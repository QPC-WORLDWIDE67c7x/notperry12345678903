/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.2r_0;
import me.darki.konas.3H;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.94;
import me.darki.konas.9b;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2p
 */
public class 2p_0
extends 2r_0 {
    public 8h_0<Boolean> c;

    @Override
    public boolean 0(int n2, int n3, int n4) {
        super.0(n2, n3, n4);
        boolean bl = 2p_0.c(n2, n3, this.e(), this.6(), this.d(), this.9());
        if (bl && n4 == 0) {
            Minecraft.getMinecraft().getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
            this.c().2(Boolean.valueOf((Boolean)this.c().6() == false));
            return true;
        }
        return false;
    }

    @Override
    public void c(int n2, int n3, float f2) {
        int n4;
        super.c(n2, n3, f2);
        94.c(this.2(), this.6(), this.b(), this.9(), ((89)3H.2.6()).c());
        int n5 = n4 = (Boolean)this.c().6() != false ? ((89)3H.2.6()).4().darker().getRGB() : ((89)3H.4.6()).c();
        if (((Boolean)3H.9.6()).booleanValue() && 2p_0.c(n2, n3, this.e(), this.6(), this.d(), this.9())) {
            n4 = (Boolean)this.c().6() != false ? ((89)3H.2.6()).4().brighter().getRGB() : new Color(96, 96, 96, 100).hashCode();
        }
        94.c(this.e(), this.6(), this.d(), this.9(), n4);
        9b.c(this.8(), (int)(this.e() + 5.0f), (int)(this.6() + this.9() / 2.0f - 9b.c(this.8()) / 2.0f - 0.5f), ((89)3H.3.6()).c());
    }

    public 2p_0(8h_0<Boolean> h_02, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(h_02.c(), f2, f3, f4, f5, f6, f7);
        this.c = h_02;
    }

    public 8h_0<Boolean> c() {
        return this.c;
    }
}

