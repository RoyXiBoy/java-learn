package io.nio.Selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by xlt on 20180319.
 * 使用Selector能够处理多个通道
 *
  选择器（Selector)

 Selector选择器类管理着一个被注册的通道集合的信息和它们的就绪状态。通道是和选择器一起被注册的，并且使用选择器来更新通道的就绪状态。当这么做的时候，可以选择将被激发的线程挂起，直到有就绪的的通道。


 可选择通道(SelectableChannel)

 SelectableChannel这个抽象类提供了实现通道的可选择性所需要的公共方法。它是所有支持就绪检查的通道类的父类。
 因为FileChannel类没有继承SelectableChannel因此是不是可选通道，
 而所有socket通道都是可选择的，包括从管道(Pipe)对象的中获得的通道。
 SelectableChannel可以被注册到Selector对象上，同时可以指定对那个选择器而言，那种操作是感兴趣的。
 一个通道可以被注册到多个选择器上，但对每个选择器而言只能被注册一次。


 选择键(SelectionKey)

 选择键封装了特定的通道与特定的选择器的注册关系。
 选择键对象被SelectableChannel.register()返回并提供一个表示这种注册关系的标记。
 选择键包含了两个比特集(以整数的形式进行编码)，指示了该注册关系所关心的通道操作，以及通道已经准备好的操作。

 */
public class SelectorServer {

    // 通道管理器
    private Selector selector;

    public void initServer(int port) throws Exception {
        // 获得一个ServerSocket通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        // 设置通道为 非阻塞
        serverChannel.configureBlocking(false);

        //将该通道对于的serverSocket绑定到port端口
        serverChannel.socket().bind(new InetSocketAddress(port));

        // 获得一通道管理器
        this.selector = Selector.open();

        // 将通道管理器和该通道绑定，并为该通道注册selectionKey.OP_ACCEPT事件
        // 注册该事件后，当事件到达的时候，selector.select()会返回，
        // 如果事件没有到达selector.select()会一直阻塞
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    // 采用轮训的方式监听selector上是否有需要处理的事件，如果有，进行处理
    public void listen() throws Exception {
        System.out.println("start server");
        // 轮询访问selector

        while (true) {
            // 当注册事件到达时，方法返回，否则该方法会一直阻塞
            selector.select();

            // 获得selector中选中的相的迭代器，选中的相为注册的事件
            Iterator ite = this.selector.selectedKeys().iterator();

            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                // 删除已选的key 以防重负处理
                ite.remove();

                // 客户端请求连接事件
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    // 获得和客户端连接的通道
                    SocketChannel channel = server.accept();
                    // 设置成非阻塞
                    channel.configureBlocking(false);
                    // 在这里可以发送消息给客户端
                    channel.write(ByteBuffer.wrap(new String("hello client").getBytes()));
                    // 在客户端 连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限
                    channel.register(this.selector, SelectionKey.OP_READ);
                    // 获得了可读的事件

                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    // 处理 读取客户端发来的信息事件
    private void read(SelectionKey key) throws Exception {
        // 服务器可读消息，得到事件发生的socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 穿件读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("server receive from client: " + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }


    public static void main(String[] args) throws Exception {
        SelectorServer selectorServer = new SelectorServer();
        selectorServer.initServer(60001);
        selectorServer.listen();
    }

}
