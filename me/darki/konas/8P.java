/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.nio.FloatBuffer;
import me.darki.konas.1b_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8P {
    public Minecraft c;
    public Matrix4f c;
    public Matrix4f 0;
    public ScaledResolution c;
    public Vec3d c = new Matrix4f();

    public boolean c(Vector4f vector4f, int n2, int n3) {
        return 0.0 <= (double)vector4f.x && (double)vector4f.x <= (double)n2 && 0.0 <= (double)vector4f.y && (double)vector4f.y <= (double)n3;
    }

    public Vector4f 0(Vec3d vec3d) {
        Vec3d vec3d2 = this.c.subtract(vec3d);
        Vector4f vector4f = new Vector4f((float)vec3d2.x, (float)vec3d2.y, (float)vec3d2.z, 1.0f);
        this.c(vector4f, this.c);
        this.c(vector4f, this.0);
        if (vector4f.w > 0.0f) {
            vector4f.x *= -100000.0f;
            vector4f.y *= -100000.0f;
        } else {
            float f2 = 1.0f / vector4f.w;
            vector4f.x *= f2;
            vector4f.y *= f2;
        }
        return vector4f;
    }

    public 8P() {
        this.0 = new Matrix4f();
        this.c = new ScaledResolution(this.c);
        this.c = new Vec3d(0.0, 0.0, 0.0);
    }

    public Vec3d 1(Vec3d vec3d) {
        Vector4f vector4f = this.0(vec3d);
        int n2 = this.c.displayWidth;
        int n3 = this.c.displayHeight;
        vector4f.x = (float)n2 / 2.0f + (0.5f * vector4f.x * (float)n2 + 0.5f);
        vector4f.y = (float)n3 / 2.0f - (0.5f * vector4f.y * (float)n3 + 0.5f);
        double d2 = this.c(vector4f, n2, n3) ? 0.0 : -1.0;
        return new Vec3d((double)vector4f.x, (double)vector4f.y, d2);
    }

    public void c(Vector4f vector4f, Matrix4f matrix4f) {
        float f2 = vector4f.x;
        float f3 = vector4f.y;
        float f4 = vector4f.z;
        vector4f.x = f2 * matrix4f.m00 + f3 * matrix4f.m10 + f4 * matrix4f.m20 + matrix4f.m30;
        vector4f.y = f2 * matrix4f.m01 + f3 * matrix4f.m11 + f4 * matrix4f.m21 + matrix4f.m31;
        vector4f.z = f2 * matrix4f.m02 + f3 * matrix4f.m12 + f4 * matrix4f.m22 + matrix4f.m32;
        vector4f.w = f2 * matrix4f.m03 + f3 * matrix4f.m13 + f4 * matrix4f.m23 + matrix4f.m33;
    }

    public void c(Matrix4f matrix4f, int n2) {
        FloatBuffer floatBuffer = GLAllocation.createDirectFloatBuffer((int)16);
        GL11.glGetFloat((int)n2, (FloatBuffer)floatBuffer);
        matrix4f.load(floatBuffer);
    }

    public Vec3d c(Vec3d vec3d) {
        Vector4f vector4f = this.0(vec3d);
        ScaledResolution scaledResolution = new ScaledResolution(this.c);
        int n2 = scaledResolution.getScaledWidth();
        int n3 = scaledResolution.getScaledHeight();
        vector4f.x = (float)n2 / 2.0f + (0.5f * vector4f.x * (float)n2 + 0.5f);
        vector4f.y = (float)n3 / 2.0f - (0.5f * vector4f.y * (float)n3 + 0.5f);
        double d2 = this.c(vector4f, n2, n3) ? 0.0 : -1.0;
        return new Vec3d((double)vector4f.x, (double)vector4f.y, d2);
    }

    @Subscriber
    public void c(1b_0 b_02) {
        if (this.c.getRenderViewEntity() == null) {
            return;
        }
        Vec3d vec3d = ActiveRenderInfo.projectViewFromEntity((Entity)this.c.getRenderViewEntity(), (double)this.c.getRenderPartialTicks());
        Vec3d vec3d2 = ActiveRenderInfo.getCameraPosition();
        this.c(this.c, 2982);
        this.c(this.0, 2983);
        this.c = vec3d.add(vec3d2);
        this.c = new ScaledResolution(this.c);
    }
}

