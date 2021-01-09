/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.9g;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 9e
implements 9g {
    public static 9e c = new 9e();

    @Override
    public int 0(String string, float f2, float f3, int n2) {
        string = string.replaceAll("\u00c2\u00a7", String.valueOf('\u00a7'));
        return Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(string, f2, f3, n2);
    }

    @Override
    public int c(String string, float f2, float f3, int n2) {
        string = string.replaceAll("\u00c2\u00a7", String.valueOf('\u00a7'));
        return Minecraft.getMinecraft().fontRenderer.drawString(string, f2 - (float)Minecraft.getMinecraft().fontRenderer.getStringWidth(string) / 2.0f, f3, n2, false);
    }

    @Override
    public int 1(String string, float f2, float f3, int n2) {
        string = string.replaceAll("\u00c2\u00a7", String.valueOf('\u00a7'));
        return Minecraft.getMinecraft().fontRenderer.drawString(string, f2, f3, n2, false);
    }

    @Override
    public int c() {
        return Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT;
    }

    @Override
    public float 0(String string) {
        return Minecraft.getMinecraft().fontRenderer.getStringWidth(string);
    }

    @Override
    public float c(String string) {
        return Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT;
    }
}

