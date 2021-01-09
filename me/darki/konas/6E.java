/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.11;
import me.darki.konas.14;
import me.darki.konas.15;
import me.darki.konas.1N;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.6D;
import me.darki.konas.6i_0;
import me.darki.konas.6u_0;
import me.darki.konas.6y_0;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8j_0;
import me.darki.konas.8k_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import net.minecraft.block.BlockIce;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockPackedIce;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 6E
extends 3E {
    public 8h_0<Double> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Float> 3;
    public 8h_0<6D> 4;
    public 8h_0<Boolean> 5;
    public 8h_0<Boolean> 6;
    public 8h_0<Boolean> 7;
    public 8h_0<Boolean> 8;
    public 8h_0<Boolean> 9;
    public 8h_0<Boolean> a;
    public 8h_0<Boolean> b;
    public 8h_0<Double> d;
    public 8h_0<8f_0> e;
    public 8h_0<6D> f;
    public 8h_0<8j_0> g;
    public int 1;
    public int 2;
    public double c;
    public double 0;
    public double 1;
    public double 2;
    public boolean 1 = false;
    public int 3;
    public double 3;
    public int 4;
    public int 5;
    public int 6;
    public boolean 2 = 0.0;
    public double 4;
    public 9m c = 0.0;
    public 9m 0;
    public int 7;
    public double 5 = 4;
    public boolean 3 = 0.2873;
    public int 8;
    public double 6 = 0;
    public boolean 4 = 0.0;

    @Override
    public boolean 5() {
        return this.c() == 6D.1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean 8() {
        if (this.c() == 6D.3) return true;
        if (this.c() == 6D.c) return true;
        if (this.c() == 6D.5) return true;
        if (this.c() != 6D.0) return false;
        return true;
    }

    @Subscriber
    public void c(1N n2) {
        boolean bl;
        if (6E.c.player == null || 6E.c.world == null) {
            return;
        }
        if (n2.c() == TickEvent.Phase.START && this.c() == 6D.1) {
            double d2 = 6E.c.player.posX - 6E.c.player.prevPosX;
            double d3 = 6E.c.player.posZ - 6E.c.player.prevPosZ;
            this.2 = Math.sqrt(d2 * d2 + d3 * d3);
        }
        if (3F.c(6i_0.class).f() && 6i_0.q()) {
            8k_0.c.c.c(this);
            return;
        }
        int n3 = MathHelper.floor((double)(6E.c.player.getEntityBoundingBox().minY - 0.2));
        boolean bl2 = bl = 6u_0.c(BlockLiquid.class, n3) != null;
        if (3F.c(6u_0.class).f() && (6E.c.player.isInWater() || 6E.c.player.isInLava() || bl)) {
            return;
        }
        this.0(this.c().name().substring(0, 1).toUpperCase() + this.c().name().substring(1).toLowerCase());
        if (((Boolean)this.9.6()).booleanValue() && 6E.c.player.isSneaking()) {
            return;
        }
        if ((this.c() == 6D.5 || this.c() == 6D.c || this.c() == 6D.2) && ((Boolean)this.2.6()).booleanValue()) {
            8k_0.c.c.c(this, 10, 1.08f + 0.008f * ((Float)this.3.6()).floatValue());
        } else if (this.c() != 6D.0 && this.c() != 6D.3) {
            8k_0.c.c.c(this);
        }
        switch (this.c()) {
            case 5: {
                if (3F.c("LongJump").f() && ((Boolean)6y_0.6.6()).booleanValue()) {
                    return;
                }
                if (3F.c("ElytraFly").f()) {
                    return;
                }
                if (((Boolean)this.a.6()).booleanValue() && !6E.c.player.isSprinting() && 8x_0.c()) {
                    6E.c.player.setSprinting(true);
                    6E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6E.c.player, CPacketEntityAction.Action.START_SPRINTING));
                }
                this.c = Math.sqrt((6E.c.player.posX - 6E.c.player.prevPosX) * (6E.c.player.posX - 6E.c.player.prevPosX) + (6E.c.player.posZ - 6E.c.player.prevPosZ) * (6E.c.player.posZ - 6E.c.player.prevPosZ));
                break;
            }
            case 3: {
                if (!8x_0.c() || 6E.c.player.collidedHorizontally) {
                    8k_0.c.c.c(this);
                    return;
                }
                if (6E.c.player.onGround) {
                    8k_0.c.c.c(this, 10, 1.15f);
                    6E.c.player.jump();
                    boolean bl3 = 6E.c.world.getBlockState(new BlockPos(6E.c.player.posX, 6E.c.player.posY - 1.0, 6E.c.player.posZ)).getBlock() instanceof BlockIce || 6E.c.world.getBlockState(new BlockPos(6E.c.player.posX, 6E.c.player.posY - 1.0, 6E.c.player.posZ)).getBlock() instanceof BlockPackedIce;
                    double[] dArray = 8x_0.c(this.2() * (Double)this.1.6() + (((Boolean)this.b.6()).booleanValue() ? (bl3 ? 0.3 : 0.06 * (Double)this.d.6()) : 0.0));
                    6E.c.player.motionX = dArray[0];
                    6E.c.player.motionZ = dArray[1];
                    break;
                }
                6E.c.player.motionY = -1.0;
                8k_0.c.c.c(this);
                break;
            }
        }
        Item item = 6E.c.player.getActiveItemStack().getItem();
        if (this.c() == 6D.0 && ((Boolean)this.7.6()).booleanValue() && this.2 && (!6E.c.player.isHandActive() && item instanceof ItemFood || item instanceof ItemBow || item instanceof ItemPotion || !(item instanceof ItemFood) || !(item instanceof ItemBow) || !(item instanceof ItemPotion))) {
            6E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6E.c.player, CPacketEntityAction.Action.STOP_SNEAKING));
            this.2 = false;
        }
    }

    @Subscriber(priority=1000)
    public void c(1P p2) {
        if (3F.c(6i_0.class).f() && 6i_0.q()) {
            return;
        }
        if (!8x_0.c()) {
            this.1 = 0.0;
            if (this.c() != 6D.3) {
                6E.c.player.motionX = 0.0;
                6E.c.player.motionZ = 0.0;
                return;
            }
        }
        if (this.c() == 6D.c || this.c() == 6D.0 || this.c() == 6D.2) {
            double d2 = 6E.c.player.posX - 6E.c.player.prevPosX;
            double d3 = 6E.c.player.posZ - 6E.c.player.prevPosZ;
            this.2 = Math.sqrt(d2 * d2 + d3 * d3);
        }
    }

    public 6E() {
        super("Speed", 3D.0, new String[0]);
        this.5 = new 8h_0("Bypass", false).c(this::5);
        this.6 = new 8h_0("Hypixel", false).c(this::0);
        this.7 = new 8h_0("AllowEat", false).c(this::7);
        this.8 = new 8h_0("Strict", false).c(this::9);
        this.9 = new 8h_0("DisableOnSneak", false);
        this.a = new 8h_0("ForceSprint", false);
        this.b = new 8h_0("Boost", false).c(this::8);
        this.d = new 8h_0("BoostFactor", 1.0, 10.0, 0.0, 0.1).c(this::6);
        this.e = new 8h_0("Alternative", new 8f_0(false));
        this.f = new 8h_0("AltMode", 6D.1).c(this.e);
        this.g = new 8h_0("AltBind", new 8j_0(0)).c(this.e);
        this.c = new 9m();
        this.0 = new 9m();
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketPlayer) || !this.4) break block0;
            this.4 = false;
            ((ICPacketPlayer)t.c()).setOnGround(true);
        }
    }

    public 6D c() {
        if (8x_0.c(((8j_0)this.g.6()).c())) {
            return (6D)((Object)this.f.6());
        }
        return (6D)((Object)this.4.6());
    }

    public double c(double d2, int n2) {
        BigDecimal bigDecimal = new BigDecimal(d2);
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    @Override
    public void 7() {
        if (6E.c.player == null || 6E.c.world == null) {
            return;
        }
        if (this.c() == 6D.3) {
            6E.c.player.setVelocity(0.0, 0.0, 0.0);
        }
        8k_0.c.c.c(this);
    }

    public boolean 9() {
        return this.c() == 6D.c;
    }

    @Subscriber
    public void c(11 var1_1) {
        boolean bl;
        if (6E.c.player == null || 6E.c.world == null) {
            return;
        }
        if (((Boolean)this.9.6()).booleanValue() && 6E.c.player.isSneaking()) {
            return;
        }
        if (3F.c(6i_0.class).f() && 6i_0.q()) {
            return;
        }
        int n2 = MathHelper.floor((double)(6E.c.player.getEntityBoundingBox().minY - 0.2));
        boolean bl2 = bl = 6u_0.c(BlockLiquid.class, n2) != null;
        if (3F.c(6u_0.class).f() && (6E.c.player.isInWater() || 6E.c.player.isInLava() || bl)) {
            return;
        }
        switch (this.c()) {
            case c: {
                if (this.3 != 1 || 6E.c.player.moveForward == 0.0f || 6E.c.player.moveStrafing == 0.0f) {
                    if (this.3 == 2 && (6E.c.player.moveForward != 0.0f || 6E.c.player.moveStrafing != 0.0f)) {
                        double d2 = 0.0;
                        if (6E.c.player.isPotionActive(MobEffects.JUMP_BOOST)) {
                            d2 += (double)((float)(6E.c.player.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1f);
                        }
                        6E.c.player.motionY = ((Boolean)this.6.6() != false ? 0.3999999463558197 : 0.3999) + d2;
                        var1_1.0(6E.c.player.motionY);
                        this.1 *= this.1 ? 1.6835 : 1.395;
                    } else if (this.3 == 3) {
                        double d3 = 0.66 * (this.2 - this.2());
                        this.1 = this.2 - d3;
                        this.1 = !this.1;
                    } else {
                        List list = 6E.c.world.getCollisionBoxes((Entity)6E.c.player, 6E.c.player.getEntityBoundingBox().offset(0.0, 6E.c.player.motionY, 0.0));
                        if (list.size() > 0 || 6E.c.player.collidedVertically) {
                            if (this.3 > 0) {
                                this.3 = 6E.c.player.moveForward == 0.0f && 6E.c.player.moveStrafing == 0.0f ? 0 : 1;
                            }
                        }
                        this.1 = this.2 - this.2 / 159.0;
                    }
                } else {
                    this.1 = 1.35 * this.2() - 0.01;
                }
                this.1 = Math.max(this.1, this.2());
                if (this.4 > 0.0 && ((Boolean)this.b.6()).booleanValue() && !this.c.c(75.0) && !6E.c.player.collidedHorizontally) {
                    this.1 = Math.max(this.1, this.4);
                } else if (((Boolean)this.8.6()).booleanValue()) {
                    this.1 = Math.min(this.1, 0.433);
                }
                double d4 = 6E.c.player.movementInput.moveForward;
                double d5 = 6E.c.player.movementInput.moveStrafe;
                float f2 = 6E.c.player.rotationYaw;
                if (d4 == 0.0 && d5 == 0.0) {
                    var1_1.1(0.0);
                    var1_1.c(0.0);
                } else {
                    if (d4 != 0.0) {
                        if (d5 > 0.0) {
                            f2 += (float)(d4 > 0.0 ? -45 : 45);
                        } else if (d5 < 0.0) {
                            f2 += (float)(d4 > 0.0 ? 45 : -45);
                        }
                        d5 = 0.0;
                        if (d4 > 0.0) {
                            d4 = 1.0;
                        } else if (d4 < 0.0) {
                            d4 = -1.0;
                        }
                    }
                    var1_1.1(d4 * this.1 * Math.cos(Math.toRadians(f2 + 90.0f)) + d5 * this.1 * Math.sin(Math.toRadians(f2 + 90.0f)));
                    var1_1.c(d4 * this.1 * Math.sin(Math.toRadians(f2 + 90.0f)) - d5 * this.1 * Math.cos(Math.toRadians(f2 + 90.0f)));
                }
                if (6E.c.player.moveForward == 0.0f && 6E.c.player.moveStrafing == 0.0f) {
                    return;
                }
                ++this.3;
                break;
            }
            case 5: {
                if (this.c() == 6D.5 && 3F.c("LongJump").f() && ((Boolean)6y_0.6.6()).booleanValue()) {
                    return;
                }
                if (this.c() == 6D.5 && 3F.c("ElytraFly").f()) {
                    return;
                }
                if (!6E.c.player.isSprinting()) {
                    6E.c.player.setSprinting(true);
                    6E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6E.c.player, CPacketEntityAction.Action.START_SPRINTING));
                }
                double d6 = (Double)this.1.6() * 0.99;
                switch (this.1) {
                    case 0: {
                        ++this.1;
                        this.c = 0.0;
                        break;
                    }
                    case 2: {
                        double d7;
                        double d8 = d7 = (Boolean)this.6.6() != false ? 0.3999999463558197 : 0.40123128;
                        if (6E.c.player.moveForward == 0.0f && 6E.c.player.moveStrafing == 0.0f || !6E.c.player.onGround) break;
                        6E.c.player.motionY = d7;
                        var1_1.0(6E.c.player.motionY);
                        this.0 *= 2.149;
                        break;
                    }
                    case 3: {
                        this.0 = this.c - 0.76 * (this.c - this.2());
                        break;
                    }
                    default: {
                        this.0 = this.c - this.c / 159.0;
                        if (6E.c.world.getCollisionBoxes((Entity)6E.c.player, 6E.c.player.getEntityBoundingBox().offset(0.0, 6E.c.player.motionY, 0.0)).size() <= 0) {
                            if (!6E.c.player.collidedVertically) break;
                        }
                        if (this.1 <= 0) break;
                        this.1 = 6E.c.player.moveForward != 0.0f || 6E.c.player.moveStrafing != 0.0f ? 1 : 0;
                        break;
                    }
                }
                this.0 = Math.max(this.0, this.2());
                if (this.4 > 0.0 && ((Boolean)this.b.6()).booleanValue() && !this.c.c(75.0) && !6E.c.player.collidedHorizontally) {
                    this.0 = Math.max(this.0, this.4);
                }
                float f3 = 6E.c.player.movementInput.moveForward;
                float f4 = 6E.c.player.movementInput.moveStrafe;
                if (f3 == 0.0f && f4 == 0.0f) {
                    var1_1.1(0.0);
                    var1_1.c(0.0);
                } else if ((double)f3 != 0.0 && (double)f4 != 0.0) {
                    f3 = (float)((double)f3 * Math.sin(0.7853981633974483));
                    f4 = (float)((double)f4 * Math.cos(0.7853981633974483));
                }
                var1_1.1(((double)f3 * this.0 * -Math.sin(Math.toRadians(6E.c.player.rotationYaw)) + (double)f4 * this.0 * Math.cos(Math.toRadians(6E.c.player.rotationYaw))) * d6);
                var1_1.c(((double)f3 * this.0 * Math.cos(Math.toRadians(6E.c.player.rotationYaw)) - (double)f4 * this.0 * -Math.sin(Math.toRadians(6E.c.player.rotationYaw))) * d6);
                ++this.1;
                break;
            }
            case 0: {
                ++this.4;
                this.4 %= 5;
                if (this.4 != 0) {
                    8k_0.c.c.c(this);
                } else if (8x_0.c()) {
                    8k_0.c.c.c(this, 10, 1.3f);
                    6E.c.player.motionX *= (double)1.02f;
                    6E.c.player.motionZ *= (double)1.02f;
                }
                if (6E.c.player.onGround && 8x_0.c()) {
                    this.5 = 2;
                }
                if (this.c(6E.c.player.posY - (double)((int)6E.c.player.posY), 3) == this.c(0.138, 3)) {
                    6E.c.player.motionY -= 0.08;
                    var1_1.0(var1_1.0() - 0.09316090325960147);
                    6E.c.player.posY -= 0.09316090325960147;
                }
                if (this.5 == 1 && (6E.c.player.moveForward != 0.0f || 6E.c.player.moveStrafing != 0.0f)) {
                    this.5 = 2;
                    this.3 = 1.38 * this.2() - 0.01;
                } else if (this.5 == 2) {
                    this.5 = 3;
                    6E.c.player.motionY = 0.3994f;
                    var1_1.0(0.3994f);
                    this.3 *= 2.149;
                } else if (this.5 == 3) {
                    this.5 = 4;
                    double d9 = 0.66 * (this.2 - this.2());
                    this.3 = this.2 - d9;
                } else {
                    if (6E.c.world.getCollisionBoxes((Entity)6E.c.player, 6E.c.player.getEntityBoundingBox().offset(0.0, 6E.c.player.motionY, 0.0)).size() > 0 || 6E.c.player.collidedVertically) {
                        this.5 = 1;
                    }
                    this.3 = this.2 - this.2 / 159.0;
                }
                this.3 = Math.max(this.3, this.2());
                this.3 = this.4 > 0.0 && (Boolean)this.b.6() != false && !this.c.c(75.0) && !6E.c.player.collidedHorizontally ? Math.max(this.3, this.4) : Math.min(this.3, this.6 > 25 ? 0.449 : 0.433);
                float f5 = 6E.c.player.movementInput.moveForward;
                float f6 = 6E.c.player.movementInput.moveStrafe;
                float f7 = 6E.c.player.rotationYaw;
                ++this.6;
                if (this.6 > 50) {
                    this.6 = 0;
                }
                if (f5 == 0.0f && f6 == 0.0f) {
                    var1_1.1(0.0);
                    var1_1.c(0.0);
                } else if (f5 != 0.0f) {
                    if (f6 >= 1.0f) {
                        f7 += (float)(f5 > 0.0f ? -45 : 45);
                        f6 = 0.0f;
                    } else if (f6 <= -1.0f) {
                        f7 += (float)(f5 > 0.0f ? 45 : -45);
                        f6 = 0.0f;
                    }
                    if (f5 > 0.0f) {
                        f5 = 1.0f;
                    } else if (f5 < 0.0f) {
                        f5 = -1.0f;
                    }
                }
                double d10 = Math.cos(Math.toRadians(f7 + 90.0f));
                double d11 = Math.sin(Math.toRadians(f7 + 90.0f));
                var1_1.1((double)f5 * this.3 * d10 + (double)f6 * this.3 * d11);
                var1_1.c((double)f5 * this.3 * d11 - (double)f6 * this.3 * d10);
                if (f5 != 0.0f || f6 != 0.0f) break;
                var1_1.1(0.0);
                var1_1.c(0.0);
                break;
            }
            case 2: {
                if (!this.0.c(100.0)) {
                    return;
                }
                double d12 = 0.0;
                if (6E.c.player.isPotionActive(MobEffects.JUMP_BOOST)) {
                    d12 += (double)((float)(6E.c.player.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1f);
                }
                if (this.c(6E.c.player.posY - (double)((int)6E.c.player.posY), 3) == this.c(0.4, 3)) {
                    6E.c.player.motionY = 0.31 + d12;
                    var1_1.0(6E.c.player.motionY);
                } else if (this.c(6E.c.player.posY - (double)((int)6E.c.player.posY), 3) == this.c(0.71, 3)) {
                    6E.c.player.motionY = 0.04 + d12;
                    var1_1.0(6E.c.player.motionY);
                } else if (this.c(6E.c.player.posY - (double)((int)6E.c.player.posY), 3) == this.c(0.75, 3)) {
                    6E.c.player.motionY = -0.2 - d12;
                    var1_1.0(6E.c.player.motionY);
                } else if (this.c(6E.c.player.posY - (double)((int)6E.c.player.posY), 3) == this.c(0.55, 3)) {
                    6E.c.player.motionY = -0.14 + d12;
                    var1_1.0(6E.c.player.motionY);
                } else if (this.c(6E.c.player.posY - (double)((int)6E.c.player.posY), 3) == this.c(0.41, 3)) {
                    6E.c.player.motionY = -0.2 + d12;
                    var1_1.0(6E.c.player.motionY);
                }
                if (this.7 == 1 && (6E.c.player.moveForward != 0.0f || 6E.c.player.moveStrafing != 0.0f)) {
                    this.5 = 1.35 * this.2() - 0.01;
                } else if (this.7 == 2 && (6E.c.player.moveForward != 0.0f || 6E.c.player.moveStrafing != 0.0f)) {
                    6E.c.player.motionY = (this.1() ? 0.2 : 0.3999) + d12;
                    var1_1.0(6E.c.player.motionY);
                    this.5 *= this.3 ? 1.5685 : 1.3445;
                } else if (this.7 == 3) {
                    double d13 = 0.66 * (this.2 - this.2());
                    this.5 = this.2 - d13;
                    this.3 = !this.3;
                } else {
                    if (6E.c.player.onGround && this.7 > 0) {
                        this.7 = 6E.c.player.moveForward != 0.0f || 6E.c.player.moveStrafing != 0.0f ? 1 : 0;
                    }
                    this.5 = this.2 - this.2 / 159.0;
                }
                this.5 = Math.max(this.5, this.2());
                float f8 = 6E.c.player.movementInput.moveForward;
                float f9 = 6E.c.player.movementInput.moveStrafe;
                if (f8 == 0.0f && f9 == 0.0f) {
                    var1_1.1(0.0);
                    var1_1.c(0.0);
                } else if ((double)f8 != 0.0 && (double)f9 != 0.0) {
                    f8 = (float)((double)f8 * Math.sin(0.7853981633974483));
                    f9 = (float)((double)f9 * Math.cos(0.7853981633974483));
                }
                var1_1.1((double)f8 * this.5 * -Math.sin(Math.toRadians(6E.c.player.rotationYaw)) + (double)f9 * this.5 * Math.cos(Math.toRadians(6E.c.player.rotationYaw)));
                var1_1.c((double)f8 * this.5 * Math.cos(Math.toRadians(6E.c.player.rotationYaw)) - (double)f9 * this.5 * -Math.sin(Math.toRadians(6E.c.player.rotationYaw)));
                if (6E.c.player.moveForward == 0.0f && 6E.c.player.moveStrafing == 0.0f) {
                    return;
                }
                ++this.7;
                break;
            }
            case 1: {
                if (!6E.c.player.onGround && this.8 != 3) {
                    return;
                }
                if (!6E.c.player.collidedHorizontally && 6E.c.player.moveForward != 0.0f || 6E.c.player.moveStrafing != 0.0f) {
                    if (this.8 == 2) {
                        6E.c.player.motionY = -0.5;
                        var1_1.0(this.1() ? 0.2 : 0.4);
                        this.6 *= 2.149;
                        this.8 = 3;
                        if (((Boolean)this.5.6()).booleanValue()) {
                            this.4 = true;
                        }
                    } else if (this.8 == 3) {
                        double d14 = 0.66 * (this.2 - this.2());
                        this.6 = this.2 - d14;
                        this.8 = 2;
                    } else if (this.1() || 6E.c.player.collidedVertically) {
                        this.8 = 1;
                    }
                }
                this.6 = Math.min(Math.max(this.6, this.2()), (Double)this.1.6());
                float f10 = 6E.c.player.movementInput.moveForward;
                float f11 = 6E.c.player.movementInput.moveStrafe;
                if (f10 == 0.0f && f11 == 0.0f) {
                    var1_1.1(0.0);
                    var1_1.c(0.0);
                } else if ((double)f10 != 0.0 && (double)f11 != 0.0) {
                    f10 = (float)((double)f10 * Math.sin(0.7853981633974483));
                    f11 = (float)((double)f11 * Math.cos(0.7853981633974483));
                }
                var1_1.1((double)f10 * this.6 * -Math.sin(Math.toRadians(6E.c.player.rotationYaw)) + (double)f11 * this.6 * Math.cos(Math.toRadians(6E.c.player.rotationYaw)));
                var1_1.c((double)f10 * this.6 * Math.cos(Math.toRadians(6E.c.player.rotationYaw)) - (double)f11 * this.6 * -Math.sin(Math.toRadians(6E.c.player.rotationYaw)));
                break;
            }
        }
    }

    @Override
    public void c() {
        if (6E.c.player == null || 6E.c.world == null) {
            this.d();
            return;
        }
        this.4 = 0.0;
        this.2 = 1;
        this.7 = 4;
        this.8 = 2;
        if (this.c() == 6D.5 && 3F.c("LongJump").f() && ((Boolean)6y_0.6.6()).booleanValue()) {
            return;
        }
        switch (this.c()) {
            case 5: {
                if (!6E.c.player.isSprinting() && 8x_0.c()) {
                    6E.c.player.setSprinting(true);
                    6E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6E.c.player, CPacketEntityAction.Action.START_SPRINTING));
                }
            }
            case c: {
                this.3 = 4;
                this.1 = this.2();
                this.2 = 0.0;
            }
        }
    }

    public boolean 7() {
        return this.c() == 6D.0;
    }

    public boolean 6() {
        return this.c() == 6D.3 && (Boolean)this.b.6() != false;
    }

    @Subscriber
    public void c(14 var1_1) {
        if (6E.c.player == null || 6E.c.world == null) {
            return;
        }
        if (3F.c(6i_0.class).f() && 6i_0.q()) {
            return;
        }
        switch (this.c()) {
            case 4: {
                for (double d2 = 0.0625; d2 < (Double)this.1.6(); d2 += 0.262) {
                    double[] dArray = 8x_0.c(d2);
                    6E.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(6E.c.player.posX + dArray[0], 6E.c.player.posY, 6E.c.player.posZ + dArray[1], 6E.c.player.onGround));
                }
                6E.c.player.connection.sendPacket((Packet)new CPacketPlayer.Position(6E.c.player.posX + 6E.c.player.motionX, 6E.c.player.posY <= 10.0 ? 255.0 : 1.0, 6E.c.player.posZ + 6E.c.player.motionZ, 6E.c.player.onGround));
                break;
            }
        }
    }

    public boolean 1() {
        return 6E.c.world.getCollisionBoxes((Entity)6E.c.player, 6E.c.player.getEntityBoundingBox().offset(0.0, 0.21, 0.0)).size() > 0;
    }

    @Subscriber
    public void c(15 var1_1) {
        if (!this.2 && this.c() == 6D.0 && ((Boolean)this.7.6()).booleanValue()) {
            6E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6E.c.player, CPacketEntityAction.Action.START_SNEAKING));
            this.2 = true;
        }
    }

    public boolean 0() {
        return this.c() == 6D.5;
    }

    @Subscriber(priority=69)
    public void c(0S s) {
        block2: {
            block1: {
                if (3F.c(6i_0.class).f() && 6i_0.q()) {
                    return;
                }
                if (!(s.c() instanceof SPacketPlayerPosLook)) break block1;
                8k_0.c.c.c(this);
                this.c = 0.0;
                this.1 = 0.0;
                this.0 = 0.0;
                this.3 = 4;
                this.3 = 0.2873;
                this.5 = 4;
                this.2 = 0.0;
                this.4 = 0;
                this.4 = 0.0;
                this.0.c();
                this.7 = 4;
                this.8 = 2;
                this.6 = 0.0;
                break block2;
            }
            if (!(s.c() instanceof SPacketExplosion)) break block2;
            SPacketExplosion sPacketExplosion = (SPacketExplosion)s.c();
            this.4 = Math.sqrt(sPacketExplosion.getMotionX() * sPacketExplosion.getMotionX() + sPacketExplosion.getMotionZ() * sPacketExplosion.getMotionZ());
            this.c.c();
        }
    }

    public double 2() {
        double d2;
        double d3 = d2 = this.c() == 6D.c || this.c() == 6D.0 || this.c() == 6D.3 || this.c() == 6D.1 || this.c() == 6D.2 ? 0.2873 : 0.272;
        if (6E.c.player.isPotionActive(MobEffects.SPEED)) {
            int n2 = 6E.c.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d2 *= 1.0 + 0.2 * ((double)n2 + 1.0);
        }
        return d2;
    }
}

