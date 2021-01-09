/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.LinkedList;
import java.util.Queue;
import me.darki.konas.0T;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.4o_0;
import me.darki.konas.4p_0;
import me.darki.konas.8h_0;
import net.minecraft.block.BlockWeb;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.4q
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 4q_0
extends 3E {
    public 8h_0<4p_0> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Boolean> 3;
    public 8h_0<Integer> 4;
    public 8h_0<Integer> 5;
    public 8h_0<Boolean> 6;
    public Queue<CPacketUseEntity> c;
    public CPacketUseEntity c;
    public CPacketAnimation c = null;
    public int 1 = 0;
    public int 2 = 0;

    @Override
    public String 0() {
        return ((4p_0)((Object)this.1.6())).toString().charAt(0) + ((4p_0)((Object)this.1.6())).toString().substring(1).toLowerCase();
    }

    public 4q_0() {
        super("Criticals", 0, 3D.c, "Crits", "AlwaysCrit");
        this.3 = new 8h_0("Vehicles", false);
        this.4 = new 8h_0("Hits", 3, 15, 0, 1).c(this.3::6);
        this.5 = new 8h_0("Delay", 1, 10, 1, 1);
        this.6 = new 8h_0("OnlyWhenKA", true);
        this.c = new LinkedList<CPacketUseEntity>();
    }

    @Subscriber
    public void c(0T t) {
        if (((Minecraft)4q_0.c).player == null || ((Minecraft)4q_0.c).world == null) {
            return;
        }
        if (!3F.c("KillAura").f() && ((Boolean)this.6.6()).booleanValue()) {
            return;
        }
        if ((this.1.6() == 4p_0.1 || this.1.6() == 4p_0.2) && this.c != null && this.c != null) {
            return;
        }
        if (t.c() instanceof CPacketUseEntity && ((CPacketUseEntity)t.c()).getAction() == CPacketUseEntity.Action.ATTACK && 4q_0.c.player.onGround && 4q_0.c.player.collidedVertically && !((Minecraft)4q_0.c).player.isInLava() && !((Minecraft)4q_0.c).player.isInWater()) {
            Entity entity = ((CPacketUseEntity)t.c()).getEntityFromWorld((World)((Minecraft)4q_0.c).world);
            if (entity instanceof EntityEnderCrystal || entity == null) {
                return;
            }
            if (entity instanceof EntityMinecart || entity instanceof EntityBoat) {
                if (((Boolean)this.3.6()).booleanValue()) {
                    if (this.1 > 0) {
                        --this.1;
                        return;
                    }
                    this.1 = (Integer)this.4.6();
                    for (int i2 = 0; i2 < (Integer)this.4.6(); ++i2) {
                        this.c.add(new CPacketUseEntity(entity));
                    }
                    return;
                }
            }
            switch (4o_0.c[((4p_0)((Object)this.1.6())).ordinal()]) {
                case 1: {
                    4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY + 0.0625101, 4q_0.c.player.posZ, false));
                    4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY, 4q_0.c.player.posZ, false));
                    4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY + 0.0125, 4q_0.c.player.posZ, false));
                    4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY, 4q_0.c.player.posZ, false));
                    break;
                }
                case 2: {
                    if (((Boolean)this.2.6()).booleanValue() && ((Minecraft)4q_0.c).world.getBlockState(new BlockPos((Entity)((Minecraft)4q_0.c).player)).getBlock() instanceof BlockWeb) {
                        4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY + 0.0625101, 4q_0.c.player.posZ, false));
                        4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY, 4q_0.c.player.posZ, false));
                        4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY + 0.0125, 4q_0.c.player.posZ, false));
                        4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY, 4q_0.c.player.posZ, false));
                        break;
                    }
                    4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY + 0.11, 4q_0.c.player.posZ, false));
                    4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY + 0.1100013579, 4q_0.c.player.posZ, false));
                    4q_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(4q_0.c.player.posX, 4q_0.c.player.posY + 1.3579E-6, 4q_0.c.player.posZ, false));
                    break;
                }
                case 3: {
                    if (this.c != null) break;
                    ((Minecraft)4q_0.c).player.jump();
                    this.c = (CPacketUseEntity)t.c();
                    t.c(true);
                    break;
                }
                case 4: {
                    if (this.c != null) break;
                    ((Minecraft)4q_0.c).player.jump();
                    4q_0.c.player.motionY = 0.25;
                    this.c = (CPacketUseEntity)t.c();
                    t.c(true);
                    break;
                }
            }
        } else if (t.c() instanceof CPacketAnimation && 4q_0.c.player.onGround) {
            if (4q_0.c.player.collidedVertically && !((Minecraft)4q_0.c).player.isInLava() && !((Minecraft)4q_0.c).player.isInWater() && this.c != null && this.c == null) {
                this.c = (CPacketAnimation)t.c();
            }
        }
    }

    @Override
    public boolean 5() {
        return this.1.6() == 4p_0.0;
    }

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)4q_0.c).player == null || ((Minecraft)4q_0.c).world == null) {
            return;
        }
        if (n2.c() == TickEvent.Phase.START) {
            if (!this.c.isEmpty() && this.2 % (Integer)this.5.6() == 0) {
                4q_0.c.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
                4q_0.c.player.connection.sendPacket((Packet)this.c.poll());
            }
            ++this.2;
        }
        if (4q_0.c.player.motionY < 0.0 && this.c != null && this.c != null && (this.1.6() == 4p_0.1 || this.1.6() == 4p_0.2)) {
            4q_0.c.player.connection.sendPacket((Packet)this.c);
            4q_0.c.player.connection.sendPacket((Packet)this.c);
            this.c = null;
            this.c = null;
        }
    }

    @Override
    public void c() {
        this.c = null;
        this.c = null;
    }
}

