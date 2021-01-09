/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import me.darki.konas.0d_0;
import me.darki.konas.1r_0;
import me.darki.konas.1z_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.9f;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3X
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Texture", true);
    public static 8h_0<Boolean> 2 = new 8h_0("CustomColor", false);
    public static 8h_0<89> 3 = new 8h_0("Color", new 89(-65281, true));
    public static 8h_0<Boolean> 4 = new 8h_0("Shulkers", true);
    public static 8h_0<Boolean> 5 = new 8h_0("Maps", true);
    public int 1;
    public int 2;

    public 3X() {
        super("Tooltips", "Enchances inventory tooltips", 3D.5, new String[0]);
    }

    @Subscriber
    public void c(ItemTooltipEvent itemTooltipEvent) {
        if (((Boolean)5.6()).booleanValue() && itemTooltipEvent.getItemStack().getItem() instanceof ItemMap) {
            itemTooltipEvent.getToolTip().clear();
            itemTooltipEvent.getToolTip().add(itemTooltipEvent.getItemStack().getDisplayName());
        }
    }

    @Subscriber
    public void c(0d_0 d_02) {
        block3: {
            if (!((Boolean)5.6()).booleanValue() || !(d_02.c() instanceof GuiContainer) || !(3X.c.player.inventory.getItemStack().getItem() instanceof ItemAir)) break block3;
            Slot slot = ((GuiContainer)d_02.c()).getSlotUnderMouse();
            if (slot == null || !slot.getHasStack()) {
                return;
            }
            ItemStack itemStack = slot.getStack();
            if (itemStack.getItem() instanceof ItemMap) {
                MapData mapData = ((ItemMap)itemStack.getItem()).getMapData(itemStack, (World)3X.c.world);
                if (mapData == null) {
                    return;
                }
                GlStateManager.disableDepth();
                GlStateManager.disableLighting();
                c.getTextureManager().bindTexture(new ResourceLocation("textures/map/map_background.png"));
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuffer();
                GlStateManager.translate((double)this.1, (double)((double)this.2 - 72.0), (double)0.0);
                GlStateManager.scale((double)0.5, (double)0.5, (double)1.0);
                bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
                bufferBuilder.pos(-7.0, 135.0, 0.0).tex(0.0, 1.0).endVertex();
                bufferBuilder.pos(135.0, 135.0, 0.0).tex(1.0, 1.0).endVertex();
                bufferBuilder.pos(135.0, -7.0, 0.0).tex(1.0, 0.0).endVertex();
                bufferBuilder.pos(-7.0, -7.0, 0.0).tex(0.0, 0.0).endVertex();
                tessellator.draw();
                3X.c.entityRenderer.getMapItemRenderer().renderMap(mapData, true);
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
        }
    }

    @Subscriber
    public void c(1z_0 z_02) {
        if (((Boolean)5.6()).booleanValue() && z_02.1().getItem() instanceof ItemMap) {
            this.1 = z_02.0();
            this.2 = z_02.c();
        }
    }

    public void c(ItemStack itemStack, int n2, int n3) {
        NBTTagCompound nBTTagCompound = itemStack.getTagCompound();
        GlStateManager.enableBlend();
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        if (((Boolean)1.6()).booleanValue()) {
            NBTTagCompound nBTTagCompound2;
            int n4 = 144;
            int n5 = n2 + 12;
            int n6 = n3 - 12;
            int n7 = 48 + 9f.c();
            3X.c.getRenderItem().zLevel = 300.0f;
            Color color = (Boolean)2.6() != false ? new Color(((89)3.6()).c()) : new Color(((BlockShulkerBox)((ItemShulkerBox)itemStack.getItem()).getBlock()).getColor().getColorValue());
            this.c((double)n5 - 8.5, n6 - 3, 0.0, 0.0, n4 + 3, n7 + 6, color);
            3X.c.fontRenderer.drawString(itemStack.getDisplayName(), n2 + 8, n3 - 12, 0xFFFFFF);
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableTexture2D();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.scale((double)0.75, (double)0.75, (double)0.75);
            if (nBTTagCompound != null && !(nBTTagCompound2 = nBTTagCompound.getCompoundTag("BlockEntityTag")).isEmpty() && nBTTagCompound2.getTagList("Items", 10) != null) {
                NonNullList nonNullList = NonNullList.withSize((int)27, (Object)ItemStack.EMPTY);
                ItemStackHelper.loadAllItems((NBTTagCompound)nBTTagCompound2, (NonNullList)nonNullList);
                for (int i2 = 0; i2 < nonNullList.size(); ++i2) {
                    int n8 = n2 + i2 % 9 * 15 + 11;
                    int n9 = n3 + i2 / 9 * 15 - 11 + 10;
                    n8 = (int)((double)n8 / 0.75);
                    n9 = (int)((double)n9 / 0.75);
                    ItemStack itemStack2 = (ItemStack)nonNullList.get(i2);
                    c.getRenderItem().renderItemAndEffectIntoGUI(itemStack2, n8, n9);
                    c.getRenderItem().renderItemOverlayIntoGUI(3X.c.fontRenderer, itemStack2, n8, n9, null);
                }
            }
            GlStateManager.scale((double)-0.75, (double)-0.75, (double)-0.75);
            RenderHelper.disableStandardItemLighting();
            3X.c.getRenderItem().zLevel = 0.0f;
        } else {
            float f2 = Math.max(144.0f, 9f.0(itemStack.getDisplayName()) + 3.0f);
            int n10 = n2 + 12;
            int n11 = n3 - 12;
            int n12 = 48 + 9f.c();
            3X.c.getRenderItem().zLevel = 300.0f;
            Color color = (Boolean)2.6() != false ? new Color(((89)3.6()).c()) : new Color(((BlockShulkerBox)((ItemShulkerBox)itemStack.getItem()).getBlock()).getColor().getColorValue());
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), 150);
            GuiScreen.drawRect((int)(n10 - 3), (int)(n11 - 3), (int)((int)((float)n10 + f2 + 3.0f)), (int)(n11 + n12 + 3), (int)color2.getRGB());
            ItemStack itemStack3 = itemStack;
            String string = itemStack3.getDisplayName();
            float f3 = n2 + 12;
            float f4 = n3 - 12;
            int n13 = -1;
            try {
                9f.1(string, f3, f4, n13);
            }
            catch (NullPointerException nullPointerException) {
                System.out.println("Error rendering font");
            }
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableTexture2D();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableGUIStandardItemLighting();
            if (nBTTagCompound != null) {
                NBTTagCompound nBTTagCompound3 = nBTTagCompound.getCompoundTag("BlockEntityTag");
                NonNullList nonNullList = NonNullList.withSize((int)27, (Object)ItemStack.EMPTY);
                ItemStackHelper.loadAllItems((NBTTagCompound)nBTTagCompound3, (NonNullList)nonNullList);
                for (int i3 = 0; i3 < nonNullList.size(); ++i3) {
                    int n14 = n2 + i3 % 9 * 16 + 11;
                    int n15 = n3 + i3 / 9 * 16 - 11 + 8;
                    ItemStack itemStack4 = (ItemStack)nonNullList.get(i3);
                    c.getRenderItem().renderItemAndEffectIntoGUI(itemStack4, n14, n15);
                    c.getRenderItem().renderItemOverlayIntoGUI(3X.c.fontRenderer, itemStack4, n14, n15, null);
                }
            }
            RenderHelper.disableStandardItemLighting();
            3X.c.getRenderItem().zLevel = 0.0f;
        }
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableRescaleNormal();
    }

    @Subscriber
    public void c(1r_0 r_02) {
        block0: {
            if (!((Boolean)4.6()).booleanValue() || !(r_02.c().getItem() instanceof ItemShulkerBox)) break block0;
            this.c(r_02.c(), r_02.1(), r_02.0());
            r_02.c(true);
        }
    }

    public void c(double d2, double d3, double d4, double d5, double d6, double d7, Color color) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        c.getTextureManager().bindTexture(new ResourceLocation("konas/textures/container.png"));
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferBuilder.pos(d2, d3 + d7, 69.0).tex((double)((float)d4 * 0.00683593f), (double)((float)(d5 + d7) * 0.015676616f)).color(color.getRed(), color.getGreen(), color.getBlue(), 255).endVertex();
        bufferBuilder.pos(d2 + d6, d3 + d7, 69.0).tex((double)((float)(d4 + d6) * 0.0068f), (double)((float)(d5 + d7) * 0.015676616f)).color(color.getRed(), color.getGreen(), color.getBlue(), 255).endVertex();
        bufferBuilder.pos(d2 + d6, d3 + 0.0, 69.0).tex((double)((float)(d4 + d6) * 0.0068f), (double)((float)d5 * 0.015676616f)).color(color.getRed(), color.getGreen(), color.getBlue(), 255).endVertex();
        bufferBuilder.pos(d2, d3 + 0.0, 69.0).tex((double)((float)d4 * 0.00683593f), (double)((float)d5 * 0.015676616f)).color(color.getRed(), color.getGreen(), color.getBlue(), 255).endVertex();
        tessellator.draw();
    }
}

