/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.3H;
import me.darki.konas.3N;
import me.darki.konas.3s_0;
import me.darki.konas.7I;
import me.darki.konas.7J;
import me.darki.konas.8p_0;
import me.darki.konas.9b;
import me.darki.konas.9d;
import me.darki.konas.9f;
import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.i
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class i_0
extends 2 {
    public static String 2 = "default";

    public i_0() {
        super("font", "Change the font", new SyntaxChunk("<Font>"));
    }

    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size() + 1) {
            8p_0.c(this.0());
            return;
        }
        2 = stringArray[1];
        3N.c = new 9d(stringArray[1], 18.0f);
        9f.c(3N.c);
        3H.c = new 9d(stringArray[1], 17.0f);
        9b.c(3H.c);
        7J.c = new 9d(stringArray[1], 20.0f);
        7J.0 = new 9d(stringArray[1], 60.0f);
        7J.c((7I)((Object)7J.K.6()));
        3s_0.0 = new 9d(stringArray[1], 18.0f);
        3s_0.c = new 9d(stringArray[1], 16.0f);
    }
}

