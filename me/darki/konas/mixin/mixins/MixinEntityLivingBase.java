/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0f_0;
import me.darki.konas.0x_0;
import me.darki.konas.mixin.mixins.MixinEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityLivingBase.class}, priority=0x7FFFFFFF)
public abstract class MixinEntityLivingBase
extends MixinEntity {
    @Inject(method={"travel"}, at={@At(value="HEAD")}, cancellable=true)
    public void onTravel(float strafe, float vertical, float forward, CallbackInfo ci) {
        0f_0 event = 0f_0.c((Entity)((EntityLivingBase)this));
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @Inject(method={"handleJumpWater"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleJumpWater(CallbackInfo ci) {
        0x_0 event = new 0x_0();
        if (event.0()) {
            ci.cancel();
        }
    }

    @Inject(method={"handleJumpLava"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleJumpLava(CallbackInfo ci) {
        0x_0 event = new 0x_0();
        if (event.0()) {
            ci.cancel();
        }
    }
}

