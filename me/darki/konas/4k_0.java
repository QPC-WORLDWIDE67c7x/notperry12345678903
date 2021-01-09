/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.54;
import me.darki.konas.8J;
import me.darki.konas.8K;
import me.darki.konas.8L;
import me.darki.konas.8Z;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8p_0;
import me.darki.konas.8r_0;
import me.darki.konas.8u_0;
import me.darki.konas.9m;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockWeb;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.4k
 */
public class 4k_0
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("TargetRange", Float.valueOf(4.5f), Float.valueOf(16.0f), Float.valueOf(1.0f), Float.valueOf(0.1f));
    public static 8h_0<Integer> 2 = new 8h_0("ActionShift", 2, 2, 1, 1);
    public static 8h_0<Integer> 3 = new 8h_0("ActionInterval", 0, 10, 0, 1);
    public static 8h_0<Boolean> 4 = new 8h_0("Top", true);
    public static 8h_0<Boolean> 5 = new 8h_0("Self", false);
    public static 8h_0<Boolean> 6 = new 8h_0("Strict", false);
    public static 8h_0<Boolean> 7 = new 8h_0("Rotate", true);
    public static 8h_0<Boolean> 8 = new 8h_0("SwitchBack", false);
    public int 1;
    public 9m c;
    public BlockPos c;
    public int 2 = 0;
    public BlockPos 0;
    public 8K c = new 9m();
    public 8K 0;
    public 9m 0 = new 9m();

    public static boolean 3(EntityPlayer entityPlayer) {
        return ((Minecraft)4k_0.c).player.getDistance((Entity)entityPlayer) < Math.max(((Float)1.6()).floatValue() - 1.0f, 1.0f);
    }

    public static boolean c(EntityPlayer entityPlayer) {
        return entityPlayer != ((Minecraft)4k_0.c).player && entityPlayer != c.getRenderViewEntity();
    }

    public static Float 5(EntityPlayer entityPlayer) {
        return Float.valueOf(((Minecraft)4k_0.c).player.getDistance((Entity)entityPlayer));
    }

    public static boolean 6(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() > 0.0f;
    }

    public static boolean 0(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }

    @Override
    public void c() {
        if (((Minecraft)4k_0.c).player == null || ((Minecraft)4k_0.c).world == null) {
            this.d();
            return;
        }
        this.c = null;
        this.0 = null;
        this.c = null;
        this.0 = null;
        this.2 = (Integer)3.6();
    }

    public static boolean 2(EntityPlayer entityPlayer) {
        return !8J.2(entityPlayer.getUniqueID().toString());
    }

    public int c() {
        int n2 = -1;
        for (int i2 = 0; i2 < 9; ++i2) {
            Block block;
            ItemStack itemStack = 4k_0.c.player.inventory.getStackInSlot(i2);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock)itemStack.getItem()).getBlock()) instanceof BlockWeb)) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public EntityPlayer 0() {
        return 4k_0.c.world.playerEntities.stream().filter(4k_0::0).filter(4k_0::c).filter(4k_0::1).filter(4k_0::2).filter(4k_0::6).filter(4k_0::3).filter(this::4).min(Comparator.comparing(4k_0::5)).orElse((EntityPlayer)(((Boolean)5.6()).booleanValue() ? ((Minecraft)4k_0.c).player : null));
    }

    public boolean 4(EntityPlayer entityPlayer) {
        BlockPos blockPos = new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ).down();
        Block block = ((Minecraft)4k_0.c).world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockAir) && !(block instanceof BlockLiquid);
    }

    public 4k_0() {
        super("AutoWeb", 0, 3D.c, "WebAura", "AutoWebber");
    }

    @Subscriber(priority=12)
    public void c(1O o2) {
        block8: {
            if (this.c == null || this.0 == null || this.1 == -1) break block8;
            boolean bl = 4k_0.c.player.inventory.currentItem != this.1;
            int n2 = 4k_0.c.player.inventory.currentItem;
            if (bl) {
                4k_0.c.player.inventory.currentItem = this.1;
                4k_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
            }
            boolean bl2 = ((Minecraft)4k_0.c).player.isSprinting();
            boolean bl3 = 8r_0.7(this.c.3());
            if (bl2) {
                4k_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4k_0.c).player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (bl3) {
                4k_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4k_0.c).player, CPacketEntityAction.Action.START_SNEAKING));
            }
            8L.c(this.c, EnumHand.MAIN_HAND, false);
            if ((Integer)2.6() == 2 && ((Boolean)4.6()).booleanValue() && 8L.c(this.0.up(), false, false)) {
                this.c = 8L.1(this.0.up(), (Boolean)7.6(), true);
                if (this.c != null) {
                    this.c = this.0;
                    this.c.c();
                    8L.c(this.c, EnumHand.MAIN_HAND, false);
                }
            }
            if (bl3) {
                4k_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4k_0.c).player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (bl2) {
                4k_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4k_0.c).player, CPacketEntityAction.Action.START_SPRINTING));
            }
            if (bl && ((Boolean)8.6()).booleanValue()) {
                4k_0.c.player.inventory.currentItem = n2;
                4k_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
            }
        }
    }

    public static boolean 1(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block1: {
            if (((Minecraft)4k_0.c).world == null || ((Minecraft)4k_0.c).player == null) {
                return;
            }
            if (this.c == null) break block1;
            8Z.c(this.c);
        }
    }

    @Subscriber(priority=71)
    public void c(1P p2) {
        block13: {
            EntityPlayer entityPlayer;
            if (this.c != null) {
                this.0 = this.c;
                this.0.c();
            }
            this.0 = null;
            this.c = null;
            if (this.c.c(350.0)) {
                this.c = null;
            }
            if (p2.0() || !8L.c((Boolean)7.6())) {
                return;
            }
            if (3F.c(54.class).f()) {
                return;
            }
            if (!(!((Boolean)6.6()).booleanValue() || 4k_0.c.player.onGround && 4k_0.c.player.collidedVertically)) {
                return;
            }
            if (this.2 < (Integer)3.6()) {
                ++this.2;
            }
            if ((entityPlayer = this.0()) == null) {
                return;
            }
            if (this.2 < (Integer)3.6()) {
                if (this.0 != null && !this.0.c(650.0)) {
                    8k_0.c.c.c(this.0.0(), this.0.2());
                }
                return;
            }
            this.0 = new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
            int n2 = this.c();
            if (n2 == -1) {
                8p_0.c("No Webs Found!");
                this.d();
                return;
            }
            this.1 = n2;
            if (8L.c(this.0, false, false)) {
                this.c = 8L.0(this.0, (Boolean)7.6());
            } else if (((Boolean)4.6()).booleanValue() && 8L.c(this.0.up(), false, false)) {
                this.c = 8L.0(this.0.up(), (Boolean)7.6());
            }
            if (this.c == null) break block13;
            this.2 = 0;
            this.c = this.0;
            this.c.c();
        }
    }
}

