/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.11;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6o_0;
import me.darki.konas.6p_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import me.darki.konas.util.math.Interpolation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.6q
 */
public class 6q_0
extends 3E {
    public 8h_0<Boolean> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Float> 3;
    public 8h_0<Float> 4;
    public 8h_0<Float> 5;
    public 8h_0<Float> 6;
    public 8h_0<Float> 7;
    public 8h_0<Float> 8;
    public 8h_0<6p_0> 9;
    public 8h_0<Float> a;
    public 8h_0<Integer> b;
    public 8h_0<Integer> d;
    public 8h_0<6o_0> e;
    public 8h_0<Integer> f;
    public 8h_0<Integer> g;
    public 8h_0<Boolean> h;
    public 8h_0<Boolean> i;
    public 8h_0<Boolean> j;
    public 9m c;
    public long c = -1L;
    public int 1 = 0;
    public int 2 = 0;
    public int 3 = 0;
    public int 4 = 0;

    public boolean 0() {
        return this.9.6() == 6p_0.1;
    }

    @Override
    public void c() {
        this.c = System.currentTimeMillis();
        this.1 = 0;
    }

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketPlayerPosLook) {
            this.c.c();
            this.c = System.currentTimeMillis();
        }
    }

    public boolean c() {
        return this.e.6() != 6o_0.c;
    }

    @Subscriber
    public void c(11 var1_1) {
        AxisAlignedBB axisAlignedBB;
        if (!this.c.c(350.0)) {
            return;
        }
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB = ((Minecraft)6q_0.c).player.getRidingEntity() != null ? ((Minecraft)6q_0.c).player.getRidingEntity().getEntityBoundingBox() : ((Minecraft)6q_0.c).player.getEntityBoundingBox();
        if (axisAlignedBB != null) {
            int n2 = (int)axisAlignedBB.minY;
            for (int i2 = MathHelper.floor((double)axisAlignedBB.minX); i2 < MathHelper.floor((double)axisAlignedBB.maxX) + 1; ++i2) {
                for (int i3 = MathHelper.floor((double)axisAlignedBB.minZ); i3 < MathHelper.floor((double)axisAlignedBB.maxZ) + 1; ++i3) {
                    Block block = ((Minecraft)6q_0.c).world.getBlockState(new BlockPos(i2, n2, i3)).getBlock();
                    if (block instanceof BlockAir && !((Boolean)this.h.6()).booleanValue()) {
                        return;
                    }
                    if (!(block != Blocks.LAVA && block != Blocks.FLOWING_LAVA || ((Boolean)this.j.6()).booleanValue())) {
                        return;
                    }
                    if (block != Blocks.WATER && block != Blocks.FLOWING_WATER || ((Boolean)this.i.6()).booleanValue()) continue;
                    return;
                }
            }
        }
        double d2 = Interpolation.lerp(0.0, (double)((Float)this.5.6()).floatValue() * 0.2625, Math.min(1.0f, (float)(System.currentTimeMillis() - this.c) / (1000.0f * ((Float)this.3.6()).floatValue())));
        double d3 = Interpolation.lerp(0.0, (double)((Float)this.6.6()).floatValue() * 0.4, Math.min(1.0f, (float)(System.currentTimeMillis() - this.c) / (1000.0f * ((Float)this.4.6()).floatValue())));
        boolean bl = true;
        if (this.e.6() != 6o_0.c) {
            if (this.3 < (Integer)this.f.6()) {
                ++this.3;
            } else {
                ++this.4;
                if (this.4 >= (Integer)this.g.6()) {
                    this.3 = 0;
                }
                if (this.e.6() == 6o_0.0) {
                    d2 = 0.0;
                    bl = false;
                } else {
                    return;
                }
            }
        }
        double d4 = Math.sqrt(d2 * d2 + d3 * d3);
        if (this.1 < (Integer)this.b.6()) {
            ++this.1;
            this.2 = 0;
        }
        if (this.9.6() == 6p_0.0 || this.1 >= (Integer)this.b.6() && this.9.6() == 6p_0.1) {
            var1_1.0((double)(-((Float)this.a.6()).floatValue()) * 0.01);
            ++this.2;
            if (this.2 >= (Integer)this.d.6()) {
                this.1 = 0;
            }
        }
        if (6q_0.c.gameSettings.keyBindJump.isKeyDown() && bl) {
            var1_1.0(d3 * (double)((Float)this.7.6()).floatValue());
        } else if (6q_0.c.gameSettings.keyBindSneak.isKeyDown()) {
            var1_1.0(-d3);
        }
        if (d4 > (double)((Float)this.8.6()).floatValue() * 0.6625) {
            d2 = Math.min((double)((Float)this.5.6()).floatValue() * 0.2625, Math.sqrt(d4 * d4 - var1_1.0() * var1_1.0()));
        }
        double d5 = 6q_0.c.player.movementInput.moveForward;
        double d6 = 6q_0.c.player.movementInput.moveStrafe;
        float f2 = 6q_0.c.player.rotationYaw;
        if (d5 == 0.0 && d6 == 0.0) {
            var1_1.1(0.0);
            var1_1.c(0.0);
            this.c = System.currentTimeMillis();
        } else {
            if (d5 != 0.0) {
                if (d6 > 0.0) {
                    f2 += (float)(d5 > 0.0 ? -45 : 45);
                } else if (d6 < 0.0) {
                    f2 += (float)(d5 > 0.0 ? 45 : -45);
                }
                d6 = 0.0;
                if (d5 > 0.0) {
                    d5 = 1.0;
                } else if (d5 < 0.0) {
                    d5 = -1.0;
                }
            }
            var1_1.1(d5 * d2 * Math.cos(Math.toRadians(f2 + 90.0f)) + d6 * d2 * Math.sin(Math.toRadians(f2 + 90.0f)));
            var1_1.c(d5 * d2 * Math.sin(Math.toRadians(f2 + 90.0f)) - d6 * d2 * Math.cos(Math.toRadians(f2 + 90.0f)));
        }
    }

    @Override
    public boolean 5() {
        return this.9.6() != 6p_0.c;
    }

    public 6q_0() {
        super("Flight", 3D.0, "CreativeFly");
        this.5 = new 8h_0("Speed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
        this.6 = new 8h_0("VSpeed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
        this.7 = new 8h_0("UpFactor", Float.valueOf(0.5f), Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
        this.8 = new 8h_0("MaxSpeed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
        this.9 = new 8h_0("Glide", 6p_0.0);
        this.a = new 8h_0("GlideSpeed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(this::5);
        this.b = new 8h_0("GlideInterval", 3, 20, 1, 1).c(this::0);
        this.d = new 8h_0("GlideTicks", 1, 5, 1, 1).c(this::1);
        this.e = new 8h_0("AntiKick", 6o_0.c);
        this.f = new 8h_0("AntiKickInterval", 2, 20, 1, 1).c(this::c);
        this.g = new 8h_0("AntiKickTicks", 1, 5, 1, 1).c(this::6);
        this.h = new 8h_0("InAir", true);
        this.i = new 8h_0("InWater", true);
        this.j = new 8h_0("InLava", true);
        this.c = new 9m();
    }

    public boolean 1() {
        return this.9.6() == 6p_0.1;
    }

    public boolean 6() {
        return this.9.6() == 6p_0.1;
    }

    @Override
    public void 7() {
        8k_0.c.c.c(this);
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketPlayer) || !((Boolean)this.1.6()).booleanValue()) break block0;
            ((ICPacketPlayer)t.c()).setOnGround(true);
        }
    }

    @Subscriber
    public void c(1N n2) {
        if (((Boolean)this.2.6()).booleanValue()) {
            8k_0.c.c.c(this, 10, 1.088f);
        } else {
            8k_0.c.c.c(this);
        }
    }
}

