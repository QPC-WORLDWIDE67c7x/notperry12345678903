/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.network.play.server.SPacketEntityVelocity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketEntityVelocity.class})
public interface ISPacketEntityVelocity {
    @Accessor(value="motionX")
    public int getMotionX();

    @Accessor(value="motionX")
    public void setMotionX(int var1);

    @Accessor(value="motionY")
    public int getMotionY();

    @Accessor(value="motionY")
    public void setMotionY(int var1);

    @Accessor(value="motionZ")
    public int getMotionZ();

    @Accessor(value="motionZ")
    public void setMotionZ(int var1);
}

