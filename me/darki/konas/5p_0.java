/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.network.play.server.SPacketChat;

/*
 * Renamed from me.darki.konas.5p
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5p_0
extends 3E {
    public static String[] c = new String[]{"discord.gg"};
    public static String[] 0 = new String[]{".com", ".ru", ".net", ".in", ".ir", ".au", ".uk", ".de", ".br", ".xyz", ".org", ".co", ".cc", ".me", ".tk", ".us", ".bar", ".gq", ".nl", ".space"};
    public static String[] 1 = new String[]{"Looking for new anarchy servers?", "I just walked", "I just flew", "I just placed", "I just ate", "I just healed", "I just took", "I just spotted", "I walked", "I flew", "I walked", "I flew", "I placed", "I ate", "I healed", "I took", "I gained", "I mined", "I lost", "I moved"};
    public static 8h_0<Boolean> 1;
    public static 8h_0<Boolean> 2;
    public static 8h_0<Boolean> 3;

    public boolean c(String string) {
        if (((Boolean)1.6()).booleanValue()) {
            for (String string2 : c) {
                if (!string.contains(string2)) continue;
                return true;
            }
        }
        if (((Boolean)3.6()).booleanValue()) {
            for (String string2 : 1) {
                if (!string.contains(string2)) continue;
                return true;
            }
        }
        if (((Boolean)2.6()).booleanValue()) {
            for (String string2 : 0) {
                if (!string.contains(string2)) continue;
                return true;
            }
        }
        return false;
    }

    static {
        1 = new 8h_0("Discord Invites", true);
        2 = new 8h_0("Domains", false);
        3 = new 8h_0("Announcer", true);
    }

    @Subscriber
    public void c(0S s) {
        block2: {
            if (5p_0.c.world == null || 5p_0.c.player == null) {
                return;
            }
            if (!(s.c() instanceof SPacketChat)) {
                return;
            }
            SPacketChat sPacketChat = (SPacketChat)s.c();
            if (!this.c(sPacketChat.getChatComponent().getUnformattedText())) break block2;
            s.c(true);
        }
    }

    public 5p_0() {
        super("AntiSpam", 3D.3, "NoSpam", "NoLinks");
    }
}

