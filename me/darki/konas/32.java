/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.primitives.Ints;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import me.darki.konas.2;
import me.darki.konas.26;
import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8x_0;
import me.darki.konas.9f;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 32
extends 2E {
    public float 3 = 9f.c() + 2;
    public 8h_0<Boolean> 1 = new 8h_0("Yaw", true);
    public 8h_0<Boolean> 2 = new 8h_0("Pitch", true);
    public static boolean 1 = false;

    public int 0(float f2) {
        if (f2 > 20.0f) {
            return 0xFFAA00;
        }
        int n2 = Ints.constrainToRange((int)((int)((double)((int)f2) * 12.75)), (int)0, (int)255);
        return new Color(Ints.constrainToRange((int)(255 - n2), (int)0, (int)255), Ints.constrainToRange((int)n2, (int)0, (int)255), 0).hashCode();
    }

    @Override
    public void 8() {
        super.8();
        1 = false;
    }

    public String 0(EntityPlayer entityPlayer) {
        String string = "";
        PotionEffect potionEffect = entityPlayer.getActivePotionEffect(MobEffects.STRENGTH);
        if (potionEffect != null && entityPlayer.isPotionActive(MobEffects.STRENGTH)) {
            string = me.darki.konas.2.c + "c S";
        }
        return string;
    }

    public void c(int n2, int n3, ItemStack itemStack) {
        GL11.glPushMatrix();
        GL11.glDepthMask((boolean)true);
        GlStateManager.clear((int)256);
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
        32.c.getRenderItem().zLevel = -100.0f;
        GlStateManager.scale((float)1.0f, (float)1.0f, (float)0.01f);
        c.getRenderItem().renderItemAndEffectIntoGUI(itemStack, n2, n3);
        32.c.getRenderItem().zLevel = 0.0f;
        GlStateManager.scale((float)1.0f, (float)1.0f, (float)1.0f);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GL11.glPopMatrix();
    }

    public String 1(EntityPlayer entityPlayer) {
        String string = "";
        PotionEffect potionEffect = entityPlayer.getActivePotionEffect(MobEffects.WEAKNESS);
        if (potionEffect != null && entityPlayer.isPotionActive(MobEffects.WEAKNESS)) {
            string = me.darki.konas.2.c + "0 W";
        }
        return string;
    }

    public static Float c(Entity entity) {
        return Float.valueOf(32.c.player.getDistance(entity));
    }

    public static boolean 0(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    @Override
    public void 5() {
        super.5();
        if (32.c.player == null || 32.c.world == null) {
            return;
        }
        EntityPlayer entityPlayer = 8k_0.c.c.0().stream().filter(32::0).min(Comparator.comparing(32::c)).orElse(null);
        if (entityPlayer == null) {
            return;
        }
        EntityPlayer entityPlayer2 = null;
        if (32.c.world.getPlayerEntityByName(entityPlayer.getName()) != null) {
            entityPlayer2 = 32.c.world.getPlayerEntityByName(entityPlayer.getName());
        }
        if (entityPlayer2 == null || entityPlayer2.isDead || entityPlayer2.getHealth() <= 0.0f) {
            return;
        }
        32.c(this.9(), this.3(), this.9() + this.c(), this.3() + this.7(), ((89)this.c.6()).c(), false);
        32.c(this.9(), this.3(), this.9() + this.c(), this.3() + this.7(), ((89)this.0.6()).c(), true);
        1 = true;
        8x_0.c((int)this.9() + 50, (int)this.3() + 100, 50, -30.0f, 0.0f, entityPlayer2, (Boolean)this.1.6(), (Boolean)this.2.6());
        1 = false;
        9f.0(entityPlayer2.getDisplayNameString() + this.0(entityPlayer2) + this.1(entityPlayer2), (int)this.9() + 100, (int)this.3() + (int)this.3, Color.WHITE.hashCode());
        DecimalFormat decimalFormat = new DecimalFormat("##");
        9f.0(decimalFormat.format(entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount()) + "hp", (int)(this.9() + 100.0f), (int)((float)((int)this.3()) + this.3 * 2.0f), this.0(entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount()));
        boolean bl = 32.c.player.connection.getPlayerInfo(entityPlayer2.getName()) == null;
        9f.0(bl ? "0" : 32.c.player.connection.getPlayerInfo(entityPlayer2.getName()).getResponseTime() + "ms", (int)(this.9() + 100.0f), (int)((float)((int)this.3()) + this.3 * 3.0f), Color.WHITE.hashCode());
        int n2 = ((HashMap)26.c).getOrDefault(entityPlayer2.getName(), (Long)0);
        9f.0(n2 + " pops", (int)(this.9() + 100.0f), (int)((float)((int)this.3()) + this.3 * 4.0f), Color.WHITE.hashCode());
        if (this.c(entityPlayer2) != 0.0f) {
            9f.0(this.c(entityPlayer2) == 0.0f ? "No Armor" : decimalFormat.format(this.2(entityPlayer2) / this.c(entityPlayer2) * 100.0f) + "%", (int)this.9() + 100, (int)((float)((int)this.3()) + this.3 * 5.0f), this.c(this.2(entityPlayer2) / this.c(entityPlayer2)));
        }
        this.c((int)this.9() + 100, (int)this.3() + (int)(this.3 * 6.0f), entityPlayer2.getHeldItemMainhand());
        this.c((int)this.9() + 116, (int)this.3() + (int)(this.3 * 6.0f), entityPlayer2.getHeldItemOffhand());
        int n3 = 100;
        for (int i2 = 3; i2 >= 0; --i2) {
            ItemStack itemStack = (ItemStack)entityPlayer2.inventory.armorInventory.get(i2);
            this.c((int)(this.9() + (float)n3), (int)this.3() + (int)(this.3 * 7.0f + 6.0f), itemStack);
            n3 += 16;
        }
    }

    public float 2(EntityPlayer entityPlayer) {
        int n2 = 0;
        for (ItemStack itemStack : entityPlayer.getArmorInventoryList()) {
            n2 += itemStack.getMaxDamage() - itemStack.getItemDamage();
        }
        return n2;
    }

    public int c(float f2) {
        return MathHelper.hsvToRGB((float)(Math.max(0.0f, f2) / 3.0f), (float)1.0f, (float)1.0f);
    }

    public float c(EntityPlayer entityPlayer) {
        int n2 = 0;
        for (ItemStack itemStack : entityPlayer.getArmorInventoryList()) {
            n2 += itemStack.getMaxDamage();
        }
        return n2;
    }

    public static void c(float f2, float f3, float f4, float f5, int n2, boolean bl) {
        float f6 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        bufferBuilder.begin(bl ? 2 : 7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f2, (double)f5, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f4, (double)f5, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f4, (double)f3, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f2, (double)f3, 0.0).color(f7, f8, f9, f6).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public 32() {
        super("Target", 200.0f, 600.0f, 200.0f, 105.0f);
        ((89)this.c.6()).0(Integer.MIN_VALUE);
        ((89)this.0.6()).0(-805306368);
    }
}

