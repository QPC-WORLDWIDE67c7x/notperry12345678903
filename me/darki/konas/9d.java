/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.darki.konas.3p_0;
import me.darki.konas.9a;
import me.darki.konas.9g;
import me.darki.konas.T;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 9d
implements 9g {
    public int c;
    public Map<String, Float> c;
    public float c;
    public UnicodeFont c;
    public int 0;
    public String c = (int)new HashMap();
    public float 0 = new ScaledResolution(Minecraft.getMinecraft()).getScaleFactor();
    public static File c = new File(T.c, "fonts");
    public static Font c = null;

    public void 1() throws IOException, FontFormatException, SlickException {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        this.0 = scaledResolution.getScaleFactor();
        this.c = new UnicodeFont(9d.0("default").deriveFont(this.0 * (float)this.0 / 2.0f));
        this.c.addAsciiGlyphs();
        this.c.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
        this.c.loadGlyphs();
    }

    public UnicodeFont c() {
        return this.c;
    }

    public String c(String string, int n2, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = 0;
        int n4 = bl ? string.length() - 1 : 0;
        int n5 = bl ? -1 : 1;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i2 = n4; i2 >= 0 && i2 < string.length(); i2 += n5) {
            if (n3 >= n2) break;
            char c2 = string.charAt(i2);
            float f2 = this.2(string);
            if (bl2) {
                bl2 = false;
                if (c2 != 'l' && c2 != 'L') {
                    if (c2 == 'r' || c2 == 'R') {
                        bl3 = false;
                    }
                } else {
                    bl3 = true;
                }
            } else if (f2 < 0.0f) {
                bl2 = true;
            } else {
                n3 = (int)((float)n3 + f2);
                if (bl3) {
                    ++n3;
                }
            }
            if (n3 > n2) break;
            if (bl) {
                stringBuilder.insert(0, c2);
                continue;
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public void c(ArrayList<String> arrayList, int n2, int n3, int n4) {
        this.1(String.join((CharSequence)"\n\r", arrayList), n2, n3, n4);
    }

    public void c(String string, float f2, float f3, int n2) {
        this.c(StringUtils.stripControlCodes((String)string), f2 + 0.5f, f3 + 0.5f, n2);
        this.c(string, f2, f3, n2);
    }

    public void 0() throws IOException, FontFormatException, SlickException {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        this.0 = scaledResolution.getScaleFactor();
        this.c = new UnicodeFont(9d.0(this.c).deriveFont(this.0 * (float)this.0 / 2.0f));
        this.c.addAsciiGlyphs();
        this.c.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
        this.c.loadGlyphs();
    }

    @Override
    public float 0(String string) {
        return (float)this.c.getWidth(9a.c(string)) / 2.0f / ((float)new ScaledResolution(Minecraft.getMinecraft()).getScaleFactor() / 2.0f);
    }

    @Override
    public int 0(String string, float f2, float f3, int n2) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        this.1(StringUtils.stripControlCodes((String)string), f2 + 0.5f, f3 + 0.5f, 0);
        return this.1(string, f2, f3, n2);
    }

    @Override
    public int c() {
        return 9;
    }

    public List<String> 0(String string, int n2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : stringArray) {
            String string3 = stringBuilder + " " + string2;
            if (this.2(string3) >= (float)n2) {
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(string2).append(" ");
        }
        arrayList.add(stringBuilder.toString());
        return arrayList;
    }

    @Override
    public int 1(String string, float f2, float f3, int n2) {
        return this.c(string, f2, f3, n2, null);
    }

    public void 0(String string, int n2, int n3, int n4, double d2) {
        GL11.glPushMatrix();
        GL11.glTranslated((double)n2, (double)n3, (double)0.0);
        GL11.glScaled((double)d2, (double)d2, (double)d2);
        this.c(string, 0.0f, 0.0f, n4);
        GL11.glPopMatrix();
    }

    public static Font 0(String string) throws IOException, FontFormatException {
        if (string.equalsIgnoreCase("geometric")) {
            return 9d.c("/assets/konas/fonts/geometric.ttf");
        }
        if (string.equalsIgnoreCase("verdana") || string.equalsIgnoreCase("default")) {
            return 9d.c("/assets/konas/fonts/verdana.ttf");
        }
        File file = new File(c, string + ".ttf");
        if (file.exists()) {
            c = Font.createFont(0, file);
            return c;
        }
        return 9d.c("/assets/konas/fonts/verdana.ttf");
    }

    public void c(String string, int n2, int n3, int n4, double d2) {
        GL11.glPushMatrix();
        GL11.glTranslated((double)n2, (double)n3, (double)0.0);
        GL11.glScaled((double)d2, (double)d2, (double)d2);
        this.1(string, 0.0f, 0.0f, n4);
        GL11.glPopMatrix();
    }

    public float 2(String string) {
        block0: {
            if (this.c.size() <= 1000) break block0;
            this.c.clear();
        }
        return this.c.computeIfAbsent(string, arg_0 -> this.c(string, arg_0)).floatValue();
    }

    public int c(String string, float f2, float f3, 3p_0 p_02) {
        return this.c(string, f2, f3, -1, p_02);
    }

    public String c(String string, int n2) {
        return this.c(string, n2, false);
    }

    @Override
    public float c(String string) {
        return this.1(string) / ((float)new ScaledResolution(Minecraft.getMinecraft()).getScaleFactor() / 2.0f);
    }

    public Float c(String string, String string2) {
        return Float.valueOf((float)this.c.getWidth(9a.c(string)) / this.c);
    }

    public 9d(Font font) {
        this(font.getFontName(), font.getSize());
    }

    public 9d(String string, float f2) {
        this.c = string;
        this.0 = f2;
        try {
            this.0();
        }
        catch (FontFormatException | IOException | SlickException exception) {
            try {
                this.1();
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        this.c = scaledResolution.getScaleFactor();
    }

    public float 1(String string) {
        return (float)this.c.getHeight(string) / 2.0f;
    }

    @Override
    public int c(String string, float f2, float f3, int n2) {
        return this.1(string, f2 - (float)((int)this.2(string) >> 1), f3, n2);
    }

    public int c(String string, float f2, float f3, int n2, 3p_0 p_02) {
        ScaledResolution scaledResolution;
        block31: {
            ColorEffect colorEffect;
            UnicodeFont unicodeFont;
            if (string == null) {
                return 0;
            }
            string = string.replaceAll("\u00c2\u00a7", String.valueOf('\u00a7'));
            scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
            ScaledResolution scaledResolution2 = scaledResolution;
            int n3 = scaledResolution2.getScaleFactor();
            if (n3 == this.0) break block31;
            9d d2 = this;
            ScaledResolution scaledResolution3 = scaledResolution;
            int n4 = scaledResolution3.getScaleFactor();
            d2.0 = n4;
            9d d3 = this;
            UnicodeFont unicodeFont2 = unicodeFont;
            UnicodeFont unicodeFont3 = unicodeFont;
            String string2 = this.c;
            Font font = 9d.0(string2);
            float f4 = this.0 * (float)this.0 / 2.0f;
            Font font2 = font.deriveFont(f4);
            unicodeFont2(font2);
            d3.c = unicodeFont3;
            UnicodeFont unicodeFont4 = this.c;
            unicodeFont4.addAsciiGlyphs();
            UnicodeFont unicodeFont5 = this.c;
            List list = unicodeFont5.getEffects();
            ColorEffect colorEffect2 = colorEffect;
            ColorEffect colorEffect3 = colorEffect;
            java.awt.Color color = java.awt.Color.WHITE;
            colorEffect2(color);
            list.add(colorEffect3);
            UnicodeFont unicodeFont6 = this.c;
            unicodeFont6.loadGlyphs();
            try {
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this.c = scaledResolution.getScaleFactor();
        GL11.glPushMatrix();
        GlStateManager.scale((float)(1.0f / this.c), (float)(1.0f / this.c), (float)(1.0f / this.c));
        f3 *= this.c;
        float f5 = f2 *= this.c;
        float f6 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n2 & 0xFF) / 255.0f;
        float f9 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        GlStateManager.color((float)f6, (float)f7, (float)f8, (float)f9);
        int n5 = n2;
        char[] cArray = string.toCharArray();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.blendFunc((int)770, (int)771);
        String[] stringArray = 9a.c.split(string);
        int n6 = 0;
        for (String string3 : stringArray) {
            char c2;
            for (String string4 : string3.split("\n")) {
                for (String string5 : string4.split("\r")) {
                    if (p_02 == null) {
                        this.c.drawString(f2, f3, string5, new Color(n5));
                    } else {
                        this.c.drawFillDisplayList(f2, f3, string5, p_02, 0, string.length());
                    }
                    f2 += (float)this.c.getWidth(string5);
                    if ((n6 += string5.length()) >= cArray.length || cArray[n6] != '\r') continue;
                    f2 = f5;
                    ++n6;
                }
                if (n6 >= cArray.length || cArray[n6] != '\n') continue;
                f2 = f5;
                f3 += this.1(string4) * 2.0f;
                ++n6;
            }
            if (n6 >= cArray.length || (c2 = cArray[n6]) != '\u00a7') continue;
            int n7 = cArray[n6 + 1];
            int n8 = "0123456789abcdef".indexOf(n7);
            if (n8 < 0) {
                if (n7 == 114) {
                    n5 = n2;
                }
            } else {
                n5 = 9a.c[n8];
            }
            n6 += 2;
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.bindTexture((int)0);
        GlStateManager.popMatrix();
        return (int)this.2(string);
    }

    public static Font c(String string) throws IOException, FontFormatException {
        c = Font.createFont(0, 9d.class.getResourceAsStream(string));
        return c;
    }

    public float c(char c2) {
        return this.c.getWidth(String.valueOf(c2));
    }
}

