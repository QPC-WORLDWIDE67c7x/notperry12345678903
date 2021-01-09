/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.block.BlockSlab;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={BlockSlab.class})
public interface IBlockSlab {
    @Accessor(value="AABB_BOTTOM_HALF")
    public AxisAlignedBB getAABBBOTTOMHALF();

    @Accessor(value="AABB_TOP_HALF")
    public AxisAlignedBB getAABBTOPHALF();
}

