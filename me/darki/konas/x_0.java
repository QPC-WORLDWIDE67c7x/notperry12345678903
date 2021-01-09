/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import me.darki.konas.2;
import me.darki.konas.6;
import me.darki.konas.8t_0;

/*
 * Renamed from me.darki.konas.x
 */
public class x_0
extends 2 {
    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != 2) {
            8t_0.1(this.0(), new Object[0]);
            return;
        }
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            StringBuilder stringBuilder;
            URI uRI;
            Desktop desktop = Desktop.getDesktop();
            URI uRI2 = uRI;
            URI uRI3 = uRI;
            StringBuilder stringBuilder2 = stringBuilder;
            StringBuilder stringBuilder3 = stringBuilder;
            stringBuilder2();
            String string = "https://namemc.com/search?q=";
            StringBuilder stringBuilder4 = stringBuilder3.append(string);
            String string2 = stringArray[1];
            StringBuilder stringBuilder5 = stringBuilder4.append(string2);
            String string3 = stringBuilder5.toString();
            uRI2(string3);
            try {
                desktop.browse(uRI3);
            }
            catch (IOException | URISyntaxException exception) {
                // empty catch block
            }
        }
    }

    public x_0() {
        super("namemc", "Opens up the NameMC Page for the specified player", new String[]{"nmc"}, new 6("[player]"));
    }
}

