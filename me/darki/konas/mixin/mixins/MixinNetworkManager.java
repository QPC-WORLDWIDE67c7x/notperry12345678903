/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import io.netty.channel.ChannelHandlerContext;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.7P;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetworkManager.class})
public class MixinNetworkManager {
    @Inject(method={"sendPacket(Lnet/minecraft/network/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendPacket(Packet<?> packet, CallbackInfo callbackInfo) {
        0T event = new 0T(packet);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            callbackInfo.cancel();
        } else if (event.c() instanceof CPacketPlayer.Rotation || event.c() instanceof CPacketPlayer.PositionRotation) {
            7P.0(((CPacketPlayer)event.c()).getYaw(0.0f));
            7P.c(((CPacketPlayer)event.c()).getPitch(0.0f));
        }
    }

    @Inject(method={"channelRead0"}, at={@At(value="HEAD")}, cancellable=true)
    private void onChannelRead(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callbackInfo) {
        0S event = new 0S(packet);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"exceptionCaught"}, at={@At(value="HEAD")}, cancellable=true)
    private void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable, CallbackInfo ci) {
        ci.cancel();
    }
}

