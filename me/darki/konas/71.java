/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import me.darki.konas.06;
import me.darki.konas.0E;
import me.darki.konas.0T;
import me.darki.konas.1N;
import me.darki.konas.2n_0;
import me.darki.konas.38;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3y_0;
import me.darki.konas.70;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreenOptionsSounds;
import net.minecraft.client.gui.GuiVideoSettings;
import net.minecraft.client.gui.advancements.GuiScreenAdvancements;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketEntityAction;
import org.lwjgl.input.Keyboard;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 71
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("Strict", false);
    public 8e_0<Boolean> c = new 8e_0("Crouch", false, new 70(this));
    public ArrayList<KeyBinding> 0 = new ArrayList();

    public static ArrayList c(71 var0) {
        return var0.0;
    }

    @Subscriber
    public void c(0T t) {
        block3: {
            if (!((Boolean)this.1.6()).booleanValue() || !(t.c() instanceof CPacketClickWindow)) break block3;
            if (((Minecraft)71.c).player.isActiveItemStackBlocking()) {
                ((Minecraft)71.c).playerController.onStoppedUsingItem((EntityPlayer)((Minecraft)71.c).player);
            }
            if (((Minecraft)71.c).player.isSneaking()) {
                71.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)71.c).player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (((Minecraft)71.c).player.isSprinting()) {
                71.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)71.c).player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
        }
    }

    @Subscriber
    public void c(0E e2) {
        if (((Minecraft)71.c).world == null || ((Minecraft)71.c).player == null) {
            return;
        }
        if (!(((Minecraft)71.c).currentScreen instanceof GuiChat) && ((Minecraft)71.c).currentScreen != null) {
            e2.c = e2.1;
        }
    }

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)71.c).world == null || ((Minecraft)71.c).player == null) {
            return;
        }
        if (((Minecraft)71.c).currentScreen instanceof GuiOptions || ((Minecraft)71.c).currentScreen instanceof GuiVideoSettings || ((Minecraft)71.c).currentScreen instanceof GuiScreenOptionsSounds || ((Minecraft)71.c).currentScreen instanceof GuiContainer || ((Minecraft)71.c).currentScreen instanceof GuiIngameMenu || ((Minecraft)71.c).currentScreen instanceof 38 || ((Minecraft)71.c).currentScreen instanceof GuiScreenAdvancements || ((Minecraft)71.c).currentScreen instanceof 2n_0 || ((Minecraft)71.c).currentScreen instanceof 3y_0) {
            for (KeyBinding keyBinding : this.0) {
                KeyBinding.setKeyBindState((int)keyBinding.getKeyCode(), (boolean)GameSettings.isKeyDown((KeyBinding)keyBinding));
            }
            if (Keyboard.isKeyDown((int)203)) {
                71.c.player.rotationYaw -= 5.0f;
            }
            if (Keyboard.isKeyDown((int)200) && 71.c.player.rotationPitch > -84.0f) {
                71.c.player.rotationPitch -= 5.0f;
            }
            if (Keyboard.isKeyDown((int)208) && 71.c.player.rotationPitch < 84.0f) {
                71.c.player.rotationPitch += 5.0f;
            }
            if (Keyboard.isKeyDown((int)205)) {
                71.c.player.rotationYaw += 5.0f;
            }
        }
    }

    @Subscriber
    public void c(06 var1_1) {
        block2: {
            if (!((Boolean)this.1.6()).booleanValue()) {
                return;
            }
            if (((Minecraft)71.c).player.isSneaking()) {
                71.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)71.c).player, CPacketEntityAction.Action.START_SNEAKING));
            }
            if (!((Minecraft)71.c).player.isSprinting()) break block2;
            71.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)71.c).player, CPacketEntityAction.Action.START_SPRINTING));
        }
    }

    public 71() {
        super("GUIMove", "Lets you move around in GUIs", 3D.1, new String[0]);
        this.0.add(71.c.gameSettings.keyBindForward);
        this.0.add(71.c.gameSettings.keyBindBack);
        this.0.add(71.c.gameSettings.keyBindRight);
        this.0.add(71.c.gameSettings.keyBindLeft);
        this.0.add(71.c.gameSettings.keyBindJump);
        if (((Boolean)this.c.6()).booleanValue()) {
            this.0.add(71.c.gameSettings.keyBindSneak);
        }
    }
}

