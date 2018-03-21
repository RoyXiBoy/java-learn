package io.netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by xlt on 20180321.
 */
/**
实现DISCARD协议，唯一需要做的就是忽略所有收到的数据。让我们从处理器的实现开始，处理器是由Netty生成用来处理I/O事件的
 * @author XTL
 */
public class DiscardServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));

       /* 低效
        try {
            while (in.isReadable()) { // (1)
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }*/

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    /*
    DisCardServerHandler 继承自 ChannelHandlerAdapter，这个类实现了ChannelHandler接口，
    ChannelHandler提供了许多事件处理的接口方法，然后你可以覆盖这些方法。现在仅仅只需要继承ChannelHandlerAdapter类而不是你自己去实现接口方法。

    这里我们覆盖了chanelRead()事件处理方法。每当从客户端收到新的数据时，这个方法会在收到消息时被调用，这个例子中，收到的消息的类型是ByteBuf
    为了实现DISCARD协议，处理器不得不忽略所有接受到的消息。
    ByteBuf是一个引用计数对象，这个对象必须显示地调用release()方法来释放。
    请记住处理器的职责是释放所有传递到处理器的引用计数对象。
     */
}
