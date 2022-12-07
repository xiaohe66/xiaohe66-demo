package com.xiaohe66.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohe
 * @since 2022.12.06 16:54
 */
@Slf4j
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {

        ByteBuf time = ctx.alloc().buffer(4);

        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        // (3)
        final ChannelFuture f = ctx.writeAndFlush(time);

        // (4)
        f.addListener((ChannelFutureListener) future -> {
            assert f == future;
            ctx.close();
        });

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        ctx.close();
    }
}
