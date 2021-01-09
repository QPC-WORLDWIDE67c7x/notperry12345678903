/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.96;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 95 {
    public static void c() {
        GL11.glStencilFunc((int)514, (int)1, (int)15);
        GL11.glStencilOp((int)7680, (int)7680, (int)7680);
        GL11.glPolygonMode((int)1032, (int)6913);
    }

    public static void c(int n2, float f2) {
        95.c(new Color(n2));
        GL11.glDepthMask((boolean)false);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)10754);
        GL11.glPolygonOffset((float)f2, (float)-2000000.0f);
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
    }

    public static void 0() {
        GL11.glStencilFunc((int)512, (int)0, (int)15);
        GL11.glStencilOp((int)7681, (int)7681, (int)7681);
        GL11.glPolygonMode((int)1032, (int)6914);
    }

    public static void c(Color color) {
        GL11.glColor4d((double)((float)color.getRed() / 255.0f), (double)((float)color.getGreen() / 255.0f), (double)((float)color.getBlue() / 255.0f), (double)((float)color.getAlpha() / 255.0f));
    }

    public static void 1() {
        Framebuffer framebuffer = 96.0().getFramebuffer();
        if (framebuffer.depthBuffer > -1) {
            95.c(framebuffer);
            framebuffer.depthBuffer = -1;
        }
    }

    public static void c(Framebuffer framebuffer) {
        EXTFramebufferObject.glDeleteRenderbuffersEXT((int)framebuffer.depthBuffer);
        int n2 = EXTFramebufferObject.glGenRenderbuffersEXT();
        EXTFramebufferObject.glBindRenderbufferEXT((int)36161, (int)n2);
        EXTFramebufferObject.glRenderbufferStorageEXT((int)36161, (int)34041, (int)96.0().displayWidth, (int)96.0().displayHeight);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int)36160, (int)36128, (int)36161, (int)n2);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int)36160, (int)36096, (int)36161, (int)n2);
    }

    public static void c(int n2) {
        95.1();
        GL11.glPushAttrib((int)1048575);
        GL11.glDisable((int)3008);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glLineWidth((float)n2);
        GL11.glEnable((int)2848);
        GL11.glEnable((int)2960);
        GL11.glClear((int)1024);
        GL11.glClearStencil((int)15);
        GL11.glStencilFunc((int)512, (int)1, (int)15);
        GL11.glStencilOp((int)7681, (int)7681, (int)7681);
        GL11.glPolygonMode((int)1032, (int)6913);
    }

    public static void c(float f2) {
        GL11.glPolygonOffset((float)(-f2), (float)2000000.0f);
        GL11.glDisable((int)10754);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)2960);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)3008);
        GL11.glPopAttrib();
    }
}

