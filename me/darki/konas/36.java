/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.2E;
import me.darki.konas.34;
import me.darki.konas.35;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.9f;
import me.darki.konas.KonasMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 36
extends 2E {
    public static 8h_0<35> 1 = new 8h_0("Mode", 35.0);
    public 8h_0<89> 2 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false)).c(36::c);

    public 36() {
        super("Watermark", 5.0f, 5.0f, 100.0f, 60.0f);
    }

    @Override
    public void 5() {
        super.5();
        switch (34.c[((35)((Object)1.6())).ordinal()]) {
            case 1: {
                String string = KonasMod.WATERMARK + " " + "0.10.2";
                this.0(9f.c(string) + 1.0f);
                this.c(9f.0(string) + 1.0f);
                9f.0(string, (int)this.9(), (int)this.3(), ((89)this.2.6()).c());
                break;
            }
            case 2: {
                this.0(60.0f);
                this.c(60.0f);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("konas/textures/konas.png"));
                GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GlStateManager.enableAlpha();
                Gui.drawModalRectWithCustomSizedTexture((int)((int)this.9()), (int)((int)this.3()), (float)0.0f, (float)0.0f, (int)60, (int)60, (float)60.0f, (float)60.0f);
                GlStateManager.disableAlpha();
                break;
            }
        }
    }

    public static boolean c() {
        return 1.6() == 35.c;
    }
}

