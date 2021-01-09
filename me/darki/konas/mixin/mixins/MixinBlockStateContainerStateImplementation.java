/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import java.util.List;
import javax.annotation.Nullable;
import me.darki.konas.V;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={BlockStateContainer.StateImplementation.class}, priority=0x7FFFFFFF)
public class MixinBlockStateContainerStateImplementation {
    @Shadow
    @Final
    private Block block;

    @Redirect(method={"addCollisionBoxToList"}, at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;addCollisionBoxToList(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;Z)V"))
    public void addCollisionBoxToList(Block blk, IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        V event = V.c(blk, state, worldIn, pos, entityBox, collidingBoxes, entityIn, isActualState);
        EventDispatcher.Companion.dispatch(event);
        if (!event.0()) {
            this.block.addCollisionBoxToList(event.6(), event.c(), event.4(), event.3(), event.1(), event.0(), event.5());
        }
    }
}

