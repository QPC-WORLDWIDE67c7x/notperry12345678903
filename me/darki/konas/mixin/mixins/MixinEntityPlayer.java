/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.12;
import me.darki.konas.13;
import me.darki.konas.1R;
import me.darki.konas.mixin.mixins.MixinEntityLivingBase;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={EntityPlayer.class})
public abstract class MixinEntityPlayer
extends MixinEntityLivingBase {
    @Inject(method={"travel"}, at={@At(value="HEAD")}, cancellable=true)
    public void travel(float strafe, float vertical, float forward, CallbackInfo info) {
        if (this.equals(Minecraft.getMinecraft().player)) {
            13 event = new 13(strafe, vertical, forward);
            EventDispatcher.Companion.dispatch(event);
            if (event.0()) {
                this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                info.cancel();
            }
        }
    }

    @Inject(method={"isPushedByWater()Z"}, at={@At(value="HEAD")}, cancellable=true)
    public void isPushedByWater(CallbackInfoReturnable<Boolean> info) {
        12 event = new 12();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            info.cancel();
        }
    }

    @ModifyArgs(method={"travel"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/EntityLivingBase;travel(FFF)V"))
    public void onTravel(Args args) {
        1R event = new 1R(this.getEntityId(), ((Float)args.get(0)).floatValue(), ((Float)args.get(1)).floatValue(), ((Float)args.get(2)).floatValue());
        EventDispatcher.Companion.dispatch(event);
        args.set(0, (Object)Float.valueOf(event.0()));
        args.set(1, (Object)Float.valueOf(event.c()));
        args.set(2, (Object)Float.valueOf(event.2()));
    }
}

