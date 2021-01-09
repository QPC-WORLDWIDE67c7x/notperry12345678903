/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Locale;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7S;
import me.darki.konas.8h_0;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7T
extends 3E {
    public 8h_0<7S> 1 = new 8h_0("Shader", 7S.c);

    public 7T() {
        super("Shaders", "Enable 1.8 shaders", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(1N n2) {
        block27: {
            block26: {
                StringBuilder stringBuilder;
                ResourceLocation resourceLocation;
                if (!OpenGlHelper.shadersSupported || !(c.getRenderViewEntity() instanceof EntityPlayer)) break block26;
                if (7T.c.entityRenderer.getShaderGroup() != null) {
                    7T.c.entityRenderer.getShaderGroup().deleteShaderGroup();
                }
                EntityRenderer entityRenderer = 7T.c.entityRenderer;
                ResourceLocation resourceLocation2 = resourceLocation;
                ResourceLocation resourceLocation3 = resourceLocation;
                StringBuilder stringBuilder2 = stringBuilder;
                StringBuilder stringBuilder3 = stringBuilder;
                stringBuilder2();
                String string = "shaders/post/";
                StringBuilder stringBuilder4 = stringBuilder3.append(string);
                8h_0<7S> h_02 = this.1;
                Object t = h_02.6();
                7S s = (7S)((Object)t);
                String string2 = s.name();
                Locale locale = Locale.ROOT;
                String string3 = string2.toLowerCase(locale);
                StringBuilder stringBuilder5 = stringBuilder4.append(string3);
                String string4 = ".json";
                StringBuilder stringBuilder6 = stringBuilder5.append(string4);
                String string5 = stringBuilder6.toString();
                resourceLocation2(string5);
                try {
                    entityRenderer.loadShader(resourceLocation3);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                break block27;
            }
            if (7T.c.entityRenderer.getShaderGroup() == null || 7T.c.currentScreen != null) break block27;
            7T.c.entityRenderer.getShaderGroup().deleteShaderGroup();
        }
    }

    @Override
    public void 7() {
        block0: {
            if (7T.c.entityRenderer.getShaderGroup() == null) break block0;
            7T.c.entityRenderer.getShaderGroup().deleteShaderGroup();
        }
    }
}

