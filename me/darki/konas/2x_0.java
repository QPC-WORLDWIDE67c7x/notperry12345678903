/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import java.awt.Color;
import me.darki.konas.2n_0;
import me.darki.konas.2r_0;
import me.darki.konas.3H;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.8j_0;
import me.darki.konas.94;
import me.darki.konas.9b;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2x
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2x_0
extends 2r_0 {
    public 8h_0 c;
    public boolean c;

    public 2x_0(8h_0 h_02, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(h_02.c(), f2, f3, f4, f5, f6, f7);
        this.c = h_02;
        EventDispatcher.Companion.register(this);
        EventDispatcher.Companion.subscribe(this);
    }

    @Override
    public void c(char c2, int n2) {
        block1: {
            super.c(c2, n2);
            if (!this.c()) break block1;
            if (n2 == 1) {
                ((8j_0)this.c.6()).c(0);
                this.c(false);
                return;
            }
            ((8j_0)this.c.6()).c(n2);
            this.c(false);
        }
    }

    public boolean c() {
        return this.c;
    }

    public void c(boolean bl) {
        this.c = bl;
        2n_0.c(bl);
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        94.c(this.2(), this.6(), this.b(), this.9(), ((89)3H.2.6()).c());
        int n4 = 2x_0.c(n2, n3, this.e(), this.6(), this.d(), this.9()) ? new Color(96, 96, 96, 100).hashCode() : ((89)3H.4.6()).c();
        94.c(this.e(), this.6(), this.d(), this.9(), n4);
        9b.c(this.c() ? "Press new bind..." : this.8() + ": " + GameSettings.getKeyDisplayString((int)((8j_0)this.c.6()).c()), (int)(this.e() + 5.0f), (int)(this.6() + this.9() / 2.0f - 9b.c(this.c() ? "Press new bind..." : this.8() + ": " + GameSettings.getKeyDisplayString((int)((8j_0)this.c.6()).c())) / 2.0f - 0.5f), 0xFFFFFF);
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        super.0(n2, n3, n4);
        if (this.c()) {
            ((8j_0)this.c.6()).c(n4 - 100);
            this.c(false);
            return true;
        }
        boolean bl = 2x_0.c(n2, n3, this.e(), this.6(), this.d(), this.9());
        if (bl && n4 == 0) {
            Minecraft.getMinecraft().getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
            this.c(!this.c());
            return true;
        }
        return false;
    }

    public 8h_0 0() {
        return this.c;
    }
}

