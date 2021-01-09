/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={World.class})
public interface IWorld {
    @Accessor(value="rainingStrength")
    public float getRainingStrength();

    @Accessor(value="thunderingStrength")
    public float getThunderingStrength();
}

