/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Timer.class})
public interface ITimer {
    @Accessor(value="tickLength")
    public float getTickLength();

    @Accessor(value="tickLength")
    public void setTickLength(float var1);
}

