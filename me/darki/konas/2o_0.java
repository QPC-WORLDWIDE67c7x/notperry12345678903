/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import java.awt.Color;
import me.darki.konas.2n_0;
import me.darki.konas.2r_0;
import me.darki.konas.3E;
import me.darki.konas.3H;
import me.darki.konas.89;
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
 * Renamed from me.darki.konas.2o
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2o_0
extends 2r_0 {
    public 3E c;
    public boolean c;

    @Override
    public boolean 0(int n2, int n3, int n4) {
        super.0(n2, n3, n4);
        if (this.c()) {
            this.0().c(n4 - 100);
            this.c(false);
            return true;
        }
        boolean bl = 2o_0.c(n2, n3, this.e(), this.6(), this.d(), this.9());
        if (bl && n4 == 0) {
            Minecraft.getMinecraft().getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
            this.c(!this.c());
            return true;
        }
        if (bl && n4 == 1) {
            Minecraft.getMinecraft().getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
            this.0().0(!this.0().3());
            return true;
        }
        return false;
    }

    @Override
    public void c(char c2, int n2) {
        block1: {
            super.c(c2, n2);
            if (!this.c()) break block1;
            if (n2 == 1) {
                this.0().c(0);
                this.c(false);
                return;
            }
            this.0().c(n2);
            this.c(false);
        }
    }

    public 2o_0(3E e2, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(e2.b(), f2, f3, f4, f5, f6, f7);
        this.c = e2;
        EventDispatcher.Companion.register(this);
        EventDispatcher.Companion.subscribe(this);
    }

    public boolean c() {
        return this.c;
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        94.c(this.2(), this.6(), this.b(), this.9(), ((89)3H.2.6()).c());
        int n4 = 2o_0.c(n2, n3, this.e(), this.6(), this.d(), this.9()) ? new Color(96, 96, 96, 100).hashCode() : ((89)3H.4.6()).c();
        94.c(this.e(), this.6(), this.d(), this.9(), n4);
        9b.c(this.c() ? "Press new bind..." : (this.0().3() ? "Hold: " : "Bind: ") + GameSettings.getKeyDisplayString((int)this.0().6()), (int)(this.e() + 5.0f), (int)(this.6() + this.9() / 2.0f - 9b.c(this.c() ? "Press new bind..." : "Bind: " + GameSettings.getKeyDisplayString((int)this.0().6())) / 2.0f - 0.5f), 0xFFFFFF);
    }

    public 3E 0() {
        return this.c;
    }

    public void c(boolean bl) {
        this.c = bl;
        2n_0.c(bl);
    }
}

