/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.09;
import me.darki.konas.2;
import me.darki.konas.3F;
import me.darki.konas.5J;
import me.darki.konas.b_0;
import me.darki.konas.command.SyntaxChunk;

public class 7
extends 2 {
    public 7() {
        super("backup", "Notifies your party that you need backup", new SyntaxChunk[0]);
    }

    @Override
    public void c(String[] stringArray) {
        String string = "I need backup at X:" + 7.c.player.getPosition().getX() + " Y:" + 7.c.player.getPosition().getY() + " Z:" + 7.c.player.getPosition().getZ() + " in the " + (7.c.player.dimension == -1 ? "Nether" : "Overworld");
        if (3F.c(5J.class).f() && ((Boolean)5J.4.6()).booleanValue()) {
            7.c.player.sendChatMessage(string);
        } else {
            for (String string2 : b_0.0) {
                EventDispatcher.Companion.dispatch(new 09(string2, string));
            }
        }
    }
}

