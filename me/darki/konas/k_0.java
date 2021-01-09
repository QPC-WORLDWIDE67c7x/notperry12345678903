/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import java.util.regex.Pattern;
import me.darki.konas.09;
import me.darki.konas.2;
import me.darki.konas.3F;
import me.darki.konas.5J;
import me.darki.konas.6;
import me.darki.konas.8H;
import me.darki.konas.8J;
import me.darki.konas.8S;
import me.darki.konas.8p_0;
import me.darki.konas.j_0;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

/*
 * Renamed from me.darki.konas.k
 */
public class k_0
extends 2 {
    public static void c(StringBuilder stringBuilder, 8H h2) {
        stringBuilder.append(h2.0() + "\n");
    }

    public k_0() {
        super("friend", "Add and remove friends", new j_0("<add/del/list>"), new 6("[name]"));
    }

    @Override
    public void c(String[] stringArray) {
        block19: {
            block18: {
                if (stringArray.length == 2) {
                    if (stringArray[1].equalsIgnoreCase("list")) {
                        if (!8J.c().isEmpty()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("\n");
                            8J.c().stream().forEach(arg_0 -> k_0.c(stringBuilder, arg_0));
                            8p_0.1(stringBuilder.toString());
                        } else {
                            8p_0.1("You dont have any friends :(");
                        }
                    } else {
                        8p_0.c("Invalid Argument. Check syntax");
                    }
                    return;
                }
                if (stringArray.length != this.2().size() + 1) {
                    8p_0.1(this.0());
                    return;
                }
                if (!stringArray[1].equalsIgnoreCase("add")) break block18;
                if (stringArray[2].equalsIgnoreCase(k_0.c.player.getName())) {
                    8p_0.c("You cant add yourself as a friend");
                    return;
                }
                if (stringArray[2].equalsIgnoreCase("subaru")) {
                    8p_0.c("Downloading subaruhack...");
                    return;
                }
                stringArray[2] = stringArray[2].replaceAll(String.valueOf(Pattern.compile("[^a-zA-Z0-9_]{1,16}")), "");
                if (Minecraft.getMinecraft().world.getPlayerEntityByName(stringArray[2]) != null) {
                    if (8J.1(stringArray[2])) {
                        8p_0.1(stringArray[2] + " is already your friend!");
                        return;
                    }
                    EntityPlayer entityPlayer = Minecraft.getMinecraft().world.getPlayerEntityByName(stringArray[2]);
                    8J.c(entityPlayer.getName(), entityPlayer.getUniqueID().toString().replace("-", ""));
                    if (3F.c(5J.class).f() && ((Boolean)5J.e.6()).booleanValue()) {
                        EventDispatcher.Companion.dispatch(new 09(stringArray[2], "I just friended you on Konas!"));
                    }
                    8p_0.1("Added &b" + stringArray[2] + "&f as friend");
                } else if (8S.4(stringArray[2]) != null) {
                    if (8J.1(stringArray[2])) {
                        8p_0.1(stringArray[2] + " is already your friend!");
                        return;
                    }
                    8J.c(8S.c(8S.4(stringArray[2])), 8S.4(stringArray[2]));
                    if (3F.c(5J.class).f() && ((Boolean)5J.e.6()).booleanValue()) {
                        EventDispatcher.Companion.dispatch(new 09(stringArray[2], "I just friended you on Konas!"));
                    }
                    8p_0.1("Added &b" + 8S.c(8S.4(stringArray[2])) + "&f as friend");
                } else {
                    8p_0.c("Player not found");
                }
                break block19;
            }
            if (!stringArray[1].equalsIgnoreCase("del")) break block19;
            stringArray[2] = stringArray[2].replaceAll(String.valueOf(Pattern.compile("[^a-zA-Z0-9_]{1,16}")), "");
            if (8J.1(stringArray[2])) {
                8J.0(stringArray[2]);
                8p_0.1("Removed &b" + stringArray[2] + "&f as friend");
            } else {
                8p_0.c("Player not found");
            }
        }
    }
}

