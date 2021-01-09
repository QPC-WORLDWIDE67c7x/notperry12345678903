/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.Random;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.8i_0;
import me.darki.konas.8p_0;
import me.darki.konas.9m;
import me.darki.konas.T;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 67
extends 3E {
    public 8h_0<Float> 1 = new 8h_0("Delay", Float.valueOf(5.0f), Float.valueOf(20.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<8i_0> 2 = new 8h_0("SpamFileList", new 8i_0());
    public 8h_0<Boolean> 3 = new 8h_0("Random", true);
    public 8h_0<Boolean> 4 = new 8h_0("AntiAntiSpam", false);
    public 9m c = new 9m();
    public static ArrayList<String> 0 = new ArrayList();
    public static int 1 = 0;
    public static ArrayList<Integer> 1;
    public static int 2;

    @Override
    public void c() {
        if (((Minecraft)67.c).player == null || ((Minecraft)67.c).world == null) {
            return;
        }
        this.0();
        2 = 0;
        1 = 0;
        ((ArrayList)((Object)1)).clear();
    }

    @Subscriber
    public void c(1N n2) {
        block8: {
            String string;
            if (((Minecraft)67.c).player == null || ((Minecraft)67.c).world == null) {
                return;
            }
            if (!this.c.c(((Float)this.1.6()).floatValue() * 1000.0f)) break block8;
            if (0.isEmpty()) {
                this.0();
                8p_0.c("Caution: Spammer file '" + ((8i_0)2.6()).c().get(1) + "' is empty!");
                this.c.c();
                return;
            }
            if (((Boolean)this.3.6()).booleanValue()) {
                if (((ArrayList)((Object)1)).size() == 0.size()) {
                    this.0();
                    (++1).clear();
                    return;
                }
                int n3 = new Random().nextInt(0.size());
                while (((ArrayList)((Object)1)).contains(n3)) {
                    n3 = new Random().nextInt(0.size());
                }
                ((ArrayList)((Object)1)).add(n3);
                string = 0.get(n3);
            } else {
                if (2 == 0.size()) {
                    this.0();
                    ++1;
                    2 = 0;
                }
                string = 0.get(2);
                ++2;
            }
            if (((Boolean)this.4.6()).booleanValue()) {
                string = string + " " + new Random().nextInt(69420);
            }
            ((Minecraft)67.c).player.sendChatMessage(string);
            this.c.c();
        }
    }

    public void 0() {
        if (((8i_0)2.6()).c().size() == 0) {
            8p_0.c("You don't have any Spammer Files loaded. Load some with the Spammer Command");
            this.d();
            return;
        }
        if (1 >= ((8i_0)2.6()).c().size()) {
            1 = 0;
        }
        T.c(((8i_0)2.6()).c().get(1), true);
    }

    public 67() {
        super("Spammer", 3D.3, new String[0]);
    }

    static {
        1 = new ArrayList();
        2 = 0;
    }
}

