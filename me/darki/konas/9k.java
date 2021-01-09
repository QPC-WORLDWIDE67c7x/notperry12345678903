/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.nio.ByteBuffer;
import me.darki.konas.9j;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class 9k {
    public static Minecraft c = Minecraft.getMinecraft();
    public static double c = 2.0;
    public int 6;
    public int 7;
    public int 8;
    public int 9;
    public int a;
    public int b = -1;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;

    public int 3() {
        return this.b;
    }

    public 9k(Framebuffer framebuffer) {
        this(framebuffer.framebufferTexture, 9k.c.displayWidth, 9k.c.displayHeight, new ScaledResolution(c).getScaledWidth(), new ScaledResolution(c).getScaledHeight());
    }

    public void 2() {
        block2: {
            if (this.e > -1) {
                EXTFramebufferObject.glDeleteRenderbuffersEXT((int)this.e);
            }
            if (this.d > -1) {
                EXTFramebufferObject.glDeleteFramebuffersEXT((int)this.d);
            }
            if (this.b <= -1) break block2;
            GL11.glDeleteTextures((int)this.b);
        }
    }

    public 9k(int n2, int n3, int n4, int n5, int n6) {
        this.6 = n2;
        this.7 = n3;
        this.8 = n4;
        this.9 = (int)((double)n5 * c);
        this.a = (int)((double)n6 * c);
        this.4();
        this.1();
    }

    public void 5() {
        GL11.glScaled((double)(1.0 / c), (double)(1.0 / c), (double)(1.0 / c));
        GL11.glDisable((int)3553);
        GL11.glBegin((int)4);
        GL11.glTexCoord2d((double)0.0, (double)1.0);
        GL11.glVertex2d((double)0.0, (double)0.0);
        GL11.glTexCoord2d((double)0.0, (double)0.0);
        GL11.glVertex2d((double)0.0, (double)this.a);
        GL11.glTexCoord2d((double)1.0, (double)0.0);
        GL11.glVertex2d((double)this.9, (double)this.a);
        GL11.glTexCoord2d((double)1.0, (double)0.0);
        GL11.glVertex2d((double)this.9, (double)this.a);
        GL11.glTexCoord2d((double)1.0, (double)1.0);
        GL11.glVertex2d((double)this.9, (double)0.0);
        GL11.glTexCoord2d((double)0.0, (double)1.0);
        GL11.glVertex2d((double)0.0, (double)0.0);
        GL11.glEnd();
        GL11.glScaled((double)c, (double)c, (double)c);
    }

    public void 0() {
        int n2 = EXTFramebufferObject.glCheckFramebufferStatusEXT((int)36160);
        switch (n2) {
            case 36053: {
                return;
            }
            case 36054: {
                throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT");
            }
            case 36055: {
                throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT");
            }
            default: {
                throw new RuntimeException("glCheckFramebufferStatusEXT returned unknown status:" + n2);
            }
            case 36057: {
                throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT");
            }
            case 36058: {
                throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT");
            }
            case 36059: 
        }
        throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT");
    }

    public abstract 9k c();

    public void 4() {
        this.d = EXTFramebufferObject.glGenFramebuffersEXT();
        this.b = GL11.glGenTextures();
        this.e = EXTFramebufferObject.glGenRenderbuffersEXT();
        GL11.glBindTexture((int)3553, (int)this.b);
        GL11.glTexParameterf((int)3553, (int)10241, (float)9729.0f);
        GL11.glTexParameterf((int)3553, (int)10240, (float)9729.0f);
        GL11.glTexParameterf((int)3553, (int)10242, (float)10496.0f);
        GL11.glTexParameterf((int)3553, (int)10243, (float)10496.0f);
        GL11.glBindTexture((int)3553, (int)0);
        GL11.glBindTexture((int)3553, (int)this.b);
        GL11.glTexImage2D((int)3553, (int)0, (int)32856, (int)this.7, (int)this.8, (int)0, (int)6408, (int)5121, (ByteBuffer)null);
        EXTFramebufferObject.glBindFramebufferEXT((int)36160, (int)this.d);
        EXTFramebufferObject.glFramebufferTexture2DEXT((int)36160, (int)36064, (int)3553, (int)this.b, (int)0);
        EXTFramebufferObject.glBindRenderbufferEXT((int)36161, (int)this.e);
        EXTFramebufferObject.glRenderbufferStorageEXT((int)36161, (int)34041, (int)this.7, (int)this.8);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int)36160, (int)36128, (int)36161, (int)this.e);
        this.0();
    }

    /*
     * Unable to fully structure code
     */
    public void 1() {
        block13: {
            block12: {
                if (this.h != -1) break block13;
                this.h = ARBShaderObjects.glCreateProgramObjectARB();
                if (this.f != -1) ** GOTO lbl17
                v0 = "#version 120\n\nvoid main()\n{\n    gl_TexCoord[0] = gl_MultiTexCoord0;\n    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n}\n";
                var1_1 = v0;
                v1 = this;
                v2 = var1_1;
                v3 = 35633;
                v4 = 9j.c(v2, v3);
                v1.f = v4;
lbl17:
                // 2 sources

                if (this.g != -1) break block12;
                v5 = "#version 120\n\nuniform sampler2D DiffuseSamper;\nuniform vec2 TexelSize;\nuniform vec4 Color;\nuniform vec4 Fill;\nuniform int SampleRadius;\nuniform bool RenderOutline;\nuniform bool OutlineFade;\n\nvoid main()\n{\n    vec4 centerCol = texture2D(DiffuseSamper, gl_TexCoord[0].st);\n\n    if(centerCol.a != 0.0F)\n    {\n        gl_FragColor = vec4(Fill.r, Fill.g, Fill.b, Fill.a);\n        return;\n    }\n    float closest = SampleRadius * 1.0F;\n    for(int xo = -SampleRadius; xo <= SampleRadius; xo++)\n    {\n        for(int yo = -SampleRadius; yo <= SampleRadius; yo++)\n        {\n            vec4 currCol = texture2D(DiffuseSamper, gl_TexCoord[0].st + vec2(xo * TexelSize.x, yo * TexelSize.y));\n            if(currCol.r != 0.0F || currCol.g != 0.0F || currCol.b != 0.0F || currCol.a != 0.0F)\n            {\n                float currentDist = sqrt(xo * xo + yo * yo);\n                if(currentDist < closest)\n                {\n                    closest = currentDist;\n                }\n            }\n        }\n    }\n    if (RenderOutline) {\n        float fade = max(0, ((SampleRadius * 1.0F) - (closest - 1)) / (SampleRadius * 1.0F));\n        if (OutlineFade) {\n            float colorFade = max(0, fade - 1F);\n            gl_FragColor = vec4(Color.r - colorFade, Color.g - colorFade, Color.b - colorFade, fade);\n        } else {\n            if (fade > 0.5F) {\n                gl_FragColor = vec4(Color.r, Color.g, Color.b, Color.a);\n            } else {\n                gl_FragColor = vec4(0F, 0F, 0F, 0F);\n            }\n        }\n    } else {\n        gl_FragColor = vec4(0F, 0F, 0F, 0F);\n    }\n}\n";
                var1_1 = v5;
                v6 = this;
                v7 = var1_1;
                v8 = 35632;
                v9 = 9j.c(v7, v8);
                try {
                    v6.g = v9;
                }
                catch (Exception var1_2) {
                    this.h = -1;
                    this.f = -1;
                    this.g = -1;
                    var1_2.printStackTrace();
                }
            }
            if (this.h == -1) break block13;
            ARBShaderObjects.glAttachObjectARB((int)this.h, (int)this.f);
            ARBShaderObjects.glAttachObjectARB((int)this.h, (int)this.g);
            ARBShaderObjects.glLinkProgramARB((int)this.h);
            if (ARBShaderObjects.glGetObjectParameteriARB((int)this.h, (int)35714) == 0) {
                System.err.println(9j.c(this.h));
                return;
            }
            ARBShaderObjects.glValidateProgramARB((int)this.h);
            if (ARBShaderObjects.glGetObjectParameteriARB((int)this.h, (int)35715) == 0) {
                System.err.println(9j.c(this.h));
                return;
            }
            ARBShaderObjects.glUseProgramObjectARB((int)0);
        }
    }

    public int c(String string) {
        return ARBShaderObjects.glGetUniformLocationARB((int)this.h, (CharSequence)string);
    }
}

