/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.06;
import me.darki.konas.08;
import me.darki.konas.0G;
import me.darki.konas.10;
import me.darki.konas.16;
import me.darki.konas.19;
import me.darki.konas.1C;
import me.darki.konas.1D;
import me.darki.konas.Y;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={PlayerControllerMP.class})
public abstract class MixinPlayerControllerMP {
    @Shadow
    private int blockHitDelay;
    @Shadow
    private float curBlockDamageMP;
    @Shadow
    @Final
    private Minecraft mc;
    private boolean postDmg = false;

    @Shadow
    public abstract void syncCurrentPlayItem();

    @Shadow
    public abstract float getBlockReachDistance();

    @Inject(method={"onStoppedUsingItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void onStoppedUsingItemInject(EntityPlayer playerIn, CallbackInfo ci) {
        if (playerIn.equals((Object)Minecraft.getMinecraft().player)) {
            1C event = new 1C();
            EventDispatcher.Companion.dispatch(event);
            if (event.0()) {
                if (event.c()) {
                    this.syncCurrentPlayItem();
                    playerIn.stopActiveHand();
                }
                ci.cancel();
            }
        }
    }

    @Inject(method={"clickBlock"}, at={@At(value="HEAD")}, cancellable=true)
    private void clickBlock(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable<Boolean> cir) {
        0G clickEvent = new 0G((EntityPlayer)this.mc.player, posBlock, directionFacing, ForgeHooks.rayTraceEyeHitVec((EntityLivingBase)this.mc.player, (double)(this.getBlockReachDistance() + 1.0f)));
        EventDispatcher.Companion.dispatch(clickEvent);
        if (clickEvent.0()) {
            cir.setReturnValue((Object)false);
        } else {
            08 event = 08.c(posBlock, directionFacing, this.blockHitDelay, this.curBlockDamageMP);
            this.blockHitDelay = event.c();
            this.curBlockDamageMP = event.1();
            EventDispatcher.Companion.dispatch(event);
            if (event.0()) {
                cir.setReturnValue((Object)false);
                return;
            }
            this.postDmg = true;
        }
    }

    @Inject(method={"onPlayerDamageBlock(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPlayerDamageBlock(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable<Boolean> cir) {
        08 event = 08.c(posBlock, directionFacing, this.blockHitDelay, this.curBlockDamageMP);
        EventDispatcher.Companion.dispatch(event);
        this.blockHitDelay = event.c();
        this.curBlockDamageMP = event.1();
        if (event.0()) {
            cir.setReturnValue((Object)false);
            return;
        }
        this.postDmg = true;
    }

    @Inject(method={"clickBlock"}, at={@At(value="RETURN")})
    private void clickBlockPost(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable<Boolean> cir) {
        if (this.postDmg) {
            16 event = new 16();
            EventDispatcher.Companion.dispatch(event);
        }
    }

    @Inject(method={"onPlayerDamageBlock(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)Z"}, at={@At(value="RETURN")})
    private void onPlayerDamageBlockPost(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable<Boolean> cir) {
        if (this.postDmg) {
            16 event = new 16();
            EventDispatcher.Companion.dispatch(event);
        }
    }

    @Inject(method={"getBlockReachDistance"}, at={@At(value="RETURN")}, cancellable=true)
    private void onGetBlockReachDistance(CallbackInfoReturnable<Float> cir) {
        Y event = Y.0(((Float)cir.getReturnValue()).floatValue());
        EventDispatcher.Companion.dispatch(event);
        cir.setReturnValue((Object)Float.valueOf(event.c()));
    }

    @Inject(method={"windowClick"}, at={@At(value="RETURN")})
    private void onWindowClick(int windowId, int slotId, int mouseButton, ClickType type, EntityPlayer player, CallbackInfoReturnable<ItemStack> cir) {
        06 event = new 06();
        EventDispatcher.Companion.dispatch(event);
    }

    @Inject(method={"syncCurrentPlayItem"}, at={@At(value="FIELD", target="Lnet/minecraft/client/multiplayer/PlayerControllerMP;connection:Lnet/minecraft/client/network/NetHandlerPlayClient;")})
    private void onSyncPlayerItemSendPacket(CallbackInfo ci) {
        1D event = new 1D();
        EventDispatcher.Companion.dispatch(event);
    }

    @Inject(method={"onPlayerDestroyBlock"}, at={@At(value="INVOKE", target="net/minecraft/block/Block.removedByPlayer(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/player/EntityPlayer;Z)Z")}, cancellable=true)
    private void onPlayerDestroyBlock(BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        10 event = new 10(blockPos);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            cir.setReturnValue((Object)false);
        }
    }

    @Inject(method={"processRightClickBlock"}, at={@At(value="HEAD")})
    public void rightClickBlock(EntityPlayerSP player, WorldClient worldIn, BlockPos pos, EnumFacing direction, Vec3d vec, EnumHand hand, CallbackInfoReturnable<EnumActionResult> cir) {
        19 event = new 19(player, worldIn, pos, direction, vec, hand);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            event.c(true);
        }
    }
}

