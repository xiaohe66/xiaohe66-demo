package com.xiaohe66.demo.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohe
 * @since 2022.12.06 16:54
 */
@Slf4j
public class DiscardServerRewriteHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // 回显（将输入直接返回给客户端）
        ctx.write(msg);
        ctx.flush();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();

        ctx.close();
    }
}
