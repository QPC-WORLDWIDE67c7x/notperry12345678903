/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import me.darki.konas.7q_0;
import me.darki.konas.89;
import me.darki.konas.9k;
import me.darki.konas.mixin.mixins.IEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 9i
extends 9k {
    public int c = this.c("DiffuseSamper");
    public int 0 = this.c("TexelSize");
    public int 1 = this.c("Color");
    public int 2 = this.c("Fill");
    public int 3 = this.c("SampleRadius");
    public int 4 = this.c("RenderOutline");
    public int 5 = this.c("OutlineFade");

    @Override
    public 9k c() {
        if (this.d == -1 || this.e == -1 || this.h == -1) {
            throw new RuntimeException("Invalid IDs!");
        }
        EXTFramebufferObject.glBindFramebufferEXT((int)36160, (int)this.d);
        int n2 = Math.max(Minecraft.getDebugFPS(), 30);
        GL11.glClear((int)16640);
        ((IEntityRenderer)9i.c.entityRenderer).iUpdateFogColor(((IEntityRenderer)9i.c.entityRenderer).getRenderEndNanoTime() + (long)(1000000000 / n2));
        ARBShaderObjects.glUseProgramObjectARB((int)this.h);
        ARBShaderObjects.glUniform1iARB((int)this.c, (int)0);
        GL13.glActiveTexture((int)33984);
        GL11.glEnable((int)3553);
        GL11.glBindTexture((int)3553, (int)this.6);
        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer((int)2);
        floatBuffer.position(0);
        floatBuffer.put(1.0f / (float)this.7 * (((Float)7q_0.5.6()).floatValue() / 5.0f));
        floatBuffer.put(1.0f / (float)this.8 * (((Float)7q_0.5.6()).floatValue() / 5.0f));
        floatBuffer.flip();
        ARBShaderObjects.glUniform2ARB((int)this.0, (FloatBuffer)floatBuffer);
        FloatBuffer floatBuffer2 = BufferUtils.createFloatBuffer((int)4);
        floatBuffer2.position(0);
        floatBuffer2.put((float)((89)7q_0.9.6()).6() / 255.0f);
        floatBuffer2.put((float)((89)7q_0.9.6()).5() / 255.0f);
        floatBuffer2.put((float)((89)7q_0.9.6()).2() / 255.0f);
        floatBuffer2.put((float)((89)7q_0.9.6()).1() / 255.0f);
        floatBuffer2.flip();
        ARBShaderObjects.glUniform4ARB((int)this.1, (FloatBuffer)floatBuffer2);
        FloatBuffer floatBuffer3 = BufferUtils.createFloatBuffer((int)4);
        floatBuffer3.position(0);
        if (((Boolean)7q_0.a.6()).booleanValue()) {
            floatBuffer3.put((float)((89)7q_0.b.6()).6() / 255.0f);
            floatBuffer3.put((float)((89)7q_0.b.6()).5() / 255.0f);
            floatBuffer3.put((float)((89)7q_0.b.6()).2() / 255.0f);
            floatBuffer3.put((float)((89)7q_0.b.6()).1() / 255.0f);
        } else {
            floatBuffer3.put(0.0f);
            floatBuffer3.put(0.0f);
            floatBuffer3.put(0.0f);
            floatBuffer3.put(0.0f);
        }
        floatBuffer3.flip();
        ARBShaderObjects.glUniform4ARB((int)this.2, (FloatBuffer)floatBuffer3);
        IntBuffer intBuffer = BufferUtils.createIntBuffer((int)1);
        intBuffer.position(0);
        intBuffer.put(4);
        intBuffer.flip();
        ARBShaderObjects.glUniform1ARB((int)this.3, (IntBuffer)intBuffer);
        IntBuffer intBuffer2 = BufferUtils.createIntBuffer((int)1);
        intBuffer2.position(0);
        intBuffer2.put(((Boolean)7q_0.7.6()).booleanValue() ? 1 : 0);
        intBuffer2.flip();
        ARBShaderObjects.glUniform1ARB((int)this.4, (IntBuffer)intBuffer2);
        IntBuffer intBuffer3 = BufferUtils.createIntBuffer((int)1);
        intBuffer3.position(0);
        intBuffer3.put((Boolean)7q_0.8.6() != false ? 1 : 0);
        intBuffer3.flip();
        ARBShaderObjects.glUniform1ARB((int)this.5, (IntBuffer)intBuffer3);
        this.5();
        ARBShaderObjects.glUseProgramObjectARB((int)0);
        return this;
    }

    public 9i(Framebuffer framebuffer) {
        super(framebuffer);
    }
}

