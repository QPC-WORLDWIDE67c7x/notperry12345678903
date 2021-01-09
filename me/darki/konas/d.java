/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.io.Files;
import java.io.File;
import java.util.List;
import me.darki.konas.2;
import me.darki.konas.8p_0;
import me.darki.konas.8t_0;
import me.darki.konas.T;
import me.darki.konas.command.SyntaxChunk;

public class d
extends 2 {
    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size()) {
            if (stringArray.length != this.2().size() + 1) {
                8p_0.c(this.0());
                return;
            }
        }
        if (!T.1.exists()) {
            T.1.mkdir();
        }
        if (stringArray[1].equalsIgnoreCase("list")) {
            List<File> list = T.c();
            8t_0.0("(h)Configs:", new Object[0]);
            8t_0.c();
            if (T.3.toPath() == T.0.toPath()) {
                8t_0.0("(h)default", new Object[0]);
            } else {
                8t_0.0("default", new Object[0]);
            }
            if (list != null && !list.isEmpty()) {
                for (File file : list) {
                    if (file.toPath() == T.3.toPath()) {
                        8t_0.0("(h)%s", Files.getNameWithoutExtension((String)file.getName()));
                        continue;
                    }
                    8t_0.0("%s", Files.getNameWithoutExtension((String)file.getName()));
                }
            }
            return;
        }
        if (stringArray[1].equalsIgnoreCase("current")) {
            if (T.3 == T.0) {
                8t_0.0("Currently selected config: (h)default", new Object[0]);
            } else {
                8t_0.0("Currently selected config: (h)%s", Files.getNameWithoutExtension((String)T.3.getName()));
            }
            return;
        }
        if (stringArray.length == 2) {
            8t_0.1(this.0(), new Object[0]);
            return;
        }
        File file = new File(T.1, stringArray[2] + ".json");
        boolean bl = stringArray[2].equalsIgnoreCase("default");
        if (bl) {
            file = T.0;
        }
        switch (stringArray[1].toLowerCase()) {
            case "create": {
                if (file.exists()) {
                    8t_0.1("Config (h)%s(r) already exists!", bl ? "default" : stringArray[2]);
                    return;
                }
                T.0(T.3);
                T.0(file);
                T.c(file, false);
                8t_0.0("Created Config (h)%s", bl ? "default" : stringArray[2]);
                break;
            }
            case "save": {
                if (!file.exists()) {
                    8t_0.1("Config (h)%s(r) doesn't exist!", bl ? "default" : stringArray[2]);
                    return;
                }
                T.0(file);
                8t_0.0("Saved Config (h)%s", bl ? "default" : stringArray[2]);
                break;
            }
            case "load": {
                if (!file.exists()) {
                    Object[] objectArray = new Object[1];
                    objectArray[0] = bl ? "default" : stringArray[2];
                    8t_0.1("Config (h)%s(r) doesn't exist!", objectArray);
                    return;
                }
                T.0(T.3);
                T.c(file, false);
                8t_0.0("Loaded Config (h)%s", bl ? "default" : stringArray[2]);
                break;
            }
            case "forceload": {
                if (!file.exists()) {
                    8t_0.1("Config (h)%s(r) doesn't exist!", bl ? "default" : stringArray[2]);
                    return;
                }
                T.c(file, false);
                8t_0.0("Forceloaded Config (h)%s", bl ? "default" : stringArray[2]);
                break;
            }
            case "delete": {
                if (bl) {
                    8t_0.1("You can't delete the (h)Default(r) Config", new Object[0]);
                    return;
                }
                if (!file.exists()) {
                    8t_0.1("Config (h)%s(r) doesn't exist!", stringArray[2]);
                    return;
                }
                if (T.2(file)) {
                    8t_0.0("Deleted Config (h)%s", stringArray[2]);
                    break;
                }
                8t_0.1("Couldn't delete Config (h)%s", stringArray[2]);
                break;
            }
            default: {
                8t_0.1(this.0(), new Object[0]);
                break;
            }
        }
    }

    public d() {
        super("config", "Load different configs", new SyntaxChunk("<create/save/load/forceload/delete/list/current>"), new SyntaxChunk("<name/default>"));
    }
}

