/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import com.mojang.authlib.GameProfile;
import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.02;
import me.darki.konas.0O;
import me.darki.konas.0a_0;
import me.darki.konas.0o_0;
import me.darki.konas.11;
import me.darki.konas.14;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.2l_0;
import me.darki.konas.5V;
import me.darki.konas.8k_0;
import me.darki.konas.8z_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityPlayerSP.class}, priority=0x7FFFFFFF)
public abstract class MixinEntityPlayerSP
extends EntityPlayer {
    @Shadow
    protected Minecraft mc;
    @Shadow
    @Final
    public NetHandlerPlayClient connection;
    @Shadow
    public MovementInput movementInput;

    public MixinEntityPlayerSP(World worldIn, GameProfile gameProfileIn) {
        super(worldIn, gameProfileIn);
    }

    @Inject(method={"move"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/entity/AbstractClientPlayer;move(Lnet/minecraft/entity/MoverType;DDD)V")}, cancellable=true)
    public void moveInject(MoverType type, double x, double y, double z, CallbackInfo ci) {
        ci.cancel();
        11 event = 11.c(type, x, y, z);
        EventDispatcher.Companion.dispatch(event);
        if (!event.0()) {
            super.move(event.c(), event.2(), event.0(), event.1());
        }
    }

    @Inject(method={"onUpdate"}, at={@At(value="HEAD")})
    public void onPlayerUpdate(CallbackInfo info) {
        14 playerUpdateEvent = new 14();
        EventDispatcher.Companion.dispatch(playerUpdateEvent);
    }

    @Inject(method={"onUpdateWalkingPlayer"}, at={@At(value="TAIL")})
    public void onUpdateWalkingPlayerPost(CallbackInfo ci) {
        1O postEvent = 1O.c(this.mc.player.posX, this.mc.player.posY, this.mc.player.posY, this.mc.player.rotationYaw, this.mc.player.rotationPitch, this.mc.player.onGround);
        EventDispatcher.Companion.dispatch(postEvent);
    }

    @Redirect(method={"onUpdate"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/AbstractClientPlayer;onUpdate()V"))
    public void redirectUpdateSuper(AbstractClientPlayer abstractClientPlayer) {
    }

    @Inject(method={"onUpdate"}, at={@At(value="HEAD")}, cancellable=true)
    public void redirectUpdateWalking(CallbackInfo ci) {
        if (this.world.isBlockLoaded(new BlockPos(this.posX, 0.0, this.posZ))) {
            super.onUpdate();
            1P event = 1P.c(this.mc.player.posX, this.mc.player.getEntityBoundingBox().minY, this.mc.player.posY, this.mc.player.rotationYaw, this.mc.player.rotationPitch, this.mc.player.onGround);
            5V.1 = true;
            EventDispatcher.Companion.dispatch(event);
            if (8k_0.c.c.c()) {
                ci.cancel();
                5V.c.c();
                if (this.isRiding()) {
                    this.connection.sendPacket((Packet)new CPacketPlayer.Rotation(8k_0.c.c.1(), 8k_0.c.c.0(), this.onGround));
                    this.connection.sendPacket((Packet)new CPacketInput(this.moveStrafing, this.moveForward, this.movementInput.jump, this.movementInput.sneak));
                    Entity entity = this.getLowestRidingEntity();
                    if (entity != this && entity.canPassengerSteer()) {
                        this.connection.sendPacket((Packet)new CPacketVehicleMove(entity));
                    }
                } else {
                    8z_0.c(8k_0.c.c.1(), 8k_0.c.c.0());
                }
                1O postEvent = 1O.c(this.mc.player.posX, this.mc.player.posY, this.mc.player.posY, this.mc.player.rotationYaw, this.mc.player.rotationPitch, this.mc.player.onGround);
                EventDispatcher.Companion.dispatch(postEvent);
            } else {
                5V.1 = false;
            }
        }
        8k_0.c.c.2();
    }

    @Inject(method={"displayGUIChest"}, at={@At(value="HEAD")}, cancellable=true)
    public void onDisplayGUIChest(IInventory chestInventory, CallbackInfo ci) {
        if (chestInventory instanceof IInteractionObject && "minecraft:beacon".equals(((IInteractionObject)chestInventory).getGuiID())) {
            0O event = new 0O();
            EventDispatcher.Companion.dispatch(event);
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new 2l_0(this.inventory, chestInventory));
            if (event.0()) {
                ci.cancel();
            }
        }
    }

    @Inject(method={"dismountRidingEntity"}, at={@At(value="HEAD")}, cancellable=true)
    public void onDismountRidingEntity(CallbackInfo ci) {
        0a_0 event = 0a_0.c();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @Inject(method={"sendChatMessage"}, at={@At(value="HEAD")}, cancellable=true)
    public void onSendChatMessage(String message, CallbackInfo ci) {
        ci.cancel();
        02 event = new 02(message);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            return;
        }
        this.connection.sendPacket((Packet)new CPacketChatMessage(event.c()));
    }

    @Redirect(method={"onUpdateWalkingPlayer"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isCurrentViewEntity()Z"))
    private boolean redirectIsCurrentViewEntity(EntityPlayerSP entityPlayerSP) {
        Minecraft mc = Minecraft.getMinecraft();
        0o_0 event = new 0o_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            return entityPlayerSP == mc.player;
        }
        return mc.getRenderViewEntity() == entityPlayerSP;
    }

    @Redirect(method={"updateEntityActionState"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isCurrentViewEntity()Z"))
    private boolean redirectIsCurrentViewEntity2(EntityPlayerSP entityPlayerSP) {
        Minecraft mc = Minecraft.getMinecraft();
        0o_0 event = new 0o_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            return entityPlayerSP == mc.player;
        }
        return mc.getRenderViewEntity() == entityPlayerSP;
    }
}

