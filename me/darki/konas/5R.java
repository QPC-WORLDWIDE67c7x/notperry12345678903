/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.darki.konas.0S;
import me.darki.konas.1N;
import me.darki.konas.2;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.5G;
import me.darki.konas.5O;
import me.darki.konas.5P;
import me.darki.konas.5Q;
import me.darki.konas.8S;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;
import me.darki.konas.8o_0;
import me.darki.konas.8p_0;
import me.darki.konas.8w_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IChatLine;
import me.darki.konas.mixin.mixins.IGuiNewChat;
import me.darki.konas.mixin.mixins.ISPacketChat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ClientChatEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5R
extends 3E {
    public 9m c;
    public static boolean 1 = true;
    public Socket c;
    public DataInputStream c;
    public DataOutputStream c;
    public String 2;
    public 8e_0<5Q> c;
    public 8h_0<Boolean> 1;
    public String 3 = "kcr";
    public ConcurrentHashMap<String, String> c;

    public void 2(String string) {
        if (this.c == null) {
            return;
        }
        DataOutputStream dataOutputStream = this.c;
        String string2 = "MESSAGE";
        dataOutputStream.writeUTF(string2);
        DataOutputStream dataOutputStream2 = this.c;
        String string3 = string;
        dataOutputStream2.writeUTF(string3);
        DataOutputStream dataOutputStream3 = this.c;
        try {
            dataOutputStream3.flush();
        }
        catch (IOException iOException) {
            System.err.println("Sending message failed");
        }
    }

    public static Optional<Map.Entry<String, String>> 3(String string) {
        Matcher matcher = Pattern.compile("^<([a-zA-Z0-9_]{3,16})> (.+)$").matcher(string);
        String string2 = null;
        String string3 = null;
        while (matcher.find()) {
            string2 = matcher.group(1);
            string3 = matcher.group(2);
        }
        if (string2 == null || string2.isEmpty()) {
            return Optional.empty();
        }
        if (string3 == null || string3.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new AbstractMap.SimpleEntry<String, String>(string2, string3));
    }

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)5R.c).player == null || ((Minecraft)5R.c).world == null) {
            return;
        }
        if (3F.c(5G.class).f()) {
            3F.c(5G.class).1(false);
        }
        ArrayList<ChatLine> arrayList = new ArrayList<ChatLine>(((IGuiNewChat)((Minecraft)5R.c).ingameGUI.getChatGUI()).getDrawnChatLines());
        for (ChatLine chatLine : arrayList) {
            for (Map.Entry entry : ((ConcurrentHashMap)((Object)this.c)).entrySet()) {
                String string = (String)entry.getKey();
                String string2 = (String)entry.getValue();
                if (!chatLine.getChatComponent().getUnformattedText().contains(string2)) continue;
                ((IChatLine)chatLine).setLineString((ITextComponent)new 8o_0(me.darki.konas.2.c + "bKonasChat:" + me.darki.konas.2.c + "r " + chatLine.getChatComponent().getFormattedText().replace(string2, string)));
                ((ConcurrentHashMap)((Object)this.c)).remove(string);
            }
        }
        ((IGuiNewChat)((Minecraft)5R.c).ingameGUI.getChatGUI()).setDrawnChatLines(arrayList);
    }

    @Override
    public void 7() {
        this.0();
    }

    @Subscriber
    public void c(ClientChatEvent clientChatEvent) {
        String string;
        block7: {
            block6: {
                string = clientChatEvent.getMessage();
                if (string.startsWith("/") || string.startsWith(me.darki.konas.2.1())) break block6;
                if (((Boolean)this.1.6()).booleanValue()) break block7;
            }
            return;
        }
        switch (5O.c[((5Q)((Object)((8h_0)((Object)this.c)).6())).ordinal()]) {
            case 1: {
                String string2 = "kcr" + this.c(string);
                ((ConcurrentHashMap)((Object)this.c)).put(string, string2);
                clientChatEvent.setMessage(string2);
                break;
            }
            case 2: {
                this.2(string);
                clientChatEvent.setCanceled(true);
                break;
            }
        }
    }

    public String c(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 >= 'a' && c2 <= 'm') {
                c2 = (char)(c2 + 13);
            } else if (c2 >= 'A' && c2 <= 'M') {
                c2 = (char)(c2 + 13);
            } else if (c2 >= 'n' && c2 <= 'z') {
                c2 = (char)(c2 - 13);
            } else if (c2 >= 'N' && c2 <= 'Z') {
                c2 = (char)(c2 - 13);
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public void 1() {
        block43: {
            5P p2;
            5P p3;
            DataOutputStream dataOutputStream;
            DataInputStream dataInputStream;
            Socket socket;
            block42: {
                block41: {
                    boolean bl = 8w_0.c();
                    if (bl) break block41;
                    String string = "Please log in to use Konas Chat";
                    8p_0.c(string);
                    return;
                }
                if (this.c == null) break block42;
                Socket socket2 = this.c;
                socket2.close();
            }
            5R r = this;
            Socket socket3 = socket;
            Socket socket4 = socket;
            String string = "auth.konasclient.com";
            int n2 = 21122;
            socket3(string, n2);
            r.c = socket4;
            5R r2 = this;
            DataInputStream dataInputStream2 = dataInputStream;
            DataInputStream dataInputStream3 = dataInputStream;
            Socket socket5 = this.c;
            InputStream inputStream = socket5.getInputStream();
            dataInputStream2(inputStream);
            r2.c = dataInputStream3;
            5R r3 = this;
            DataOutputStream dataOutputStream2 = dataOutputStream;
            DataOutputStream dataOutputStream3 = dataOutputStream;
            Socket socket6 = this.c;
            OutputStream outputStream = socket6.getOutputStream();
            dataOutputStream2(outputStream);
            r3.c = dataOutputStream3;
            5P p4 = p3;
            5P p5 = p3;
            Socket socket7 = this.c;
            DataInputStream dataInputStream4 = this.c;
            p4(socket7, dataInputStream4);
            5P p6 = p2 = p5;
            p6.start();
            DataOutputStream dataOutputStream4 = this.c;
            String string2 = "CONNECT";
            dataOutputStream4.writeUTF(string2);
            DataOutputStream dataOutputStream5 = this.c;
            String string3 = this.2;
            dataOutputStream5.writeUTF(string3);
            if (this.c != null) break block43;
            String string4 = "Couldn't authenticate with Chat Server, please restart your client!";
            8p_0.c(string4);
            return;
        }
        DataOutputStream dataOutputStream = this.c;
        EntityPlayerSP entityPlayerSP = ((Minecraft)5R.c).player;
        String string = entityPlayerSP.getName();
        dataOutputStream.writeUTF(string);
        DataOutputStream dataOutputStream6 = this.c;
        try {
            dataOutputStream6.flush();
        }
        catch (IOException iOException) {
            System.err.println("Couldn't connect to Chat Server");
        }
    }

    public 5R() {
        super("KonasChat", "Encrypt chat messages among Konas Users", 3D.3, new String[0]);
        this.c = new 9m();
        this.2 = null;
        this.c = new 8e_0("Mode", 5Q.c, this::c);
        this.1 = new 8h_0("Encrypt", true);
        this.3 = "kcr";
        this.c = new ConcurrentHashMap();
    }

    @Subscriber
    public void c(0S s) {
        block0: {
            Map.Entry<String, String> entry;
            Optional<Map.Entry<String, String>> optional;
            if (!(s.c() instanceof SPacketChat) || !(optional = 5R.3(((SPacketChat)s.c()).getChatComponent().getUnformattedText())).isPresent() || !(entry = optional.get()).getValue().startsWith("kcr")) break block0;
            String string = this.c(entry.getValue().substring("kcr".length()));
            ((ISPacketChat)s.c()).setChatComponent((ITextComponent)new 8o_0(me.darki.konas.2.c + "bKonasChat: " + me.darki.konas.2.c + "f<" + entry.getKey() + "> " + me.darki.konas.2.c + "r" + string));
        }
    }

    public void c(5Q q) {
        if (q == 5Q.0) {
            if (!1 && !this.c.c(10000.0)) {
                8p_0.1("Please wait another " + Math.abs((System.currentTimeMillis() - this.c.0()) / 1000L - 10L) + " seconds, before you enable this setting again!");
                ((8e_0)((Object)this.c)).c();
            } else {
                if (this.2 == null) {
                    this.2 = 8S.2();
                }
                this.1();
                this.c.c();
            }
        } else {
            this.0();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void c() {
        if (this.2 == null) {
            this.2 = 8S.2();
        }
        if (((8h_0)((Object)this.c)).6() != 5Q.0) return;
        if (!1 && !this.c.c(10000.0)) {
            8p_0.1("Please wait another " + Math.abs((System.currentTimeMillis() - this.c.0()) / 1000L - 10L) + " seconds, before you enable this module again!");
            this.d();
            return;
        }
        this.1();
        this.c.c();
    }

    public void 0() {
        block4: {
            if (this.c == null) break block4;
            Socket socket = this.c;
            socket.close();
        }
        try {
            this.c = null;
            this.c = null;
            this.c = null;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

