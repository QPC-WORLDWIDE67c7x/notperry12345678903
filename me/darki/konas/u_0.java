/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;
import org.lwjgl.input.Keyboard;

/*
 * Renamed from me.darki.konas.u
 */
public class u_0
extends 2 {
    public u_0() {
        super("modules", "List all modules including their given keybinds", new SyntaxChunk[0]);
    }

    public static void c(3E e2) {
        8p_0.1(e2.b() + (e2.6() != 0 ? " [&b" + Keyboard.getKeyName((int)e2.6()) + "&f]" : ""));
    }

    @Override
    public void c(String[] stringArray) {
        8p_0.1("&bModules:");
        8p_0.1(" ");
        3F.2().forEach(u_0::c);
    }
}

