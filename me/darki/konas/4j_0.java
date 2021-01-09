/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.4E;
import me.darki.konas.4c_0;
import me.darki.konas.54;
import me.darki.konas.8E;
import me.darki.konas.8J;
import me.darki.konas.8K;
import me.darki.konas.8L;
import me.darki.konas.8Z;
import me.darki.konas.8h_0;
import me.darki.konas.8j_0;
import me.darki.konas.8k_0;
import me.darki.konas.8p_0;
import me.darki.konas.8r_0;
import me.darki.konas.8u_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockObsidian;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.4j
 */
public class 4j_0
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("TargetRange", Float.valueOf(4.5f), Float.valueOf(16.0f), Float.valueOf(1.0f), Float.valueOf(0.1f));
    public static 8h_0<Integer> 2 = new 8h_0("ActionShift", 3, 8, 1, 1);
    public static 8h_0<Integer> 3 = new 8h_0("ActionInterval", 0, 10, 0, 1);
    public static 8h_0<Boolean> 4 = new 8h_0("Top", true);
    public static 8h_0<Boolean> 5 = new 8h_0("Piston", false);
    public static 8h_0<8j_0> 6 = new 8h_0("Self", new 8j_0(0));
    public static 8h_0<Boolean> 7 = new 8h_0("Strict", false);
    public static 8h_0<Boolean> 8 = new 8h_0("Rotate", true);
    public static 8h_0<Boolean> 9 = new 8h_0("DisableWhenDone", false);
    public static 8h_0<Boolean> a = new 8h_0("LogoutSpots", false);
    public int 1;
    public 9m c;
    public BlockPos c;
    public int 2 = 0;
    public BlockPos 0;
    public 8K c = new 9m();
    public 8K 0;
    public 9m 0 = new 9m();
    public static ConcurrentHashMap<BlockPos, Long> c;

    public int c() {
        int n2 = -1;
        for (int i2 = 0; i2 < 9; ++i2) {
            Block block;
            ItemStack itemStack = 4j_0.c.player.inventory.getStackInSlot(i2);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock)itemStack.getItem()).getBlock()) instanceof BlockObsidian)) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block1: {
            if (((Minecraft)4j_0.c).world == null || ((Minecraft)4j_0.c).player == null) {
                return;
            }
            if (this.c == null || this.c.c(500.0)) break block1;
            8Z.c(this.c);
        }
    }

    public boolean 1(EntityPlayer entityPlayer) {
        BlockPos blockPos = new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ).down();
        Block block = ((Minecraft)4j_0.c).world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockAir) && !(block instanceof BlockLiquid);
    }

    @Override
    public void c() {
        if (((Minecraft)4j_0.c).player == null || ((Minecraft)4j_0.c).world == null) {
            this.d();
            return;
        }
        this.c = null;
        this.0 = null;
        this.c = null;
        this.0 = null;
        this.2 = (Integer)3.6();
    }

    @Subscriber(priority=70)
    public void c(1P p2) {
        int n2;
        if (this.c != null) {
            this.0 = this.c;
            this.0.c();
        }
        this.c = null;
        this.0 = null;
        int n3 = 8E.0();
        ((ConcurrentHashMap)((Object)c)).forEach((arg_0, arg_1) -> 4j_0.c(n3, arg_0, arg_1));
        if (p2.0() || !8L.c((Boolean)8.6())) {
            return;
        }
        if (!(!((Boolean)7.6()).booleanValue() || 4j_0.c.player.onGround && 4j_0.c.player.collidedVertically)) {
            return;
        }
        if (3F.c(54.class).f()) {
            return;
        }
        if (this.2 < (Integer)3.6()) {
            ++this.2;
        }
        if ((n2 = this.c()) == -1) {
            8p_0.c("No Obby Found!");
            this.d();
            return;
        }
        this.1 = n2;
        EntityPlayer entityPlayer = this.0();
        if (entityPlayer == null) {
            return;
        }
        if (this.2 < (Integer)3.6()) {
            if (this.0 != null && !this.0.c(650.0)) {
                8k_0.c.c.c(this.0.0(), this.0.2());
            }
            return;
        }
        this.0 = new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
        BlockPos blockPos = this.c(this.0);
        if (blockPos != null) {
            this.c = 8L.0(blockPos, (Boolean)8.6());
            if (this.c != null) {
                ((ConcurrentHashMap)((Object)c)).put(blockPos, System.currentTimeMillis());
                this.2 = 0;
                this.c = blockPos;
                this.c.c();
            }
        } else if (((Boolean)9.6()).booleanValue()) {
            this.d();
            return;
        }
    }

    public boolean c(BlockPos blockPos, EnumFacing enumFacing) {
        block3: {
            4E e2;
            block2: {
                e2 = (4E)3F.c(4E.class);
                if (e2.c == null) break block2;
                if (e2.c.equals((Object)enumFacing)) {
                    return false;
                }
                break block3;
            }
            e2.2(blockPos);
            if (e2.c == null) break block3;
            if (e2.c.equals((Object)enumFacing)) {
                this.c(e2);
                return false;
            }
            this.c(e2);
        }
        return true;
    }

    public static Float c(EntityPlayer entityPlayer) {
        return Float.valueOf(((Minecraft)4j_0.c).player.getDistance((Entity)entityPlayer));
    }

    public EntityPlayer 0() {
        4c_0 c_02 = (4c_0)3F.c(4c_0.class);
        Stream stream = 4j_0.c.world.playerEntities.stream();
        if (((Boolean)a.6()).booleanValue()) {
            stream = Stream.concat(4j_0.c.world.playerEntities.stream(), c_02.c().keySet().stream());
        }
        return stream.filter(4j_0::3).filter(4j_0::2).filter(4j_0::0).filter(4j_0::4).filter(this::1).min(Comparator.comparing(4j_0::c)).orElse((EntityPlayer)(8x_0.c(((8j_0)6.6()).c()) ? ((Minecraft)4j_0.c).player : null));
    }

    public 4j_0() {
        super("AutoTrap", 0, 3D.c, "Trapper", "AutoTrapper");
    }

    public static boolean 2(EntityPlayer entityPlayer) {
        return entityPlayer != ((Minecraft)4j_0.c).player && entityPlayer != c.getRenderViewEntity();
    }

    public static void c(int n2, BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > (long)(n2 + 100)) {
            ((ConcurrentHashMap)((Object)c)).remove(blockPos);
        }
    }

    public static boolean 3(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }

    public static boolean 4(EntityPlayer entityPlayer) {
        return ((Minecraft)4j_0.c).player.getDistance((Entity)entityPlayer) < Math.max(((Float)1.6()).floatValue() - 1.0f, 1.0f);
    }

    public boolean c(BlockPos blockPos, boolean bl) {
        return 8L.c(blockPos, bl) && !((ConcurrentHashMap)((Object)c)).containsKey(blockPos);
    }

    public static boolean 0(EntityPlayer entityPlayer) {
        return !8J.2(entityPlayer.getUniqueID().toString());
    }

    static {
        c = new ConcurrentHashMap();
    }

    public void c(4E e2) {
        e2.c = null;
        e2.c = null;
        e2.0 = null;
        e2.1 = null;
        e2.0 = null;
    }

    @Subscriber(priority=70)
    public void c(1O o2) {
        block9: {
            if (this.c == null || this.0 == null || this.1 == -1) break block9;
            boolean bl = 4j_0.c.player.inventory.currentItem != this.1;
            int n2 = 4j_0.c.player.inventory.currentItem;
            if (bl) {
                4j_0.c.player.inventory.currentItem = this.1;
                4j_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
            }
            boolean bl2 = ((Minecraft)4j_0.c).player.isSprinting();
            boolean bl3 = 8r_0.7(this.c.3());
            if (bl2) {
                4j_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4j_0.c).player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (bl3) {
                4j_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4j_0.c).player, CPacketEntityAction.Action.START_SNEAKING));
            }
            8L.c(this.c, EnumHand.MAIN_HAND, true);
            for (int i2 = 0; i2 < (Integer)2.6() - 1; ++i2) {
                BlockPos blockPos = this.c(this.0);
                if (blockPos != null) {
                    8K k2 = 8L.1(blockPos, (Boolean)8.6(), true);
                    if (k2 == null) break;
                    this.c = k2;
                    ((ConcurrentHashMap)((Object)c)).put(blockPos, System.currentTimeMillis());
                    8L.c(this.c, EnumHand.MAIN_HAND, true);
                    this.c = blockPos;
                    this.c.c();
                    continue;
                }
                if (!((Boolean)9.6()).booleanValue()) break;
                this.d();
                if (bl) {
                    4j_0.c.player.inventory.currentItem = n2;
                    4j_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
                }
                return;
            }
            if (bl3) {
                4j_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4j_0.c).player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (bl2) {
                4j_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4j_0.c).player, CPacketEntityAction.Action.START_SPRINTING));
            }
            if (bl) {
                4j_0.c.player.inventory.currentItem = n2;
                4j_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
            }
        }
    }

    public BlockPos c(BlockPos blockPos) {
        BlockPos blockPos2;
        double d2;
        double d3;
        BlockPos blockPos3;
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            blockPos3 = null;
            d3 = 0.0;
            if (this.c(blockPos.offset(enumFacing).down(), true) && (d2 = ((Minecraft)4j_0.c).player.getDistance((double)(blockPos2 = blockPos.offset(enumFacing).down()).getX() + 0.5, (double)blockPos2.getY() + 0.5, (double)blockPos2.getZ() + 0.5)) >= d3) {
                blockPos3 = blockPos2;
                d3 = d2;
            }
            if (blockPos3 == null) continue;
            return blockPos3;
        }
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            blockPos3 = null;
            d3 = 0.0;
            if (this.c(blockPos.offset(enumFacing), false) && (d2 = ((Minecraft)4j_0.c).player.getDistance((double)(blockPos2 = blockPos.offset(enumFacing)).getX() + 0.5, (double)blockPos2.getY() + 0.5, (double)blockPos2.getZ() + 0.5)) >= d3) {
                blockPos3 = blockPos2;
                d3 = d2;
            }
            if (blockPos3 == null) continue;
            return blockPos3;
        }
        Block block = EnumFacing.HORIZONTALS;
        int n2 = ((EnumFacing[])block).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            EnumFacing enumFacing;
            enumFacing = block[i2];
            blockPos3 = null;
            d3 = 0.0;
            if (this.c(blockPos.up().offset(enumFacing), false) && (!((Boolean)5.6()).booleanValue() || this.c(blockPos.up(), enumFacing)) && (d2 = ((Minecraft)4j_0.c).player.getDistance((double)(blockPos2 = blockPos.up().offset(enumFacing)).getX() + 0.5, (double)blockPos2.getY() + 0.5, (double)blockPos2.getZ() + 0.5)) >= d3) {
                blockPos3 = blockPos2;
                d3 = d2;
            }
            if (blockPos3 == null) continue;
            return blockPos3;
        }
        if (((Boolean)4.6()).booleanValue() && ((block = ((Minecraft)4j_0.c).world.getBlockState(blockPos.up().up()).getBlock()) instanceof BlockAir || block instanceof BlockLiquid)) {
            if (this.c(blockPos.up().up(), false)) {
                return blockPos.up().up();
            }
            BlockPos blockPos4 = blockPos.up().up().offset(EnumFacing.byHorizontalIndex((int)(MathHelper.floor((double)((double)(4j_0.c.player.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3)));
            if (this.c(blockPos4, false)) {
                return blockPos4;
            }
        }
        return null;
    }
}

