/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;
import me.darki.konas.02;
import me.darki.konas.2;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5G;
import me.darki.konas.8p_0;
import me.darki.konas.9o;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 68
extends 3E {
    public static ReentrantLock c = new ReentrantLock();
    public boolean 1 = false;
    public static String 2 = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void c(String[] stringArray, String[] stringArray2) {
        try {
            ArrayList<String> arrayList;
            c.lock();
            arrayList();
            ArrayList<String> arrayList2 = arrayList;
            for (String string : stringArray) {
                arrayList2.add(9o.0(string));
            }
            stringArray2[0] = arrayList2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            8p_0.1("Couldnt find Input Language");
        }
        finally {
            c.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void c(String[] stringArray, String string, String[] stringArray2, String string2) {
        try {
            c.lock();
            stringArray[0] = 9o.c(string, stringArray2[0], string2);
            if (!stringArray[0].equals("")) {
                this.1 = true;
                ((Minecraft)68.c).player.sendChatMessage(stringArray[0]);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            8p_0.1("Couldn't translate message");
        }
        finally {
            c.unlock();
        }
    }

    public 68() {
        super("Translate", "Translate your chat message into any language", 3D.3, new String[0]);
    }

    @Subscriber
    public void c(02 var1_1) {
        Thread thread;
        Thread thread2;
        String string = var1_1.c();
        if (string.startsWith("/") || string.startsWith(me.darki.konas.2.1())) {
            return;
        }
        if (this.1) {
            var1_1.c();
            this.1 = false;
        }
        if (string.endsWith(5G.2)) {
            string = string.substring(0, string.length() - 5G.2.length());
        }
        String[] stringArray = string.split(" ");
        String[] stringArray2 = new String[]{null};
        Thread thread3 = thread2;
        Thread thread4 = thread2;
        Runnable runnable = () -> 68.c(stringArray, stringArray2);
        thread3(runnable);
        try {
            thread4.start();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        String[] stringArray3 = new String[]{""};
        String string2 = 2;
        String string3 = string;
        Thread thread5 = thread;
        Thread thread6 = thread;
        Runnable runnable2 = () -> this.c(stringArray3, string3, stringArray2, string2);
        thread5(runnable2);
        try {
            thread6.start();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void c() {
        block0: {
            if (2 != null) break block0;
            8p_0.c("Target language is null, please use the " + me.darki.konas.2.1() + "language command to set your target language!");
            this.d();
        }
    }
}

