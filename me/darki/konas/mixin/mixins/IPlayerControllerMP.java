/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={PlayerControllerMP.class})
public interface IPlayerControllerMP {
    @Accessor(value="curBlockDamageMP")
    public float getCurBlockDamageMP();

    @Accessor(value="currentBlock")
    public BlockPos getCurrentBlock();
}

