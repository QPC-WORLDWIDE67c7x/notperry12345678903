/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.1P;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7W;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.server.SPacketSpawnMob;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7X
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Crystals", true);
    public static 8h_0<Boolean> 2 = new 8h_0("OnlyOwn", false).c(1::6);
    public static 8h_0<Boolean> 3 = new 8h_0("Players", false);
    public static 8h_0<Boolean> 4 = new 8h_0("Mobs", false);
    public static 8h_0<Boolean> 5 = new 8h_0("Boats", false);
    public static 8h_0<Float> 6 = new 8h_0("Duration", Float.valueOf(1.0f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<89> 7 = new 8h_0("Color", new 89(-65536, true));
    public static 8h_0<Float> 8 = new 8h_0("Width", Float.valueOf(2.5f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public CopyOnWriteArrayList<7W> c;
    public ConcurrentHashMap<BlockPos, Long> c = new ConcurrentHashMap();

    @Subscriber
    public void c(1P p2) {
        block0: {
            if (7X.c.player.ticksExisted % 20 != 0 || !((Boolean)2.6()).booleanValue()) break block0;
            ((ConcurrentHashMap)((Object)this.c)).forEach(this::c);
        }
    }

    public void c(BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > 2500L) {
            ((ConcurrentHashMap)((Object)this.c)).remove(blockPos);
        }
    }

    public 7X() {
        super("Spawns", "Renders entity spawning", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(1b_0 b_02) {
        for (7W w : this.c) {
            int n2;
            if ((float)(System.currentTimeMillis() - 7W.1(w)) > 1000.0f * ((Float)6.6()).floatValue()) {
                this.c.remove(w);
                continue;
            }
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableTexture2D();
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            IRenderManager iRenderManager = (IRenderManager)c.getRenderManager();
            float[] fArray = Color.RGBtoHSB(((89)7.6()).6(), ((89)7.6()).5(), ((89)7.6()).2(), null);
            float f2 = (float)(System.currentTimeMillis() % 7200L) / 7200.0f;
            int n3 = Color.getHSBColor(f2, fArray[1], fArray[2]).getRGB();
            ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
            double d2 = 7W.2((7W)w).x - iRenderManager.getRenderPosX();
            double d3 = 7W.2((7W)w).y - iRenderManager.getRenderPosY();
            double d4 = 7W.2((7W)w).z - iRenderManager.getRenderPosZ();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glLineWidth((float)((Float)8.6()).floatValue());
            GL11.glEnable((int)2848);
            GL11.glHint((int)3154, (int)4354);
            GL11.glBegin((int)1);
            for (n2 = 0; n2 <= 360; ++n2) {
                Vec3d vec3d = new Vec3d(d2 + Math.sin((double)n2 * Math.PI / 180.0) * (double)7W.0(w), d3 + (double)(7W.c(w) * ((float)(System.currentTimeMillis() - 7W.1(w)) / (1000.0f * ((Float)6.6()).floatValue()))), d4 + Math.cos((double)n2 * Math.PI / 180.0) * (double)7W.0(w));
                arrayList.add(vec3d);
            }
            for (n2 = 0; n2 < arrayList.size() - 1; ++n2) {
                int n4 = n3 >> 24 & 0xFF;
                int n5 = n3 >> 16 & 0xFF;
                int n6 = n3 >> 8 & 0xFF;
                int n7 = n3 & 0xFF;
                if (((89)7.6()).7()) {
                    GL11.glColor4f((float)((float)n5 / 255.0f), (float)((float)n6 / 255.0f), (float)((float)n7 / 255.0f), (float)((float)n4 / 255.0f));
                } else {
                    GL11.glColor4f((float)((float)((89)7.6()).6() / 255.0f), (float)((float)((89)7.6()).5() / 255.0f), (float)((float)((89)7.6()).2() / 255.0f), (float)((float)((89)7.6()).1() / 255.0f));
                }
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)n2)).x, (double)((Vec3d)arrayList.get((int)n2)).y, (double)((Vec3d)arrayList.get((int)n2)).z);
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)(n2 + 1))).x, (double)((Vec3d)arrayList.get((int)(n2 + 1))).y, (double)((Vec3d)arrayList.get((int)(n2 + 1))).z);
                n3 = Color.getHSBColor(f2 += 0.0027777778f, fArray[1], fArray[2]).getRGB();
            }
            GL11.glEnd();
            GL11.glDisable((int)2848);
            GlStateManager.enableLighting();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    @Subscriber
    public void c(0S s) {
        EntityLivingBase entityLivingBase;
        if (s.c() instanceof SPacketSpawnObject) {
            if (((SPacketSpawnObject)s.c()).getType() == 51 && ((Boolean)1.6()).booleanValue()) {
                if (((Boolean)2.6()).booleanValue()) {
                    BlockPos blockPos = new BlockPos(((SPacketSpawnObject)s.c()).getX(), ((SPacketSpawnObject)s.c()).getY(), ((SPacketSpawnObject)s.c()).getZ()).down();
                    if (((ConcurrentHashMap)((Object)this.c)).containsKey(blockPos)) {
                        ((ConcurrentHashMap)((Object)this.c)).remove(blockPos);
                        this.c.add(new 7W(new Vec3d(((SPacketSpawnObject)s.c()).getX(), ((SPacketSpawnObject)s.c()).getY(), ((SPacketSpawnObject)s.c()).getZ()), 1.5f, 0.5f));
                    }
                } else {
                    this.c.add(new 7W(new Vec3d(((SPacketSpawnObject)s.c()).getX(), ((SPacketSpawnObject)s.c()).getY(), ((SPacketSpawnObject)s.c()).getZ()), 1.5f, 0.5f));
                }
            } else if (((SPacketSpawnObject)s.c()).getType() == 1 && ((Boolean)5.6()).booleanValue()) {
                this.c.add(new 7W(new Vec3d(((SPacketSpawnObject)s.c()).getX(), ((SPacketSpawnObject)s.c()).getY(), ((SPacketSpawnObject)s.c()).getZ()), 1.0f, 0.75f));
            }
        } else if (s.c() instanceof SPacketSpawnPlayer && ((Boolean)3.6()).booleanValue()) {
            this.c.add(new 7W(new Vec3d(((SPacketSpawnPlayer)s.c()).getX(), ((SPacketSpawnPlayer)s.c()).getY(), ((SPacketSpawnPlayer)s.c()).getZ()), 1.8f, 0.5f));
        } else if (s.c() instanceof SPacketSpawnMob && ((Boolean)4.6()).booleanValue() && (entityLivingBase = (EntityLivingBase)EntityList.createEntityByID((int)((SPacketSpawnMob)s.c()).getEntityType(), (World)((Minecraft)7X.c).world)) != null) {
            this.c.add(new 7W(new Vec3d(((SPacketSpawnMob)s.c()).getX(), ((SPacketSpawnMob)s.c()).getY(), ((SPacketSpawnMob)s.c()).getZ()), entityLivingBase.height, entityLivingBase.width / 2.0f));
        }
    }

    @Subscriber
    public void c(0T t) {
        if (t.c() instanceof CPacketPlayerTryUseItemOnBlock && ((Boolean)2.6()).booleanValue() && ((Minecraft)7X.c).player.getHeldItem(((CPacketPlayerTryUseItemOnBlock)t.c()).getHand()).getItem() instanceof ItemEndCrystal) {
            ((ConcurrentHashMap)((Object)this.c)).put(((CPacketPlayerTryUseItemOnBlock)t.c()).getPos(), System.currentTimeMillis());
        }
    }
}

