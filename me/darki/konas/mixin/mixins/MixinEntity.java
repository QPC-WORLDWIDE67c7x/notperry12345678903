/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0h_0;
import me.darki.konas.0i_0;
import me.darki.konas.1I;
import me.darki.konas.1S;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Entity.class}, priority=0x7FFFFFFF)
public abstract class MixinEntity {
    @Shadow
    private int entityId;
    @Shadow
    protected boolean isInWeb;
    @Shadow
    public double motionX;
    @Shadow
    public double motionY;
    @Shadow
    public double motionZ;

    @Shadow
    public void move(MoverType type, double x, double y, double z) {
    }

    @Shadow
    public abstract boolean equals(Object var1);

    @Shadow
    public abstract int getEntityId();

    @ModifyVariable(method={"addVelocity"}, at=@At(value="HEAD"), ordinal=0)
    private double modifyVariable1(double x) {
        0i_0 event = 0i_0.c((Entity)this, x, 0h_0.c);
        EventDispatcher.Companion.dispatch(event);
        return event.0();
    }

    @ModifyVariable(method={"addVelocity"}, at=@At(value="HEAD"), ordinal=1)
    private double modifyVariable2(double y) {
        0i_0 event = 0i_0.c((Entity)this, y, 0h_0.0);
        EventDispatcher.Companion.dispatch(event);
        return event.0();
    }

    @ModifyVariable(method={"addVelocity"}, at=@At(value="HEAD"), ordinal=2)
    private double modifyVariable3(double z) {
        0i_0 event = 0i_0.c((Entity)this, z, 0h_0.c);
        EventDispatcher.Companion.dispatch(event);
        return event.0();
    }

    @Inject(method={"move"}, at={@At(value="HEAD")})
    public void injectWebEvent(MoverType type, double x, double y, double z, CallbackInfo ci) {
        if (this.isInWeb) {
            1S event = new 1S();
            EventDispatcher.Companion.dispatch(event);
            if (event.0()) {
                this.isInWeb = false;
            }
        }
    }

    @Inject(method={"turn"}, at={@At(value="HEAD")}, cancellable=true)
    public void onTurn(float yaw, float pitch, CallbackInfo ci) {
        1I event = new 1I(yaw, pitch);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }
}

