/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.mixin.mixins.ICPacketChatMessage;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.server.SPacketChat;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 66
extends 3E {
    public String 2;
    public boolean 1;
    public boolean 2;

    @Subscriber
    public void c(0T t) {
        block2: {
            if (66.c.world == null || 66.c.player == null) {
                return;
            }
            if (!(t.c() instanceof CPacketChatMessage)) break block2;
            CPacketChatMessage cPacketChatMessage = (CPacketChatMessage)t.c();
            String string = cPacketChatMessage.getMessage();
            if (this.2 != null && this.1 && string.split(" ")[0].equalsIgnoreCase("/r") && this.2) {
                ((ICPacketChatMessage)cPacketChatMessage).setMessage("/msg " + this.2 + " " + string.substring(3));
            }
        }
    }

    @Subscriber
    public void c(0S s) {
        String string;
        if (66.c.world == null || 66.c.player == null) {
            return;
        }
        if (s.c() instanceof SPacketChat && (string = ((SPacketChat)s.c()).getChatComponent().getUnformattedText()).contains("whispers: ")) {
            if (66.c.ingameGUI.getChatGUI().getChatOpen() && this.1) {
                this.2 = true;
            } else {
                this.2 = string.split(" ")[0];
                this.1 = true;
            }
        }
    }

    public 66() {
        super("SmartWhisper", 3D.3, "SmartReply");
    }
}

