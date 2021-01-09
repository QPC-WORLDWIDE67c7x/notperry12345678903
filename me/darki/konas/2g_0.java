/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import me.darki.konas.29;
import me.darki.konas.2e_0;
import me.darki.konas.8S;
import me.darki.konas.8k_0;
import me.darki.konas.8w_0;
import me.darki.konas.mixin.mixins.IMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenWorking;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2g
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2g_0
implements GuiListExtended.IGuiListEntry {
    public static Logger c = LogManager.getLogger();
    public static ResourceLocation c = new ResourceLocation("konas/textures/steve.png");
    public Minecraft c;
    public 2e_0 c;
    public 29 c;
    public DynamicTexture c;
    public ResourceLocation 0;
    public long c;
    public BufferedImage c = null;

    public void 5() {
        this.c.displayGuiScreen((GuiScreen)new GuiYesNo(this::c, "Are you sure you want to delete '" + this.c.c() + "'?", "This process cannot be reverted.", "Delete", "Cancel", 0));
    }

    public void c(boolean bl, int n2) {
        if (bl) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiScreenWorking());
            8k_0.c.c.c().0(this);
        }
        this.c.displayGuiScreen((GuiScreen)this.c);
    }

    public void 3() {
        this.c.c().c().forEach(2g_0::0);
        this.c.0(true);
        this.c.c(true);
        this.c.c(System.currentTimeMillis());
    }

    public void updatePosition(int n2, int n3, int n4, float f2) {
    }

    public static void 0(2g_0 g_02) {
        g_02.c.c(false);
    }

    public void 4() {
        this.c.c().c().forEach(2g_0::c);
        this.c.0(false);
        this.c.c(true);
        this.c.c(System.currentTimeMillis());
        this.c.1(Minecraft.getMinecraft().getSession().getUsername());
    }

    public void 1() {
        boolean bl;
        if (this.c.1()) {
            return;
        }
        this.c.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
        File file = new File(this.c.gameDir + File.separator + "exploit.txt");
        if (this.c.5()) {
            ((IMinecraft)Minecraft.getMinecraft()).setSession(new Session(this.c.c(), this.c.6(), this.c.4(), "mojang"));
            bl = !8w_0.c() ? 8w_0.0(this.c, this.c.0(), this.c.7()) : true;
        } else if (!file.exists() || this.c.4().isEmpty() || this.c.6().isEmpty()) {
            bl = 8w_0.c(this.c, this.c.0(), this.c.7());
        } else {
            bl = true;
            ((IMinecraft)Minecraft.getMinecraft()).setSession(new Session(this.c.c(), this.c.6(), this.c.4(), "mojang"));
        }
        if (bl) {
            this.4();
        } else if (8w_0.c(this.c.c())) {
            this.3();
        }
        this.c.c = 8w_0.c();
    }

    public 2g_0(29 var1_1) {
        this.c = 8k_0.c.c;
        this.c = var1_1;
        this.c = Minecraft.getMinecraft();
        if (!this.c.3()) {
            new Thread(this::6).start();
        }
    }

    public static void c(2g_0 g_02) {
        g_02.c.c(false);
    }

    public boolean c() {
        return 8w_0.c(this.c, this.c.0(), this.c.7());
    }

    public void 6() {
        String string = 8S.4(this.c.c());
        if (string == null) {
            this.c.0(true);
            return;
        }
        string = string.replaceAll("-", "");
        this.c.0(string);
        2g_0 g_02 = this;
        String string2 = string;
        InputStream inputStream = 8S.2(string2);
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        g_02.c = bufferedImage;
        BufferedImage bufferedImage2 = this.c;
        int n2 = bufferedImage2.getWidth();
        boolean bl = n2 == 64;
        String string3 = "Must be 64 pixels wide";
        Object[] objectArray = new Object[]{};
        Validate.validState((boolean)bl, (String)string3, (Object[])objectArray);
        BufferedImage bufferedImage3 = this.c;
        int n3 = bufferedImage3.getHeight();
        boolean bl2 = n3 == 64;
        String string4 = "Must be 64 pixels high";
        Object[] objectArray2 = new Object[]{};
        try {
            Validate.validState((boolean)bl2, (String)string4, (Object[])objectArray2);
        }
        catch (Throwable throwable) {
            System.err.println("Couldn't load face");
        }
    }

    public boolean mousePressed(int n2, int n3, int n4, int n5, int n6, int n7) {
        8k_0.c.c.c().c(n2);
        if (n6 <= 32 && n6 < 32) {
            this.1();
            return true;
        }
        if (Minecraft.getSystemTime() - this.c < 250L) {
            this.1();
            return true;
        }
        this.c = Minecraft.getSystemTime();
        return false;
    }

    public void 2() {
    }

    public boolean 0() {
        return 8w_0.0(this.c, this.c.0(), this.c.7());
    }

    public void mouseReleased(int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    public void drawEntry(int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl, float f2) {
        String string = this.c.1() ? TextFormatting.GREEN + this.c.c() : this.c.c();
        String string2 = this.c.0();
        String string3 = this.c.3() ? TextFormatting.RED + "Cracked" : TextFormatting.GREEN + "Premium";
        this.c.fontRenderer.drawString(string, n3 + 32 + 3, n4 + 1, 0xFFFFFF);
        if (!this.c.3()) {
            this.c.fontRenderer.drawString(string2, n3 + 32 + 3, n4 + this.c.fontRenderer.FONT_HEIGHT + 2, 0x808080);
            this.c.fontRenderer.drawString(string3, n3 + 32 + 3, n4 + this.c.fontRenderer.FONT_HEIGHT + this.c.fontRenderer.FONT_HEIGHT + 3, 0x808080);
        } else {
            this.c.fontRenderer.drawString(string3, n3 + 32 + 3, n4 + this.c.fontRenderer.FONT_HEIGHT + 3, 0x808080);
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (this.c != null) {
            if (this.c == null) {
                this.c = new DynamicTexture(this.c);
                this.0 = this.c.getTextureManager().getDynamicTextureLocation(this.c.6(), this.c);
                this.c.getTextureManager().loadTexture(this.0, (ITextureObject)this.c);
                this.c.getRGB(0, 0, this.c.getWidth(), this.c.getHeight(), this.c.getTextureData(), 0, this.c.getWidth());
                this.c.updateDynamicTexture();
            }
        } else if (!this.c.3()) {
            new Thread(this::6).start();
        }
        this.c.getTextureManager().bindTexture(this.c != null ? this.0 : c);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture((int)n3, (int)n4, (float)0.0f, (float)0.0f, (int)32, (int)32, (float)32.0f, (float)32.0f);
        GlStateManager.disableBlend();
    }
}

