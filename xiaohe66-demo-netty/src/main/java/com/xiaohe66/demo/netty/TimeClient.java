package com.xiaohe66.demo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohe
 * @since 2022.12.06 17:15
 */
@Slf4j
public class TimeClient {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 8088;

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // (1)
            Bootstrap b = new Bootstrap();
            // (2)
            b.group(workerGroup);
            // (3)
            b.channel(NioSocketChannel.class);
            // (4)
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });

            // Start the client.
            // (5)
            ChannelFuture f = b.connect(host, port).sync();

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("interrupt", e);
            Thread.currentThread().interrupt();

        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
