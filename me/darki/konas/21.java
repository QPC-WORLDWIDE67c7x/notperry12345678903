/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.02;
import me.darki.konas.2;
import me.darki.konas.3;
import me.darki.konas.8p_0;

public class 21 {
    public static 21 c = new 21();

    @Subscriber
    public void c(02 var1_1) {
        block2: {
            String string = var1_1.c();
            if (!string.startsWith(2.1())) break block2;
            var1_1.c(true);
            String[] stringArray = string.replaceAll("([\\s])\\1+", "$1").split(" ");
            if (3.c(stringArray[0]) != null) {
                3.c(stringArray[0]).c(stringArray);
            } else {
                8p_0.c("Command not found! To view a list of all commands type " + 2.1() + "commands");
            }
        }
    }
}

