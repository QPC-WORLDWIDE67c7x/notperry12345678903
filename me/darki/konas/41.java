/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import me.darki.konas.0S;
import me.darki.konas.14;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.40;
import me.darki.konas.6S;
import me.darki.konas.89;
import me.darki.konas.8F;
import me.darki.konas.8J;
import me.darki.konas.8L;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8u_0;
import me.darki.konas.99;
import me.darki.konas.9m;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 41
extends 3E {
    public 8h_0<Boolean> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Float> 3;
    public 8h_0<Float> 4;
    public 8h_0<Boolean> 5;
    public 8h_0<40> 6;
    public 8h_0<Boolean> 7;
    public 8h_0<Boolean> 8;
    public 8h_0<8f_0> 9;
    public 8h_0<Boolean> a;
    public 8h_0<89> b;
    public 8h_0<89> d;
    public 8h_0<89> e;
    public 8h_0<89> f;
    public 8h_0<Float> g;
    public 9m c;
    public BlockPos c;
    public BlockPos 0;
    public EnumFacing c;
    public float c;
    public 9m 0;
    public boolean 1;
    public 9m 1;
    public Runnable c = null;
    public int 1 = -1;

    public boolean 2(EntityPlayer entityPlayer) {
        return ((Minecraft)41.c).player.getDistance((Entity)entityPlayer) <= ((Float)this.3.6()).floatValue();
    }

    public 41() {
        super("AntiSurround", "Mines enemy surrounds", 3D.c, new String[0]);
        this.2 = new 8h_0("Swing", true);
        this.3 = new 8h_0("Range", Float.valueOf(4.0f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.1f));
        this.4 = new 8h_0("Delay", Float.valueOf(2.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
        this.5 = new 8h_0("StrictDirection", false);
        this.6 = new 8h_0("Swap", 40.0);
        this.7 = new 8h_0("Instant", false);
        this.8 = new 8h_0("Limit", false).c(this.7::6);
        this.9 = new 8h_0("Render", new 8f_0(false));
        this.a = new 8h_0("ShowMining", true).c(this.9);
        this.b = new 8h_0("Mining", new 89(0x55FF0000)).c(this.9);
        this.d = new 8h_0("MiningOutline", new 89(Color.RED.hashCode())).c(this.9);
        this.e = new 8h_0("Ready", new 89(0x5500FF00)).c(this.9);
        this.f = new 8h_0("ReadyOutline", new 89(Color.GREEN.hashCode())).c(this.9);
        this.g = new 8h_0("Width", Float.valueOf(1.5f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(this.9);
        this.c = new 9m();
        this.0 = new 9m();
        this.1 = new 9m();
    }

    @Subscriber(priority=15)
    public void c(1O o2) {
        if (this.c != null) {
            this.c.run();
            this.c = null;
        }
        if (this.1 != -1 && this.c.c(350.0)) {
            41.c.player.inventory.currentItem = this.1;
            41.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
            this.1 = -1;
        }
    }

    public void 0() {
        block1: {
            if (((Boolean)this.8.6()).booleanValue()) {
                41.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.0, this.c.getOpposite()));
            }
            41.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.0, this.c));
            if (!((Boolean)this.2.6()).booleanValue()) break block1;
            ((Minecraft)41.c).player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    @Override
    public void c() {
        this.c = null;
        this.0 = null;
        this.c = null;
        this.c = 0.0f;
        this.c = null;
        this.1 = false;
        this.1 = -1;
    }

    public static boolean 4(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() > 0.0f;
    }

    public static Double c(BlockPos blockPos) {
        return ((Minecraft)41.c).player.getDistanceSq(blockPos);
    }

    public static boolean 3(EntityPlayer entityPlayer) {
        return entityPlayer != ((Minecraft)41.c).player;
    }

    @Override
    public void 7() {
        if (this.1 != -1 && ((Minecraft)41.c).player != null) {
            41.c.player.inventory.currentItem = this.1;
            41.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
            this.1 = -1;
        }
    }

    @Subscriber
    public void c(14 var1_1) {
        block2: {
            if (this.0 == null || !(this.c < 1.0f)) break block2;
            IBlockState iBlockState = ((Minecraft)41.c).world.getBlockState(this.0);
            if (iBlockState.getMaterial() == Material.AIR) {
                this.c = this.0;
                this.0 = null;
                return;
            }
            int n2 = 6S.c(this.0);
            if (n2 == -1) {
                n2 = 41.c.player.inventory.currentItem;
            }
            int n3 = 41.c.player.inventory.currentItem;
            41.c.player.inventory.currentItem = n2;
            this.c += iBlockState.getPlayerRelativeBlockHardness((EntityPlayer)((Minecraft)41.c).player, 41.c.player.world, this.0);
            41.c.player.inventory.currentItem = n3;
            this.0.c();
        }
    }

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketBlockChange && this.0 != null && ((SPacketBlockChange)s.c()).getBlockPosition().equals((Object)this.0) && ((SPacketBlockChange)s.c()).getBlockState().getBlock() instanceof BlockAir) {
            this.c = this.0;
            this.0 = null;
            this.c = null;
        }
    }

    public static boolean 1(EntityPlayer entityPlayer) {
        return !8J.2(entityPlayer.getUniqueID().toString());
    }

    public static Double c(BlockPos blockPos, Vec3d vec3d, EnumFacing enumFacing) {
        return new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5)).distanceTo(vec3d);
    }

    public void 1() {
        block0: {
            41.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.0, this.c));
            41.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.0, this.c));
            if (!((Boolean)this.2.6()).booleanValue()) break block0;
            ((Minecraft)41.c).player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    @Subscriber(priority=90)
    public void c(1P p2) {
        block13: {
            EnumFacing enumFacing;
            ArrayList<BlockPos> arrayList;
            BlockPos blockPos;
            EntityPlayer entityPlayer;
            if (p2.0() || !8L.c((Boolean)this.1.6())) {
                return;
            }
            if (this.0 != null) {
                if (this.c >= 1.0f) {
                    if (this.1) {
                        if (this.0.c(1500.0)) {
                            this.0 = null;
                            this.c = null;
                        }
                    } else {
                        int n2;
                        this.1 = true;
                        if (this.6.6() != 40.c && (n2 = 6S.c(this.0)) != -1 && n2 != 41.c.player.inventory.currentItem) {
                            if (this.6.6() == 40.1) {
                                this.1 = 41.c.player.inventory.currentItem;
                                41.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
                                this.c.c();
                            } else {
                                41.c.player.inventory.currentItem = n2;
                                41.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
                            }
                        }
                    }
                }
            } else if (this.1.c(((Float)this.4.6()).floatValue() * 1000.0f) && (entityPlayer = this.2()) != null && (blockPos = (BlockPos)(arrayList = 8F.c(new BlockPos((Entity)entityPlayer))).stream().min(Comparator.comparing(41::c)).orElse(null)) != null && (enumFacing = this.c(blockPos, (Boolean)this.5.6())) != null) {
                this.0 = blockPos;
                this.c = enumFacing;
                this.c = 0.0f;
                this.1 = false;
                this.1.c();
                if (((Boolean)this.7.6()).booleanValue() && this.0.equals((Object)this.c)) {
                    this.c = 1.0f;
                    this.0.c();
                    this.c = this::0;
                } else {
                    this.c = this::1;
                }
            }
            if (!((Boolean)this.1.6()).booleanValue() || this.0 == null) break block13;
            Vec3d vec3d = new Vec3d((Vec3i)this.0).add(0.5, 0.5, 0.5).add(new Vec3d(this.c.getDirectionVec()).scale(0.5));
            8k_0.c.c.c(vec3d);
        }
    }

    public static boolean c(Vec3d vec3d, BlockPos blockPos, EnumFacing enumFacing) {
        return ((Minecraft)41.c).world.rayTraceBlocks(vec3d, new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5))) == null;
    }

    public static Float 5(EntityPlayer entityPlayer) {
        return Float.valueOf(((Minecraft)41.c).player.getDistance((Entity)entityPlayer));
    }

    public static boolean c(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    /*
     * Unable to fully structure code
     */
    @Subscriber
    public void c(1b_0 var1_1) {
        block31: {
            block32: {
                if (this.0 == null) break block31;
                v0 = this.a;
                v1 = v0.6();
                v2 = (Boolean)v1;
                v3 = v2;
                if (!v3) break block31;
                v4 = 41.c.world;
                v5 = this.0;
                v6 = v4.getBlockState(v5);
                v7 = 41.c.world;
                v8 = this.0;
                v9 = v6.getBoundingBox((IBlockAccess)v7, v8);
                v10 = this.0;
                v11 = v9.offset(v10);
                var2_2 = v11;
                99.c();
                v12 = var2_2;
                v13 = true;
                v14 = 1.0;
                if (!(this.c >= 1.0f)) ** GOTO lbl41
                v15 = this.e;
                v16 = v15.6();
                v17 = (89)v16;
                ** GOTO lbl46
lbl41:
                // 1 sources

                v18 = this.b;
                v19 = v18.6();
                v17 = (89)v19;
lbl46:
                // 2 sources

                v20 = 63;
                99.c(v12, v13, v14, v17, v20);
                v21 = var2_2;
                v22 = this.g;
                v23 = v22.6();
                v24 = (Float)v23;
                v25 = v24.floatValue();
                v26 = v25;
                if (!(this.c >= 1.0f)) ** GOTO lbl67
                v27 = this.f;
                v28 = v27.6();
                v29 = (89)v28;
                break block32;
lbl67:
                // 1 sources

                v30 = this.d;
                v31 = v30.6();
                v29 = (89)v31;
            }
            99.c(v21, v26, v29);
            try {
                99.0();
            }
            catch (NullPointerException var2_3) {
                // empty catch block
            }
        }
    }

    public EnumFacing c(BlockPos blockPos, boolean bl) {
        Vec3d vec3d;
        List<Object> list;
        block1: {
            block0: {
                list = new ArrayList();
                vec3d = ((Minecraft)41.c).player.getPositionEyes(1.0f);
                if (!bl) break block0;
                Vec3d vec3d2 = new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5);
                IBlockState iBlockState = ((Minecraft)41.c).world.getBlockState(blockPos);
                boolean bl2 = iBlockState.getBlock() == Blocks.AIR || iBlockState.isFullBlock();
                list.addAll(8L.c(vec3d.x - vec3d2.x, EnumFacing.WEST, EnumFacing.EAST, !bl2));
                list.addAll(8L.c(vec3d.y - vec3d2.y, EnumFacing.DOWN, EnumFacing.UP, true));
                list.addAll(8L.c(vec3d.z - vec3d2.z, EnumFacing.NORTH, EnumFacing.SOUTH, !bl2));
                list = list.stream().filter(arg_0 -> 41.c(vec3d, blockPos, arg_0)).collect(Collectors.toList());
                if (!list.isEmpty()) break block1;
                list.addAll(8L.c(vec3d.x - vec3d2.x, EnumFacing.WEST, EnumFacing.EAST, !bl2));
                list.addAll(8L.c(vec3d.y - vec3d2.y, EnumFacing.DOWN, EnumFacing.UP, true));
                list.addAll(8L.c(vec3d.z - vec3d2.z, EnumFacing.NORTH, EnumFacing.SOUTH, !bl2));
                break block1;
            }
            list = Arrays.asList(EnumFacing.values());
        }
        return list.stream().min(Comparator.comparing(arg_0 -> 41.c(blockPos, vec3d, arg_0))).orElse(null);
    }

    public static boolean 0(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }

    public EntityPlayer 2() {
        return 41.c.world.playerEntities.stream().filter(41::0).filter(41::3).filter(41::c).filter(41::1).filter(41::4).filter(this::2).filter(8F::c).min(Comparator.comparing(41::5)).orElse(null);
    }
}

