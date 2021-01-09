/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.Random;
import me.darki.konas.0I;
import me.darki.konas.0S;
import me.darki.konas.1E;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.5w
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5w_0
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("GG", true);
    public static 8h_0<Boolean> 2 = new 8h_0("EZ", false);
    public static 8h_0<Boolean> 3 = new 8h_0("Log", false);
    public static 8h_0<Boolean> 4 = new 8h_0("Excuses", false);
    public static 8h_0<Boolean> 5 = new 8h_0("Pops", false);
    public static ArrayList<String> 0 = new ArrayList();
    public static ArrayList<String> 1;
    public static ArrayList<String> 2;
    public static ArrayList<String> 3;
    public static ArrayList<String> 4;
    public Random c;
    public 9m c = new 9m();

    public 5w_0() {
        super("AutoGG", 3D.3, new String[0]);
        0.add("Good fight! Konas owns me and all \u2022\u1d17\u2022");
        ((ArrayList)((Object)1)).add("you just got nae nae'd by konas <player>!");
        ((ArrayList)((Object)1)).add("<player> tango down");
        ((ArrayList)((Object)1)).add("<player> you just felt the wrath of konas client");
        ((ArrayList)((Object)1)).add("I guess konas ca is too fast for you <player>!");
        ((ArrayList)((Object)1)).add("<player> konas ca is too fast!");
        ((ArrayList)((Object)1)).add("you just got ez'd by konas client <player>");
        ((ArrayList)((Object)2)).add("keep popping <player>");
        ((ArrayList)((Object)2)).add("ez pop <player>");
        ((ArrayList)((Object)3)).add("ez log <player>");
        ((ArrayList)((Object)3)).add("I just made <player> log with the power of Konas!");
        ((ArrayList)((Object)4)).add("You're such a ping player!");
        ((ArrayList)((Object)4)).add("Photoshop! Konas users can never die.");
        ((ArrayList)((Object)4)).add("I was AFK!");
        ((ArrayList)((Object)4)).add("I bet you wet yourself while killing me! Stupid bedwetter...");
    }

    public void c(EntityPlayer entityPlayer) {
        ((Minecraft)5w_0.c).player.sendChatMessage(((String)((ArrayList)((Object)1)).get(this.c.nextInt(((ArrayList)((Object)1)).size()))).replaceAll("<player>", entityPlayer.getName()));
    }

    @Subscriber
    public void c(0I i2) {
        block0: {
            if (!(i2.c() instanceof GuiGameOver) || !((Boolean)4.6()).booleanValue() || !this.c.c(2000.0)) break block0;
            this.0();
            this.c.c();
        }
    }

    public void 1(EntityPlayer entityPlayer) {
        ((Minecraft)5w_0.c).player.sendChatMessage(0.get(this.c.nextInt(0.size())).replaceAll("<player>", entityPlayer.getName()));
    }

    static {
        1 = new ArrayList();
        2 = new ArrayList();
        3 = new ArrayList();
        4 = new ArrayList();
    }

    public void 2(EntityPlayer entityPlayer) {
        ((Minecraft)5w_0.c).player.sendChatMessage(((String)((ArrayList)((Object)3)).get(this.c.nextInt(((ArrayList)((Object)3)).size()))).replaceAll("<player>", entityPlayer.getName()));
    }

    @Subscriber
    public void 0(0S s) {
        SPacketPlayerListItem sPacketPlayerListItem;
        if (((Minecraft)5w_0.c).player == null || ((Minecraft)5w_0.c).world == null) {
            return;
        }
        if (s.c() instanceof SPacketPlayerListItem && (sPacketPlayerListItem = (SPacketPlayerListItem)s.c()).getAction() == SPacketPlayerListItem.Action.REMOVE_PLAYER) {
            for (SPacketPlayerListItem.AddPlayerData addPlayerData : sPacketPlayerListItem.getEntries()) {
                EntityPlayer entityPlayer = ((Minecraft)5w_0.c).world.getPlayerEntityByUUID(addPlayerData.getProfile().getId());
                if (entityPlayer == null || !((Boolean)3.6()).booleanValue() || 5w_0.c.player.ticksExisted <= 100 || !8k_0.c.c.c((Entity)entityPlayer)) continue;
                this.2(entityPlayer);
            }
        }
    }

    @Subscriber
    public void c(1E e2) {
        block1: {
            if (((Boolean)1.6()).booleanValue()) {
                this.1(e2.c());
                return;
            }
            if (!((Boolean)2.6()).booleanValue()) break block1;
            this.c(e2.c());
        }
    }

    public void 0() {
        ((Minecraft)5w_0.c).player.sendChatMessage((String)((ArrayList)((Object)4)).get(this.c.nextInt(((ArrayList)((Object)4)).size())));
    }

    public void 0(EntityPlayer entityPlayer) {
        ((Minecraft)5w_0.c).player.sendChatMessage(((String)((ArrayList)((Object)2)).get(this.c.nextInt(((ArrayList)((Object)2)).size()))).replaceAll("<player>", entityPlayer.getName()));
    }

    @Subscriber
    public void c(0S s) {
        block0: {
            EntityPlayer entityPlayer;
            Entity entity;
            SPacketEntityStatus sPacketEntityStatus;
            if (!(s.c() instanceof SPacketEntityStatus) || (sPacketEntityStatus = (SPacketEntityStatus)s.c()).getOpCode() != 35 || !((entity = sPacketEntityStatus.getEntity((World)((Minecraft)5w_0.c).world)) instanceof EntityPlayer) || !8k_0.c.c.c((Entity)(entityPlayer = (EntityPlayer)entity)) || !((Boolean)5.6()).booleanValue()) break block0;
            this.0(entityPlayer);
        }
    }
}

