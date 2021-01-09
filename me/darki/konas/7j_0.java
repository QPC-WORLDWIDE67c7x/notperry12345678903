/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.HashMap;
import me.darki.konas.0J;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8S;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.7j
 */
public class 7j_0
extends 3E {
    public HashMap<String, ResourceLocation> c = new HashMap();
    public HashMap<String, String> 0 = new HashMap();

    public void 2(String string) {
        DynamicTexture dynamicTexture = 8S.1(string);
        ResourceLocation resourceLocation = Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation(string, dynamicTexture);
        this.c.put(string, resourceLocation);
        Minecraft.getMinecraft().getTextureManager().loadTexture(resourceLocation, (ITextureObject)dynamicTexture);
    }

    @Override
    public void c() {
        if (this.0.isEmpty()) {
            this.0 = 8S.3();
        }
    }

    @Subscriber
    public void c(0J j2) {
        block2: {
            if (((Minecraft)7j_0.c).player == null || ((Minecraft)7j_0.c).world == null) {
                return;
            }
            if (this.0.get(j2.0().toUpperCase()) == null) break block2;
            String string = this.0.get(j2.0().toUpperCase());
            if (this.c.get(string) == null) {
                c.addScheduledTask(() -> this.2(string));
            }
            j2.c(this.c.get(string));
            j2.c();
        }
    }

    public 7j_0() {
        super("Capes", 3D.2, new String[0]);
    }
}

