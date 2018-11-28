package io.nio.Channels;

/**
 * Created by xlt on 20180319.
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**

    FileChannel
    DatagramChannel
    SocketChannel
    ServerSocketChannel

FileChannel 从文件中读写数据。

DatagramChannel 能通过UDP读写网络中的数据。

SocketChannel 能通过TCP读写网络中的数据。

ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

 */
public class ChannelLearn {

    public static void fileChannelLearn(){
        String url = "C:\\Users\\XTL\\Desktop\\演示环境访问地址.txt";

        try(RandomAccessFile aFile = new RandomAccessFile(url, "rw")){
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {

                //System.out.println("Read " + bytesRead);
                buf.flip();

                while(buf.hasRemaining()){
                    System.out.print((char) buf.get());
                }

                buf.clear();
                bytesRead = inChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        fileChannelLearn();
    }
}
