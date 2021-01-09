/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.1N;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.45;
import me.darki.konas.46;
import me.darki.konas.47;
import me.darki.konas.48;
import me.darki.konas.49;
import me.darki.konas.4E;
import me.darki.konas.4a_0;
import me.darki.konas.4b_0;
import me.darki.konas.4d_0;
import me.darki.konas.4e_0;
import me.darki.konas.4f_0;
import me.darki.konas.4x_0;
import me.darki.konas.54;
import me.darki.konas.6X;
import me.darki.konas.7J;
import me.darki.konas.89;
import me.darki.konas.8B;
import me.darki.konas.8E;
import me.darki.konas.8J;
import me.darki.konas.8L;
import me.darki.konas.8M;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8j_0;
import me.darki.konas.8k_0;
import me.darki.konas.8r_0;
import me.darki.konas.8u_0;
import me.darki.konas.8x_0;
import me.darki.konas.97;
import me.darki.konas.99;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.ICPacketUseEntity;
import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.4g
 */
public class 4g_0
extends 3E {
    public static 8h_0<8f_0> 1 = new 8h_0("AntiCheat", new 8f_0(false));
    public static 8h_0<4e_0> 2 = new 8h_0("Timing", 4e_0.0).c(1).0("Changes how AC is timed");
    public static 8h_0<49> 3 = new 8h_0("Rotate", 49.0).c(1).0("Spoof rotations server-side");
    public static 8h_0<Boolean> 4 = new 8h_0("Inhibit", false).c(1).0("Prevent unnesasary attacks");
    public static 8h_0<Boolean> 5 = new 8h_0("Limit", true).c(1).0("Limit attacks");
    public static 8h_0<4f_0> 6 = new 8h_0("YawStep", 4f_0.c).c(1).0("Rotate slower");
    public static 8h_0<Float> 7 = new 8h_0("YawAngle", Float.valueOf(0.3f), Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(1).0("Maximum angle to rotate by per tick");
    public static 8h_0<Integer> 8 = new 8h_0("YawTicks", 1, 5, 1, 1).c(1).0("Rotate slower by this amount of ticks");
    public static 8h_0<8f_0> 9 = new 8h_0("Placements", new 8f_0(false));
    public static 8h_0<Boolean> a = new 8h_0("Check", true).c(9).0("Check if you will be able to break the crystals you place");
    public static 8h_0<46> b = new 8h_0("Interact", 46.0).c(9).0("Changes how you interact with blocks while placing");
    public static 8h_0<Boolean> d = new 8h_0("Protocol", false).c(9).0("Place in 1x1x1 areas");
    public static 8h_0<Boolean> e = new 8h_0("PlaceInFire", false).c(9).0("Place in fires");
    public static 8h_0<8f_0> f = new 8h_0("Speeds", new 8f_0(false));
    public static 8h_0<45> g = new 8h_0("Confirm", 45.c).c(f).0("Do not place elsewhere until previous placement has been executed");
    public static 8h_0<Integer> h = new 8h_0("TicksExisted", 0, 20, 0, 1).c(f).0("Tick delay for 2b2t");
    public static 8h_0<Integer> i = new 8h_0("AttackTicks", 3, 20, 1, 1).c(f).0("Amount of ticks to attack crystals for").c(4g_0::6);
    public static 8h_0<Float> j = new 8h_0("BreakSpeed", Float.valueOf(20.0f), Float.valueOf(20.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)).c(f).0("Crystal break speed");
    public static 8h_0<Float> k = new 8h_0("PlaceSpeed", Float.valueOf(20.0f), Float.valueOf(20.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)).c(f).0("Crystal place speed");
    public static 8h_0<4b_0> l = new 8h_0("Sync", 4b_0.c).c(f).0("Syncronizes breaking and placing");
    public static 8h_0<Float> m = new 8h_0("Offset", Float.valueOf(0.0f), Float.valueOf(0.8f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(f).c(4g_0::d).0("Syncronization offset");
    public static 8h_0<8f_0> n = new 8h_0("Ranges", new 8f_0(false));
    public static 8h_0<Float> o = new 8h_0("EnemyRange", Float.valueOf(8.0f), Float.valueOf(15.0f), Float.valueOf(4.0f), Float.valueOf(0.5f)).c(n).0("Range from which to select target(s)");
    public static 8h_0<Float> p = new 8h_0("CrystalRange", Float.valueOf(6.0f), Float.valueOf(12.0f), Float.valueOf(2.0f), Float.valueOf(0.5f)).c(n).0("Maximum range between enemies and placements");
    public static 8h_0<Float> q = new 8h_0("BreakRange", Float.valueOf(4.3f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)).c(n).0("Break range for breaking visible crystals");
    public static 8h_0<Float> r = new 8h_0("BreakWalls", Float.valueOf(1.5f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)).c(n).0("Break range for breaking crystals through walls");
    public static 8h_0<Float> s = new 8h_0("PlaceRange", Float.valueOf(4.0f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)).c(n).0("Place range for visible blocks");
    public static 8h_0<Float> t = new 8h_0("PlaceWalls", Float.valueOf(3.0f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)).c(n).0("Place range for placing through walls");
    public static 8h_0<8f_0> u = new 8h_0("Swap", new 8f_0(false));
    public static 8h_0<4a_0> v = new 8h_0("AutoSwap", 4a_0.c).c(u).0("Auto Swap");
    public static 8h_0<4a_0> w = new 8h_0("AntiWeakness", 4a_0.c).c(u).0("Swap to sword before hitting crystal when weaknessed");
    public static 8h_0<Float> x = new 8h_0("SwapDelay", Float.valueOf(5.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.5f)).c(u).0("Delay for hitting crystals after swapping");
    public static 8h_0<8f_0> y = new 8h_0("Damages", new 8f_0(false));
    public static 8h_0<4d_0> z = new 8h_0("Target", 4d_0.c).c(y).0("Algorithm to use for selecting target(s)");
    public static 8h_0<Float> A = new 8h_0("MinDamage", Float.valueOf(6.0f), Float.valueOf(20.0f), Float.valueOf(0.0f), Float.valueOf(0.5f)).c(y).0("Minimum amount of damage for placing crystals");
    public static 8h_0<Float> B = new 8h_0("MaxSelfPlace", Float.valueOf(12.0f), Float.valueOf(20.0f), Float.valueOf(0.0f), Float.valueOf(0.5f)).c(y).0("Maximum amount of self damage for placing crystals");
    public static 8h_0<Float> C = new 8h_0("MaxSelfBreak", Float.valueOf(2.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(y).0("Maximum self damage for breaking enemy crystals");
    public static 8h_0<Float> D = new 8h_0("FacePlaceHealth", Float.valueOf(4.0f), Float.valueOf(20.0f), Float.valueOf(0.0f), Float.valueOf(0.5f)).c(y).0("Health at which to start faceplacing enemies");
    public static 8h_0<8j_0> E = new 8h_0("FacePlace", new 8j_0(56)).c(y);
    public static 8h_0<Boolean> F = new 8h_0("ArmorBreaker", true).c(y);
    public static 8h_0<Float> G = new 8h_0("Depletion", Float.valueOf(0.9f), Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(y).c(F::6);
    public static 8h_0<8f_0> H = new 8h_0("Prediction", new 8f_0(false));
    public static 8h_0<Boolean> I = new 8h_0("Collision", false).c(H).0("Simulate collision when predicting motion");
    public static 8h_0<Integer> J = new 8h_0("PredictTicks", 1, 10, 0, 1).c(H).0("Predict target motion by this amount of ticks");
    public static 8h_0<Boolean> K = new 8h_0("PredictDestruction", false).c(H).0("Ignore destructable blocks when doing damage calculations");
    public static 8h_0<8f_0> L = new 8h_0("Pause", new 8f_0(false));
    public static 8h_0<Boolean> M = new 8h_0("Mining", false).c(L);
    public static 8h_0<Boolean> N = new 8h_0("Gapping", false).c(L);
    public static 8h_0<Boolean> O = new 8h_0("RightClickGap", false).c(N::6).c(L);
    public static 8h_0<Boolean> P = new 8h_0("KillAura", true).c(L);
    public static 8h_0<Boolean> Q = new 8h_0("PistonAura", true).c(L);
    public static 8h_0<Float> R = new 8h_0("Health", Float.valueOf(2.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.5f)).c(L);
    public static 8h_0<Boolean> S = new 8h_0("DisableOnTP", false).c(L);
    public static 8h_0<8f_0> T = new 8h_0("Render", new 8f_0(false));
    public static 8h_0<Boolean> U = new 8h_0("Swing", false).c(T).0("Swing arm client-side");
    public static 8h_0<Boolean> V = new 8h_0("Box", true).c(T);
    public static 8h_0<Boolean> W = new 8h_0("Breaking", true).c(T);
    public static 8h_0<Float> X = new 8h_0("OutlineWidth", Float.valueOf(1.5f), Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(T).c(V::6);
    public static 8h_0<48> Y = new 8h_0("Damage", 48.c).c(T);
    public static 8h_0<Boolean> Z = new 8h_0("CustomFont", true).c(T);
    public static 8h_0<Float> 0c = new 8h_0("Fade", Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(T);
    public static 8h_0<89> 00 = new 8h_0("Color", new 89(1354711231)).c(T);
    public static 8h_0<89> 01 = new 8h_0("Outline", new 89(-4243265)).c(T);
    public static 8h_0<Boolean> 02 = new 8h_0("TargetRender", true).c(T).0("Render circle around target");
    public static 8h_0<Boolean> 03 = new 8h_0("Depth", true).c(T);
    public static 8h_0<Boolean> 04 = new 8h_0("Fill", false).c(T);
    public static 8h_0<Boolean> 05 = new 8h_0("Orbit", true).c(T);
    public static 8h_0<Boolean> 06 = new 8h_0("Trail", true).c(T);
    public static 8h_0<Float> 07 = new 8h_0("OrbitSpeed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(T);
    public static 8h_0<Float> 08 = new 8h_0("AnimSpeed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(T);
    public static 8h_0<Float> 09 = new 8h_0("Width", Float.valueOf(2.5f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(T);
    public static 8h_0<89> 0a = new 8h_0("TargetColor", new 89(869950564, true)).c(T);
    public Vec3d c;
    public float[] c;
    public 9m c;
    public EntityEnderCrystal c;
    public BlockPos c;
    public BlockPos 0;
    public EnumFacing c;
    public RayTraceResult c;
    public 9m 0;
    public 9m 1;
    public 9m 2;
    public BlockPos 1;
    public float c;
    public 9m 3;
    public BlockPos 2;
    public 9m 4;
    public boolean 1;
    public ConcurrentHashMap<BlockPos, Long> c;
    public ConcurrentHashMap<Integer, Long> 0;
    public Map<EntityPlayer, 9m> c;
    public List<BlockPos> c;
    public AtomicBoolean c;
    public 9m 5;
    public 9m 6;
    public BlockPos 3;
    public 9m 7;
    public EntityEnderCrystal 0;
    public 9m 8;
    public Vec3d 0;
    public Thread c;
    public AtomicBoolean 0 = null;
    public AtomicBoolean 1;
    public EntityPlayer c = 0.0f;
    public 9m 9;
    public int 1 = false;
    public boolean 2;
    public int 2 = -1;
    public int 3 = -1;

    @Subscriber(priority=20)
    public void c(1O o2) {
        if (this.c != null) {
            if (this.0(this.c)) {
                this.1.c();
                this.0.put(this.c.getEntityId(), System.currentTimeMillis());
                for (Entity entity : 4g_0.c.world.loadedEntityList) {
                    if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistance(this.c.posX, this.c.posY, this.c.posZ) <= 6.0)) continue;
                    this.0.put(entity.getEntityId(), System.currentTimeMillis());
                }
                this.c = null;
                if (l.6() == 4b_0.0) {
                    this.b();
                }
            }
        } else if (this.c != null) {
            if (!this.c(this.c, this.c)) {
                this.0.set(false);
                this.c = null;
                return;
            }
            this.0.c();
            this.c = null;
        }
    }

    @Subscriber
    public void 0(1b_0 b_02) {
        block10: {
            int n2;
            int n3;
            int n4;
            float f2;
            if (4g_0.c.player == null || 4g_0.c.world == null) {
                return;
            }
            if (!((Boolean)02.6()).booleanValue() || this.c == null || this.9.c(3500.0)) break block10;
            GlStateManager.pushMatrix();
            99.c();
            if (((Boolean)03.6()).booleanValue()) {
                GlStateManager.enableDepth();
            }
            IRenderManager iRenderManager = (IRenderManager)c.getRenderManager();
            float[] fArray = Color.RGBtoHSB(((89)0a.6()).6(), ((89)0a.6()).5(), ((89)0a.6()).2(), null);
            float f3 = f2 = (float)(System.currentTimeMillis() % 7200L) / 7200.0f;
            int n5 = Color.getHSBColor(f3, fArray[1], fArray[2]).getRGB();
            ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
            double d2 = this.c.lastTickPosX + (this.c.posX - this.c.lastTickPosX) * (double)b_02.c() - iRenderManager.getRenderPosX();
            double d3 = this.c.lastTickPosY + (this.c.posY - this.c.lastTickPosY) * (double)b_02.c() - iRenderManager.getRenderPosY();
            double d4 = this.c.lastTickPosZ + (this.c.posZ - this.c.lastTickPosZ) * (double)b_02.c() - iRenderManager.getRenderPosZ();
            double d5 = -Math.cos((double)System.currentTimeMillis() / 1000.0 * (double)((Float)08.6()).floatValue()) * ((double)this.c.height / 2.0) + (double)this.c.height / 2.0;
            GL11.glLineWidth((float)((Float)09.6()).floatValue());
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
                float f5 = ((Boolean)05.6()).booleanValue() ? (((Boolean)06.6()).booleanValue() ? (float)Math.max(0.0, -0.3183098861837907 * Math.atan(Math.tan(Math.PI * (double)((float)n4 + 1.0f) / (double)arrayList.size() + (double)System.currentTimeMillis() / 1000.0 * (double)((Float)07.6()).floatValue()))) : (float)Math.max(0.0, Math.abs(Math.sin((double)(((float)n4 + 1.0f) / (float)arrayList.size()) * Math.PI + (double)System.currentTimeMillis() / 1000.0 * (double)((Float)07.6()).floatValue())) * 2.0 - 1.0)) : (f4 = (Boolean)04.6() != false ? 1.0f : (float)((89)0a.6()).1() / 255.0f);
                if (((89)0a.6()).7()) {
                    GL11.glColor4f((float)((float)n6 / 255.0f), (float)((float)n3 / 255.0f), (float)((float)n2 / 255.0f), (float)f4);
                } else {
                    GL11.glColor4f((float)((float)((89)0a.6()).6() / 255.0f), (float)((float)((89)0a.6()).5() / 255.0f), (float)((float)((89)0a.6()).2() / 255.0f), (float)f4);
                }
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)n4)).x, (double)((Vec3d)arrayList.get((int)n4)).y, (double)((Vec3d)arrayList.get((int)n4)).z);
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)(n4 + 1))).x, (double)((Vec3d)arrayList.get((int)(n4 + 1))).y, (double)((Vec3d)arrayList.get((int)(n4 + 1))).z);
                n5 = Color.getHSBColor(f3 += 0.0027777778f, fArray[1], fArray[2]).getRGB();
            }
            GL11.glEnd();
            if (((Boolean)04.6()).booleanValue()) {
                f3 = f2;
                GL11.glBegin((int)9);
                for (n4 = 0; n4 < arrayList.size() - 1; ++n4) {
                    int n7 = n5 >> 16 & 0xFF;
                    n3 = n5 >> 8 & 0xFF;
                    n2 = n5 & 0xFF;
                    if (((89)0a.6()).7()) {
                        GL11.glColor4f((float)((float)n7 / 255.0f), (float)((float)n3 / 255.0f), (float)((float)n2 / 255.0f), (float)((float)((89)0a.6()).1() / 255.0f));
                    } else {
                        GL11.glColor4f((float)((float)((89)0a.6()).6() / 255.0f), (float)((float)((89)0a.6()).5() / 255.0f), (float)((float)((89)0a.6()).2() / 255.0f), (float)((float)((89)0a.6()).1() / 255.0f));
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

    public static Float 6(EntityPlayer entityPlayer) {
        return Float.valueOf(4g_0.c.player.getDistance((Entity)entityPlayer));
    }

    public int c(EntityLivingBase entityLivingBase) {
        if (entityLivingBase.isPotionActive(MobEffects.HASTE)) {
            return 6 - (1 + entityLivingBase.getActivePotionEffect(MobEffects.HASTE).getAmplifier());
        }
        return entityLivingBase.isPotionActive(MobEffects.MINING_FATIGUE) ? 6 + (1 + entityLivingBase.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) * 2 : 6;
    }

    public static boolean 8(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount() < 10.0f;
    }

    public List<Entity> 1() {
        return 4g_0.c.world.loadedEntityList.stream().filter(4g_0::0).filter(this::4).collect(Collectors.toList());
    }

    public static boolean c(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() > 0.0f;
    }

    @Override
    public void c() {
        this.c = null;
        this.c = null;
        this.c = null;
        this.c = null;
        this.0 = null;
        this.3 = null;
        this.0 = null;
        this.1.set(false);
        this.c = null;
        this.c.c();
        this.1 = false;
        this.2 = false;
        this.c.clear();
        this.2 = -1;
        this.3 = -1;
    }

    @Subscriber(priority=50)
    public void c(1P p2) {
        block8: {
            this.c.forEach(this::c);
            --this.1;
            if (this.0 != null) {
                for (Entity entity : 4g_0.c.world.loadedEntityList) {
                    if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistance(this.0.x, this.0.y, this.0.z) <= 6.0)) continue;
                    this.0.put(entity.getEntityId(), System.currentTimeMillis());
                }
                this.0 = null;
            }
            if (p2.0() || !8L.c(3.6() != 49.c)) {
                return;
            }
            this.c = null;
            this.c = null;
            this.c = null;
            this.c = null;
            this.2 = false;
            this.f();
            if (3.6() == 49.c || this.c.c(650.0) || this.c == null) break block8;
            if (3.6() == 49.0) {
                this.c = 8M.c(4g_0.c.player.getPositionEyes(1.0f), this.c);
            }
            if (((Float)7.6()).floatValue() < 1.0f && 6.6() != 4f_0.c && (this.c != null || 6.6() == 4f_0.1)) {
                if (this.1 > 0) {
                    this.c[0] = ((IEntityPlayerSP)4g_0.c.player).getLastReportedYaw();
                    this.c = null;
                    this.c = null;
                } else {
                    float f2 = MathHelper.wrapDegrees((float)(this.c[0] - ((IEntityPlayerSP)4g_0.c.player).getLastReportedYaw()));
                    if (Math.abs(f2) > 180.0f * ((Float)7.6()).floatValue()) {
                        this.c[0] = ((IEntityPlayerSP)4g_0.c.player).getLastReportedYaw() + f2 * (180.0f * ((Float)7.6()).floatValue() / Math.abs(f2));
                        this.c = null;
                        this.c = null;
                        this.1 = (Integer)8.6();
                    }
                }
            }
            8k_0.c.c.c(this.c[0], this.c[1]);
        }
    }

    public EntityEnderCrystal c() {
        return this.c;
    }

    public boolean 4(Entity entity) {
        return this.c((EntityEnderCrystal)entity);
    }

    public static boolean a(EntityPlayer entityPlayer) {
        return !8r_0.1(new BlockPos((Entity)entityPlayer)) && (4g_0.c.world.getBlockState(new BlockPos((Entity)entityPlayer)).getBlock() == Blocks.AIR || 4g_0.c.world.getBlockState(new BlockPos((Entity)entityPlayer)).getBlock() == Blocks.WEB || 4g_0.c.world.getBlockState(new BlockPos((Entity)entityPlayer)).getBlock() instanceof BlockLiquid);
    }

    public List<EntityPlayer> e() {
        List<Object> list = 4g_0.c.world.playerEntities.stream().filter(4g_0::0).filter(4g_0::2).filter(4g_0::7).filter(4g_0::4).filter(4g_0::c).filter(4g_0::9).sorted(Comparator.comparing(4g_0::3)).collect(Collectors.toList());
        if (z.6() == 4d_0.0) {
            List list2 = list.stream().filter(4g_0::a).sorted(Comparator.comparing(4g_0::5)).collect(Collectors.toList());
            if (list2.size() > 0) {
                list = list2;
            }
            if ((list2 = list.stream().filter(4g_0::8).sorted(Comparator.comparing(4g_0::6)).collect(Collectors.toList())).size() > 0) {
                list = list2;
            }
        }
        return list;
    }

    public boolean c(EntityEnderCrystal entityEnderCrystal) {
        if (4g_0.c.player.getPositionEyes(1.0f).distanceTo(entityEnderCrystal.getPositionVector()) > (double)((Float)q.6()).floatValue()) {
            return false;
        }
        if (this.0.containsKey(entityEnderCrystal.getEntityId()) && ((Boolean)5.6()).booleanValue()) {
            return false;
        }
        if (this.0.containsKey(entityEnderCrystal.getEntityId()) && entityEnderCrystal.ticksExisted > (Integer)h.6() + (Integer)i.6()) {
            return false;
        }
        return !(8E.c(entityEnderCrystal, (Entity)4g_0.c.player) + 2.0f >= 4g_0.c.player.getHealth() + 4g_0.c.player.getAbsorptionAmount());
    }

    public void c(EnumHand enumHand) {
        if (!((Boolean)U.6()).booleanValue()) {
            return;
        }
        ItemStack itemStack = 4g_0.c.player.getHeldItem(enumHand);
        if (!itemStack.isEmpty() && itemStack.getItem().onEntitySwing((EntityLivingBase)4g_0.c.player, itemStack)) {
            return;
        }
        if (!4g_0.c.player.isSwingInProgress || 4g_0.c.player.swingProgressInt >= this.c((EntityLivingBase)4g_0.c.player) / 2 || 4g_0.c.player.swingProgressInt < 0) {
            4g_0.c.player.swingProgressInt = -1;
            4g_0.c.player.isSwingInProgress = true;
            4g_0.c.player.swingingHand = enumHand;
        }
    }

    public void c(double d2, double d3, double d4) {
        if (3.6() != 49.c) {
            if (3.6() == 49.1 && this.c != null && !this.c.c(650.0)) {
                if (this.c.y < d3 - 0.1) {
                    this.c = new Vec3d(this.c.x, d3, this.c.z);
                }
                this.c = 8M.c(4g_0.c.player.getPositionEyes(1.0f), this.c);
                this.c.c();
                return;
            }
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d2 - 1.0, d3, d4 - 1.0, d2 + 1.0, d3 + 2.0, d4 + 1.0);
            Vec3d vec3d = new Vec3d(4g_0.c.player.posX, 4g_0.c.player.getEntityBoundingBox().minY + (double)4g_0.c.player.getEyeHeight(), 4g_0.c.player.posZ);
            double d5 = 0.1;
            double d6 = 0.15;
            double d7 = 0.85;
            if (axisAlignedBB.intersects(4g_0.c.player.getEntityBoundingBox())) {
                d6 = 0.4;
                d7 = 0.6;
                d5 = 0.05;
            }
            Vec3d vec3d2 = null;
            double[] dArray = null;
            boolean bl = false;
            for (double d8 = d6; d8 <= d7; d8 += d5) {
                for (double d9 = d6; d9 <= d7; d9 += d5) {
                    for (double d10 = d6; d10 <= d7; d10 += d5) {
                        Vec3d vec3d3 = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * d8, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * d9, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * d10);
                        double d11 = vec3d3.x - vec3d.x;
                        double d12 = vec3d3.y - vec3d.y;
                        double d13 = vec3d3.z - vec3d.z;
                        double[] dArray2 = new double[]{MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d13, d11)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d12, Math.sqrt(d11 * d11 + d13 * d13))))))};
                        boolean bl2 = true;
                        if (b.6() != 46.c && !8E.c(vec3d3)) {
                            bl2 = false;
                        }
                        if (vec3d2 != null && dArray != null) {
                            if (!bl2 && bl || !(4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d3) < 4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d2))) continue;
                            vec3d2 = vec3d3;
                            dArray = dArray2;
                            continue;
                        }
                        vec3d2 = vec3d3;
                        dArray = dArray2;
                        bl = bl2;
                    }
                }
            }
            if (vec3d2 != null && dArray != null) {
                this.c.c();
                this.c = vec3d2;
                this.c = 8M.c(4g_0.c.player.getPositionEyes(1.0f), this.c);
            }
        }
    }

    public void f() {
        if (4g_0.c.player.getHealth() + 4g_0.c.player.getAbsorptionAmount() < ((Float)R.6()).floatValue() || (Boolean)P.6() != false && 3F.c(4x_0.class).f() || (Boolean)Q.6() != false && 3F.c(4E.class).f() || (Boolean)N.6() != false && 4g_0.c.player.getActiveItemStack().getItem() instanceof ItemFood || ((Boolean)M.6()).booleanValue() && 4g_0.c.playerController.getIsHittingBlock() && 4g_0.c.player.getHeldItemMainhand().getItem() instanceof ItemTool) {
            this.c = null;
            return;
        }
        if (((Boolean)N.6()).booleanValue() && ((Boolean)O.6()).booleanValue() && 4g_0.c.gameSettings.keyBindUseItem.isKeyDown() && 4g_0.c.player.inventory.getCurrentItem().getItem() instanceof ItemEndCrystal) {
            int n2 = -1;
            for (int i2 = 0; i2 < 9; ++i2) {
                if (4g_0.c.player.inventory.getStackInSlot(i2).getItem() != Items.GOLDEN_APPLE) continue;
                n2 = i2;
                break;
            }
            if (n2 != -1 && n2 != 4g_0.c.player.inventory.currentItem) {
                4g_0.c.player.inventory.currentItem = n2;
                4g_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
                return;
            }
        }
        if (!this.9() && !(4g_0.c.player.inventory.getCurrentItem().getItem() instanceof ItemEndCrystal) && v.6() == 4a_0.c) {
            return;
        }
        List<EntityPlayer> list = this.e();
        EntityEnderCrystal entityEnderCrystal = this.c(list);
        int n3 = (int)Math.max(100.0f, (float)(8E.0() + 50) / (8B.c.1() / 20.0f)) + 150;
        if (entityEnderCrystal != null && this.1.c(1000.0f - ((Float)j.6()).floatValue() * 50.0f) && (entityEnderCrystal.ticksExisted >= (Integer)h.6() || 2.6() == 4e_0.0)) {
            this.c = entityEnderCrystal;
            this.c(this.c.posX, this.c.posY, this.c.posZ);
        }
        if (entityEnderCrystal == null && (g.6() != 45.1 || this.0 == null || (double)this.0.ticksExisted >= Math.floor(((Integer)h.6()).intValue())) && (l.6() != 4b_0.c || this.1.c(950.0f - ((Float)j.6()).floatValue() * 50.0f - (float)8E.0())) && this.0.c(1000.0f - ((Float)k.6()).floatValue() * 50.0f) && (2.6() == 4e_0.c || this.5.c((float)((Integer)h.6()).intValue() * 5.0f))) {
            BlockPos blockPos;
            if (g.6() != 45.c && this.3 != null && !this.6.c((double)(n3 + 100)) && this.c(this.3)) {
                this.c = this.3;
                this.c = this.0(this.c);
                this.1.set(false);
                return;
            }
            List<BlockPos> list2 = this.a();
            if (!list2.isEmpty() && (blockPos = this.c(list2, list)) != null) {
                this.c = blockPos;
                this.c = this.0(this.c);
            }
        }
        this.1.set(false);
    }

    public void c(BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > 1500L) {
            this.c.remove(blockPos);
        }
    }

    public static Thread 0(4g_0 g_02) {
        return g_02.c;
    }

    public void 0() {
        BlockPos blockPos;
        List<BlockPos> list;
        if (g.6() != 45.c && (g.6() != 45.1 || this.0 == null || (double)this.0.ticksExisted >= Math.floor(((Integer)h.6()).intValue()))) {
            int n2 = (int)Math.max(100.0f, (float)(8E.0() + 50) / (8B.c.1() / 20.0f)) + 150;
            if (this.3 != null && !this.6.c((double)(n2 + 100)) && this.c(this.3)) {
                this.c = this.3;
                this.c = this.0(this.c);
                if (this.c != null) {
                    if (!this.c(this.c, this.c)) {
                        this.c = null;
                        return;
                    }
                    this.0.c();
                    this.c = null;
                }
                return;
            }
        }
        if (!(list = this.a()).isEmpty() && (blockPos = this.c(list, this.e())) != null) {
            this.c = blockPos;
            this.c = this.0(this.c);
            if (this.c != null) {
                if (!this.c(this.c, this.c)) {
                    this.c = null;
                    return;
                }
                this.0.c();
                this.c = null;
            }
        }
    }

    @Subscriber
    public void c(1N n2) {
        if (n2.c() == TickEvent.Phase.START) {
            this.c.set(true);
        } else {
            this.c.set(false);
        }
    }

    public 4g_0() {
        super("AutoCrystal", "Automatically places crystals around you", 3D.c, new String[0]);
        this.0 = new 9m();
        this.1 = new 9m();
        this.2 = new 9m();
        this.3 = new 9m();
        this.4 = new 9m();
        this.c = new ConcurrentHashMap();
        this.0 = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.c = new CopyOnWriteArrayList();
        this.c = new AtomicBoolean(false);
        this.5 = new 9m();
        this.6 = new 9m();
        this.7 = new 9m();
        this.8 = new 9m();
        this.0 = new AtomicBoolean(false);
        this.1 = new AtomicBoolean(false);
        this.9 = new 9m();
    }

    public static boolean 1(Entity entity) {
        return entity.getPositionVector().distanceTo(4g_0.c.player.getPositionEyes(1.0f)) < (double)((Float)r.6()).floatValue() || 8E.c(entity.posX, entity.posY, entity.posZ);
    }

    public boolean g() {
        int n2 = 8E.c();
        if (4g_0.c.player.inventory.currentItem != n2 && n2 != -1) {
            if (w.6() == 4a_0.1) {
                this.3 = 4g_0.c.player.inventory.currentItem;
            }
            4g_0.c.player.inventory.currentItem = n2;
            4g_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
        }
        return n2 != -1;
    }

    @Subscriber
    public void c(0S s) {
        block4: {
            block6: {
                block5: {
                    block3: {
                        if (!(s.c() instanceof SPacketSpawnObject)) break block3;
                        SPacketSpawnObject sPacketSpawnObject = (SPacketSpawnObject)s.c();
                        if (sPacketSpawnObject.getType() != 51) break block4;
                        this.c.forEach((arg_0, arg_1) -> this.c(sPacketSpawnObject, arg_0, arg_1));
                        break block4;
                    }
                    if (!(s.c() instanceof SPacketSoundEffect)) break block5;
                    SPacketSoundEffect sPacketSoundEffect = (SPacketSoundEffect)s.c();
                    if (sPacketSoundEffect.getCategory() != SoundCategory.BLOCKS || sPacketSoundEffect.getSound() != SoundEvents.ENTITY_GENERIC_EXPLODE) break block4;
                    if (this.0 != null && this.0.getDistance(sPacketSoundEffect.getX(), sPacketSoundEffect.getY(), sPacketSoundEffect.getZ()) < 6.0) {
                        this.0 = null;
                    }
                    try {
                        this.c.remove(new BlockPos(sPacketSoundEffect.getX(), sPacketSoundEffect.getY() - 1.0, sPacketSoundEffect.getZ()));
                    }
                    catch (ConcurrentModificationException concurrentModificationException) {}
                    break block4;
                }
                if (!(s.c() instanceof SPacketEntityStatus)) break block6;
                SPacketEntityStatus sPacketEntityStatus = (SPacketEntityStatus)s.c();
                if (sPacketEntityStatus.getOpCode() != 35 || !(sPacketEntityStatus.getEntity((World)4g_0.c.world) instanceof EntityPlayer)) break block4;
                this.c.put((EntityPlayer)sPacketEntityStatus.getEntity((World)4g_0.c.world), new 9m());
                break block4;
            }
            if (!(s.c() instanceof SPacketPlayerPosLook) || !((Boolean)S.6()).booleanValue() || 3F.c(54.class).f()) break block4;
            this.d();
        }
    }

    public static boolean 4(EntityPlayer entityPlayer) {
        return !8J.2(entityPlayer.getUniqueID().toString());
    }

    public static void c(4g_0 g_02) {
        g_02.0();
    }

    public void c(SPacketSpawnObject sPacketSpawnObject, BlockPos blockPos, Long l2) {
        block17: {
            if (!(this.c((double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, sPacketSpawnObject.getX(), sPacketSpawnObject.getY() - 1.0, sPacketSpawnObject.getZ()) < 1.0)) break block17;
            Vec3d vec3d = this.c;
            BlockPos blockPos2 = blockPos;
            vec3d.remove(blockPos2);
            this.3 = null;
            Boolean bl = (Boolean)5.6();
            try {
                if (!bl.booleanValue() && ((Boolean)4.6()).booleanValue()) {
                    this.8.c();
                }
            }
            catch (ConcurrentModificationException concurrentModificationException) {
                // empty catch block
            }
            if (2.6() != 4e_0.0) {
                return;
            }
            if (!this.2.c(((Float)x.6()).floatValue() * 100.0f)) {
                return;
            }
            if (this.c.get()) {
                return;
            }
            if (4g_0.c.player.isPotionActive(MobEffects.WEAKNESS)) {
                return;
            }
            if (this.0.containsKey(sPacketSpawnObject.getEntityID())) {
                return;
            }
            if (4g_0.c.player.getHealth() + 4g_0.c.player.getAbsorptionAmount() < ((Float)R.6()).floatValue() || (Boolean)P.6() != false && 3F.c(4x_0.class).f() || (Boolean)Q.6() != false && 3F.c(4E.class).f() || (Boolean)N.6() != false && 4g_0.c.player.getActiveItemStack().getItem() instanceof ItemFood || ((Boolean)M.6()).booleanValue() && 4g_0.c.playerController.getIsHittingBlock() && 4g_0.c.player.getHeldItemMainhand().getItem() instanceof ItemTool) {
                this.c = null;
                return;
            }
            Vec3d vec3d2 = new Vec3d(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
            if (4g_0.c.player.getPositionEyes(1.0f).distanceTo(vec3d2) > (double)((Float)q.6()).floatValue()) {
                return;
            }
            if (!this.1.c(1000.0f - ((Float)j.6()).floatValue() * 50.0f)) {
                return;
            }
            if (8E.c(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ(), (Entity)4g_0.c.player) + 2.0f >= 4g_0.c.player.getHealth() + 4g_0.c.player.getAbsorptionAmount()) {
                return;
            }
            this.0.put(sPacketSpawnObject.getEntityID(), System.currentTimeMillis());
            this.0 = new Vec3d(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
            CPacketUseEntity cPacketUseEntity = new CPacketUseEntity();
            ((ICPacketUseEntity)cPacketUseEntity).setEntityId(sPacketSpawnObject.getEntityID());
            ((ICPacketUseEntity)cPacketUseEntity).setAction(CPacketUseEntity.Action.ATTACK);
            4g_0.c.player.connection.sendPacket((Packet)new CPacketAnimation(this.9() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            4g_0.c.player.connection.sendPacket((Packet)cPacketUseEntity);
            this.c(this.9() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            this.2 = new BlockPos(sPacketSpawnObject.getX(), sPacketSpawnObject.getY() - 1.0, sPacketSpawnObject.getZ());
            this.4.c();
            this.1.c();
            this.5.c();
            if (l.6() == 4b_0.0) {
                this.0.c(0L);
            }
            if (l.6() == 4b_0.c) {
                this.1.set(true);
            }
            if (l.6() == 4b_0.0) {
                this.b();
            }
        }
    }

    public static boolean 2(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    public boolean 1(EntityPlayer entityPlayer) {
        if (!((Boolean)F.6()).booleanValue()) {
            return false;
        }
        for (int i2 = 3; i2 >= 0; --i2) {
            double d2;
            ItemStack itemStack = (ItemStack)entityPlayer.inventory.armorInventory.get(i2);
            if (itemStack == null || !((d2 = itemStack.getItem().getDurabilityForDisplay(itemStack)) > (double)((Float)G.6()).floatValue())) continue;
            return true;
        }
        return false;
    }

    public static boolean 0(EntityPlayer entityPlayer) {
        return entityPlayer != 4g_0.c.player && entityPlayer != c.getRenderViewEntity();
    }

    public static boolean 9(EntityPlayer entityPlayer) {
        return 4g_0.c.player.getDistance((Entity)entityPlayer) < ((Float)o.6()).floatValue();
    }

    public void c(Integer n2, Long l2) {
        if (System.currentTimeMillis() - l2 > 1000L) {
            this.0.remove(n2);
        }
    }

    public boolean 0(EntityEnderCrystal entityEnderCrystal) {
        if (entityEnderCrystal != null) {
            if (w.6() != 4a_0.c && 4g_0.c.player.isPotionActive(MobEffects.WEAKNESS) && !(4g_0.c.player.getHeldItemMainhand().getItem() instanceof ItemSword) && !this.g()) {
                return false;
            }
            if (!this.2.c(((Float)x.6()).floatValue() * 100.0f)) {
                return false;
            }
            4g_0.c.playerController.attackEntity((EntityPlayer)4g_0.c.player, (Entity)entityEnderCrystal);
            4g_0.c.player.connection.sendPacket((Packet)new CPacketAnimation(this.9() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            this.c(this.9() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            if (this.3 != -1 && 4g_0.c.player.getHeldItemMainhand().getItem() instanceof ItemSword) {
                4g_0.c.player.inventory.currentItem = this.3;
                4g_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.3));
                this.3 = -1;
            }
            if (l.6() == 4b_0.0) {
                this.0.c(0L);
            }
            if (l.6() == 4b_0.c) {
                this.1.set(true);
            }
            this.7.c();
            this.0 = entityEnderCrystal;
            this.2 = new BlockPos((Entity)entityEnderCrystal).down();
            this.4.c();
            return true;
        }
        return false;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block25: {
            Object object;
            if (4g_0.c.world == null || 4g_0.c.player == null) {
                return;
            }
            if (((Boolean)V.6()).booleanValue() && this.1 != null) {
                if (this.3.c(1000.0)) {
                    return;
                }
                object = null;
                try {
                    object = 4g_0.c.world.getBlockState(this.1).getBoundingBox((IBlockAccess)4g_0.c.world, this.1).offset(this.1);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (object == null) {
                    return;
                }
                99.c();
                99.c(object, ((89)00.6()).1((int)((float)((89)00.6()).1() * (1.0f - (float)Math.max(0L, System.currentTimeMillis() - this.3.0() - 150L) / 850.0f * ((Float)0c.6()).floatValue()))));
                if (((Float)X.6()).floatValue() > 0.0f) {
                    99.c(object, ((Float)X.6()).floatValue(), ((89)01.6()).1((int)((float)((89)01.6()).1() * (1.0f - (float)Math.max(0L, System.currentTimeMillis() - this.3.0() - 150L) / 850.0f * ((Float)0c.6()).floatValue()))));
                }
                99.0();
            }
            if (((Boolean)W.6()).booleanValue() && this.2 != null && !this.4.c(1000.0)) {
                if (!this.2.equals((Object)this.1)) {
                    object = null;
                    try {
                        object = 4g_0.c.world.getBlockState(this.2).getBoundingBox((IBlockAccess)4g_0.c.world, this.2).offset(this.2);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    if (object == null) {
                        return;
                    }
                    99.c();
                    99.c(object, ((89)00.6()).1((int)((float)((89)00.6()).1((int)((double)((89)00.6()).1() * 0.5)).1() * (1.0f - (float)Math.max(0L, System.currentTimeMillis() - this.4.0() - 150L) / 850.0f * ((Float)0c.6()).floatValue()))));
                    if (((Float)X.6()).floatValue() > 0.0f) {
                        99.c(object, ((Float)X.6()).floatValue(), ((89)01.6()).1((int)((float)((89)01.6()).1() * (1.0f - (float)Math.max(0L, System.currentTimeMillis() - this.4.0() - 150L) / 850.0f * ((Float)0c.6()).floatValue()))));
                    }
                    99.0();
                }
            }
            if (Y.6() == 48.c || this.1 == null) break block25;
            if (this.3.c(1000.0)) {
                return;
            }
            GlStateManager.pushMatrix();
            float f2 = (float)this.1.getX() + 0.5f;
            float f3 = (float)this.1.getY() + 0.5f;
            BlockPos blockPos = this.1;
            try {
                97.c(f2, f3, (float)blockPos.getZ() + 0.5f, (EntityPlayer)4g_0.c.player, 1.0f);
            }
            catch (Exception exception) {
                // empty catch block
            }
            object = (Math.floor(this.c) == (double)this.c ? Integer.valueOf((int)this.c) : String.format("%.1f", Float.valueOf(this.c))) + "";
            GlStateManager.disableDepth();
            if (((Boolean)Z.6()).booleanValue()) {
                GlStateManager.disableTexture2D();
            }
            GlStateManager.disableLighting();
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            if (((Boolean)Z.6()).booleanValue()) {
                GlStateManager.scale((double)0.3, (double)0.3, (double)1.0);
                if (Y.6() == 48.1) {
                    7J.0.0((String)object, (float)(-((double)7J.0.0((String)object) / 2.0)), (int)(-7J.0.c((String)object) / 2.0f), -1);
                } else {
                    7J.0.1((String)object, (float)(-((double)7J.0.0((String)object) / 2.0)), (int)(-7J.0.c((String)object) / 2.0f), -1);
                }
                GlStateManager.scale((double)3.3333333333333335, (double)3.3333333333333335, (double)1.0);
            } else if (Y.6() == 48.1) {
                4g_0.c.fontRenderer.drawStringWithShadow((String)object, (float)((int)(-((double)4g_0.c.fontRenderer.getStringWidth((String)object) / 2.0))), -4.0f, -1);
            } else {
                4g_0.c.fontRenderer.drawString((String)object, (int)(-((double)4g_0.c.fontRenderer.getStringWidth((String)object) / 2.0)), -4, -1);
            }
            GlStateManager.enableLighting();
            if (((Boolean)Z.6()).booleanValue()) {
                GlStateManager.enableTexture2D();
            }
            GlStateManager.enableDepth();
            GlStateManager.popMatrix();
        }
    }

    public boolean 2(Entity entity) {
        return !this.0.containsKey(entity.getEntityId()) && (!(entity instanceof EntityEnderCrystal) || entity.ticksExisted > 20);
    }

    public List<BlockPos> a() {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection)4g_0.c(new BlockPos((Entity)4g_0.c.player), ((Float)s.6()).floatValue(), ((Float)s.6()).intValue(), false, true, 0).stream().filter(this::c).collect(Collectors.toList()));
        return nonNullList;
    }

    public static Float 5(EntityPlayer entityPlayer) {
        return Float.valueOf(4g_0.c.player.getDistance((Entity)entityPlayer));
    }

    public static boolean d() {
        return l.6() == 4b_0.0;
    }

    public BlockPos c(List<BlockPos> list, List<EntityPlayer> list2) {
        if (list2.isEmpty()) {
            return null;
        }
        float f2 = 0.5f;
        EntityPlayer entityPlayer = null;
        BlockPos blockPos = null;
        this.2 = false;
        EntityPlayer entityPlayer2 = null;
        for (BlockPos blockPos2 : list) {
            float f3 = 8E.c(blockPos2, (Entity)4g_0.c.player);
            if (!((double)f3 + 2.0 < (double)(4g_0.c.player.getHealth() + 4g_0.c.player.getAbsorptionAmount())) || !(f3 <= ((Float)B.6()).floatValue())) continue;
            if (z.6() != 4d_0.c) {
                entityPlayer2 = list2.get(0);
                if (entityPlayer2.getDistance((double)blockPos2.getX() + 0.5, (double)blockPos2.getY() + 0.5, (double)blockPos2.getZ() + 0.5) > (double)((Float)p.6()).floatValue()) continue;
                float f4 = 8E.c(blockPos2, (Entity)entityPlayer2);
                if (this.c(entityPlayer2, f4) && (blockPos == null || entityPlayer2.getDistanceSq(blockPos2) < entityPlayer2.getDistanceSq(blockPos))) {
                    entityPlayer = entityPlayer2;
                    f2 = f4;
                    blockPos = blockPos2;
                    this.2 = true;
                    continue;
                }
                if (this.2 || !(f4 > f2) || !(f4 > f3) && !(f4 > entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount()) || f4 < ((Float)A.6()).floatValue() && entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount() > ((Float)D.6()).floatValue() && !8x_0.c(((8j_0)E.6()).c()) && !this.1(entityPlayer2)) continue;
                f2 = f4;
                entityPlayer = entityPlayer2;
                blockPos = blockPos2;
                continue;
            }
            for (EntityPlayer entityPlayer3 : list2) {
                if (entityPlayer3.equals((Object)entityPlayer2) || entityPlayer3.getDistance((double)blockPos2.getX() + 0.5, (double)blockPos2.getY() + 0.5, (double)blockPos2.getZ() + 0.5) > (double)((Float)p.6()).floatValue()) continue;
                float f5 = 8E.c(blockPos2, (Entity)entityPlayer3);
                if (this.c(entityPlayer3, f5) && (blockPos == null || entityPlayer3.getDistanceSq(blockPos2) < entityPlayer3.getDistanceSq(blockPos))) {
                    entityPlayer = entityPlayer3;
                    f2 = f5;
                    blockPos = blockPos2;
                    this.2 = true;
                    continue;
                }
                if (this.2 || !(f5 > f2) || !(f5 > f3) && !(f5 > entityPlayer3.getHealth() + entityPlayer3.getAbsorptionAmount()) || f5 < ((Float)A.6()).floatValue() && entityPlayer3.getHealth() + entityPlayer3.getAbsorptionAmount() > ((Float)D.6()).floatValue() && !8x_0.c(((8j_0)E.6()).c()) && !this.1(entityPlayer3)) continue;
                f2 = f5;
                entityPlayer = entityPlayer3;
                blockPos = blockPos2;
            }
        }
        if (entityPlayer != null && blockPos != null) {
            8k_0.c.c.1((Entity)entityPlayer);
            this.0(entityPlayer.getName());
            this.c = entityPlayer;
            this.9.c();
        } else {
            this.0((String)null);
        }
        if (blockPos != null) {
            this.1 = blockPos;
            this.c = f2;
        }
        this.3 = blockPos;
        this.6.c();
        return blockPos;
    }

    public static AtomicBoolean 2(4g_0 g_02) {
        return g_02.c;
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketHeldItemChange)) break block0;
            this.2.c();
        }
    }

    public static Float c(Entity entity) {
        return Float.valueOf(4g_0.c.player.getDistance(entity));
    }

    public boolean c(BlockPos blockPos, EnumFacing enumFacing) {
        if (blockPos != null) {
            if (v.6() != 4a_0.c && !this.7()) {
                return false;
            }
            if (!this.9() && 4g_0.c.player.getHeldItemMainhand().getItem() != Items.END_CRYSTAL) {
                if (this.2 != -1) {
                    4g_0.c.player.inventory.currentItem = this.2;
                    4g_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
                    this.2 = -1;
                }
                return false;
            }
            if (4g_0.c.world.getBlockState(blockPos.up()).getBlock() == Blocks.FIRE) {
                4g_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos.up(), EnumFacing.DOWN));
                4g_0.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos.up(), EnumFacing.DOWN));
                if (this.2 != -1) {
                    4g_0.c.player.inventory.currentItem = this.2;
                    4g_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
                    this.2 = -1;
                }
                return true;
            }
            6X.1 = true;
            this.1 = true;
            if (this.c == null) {
                8r_0.c(blockPos, 4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0), this.9() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, enumFacing, true);
            } else {
                4g_0.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, this.9() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, (float)(this.c.hitVec.x - (double)blockPos.getX()), (float)(this.c.hitVec.y - (double)blockPos.getY()), (float)(this.c.hitVec.z - (double)blockPos.getZ())));
                4g_0.c.player.connection.sendPacket((Packet)new CPacketAnimation(this.9() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            }
            if (this.2 && this.c != null) {
                this.c.put(this.c, new 9m());
            }
            this.1 = false;
            this.c.put(blockPos, System.currentTimeMillis());
            this.c.add(blockPos);
            this.3.c();
            this.0 = blockPos;
            if (this.2 != -1) {
                4g_0.c.player.inventory.currentItem = this.2;
                4g_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
                this.2 = -1;
            }
            return true;
        }
        return false;
    }

    public BlockPos 8() {
        return this.c;
    }

    public static boolean 0(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    public EnumFacing 0(BlockPos blockPos) {
        block26: {
            block25: {
                if (blockPos == null) break block25;
                if (4g_0.c.player != null) break block26;
            }
            return null;
        }
        EnumFacing enumFacing = null;
        if (b.6() != 46.c) {
            double[] dArray;
            Vec3d vec3d;
            RayTraceResult rayTraceResult;
            Vec3d vec3d2;
            Vec3d vec3d3;
            float f2;
            float f3;
            float f4;
            float f5;
            double[] dArray2;
            double d2;
            double d3;
            double d4;
            double d5;
            double d6;
            Vec3d vec3d4;
            double d7;
            double d8;
            double d9;
            Vec3d vec3d5 = null;
            double[] dArray3 = null;
            double d10 = 0.45;
            double d11 = 0.05;
            double d12 = 0.95;
            Vec3d vec3d6 = new Vec3d(4g_0.c.player.posX, 4g_0.c.player.getEntityBoundingBox().minY + (double)4g_0.c.player.getEyeHeight(), 4g_0.c.player.posZ);
            for (d9 = d11; d9 <= d12; d9 += d10) {
                for (d8 = d11; d8 <= d12; d8 += d10) {
                    for (d7 = d11; d7 <= d12; d7 += d10) {
                        vec3d4 = new Vec3d((Vec3i)blockPos).add(d9, d8, d7);
                        d6 = vec3d6.distanceTo(vec3d4);
                        d5 = vec3d4.x - vec3d6.x;
                        d4 = vec3d4.y - vec3d6.y;
                        d3 = vec3d4.z - vec3d6.z;
                        d2 = MathHelper.sqrt((double)(d5 * d5 + d3 * d3));
                        dArray2 = new double[]{MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d3, d5)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d4, d2)))))};
                        f5 = MathHelper.cos((float)((float)(-dArray2[0] * 0.01745329238474369 - 3.1415927410125732)));
                        f4 = MathHelper.sin((float)((float)(-dArray2[0] * 0.01745329238474369 - 3.1415927410125732)));
                        f3 = -MathHelper.cos((float)((float)(-dArray2[1] * 0.01745329238474369)));
                        f2 = MathHelper.sin((float)((float)(-dArray2[1] * 0.01745329238474369)));
                        vec3d3 = new Vec3d((double)(f4 * f3), (double)f2, (double)(f5 * f3));
                        vec3d2 = vec3d6.add(vec3d3.x * d6, vec3d3.y * d6, vec3d3.z * d6);
                        rayTraceResult = 4g_0.c.world.rayTraceBlocks(vec3d6, vec3d2, false, true, false);
                        if (!(((Float)t.6()).floatValue() >= ((Float)s.6()).floatValue())) {
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK || !rayTraceResult.getBlockPos().equals((Object)blockPos)) continue;
                        }
                        vec3d = vec3d4;
                        dArray = dArray2;
                        if (vec3d5 != null && dArray3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                            if (!(4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d) < 4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d5))) continue;
                            vec3d5 = vec3d;
                            dArray3 = dArray;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.c = rayTraceResult;
                            continue;
                        }
                        vec3d5 = vec3d;
                        dArray3 = dArray;
                        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                        enumFacing = rayTraceResult.sideHit;
                        this.c = rayTraceResult;
                    }
                }
            }
            if (((Float)t.6()).floatValue() < ((Float)s.6()).floatValue() && b.6() == 46.1) {
                if (dArray3 != null && enumFacing != null) {
                    this.c.c();
                    this.c = vec3d5;
                    this.c = 8M.c(4g_0.c.player.getPositionEyes(1.0f), this.c);
                    return enumFacing;
                }
                for (d9 = d11; d9 <= d12; d9 += d10) {
                    for (d8 = d11; d8 <= d12; d8 += d10) {
                        for (d7 = d11; d7 <= d12; d7 += d10) {
                            vec3d4 = new Vec3d((Vec3i)blockPos).add(d9, d8, d7);
                            d6 = vec3d6.distanceTo(vec3d4);
                            d5 = vec3d4.x - vec3d6.x;
                            d4 = vec3d4.y - vec3d6.y;
                            d3 = vec3d4.z - vec3d6.z;
                            d2 = MathHelper.sqrt((double)(d5 * d5 + d3 * d3));
                            dArray2 = new double[]{MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d3, d5)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d4, d2)))))};
                            f5 = MathHelper.cos((float)((float)(-dArray2[0] * 0.01745329238474369 - 3.1415927410125732)));
                            f4 = MathHelper.sin((float)((float)(-dArray2[0] * 0.01745329238474369 - 3.1415927410125732)));
                            f3 = -MathHelper.cos((float)((float)(-dArray2[1] * 0.01745329238474369)));
                            f2 = MathHelper.sin((float)((float)(-dArray2[1] * 0.01745329238474369)));
                            vec3d3 = new Vec3d((double)(f4 * f3), (double)f2, (double)(f5 * f3));
                            vec3d2 = vec3d6.add(vec3d3.x * d6, vec3d3.y * d6, vec3d3.z * d6);
                            rayTraceResult = 4g_0.c.world.rayTraceBlocks(vec3d6, vec3d2, false, true, true);
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                            vec3d = vec3d4;
                            dArray = dArray2;
                            if (vec3d5 != null && dArray3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                if (!(4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d) < 4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d5))) continue;
                                vec3d5 = vec3d;
                                dArray3 = dArray;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.c = rayTraceResult;
                                continue;
                            }
                            vec3d5 = vec3d;
                            dArray3 = dArray;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.c = rayTraceResult;
                        }
                    }
                }
            } else {
                if (dArray3 != null) {
                    this.c.c();
                    this.c = vec3d5;
                    this.c = 8M.c(4g_0.c.player.getPositionEyes(1.0f), this.c);
                }
                if (enumFacing != null) {
                    return enumFacing;
                }
            }
        } else {
            Vec3d vec3d;
            EnumFacing enumFacing2 = null;
            Vec3d vec3d7 = null;
            for (EnumFacing enumFacing3 : EnumFacing.values()) {
                vec3d = new Vec3d((double)blockPos.getX() + 0.5 + (double)enumFacing3.getDirectionVec().getX() * 0.5, (double)blockPos.getY() + 0.5 + (double)enumFacing3.getDirectionVec().getY() * 0.5, (double)blockPos.getZ() + 0.5 + (double)enumFacing3.getDirectionVec().getZ() * 0.5);
                RayTraceResult rayTraceResult = 4g_0.c.world.rayTraceBlocks(new Vec3d(4g_0.c.player.posX, 4g_0.c.player.posY + (double)4g_0.c.player.getEyeHeight(), 4g_0.c.player.posZ), vec3d, false, true, false);
                if (rayTraceResult == null || !rayTraceResult.typeOfHit.equals((Object)RayTraceResult.Type.BLOCK) || !rayTraceResult.getBlockPos().equals((Object)blockPos) || vec3d7 != null && !(4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d) < 4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d7))) continue;
                vec3d7 = vec3d;
                enumFacing2 = enumFacing3;
                this.c = rayTraceResult;
            }
            if (enumFacing2 != null) {
                this.c.c();
                this.c = vec3d7;
                this.c = 8M.c(4g_0.c.player.getPositionEyes(1.0f), this.c);
                return enumFacing2;
            }
            for (EnumFacing enumFacing3 : EnumFacing.values()) {
                vec3d = new Vec3d((double)blockPos.getX() + 0.5 + (double)enumFacing3.getDirectionVec().getX() * 0.5, (double)blockPos.getY() + 0.5 + (double)enumFacing3.getDirectionVec().getY() * 0.5, (double)blockPos.getZ() + 0.5 + (double)enumFacing3.getDirectionVec().getZ() * 0.5);
                if (vec3d7 != null && !(4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d) < 4g_0.c.player.getPositionVector().add(0.0, (double)4g_0.c.player.getEyeHeight(), 0.0).distanceTo(vec3d7))) continue;
                vec3d7 = vec3d;
                enumFacing2 = enumFacing3;
            }
            if (enumFacing2 != null) {
                this.c.c();
                this.c = vec3d7;
                this.c = 8M.c(4g_0.c.player.getPositionEyes(1.0f), this.c);
                return enumFacing2;
            }
        }
        if ((double)blockPos.getY() > 4g_0.c.player.posY + (double)4g_0.c.player.getEyeHeight()) {
            this.c.c();
            this.c = new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 1.0, (double)blockPos.getZ() + 0.5);
            this.c = 8M.c(4g_0.c.player.getPositionEyes(1.0f), this.c);
            return EnumFacing.DOWN;
        }
        this.c.c();
        this.c = new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 1.0, (double)blockPos.getZ() + 0.5);
        this.c = 8M.c(4g_0.c.player.getPositionEyes(1.0f), this.c);
        return EnumFacing.UP;
    }

    public EntityEnderCrystal c(List<EntityPlayer> list) {
        this.0.forEach(this::c);
        if (l.6() == 4b_0.c && !((Boolean)5.6()).booleanValue() && this.1.get()) {
            return null;
        }
        EntityEnderCrystal entityEnderCrystal = null;
        int n2 = (int)Math.max(100.0f, (float)(8E.0() + 50) / (8B.c.1() / 20.0f)) + 150;
        if (((Boolean)4.6()).booleanValue() && !((Boolean)5.6()).booleanValue() && !this.7.c((double)n2) && this.0 != null && 4g_0.c.world.getEntityByID(this.0.getEntityId()) != null && this.c(this.0)) {
            entityEnderCrystal = this.0;
            return entityEnderCrystal;
        }
        List<Entity> list2 = this.1();
        if (list2.isEmpty()) {
            return null;
        }
        entityEnderCrystal = list2.stream().filter(this::3).filter(4g_0::1).min(Comparator.comparing(4g_0::c)).orElse(null);
        return entityEnderCrystal;
    }

    public static boolean 6() {
        return (Boolean)5.6() == false;
    }

    public boolean c(BlockPos blockPos) {
        if (4g_0.c.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && 4g_0.c.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
            return false;
        }
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        if (!(4g_0.c.world.getBlockState(blockPos2).getBlock() == Blocks.AIR || 4g_0.c.world.getBlockState(blockPos2).getBlock() == Blocks.FIRE && ((Boolean)e.6()).booleanValue())) {
            return false;
        }
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        if (!((Boolean)d.6()).booleanValue() && 4g_0.c.world.getBlockState(blockPos3).getBlock() != Blocks.AIR) {
            4g_0.c.world.getBlockState(blockPos2).getBlock();
            return false;
        }
        if (((Boolean)a.6()).booleanValue() && !8E.c((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 1.0, (double)blockPos.getZ() + 0.5)) {
            Vec3d vec3d = new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 1.0, (double)blockPos.getZ() + 0.5);
            if (4g_0.c.player.getPositionEyes(1.0f).distanceTo(vec3d) > (double)((Float)r.6()).floatValue()) {
                return false;
            }
        }
        if (((Float)t.6()).floatValue() < ((Float)s.6()).floatValue() && ((double)blockPos.getY() > 4g_0.c.player.posY + (double)4g_0.c.player.getEyeHeight() ? 4g_0.c.player.getDistance((double)blockPos.getX() + 0.5, (double)blockPos.getY(), (double)blockPos.getZ() + 0.5) > (double)((Float)t.6()).floatValue() && !8E.c(blockPos) : 4g_0.c.player.getDistance((double)blockPos.getX() + 0.5, (double)(blockPos.getY() + 1), (double)blockPos.getZ() + 0.5) > (double)((Float)t.6()).floatValue() && !8E.c(blockPos))) {
            return false;
        }
        return 4g_0.c.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2, blockPos3.add(1, 1, 1))).stream().filter(this::2).count() == 0L;
    }

    public boolean 3(Entity entity) {
        return this.c.contains(new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ)) || 8E.c((EntityEnderCrystal)entity, (Entity)4g_0.c.player) < ((Float)C.6()).floatValue();
    }

    public boolean c(EntityPlayer entityPlayer, float f2) {
        if (entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount() <= 2.0f && (double)f2 > (double)entityPlayer.getHealth() + (double)entityPlayer.getAbsorptionAmount() + 0.5 && f2 <= 4.0f) {
            9m m2 = (9m)this.c.get(entityPlayer);
            return m2 == null || m2.c(500.0);
        }
        return false;
    }

    public static Float 3(EntityPlayer entityPlayer) {
        return Float.valueOf(4g_0.c.player.getDistance((Entity)entityPlayer));
    }

    public static boolean 7(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }

    public static List<BlockPos> c(BlockPos blockPos, float f2, int n2, boolean bl, boolean bl2, int n3) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n4 = blockPos.getX();
        int n5 = blockPos.getY();
        int n6 = blockPos.getZ();
        int n7 = n4 - (int)f2;
        while ((float)n7 <= (float)n4 + f2) {
            int n8 = n6 - (int)f2;
            while ((float)n8 <= (float)n6 + f2) {
                int n9 = bl2 ? n5 - (int)f2 : n5;
                while (true) {
                    float f3 = n9;
                    float f4 = bl2 ? (float)n5 + f2 : (float)(n5 + n2);
                    if (!(f3 < f4)) break;
                    double d2 = (n4 - n7) * (n4 - n7) + (n6 - n8) * (n6 - n8) + (bl2 ? (n5 - n9) * (n5 - n9) : 0);
                    if (!(!(d2 < (double)(f2 * f2)) || bl && d2 < (double)((f2 - 1.0f) * (f2 - 1.0f)))) {
                        BlockPos blockPos2 = new BlockPos(n7, n9 + n3, n8);
                        arrayList.add(blockPos2);
                    }
                    ++n9;
                }
                ++n8;
            }
            ++n7;
        }
        return arrayList;
    }

    public static AtomicBoolean 1(4g_0 g_02) {
        return g_02.0;
    }

    public void b() {
        if (((Float)m.6()).floatValue() == 0.0f) {
            this.0();
        } else {
            this.0.set(true);
            if (this.c == null || this.c.isInterrupted() || !this.c.isAlive()) {
                if (this.c == null) {
                    this.c = new Thread(47.0(this));
                }
                if (this.c != null && (this.c.isInterrupted() || !this.c.isAlive())) {
                    this.c = new Thread(47.0(this));
                }
                if (this.c != null && this.c.getState() == Thread.State.NEW) {
                    try {
                        this.c.start();
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
        }
    }

    public double c(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        double d10 = d4 - d7;
        return Math.sqrt(d8 * d8 + d9 * d9 + d10 * d10);
    }

    public boolean 7() {
        block3: {
            if (this.9()) {
                return true;
            }
            int n2 = 8E.1();
            if (n2 == -1) {
                return false;
            }
            if (4g_0.c.player.inventory.currentItem == n2) break block3;
            if (v.6() == 4a_0.1) {
                this.2 = 4g_0.c.player.inventory.currentItem;
            }
            4g_0.c.player.inventory.currentItem = n2;
            4g_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
        }
        return true;
    }

    public boolean 9() {
        return 4g_0.c.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }
}

