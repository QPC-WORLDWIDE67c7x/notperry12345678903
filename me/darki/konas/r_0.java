/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import me.darki.konas.2;
import me.darki.konas.68;
import me.darki.konas.8p_0;
import me.darki.konas.9o;
import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.r
 */
public class r_0
extends 2 {
    @Override
    public void c(String[] stringArray) {
        block30: {
            StringBuilder stringBuilder;
            if (stringArray.length != this.2().size() + 1) {
                8p_0.1(this.0());
                return;
            }
            Map<String, String> map = 9o.c();
            Map<String, String> map2 = map;
            PrintStream printStream = System.out;
            Map<String, String> map3 = map2;
            printStream.println(map3);
            Map<String, String> map4 = map2;
            String string = stringArray[1];
            String string2 = 9o.c(map4, string);
            String string3 = string2;
            if (string3 == null) break block30;
            68.2 = string3;
            StringBuilder stringBuilder2 = stringBuilder;
            StringBuilder stringBuilder3 = stringBuilder;
            stringBuilder2();
            String string4 = "Set target language to ";
            StringBuilder stringBuilder4 = stringBuilder3.append(string4);
            char c2 = 2.c;
            StringBuilder stringBuilder5 = stringBuilder4.append(c2);
            String string5 = "b";
            StringBuilder stringBuilder6 = stringBuilder5.append(string5);
            Map<String, String> map5 = map2;
            String string6 = string3;
            String string7 = map5.get(string6);
            String string8 = string7;
            StringBuilder stringBuilder7 = stringBuilder6.append(string8);
            String string9 = stringBuilder7.toString();
            8p_0.1(string9);
        }
        String string = "Couldn't find language!";
        try {
            8p_0.c(string);
        }
        catch (IOException iOException) {
            8p_0.c("Error while fetching languages!");
        }
    }

    public r_0() {
        super("language", "Lets you choose your target language for the Translate Module", new SyntaxChunk("<language>"));
    }
}

