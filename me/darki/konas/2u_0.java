/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.util.ArrayList;
import me.darki.konas.2B;
import me.darki.konas.2o_0;
import me.darki.konas.2p_0;
import me.darki.konas.2q_0;
import me.darki.konas.2r_0;
import me.darki.konas.2t_0;
import me.darki.konas.2v_0;
import me.darki.konas.2w_0;
import me.darki.konas.2x_0;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.3H;
import me.darki.konas.87;
import me.darki.konas.89;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8j_0;
import me.darki.konas.94;
import me.darki.konas.9b;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2u
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2u_0
extends 2r_0 {
    public 3E c;
    public ArrayList<2r_0> c;
    public 9m c = new 9m();

    public 3E 0() {
        return this.c;
    }

    @Override
    public void 0(float f2, float f3) {
        super.0(f2, f3);
        this.c().forEach(this::c);
    }

    public void c(2r_0 r_02) {
        r_02.0(this.e(), this.6());
    }

    @Override
    public void 4() {
        super.4();
        float f2 = this.9();
        for (8h_0 h_02 : 3F.1(this.0())) {
            float f3;
            float f4 = f3 = h_02.3() ? 4.0f : 2.0f;
            if (h_02.6() instanceof 87) {
                this.1().add(new 2o_0(this.0(), this.e(), this.6(), f3, f2, this.d() - f3, 12.0f));
                f2 += 12.0f;
                continue;
            }
            if (h_02.6() instanceof 8j_0) {
                this.1().add(new 2x_0(h_02, this.e(), this.6(), f3, f2, this.d() - f3, 12.0f));
                f2 += 12.0f;
                continue;
            }
            if (h_02.6() instanceof Boolean) {
                this.1().add(new 2p_0(h_02, this.e(), this.6(), f3, f2, this.d() - f3, 12.0f));
                f2 += 12.0f;
                continue;
            }
            if (h_02.6() instanceof 8f_0) {
                this.1().add(new 2v_0(h_02, this.e(), this.6(), f3, f2, this.d() - f3, 12.0f));
                f2 += 12.0f;
                continue;
            }
            if (h_02.6() instanceof Number) {
                this.1().add(new 2w_0(h_02, this.e(), this.6(), f3, f2, this.d() - f3, 12.0f));
                f2 += 12.0f;
                continue;
            }
            if (h_02.6() instanceof Enum) {
                this.1().add(new 2t_0(h_02, this.e(), this.6(), f3, f2, this.d() - f3, 12.0f));
                f2 += 12.0f;
                continue;
            }
            if (!(h_02.6() instanceof 89)) continue;
            this.1().add(new 2q_0(h_02, this.e(), this.6(), f3, f2, this.d() - f3, 60.0f));
            f2 += 12.0f;
        }
        this.c().forEach(2r_0::4);
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        super.0(n2, n3, n4);
        boolean bl = 2u_0.c(n2, n3, this.e(), this.6(), this.d(), this.9());
        if (bl) {
            switch (n4) {
                case 0: {
                    Minecraft.getMinecraft().getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
                    this.0().d();
                    return true;
                }
                case 1: {
                    Minecraft.getMinecraft().getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
                    this.1(!this.7());
                    return true;
                }
            }
        }
        if (this.7()) {
            for (2r_0 r_02 : this.c()) {
                if (!r_02.0(n2, n3, n4)) continue;
                return true;
            }
        }
        return false;
    }

    public static void c(int n2, int n3, int n4, long l2, 2r_0 r_02) {
        r_02.c(n2, n3, n4, l2);
    }

    public static void c(char c2, int n2, 2r_0 r_02) {
        r_02.c(c2, n2);
    }

    public static void c(int n2, int n3, float f2, 2r_0 r_02) {
        r_02.c(n2, n3, f2);
    }

    public 2u_0(3E e2, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(e2.b(), f2, f3, f4, f5, f6, f7);
        this.c = e2;
    }

    public ArrayList<2r_0> 1() {
        return this.c;
    }

    public ArrayList<2r_0> c() {
        ArrayList<2r_0> arrayList = new ArrayList<2r_0>();
        for (2r_0 r_02 : this.1()) {
            if (r_02 instanceof 2o_0) {
                arrayList.add(r_02);
                continue;
            }
            if (r_02 instanceof 2p_0) {
                if (!((2p_0)r_02).c().b()) continue;
                arrayList.add(r_02);
                continue;
            }
            if (r_02 instanceof 2q_0) {
                if (!((2q_0)r_02).c().b()) continue;
                arrayList.add(r_02);
                continue;
            }
            if (r_02 instanceof 2t_0) {
                if (!((2t_0)r_02).c().b()) continue;
                arrayList.add(r_02);
                continue;
            }
            if (r_02 instanceof 2x_0) {
                if (!((2x_0)r_02).0().b()) continue;
                arrayList.add(r_02);
                continue;
            }
            if (r_02 instanceof 2w_0) {
                if (!((2w_0)r_02).c().b()) continue;
                arrayList.add(r_02);
                continue;
            }
            arrayList.add(r_02);
        }
        return arrayList;
    }

    public static void c(int n2, int n3, int n4, 2r_0 r_02) {
        r_02.1(n2, n3, n4);
    }

    @Override
    public void 1(int n2, int n3, int n4) {
        block0: {
            super.1(n2, n3, n4);
            if (!this.7()) break block0;
            this.c().forEach(arg_0 -> 2u_0.c(n2, n3, n4, arg_0));
        }
    }

    @Override
    public void c(int n2, int n3, float f2) {
        block4: {
            int n4;
            super.c(n2, n3, f2);
            float f3 = this.9();
            for (2r_0 r_02 : this.c()) {
                r_02.1(f3);
                f3 += r_02.9();
            }
            int n5 = n4 = this.c.f() ? ((89)3H.2.6()).c() : ((89)3H.4.6()).c();
            if (((Boolean)3H.9.6()).booleanValue()) {
                if (2u_0.c(n2, n3, this.e(), this.6(), this.d(), this.9())) {
                    n4 = this.c.f() ? ((89)3H.2.6()).4().brighter().hashCode() : new Color(96, 96, 96, 100).hashCode();
                }
            }
            94.c(this.e(), this.6(), this.d(), this.9(), n4);
            int n6 = (int)(this.6() + this.9() / 2.0f - 9b.c(this.8()) / 2.0f);
            9b.c(this.8(), (int)(this.e() + 4.0f), n6, ((89)3H.3.6()).c());
            if (this.c.6() != 0 && ((Boolean)3H.1.6()).booleanValue()) {
                String string = GameSettings.getKeyDisplayString((int)this.0().6());
                string = string.replaceAll("NUMPAD", "");
                9b.c(string, (int)(this.e() + this.d() - 4.0f - (9b.0(string) - 0.5f)), n6, ((89)3H.3.6()).c());
            }
            if (!this.7()) break block4;
            this.c().forEach(arg_0 -> 2u_0.c(n2, n3, f2, arg_0));
        }
    }

    @Override
    public void c(char c2, int n2) {
        block0: {
            super.c(c2, n2);
            if (!this.7()) break block0;
            this.c().forEach(arg_0 -> 2u_0.c(c2, n2, arg_0));
        }
    }

    public void c(int n2, int n3) {
        block2: {
            block1: {
                if (!2u_0.c(n2, n3, this.e(), this.6(), this.d(), this.9())) break block1;
                if (!this.c.c(500.0)) break block2;
                2B.c = this.0().8();
                break block2;
            }
            if (2B.c != null && 2B.c.equals(this.0().8())) {
                2B.c = null;
            }
            this.c.c();
        }
    }

    @Override
    public void c(int n2, int n3, int n4, long l2) {
        block0: {
            super.c(n2, n3, n4, l2);
            if (!this.7()) break block0;
            this.c().forEach(arg_0 -> 2u_0.c(n2, n3, n4, l2, arg_0));
        }
    }
}

