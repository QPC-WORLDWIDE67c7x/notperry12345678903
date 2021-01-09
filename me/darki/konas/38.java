/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.IOException;
import me.darki.konas.3O;
import me.darki.konas.3a_0;
import me.darki.konas.3f_0;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import org.lwjgl.input.Mouse;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 38
extends GuiScreen {
    public 3f_0 c;
    public static boolean c = false;

    public void c() {
        this.c = new 3f_0((Boolean)3O.c.6() != false ? 488.0f : 800.0f, ((Integer)3O.u.6()).intValue());
    }

    public void mouseClickMove(int n2, int n3, int n4, long l2) {
        super.mouseClickMove(n2, n3, n4, l2);
        this.c.c(n2, n3, n4, l2);
    }

    public void mouseClicked(int n2, int n3, int n4) throws IOException {
        block0: {
            super.mouseClicked(n2, n3, n4);
            if (!this.c.0(n2, n3, n4)) break block0;
            this.mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
        }
    }

    public 3f_0 0() {
        return this.c;
    }

    public void mouseReleased(int n2, int n3, int n4) {
        super.mouseReleased(n2, n3, n4);
        this.c.c(n2, n3, n4);
    }

    public void initGui() {
        super.initGui();
        this.c.c(0.0f, 0.0f);
    }

    public void keyTyped(char c2, int n2) throws IOException {
        this.c.c(c2, n2);
        if (c) {
            c = false;
            return;
        }
        super.keyTyped(c2, n2);
    }

    public void drawScreen(int n2, int n3, float f2) {
        super.drawScreen(n2, n3, f2);
        if (((Boolean)3O.t.6()).booleanValue()) {
            3O.t.2(Boolean.valueOf(false));
            this.c();
            this.c.c(0.0f, 0.0f);
        }
        3a_0.c(Mouse.getDWheel());
        this.c.0(n2, n3, f2);
        this.c.c(n2, n3, f2);
    }
}

