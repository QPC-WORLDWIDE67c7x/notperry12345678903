/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.List;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.4g_0;
import me.darki.konas.5D;
import me.darki.konas.8K;
import me.darki.konas.8L;
import me.darki.konas.8h_0;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5E
extends 3E {
    public 8h_0<Boolean> 1;
    public 8h_0<Boolean> 2;
    public static 8h_0<Integer> 3 = new 8h_0("Range", 4, 10, 2, 1);
    public static 8h_0<Integer> 4 = new 8h_0("ActionShift", 1, 5, 1, 1);
    public static 8h_0<Integer> 5 = new 8h_0("ActionInterval", 15, 30, 5, 1);
    public BlockPos c;
    public boolean 1;
    public boolean 2;
    public int 1 = new 8h_0("Rotate", true);
    public int 2 = new 8h_0("Triggerable", true);
    public int 3;
    public int 4;
    public boolean 3 = false;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean 0() {
        boolean bl = true;
        this.1 = true;
        this.2 = true;
        boolean bl2 = false;
        if (5E.c.world.getBlockState(this.c) == null) {
            return false;
        }
        Block block = 5E.c.world.getBlockState(this.c).getBlock();
        if (block instanceof BlockTallGrass || block instanceof BlockDeadBush) {
            bl2 = true;
        }
        if (5E.c(this.c.up()) == null) {
            return false;
        }
        for (BlockPos blockPos : 5D.c()) {
            if (!this.0(this.c.add((Vec3i)blockPos))) continue;
            bl = false;
        }
        for (BlockPos blockPos : 5D.3()) {
            if (!this.0(this.c.add((Vec3i)blockPos)) && !this.0(this.c.add((Vec3i)blockPos.down()))) continue;
            this.1 = false;
        }
        for (BlockPos blockPos : 5D.1()) {
            if (!this.0(this.c.add((Vec3i)blockPos)) && !this.0(this.c.add((Vec3i)blockPos.down()))) continue;
            this.2 = false;
        }
        for (BlockPos blockPos : 5D.0()) {
            if (!this.0(this.c.add((Vec3i)blockPos))) continue;
            this.1 = false;
        }
        for (BlockPos blockPos : 5D.2()) {
            if (!this.0(this.c.add((Vec3i)blockPos))) continue;
            this.2 = false;
        }
        if (bl2) return false;
        if (!bl) return false;
        if (this.1) return true;
        if (!this.2) return false;
        return true;
    }

    public 5E() {
        super("AutoWither", "Automatically places and spawns wither", 3D.3, new String[0]);
    }

    @Subscriber(priority=40)
    public void c(1P p2) {
        if (this.3 == 1) {
            8K k2;
            if (this.3) {
                this.3 = false;
            } else {
                this.1 = false;
                this.2 = false;
                if (!this.c()) {
                    this.d();
                    return;
                }
                List<BlockPos> list = 4g_0.c(5E.c.player.getPosition().down(), ((Integer)3.6()).intValue(), (Integer)3.6(), false, true, 0);
                boolean bl = true;
                for (BlockPos blockPos : list) {
                    this.c = blockPos.down();
                    if (!this.0()) continue;
                    bl = false;
                    break;
                }
                if (bl) {
                    if (((Boolean)this.2.6()).booleanValue()) {
                        this.d();
                    }
                    return;
                }
            }
            if (5E.c.player.inventory.currentItem != this.1) {
                5E.c.player.inventory.currentItem = this.1;
                5E.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
            }
            int n2 = 0;
            for (BlockPos blockPos : 5D.c()) {
                if (!8L.c(this.c.add((Vec3i)blockPos), false, true) || (k2 = 8L.1(this.c.add((Vec3i)blockPos), (Boolean)this.1.6(), true)) == null) continue;
                8L.c(k2, EnumHand.MAIN_HAND, false);
                if (++n2 < (Integer)4.6()) continue;
                this.3 = true;
                return;
            }
            if (this.1) {
                for (BlockPos blockPos : 5D.3()) {
                    if (!8L.c(this.c.add((Vec3i)blockPos), false, true) || (k2 = 8L.1(this.c.add((Vec3i)blockPos), (Boolean)this.1.6(), true)) == null) continue;
                    8L.c(k2, EnumHand.MAIN_HAND, false);
                    if (++n2 < (Integer)4.6()) continue;
                    this.3 = true;
                    return;
                }
            } else if (this.2) {
                for (BlockPos blockPos : 5D.1()) {
                    if (!8L.c(this.c.add((Vec3i)blockPos), false, true) || (k2 = 8L.1(this.c.add((Vec3i)blockPos), (Boolean)this.1.6(), true)) == null) continue;
                    8L.c(k2, EnumHand.MAIN_HAND, false);
                    if (++n2 < (Integer)4.6()) continue;
                    this.3 = true;
                    return;
                }
            }
            this.3 = 2;
        } else if (this.3 == 2) {
            if (5E.c.player.inventory.currentItem != this.2) {
                5E.c.player.inventory.currentItem = this.2;
                5E.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
            }
            int n3 = 0;
            if (this.1) {
                for (BlockPos blockPos : 5D.0()) {
                    8K k3;
                    if (!8L.c(this.c.add((Vec3i)blockPos), false, true) || (k3 = 8L.1(this.c.add((Vec3i)blockPos), (Boolean)this.1.6(), true)) == null) continue;
                    8L.c(k3, EnumHand.MAIN_HAND, false);
                    if (++n3 < (Integer)4.6()) continue;
                    return;
                }
            } else if (this.2) {
                for (BlockPos blockPos : 5D.2()) {
                    8K k4;
                    if (!8L.c(this.c.add((Vec3i)blockPos), false, true) || (k4 = 8L.1(this.c.add((Vec3i)blockPos), (Boolean)this.1.6(), true)) == null) continue;
                    8L.c(k4, EnumHand.MAIN_HAND, false);
                    if (++n3 < (Integer)4.6()) continue;
                    return;
                }
            }
            if (((Boolean)this.2.6()).booleanValue()) {
                this.d();
            }
            this.3 = 3;
        } else if (this.3 == 3) {
            if (this.4 < (Integer)5.6()) {
                ++this.4;
            } else {
                this.4 = 1;
                this.3 = 1;
            }
        }
    }

    public boolean 0(BlockPos blockPos) {
        Block block = 5E.c.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir)) {
            return true;
        }
        for (Entity entity : 5E.c.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
            if (entity instanceof EntityItem || entity instanceof EntityXPOrb) continue;
            return true;
        }
        return false;
    }

    @Override
    public void c() {
        if (5E.c.player == null) {
            this.d();
            return;
        }
        this.3 = 1;
        this.4 = 1;
        this.3 = false;
    }

    public boolean c() {
        this.2 = -1;
        this.1 = -1;
        for (int i2 = 0; i2 < 9; ++i2) {
            Block block;
            ItemStack itemStack = 5E.c.player.inventory.getStackInSlot(i2);
            if (itemStack == ItemStack.EMPTY) continue;
            if (itemStack.getItem() == Items.SKULL && itemStack.getItemDamage() == 1) {
                if (5E.c.player.inventory.getStackInSlot(i2).getCount() < 3) continue;
                this.2 = i2;
                continue;
            }
            if (!(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock)itemStack.getItem()).getBlock()) instanceof BlockSoulSand) || 5E.c.player.inventory.getStackInSlot(i2).getCount() < 4) continue;
            this.1 = i2;
        }
        return this.1 != -1 && this.2 != -1;
    }

    public static EnumFacing c(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!5E.c.world.getBlockState(blockPos2).getBlock().canCollideCheck(5E.c.world.getBlockState(blockPos2), false) || (iBlockState = 5E.c.world.getBlockState(blockPos2)).getMaterial().isReplaceable() || iBlockState.getBlock() instanceof BlockTallGrass || iBlockState.getBlock() instanceof BlockDeadBush) continue;
            return enumFacing;
        }
        return null;
    }
}

