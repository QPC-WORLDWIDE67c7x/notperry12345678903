/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.List;
import me.darki.konas.11;
import me.darki.konas.1P;
import me.darki.konas.1Q;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.62;
import me.darki.konas.63;
import me.darki.konas.64;
import me.darki.konas.6H;
import me.darki.konas.88;
import me.darki.konas.8L;
import me.darki.konas.8M;
import me.darki.konas.8Z;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 65
extends 3E {
    public List<Block> c;
    public 9m c;
    public 62 c;
    public static 8h_0<88> 1 = new 8h_0("CustomBlocks", new 88(new String[0]));
    public static 8h_0<63> 2 = new 8h_0("Filter", 63.c);
    public static 8h_0<Double> 3 = new 8h_0("Expand", 1.0, 6.0, 0.0, 0.1);
    public static 8h_0<Double> 4 = new 8h_0("Delay", 3.5, 10.0, 1.0, 0.5);
    public static 8h_0<Boolean> 5 = new 8h_0("Switch", true);
    public static 8h_0<64> 6 = new 8h_0("Tower", 64.0);
    public static 8h_0<Boolean> 7 = new 8h_0("Center", true);
    public static 8h_0<Boolean> 8 = new 8h_0("Safe", true);
    public static 8h_0<Boolean> 9 = new 8h_0("KeepY", true);
    public static 8h_0<Boolean> a = new 8h_0("Sprint", true);
    public static 8h_0<Boolean> b = new 8h_0("Down", true);
    public static 8h_0<Boolean> d = new 8h_0("Swing", false);
    public int 1;
    public 9m 0;
    public float c;
    public float 0;
    public BlockPos c = new 9m();
    public boolean 1;

    public float[] c(double d2, double d3, double d4) {
        double d5 = d2 - 65.c.player.posX;
        double d6 = d3 - 65.c.player.posY;
        double d7 = d4 - 65.c.player.posZ;
        double d8 = MathHelper.sqrt((double)(d5 * d5 + d7 * d7));
        return new float[]{(float)(Math.atan2(d7, d5) * 180.0 / Math.PI) - 90.0f, (float)(-(Math.atan2(d6, d8) * 180.0 / Math.PI))};
    }

    @Subscriber(priority=3)
    public void c(1P p2) {
        block0: {
            if (this.0.c(100.0 * (Double)4.6()) || !8L.c()) break block0;
            8k_0.c.c.c(this.c, this.0);
        }
    }

    public int c() {
        int n2 = 0;
        for (int i2 = 36; i2 < 45; ++i2) {
            if (!65.c.player.inventoryContainer.getSlot(i2).getHasStack()) continue;
            ItemStack itemStack = 65.c.player.inventoryContainer.getSlot(i2).getStack();
            Item item = itemStack.getItem();
            if (!(itemStack.getItem() instanceof ItemBlock) || this.c.contains(((ItemBlock)item).getBlock())) continue;
            n2 += itemStack.getCount();
        }
        return n2;
    }

    @Override
    public void 7() {
        8k_0.c.c.c(this);
    }

    public double[] c(double d2, double d3, double d4, double d5, float f2) {
        BlockPos blockPos = new BlockPos(d2, 65.c.player.posY - (double)(Keyboard.isKeyDown((int)56) && ((Boolean)b.6()).booleanValue() ? 2 : 1), d3);
        Block block = ((Minecraft)65.c).world.getBlockState(blockPos).getBlock();
        double d6 = -999.0;
        double d7 = -999.0;
        double d8 = 0.0;
        double d9 = (Double)3.6() * 2.0;
        while (!this.c(block)) {
            d6 = d2;
            d7 = d3;
            if ((d8 += 1.0) > d9) {
                d8 = d9;
            }
            d6 += (d4 * 0.45 * Math.cos(Math.toRadians(f2 + 90.0f)) + d5 * 0.45 * Math.sin(Math.toRadians(f2 + 90.0f))) * d8;
            d7 += (d4 * 0.45 * Math.sin(Math.toRadians(f2 + 90.0f)) - d5 * 0.45 * Math.cos(Math.toRadians(f2 + 90.0f))) * d8;
            if (d8 == d9) break;
            blockPos = new BlockPos(d6, 65.c.player.posY - (double)(Keyboard.isKeyDown((int)56) && (Boolean)b.6() != false ? 2 : 1), d7);
            block = ((Minecraft)65.c).world.getBlockState(blockPos).getBlock();
        }
        return new double[]{d6, d7};
    }

    public boolean 0(Block block) {
        if (this.c.contains(block)) {
            return false;
        }
        if (2.6() == 63.1) {
            if (((88)1.6()).0().contains(block)) {
                return false;
            }
        } else if (2.6() == 63.0 && !((88)1.6()).0().contains(block)) {
            return false;
        }
        return true;
    }

    public 65() {
        super("Scaffold", 3D.3, new String[0]);
        this.0 = new 9m();
    }

    public 62 c(BlockPos blockPos) {
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos.add(0, 1, 0), EnumFacing.DOWN);
        }
        BlockPos blockPos2 = blockPos.add(-1, 0, 0);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos2.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos2.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos2.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos2.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos2.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos2.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos3 = blockPos.add(1, 0, 0);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos3.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos3.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos3.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos3.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos3.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos3.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos4 = blockPos.add(0, 0, 1);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos4.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos4.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos4.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos4.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos4.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos4.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos5 = blockPos.add(0, 0, -1);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos5.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos5.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos5.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos5.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos5.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos5.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos6 = blockPos.add(-2, 0, 0);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos2.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos2.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos2.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos2.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos2.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos2.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos2.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos7 = blockPos.add(2, 0, 0);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos3.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos3.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos3.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos3.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos3.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos3.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos3.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos8 = blockPos.add(0, 0, 2);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos4.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos4.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos4.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos4.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos4.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos4.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos4.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos9 = blockPos.add(0, 0, -2);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos5.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos5.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos5.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos5.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos5.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos5.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos5.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos10 = blockPos.add(0, -1, 0);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos10.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos10.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos10.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos10.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos10.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos10.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos10.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos10.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos10.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos10.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos10.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos10.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos11 = blockPos10.add(1, 0, 0);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos11.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos11.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos11.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos11.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos11.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos11.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos11.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos11.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos11.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos11.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos11.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos11.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos12 = blockPos10.add(-1, 0, 0);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos12.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos12.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos12.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos12.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos12.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos12.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos12.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos12.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos12.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos12.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos12.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos12.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos13 = blockPos10.add(0, 0, 1);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos13.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos13.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos13.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos13.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos13.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos13.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos13.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos13.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos13.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos13.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos13.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos13.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos14 = blockPos10.add(0, 0, -1);
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos14.add(0, -1, 0)).getBlock())) {
            return new 62(this, blockPos14.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos14.add(0, 1, 0)).getBlock())) {
            return new 62(this, blockPos14.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos14.add(-1, 0, 0)).getBlock())) {
            return new 62(this, blockPos14.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos14.add(1, 0, 0)).getBlock())) {
            return new 62(this, blockPos14.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos14.add(0, 0, 1)).getBlock())) {
            return new 62(this, blockPos14.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.c.contains(((Minecraft)65.c).world.getBlockState(blockPos14.add(0, 0, -1)).getBlock())) {
            return new 62(this, blockPos14.add(0, 0, -1), EnumFacing.SOUTH);
        }
        return null;
    }

    @Override
    public void c() {
        if (((Minecraft)65.c).world != null) {
            this.c.c();
            this.1 = MathHelper.floor((double)65.c.player.posY);
        }
    }

    public boolean c(Block block) {
        return (block instanceof BlockAir || block instanceof BlockLiquid) && ((Minecraft)65.c).world != null && ((Minecraft)65.c).player != null && this.c != null && ((Minecraft)65.c).world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(this.c)).isEmpty();
    }

    public int 0() {
        int n2 = 0;
        for (int i2 = 0; i2 < 45; ++i2) {
            if (!65.c.player.inventoryContainer.getSlot(i2).getHasStack()) continue;
            ItemStack itemStack = 65.c.player.inventoryContainer.getSlot(i2).getStack();
            Item item = itemStack.getItem();
            if (!(itemStack.getItem() instanceof ItemBlock) || this.c.contains(((ItemBlock)item).getBlock())) continue;
            n2 += itemStack.getCount();
        }
        return n2;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block0: {
            if (this.c == null || this.c.c == null) break block0;
            8Z.c(this.c.c);
        }
    }

    public float[] c(double d2, double d3, double d4, EnumFacing enumFacing) {
        EntitySnowball entitySnowball = new EntitySnowball((World)((Minecraft)65.c).world);
        entitySnowball.posX = d2 + 0.5;
        entitySnowball.posY = d3 - 2.7035252353;
        entitySnowball.posZ = d4 + 0.5;
        return this.c(entitySnowball.posX, entitySnowball.posY, entitySnowball.posZ);
    }

    @Subscriber(priority=11)
    public void c(1Q q) {
        if (!3F.c(6H.class).f() && (((Boolean)b.6()).booleanValue() && 65.c.gameSettings.keyBindSneak.isKeyDown() || !((Boolean)a.6()).booleanValue())) {
            ((Minecraft)65.c).player.setSprinting(false);
        }
        int n2 = (Boolean)b.6() != false && Keyboard.isKeyDown((int)56) ? 2 : 1;
        if (((Boolean)9.6()).booleanValue()) {
            if (!8x_0.c() && 65.c.gameSettings.keyBindJump.isKeyDown() || 65.c.player.collidedVertically || 65.c.player.onGround) {
                this.1 = MathHelper.floor((double)65.c.player.posY);
            }
        } else {
            this.1 = MathHelper.floor((double)65.c.player.posY);
        }
        if (q instanceof 1P) {
            Object object;
            this.c = null;
            double d2 = 65.c.player.posX;
            double d3 = 65.c.player.posZ;
            double d4 = (Boolean)9.6() != false ? (double)this.1 : 65.c.player.posY;
            double d5 = 65.c.player.movementInput.moveForward;
            double d6 = 65.c.player.movementInput.moveStrafe;
            float f2 = 65.c.player.rotationYaw;
            if (!65.c.player.collidedHorizontally && (Double)3.6() > 0.0) {
                object = this.c(d2, d3, d5, d6, f2);
                d2 = object[0];
                d3 = object[1];
            }
            if (this.c(((Minecraft)65.c).world.getBlockState(new BlockPos(65.c.player.posX, 65.c.player.posY - (double)n2, 65.c.player.posZ)).getBlock())) {
                d2 = 65.c.player.posX;
                d3 = 65.c.player.posZ;
            }
            object = new BlockPos(d2, d4 - (double)n2, d3);
            this.c = (BlockPos)object;
            if (((Minecraft)65.c).world.getBlockState((BlockPos)object).getBlock() == Blocks.AIR) {
                this.c = this.c((BlockPos)object);
                if (this.c != null) {
                    float[] fArray = 8M.c(((Minecraft)65.c).player.getPositionEyes(c.getRenderPartialTicks()), new Vec3d((double)this.c.c.getX() + 0.5 + (double)this.c.c.getDirectionVec().getX() * 0.5, (double)this.c.c.getY() + 0.5 + (double)this.c.c.getDirectionVec().getY() * 0.5, (double)this.c.c.getZ() + 0.5 + (double)this.c.c.getDirectionVec().getZ() * 0.5));
                    8k_0.c.c.c(fArray[0], fArray[1]);
                    this.c = fArray[0];
                    this.0 = fArray[1];
                    this.0.c();
                }
            }
        } else if (this.c != null) {
            if (this.c() <= 0 || !((Boolean)5.6()).booleanValue() && ((Minecraft)65.c).player.getHeldItemMainhand().getItem() != null && !(((Minecraft)65.c).player.getHeldItemMainhand().getItem() instanceof ItemBlock)) {
                return;
            }
            int n3 = 65.c.player.inventory.currentItem;
            if (!(!((Boolean)5.6()).booleanValue() || ((Minecraft)65.c).player.getHeldItemMainhand().getItem() != null && ((Minecraft)65.c).player.getHeldItemMainhand().getItem() instanceof ItemBlock && this.0(((ItemBlock)((Minecraft)65.c).player.getHeldItemMainhand().getItem()).getBlock()))) {
                for (int i2 = 0; i2 < 9; ++i2) {
                    if (65.c.player.inventory.getStackInSlot(i2) == null || 65.c.player.inventory.getStackInSlot(i2).getCount() == 0 || !(65.c.player.inventory.getStackInSlot(i2).getItem() instanceof ItemBlock) || !this.0(((ItemBlock)65.c.player.inventory.getStackInSlot(i2).getItem()).getBlock())) continue;
                    65.c.player.inventory.currentItem = i2;
                    break;
                }
            }
            if (6.6() != 64.c) {
                if (65.c.gameSettings.keyBindJump.isKeyDown() && 65.c.player.moveForward == 0.0f && 65.c.player.moveStrafing == 0.0f && 6.6() != 64.c && !((Minecraft)65.c).player.isPotionActive(MobEffects.JUMP_BOOST)) {
                    if (!this.1 && ((Boolean)7.6()).booleanValue()) {
                        this.1 = true;
                        BlockPos blockPos = new BlockPos(65.c.player.posX, 65.c.player.posY, 65.c.player.posZ);
                        ((Minecraft)65.c).player.setPosition((double)blockPos.getX() + 0.5, (double)blockPos.getY(), (double)blockPos.getZ() + 0.5);
                    }
                    if (((Boolean)7.6()).booleanValue() && !this.1) {
                        return;
                    }
                    if (6.6() == 64.1) {
                        8k_0.c.c.c(this, 25, 65.c.player.ticksExisted % 10 == 0 ? 1.0f : 1.5782f);
                    }
                    65.c.player.motionY = 0.42f;
                    65.c.player.motionZ = 0.0;
                    65.c.player.motionX = 0.0;
                    if (this.c.c(1500.0)) {
                        8k_0.c.c.c(this);
                        this.c.c();
                        65.c.player.motionY = -0.28;
                    }
                } else {
                    8k_0.c.c.c(this);
                    this.c.c();
                    if (this.1 && ((Boolean)7.6()).booleanValue()) {
                        this.1 = false;
                    }
                }
            } else {
                8k_0.c.c.c(this);
            }
            if (((Minecraft)65.c).playerController.processRightClickBlock(((Minecraft)65.c).player, ((Minecraft)65.c).world, this.c.c, this.c.c, new Vec3d((double)this.c.c.getX() + Math.random(), (double)this.c.c.getY() + Math.random(), (double)this.c.c.getZ() + Math.random()), EnumHand.MAIN_HAND) != EnumActionResult.FAIL) {
                if (((Boolean)d.6()).booleanValue()) {
                    ((Minecraft)65.c).player.swingArm(EnumHand.MAIN_HAND);
                } else {
                    65.c.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
                }
            }
            65.c.player.inventory.currentItem = n3;
        }
    }

    @Subscriber
    public void c(11 var1_1) {
        double d2 = var1_1.2();
        double d3 = var1_1.1();
        if (65.c.player.onGround && !65.c.player.noClip && ((Boolean)8.6()).booleanValue() && !Keyboard.isKeyDown((int)56)) {
            double d4 = 0.05;
            while (d2 != 0.0 && ((Minecraft)65.c).world.getCollisionBoxes((Entity)((Minecraft)65.c).player, ((Minecraft)65.c).player.getEntityBoundingBox().offset(d2, -1.0, 0.0)).isEmpty()) {
                if (d2 < d4 && d2 >= -d4) {
                    d2 = 0.0;
                    continue;
                }
                if (d2 > 0.0) {
                    d2 -= d4;
                    continue;
                }
                d2 += d4;
            }
            while (d3 != 0.0 && ((Minecraft)65.c).world.getCollisionBoxes((Entity)((Minecraft)65.c).player, ((Minecraft)65.c).player.getEntityBoundingBox().offset(0.0, -1.0, d3)).isEmpty()) {
                if (d3 < d4 && d3 >= -d4) {
                    d3 = 0.0;
                    continue;
                }
                if (d3 > 0.0) {
                    d3 -= d4;
                    continue;
                }
                d3 += d4;
            }
            while (d2 != 0.0 && d3 != 0.0 && ((Minecraft)65.c).world.getCollisionBoxes((Entity)((Minecraft)65.c).player, ((Minecraft)65.c).player.getEntityBoundingBox().offset(d2, -1.0, d3)).isEmpty()) {
                d2 = d2 < d4 && d2 >= -d4 ? 0.0 : (d2 > 0.0 ? (d2 -= d4) : (d2 += d4));
                if (d3 < d4 && d3 >= -d4) {
                    d3 = 0.0;
                    continue;
                }
                if (d3 > 0.0) {
                    d3 -= d4;
                    continue;
                }
                d3 += d4;
            }
        }
        var1_1.1(d2);
        var1_1.c(d3);
    }
}

