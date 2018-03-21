package io.netty.time;

/**
 * Created by xlt on 20180321.
 */

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * TIME协议。
 * 和之前的例子不同的是在不接受任何请求时他会发送一个含32位的整数的消息，并且一旦消息发送就会立即关闭连接。
 * 在这个例子中，学习到如何构建和发送一个消息，然后在完成时主动关闭连接。
 */
public class timeServerHandler extends ChannelHandlerAdapter{
    //将会忽略任何接收到的数据，而只是在连接被创建发送一个消息，所以这次我们不能使用channelRead()方法了，代替他的是，我们需要覆盖channelActive()方法


    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        final ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(time);

        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
