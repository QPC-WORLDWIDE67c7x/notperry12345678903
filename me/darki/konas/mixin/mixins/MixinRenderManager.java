/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.1i_0;
import me.darki.konas.1j_0;
import me.darki.konas.2e_0;
import me.darki.konas.8S;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderManager.class})
public class MixinRenderManager {
    @Redirect(method={"getEntityRenderObject"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/AbstractClientPlayer;getSkinType()Ljava/lang/String;"))
    public String isSlim(AbstractClientPlayer abstractClientPlayer) {
        if (Minecraft.getMinecraft().currentScreen instanceof 2e_0) {
            return 8S.0(Minecraft.getMinecraft().getSession().getProfile().getId().toString()) ? "slim" : "default";
        }
        return abstractClientPlayer.getSkinType();
    }

    @Inject(method={"renderEntity"}, at={@At(value="INVOKE")}, cancellable=true)
    public void onRenderEntityPre(Entity entityIn, double x, double y, double z, float yaw, float partialTicks, boolean p_188391_10_, CallbackInfo ci) {
        1j_0 pre = new 1j_0(entityIn, x, y, z, yaw, partialTicks);
        EventDispatcher.Companion.dispatch(pre);
        if (pre.0()) {
            ci.cancel();
        }
    }

    @Inject(method={"renderEntity"}, at={@At(value="TAIL")})
    public void onRenderEntityPost(Entity entityIn, double x, double y, double z, float yaw, float partialTicks, boolean p_188391_10_, CallbackInfo ci) {
        1i_0 post = new 1i_0(entityIn, x, y, z, yaw, partialTicks);
        EventDispatcher.Companion.dispatch(post);
    }
}

