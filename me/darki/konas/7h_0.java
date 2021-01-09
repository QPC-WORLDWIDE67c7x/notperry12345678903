/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.ArrayList;
import me.darki.konas.1N;
import me.darki.konas.1T;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

/*
 * Renamed from me.darki.konas.7h
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7h_0
extends 3E {
    public static ArrayList<Vec3d> 0 = new ArrayList();
    public static 8h_0<Boolean> 1 = new 8h_0("OnlyRender", false);
    public 8h_0<Integer> 2 = new 8h_0("MaxVertices", 50, 250, 25, 25);
    public 8h_0<89> 3 = new 8h_0("Color", new 89(Color.WHITE.hashCode()));

    @Subscriber
    public void c(1b_0 b_02) {
        if (7h_0.c.player == null || 7h_0.c.world == null) {
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
        GlStateManager.color((float)((float)((89)this.3.6()).4().getRed() / 255.0f), (float)((float)((89)this.3.6()).4().getGreen() / 255.0f), (float)((float)((89)this.3.6()).4().getBlue() / 255.0f), (float)((float)((89)this.3.6()).4().getAlpha() / 255.0f));
        double d2 = 7h_0.c.player.lastTickPosX + (7h_0.c.player.posX - 7h_0.c.player.lastTickPosX) * (double)b_02.c();
        double d3 = 7h_0.c.player.lastTickPosY + (7h_0.c.player.posY - 7h_0.c.player.lastTickPosY) * (double)b_02.c();
        double d4 = 7h_0.c.player.lastTickPosZ + (7h_0.c.player.posZ - 7h_0.c.player.lastTickPosZ) * (double)b_02.c();
        GL11.glBegin((int)3);
        for (Vec3d vec3d : 0) {
            Vec3d vec3d2 = vec3d.subtract(d2, d3, d4);
            GL11.glVertex3d((double)vec3d2.x, (double)vec3d2.y, (double)vec3d2.z);
        }
        GL11.glEnd();
        GL11.glPopMatrix();
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
    }

    public 7h_0() {
        super("Breadcrumbs", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(1T t) {
        0.clear();
    }

    @Subscriber
    public void c(1N n2) {
        block7: {
            block6: {
                if (7h_0.c.player == null || 7h_0.c.world == null) {
                    return;
                }
                if (((Boolean)1.6()).booleanValue()) {
                    return;
                }
                if (7h_0.c.player.posX != 7h_0.c.player.lastTickPosX) break block6;
                if (7h_0.c.player.posY == 7h_0.c.player.lastTickPosY && 7h_0.c.player.posZ == 7h_0.c.player.lastTickPosZ) break block7;
            }
            0.add(7h_0.c.player.getPositionVector());
            if (0.size() >= (Integer)this.2.6() * 10000) {
                0.remove(0);
                0.remove(1);
            }
        }
    }
}

