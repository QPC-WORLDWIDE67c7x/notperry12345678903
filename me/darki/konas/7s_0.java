/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.darki.konas.1N;
import me.darki.konas.1T;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7r_0;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.7s
 */
public class 7s_0
extends 3E {
    public ConcurrentHashMap<Integer, 7r_0> c = new ConcurrentHashMap();
    public 8h_0<89> 1 = new 8h_0("Color", new 89(Color.WHITE.hashCode()));
    public 8h_0<Boolean> 2 = new 8h_0("Timeout", true);
    public 8h_0<Integer> 3 = new 8h_0("Seconds", 10, 100, 0, 1).c(this.2::6);

    @Override
    public void c() {
        this.c.clear();
    }

    public void 0(Entity entity) {
        block2: {
            if (entity.ticksExisted <= 1 || !this.1(entity)) break block2;
            if (!this.c.containsKey(entity.getEntityId())) {
                ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
                arrayList.add(new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ));
                this.c.put(entity.getEntityId(), new 7r_0(System.currentTimeMillis(), arrayList));
            } else {
                this.c.get(entity.getEntityId()).0().add(new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ));
                this.c.get(entity.getEntityId()).c(System.currentTimeMillis());
            }
        }
    }

    public static boolean c(Entity entity) {
        return ((Minecraft)7s_0.c).player != entity;
    }

    public boolean 1(Entity entity) {
        if (entity instanceof EntitySnowball) {
            return true;
        }
        if (entity instanceof EntityArrow) {
            return true;
        }
        if (entity instanceof EntityEnderPearl) {
            return true;
        }
        return entity instanceof EntityEgg;
    }

    public static void c(double d2, double d3, double d4, Integer n2, 7r_0 r_02) {
        GL11.glBegin((int)3);
        for (Vec3d vec3d : r_02.0()) {
            Vec3d vec3d2 = vec3d.subtract(d2, d3, d4);
            GL11.glVertex3d((double)vec3d2.x, (double)vec3d2.y, (double)vec3d2.z);
        }
        GL11.glEnd();
    }

    @Subscriber
    public void c(1N n2) {
        block1: {
            if (((Minecraft)7s_0.c).player == null || ((Minecraft)7s_0.c).world == null) {
                return;
            }
            7s_0.c.world.loadedEntityList.stream().filter(7s_0::c).forEach(this::0);
            if (!((Boolean)this.2.6()).booleanValue()) break block1;
            this.c.forEach(this::c);
        }
    }

    @Subscriber
    public void c(1b_0 b_02) {
        if (((Minecraft)7s_0.c).player == null || ((Minecraft)7s_0.c).world == null) {
            return;
        }
        GL11.glBlendFunc((int)770, (int)771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float)1.5f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GL11.glEnable((int)2848);
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GL11.glHint((int)3154, (int)4354);
        GlStateManager.depthMask((boolean)false);
        GlStateManager.color((float)((float)((89)this.1.6()).4().getRed() / 255.0f), (float)((float)((89)this.1.6()).4().getGreen() / 255.0f), (float)((float)((89)this.1.6()).4().getBlue() / 255.0f), (float)((float)((89)this.1.6()).4().getAlpha() / 255.0f));
        double d2 = 7s_0.c.player.lastTickPosX + (7s_0.c.player.posX - 7s_0.c.player.lastTickPosX) * (double)b_02.c();
        double d3 = 7s_0.c.player.lastTickPosY + (7s_0.c.player.posY - 7s_0.c.player.lastTickPosY) * (double)b_02.c();
        double d4 = 7s_0.c.player.lastTickPosZ + (7s_0.c.player.posZ - 7s_0.c.player.lastTickPosZ) * (double)b_02.c();
        this.c.forEach((arg_0, arg_1) -> 7s_0.c(d2, d3, d4, arg_0, arg_1));
        GL11.glPopMatrix();
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
    }

    public void c(Integer n2, 7r_0 r_02) {
        if (System.currentTimeMillis() - r_02.c() > 1000L * (long)((Integer)this.3.6()).intValue()) {
            this.c.remove(n2);
        }
    }

    public 7s_0() {
        super("EntityTrails", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(1T t) {
        this.c.clear();
    }
}

