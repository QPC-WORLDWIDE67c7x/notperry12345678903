/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import me.darki.konas.0I;
import me.darki.konas.0S;
import me.darki.konas.1E;
import me.darki.konas.1N;
import me.darki.konas.1T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3R;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3S
extends 3E {
    public TrayIcon c;
    public SystemTray c;
    public int 1;
    public 8h_0<Boolean> 1 = (int)new 8h_0("Modules", true);
    public 8h_0<Boolean> 2 = new 8h_0("2b2tKick", false);
    public 8e_0<Boolean> c;
    public 8h_0<Boolean> 3;
    public 8h_0<Boolean> 4;
    public 8h_0<Boolean> 5;
    public 8h_0<Boolean> 6;
    public 8h_0<Boolean> 7;
    public 8e_0<Boolean> 0;
    public ArrayList<Entity> 0;
    public 9m c;
    public HashMap<Long, Boolean> c = new 8e_0("KillStreak", false, this::c);

    @Subscriber
    public void 1(1N n2) {
        if (((Minecraft)3S.c).player == null || ((Minecraft)3S.c).world == null) {
            return;
        }
        if (((Minecraft)3S.c).player.getHealth() <= 0.0f || 3S.c.player.isDead) {
            this.1 = 0;
        }
    }

    @Subscriber
    public void c(1E e2) {
        block0: {
            ++this.1;
            if (this.1 <= 1) break block0;
            8p_0.1("You are on a " + this.1 + " Kill Streak!");
        }
    }

    @Subscriber
    public void c(1T t) {
        ((ArrayList)((Object)this.0)).clear();
    }

    @Override
    public void c() {
        ((ArrayList)((Object)this.0)).clear();
    }

    public void c(String string, String string2, TrayIcon.MessageType messageType) {
        this.c.displayMessage(string, string2, messageType);
    }

    @Subscriber
    public void c(0I i2) {
        if (i2.c() instanceof GuiMultiplayer || i2.c() instanceof GuiMainMenu) {
            this.0();
            this.1 = 0;
        }
    }

    public 3S() {
        super("Notify", "Notifies you of various things", 3D.5, new String[0]);
        this.3 = new 8h_0("Donkeys", false);
        this.4 = new 8h_0("Llamas", false);
        this.5 = new 8h_0("Slimes", false);
        this.6 = new 8h_0("Ghasts", false);
        this.7 = new 8h_0("Sound", true);
        this.0 = new 8e_0("SystemTray", false, this::0);
        this.0 = new ArrayList();
        this.c = new 9m();
        this.c = new 3R(this);
    }

    public void c(Boolean bl) {
        this.1 = 0;
    }

    @Subscriber
    public void c(0S s) {
        block1: {
            if (!(s.c() instanceof SPacketChat) || !3S.c.getCurrentServerData().serverIP.toLowerCase().contains("2b2t.org")) break block1;
            if (((SPacketChat)s.c()).getChatComponent().getFormattedText().contains("Position in queue:")) {
                this.0();
            }
        }
    }

    public void 0(Boolean bl) {
        if (bl.booleanValue()) {
            TrayIcon trayIcon;
            SystemTray systemTray;
            if (!SystemTray.isSupported()) {
                8p_0.c("Your computer does not support system tray notifications.");
                this.d();
                return;
            }
            InputStream inputStream = 3S.class.getResourceAsStream("assets/minecraft/konas/textures/konas.png");
            BufferedImage bufferedImage = null;
            InputStream inputStream2 = inputStream;
            BufferedImage bufferedImage2 = ImageIO.read(inputStream2);
            try {
                bufferedImage = bufferedImage2;
            }
            catch (IOException iOException) {
                // empty catch block
            }
            if (bufferedImage == null) {
                8p_0.c("Failed to load assets.");
                this.d();
                return;
            }
            this.c = new TrayIcon(bufferedImage, "Konas");
            this.c = SystemTray.getSystemTray();
            try {
                systemTray = this.c;
                trayIcon = this.c;
            }
            catch (AWTException aWTException) {
                8p_0.c("Failed to initialize tray icon.");
                this.d();
                return;
            }
            systemTray.add(trayIcon);
        }
        this.c.remove(this.c);
    }

    @Subscriber
    public void 0(1N n2) {
        if (!((Boolean)this.6.6()).booleanValue() && !((Boolean)this.3.6()).booleanValue() && !((Boolean)this.4.6()).booleanValue() && !((Boolean)this.5.6()).booleanValue() || ((Minecraft)3S.c).player == null || ((Minecraft)3S.c).world == null || n2.c() == TickEvent.Phase.START) {
            return;
        }
        for (Entity entity : 3S.c.world.loadedEntityList) {
            if (entity instanceof EntityDonkey && ((Boolean)this.3.6()).booleanValue() && !((ArrayList)((Object)this.0)).contains(entity)) {
                8p_0.1("Found &bDonkey &fat &bx=" + entity.getPosition().getX() + ",y=" + entity.getPosition().getY() + ",z=" + entity.getPosition().getZ());
                ((ArrayList)((Object)this.0)).add(entity);
                if (!((Boolean)this.7.6()).booleanValue()) continue;
                c.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.ENTITY_PLAYER_LEVELUP, (float)1.0f));
                continue;
            }
            if (entity instanceof EntityLlama && ((Boolean)this.4.6()).booleanValue() && !((ArrayList)((Object)this.0)).contains(entity)) {
                8p_0.1("Found &bLlama &fat &bx=" + entity.getPosition().getX() + ",y=" + entity.getPosition().getY() + ",z=" + entity.getPosition().getZ());
                ((ArrayList)((Object)this.0)).add(entity);
                if (!((Boolean)this.7.6()).booleanValue()) continue;
                c.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.ENTITY_PLAYER_LEVELUP, (float)1.0f));
                continue;
            }
            if (entity instanceof EntitySlime && ((Boolean)this.5.6()).booleanValue() && !((ArrayList)((Object)this.0)).contains(entity)) {
                8p_0.1("Found &bSlime &fat &bx=" + entity.getPosition().getX() + ",y=" + entity.getPosition().getY() + ",z=" + entity.getPosition().getZ());
                ((ArrayList)((Object)this.0)).add(entity);
                if (!((Boolean)this.7.6()).booleanValue()) continue;
                c.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.ENTITY_PLAYER_LEVELUP, (float)1.0f));
                continue;
            }
            if (!(entity instanceof EntityGhast) || !((Boolean)this.6.6()).booleanValue() || ((ArrayList)((Object)this.0)).contains(entity)) continue;
            8p_0.1("Found &bGhast &fat &bx=" + entity.getPosition().getX() + ",y=" + entity.getPosition().getY() + ",z=" + entity.getPosition().getZ());
            ((ArrayList)((Object)this.0)).add(entity);
            if (!((Boolean)this.7.6()).booleanValue()) continue;
            c.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.ENTITY_PLAYER_LEVELUP, (float)1.0f));
        }
    }

    public void 0() {
        this.c.c();
        for (Map.Entry entry : ((HashMap)((Object)this.c)).entrySet()) {
            ((HashMap)((Object)this.c)).put(entry.getKey(), false);
        }
    }

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)3S.c).player == null || ((Minecraft)3S.c).world == null || n2.c() == TickEvent.Phase.START || !((Boolean)this.2.6()).booleanValue()) {
            return;
        }
        if (this.c.c(2.07E7) && !((Boolean)((HashMap)((Object)this.c)).get(20700000L)).booleanValue()) {
            8p_0.1("You will get kicked in 15 Minutes!");
            ((HashMap)((Object)this.c)).put(20700000L, true);
        }
        if (this.c.c(2.1E7) && !((Boolean)((HashMap)((Object)this.c)).get(21000000L)).booleanValue()) {
            8p_0.1("You will get kicked in 10 Minutes!");
            ((HashMap)((Object)this.c)).put(21000000L, true);
        }
        if (this.c.c(2.13E7) && !((Boolean)((HashMap)((Object)this.c)).get(21300000L)).booleanValue()) {
            8p_0.1("You will get kicked in 5 Minutes!");
            ((HashMap)((Object)this.c)).put(21300000L, true);
        }
        if (this.c.c(2.154E7) && !((Boolean)((HashMap)((Object)this.c)).get(21540000L)).booleanValue()) {
            8p_0.1("You will get kicked in 1 Minute!");
            ((HashMap)((Object)this.c)).put(21540000L, true);
        }
        if (this.c.c(2.157E7) && !((Boolean)((HashMap)((Object)this.c)).get(21570000L)).booleanValue()) {
            8p_0.1("You will get kicked in 30 Seconds!");
            ((HashMap)((Object)this.c)).put(21570000L, true);
        }
    }
}

