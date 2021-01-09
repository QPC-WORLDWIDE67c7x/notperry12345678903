/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.mojang.realmsclient.gui.ChatFormatting;
import cookiedragon.eventsystem.EventDispatcher;
import cookiedragon.eventsystem.Subscriber;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import me.darki.konas.02;
import me.darki.konas.03;
import me.darki.konas.09;
import me.darki.konas.0p_0;
import me.darki.konas.1F;
import me.darki.konas.1N;
import me.darki.konas.2;
import me.darki.konas.20;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5H;
import me.darki.konas.5R;
import me.darki.konas.8J;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8t_0;
import me.darki.konas.b_0;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5J
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("Delay", Float.valueOf(0.5f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(1.0f));
    public static 8h_0<5H> 2 = new 8h_0("Mode", 5H.c);
    public static 8h_0<Boolean> 3 = new 8h_0("AutoBackup", false);
    public static 8h_0<Boolean> 4 = new 8h_0("Global", false).c(3::6);
    public 8h_0<Boolean> 5 = new 8h_0("PopBackup", true).c(3::6);
    public 8h_0<Boolean> 6 = new 8h_0("Taunt", false);
    public 8h_0<Boolean> 7 = new 8h_0("AntiRacism", false);
    public 8h_0<Boolean> 8 = new 8h_0("AntiCoordLeak", false);
    public 8h_0<Boolean> 9 = new 8h_0("Embarrass", false).c(this.7::6);
    public 8h_0<Boolean> a = new 8h_0("AutoGroom", false);
    public 8h_0<Float> b = new 8h_0("TauntDelay", Float.valueOf(15.0f), Float.valueOf(30.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)).c(this.6::6);
    public 8h_0<Float> d = new 8h_0("GroomDelay", Float.valueOf(15.0f), Float.valueOf(30.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)).c(this.a::6);
    public static 8h_0<Boolean> e = new 8h_0("NotifyFriended", false);
    public 8h_0<Boolean> f = new 8h_0("PartyChat", false);
    public 8h_0<Boolean> g = new 8h_0("Longer", false);
    public 8h_0<Integer> h = new 8h_0("ChatHeight", 200, 500, 0, 0).c(this.g::6);
    public 8h_0<Boolean> i = new 8h_0("Clear", false);
    public 8h_0<Boolean> j = new 8h_0("ChatTimestamps", true);
    public 8h_0<Boolean> k = new 8h_0("24HourFormat", true).c(this.j::6);
    public 8h_0<Boolean> l = new 8h_0("Hours", true).c(this.j::6);
    public 8h_0<Boolean> m;
    public 8h_0<Boolean> n;
    public 8h_0<Boolean> o;
    public Random c;
    public static ArrayList<String> 0 = new ArrayList();
    public static ArrayList<String> 1;

    @Subscriber
    public void c(ClientChatReceivedEvent clientChatReceivedEvent) {
        block7: {
            09 var3_3;
            Object object;
            if (((Boolean)this.7.6()).booleanValue() && (clientChatReceivedEvent.getMessage().getUnformattedText().toLowerCase().contains("nigger") || clientChatReceivedEvent.getMessage().getUnformattedText().toLowerCase().contains("nigga")) && ((Optional)(object = 5R.3(clientChatReceivedEvent.getMessage().getUnformattedText()))).isPresent()) {
                if (((Boolean)this.9.6()).booleanValue()) {
                    ((Minecraft)5J.c).player.sendChatMessage((String)((Map.Entry)((Optional)object).get()).getKey() + ", don't be racist");
                } else {
                    var3_3 = new 09((String)((Map.Entry)((Optional)object).get()).getKey(), "Don't be racist");
                    EventDispatcher.Companion.dispatch(var3_3);
                }
            }
            if (!((Boolean)this.j.6()).booleanValue()) break block7;
            object = new StringBuilder();
            if (((Boolean)this.o.6()).booleanValue()) {
                ((StringBuilder)object).append("<");
            }
            if (((Boolean)this.l.6()).booleanValue()) {
                ((StringBuilder)object).append((Boolean)this.k.6() != false ? "HH" : "hh").append((Boolean)this.m.6() != false || (Boolean)this.n.6() != false ? ":" : "");
            }
            if (((Boolean)this.m.6()).booleanValue()) {
                ((StringBuilder)object).append("mm").append((Boolean)this.n.6() != false ? ":" : "");
            }
            if (((Boolean)this.n.6()).booleanValue()) {
                ((StringBuilder)object).append("ss");
            }
            ((StringBuilder)object).append((Boolean)this.k.6() != false ? "" : "aa").append((Boolean)this.o.6() != false ? "> " : " ");
            var3_3 = new TextComponentString(ChatFormatting.GRAY + new SimpleDateFormat(((StringBuilder)object).toString()).format(new Date()) + ChatFormatting.RESET);
            var3_3.appendSibling(clientChatReceivedEvent.getMessage());
            clientChatReceivedEvent.setMessage((ITextComponent)var3_3);
        }
    }

    @Subscriber
    public void c(02 var1_1) {
        if (((Boolean)this.8.6()).booleanValue() && var1_1.c().replaceAll("\\D", "").length() >= 6) {
            var1_1.c();
            8t_0.1("AntiCoordLeak: Blocked message because it contained 6 or more digits", new Object[0]);
            return;
        }
        if (((Boolean)this.f.6()).booleanValue() && !var1_1.c().startsWith(me.darki.konas.2.1()) && !var1_1.c().startsWith("/")) {
            var1_1.c();
            for (String string : b_0.0) {
                09 var4_4 = new 09(string, var1_1.c());
                EventDispatcher.Companion.dispatch(var4_4);
            }
        }
    }

    @Subscriber
    public void c(1N n2) {
        09 var3_3;
        Entity entity;
        if (((Minecraft)5J.c).player == null || ((Minecraft)5J.c).world == null) {
            return;
        }
        if (((Boolean)this.a.6()).booleanValue() && 20.c.isEmpty() && 20.c.c(((Float)this.d.6()).floatValue() * 1000.0f) && (entity = 8k_0.c.c.2()) != null && !8J.1(entity.getName())) {
            var3_3 = new 09(entity.getName(), ((String)((ArrayList)((Object)1)).get(this.c.nextInt(((ArrayList)((Object)1)).size()))).replaceAll("<player>", entity.getName()));
            EventDispatcher.Companion.dispatch(var3_3);
        }
        if (((Boolean)this.6.6()).booleanValue() && 20.c.isEmpty() && 20.c.c(((Float)this.b.6()).floatValue() * 1000.0f) && (entity = 8k_0.c.c.2()) != null) {
            if (!8J.1(entity.getName())) {
                var3_3 = new 09(entity.getName(), 0.get(this.c.nextInt(0.size())).replaceAll("<player>", entity.getName()));
                EventDispatcher.Companion.dispatch(var3_3);
            }
        }
    }

    public 5J() {
        super("ExtraChat", 3D.3, "ChatTimestamp", "ChatTimestamps", "ClearChat");
        8h_0 h_02 = new 8h_0("Minutes", true);
        8h_0<Boolean> h_03 = this.j;
        h_03.getClass();
        this.m = h_02.c(h_03::6);
        this.n = new 8h_0("Seconds", false).c(this.j::6);
        this.o = new 8h_0("Brackets", true).c(this.j::6);
        this.c = new Random();
        0.add("Lol, you're so ez <player>");
        0.add("ur bad");
        0.add("ur fat");
        0.add("you're dogwater kid");
        0.add("im going to destroy you");
        0.add("you like men");
        ((ArrayList)((Object)1)).add("Send thigh pics");
        ((ArrayList)((Object)1)).add("Are you a femboy?");
        ((ArrayList)((Object)1)).add("Where do you live?");
        ((ArrayList)((Object)1)).add("How old are you?");
        ((ArrayList)((Object)1)).add("Let's have sex");
        ((ArrayList)((Object)1)).add("Send skirt pics");
        ((ArrayList)((Object)1)).add("I'll get you nitro if you send thigh pics");
        ((ArrayList)((Object)1)).add("Hewwo cutie");
        ((ArrayList)((Object)1)).add("AwA Let's have sex");
    }

    @Subscriber
    public void c(0p_0 p_02) {
        block0: {
            if (!((Boolean)this.g.6()).booleanValue()) break block0;
            p_02.c((Integer)this.h.6());
        }
    }

    static {
        1 = new ArrayList();
    }

    @Subscriber
    public void c(1F f2) {
        if (((Boolean)3.6()).booleanValue() && ((Boolean)this.5.6()).booleanValue() && f2.c().getUniqueID().equals(((Minecraft)5J.c).player.getUniqueID())) {
            String string = "I just popped at X:" + ((Minecraft)5J.c).player.getPosition().getX() + " Y:" + ((Minecraft)5J.c).player.getPosition().getY() + " Z:" + ((Minecraft)5J.c).player.getPosition().getZ() + " in the " + (5J.c.player.dimension == -1 ? "Nether" : "Overworld") + ", and I need backup!";
            if (((Boolean)4.6()).booleanValue()) {
                ((Minecraft)5J.c).player.sendChatMessage(string);
            } else {
                for (String string2 : b_0.0) {
                    09 var5_5 = new 09(string2, string);
                    EventDispatcher.Companion.dispatch(var5_5);
                }
            }
        }
    }

    @Subscriber
    public void c(03 var1_1) {
        block0: {
            if (!((Boolean)this.i.6()).booleanValue()) break block0;
            var1_1.c();
        }
    }
}

