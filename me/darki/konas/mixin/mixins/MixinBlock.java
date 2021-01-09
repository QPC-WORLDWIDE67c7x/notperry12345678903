/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import java.util.List;
import javax.annotation.Nullable;
import me.darki.konas.07;
import me.darki.konas.3F;
import me.darki.konas.85;
import me.darki.konas.88;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Block.class}, priority=0x7FFFFFFF)
public class MixinBlock {
    private 07 bbEvent;

    @Inject(method={"addCollisionBoxToList(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;Z)V"}, at={@At(value="HEAD")})
    private void in(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState, CallbackInfo ci) {
        07 event;
        if (Minecraft.getMinecraft().player == null || entity == null || world == null || entityBox == null) {
            return;
        }
        Block block = (Block)this;
        this.bbEvent = event = 07.c(block, pos, block.getCollisionBoundingBox(state, (IBlockAccess)world, pos), collidingBoxes, entity);
        EventDispatcher.Companion.dispatch(event);
    }

    @Redirect(method={"addCollisionBoxToList(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;Z)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;addCollisionBoxToList(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/util/math/AxisAlignedBB;)V"))
    private void addCollisionBoxToList(BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable AxisAlignedBB rawBlockBox) {
        AxisAlignedBB axisalignedbb;
        AxisAlignedBB blockBox = this.bbEvent == null ? rawBlockBox : this.bbEvent.3();
        this.bbEvent = null;
        if (blockBox != null && blockBox != Block.NULL_AABB && entityBox.intersects(axisalignedbb = blockBox.offset(pos))) {
            collidingBoxes.add(axisalignedbb);
        }
    }

    @Inject(method={"isFullCube"}, at={@At(value="HEAD")}, cancellable=true)
    public void isFullCubeHook(IBlockState blockState, CallbackInfoReturnable<Boolean> info) {
        if (3F.c(85.class) == null) {
            return;
        }
        if (3F.c(85.class).f()) {
            info.setReturnValue((Object)((88)85.1.6()).0().contains((Block)Block.class.cast(this)));
            info.cancel();
        }
    }
}

