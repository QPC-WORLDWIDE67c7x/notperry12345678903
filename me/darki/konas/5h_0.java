/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.08;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5e_0;
import me.darki.konas.5f_0;
import me.darki.konas.5g_0;
import me.darki.konas.8E;
import me.darki.konas.8L;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8r_0;
import me.darki.konas.9m;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.5h
 */
public class 5h_0
extends 3E {
    public 8h_0<5g_0> 1;
    public 8h_0<5f_0> 2;
    public 8h_0<Float> 3;
    public 8h_0<Integer> 4;
    public 8h_0<Boolean> 5;
    public 8h_0<Boolean> 6;
    public 8h_0<Boolean> 7;
    public 8h_0<Boolean> 8;
    public 8h_0<Boolean> 9;
    public 8h_0<Boolean> a;
    public 8h_0<Boolean> b;
    public 8h_0<Boolean> d;
    public 8h_0<Boolean> e;
    public 8h_0<Float> f;
    public 9m c;
    public boolean 1;
    public boolean 2 = false;
    public BlockPos c;
    public EnumFacing c = null;
    public 9m 0;
    public int 1 = 2000;

    @Override
    public boolean 5() {
        return this.1.6() == 5g_0.0;
    }

    public boolean c() {
        return this.1.6() == 5g_0.1;
    }

    @Subscriber
    public void c(0T t) {
        block1: {
            if (this.1.6() != 5g_0.1) {
                return;
            }
            if (!((Boolean)this.7.6()).booleanValue() || this.2.6() != 5f_0.0 || !(t.c() instanceof CPacketPlayerTryUseItemOnBlock) || !((CPacketPlayerTryUseItemOnBlock)t.c()).getPos().offset(((CPacketPlayerTryUseItemOnBlock)t.c()).getDirection()).equals((Object)this.c)) break block1;
            this.1 = true;
            this.c.c();
        }
    }

    public boolean 0() {
        return this.1.6() == 5g_0.1 && this.2.6() == 5f_0.0;
    }

    public boolean 7() {
        return this.1.6() == 5g_0.1;
    }

    @Override
    public void c() {
        this.1 = false;
        this.2 = false;
        this.c = null;
        this.c = null;
        this.1 = 2000;
    }

    public boolean 6() {
        return this.1.6() != 5g_0.1;
    }

    public boolean d() {
        return this.1.6() == 5g_0.1;
    }

    public boolean 9() {
        return ((Minecraft)5h_0.c).player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }

    public EnumFacing c(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            RayTraceResult rayTraceResult = ((Minecraft)5h_0.c).world.rayTraceBlocks(new Vec3d(5h_0.c.player.posX, 5h_0.c.player.posY + (double)((Minecraft)5h_0.c).player.getEyeHeight(), 5h_0.c.player.posZ), new Vec3d((double)blockPos.getX() + 0.5 + (double)enumFacing.getDirectionVec().getX() * 1.0 / 2.0, (double)blockPos.getY() + 0.5 + (double)enumFacing.getDirectionVec().getY() * 1.0 / 2.0, (double)blockPos.getZ() + 0.5 + (double)enumFacing.getDirectionVec().getZ() * 1.0 / 2.0), false, true, false);
            if (rayTraceResult == null || !rayTraceResult.typeOfHit.equals((Object)RayTraceResult.Type.BLOCK) || !rayTraceResult.getBlockPos().equals((Object)blockPos)) continue;
            return enumFacing;
        }
        if ((double)blockPos.getY() > 5h_0.c.player.posY + (double)((Minecraft)5h_0.c).player.getEyeHeight()) {
            return EnumFacing.DOWN;
        }
        return EnumFacing.UP;
    }

    public 5h_0() {
        super("SpeedMine", 3D.4, "FastMine", "FakeHaste", "InstantMine", "InstantBreak");
        this.2 = new 8h_0("Type", 5f_0.c);
        this.3 = new 8h_0("Speed", Float.valueOf(0.8f), Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(this::5);
        this.4 = new 8h_0("Intensity", 1, 10, 1, 1).c(this::8);
        this.5 = new 8h_0("Fall", true).c(this::6);
        this.6 = new 8h_0("Rotate", true).c(this::7);
        this.7 = new 8h_0("Predict", true).c(this::h);
        this.8 = new 8h_0("Others", false).c(this::1);
        this.9 = new 8h_0("NoAnim", false).c(this::g);
        this.a = new 8h_0("Strict", false).c(this::b);
        this.b = new 8h_0("Limit", false).c(this::d);
        this.d = new 8h_0("Direction", false).c(this::c);
        this.e = new 8h_0("Crystals", false).c(this::0);
        this.f = new 8h_0("Delay", Float.valueOf(1.0f), Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(this::e);
        this.c = new 9m();
        this.0 = new 9m();
    }

    @Override
    public void 7() {
        block0: {
            if (this.1.6() != 5g_0.c) break block0;
            ((Minecraft)5h_0.c).player.removePotionEffect(MobEffects.HASTE);
        }
    }

    @Subscriber(priority=10)
    public void c(1P p2) {
        block7: {
            if (this.1 && this.c != null && this.c != null && this.1.6() == 5g_0.1 && this.2.6() == 5f_0.0 && this.c.c(100.0f * ((Float)this.f.6()).floatValue())) {
                ((Minecraft)5h_0.c).player.swingArm(EnumHand.MAIN_HAND);
                if (((Boolean)this.e.6()).booleanValue()) {
                    int n2;
                    int n3 = 5h_0.c.player.inventory.currentItem;
                    if (!this.9() && (n2 = 8E.1()) != -1 && 5h_0.c.player.inventory.currentItem != n2) {
                        5h_0.c.player.inventory.currentItem = n2;
                        5h_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
                    }
                    if (this.9() || 5h_0.c.player.inventory.getCurrentItem() != null && 5h_0.c.player.inventory.getCurrentItem().getItem() instanceof ItemEndCrystal) {
                        8r_0.c(this.c, ((Minecraft)5h_0.c).player.getPositionVector().add(0.0, (double)((Minecraft)5h_0.c).player.getEyeHeight(), 0.0), this.9() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, this.c(this.c), true);
                    }
                    if (5h_0.c.player.inventory.currentItem != n3) {
                        5h_0.c.player.inventory.currentItem = n3;
                        5h_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n3));
                    }
                }
                5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.c, (Boolean)this.d.6() != false ? this.c : EnumFacing.UP));
                if (((Boolean)this.b.6()).booleanValue()) {
                    5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.c, (Boolean)this.d.6() != false ? this.c.getOpposite() : EnumFacing.DOWN));
                }
                this.1 = false;
            }
            if (p2.0() || !8L.c()) {
                return;
            }
            if (this.c == null || this.c == null || this.0.c(3500.0) || !((Boolean)this.6.6()).booleanValue()) break block7;
            8k_0.c.c.c(new Vec3d((double)this.c.getX() + 0.5 + (double)this.c.getDirectionVec().getX() * 0.5, (double)this.c.getY() + 0.5 + (double)this.c.getDirectionVec().getY() * 0.5, (double)this.c.getZ() + 0.5 + (double)this.c.getDirectionVec().getZ() * 0.5));
        }
    }

    public boolean 8() {
        return this.1.6() == 5g_0.c;
    }

    public boolean g() {
        return this.1.6() == 5g_0.1;
    }

    @Subscriber
    public void c(08 var1_1) {
        if (((Minecraft)5h_0.c).player == null || ((Minecraft)5h_0.c).world == null) {
            return;
        }
        if (((Boolean)this.5.6()).booleanValue() && 5h_0.c.player.onGround && this.1.6() != 5g_0.1 && var1_1.2().equals((Object)((Minecraft)5h_0.c).player.getPosition().down())) {
            5h_0.c.player.motionY -= 1.0;
        }
        switch (5e_0.c[((5g_0)((Object)this.1.6())).ordinal()]) {
            case 1: {
                var1_1.c(0);
                ((Minecraft)5h_0.c).player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 69, ((Integer)this.4.6()).intValue(), true, false));
                break;
            }
            case 2: {
                IBlockState iBlockState = ((Minecraft)5h_0.c).world.getBlockState(var1_1.2());
                if (iBlockState.getMaterial() == Material.AIR) break;
                var1_1.c(var1_1.1() + iBlockState.getPlayerRelativeBlockHardness((EntityPlayer)((Minecraft)5h_0.c).player, (World)((Minecraft)5h_0.c).world, var1_1.2()) * ((Float)this.3.6()).floatValue());
                var1_1.c(0);
                break;
            }
            case 3: {
                ((Minecraft)5h_0.c).player.swingArm(EnumHand.MAIN_HAND);
                if (!this.0(var1_1.2())) break;
                this.0.c();
                if (this.2.6() == 5f_0.c && var1_1.2().equals((Object)this.c)) {
                    this.1 = 500;
                    5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, var1_1.2(), (Boolean)this.d.6() != false ? var1_1.0() : EnumFacing.UP));
                } else {
                    this.1 = 2000;
                    if (((Boolean)this.a.6()).booleanValue()) {
                        5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, var1_1.2(), (Boolean)this.d.6() != false ? var1_1.0() : EnumFacing.UP));
                        5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, var1_1.2(), (Boolean)this.d.6() != false ? var1_1.0().getOpposite() : EnumFacing.DOWN));
                        if (((Boolean)this.9.6()).booleanValue()) {
                            5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, var1_1.2(), (Boolean)this.d.6() != false ? var1_1.0().getOpposite() : EnumFacing.DOWN));
                        }
                        5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, var1_1.2(), (Boolean)this.d.6() != false ? var1_1.0() : EnumFacing.UP));
                    } else {
                        5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, var1_1.2(), (Boolean)this.d.6() != false ? var1_1.0() : EnumFacing.UP));
                        if (((Boolean)this.9.6()).booleanValue()) {
                            5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, var1_1.2(), (Boolean)this.d.6() != false ? var1_1.0() : EnumFacing.UP));
                        }
                        5h_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, var1_1.2(), (Boolean)this.d.6() != false ? var1_1.0() : EnumFacing.UP));
                    }
                }
                this.c = var1_1.2();
                this.c = var1_1.0();
                var1_1.c(true);
                break;
            }
        }
    }

    public boolean e() {
        return this.1.6() == 5g_0.1 && this.2.6() == 5f_0.0;
    }

    @Subscriber
    public void c(0S s) {
        block1: {
            if (this.1.6() != 5g_0.1) {
                return;
            }
            if (((Boolean)this.7.6()).booleanValue() || this.2.6() != 5f_0.0 || !(s.c() instanceof SPacketBlockChange) || !((SPacketBlockChange)s.c()).getBlockPosition().equals((Object)this.c) || ((SPacketBlockChange)s.c()).getBlockState().getBlock() == Blocks.AIR || !(((Minecraft)5h_0.c).player.getDistance((double)((SPacketBlockChange)s.c()).getBlockPosition().getX() + 0.5, (double)((SPacketBlockChange)s.c()).getBlockPosition().getY() + 0.5, (double)((SPacketBlockChange)s.c()).getBlockPosition().getZ() + 0.5) < 6.0) || ((Boolean)this.8.6()).booleanValue() && ((SPacketBlockChange)s.c()).getBlockState().getBlock().equals(((Minecraft)5h_0.c).world.getBlockState(((SPacketBlockChange)s.c()).getBlockPosition()).getBlock())) break block1;
            this.1 = true;
            this.c.c();
        }
    }

    public boolean 0(BlockPos blockPos) {
        IBlockState iBlockState = ((Minecraft)5h_0.c).world.getBlockState(blockPos);
        return iBlockState.getBlockHardness((World)((Minecraft)5h_0.c).world, blockPos) != -1.0f;
    }

    public boolean b() {
        return this.1.6() == 5g_0.1;
    }

    public boolean h() {
        return this.1.6() == 5g_0.1 && this.2.6() == 5f_0.0;
    }

    public boolean 1() {
        return this.1.6() == 5g_0.1 && this.2.6() == 5f_0.0;
    }
}

