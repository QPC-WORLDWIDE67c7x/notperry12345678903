/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.28;
import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.8h_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 31
extends 2E {
    public static 28 c = new 28();
    public static 8h_0<89> 1 = new 8h_0("Selected", new 89(Color.BLUE.hashCode(), true));
    public static 8h_0<89> 2 = new 8h_0("Toggled", new 89(Color.BLUE.hashCode(), true));

    @Override
    public void c(int n2) {
        block1: {
            block3: {
                block2: {
                    block0: {
                        super.c(n2);
                        if (n2 != 208) break block0;
                        c.2();
                        break block1;
                    }
                    if (n2 != 200) break block2;
                    c.4();
                    break block1;
                }
                if (n2 != 203) break block3;
                c.c();
                break block1;
            }
            if (n2 != 205 && n2 != 28) break block1;
            c.0();
        }
    }

    public 31() {
        super("TabGUI", 3.0f, 80.0f, 120.0f, 100.0f);
    }

    @Override
    public void 5() {
        super.5();
        c.c(this.9(), this.3());
        this.0(c.1());
        this.c((float)c.3());
    }
}

