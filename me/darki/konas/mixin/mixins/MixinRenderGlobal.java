/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.04;
import me.darki.konas.0k_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={RenderGlobal.class})
public class MixinRenderGlobal {
    @Redirect(method={"renderSky(FI)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/WorldClient;getSkyColor(Lnet/minecraft/entity/Entity;F)Lnet/minecraft/util/math/Vec3d;"))
    public Vec3d getSkyColorRedirect(WorldClient worldClient, Entity entityIn, float partialTicks) {
        Vec3d sky = Minecraft.getMinecraft().world.getSkyColor(entityIn, partialTicks);
        0k_0 event = new 0k_0((float)sky.x, (float)sky.y, (float)sky.z);
        EventDispatcher.Companion.dispatch(event);
        return new Vec3d((double)event.1(), (double)event.0(), (double)event.c());
    }

    @ModifyVariable(method={"setupTerrain"}, at=@At(value="HEAD"))
    private boolean setupTerrain(boolean playerSpectator) {
        04 event = 04.c();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            return true;
        }
        return playerSpectator;
    }
}

