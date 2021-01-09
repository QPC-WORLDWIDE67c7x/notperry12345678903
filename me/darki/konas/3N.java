/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.Comparator;
import me.darki.konas.0I;
import me.darki.konas.18;
import me.darki.konas.1a_0;
import me.darki.konas.2n_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3J;
import me.darki.konas.3K;
import me.darki.konas.3L;
import me.darki.konas.3M;
import me.darki.konas.89;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;
import me.darki.konas.9d;
import me.darki.konas.9f;
import me.darki.konas.i_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3N
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Overlap", true);
    public static 8h_0<Boolean> 2 = new 8h_0("PotionIcons", false);
    public static 8h_0<Boolean> 3 = new 8h_0("Blur", false);
    public static 8h_0<Boolean> 4 = new 8h_0("BlurEverything", true).c(3::6);
    public 8h_0<Boolean> 5 = new 8e_0("CustomFont", true, new 3J(this));
    public static 8h_0<Boolean> 6 = new 8h_0("Hotbar", true);
    public static 8h_0<Boolean> 7 = new 8h_0("XPBar", true);
    public static 8h_0<3K> 8 = new 8h_0("ArmorMode", 3K.2);
    public static 8h_0<3M> 9 = new 8h_0("NumberMode", 3M.0).c(3N::1);
    public static 8h_0<3L> a = new 8h_0("ColorMode", 3L.0).c(3N::c);
    public static 8h_0<89> b = new 8h_0("Color", new 89(new Color(255, 85, 255, 255).hashCode(), false)).c(3N::0);
    public static 8h_0<Boolean> d = new 8h_0("Health", true);
    public static 8h_0<Boolean> e = new 8h_0("Food", true);
    public static 8h_0<Boolean> f = new 8h_0("Crosshair", true);
    public static 9d c = new 9d(i_0.2, 18.0f);

    @Subscriber
    public void c(RenderGameOverlayEvent.Post post) {
        GuiIngameForge.renderHealth = (Boolean)d.6();
        GuiIngameForge.renderArmor = 8.6() == 3K.2 || 8.6() == 3K.0;
        GuiIngameForge.renderExperiance = (Boolean)7.6();
        GuiIngameForge.renderHotbar = (Boolean)6.6();
        GuiIngameForge.renderFood = (Boolean)e.6();
        GuiIngameForge.renderCrosshairs = (Boolean)f.6();
    }

    public String c(PotionEffect potionEffect) {
        return I18n.format((String)potionEffect.getEffectName(), (Object[])new Object[0]);
    }

    public int 0(ItemStack itemStack) {
        int n2 = itemStack.getMaxDamage();
        int n3 = n2 - itemStack.getItemDamage();
        int n4 = (int)Math.round((double)n3 / ((double)n2 * 0.01));
        boolean bl = 9.6() == 3M.0;
        return bl ? n4 : n3;
    }

    @Subscriber
    public void c(0I i2) {
        block2: {
            block1: {
                if (((Minecraft)3N.c).player == null || ((Minecraft)3N.c).world == null) {
                    return;
                }
                if (i2.c() == null || !((Boolean)3.6()).booleanValue() || i2.c() instanceof GuiChat) break block1;
                if (!(i2.c() instanceof 2n_0) && !((Boolean)4.6()).booleanValue()) break block2;
                ((Minecraft)3N.c).entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
                break block2;
            }
            if (!((Minecraft)3N.c).entityRenderer.isShaderActive()) break block2;
            ((Minecraft)3N.c).entityRenderer.stopUseShader();
        }
    }

    public int c(FontRenderer fontRenderer, PotionEffect potionEffect) {
        return fontRenderer.getStringWidth(this.0(potionEffect));
    }

    public static boolean 0() {
        return a.6() == 3L.c && (8.6() == 3K.2 || 8.6() == 3K.1);
    }

    public int 1(PotionEffect potionEffect) {
        String string;
        switch (string = this.c(potionEffect)) {
            case "Absorption": {
                return new Color(33, 118, 255).hashCode();
            }
            case "Fire Resistance": {
                return new Color(247, 152, 36).hashCode();
            }
            case "Regeneration": {
                return new Color(232, 142, 237).hashCode();
            }
            case "Strength": 
            case "Resistance": {
                return new Color(237, 28, 36).hashCode();
            }
            case "Hunger": {
                return new Color(41, 191, 18).hashCode();
            }
            case "Jump Boost": {
                return new Color(0, 204, 51).hashCode();
            }
            case "Haste": {
                return new Color(255, 207, 0).hashCode();
            }
            case "Speed": {
                return new Color(0, 255, 227).hashCode();
            }
        }
        return Color.WHITE.hashCode();
    }

    public static boolean 1() {
        return 8.6() == 3K.2 || 8.6() == 3K.1;
    }

    public int c(ItemStack itemStack) {
        if (a.6() == 3L.0) {
            return itemStack.getItem().getRGBDurabilityForDisplay(itemStack);
        }
        return ((89)b.6()).c();
    }

    public String 0(PotionEffect potionEffect) {
        return this.c(potionEffect) + " " + Potion.getPotionDurationString((PotionEffect)potionEffect, (float)1.0f);
    }

    public void c(FontRenderer fontRenderer, ScaledResolution scaledResolution) {
        int[] nArray = ((Minecraft)3N.c).ingameGUI.getChatGUI().getChatOpen() ? new int[]{scaledResolution.getScaledHeight() - (((Minecraft)3N.c).player.getActivePotionEffects().size() * fontRenderer.FONT_HEIGHT + 5 + (fontRenderer.FONT_HEIGHT + 5))} : new int[]{scaledResolution.getScaledHeight() - (((Minecraft)3N.c).player.getActivePotionEffects().size() * fontRenderer.FONT_HEIGHT + 5)};
        ((Minecraft)3N.c).player.getActivePotionEffects().stream().sorted(Comparator.comparingInt(arg_0 -> this.c(fontRenderer, arg_0))).forEach(arg_0 -> this.c(fontRenderer, scaledResolution, nArray, arg_0));
    }

    public 3N() {
        super("HUD", "Displays information on the ingame screen", 3D.5, new String[0]);
    }

    public static boolean c() {
        return 8.6() == 3K.2 || 8.6() == 3K.1;
    }

    @Subscriber
    public void c(18 var1_1) {
        block0: {
            if (!((Boolean)2.6()).booleanValue()) break block0;
            var1_1.c();
        }
    }

    @Subscriber
    public void c(1a_0 a_02) {
        if (((Minecraft)3N.c).world == null || ((Minecraft)3N.c).player == null) {
            return;
        }
        if (8.6() == 3K.1 || 8.6() == 3K.2) {
            ScaledResolution scaledResolution = new ScaledResolution((Minecraft)c);
            int n2 = 3;
            for (int i2 = 3; i2 >= 0; --i2) {
                ItemStack itemStack = 3N.c.player.inventory.armorItemInSlot(i2);
                if (itemStack == null || !(itemStack.getItem() instanceof ItemArmor) && !(itemStack.getItem() instanceof ItemElytra)) continue;
                GlStateManager.enableDepth();
                3N.c.getRenderItem().zLevel = 200.0f;
                String string = "" + this.0(itemStack);
                int n3 = (int)(scaledResolution.getScaledWidth_double() * (double)0.5085f);
                int n4 = scaledResolution.getScaledHeight() - 68;
                9f.0(string, n3 + n2 + 8 - (int)(9f.0(string) / 2.0f), n4, this.c(itemStack));
                c.getRenderItem().renderItemAndEffectIntoGUI(itemStack, n3 + n2, n4 + 8);
                c.getRenderItem().renderItemOverlayIntoGUI(((Minecraft)3N.c).standardGalacticFontRenderer, itemStack, n3 + n2, n4 + 12, "");
                3N.c.getRenderItem().zLevel = 0.0f;
                GlStateManager.enableTexture2D();
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                n2 += 20;
            }
        }
    }

    public void c(FontRenderer fontRenderer, ScaledResolution scaledResolution, int[] nArray, PotionEffect potionEffect) {
        fontRenderer.drawStringWithShadow(this.0(potionEffect), (float)(scaledResolution.getScaledWidth() - 2 - fontRenderer.getStringWidth(this.0(potionEffect))), (float)nArray[0], this.1(potionEffect));
        nArray[0] = nArray[0] + fontRenderer.FONT_HEIGHT;
    }
}

