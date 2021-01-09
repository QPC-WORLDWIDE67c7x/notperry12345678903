/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import me.darki.konas.0T;
import me.darki.konas.1N;
import me.darki.konas.1P;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.4g_0;
import me.darki.konas.4t_0;
import me.darki.konas.4u_0;
import me.darki.konas.4v_0;
import me.darki.konas.4w_0;
import me.darki.konas.5o_0;
import me.darki.konas.89;
import me.darki.konas.8B;
import me.darki.konas.8J;
import me.darki.konas.8L;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8r_0;
import me.darki.konas.99;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.block.BlockAir;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.4x
 */
public class 4x_0
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("Range", Float.valueOf(4.3f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.5f));
    public static 8h_0<8f_0> 2 = new 8h_0("Targeting", new 8f_0(false));
    public static 8h_0<Boolean> 3 = new 8h_0("Animals", false).c(2);
    public static 8h_0<Boolean> 4 = new 8h_0("Mobs", true).c(2);
    public static 8h_0<Boolean> 5 = new 8h_0("Bullets", false).c(2);
    public static 8h_0<Boolean> 6 = new 8h_0("Players", true).c(2);
    public static 8h_0<Boolean> 7 = new 8h_0("AttackFriends", false).c(2);
    public static 8h_0<8f_0> 8 = new 8h_0("AntiCheat", new 8f_0(false));
    public static 8h_0<4v_0> 9 = new 8h_0("Timing", 4v_0.c).c(8);
    public static 8h_0<4u_0> a = new 8h_0("Rotate", 4u_0.0).c(8);
    public static 8h_0<Float> b = new 8h_0("WallsRange", Float.valueOf(3.0f), Float.valueOf(6.0f), Float.valueOf(0.5f), Float.valueOf(0.5f)).c(8);
    public static 8h_0<Boolean> d = new 8h_0("Strict", false).c(8);
    public static 8h_0<Float> e = new 8h_0("YawAngle", Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(8);
    public static 8h_0<4w_0> f = new 8h_0("TPSSync", 4w_0.0).c(8);
    public static 8h_0<8f_0> g = new 8h_0("Speed", new 8f_0(false));
    public static 8h_0<4t_0> h = new 8h_0("Mode", 4t_0.c).c(g);
    public static 8h_0<Integer> i = new 8h_0("TickDelay", 12, 20, 0, 1).c(4x_0::6).c(g);
    public static 8h_0<8f_0> j = new 8h_0("Misc", new 8f_0(false));
    public static 8h_0<Boolean> k = new 8h_0("AutoSwitch", true).c(j);
    public static 8h_0<Boolean> l = new 8h_0("SwitchBack", false).c(j);
    public static 8h_0<Boolean> m = new 8h_0("NoGapSwitch", true).c(j);
    public static 8h_0<Boolean> n = new 8h_0("AutoBlock", false).c(j);
    public static 8h_0<Boolean> o = new 8h_0("SwordOnly", false).c(j);
    public static 8h_0<Boolean> p = new 8h_0("OnlyInHoles", false).c(j);
    public static 8h_0<Boolean> q = new 8h_0("OnlyWhenFalling", false).c(j);
    public static 8h_0<Boolean> r = new 8h_0("OnlyInAir", false).c(j);
    public static 8h_0<Boolean> s = new 8h_0("DisableWhenCA", false).c(j);
    public static 8h_0<Boolean> t = new 8h_0("OnlyWhenNoTargets", true).c(s::6).c(j);
    public static 8h_0<Boolean> u = new 8h_0("Check32k", false).c(4x_0::0).c(j);
    public static 8h_0<8f_0> v = new 8h_0("Render", new 8f_0(false));
    public static 8h_0<Boolean> w = new 8h_0("TargetRender", true).c(v);
    public static 8h_0<Boolean> x = new 8h_0("OnlyWhenHitting", true).c(v);
    public static 8h_0<Boolean> y = new 8h_0("Depth", true).c(v);
    public static 8h_0<Boolean> z = new 8h_0("Fill", false).c(v);
    public static 8h_0<Boolean> A = new 8h_0("Orbit", true).c(v);
    public static 8h_0<Boolean> B = new 8h_0("Trail", true).c(v);
    public static 8h_0<Float> C = new 8h_0("OrbitSpeed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(v);
    public static 8h_0<Float> D = new 8h_0("AnimSpeed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(v);
    public static 8h_0<Float> E = new 8h_0("Width", Float.valueOf(2.5f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(v);
    public static 8h_0<89> F = new 8h_0("Color", new 89(869950564, true)).c(v);
    public int 1 = 0;
    public static double c;
    public static double 0;
    public long c;
    public int 2 = -1;
    public Entity c;
    public 9m c = new 9m();

    @Override
    public void 7() {
        if (4x_0.c.player != null && ((Boolean)l.6()).booleanValue() && this.2 != -1) {
            4x_0.c.player.inventory.currentItem = this.2;
            4x_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
            this.2 = -1;
        }
    }

    public 4x_0() {
        super("KillAura", 0, 3D.c, "Aura", "SwordAura", "HitAura");
    }

    @Subscriber
    public void c(0T t) {
        block2: {
            if (4x_0.c.world == null || 4x_0.c.player == null) {
                return;
            }
            if (!(t.c() instanceof CPacketPlayer) || a.6() == 4u_0.c || this.c == null || 9.6() != 4v_0.0) break block2;
            this.c(this.c);
            CPacketPlayer cPacketPlayer = (CPacketPlayer)t.c();
            if (t.c() instanceof CPacketPlayer.Position) {
                t.c(true);
                4x_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(cPacketPlayer.getX(4x_0.c.player.posX), cPacketPlayer.getY(4x_0.c.player.posY), cPacketPlayer.getZ(4x_0.c.player.posZ), (float)c, (float)0, cPacketPlayer.isOnGround()));
            }
        }
    }

    public boolean 2(Entity entity) {
        if (((Boolean)3.6()).booleanValue() && entity instanceof EntityAnimal) {
            return true;
        }
        if (((Boolean)4.6()).booleanValue() && entity instanceof IMob) {
            return true;
        }
        if (((Boolean)6.6()).booleanValue() && entity instanceof EntityPlayer) {
            if (!((Boolean)7.6()).booleanValue()) {
                return !8J.1(entity.getName());
            }
            return true;
        }
        return false;
    }

    @Subscriber(priority=1)
    public void c(1P p2) {
        block15: {
            if (p2.0() || !8L.c(a.6() != 4u_0.c) || 9.6() == 4v_0.0) {
                return;
            }
            if (4x_0.c.world == null || 4x_0.c.player == null) {
                return;
            }
            if (!this.1()) {
                return;
            }
            boolean bl = true;
            if (a.6() != 4u_0.c && this.c != null) {
                float f2;
                if (a.6() == 4u_0.1) {
                    f2 = 0.0f;
                    if (f.6() == 4w_0.0) {
                        f2 = 20.0f - 8B.c.0();
                    } else if (f.6() == 4w_0.1) {
                        f2 = 20.0f - 8B.c.2();
                    } else if (f.6() == 4w_0.2) {
                        f2 = 20.0f - 8B.c.1();
                    }
                    if (h.6() == 4t_0.0 && this.1 < (Integer)i.6()) {
                        ++this.1;
                    }
                    float f3 = 1.0f;
                    if (this.c != null && this.c instanceof EntityShulkerBullet) {
                        f3 = 0.0f;
                    }
                    if (this.c.c(5000.0) || c == 0.0 || h.6() == 4t_0.c && 4x_0.c.player.getCooledAttackStrength(f.6() != 4w_0.c ? -f2 : 0.0f) >= f3 || h.6() == 4t_0.0 && this.1 >= (Integer)i.6()) {
                        this.c(this.c);
                    }
                } else {
                    this.c(this.c);
                }
                if (((Float)e.6()).floatValue() < 1.0f && Math.abs(f2 = (float)MathHelper.wrapDegrees((double)(c - (double)((IEntityPlayerSP)4x_0.c.player).getLastReportedYaw()))) > 180.0f * ((Float)e.6()).floatValue()) {
                    c = ((IEntityPlayerSP)4x_0.c.player).getLastReportedYaw() + f2 * (180.0f * ((Float)e.6()).floatValue() / Math.abs(f2));
                    bl = false;
                }
                8k_0.c.c.c((float)c, (float)0);
            }
            if (!bl) break block15;
            this.8();
        }
    }

    public boolean 0(Entity entity, float f2) {
        if (entity == 4x_0.c.player || entity == c.getRenderViewEntity()) {
            return false;
        }
        if (((Boolean)5.6()).booleanValue() && entity instanceof EntityShulkerBullet && !entity.isDead && this.c(entity, f2) && 4x_0.1(entity)) {
            return true;
        }
        if (!(entity instanceof EntityLivingBase)) {
            return false;
        }
        if (!this.2(entity)) {
            return false;
        }
        if (entity.isDead) {
            return false;
        }
        if (((EntityLivingBase)entity).getHealth() <= 0.0f) {
            return false;
        }
        if (!this.c(entity, f2)) {
            return false;
        }
        if (!4x_0.1(entity)) {
            return false;
        }
        return !5o_0.c().contains(entity);
    }

    public void 8() {
        if (((Boolean)m.6()).booleanValue() && 4x_0.c.player.getActiveItemStack().getItem() instanceof ItemFood) {
            return;
        }
        float f2 = 0.0f;
        if (f.6() == 4w_0.0) {
            f2 = 20.0f - 8B.c.0();
        } else if (f.6() == 4w_0.1) {
            f2 = 20.0f - 8B.c.2();
        } else if (f.6() == 4w_0.2) {
            f2 = 20.0f - 8B.c.1();
        }
        if (h.6() == 4t_0.0 && this.1 < (Integer)i.6()) {
            ++this.1;
        }
        float f3 = 1.0f;
        if (this.c != null && this.c instanceof EntityShulkerBullet) {
            f3 = 0.0f;
        }
        if (h.6() == 4t_0.c && 4x_0.c.player.getCooledAttackStrength(f.6() != 4w_0.c ? -f2 : 0.0f) >= f3 || h.6() == 4t_0.0 && this.1 >= (Integer)i.6()) {
            if (!this.0(this.c, ((Float)1.6()).floatValue())) {
                this.c = null;
            }
        } else if (h.6() == 4t_0.0 && this.1 < (Integer)i.6()) {
            ++this.1;
        }
        if ((!((Boolean)q.6()).booleanValue() || 4x_0.c.player.motionY < 0.0) && (!((Boolean)r.6()).booleanValue() || 4x_0.c.world.getBlockState(new BlockPos((Entity)4x_0.c.player)).getBlock() instanceof BlockAir) && (h.6() == 4t_0.c && 4x_0.c.player.getCooledAttackStrength(f.6() != 4w_0.c ? -f2 : 0.0f) >= f3 || h.6() == 4t_0.0 && this.1 >= (Integer)i.6())) {
            if (this.c != null) {
                if (((Boolean)k.6()).booleanValue()) {
                    this.0(this.c());
                }
                boolean bl = 4x_0.c.player.isSneaking();
                boolean bl2 = (Boolean)d.6() != false && 4x_0.c.player.isSprinting();
                boolean bl3 = 4x_0.c.player.isActiveItemStackBlocking();
                if (bl) {
                    4x_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)4x_0.c.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                if (bl2) {
                    4x_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)4x_0.c.player, CPacketEntityAction.Action.STOP_SPRINTING));
                }
                if (bl3 && 4x_0.c.player.getHeldItemOffhand().getItem() instanceof ItemShield) {
                    4x_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos((Entity)4x_0.c.player), EnumFacing.getFacingFromVector((float)((int)4x_0.c.player.posX), (float)((int)4x_0.c.player.posY), (float)((int)4x_0.c.player.posZ))));
                }
                4x_0.c.playerController.attackEntity((EntityPlayer)4x_0.c.player, this.c);
                4x_0.c.player.swingArm(EnumHand.MAIN_HAND);
                this.c.c();
                this.1 = 0;
                if (bl) {
                    4x_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)4x_0.c.player, CPacketEntityAction.Action.START_SNEAKING));
                }
                if (bl2) {
                    4x_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)4x_0.c.player, CPacketEntityAction.Action.START_SPRINTING));
                }
                if (bl3 && 4x_0.c.player.getHeldItemMainhand().getItem() instanceof ItemSword && 4x_0.c.player.getHeldItemOffhand().getItem() instanceof ItemShield) {
                    4x_0.c.playerController.processRightClick((EntityPlayer)4x_0.c.player, (World)4x_0.c.world, EnumHand.OFF_HAND);
                }
            } else if (((Boolean)l.6()).booleanValue() && this.2 != -1) {
                4x_0.c.player.inventory.currentItem = this.2;
                4x_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
                this.2 = -1;
            }
        }
    }

    public static Float 3(Entity entity) {
        return Float.valueOf(4x_0.c.player.getDistance(entity));
    }

    @Subscriber
    public void c(1N n2) {
        if (9.6() == 4v_0.c) {
            return;
        }
        if (4x_0.c.player == null || 4x_0.c.world == null) {
            return;
        }
        if (!this.1()) {
            this.c = null;
            return;
        }
        this.8();
    }

    public static boolean c(Vec3d vec3d) {
        Vec3d vec3d2 = new Vec3d(4x_0.c.player.posX, 4x_0.c.player.getEntityBoundingBox().minY + (double)4x_0.c.player.getEyeHeight(), 4x_0.c.player.posZ);
        return 4x_0.c.world.rayTraceBlocks(vec3d2, vec3d) == null || vec3d.distanceTo(4x_0.c.player.getPositionEyes(1.0f)) <= (double)((Float)b.6()).floatValue();
    }

    public boolean 1() {
        List list;
        if (((Boolean)s.6()).booleanValue() && (list = 3F.c(4g_0.class)) != null) {
            4g_0 g_02 = (4g_0)((Object)list);
            if (((3E)((Object)list)).f()) {
                if (((Boolean)t.6()).booleanValue()) {
                    if (g_02.c() != null || g_02.8() != null) {
                        this.c = null;
                        if (((Boolean)l.6()).booleanValue() && this.2 != -1) {
                            4x_0.c.player.inventory.currentItem = this.2;
                            4x_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
                            this.2 = -1;
                        }
                        return false;
                    }
                } else {
                    this.c = null;
                    if (((Boolean)l.6()).booleanValue() && this.2 != -1) {
                        4x_0.c.player.inventory.currentItem = this.2;
                        4x_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
                        this.2 = -1;
                    }
                    return false;
                }
            }
        }
        if (((Boolean)o.6()).booleanValue()) {
            if (!(4x_0.c.player.getHeldItemMainhand().getItem() instanceof ItemSword)) {
                return false;
            }
            if (((Boolean)u.6()).booleanValue() && EnchantmentHelper.getEnchantmentLevel((Enchantment)Enchantments.SHARPNESS, (ItemStack)4x_0.c.player.getHeldItemMainhand()) < 6) {
                this.c = null;
                if (((Boolean)l.6()).booleanValue() && this.2 != -1) {
                    4x_0.c.player.inventory.currentItem = this.2;
                    4x_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
                    this.2 = -1;
                }
                return false;
            }
        }
        if (((Boolean)p.6()).booleanValue() && !8r_0.1((BlockPos)(list = new BlockPos((Entity)4x_0.c.player)))) {
            this.c = null;
            if (((Boolean)l.6()).booleanValue() && this.2 != -1) {
                4x_0.c.player.inventory.currentItem = this.2;
                4x_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
                this.2 = -1;
            }
            return false;
        }
        list = 4x_0.c.world.loadedEntityList.stream().filter(this::0).sorted(Comparator.comparing(4x_0::3)).collect(Collectors.toList());
        if (!list.isEmpty()) {
            if (this.c == null || !this.c.equals(list.get(0))) {
                this.c = System.currentTimeMillis();
            }
            this.c = (Entity)list.get(0);
        } else {
            this.c = null;
        }
        if (((Boolean)n.6()).booleanValue() && this.c != null && !4x_0.c.player.isActiveItemStackBlocking() && 4x_0.c.player.getHeldItemOffhand().getItem() instanceof ItemShield) {
            4x_0.c.playerController.processRightClick((EntityPlayer)4x_0.c.player, (World)4x_0.c.world, EnumHand.OFF_HAND);
        }
        return true;
    }

    public static void c(float f2, float f3) {
        c = f2;
        0 = f3;
    }

    public int c() {
        int n2 = -1;
        if (4x_0.c.player.getHeldItemMainhand().getItem() == Items.DIAMOND_SWORD) {
            n2 = 4x_0.c.player.inventory.currentItem;
        }
        if (n2 == -1) {
            for (int i2 = 0; i2 < 9; ++i2) {
                if (4x_0.c.player.inventory.getStackInSlot(i2).getItem() != Items.DIAMOND_SWORD) continue;
                n2 = i2;
                break;
            }
        }
        return n2;
    }

    public static boolean 0() {
        return (Boolean)o.6();
    }

    public boolean c(Entity entity, float f2) {
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        for (double d2 = 0.15; d2 < 0.85; d2 += 0.1) {
            for (double d3 = 0.15; d3 < 0.85; d3 += 0.1) {
                for (double d4 = 0.15; d4 < 0.85; d4 += 0.1) {
                    Vec3d vec3d = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * d2, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * d3, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * d4);
                    if (!(4x_0.c.player.getDistance(vec3d.x, vec3d.y, vec3d.z) < (double)f2)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void c() {
        this.c = null;
        this.2 = -1;
    }

    public boolean 0(Entity entity) {
        return this.0(entity, ((Float)1.6()).floatValue());
    }

    public static boolean 6() {
        return h.6() == 4t_0.0;
    }

    public void c(Entity entity) {
        block4: {
            double d2;
            double d3;
            AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
            Vec3d vec3d = new Vec3d(4x_0.c.player.posX, 4x_0.c.player.getEntityBoundingBox().minY + (double)4x_0.c.player.getEyeHeight(), 4x_0.c.player.posZ);
            Vec3d vec3d2 = null;
            double[] dArray = null;
            for (d3 = 0.15; d3 < 0.85; d3 += 0.1) {
                for (d2 = 0.15; d2 < 0.85; d2 += 0.1) {
                    for (double d4 = 0.15; d4 < 0.85; d4 += 0.1) {
                        Vec3d vec3d3 = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * d3, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * d2, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * d4);
                        if (!4x_0.c(vec3d3)) continue;
                        double d5 = vec3d3.x - vec3d.x;
                        double d6 = vec3d3.y - vec3d.y;
                        double d7 = vec3d3.z - vec3d.z;
                        double[] dArray2 = new double[]{MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d7, d5)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d6, Math.sqrt(d5 * d5 + d7 * d7))))))};
                        if (vec3d2 != null && dArray != null) {
                            if (!(Math.hypot(((dArray2[0] - (double)((IEntityPlayerSP)4x_0.c.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, dArray2[1] - (double)((IEntityPlayerSP)4x_0.c.player).getLastReportedPitch()) < Math.hypot(((dArray[0] - (double)((IEntityPlayerSP)4x_0.c.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, dArray[1] - (double)((IEntityPlayerSP)4x_0.c.player).getLastReportedPitch()))) continue;
                            vec3d2 = vec3d3;
                            dArray = dArray2;
                            continue;
                        }
                        vec3d2 = vec3d3;
                        dArray = dArray2;
                    }
                }
            }
            if (vec3d2 == null || dArray == null) break block4;
            d3 = ((dArray[0] - (double)((IEntityPlayerSP)4x_0.c.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0;
            d2 = ((dArray[1] - (double)((IEntityPlayerSP)4x_0.c.player).getLastReportedPitch()) % 360.0 + 540.0) % 360.0 - 180.0;
            double[] dArray3 = new double[]{(double)((IEntityPlayerSP)4x_0.c.player).getLastReportedYaw() + (d3 > 180.0 ? 180.0 : Math.max(d3, -180.0)), (double)((IEntityPlayerSP)4x_0.c.player).getLastReportedPitch() + (d2 > 180.0 ? 180.0 : Math.max(d2, -180.0))};
            4x_0.c((float)dArray3[0], (float)dArray3[1]);
        }
    }

    public void 0(int n2) {
        block1: {
            if (4x_0.c.player.inventory.currentItem == n2 || n2 == -1) break block1;
            if (((Boolean)l.6()).booleanValue()) {
                this.2 = 4x_0.c.player.inventory.currentItem;
            }
            4x_0.c.player.inventory.currentItem = n2;
            4x_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
        }
    }

    public static boolean 1(Entity entity) {
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        for (double d2 = 0.15; d2 < 0.85; d2 += 0.1) {
            for (double d3 = 0.15; d3 < 0.85; d3 += 0.1) {
                for (double d4 = 0.15; d4 < 0.85; d4 += 0.1) {
                    Vec3d vec3d = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * d2, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * d3, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * d4);
                    if (!4x_0.c(vec3d)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block10: {
            int n2;
            int n3;
            int n4;
            float f2;
            if (4x_0.c.player == null || 4x_0.c.world == null) {
                return;
            }
            if (!((Boolean)w.6()).booleanValue() || this.c == null || ((Boolean)x.6()).booleanValue() && this.c.c(3500.0)) break block10;
            GlStateManager.pushMatrix();
            99.c();
            if (((Boolean)y.6()).booleanValue()) {
                GlStateManager.enableDepth();
            }
            IRenderManager iRenderManager = (IRenderManager)c.getRenderManager();
            float[] fArray = Color.RGBtoHSB(((89)F.6()).6(), ((89)F.6()).5(), ((89)F.6()).2(), null);
            float f3 = f2 = (float)(System.currentTimeMillis() % 7200L) / 7200.0f;
            int n5 = Color.getHSBColor(f3, fArray[1], fArray[2]).getRGB();
            ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
            double d2 = this.c.lastTickPosX + (this.c.posX - this.c.lastTickPosX) * (double)b_02.c() - iRenderManager.getRenderPosX();
            double d3 = this.c.lastTickPosY + (this.c.posY - this.c.lastTickPosY) * (double)b_02.c() - iRenderManager.getRenderPosY();
            double d4 = this.c.lastTickPosZ + (this.c.posZ - this.c.lastTickPosZ) * (double)b_02.c() - iRenderManager.getRenderPosZ();
            double d5 = -Math.cos((double)(System.currentTimeMillis() - this.c) / 1000.0 * (double)((Float)D.6()).floatValue()) * ((double)this.c.height / 2.0) + (double)this.c.height / 2.0;
            GL11.glLineWidth((float)((Float)E.6()).floatValue());
            GL11.glBegin((int)1);
            for (n4 = 0; n4 <= 360; ++n4) {
                Vec3d vec3d = new Vec3d(d2 + Math.sin((double)n4 * Math.PI / 180.0) * 0.5, d3 + d5 + 0.01, d4 + Math.cos((double)n4 * Math.PI / 180.0) * 0.5);
                arrayList.add(vec3d);
            }
            for (n4 = 0; n4 < arrayList.size() - 1; ++n4) {
                float f4;
                int n6 = n5 >> 16 & 0xFF;
                n3 = n5 >> 8 & 0xFF;
                n2 = n5 & 0xFF;
                float f5 = ((Boolean)A.6()).booleanValue() ? (((Boolean)B.6()).booleanValue() ? (float)Math.max(0.0, -0.3183098861837907 * Math.atan(Math.tan(Math.PI * (double)((float)n4 + 1.0f) / (double)arrayList.size() + (double)System.currentTimeMillis() / 1000.0 * (double)((Float)C.6()).floatValue()))) : (float)Math.max(0.0, Math.abs(Math.sin((double)(((float)n4 + 1.0f) / (float)arrayList.size()) * Math.PI + (double)System.currentTimeMillis() / 1000.0 * (double)((Float)C.6()).floatValue())) * 2.0 - 1.0)) : (f4 = (Boolean)z.6() != false ? 1.0f : (float)((89)F.6()).1() / 255.0f);
                if (((89)F.6()).7()) {
                    GL11.glColor4f((float)((float)n6 / 255.0f), (float)((float)n3 / 255.0f), (float)((float)n2 / 255.0f), (float)f4);
                } else {
                    GL11.glColor4f((float)((float)((89)F.6()).6() / 255.0f), (float)((float)((89)F.6()).5() / 255.0f), (float)((float)((89)F.6()).2() / 255.0f), (float)f4);
                }
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)n4)).x, (double)((Vec3d)arrayList.get((int)n4)).y, (double)((Vec3d)arrayList.get((int)n4)).z);
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)(n4 + 1))).x, (double)((Vec3d)arrayList.get((int)(n4 + 1))).y, (double)((Vec3d)arrayList.get((int)(n4 + 1))).z);
                n5 = Color.getHSBColor(f3 += 0.0027777778f, fArray[1], fArray[2]).getRGB();
            }
            GL11.glEnd();
            if (((Boolean)z.6()).booleanValue()) {
                f3 = f2;
                GL11.glBegin((int)9);
                for (n4 = 0; n4 < arrayList.size() - 1; ++n4) {
                    int n7 = n5 >> 16 & 0xFF;
                    n3 = n5 >> 8 & 0xFF;
                    n2 = n5 & 0xFF;
                    if (((89)F.6()).7()) {
                        GL11.glColor4f((float)((float)n7 / 255.0f), (float)((float)n3 / 255.0f), (float)((float)n2 / 255.0f), (float)((float)((89)F.6()).1() / 255.0f));
                    } else {
                        GL11.glColor4f((float)((float)((89)F.6()).6() / 255.0f), (float)((float)((89)F.6()).5() / 255.0f), (float)((float)((89)F.6()).2() / 255.0f), (float)((float)((89)F.6()).1() / 255.0f));
                    }
                    GL11.glVertex3d((double)((Vec3d)arrayList.get((int)n4)).x, (double)((Vec3d)arrayList.get((int)n4)).y, (double)((Vec3d)arrayList.get((int)n4)).z);
                    GL11.glVertex3d((double)((Vec3d)arrayList.get((int)(n4 + 1))).x, (double)((Vec3d)arrayList.get((int)(n4 + 1))).y, (double)((Vec3d)arrayList.get((int)(n4 + 1))).z);
                    n5 = Color.getHSBColor(f3 += 0.0027777778f, fArray[1], fArray[2]).getRGB();
                }
                GL11.glEnd();
            }
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            99.0();
            GlStateManager.popMatrix();
        }
    }
}

