/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;

/*
 * Renamed from me.darki.konas.8z
 */
public class 8z_0 {
    public static Minecraft c = Minecraft.getMinecraft();

    public static void c(float f2, float f3) {
        block17: {
            boolean bl;
            boolean bl2;
            boolean bl3 = 8z_0.c.player.isSprinting();
            if (bl3 != ((IEntityPlayerSP)8z_0.c.player).getServerSprintState()) {
                if (bl3) {
                    8z_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)8z_0.c.player, CPacketEntityAction.Action.START_SPRINTING));
                } else {
                    8z_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)8z_0.c.player, CPacketEntityAction.Action.STOP_SPRINTING));
                }
                ((IEntityPlayerSP)8z_0.c.player).setServerSprintState(bl3);
            }
            if ((bl2 = 8z_0.c.player.isSneaking()) != ((IEntityPlayerSP)8z_0.c.player).getServerSneakState()) {
                if (bl2) {
                    8z_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)8z_0.c.player, CPacketEntityAction.Action.START_SNEAKING));
                } else {
                    8z_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)8z_0.c.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                ((IEntityPlayerSP)8z_0.c.player).setServerSneakState(bl2);
            }
            if (8z_0.c.player != c.getRenderViewEntity()) break block17;
            AxisAlignedBB axisAlignedBB = 8z_0.c.player.getEntityBoundingBox();
            double d2 = 8z_0.c.player.posX - ((IEntityPlayerSP)8z_0.c.player).getLastReportedPosX();
            double d3 = axisAlignedBB.minY - ((IEntityPlayerSP)8z_0.c.player).getLastReportedPosY();
            double d4 = 8z_0.c.player.posZ - ((IEntityPlayerSP)8z_0.c.player).getLastReportedPosZ();
            double d5 = f2 - ((IEntityPlayerSP)8z_0.c.player).getLastReportedYaw();
            double d6 = f3 - ((IEntityPlayerSP)8z_0.c.player).getLastReportedPitch();
            ((IEntityPlayerSP)8z_0.c.player).setPositionUpdateTicks(((IEntityPlayerSP)8z_0.c.player).getPositionUpdateTicks() + 1);
            boolean bl4 = d2 * d2 + d3 * d3 + d4 * d4 > 9.0E-4 || ((IEntityPlayerSP)8z_0.c.player).getPositionUpdateTicks() >= 20;
            boolean bl5 = bl = d5 != 0.0 || d6 != 0.0;
            if (8z_0.c.player.isRiding()) {
                8z_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(8z_0.c.player.motionX, -999.0, 8z_0.c.player.motionZ, f2, f3, 8z_0.c.player.onGround));
                bl4 = false;
            } else if (bl4 && bl) {
                8z_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(8z_0.c.player.posX, axisAlignedBB.minY, 8z_0.c.player.posZ, f2, f3, 8z_0.c.player.onGround));
            } else if (bl4) {
                8z_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(8z_0.c.player.posX, axisAlignedBB.minY, 8z_0.c.player.posZ, 8z_0.c.player.onGround));
            } else if (bl) {
                8z_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(f2, f3, 8z_0.c.player.onGround));
            } else if (((IEntityPlayerSP)8z_0.c.player).getPrevOnGround() != 8z_0.c.player.onGround) {
                8z_0.c.player.connection.sendPacket((Packet)new CPacketPlayer(8z_0.c.player.onGround));
            }
            if (bl4) {
                ((IEntityPlayerSP)8z_0.c.player).setLastReportedPosX(8z_0.c.player.posX);
                ((IEntityPlayerSP)8z_0.c.player).setLastReportedPosY(axisAlignedBB.minY);
                ((IEntityPlayerSP)8z_0.c.player).setLastReportedPosZ(8z_0.c.player.posZ);
                ((IEntityPlayerSP)8z_0.c.player).setPositionUpdateTicks(0);
            }
            if (bl) {
                ((IEntityPlayerSP)8z_0.c.player).setLastReportedYaw(f2);
                ((IEntityPlayerSP)8z_0.c.player).setLastReportedPitch(f3);
            }
            ((IEntityPlayerSP)8z_0.c.player).setPrevOnGround(8z_0.c.player.onGround);
            ((IEntityPlayerSP)8z_0.c.player).setAutoJumpEnabled(8z_0.c.gameSettings.autoJump);
        }
    }
}

