/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1P;
import me.darki.konas.1a_0;
import me.darki.konas.1e_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.IMinecraft;
import me.darki.konas.mixin.mixins.ITimer;
import me.darki.konas.util.math.Interpolation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

/*
 * Renamed from me.darki.konas.7m
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7m_0
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("Dot", false);
    public 8h_0<Float> 2 = new 8h_0("Gap", Float.valueOf(2.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.5f));
    public 8h_0<Float> 3 = new 8h_0("MotionGap", Float.valueOf(0.0f), Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(0.05f));
    public 8h_0<Float> 4 = new 8h_0("Width", Float.valueOf(1.0f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public 8h_0<Float> 5 = new 8h_0("MotionWidth", Float.valueOf(0.0f), Float.valueOf(2.5f), Float.valueOf(0.0f), Float.valueOf(0.05f));
    public 8h_0<Float> 6 = new 8h_0("Size", Float.valueOf(2.0f), Float.valueOf(40.0f), Float.valueOf(1.0f), Float.valueOf(0.5f));
    public 8h_0<Float> 7 = new 8h_0("MotionSize", Float.valueOf(0.0f), Float.valueOf(20.0f), Float.valueOf(0.0f), Float.valueOf(0.2f));
    public 8h_0<89> 8 = new 8h_0("Color", new 89(-1));
    public long c;
    public float c = 0.0f;
    public float 0 = 0.0f;

    @Subscriber
    public void c(1e_0 e_02) {
        e_02.c(true);
    }

    @Subscriber
    public void c(1P p2) {
        this.0 = this.c;
        double d2 = 7m_0.c.player.posX - 7m_0.c.player.prevPosX;
        double d3 = 7m_0.c.player.posZ - 7m_0.c.player.prevPosZ;
        this.c = (float)Math.sqrt(d2 * d2 + d3 * d3);
        this.c = System.currentTimeMillis();
    }

    public 7m_0() {
        super("Crosshair", "Draws a custom crosshair", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(1a_0 a_02) {
        block0: {
            ScaledResolution scaledResolution = new ScaledResolution((Minecraft)c);
            float f2 = (float)(scaledResolution.getScaledWidth_double() / 2.0 + 0.5);
            float f3 = (float)(scaledResolution.getScaledHeight_double() / 2.0 + 0.5);
            float f4 = ((Float)this.2.6()).floatValue();
            float f5 = Math.max(((Float)this.4.6()).floatValue(), 0.5f);
            float f6 = ((Float)this.6.6()).floatValue();
            float f7 = ((ITimer)((IMinecraft)c).getTimer()).getTickLength();
            7m_0.c(f2 - (f4 += Interpolation.lerp(this.0, this.c, Math.min((float)(System.currentTimeMillis() - this.c) / f7, 1.0f)) * ((Float)this.3.6()).floatValue()) - (f6 += Interpolation.lerp(this.0, this.c, Math.min((float)(System.currentTimeMillis() - this.c) / f7, 1.0f)) * ((Float)this.7.6()).floatValue()), f3 - (f5 += Interpolation.lerp(this.0, this.c, Math.min((float)(System.currentTimeMillis() - this.c) / f7, 1.0f)) * ((Float)this.5.6()).floatValue()) / 2.0f, f2 - f4, f3 + f5 / 2.0f, ((89)this.8.6()).c());
            7m_0.c(f2 + f4 + f6, f3 - f5 / 2.0f, f2 + f4, f3 + f5 / 2.0f, ((89)this.8.6()).c());
            7m_0.c(f2 - f5 / 2.0f, f3 + f4 + f6, f2 + f5 / 2.0f, f3 + f4, ((89)this.8.6()).c());
            7m_0.c(f2 - f5 / 2.0f, f3 - f4 - f6, f2 + f5 / 2.0f, f3 - f4, ((89)this.8.6()).c());
            if (!((Boolean)this.1.6()).booleanValue()) break block0;
            7m_0.c(f2 - f5 / 2.0f, f3 - f5 / 2.0f, f2 + f5 / 2.0f, f3 + f5 / 2.0f, ((89)this.8.6()).c());
        }
    }

    public static void c(float f2, float f3, float f4, float f5, int n2) {
        float f6;
        if (f2 < f4) {
            f6 = f2;
            f2 = f4;
            f4 = f6;
        }
        if (f3 < f5) {
            f6 = f3;
            f3 = f5;
            f5 = f6;
        }
        f6 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)f7, (float)f8, (float)f9, (float)f6);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double)f2, (double)f5, 0.0).endVertex();
        bufferBuilder.pos((double)f4, (double)f5, 0.0).endVertex();
        bufferBuilder.pos((double)f4, (double)f3, 0.0).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
}

