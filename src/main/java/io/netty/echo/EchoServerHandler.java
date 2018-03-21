package io.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

/**
 * Created by xlt on 20180321.
 */

/**
 ECHO服务（响应式协议)
 * @author XTL
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf)msg;
        System.out.println(in.toString(CharsetUtil.US_ASCII));

        ctx.write(msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    /*
     ChannelHandlerContext对象提供了许多操作，使你能够触发各种各样的I/O事件和操作。
     这里我们调用了write(Object)方法来逐字地把接受到的消息写入。
     请注意不同于DISCARD的例子我们并没有释放接受到的消息，这是因为当写入的时候Netty已经帮我们释放了。

     ctx.write(Object)方法不会使消息写入到通道上，他被缓冲在了内部，你需要调用ctx.flush()方法来把缓冲区中数据强行输出。
     或者你可以用更简洁的cxt.writeAndFlush(msg)以达到同样的目的。
     */
}
