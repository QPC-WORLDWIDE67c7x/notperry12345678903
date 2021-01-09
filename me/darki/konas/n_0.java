/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.6e_0;
import me.darki.konas.8V;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;
import net.minecraft.util.math.BlockPos;

/*
 * Renamed from me.darki.konas.n
 */
public class n_0
extends 2 {
    public n_0() {
        super("goto", "Go to coordinates", new String[]{"go"}, new SyntaxChunk("<X>"), new SyntaxChunk("<Y>"), new SyntaxChunk("<Z>"));
    }

    @Override
    public void c(String[] stringArray) {
        block17: {
            String string;
            BlockPos blockPos;
            BlockPos blockPos2;
            8V v;
            8V v2;
            if (stringArray.length != this.2().size() + 1) {
                8p_0.1(this.0());
                return;
            }
            3E e2 = 3F.c("AutoWalk");
            if (e2 == null) {
                return;
            }
            if (!(e2 instanceof 6e_0)) {
                return;
            }
            6e_0 e_02 = (6e_0)e2;
            e_02.1 = 0;
            e_02.1 = false;
            try {
                BlockPos blockPos3;
                8V v3;
                6e_0 e_03 = e_02;
                v2 = v3;
                v = v3;
                blockPos2 = blockPos3;
                blockPos = blockPos3;
                string = stringArray[1];
            }
            catch (Exception exception) {
                8p_0.1(this.0());
                return;
            }
            int n2 = Integer.parseInt(string);
            String string2 = stringArray[2];
            int n3 = Integer.parseInt(string2);
            String string3 = stringArray[3];
            int n4 = Integer.parseInt(string3);
            blockPos2(n2, n3, n4);
            String string4 = "GOTO-WALK";
            v2(blockPos, string4);
            e_03.c = v;
            e_02.c.2();
            e_02.1.2(Boolean.valueOf(true));
            if (e_02.f()) break block17;
            e_02.d();
        }
    }
}

