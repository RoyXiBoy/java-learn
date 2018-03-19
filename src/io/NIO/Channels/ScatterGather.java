package io.NIO.Channels;

/**
 * Created by xlt on 20180319.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.MembershipKey;
import java.util.Set;

/**
 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。
 因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。

 聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，
 因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。

 scatter / gather经常用于需要将传输的数据分开处理的场合，
 例如传输一个由消息头和消息体组成的消息，你可能会将消息体和消息头分散到不同的buffer中，
 这样你可以方便的处理消息头和消息体。

 */
public class ScatterGather {

    private String fileUrl = "C:\\Users\\XTL\\Desktop\\演示环境访问地址.txt";

    public  void  scatter() throws IOException {

        RandomAccessFile file = new RandomAccessFile(fileUrl,"rw");
        FileChannel channel = file.getChannel();

        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = { header, body };

        System.out.println(channel.read(bufferArray));
    }

    public void  gather() throws IOException {
        RandomAccessFile file = new RandomAccessFile(fileUrl,"rw");
        FileChannel channel = file.getChannel();

        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = { header, body };

        System.out.println(channel.write(bufferArray));
    }


    public static void main(String[] args) throws IOException {
        ScatterGather scatterGather = new ScatterGather();
        scatterGather.gather();
        scatterGather.scatter();

    }

}
