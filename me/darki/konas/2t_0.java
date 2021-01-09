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
 * Renamed from me.darki.konas.2t
 */
public class 2t_0
extends 2r_0 {
    public 8h_0<Enum> c;

    public 2t_0(8h_0<Enum> h_02, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(h_02.c(), f2, f3, f4, f5, f6, f7);
        this.c = h_02;
    }

    public boolean c(int n2) {
        return n2 <= ((Enum[])((Enum)this.c().6()).getClass().getEnumConstants()).length - 1 && n2 >= 0;
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        int n4 = 2t_0.c(n2, n3, this.e(), this.6(), this.d(), this.9()) ? new Color(96, 96, 96, 100).hashCode() : ((89)3H.4.6()).c();
        94.c(this.e(), this.6(), this.d(), this.9(), n4);
        9b.c(this.8(), (int)(this.e() + 5.0f), (int)(this.6() + this.9() / 2.0f - 9b.c(this.8()) / 2.0f), ((89)3H.3.6()).c());
        94.c(this.2(), this.6(), this.b(), this.9(), ((89)3H.2.6()).c());
        9b.c(((Enum)this.c().6()).toString(), (int)(this.e() + 5.0f + 9b.0(this.8())), (int)(this.6() + this.9() / 2.0f - 9b.c(((Enum)this.c().6()).toString()) / 2.0f), ((89)3H.2.6()).c());
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        boolean bl;
        super.0(n2, n3, n4);
        boolean bl2 = 2t_0.c(n2, n3, this.e(), this.6(), this.d(), this.9());
        boolean bl3 = bl = (float)n2 > this.e() + this.d() / 2.0f;
        if (bl2 && n4 == 0) {
            Minecraft.getMinecraft().getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
            int n5 = this.c().3(((Enum)this.c().6()).toString());
            if (bl) {
                if (this.c(n5 + 1)) {
                    this.c().2(((Enum[])((Enum)this.c().6()).getClass().getEnumConstants())[n5 + 1]);
                } else {
                    this.c().2(((Enum[])((Enum)this.c().6()).getClass().getEnumConstants())[0]);
                }
            } else if (this.c(n5 - 1)) {
                this.c().2(((Enum[])((Enum)this.c().6()).getClass().getEnumConstants())[n5 - 1]);
            } else {
                this.c().2(((Enum[])((Enum)this.c().6()).getClass().getEnumConstants())[((Enum[])((Enum)this.c().6()).getClass().getEnumConstants()).length - 1]);
            }
            return true;
        }
        return false;
    }

    public 8h_0<Enum> c() {
        return this.c;
    }
}

