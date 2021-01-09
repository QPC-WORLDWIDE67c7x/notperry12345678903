/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Random;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.0f_0;
import me.darki.konas.11;
import me.darki.konas.1N;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6g_0;
import me.darki.konas.6h_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.server.SPacketEntityMetadata;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.6i
 */
public class 6i_0
extends 3E {
    public static 8h_0<6g_0> 1 = new 8h_0("Mode", 6g_0.0);
    public static 8h_0<Float> 2 = new 8h_0("Limit", Float.valueOf(1.0f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(6i_0::h);
    public static 8h_0<Float> 3 = new 8h_0("Delay", Float.valueOf(5.0f), Float.valueOf(20.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(6i_0::r);
    public static 8h_0<Float> 4 = new 8h_0("Timeout", Float.valueOf(0.5f), Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(6i_0::i);
    public static 8h_0<Boolean> 5 = new 8h_0("StopMotion", true).c(6i_0::w);
    public static 8h_0<Boolean> 6 = new 8h_0("Freeze", false).c(6i_0::b);
    public static 8h_0<Boolean> 7 = new 8h_0("Better", true).c(6i_0::u);
    public static 8h_0<Boolean> 8 = new 8h_0("CruiseControl", false).c(6i_0::8);
    public static 8h_0<Double> 9 = new 8h_0("MinUpSpeed", 0.5, 5.0, 0.1, 0.05).c(6i_0::e);
    public static 8h_0<Boolean> a = new 8h_0("AutoSwitch", false).c(6i_0::j);
    public static 8h_0<Float> b = new 8h_0("Factor", Float.valueOf(1.5f), Float.valueOf(50.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<Integer> d = new 8h_0("MinSpeed", 20, 50, 1, 1).c(6i_0::7);
    public static 8h_0<Float> e = new 8h_0("UpFactor", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f));
    public static 8h_0<Float> f = new 8h_0("DownFactor", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> g = new 8h_0("ForceHeight", false).c(6i_0::n);
    public static 8h_0<Integer> h = new 8h_0("Height", 121, 256, 1, 1).c(6i_0::l);
    public static 8h_0<Boolean> i = new 8h_0("GroundSafety", false).c(6i_0::t);
    public static 8h_0<Float> j = new 8h_0("TriggerHeight", Float.valueOf(0.3f), Float.valueOf(1.0f), Float.valueOf(0.05f), Float.valueOf(0.05f)).c(6i_0::k);
    public static 8h_0<Float> k = new 8h_0("Speed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(6i_0::p);
    public static 8h_0<Float> l = new 8h_0("DownSpeed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(6i_0::m);
    public static 8h_0<Boolean> m = new 8h_0("InstantFly", true).c(6i_0::9);
    public static 8h_0<Boolean> n = new 8h_0("Timer", true).c(6i_0::1);
    public static 8h_0<Boolean> o = new 8h_0("SpeedLimit", true).c(6i_0::0);
    public static 8h_0<Float> p = new 8h_0("MaxSpeed", Float.valueOf(2.5f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(6i_0::g);
    public static 8h_0<Boolean> q = new 8h_0("NoDrag", false).c(6i_0::v);
    public static 8h_0<Boolean> r = new 8h_0("Accelerate", true).c(6i_0::o);
    public static 8h_0<Float> s = new 8h_0("Acceleration", Float.valueOf(1.0f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(6i_0::6);
    public static 8h_0<6h_0> t = new 8h_0("Strict", 6h_0.c).c(6i_0::s);
    public static 8h_0<Boolean> u = new 8h_0("AntiKick", true).c(6i_0::c);
    public static 8h_0<Boolean> v = new 8h_0("InfDurability", true).c(6i_0::d);
    public static boolean 1 = false;
    public boolean 2;
    public double c;
    public double 0;
    public double 1;
    public Random c;
    public 9m c = new 9m();
    public 9m 0 = new 9m();
    public 9m 1 = new 9m();
    public 9m 2 = new 9m();
    public boolean 3 = false;
    public boolean 4 = false;

    @Subscriber
    public void c(1N n2) {
        if (6i_0.c.world == null || 6i_0.c.player == null) {
            return;
        }
        if (n2.c() != TickEvent.Phase.START) {
            return;
        }
        if (6i_0.c.player.onGround) {
            this.4 = true;
        }
        if (!((Boolean)8.6()).booleanValue()) {
            this.1 = 6i_0.c.player.posY;
        }
        for (ItemStack itemStack : 6i_0.c.player.getArmorInventoryList()) {
            if (itemStack.getItem() instanceof ItemElytra) {
                1 = true;
                break;
            }
            1 = false;
        }
        if (this.2.c(1500.0) && !this.2.c(2000.0)) {
            8k_0.c.c.c(this);
        }
        if (!6i_0.c.player.isElytraFlying() && 1.6() != 6g_0.2) {
            if (this.4 && n.6() != n.6() && !6i_0.c.player.onGround) {
                8k_0.c.c.c(this, 25, 0.3f);
            }
            if (!6i_0.c.player.onGround && ((Boolean)m.6()).booleanValue() && 6i_0.c.player.motionY < 0.0) {
                if (!this.c.c(1000.0f * ((Float)4.6()).floatValue())) {
                    return;
                }
                this.c.c();
                6i_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6i_0.c.player, CPacketEntityAction.Action.START_FALL_FLYING));
                this.4 = false;
                this.2.c();
            }
            return;
        }
    }

    @Subscriber
    public void c(0S s) {
        block6: {
            SPacketEntityMetadata sPacketEntityMetadata;
            block5: {
                if (6i_0.c.player == null || 6i_0.c.world == null) {
                    return;
                }
                if (!(s.c() instanceof SPacketPlayerPosLook)) break block5;
                if (1.6() != 6g_0.2 && 1.6() != 6g_0.1) break block6;
                if (6i_0.c.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == Items.ELYTRA) {
                    this.2 = true;
                }
                if (6i_0.c.player.isElytraFlying()) {
                    this.1.c();
                    if (6i_0.c.player != null) {
                        this.1 = 6i_0.c.player.posY;
                    }
                }
                break block6;
            }
            if (!(s.c() instanceof SPacketEntityMetadata) || (sPacketEntityMetadata = (SPacketEntityMetadata)s.c()).getEntityId() != 6i_0.c.player.getEntityId()) break block6;
            8k_0.c.c.c(this);
            if (1.6() == 6g_0.2) {
                s.c();
            }
        }
    }

    public static boolean t() {
        return 1.6() == 6g_0.1;
    }

    public static boolean e() {
        return 1.6() == 6g_0.c && (Boolean)8.6() != false;
    }

    public 6i_0() {
        super("ElytraFly", 3D.0, "ElytraPlus");
    }

    @Subscriber
    public void 0(1N n2) {
        block13: {
            Block block;
            boolean bl;
            double d2;
            if (n2.c() != TickEvent.Phase.START) {
                return;
            }
            if (6i_0.c.player == null) {
                return;
            }
            if (!6i_0.c.player.isElytraFlying()) {
                return;
            }
            if (1.6() != 6g_0.1) {
                return;
            }
            if (6i_0.c.gameSettings.keyBindJump.isKeyDown()) {
                this.1 += (double)((Float)e.6()).floatValue() * 0.5;
            } else if (6i_0.c.gameSettings.keyBindSneak.isKeyDown()) {
                this.1 -= (double)((Float)f.6()).floatValue() * 0.5;
            }
            if (((Boolean)g.6()).booleanValue()) {
                this.1 = ((Integer)h.6()).intValue();
            }
            Vec3d vec3d = new Vec3d(6i_0.c.player.motionX, 6i_0.c.player.motionY, 6i_0.c.player.motionZ);
            double d3 = vec3d.length() * 20.0;
            double d4 = Math.sqrt(6i_0.c.player.motionX * 6i_0.c.player.motionX + 6i_0.c.player.motionZ * 6i_0.c.player.motionZ);
            double d5 = MathHelper.clamp((double)(d4 / 1.7), (double)0.0, (double)1.0);
            double d6 = 1.0 - Math.sqrt(d5);
            double d7 = 0.6;
            if (d5 >= 0.5 || 6i_0.c.player.posY > this.1 + 1.0) {
                d2 = -((45.0 - d7) * d6 + d7);
                double d8 = (this.1 + 1.0 - 6i_0.c.player.posY) * 2.0;
                double d9 = MathHelper.clamp((double)Math.abs(d8), (double)0.0, (double)1.0);
                double d10 = -Math.toDegrees(Math.atan2(Math.abs(d8), d4 * 30.0)) * Math.signum(d8);
                double d11 = (d10 - d2) * d9;
                6i_0.c.player.rotationPitch = (float)d2;
                6i_0.c.player.rotationPitch += (float)d11;
                6i_0.c.player.prevRotationPitch = 6i_0.c.player.rotationPitch;
            }
            if (!this.1.c(1000.0f * ((Float)b.6()).floatValue())) break block13;
            d2 = this.1 - 6i_0.c.player.posY;
            boolean bl2 = bl = d2 > 0.25 && d2 < 1.0 || d3 < (double)((Integer)d.6()).intValue();
            if (((Boolean)i.6()).booleanValue() && (block = 6i_0.c.world.getBlockState(new BlockPos((Entity)6i_0.c.player).down()).getBlock()) != Blocks.AIR && !(block instanceof BlockLiquid) && 6i_0.c.player.getEntityBoundingBox().minY - Math.floor(6i_0.c.player.getEntityBoundingBox().minY) > (double)((Float)j.6()).floatValue()) {
                bl = true;
            }
            if (((Boolean)a.6()).booleanValue() && bl && 6i_0.c.player.getHeldItemMainhand().getItem() != Items.FIREWORKS) {
                for (int i2 = 0; i2 < 9; ++i2) {
                    if (6i_0.c.player.inventory.getStackInSlot(i2).getItem() != Items.FIREWORKS) continue;
                    6i_0.c.player.inventory.currentItem = i2;
                    6i_0.c.playerController.updateController();
                    break;
                }
            }
            if (6i_0.c.player.getHeldItemMainhand().getItem() == Items.FIREWORKS && bl) {
                6i_0.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                this.1.c();
            }
        }
    }

    public static boolean 0() {
        return 1.6() != 6g_0.2 && 1.6() != 6g_0.1;
    }

    @Override
    public void c() {
        this.2 = false;
        this.c = 0.0;
        if (6i_0.c.player != null) {
            this.1 = 6i_0.c.player.posY;
            if (!6i_0.c.player.isCreative()) {
                6i_0.c.player.capabilities.allowFlying = false;
            }
            6i_0.c.player.capabilities.isFlying = false;
        }
        this.3 = false;
        1 = false;
    }

    public static boolean 8() {
        return 1.6() == 6g_0.c;
    }

    public static boolean o() {
        return 1.6() == 6g_0.2;
    }

    public static boolean q() {
        return 1;
    }

    public static boolean p() {
        return 1.6() == 6g_0.0;
    }

    public boolean c(int n2) {
        for (int i2 = MathHelper.floor((double)6i_0.c.player.getEntityBoundingBox().minX); i2 < MathHelper.ceil((double)6i_0.c.player.getEntityBoundingBox().maxX); ++i2) {
            for (int i3 = MathHelper.floor((double)6i_0.c.player.getEntityBoundingBox().minZ); i3 < MathHelper.ceil((double)6i_0.c.player.getEntityBoundingBox().maxZ); ++i3) {
                IBlockState iBlockState = 6i_0.c.world.getBlockState(new BlockPos(i2, n2, i3));
                if (iBlockState.getBlock() == Blocks.AIR) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean i() {
        return 1.6() == 6g_0.c;
    }

    public static boolean 6() {
        return 1.6() == 6g_0.2;
    }

    public static boolean b() {
        return 1.6() == 6g_0.c;
    }

    public static boolean w() {
        return 1.6() == 6g_0.c;
    }

    @Subscriber
    public void c(0T t) {
        block2: {
            if (!(t.c() instanceof CPacketPlayer) || 6i_0.t.6() != 6h_0.1 || 1.6() != 6g_0.2 || this.2 || !(Math.abs(6i_0.c.player.motionX) >= 0.05) && !(Math.abs(6i_0.c.player.motionZ) >= 0.05)) break block2;
            double d2 = 1.0E-8 + 1.0E-8 * (1.0 + (double)this.c.nextInt(1 + (this.c.nextBoolean() ? this.c.nextInt(34) : this.c.nextInt(43))));
            if (6i_0.c.player.onGround || 6i_0.c.player.ticksExisted % 2 == 0) {
                ((ICPacketPlayer)t.c()).setY(((CPacketPlayer)t.c()).getY(6i_0.c.player.posY) + d2);
            } else {
                ((ICPacketPlayer)t.c()).setY(((CPacketPlayer)t.c()).getY(6i_0.c.player.posY) - d2);
            }
        }
    }

    public static boolean 7() {
        return 1.6() == 6g_0.1;
    }

    public static boolean c() {
        return 1.6() == 6g_0.2;
    }

    public static boolean u() {
        return 1.6() == 6g_0.c;
    }

    @Subscriber(priority=30)
    public void c(1P p2) {
        block0: {
            block1: {
                if (6i_0.c.player.onGround || 6i_0.c.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() != Items.ELYTRA || 1.6() != 6g_0.2) break block0;
                if (((Boolean)v.6()).booleanValue()) break block1;
                if (6i_0.c.player.isElytraFlying()) break block0;
            }
            6i_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6i_0.c.player, CPacketEntityAction.Action.START_FALL_FLYING));
        }
    }

    public static boolean 1() {
        return 1.6() == 6g_0.c;
    }

    public static boolean j() {
        return 1.6() == 6g_0.1;
    }

    public static boolean l() {
        return (1.6() == 6g_0.1 || 1.6() == 6g_0.c && (Boolean)8.6() != false) && (Boolean)g.6() != false;
    }

    @Subscriber
    public void c(0f_0 f_02) {
        block41: {
            if (6i_0.c.world == null || 6i_0.c.player == null || !1) {
                return;
            }
            if (!6i_0.c.player.isElytraFlying()) {
                if (1.6() == 6g_0.c) {
                    if (!this.c.c(2000.0f * ((Float)2.6()).floatValue()) && ((Boolean)7.6()).booleanValue() && !6i_0.c.player.onGround) {
                        8k_0.c.c.c(this, 20, 0.1f);
                        return;
                    }
                    8k_0.c.c.c(this);
                }
                return;
            }
            8k_0.c.c.c(this);
            if (1.6() == 6g_0.2 || 1.6() == 6g_0.1) {
                return;
            }
            if (!(f_02.c() == 6i_0.c.player && 6i_0.c.player.isServerWorld() || 6i_0.c.player.canPassengerSteer() && !6i_0.c.player.isInWater() || 6i_0.c.player != null && 6i_0.c.player.capabilities.isFlying && !6i_0.c.player.isInLava()) && (!6i_0.c.player.capabilities.isFlying || !6i_0.c.player.isElytraFlying())) break block41;
            f_02.c(true);
            if (1.6() != 6g_0.c) {
                double d2;
                Vec3d vec3d = 6i_0.c.player.getLookVec();
                float f2 = 6i_0.c.player.rotationPitch * ((float)Math.PI / 180);
                double d3 = Math.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z);
                double d4 = Math.sqrt(6i_0.c.player.motionX * 6i_0.c.player.motionX + 6i_0.c.player.motionZ * 6i_0.c.player.motionZ);
                double d5 = vec3d.length();
                float f3 = MathHelper.cos((float)f2);
                f3 = (float)((double)f3 * (double)f3 * Math.min(1.0, d5 / 0.4));
                if (1.6() != 6g_0.0) {
                    6i_0.c.player.motionY += -0.08 + (double)f3 * (0.06 / (double)((Float)f.6()).floatValue());
                }
                if (1.6() == 6g_0.0) {
                    if (6i_0.c.gameSettings.keyBindSneak.isKeyDown()) {
                        6i_0.c.player.motionY = -((Float)l.6()).floatValue();
                    } else if (!6i_0.c.gameSettings.keyBindJump.isKeyDown()) {
                        6i_0.c.player.motionY = -3.0E-14 * (double)((Float)f.6()).floatValue();
                    }
                } else if (1.6() != 6g_0.0 && 6i_0.c.player.motionY < 0.0 && d3 > 0.0) {
                    d2 = 6i_0.c.player.motionY * -0.1 * (double)f3;
                    6i_0.c.player.motionY += d2;
                    6i_0.c.player.motionX += vec3d.x * d2 / d3 * (double)((Float)b.6()).floatValue();
                    6i_0.c.player.motionZ += vec3d.z * d2 / d3 * (double)((Float)b.6()).floatValue();
                }
                if (f2 < 0.0f && 1.6() != 6g_0.0) {
                    d2 = d4 * (double)(-MathHelper.sin((float)f2)) * 0.04;
                    6i_0.c.player.motionY += d2 * 3.2 * (double)((Float)e.6()).floatValue();
                    6i_0.c.player.motionX -= vec3d.x * d2 / d3;
                    6i_0.c.player.motionZ -= vec3d.z * d2 / d3;
                } else if (1.6() == 6g_0.0 && 6i_0.c.gameSettings.keyBindJump.isKeyDown()) {
                    if (d4 > (double)(((Float)e.6()).floatValue() / ((Float)e.7()).floatValue())) {
                        d2 = d4 * 0.01325;
                        6i_0.c.player.motionY += d2 * 3.2;
                        6i_0.c.player.motionX -= vec3d.x * d2 / d3;
                        6i_0.c.player.motionZ -= vec3d.z * d2 / d3;
                    } else {
                        double[] dArray = 8x_0.c((double)((Float)k.6()).floatValue());
                        6i_0.c.player.motionX = dArray[0];
                        6i_0.c.player.motionZ = dArray[1];
                    }
                }
                if (d3 > 0.0) {
                    6i_0.c.player.motionX += (vec3d.x / d3 * d4 - 6i_0.c.player.motionX) * 0.1;
                    6i_0.c.player.motionZ += (vec3d.z / d3 * d4 - 6i_0.c.player.motionZ) * 0.1;
                }
                if (1.6() == 6g_0.0 && !6i_0.c.gameSettings.keyBindJump.isKeyDown()) {
                    double[] dArray = 8x_0.c((double)((Float)k.6()).floatValue());
                    6i_0.c.player.motionX = dArray[0];
                    6i_0.c.player.motionZ = dArray[1];
                }
                if (!((Boolean)q.6()).booleanValue()) {
                    6i_0.c.player.motionX *= (double)0.99f;
                    6i_0.c.player.motionY *= (double)0.98f;
                    6i_0.c.player.motionZ *= (double)0.99f;
                }
                double d6 = Math.sqrt(6i_0.c.player.motionX * 6i_0.c.player.motionX + 6i_0.c.player.motionZ * 6i_0.c.player.motionZ);
                if (((Boolean)o.6()).booleanValue() && d6 > (double)((Float)p.6()).floatValue()) {
                    6i_0.c.player.motionX *= (double)((Float)p.6()).floatValue() / d6;
                    6i_0.c.player.motionZ *= (double)((Float)p.6()).floatValue() / d6;
                }
                6i_0.c.player.move(MoverType.SELF, 6i_0.c.player.motionX, 6i_0.c.player.motionY, 6i_0.c.player.motionZ);
            } else {
                double d7;
                double d8;
                double d9;
                double d10;
                double d11;
                boolean bl = false;
                float f4 = 6i_0.c.player.movementInput.moveForward;
                if (((Boolean)8.6()).booleanValue()) {
                    if (6i_0.c.gameSettings.keyBindJump.isKeyDown()) {
                        this.1 += (double)((Float)e.6()).floatValue() * 0.5;
                    } else if (6i_0.c.gameSettings.keyBindSneak.isKeyDown()) {
                        this.1 -= (double)((Float)f.6()).floatValue() * 0.5;
                    }
                    if (((Boolean)g.6()).booleanValue()) {
                        this.1 = ((Integer)h.6()).intValue();
                    }
                    double d12 = Math.sqrt(6i_0.c.player.motionX * 6i_0.c.player.motionX + 6i_0.c.player.motionZ * 6i_0.c.player.motionZ);
                    d11 = MathHelper.clamp((double)(d12 / 1.7), (double)0.0, (double)1.0);
                    d10 = 1.0 - Math.sqrt(d11);
                    d9 = 0.6;
                    if (d12 >= (Double)9.6() && this.c.c(2000.0f * ((Float)2.6()).floatValue())) {
                        double d13 = -((45.0 - d9) * d10 + d9);
                        d8 = (this.1 + 1.0 - 6i_0.c.player.posY) * 2.0;
                        double d14 = MathHelper.clamp((double)Math.abs(d8), (double)0.0, (double)1.0);
                        double d15 = -Math.toDegrees(Math.atan2(Math.abs(d8), d12 * 30.0)) * Math.signum(d8);
                        double d16 = (d15 - d13) * d14;
                        6i_0.c.player.rotationPitch = (float)d13;
                        6i_0.c.player.rotationPitch += (float)d16;
                        6i_0.c.player.prevRotationPitch = 6i_0.c.player.rotationPitch;
                    } else {
                        6i_0.c.player.rotationPitch = 0.25f;
                        6i_0.c.player.prevRotationPitch = 0.25f;
                        f4 = 1.0f;
                    }
                }
                Vec3d vec3d = 6i_0.c.player.getLookVec();
                float f5 = 6i_0.c.player.rotationPitch * ((float)Math.PI / 180);
                d11 = Math.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z);
                d10 = Math.sqrt(6i_0.c.player.motionX * 6i_0.c.player.motionX + 6i_0.c.player.motionZ * 6i_0.c.player.motionZ);
                d9 = vec3d.length();
                float f6 = MathHelper.cos((float)f5);
                f6 = (float)((double)f6 * (double)f6 * Math.min(1.0, d9 / 0.4));
                6i_0.c.player.motionY += -0.08 + (double)f6 * 0.06;
                if (6i_0.c.player.motionY < 0.0 && d11 > 0.0) {
                    d7 = 6i_0.c.player.motionY * -0.1 * (double)f6;
                    6i_0.c.player.motionY += d7;
                    6i_0.c.player.motionX += vec3d.x * d7 / d11;
                    6i_0.c.player.motionZ += vec3d.z * d7 / d11;
                }
                if (f5 < 0.0f) {
                    d7 = d10 * (double)(-MathHelper.sin((float)f5)) * 0.04;
                    6i_0.c.player.motionY += d7 * 3.2;
                    6i_0.c.player.motionX -= vec3d.x * d7 / d11;
                    6i_0.c.player.motionZ -= vec3d.z * d7 / d11;
                }
                if (d11 > 0.0) {
                    6i_0.c.player.motionX += (vec3d.x / d11 * d10 - 6i_0.c.player.motionX) * 0.1;
                    6i_0.c.player.motionZ += (vec3d.z / d11 * d10 - 6i_0.c.player.motionZ) * 0.1;
                }
                if (!((Boolean)q.6()).booleanValue()) {
                    6i_0.c.player.motionX *= (double)0.99f;
                    6i_0.c.player.motionY *= (double)0.98f;
                    6i_0.c.player.motionZ *= (double)0.99f;
                }
                float f7 = 6i_0.c.player.rotationYaw * ((float)Math.PI / 180);
                if (f5 > 0.0f && (6i_0.c.player.motionY < 0.0 || bl)) {
                    if (f4 != 0.0f && this.c.c(2000.0f * ((Float)2.6()).floatValue()) && this.0.c(1000.0f * ((Float)3.6()).floatValue())) {
                        if (((Boolean)5.6()).booleanValue()) {
                            6i_0.c.player.motionX = 0.0;
                            6i_0.c.player.motionZ = 0.0;
                        }
                        this.c.c();
                        6i_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)6i_0.c.player, CPacketEntityAction.Action.START_FALL_FLYING));
                    } else if (!this.c.c(2000.0f * ((Float)2.6()).floatValue())) {
                        6i_0.c.player.motionX -= (double)f4 * Math.sin(f7) * (double)((Float)b.6()).floatValue() / 20.0;
                        6i_0.c.player.motionZ += (double)f4 * Math.cos(f7) * (double)((Float)b.6()).floatValue() / 20.0;
                        this.0.c();
                    }
                }
                d8 = Math.sqrt(6i_0.c.player.motionX * 6i_0.c.player.motionX + 6i_0.c.player.motionZ * 6i_0.c.player.motionZ);
                if (((Boolean)o.6()).booleanValue() && d8 > (double)((Float)p.6()).floatValue()) {
                    6i_0.c.player.motionX *= (double)((Float)p.6()).floatValue() / d8;
                    6i_0.c.player.motionZ *= (double)((Float)p.6()).floatValue() / d8;
                }
                if (((Boolean)6.6()).booleanValue() && Keyboard.isKeyDown((int)56)) {
                    6i_0.c.player.setVelocity(0.0, 0.0, 0.0);
                }
                6i_0.c.player.move(MoverType.SELF, 6i_0.c.player.motionX, 6i_0.c.player.motionY, 6i_0.c.player.motionZ);
            }
        }
    }

    public static boolean n() {
        return 1.6() == 6g_0.1 || 1.6() == 6g_0.c && (Boolean)8.6() != false;
    }

    public static boolean h() {
        return 1.6() == 6g_0.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Subscriber
    public void c(11 var1_1) {
        if (1.6() == 6g_0.2) {
            if (6i_0.c.player.onGround) {
                return;
            }
            if (!1) {
                return;
            }
            if (((Boolean)r.6()).booleanValue()) {
                if (this.2) {
                    this.c = 1.0;
                    this.2 = false;
                }
                if (this.c < (double)((Float)b.6()).floatValue()) {
                    this.c += 0.1 * (double)((Float)s.6()).floatValue();
                }
                if (this.c - 0.1 > (double)((Float)b.6()).floatValue()) {
                    this.c -= 0.1 * (double)((Float)s.6()).floatValue();
                }
            } else {
                this.c = ((Float)b.6()).floatValue();
            }
            if (6i_0.c.gameSettings.keyBindJump.isKeyDown()) {
                6i_0.c.player.motionY = ((Float)e.6()).floatValue();
                var1_1.0(6i_0.c.player.motionY);
            } else if (6i_0.c.gameSettings.keyBindSneak.isKeyDown()) {
                6i_0.c.player.motionY = -((Float)f.6()).floatValue();
                var1_1.0(6i_0.c.player.motionY);
            } else if (t.6() == 6h_0.0) {
                if (6i_0.c.player.ticksExisted % 32 == 0 && !this.2 && (Math.abs(var1_1.2()) >= 0.05 || Math.abs(var1_1.1()) >= 0.05)) {
                    6i_0.c.player.motionY = -2.0E-4;
                    var1_1.0(0.006200000000000001);
                } else {
                    6i_0.c.player.motionY = -2.0E-4;
                    var1_1.0(-2.0E-4);
                }
            } else if (t.6() == 6h_0.2) {
                6i_0.c.player.motionY = -1.0E-5f;
                var1_1.0(-1.0E-5f);
            } else {
                6i_0.c.player.motionY = 0.0;
                var1_1.0(0.0);
            }
            var1_1.1(var1_1.2() * (this.2 ? 0.0 : this.c));
            var1_1.c(var1_1.1() * (this.2 ? 0.0 : this.c));
            if (((Boolean)u.6()).booleanValue() && var1_1.2() == 0.0 && var1_1.1() == 0.0 && !this.2) {
                var1_1.1(Math.sin(Math.toRadians(6i_0.c.player.ticksExisted % 360)) * 0.03);
                var1_1.c(Math.cos(Math.toRadians(6i_0.c.player.ticksExisted % 360)) * 0.03);
            }
            this.2 = false;
        }
    }

    public static boolean 9() {
        return 1.6() != 6g_0.2;
    }

    public static boolean m() {
        return 1.6() == 6g_0.0;
    }

    @Override
    public void 7() {
        if (6i_0.c.player != null) {
            if (!6i_0.c.player.isCreative()) {
                6i_0.c.player.capabilities.allowFlying = false;
            }
            6i_0.c.player.capabilities.isFlying = false;
        }
        8k_0.c.c.c(this);
        1 = false;
    }

    public static boolean v() {
        return 1.6() != 6g_0.2 && 1.6() != 6g_0.1;
    }

    public static boolean r() {
        return 1.6() == 6g_0.c;
    }

    public static boolean k() {
        return 1.6() == 6g_0.1 && (Boolean)i.6() != false;
    }

    public static boolean d() {
        return 1.6() == 6g_0.2;
    }

    public static boolean g() {
        return (Boolean)o.6() != false && 1.6() != 6g_0.2 && 1.6() != 6g_0.1;
    }

    public static boolean s() {
        return 1.6() == 6g_0.2;
    }
}

