package com.xiaohe66.demo.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohe
 * @since 2022.12.06 16:54
 */
@Slf4j
public class DiscardServerReadHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;

        // 读取数据
        try {
            while (buf.isReadable()) {
                char c = (char) buf.readByte();
                System.out.print(c);
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();

        ctx.close();
    }
}
