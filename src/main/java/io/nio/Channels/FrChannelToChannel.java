package io.nio.Channels;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by xlt on 20180319.
 *
 *
  如果两个通道中有一个是FileChannel，那你可以直接将数据从一个channel（译者注：channel中文常译作通道）传输到另外一个channel。

 transferFrom()

 FileChannel的transferFrom()方法可以将数据从源通道传输到FileChannel中

 transferTo()

 transferTo()方法将数据从FileChannel传输到其他的channel中。下面是一个简单的例子：
 */
public class FrChannelToChannel {

    public void fileCopy(){
        String fromFileUrl = "";
        String toFileUrl = "";

        try(RandomAccessFile fromFile = new RandomAccessFile(fromFileUrl,"rw");
            RandomAccessFile toFile = new RandomAccessFile(toFileUrl,"rw")){

            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            //最多传输字节数（肯定是from的字节）
            long count = fromChannel.size();

            toChannel.transferFrom(fromChannel, position, count);
            fromChannel.transferTo(position, count, toChannel);

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
