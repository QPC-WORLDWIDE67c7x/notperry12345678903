/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.mojang.authlib.GameProfile;
import me.darki.konas.3a_0;
import me.darki.konas.7l_0;
import me.darki.konas.7q_0;
import me.darki.konas.8g_0;
import me.darki.konas.8h_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3n
 */
public class 3n_0
extends 3a_0 {
    public 8h_0<8g_0> c;

    @Override
    public void 0(int n2, int n3, float f2) {
        super.0(n2, n3, f2);
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP((World)Minecraft.getMinecraft().world, new GameProfile(Minecraft.getMinecraft().player.getUniqueID(), Minecraft.getMinecraft().player.getName()));
        entityOtherPlayerMP.copyLocationAndAnglesFrom((Entity)Minecraft.getMinecraft().player);
        entityOtherPlayerMP.posX = -20000.0;
        entityOtherPlayerMP.posZ = -20000.0;
        entityOtherPlayerMP.rotationPitch = -15.0f;
        entityOtherPlayerMP.prevRotationPitch = -15.0f;
        entityOtherPlayerMP.rotationYaw = 20.0f;
        entityOtherPlayerMP.prevRotationYaw = 20.0f;
        entityOtherPlayerMP.rotationYawHead = 20.0f;
        entityOtherPlayerMP.prevRotationYawHead = 20.0f;
        entityOtherPlayerMP.ticksExisted = Minecraft.getMinecraft().player.ticksExisted;
        this.c((int)(this.2() + this.5() / 2.0f), (int)(this.4() + this.8() - 10.0f), 100, n2, n3, (EntityPlayer)entityOtherPlayerMP, true, true);
    }

    public 3n_0(8h_0<8g_0> h_02, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(h_02.c(), f2, f3, f4, f5, f6, f7);
        this.c = h_02;
    }

    public void c(int n2, int n3, int n4, float f2, float f3, EntityPlayer entityPlayer, boolean bl, boolean bl2) {
        7l_0.1 = true;
        7q_0.1 = true;
        GlStateManager.pushMatrix();
        GlStateManager.enableDepth();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)n2, (float)n3, (float)50.0f);
        GlStateManager.scale((float)(-n4), (float)n4, (float)n4);
        GlStateManager.rotate((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float f4 = entityPlayer.renderYawOffset;
        float f5 = entityPlayer.rotationYaw;
        float f6 = entityPlayer.rotationPitch;
        float f7 = entityPlayer.prevRotationYawHead;
        float f8 = entityPlayer.rotationYawHead;
        GlStateManager.rotate((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        f2 = bl ? entityPlayer.rotationYaw * -1.0f : f2;
        f3 = bl2 ? entityPlayer.rotationPitch * -1.0f : f3;
        GlStateManager.rotate((float)(-((float)Math.atan(f3 / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        if (!bl) {
            entityPlayer.renderYawOffset = (float)Math.atan(f2 / 40.0f) * 20.0f;
            entityPlayer.rotationYawHead = entityPlayer.rotationYaw = (float)Math.atan(f2 / 40.0f) * 40.0f;
            entityPlayer.prevRotationYawHead = entityPlayer.rotationYaw;
        }
        if (!bl2) {
            entityPlayer.rotationPitch = -((float)Math.atan(f3 / 40.0f)) * 20.0f;
        }
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.0f);
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        renderManager.setPlayerViewY(180.0f);
        renderManager.setRenderShadow(false);
        renderManager.renderEntity((Entity)entityPlayer, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        renderManager.setRenderShadow(true);
        if (!bl) {
            entityPlayer.renderYawOffset = f4;
            entityPlayer.rotationYaw = f5;
            entityPlayer.prevRotationYawHead = f7;
            entityPlayer.rotationYawHead = f8;
        }
        if (!bl2) {
            entityPlayer.rotationPitch = f6;
        }
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
        GlStateManager.disableDepth();
        GlStateManager.popMatrix();
        7q_0.1 = false;
        7l_0.1 = false;
    }
}

