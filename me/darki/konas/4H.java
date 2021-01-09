/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.darki.konas.0S;
import me.darki.konas.1N;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8E;
import me.darki.konas.8L;
import me.darki.konas.8M;
import me.darki.konas.8Z;
import me.darki.konas.8h_0;
import me.darki.konas.8r_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import me.darki.konas.mixin.mixins.IMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 4H
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Rotate", true);
    public static 8h_0<Boolean> 2 = new 8h_0("Swing", true);
    public static 8h_0<Boolean> 3 = new 8h_0("Packet", true);
    public static 8h_0<Boolean> 4 = new 8h_0("Force", false);
    public static 8h_0<Boolean> 5 = new 8h_0("Full", true);
    public static 8h_0<Boolean> 6 = new 8h_0("Strict", false);
    public static 8h_0<Integer> 7 = new 8h_0("ActionShift", 3, 8, 1, 1);
    public static 8h_0<Float> 8 = new 8h_0("ActionInterval", Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> 9 = new 8h_0("Center", true);
    public static 8h_0<Boolean> a = new 8h_0("Queue", true);
    public static 8h_0<Boolean> b = new 8h_0("Clear", false);
    public static 8h_0<Boolean> d = new 8h_0("AutoDisable", true);
    public static 8h_0<Boolean> e = new 8h_0("EChest", false);
    public static boolean 1 = false;
    public 9m c;
    public BlockPos c;
    public int 1;
    public boolean 2;
    public int 2 = 0;
    public int 3;
    public boolean 3 = false;
    public List<Vec3d> c;
    public ConcurrentHashMap<BlockPos, Long> c = new ConcurrentHashMap();
    public BlockPos 0;

    public int 1() {
        Block block;
        ItemStack itemStack;
        int n2;
        int n3 = -1;
        if (((Boolean)e.6()).booleanValue()) {
            for (n2 = 0; n2 < 9; ++n2) {
                itemStack = 4H.c.player.inventory.getStackInSlot(n2);
                if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock)itemStack.getItem()).getBlock()) instanceof BlockEnderChest)) continue;
                n3 = n2;
                return n3;
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            itemStack = 4H.c.player.inventory.getStackInSlot(n2);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock)itemStack.getItem()).getBlock()) instanceof BlockObsidian)) continue;
            n3 = n2;
            break;
        }
        return n3;
    }

    public void 8() {
        BlockPos blockPos;
        if (this.b()) {
            return;
        }
        this.0 = null;
        this.c = new ArrayList();
        if (this.7()) {
            if (((Boolean)5.6()).booleanValue()) {
                this.c.add(((Minecraft)4H.c).player.getPositionVector().add(1.0, 0.0, 0.0));
                this.c.add(((Minecraft)4H.c).player.getPositionVector().add(-1.0, 0.0, 0.0));
                this.c.add(((Minecraft)4H.c).player.getPositionVector().add(0.0, 0.0, 1.0));
                this.c.add(((Minecraft)4H.c).player.getPositionVector().add(0.0, 0.0, -1.0));
            }
            this.c.add(((Minecraft)4H.c).player.getPositionVector().add(1.0, 1.0, 0.0));
            this.c.add(((Minecraft)4H.c).player.getPositionVector().add(-1.0, 1.0, 0.0));
            this.c.add(((Minecraft)4H.c).player.getPositionVector().add(0.0, 1.0, 1.0));
            this.c.add(((Minecraft)4H.c).player.getPositionVector().add(0.0, 1.0, -1.0));
        } else {
            this.c.add(((Minecraft)4H.c).player.getPositionVector().add(0.0, -1.0, 0.0));
            if (((Boolean)5.6()).booleanValue()) {
                this.c.add(((Minecraft)4H.c).player.getPositionVector().add(1.0, -1.0, 0.0));
                this.c.add(((Minecraft)4H.c).player.getPositionVector().add(-1.0, -1.0, 0.0));
                this.c.add(((Minecraft)4H.c).player.getPositionVector().add(0.0, -1.0, 1.0));
                this.c.add(((Minecraft)4H.c).player.getPositionVector().add(0.0, -1.0, -1.0));
            }
            this.c.add(((Minecraft)4H.c).player.getPositionVector().add(1.0, 0.0, 0.0));
            this.c.add(((Minecraft)4H.c).player.getPositionVector().add(-1.0, 0.0, 0.0));
            this.c.add(((Minecraft)4H.c).player.getPositionVector().add(0.0, 0.0, 1.0));
            this.c.add(((Minecraft)4H.c).player.getPositionVector().add(0.0, 0.0, -1.0));
        }
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        Iterator iterator = this.c.iterator();
        while (iterator.hasNext()) {
            Vec3d vec3d = (Vec3d)iterator.next();
            blockPos = new BlockPos(vec3d);
            if (((Minecraft)4H.c).world.getBlockState(blockPos).getBlock() != Blocks.AIR) continue;
            arrayList.add(blockPos);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (BlockPos blockPos2 : arrayList) {
            if (this.2 > (Integer)7.6()) {
                return;
            }
            if (((ConcurrentHashMap)((Object)this.c)).containsKey(blockPos2) || this.c(blockPos2)) continue;
            if (this.1(blockPos2)) {
                if (!((Boolean)b.6()).booleanValue()) continue;
                blockPos = null;
                for (Entity entity : 4H.c.world.loadedEntityList) {
                    if (entity == null || (double)((Minecraft)4H.c).player.getDistance(entity) > 2.4 || !(entity instanceof EntityEnderCrystal) || entity.isDead) continue;
                    blockPos = (EntityEnderCrystal)entity;
                }
                if (blockPos != null) {
                    if (((Boolean)1.6()).booleanValue()) {
                        Object object = 8M.c(((Minecraft)4H.c).player.getPositionEyes(c.getRenderPartialTicks()), blockPos.getPositionEyes(c.getRenderPartialTicks()));
                        4H.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation((float)object[0], (float)MathHelper.normalizeAngle((int)((int)object[1]), (int)360), 4H.c.player.onGround));
                        ((IEntityPlayerSP)((Minecraft)4H.c).player).setLastReportedYaw((float)object[0]);
                        ((IEntityPlayerSP)((Minecraft)4H.c).player).setLastReportedPitch(MathHelper.normalizeAngle((int)((int)object[1]), (int)360));
                    }
                    c.getConnection().sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
                    c.getConnection().sendPacket((Packet)new CPacketUseEntity((Entity)blockPos));
                }
            }
            this.0 = blockPos2;
            this.0(blockPos2);
            ++this.2;
        }
    }

    public void 9() {
        this.8();
    }

    @Subscriber
    public void c(0S s) {
        if (((Minecraft)4H.c).world == null || ((Minecraft)4H.c).player == null) {
            return;
        }
        if (s.c() instanceof SPacketBlockChange && ((Boolean)a.6()).booleanValue()) {
            SPacketBlockChange sPacketBlockChange = (SPacketBlockChange)s.c();
            if (sPacketBlockChange.blockState.getBlock() == Blocks.AIR && ((Minecraft)4H.c).player.getDistance((double)sPacketBlockChange.getBlockPosition().getX(), (double)sPacketBlockChange.getBlockPosition().getY(), (double)sPacketBlockChange.getBlockPosition().getZ()) < 1.75) {
                c.addScheduledTask(this::0);
            }
        }
    }

    public boolean 7() {
        return !this.6() && this.c((Entity)((Minecraft)4H.c).player);
    }

    @Override
    public void 7() {
        if (((Minecraft)4H.c).player == null || ((Minecraft)4H.c).world == null) {
            return;
        }
        this.0 = null;
        1 = false;
        this.2 = this.c(this.2);
    }

    public void 0() {
        this.8();
    }

    public boolean c(BlockPos blockPos) {
        for (Entity entity : 4H.c.world.loadedEntityList) {
            if (entity instanceof EntityEnderCrystal || entity instanceof EntityItem || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox())) continue;
            return true;
        }
        return false;
    }

    public void c(BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > (long)(8E.0() + 40)) {
            ((ConcurrentHashMap)((Object)this.c)).remove(blockPos);
        }
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block1: {
            if (((Minecraft)4H.c).world == null || ((Minecraft)4H.c).player == null) {
                return;
            }
            if (this.0 == null) break block1;
            8Z.c(this.0);
        }
    }

    public boolean 6() {
        Block block = ((Minecraft)4H.c).world.getBlockState(new BlockPos(((Minecraft)4H.c).player.getPositionVector().add(0.0, 0.2, 0.0))).getBlock();
        return block == Blocks.OBSIDIAN || block == Blocks.ENDER_CHEST;
    }

    public boolean b() {
        if (((Minecraft)4H.c).player == null || ((Minecraft)4H.c).world == null) {
            return true;
        }
        1 = false;
        this.2 = 0;
        this.3 = this.1();
        if (!this.f()) {
            return true;
        }
        if (this.3 == -1) {
            this.d();
            return true;
        }
        this.2 = this.c(this.2);
        if (4H.c.player.inventory.currentItem != this.1 && 4H.c.player.inventory.currentItem != this.3) {
            this.1 = 4H.c.player.inventory.currentItem;
        }
        if (((Boolean)d.6()).booleanValue() && !this.c.equals((Object)new BlockPos((Entity)((Minecraft)4H.c).player))) {
            this.d();
            return true;
        }
        return !this.c.c(((Float)8.6()).floatValue() * 10.0f);
    }

    @Override
    public void c() {
        if (((Minecraft)4H.c).player == null || ((Minecraft)4H.c).world == null) {
            this.d();
            return;
        }
        this.1 = 4H.c.player.inventory.currentItem;
        this.c = new BlockPos((Entity)((Minecraft)4H.c).player);
        if (((Boolean)9.6()).booleanValue()) {
            8x_0.1();
        }
        ((ConcurrentHashMap)((Object)this.c)).clear();
    }

    public 4H() {
        super("Surround", 0, 3D.c, "AutoObsidian");
    }

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)4H.c).player == null || ((Minecraft)4H.c).world == null) {
            this.d();
            return;
        }
        ((ConcurrentHashMap)((Object)this.c)).forEach(this::c);
        c.addScheduledTask(this::9);
    }

    public boolean c(boolean bl) {
        block0: {
            if (!bl || ((Minecraft)4H.c).player == null) break block0;
            4H.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4H.c).player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        return false;
    }

    public boolean c(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        BlockPos blockPos2;
        EnumFacing enumFacing3;
        boolean bl4 = false;
        EnumFacing enumFacing2 = null;
        double d2 = 69420.0;
        for (EnumFacing enumFacing3 : 8L.0(blockPos, (Boolean)6.6(), false)) {
            blockPos2 = blockPos.offset(enumFacing3);
            Vec3d vec3d = new Vec3d((Vec3i)blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing3.getDirectionVec()).scale(0.5));
            if (!(((Minecraft)4H.c).player.getPositionVector().add(0.0, (double)((Minecraft)4H.c).player.getEyeHeight(), 0.0).distanceTo(vec3d) < d2)) continue;
            enumFacing2 = enumFacing3;
        }
        if (enumFacing2 == null) {
            enumFacing2 = EnumFacing.DOWN;
        }
        BlockPos blockPos3 = blockPos.offset(enumFacing2);
        enumFacing3 = enumFacing2.getOpposite();
        blockPos2 = new Vec3d((Vec3i)blockPos3).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing3.getDirectionVec()).scale(0.5));
        if (!((Minecraft)4H.c).player.isSneaking() && 8r_0.7(blockPos3)) {
            4H.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4H.c).player, CPacketEntityAction.Action.START_SNEAKING));
            ((Minecraft)4H.c).player.setSneaking(true);
            bl4 = true;
        }
        if (bl) {
            8x_0.c((Vec3d)blockPos2);
        }
        8L.c(blockPos3, (Vec3d)blockPos2, enumHand, enumFacing3, bl2, (Boolean)2.6());
        4H.c.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        if (!((Boolean)4.6()).booleanValue()) {
            ((ConcurrentHashMap)((Object)this.c)).put(blockPos, System.currentTimeMillis());
        }
        ((IMinecraft)((Object)c)).setRightClickDelayTimer(0);
        return bl4 || bl3;
    }

    public boolean c(Entity entity) {
        BlockPos blockPos = new BlockPos(entity.posX, entity.posY, entity.posZ);
        return ((Minecraft)4H.c).world.getBlockState(blockPos).getBlock().equals(Blocks.OBSIDIAN) || ((Minecraft)4H.c).world.getBlockState(blockPos).getBlock().equals(Blocks.ENDER_CHEST);
    }

    public void 0(BlockPos blockPos) {
        int n2;
        block17: {
            n2 = 4H.c.player.inventory.currentItem;
            if (this.3 != -1) break block17;
            4H h2 = this;
            h2.d();
            return;
        }
        1 = true;
        4H.c.player.inventory.currentItem = this.3;
        PlayerControllerMP playerControllerMP = ((Minecraft)4H.c).playerController;
        playerControllerMP.updateController();
        4H h3 = this;
        4H h4 = this;
        BlockPos blockPos2 = blockPos;
        EnumHand enumHand = this.3 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
        8h_0<Boolean> h_02 = 1;
        Object t = h_02.6();
        Boolean bl = (Boolean)t;
        boolean bl2 = bl;
        8h_0<Boolean> h_03 = 3;
        Object t2 = h_03.6();
        Boolean bl3 = (Boolean)t2;
        boolean bl4 = bl3;
        boolean bl5 = this.2;
        boolean bl6 = h4.c(blockPos2, enumHand, bl2, bl4, bl5);
        h3.2 = bl6;
        4H.c.player.inventory.currentItem = n2;
        PlayerControllerMP playerControllerMP2 = ((Minecraft)4H.c).playerController;
        try {
            playerControllerMP2.updateController();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public boolean 1(BlockPos blockPos) {
        for (Entity entity : 4H.c.world.loadedEntityList) {
            if (!(entity instanceof EntityEnderCrystal) || entity.equals((Object)((Minecraft)4H.c).player) || entity instanceof EntityItem || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox())) continue;
            return true;
        }
        return false;
    }
}

