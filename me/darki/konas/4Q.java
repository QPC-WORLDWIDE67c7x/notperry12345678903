/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0I;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.14;
import me.darki.konas.19;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.mixin.mixins.ISPacketCloseWindow;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.server.SPacketCloseWindow;
import net.minecraft.util.EnumHand;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4Q
extends 3E {
    public GuiContainer c;
    public boolean 1;
    public boolean 2 = false;

    @Subscriber
    public void c(0T t) {
        if (t.c() instanceof CPacketCloseWindow) {
            if (this.c != null && this.1) {
                t.c(true);
            }
        } else if (t.c() instanceof CPacketClickWindow) {
            CPacketClickWindow cPacketClickWindow = (CPacketClickWindow)t.c();
            if (cPacketClickWindow.getClickType().equals((Object)ClickType.THROW) && this.1 && this.c != null) {
                this.2 = true;
            } else if (cPacketClickWindow.getClickType().equals((Object)ClickType.THROW) && !this.1) {
                this.2 = false;
                this.c = null;
            }
        }
    }

    @Subscriber
    public void c(14 var1_1) {
        if (this.1 && this.2 && 4Q.c.currentScreen instanceof GuiContainer && !(4Q.c.currentScreen instanceof GuiInventory)) {
            4Q.c.currentScreen = null;
            this.2 = false;
        }
    }

    @Subscriber
    public void c(19 var1_1) {
        if (var1_1.4() != null) {
            Block block = 4Q.c.world.getBlockState(var1_1.4()).getBlock();
            if (block == Blocks.ENDER_CHEST) {
                float f2 = (float)(var1_1.c().x - (double)var1_1.4().getX());
                float f3 = (float)(var1_1.c().y - (double)var1_1.4().getY());
                float f4 = (float)(var1_1.c().z - (double)var1_1.4().getZ());
                4Q.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(var1_1.4(), var1_1.1(), EnumHand.MAIN_HAND, f2, f3, f4));
                this.1 = true;
            } else if (block instanceof BlockContainer) {
                this.1 = false;
                this.2 = false;
                this.c = null;
            }
        }
    }

    public void c(0S s) {
        if (s.c() instanceof SPacketCloseWindow) {
            SPacketCloseWindow sPacketCloseWindow = (SPacketCloseWindow)s.c();
            if (this.c != null && ((ISPacketCloseWindow)sPacketCloseWindow).getWindowId() == this.c.inventorySlots.windowId) {
                this.1 = false;
                this.2 = false;
                this.c = null;
            }
        }
    }

    public 4Q() {
        super("EnderBackpack", "Closes your enderchest GUI and allows you to open it whenever you want", 3D.4, new String[0]);
    }

    @Override
    public void 7() {
        if (4Q.c.world != null) {
            4Q.c.player.connection.sendPacket((Packet)new CPacketCloseWindow(4Q.c.player.inventoryContainer.windowId));
            this.1 = false;
            this.2 = false;
            this.c = null;
        }
    }

    @Subscriber
    public void c(0I i2) {
        block1: {
            block0: {
                if (!(i2.c() instanceof GuiContainer) || i2.c() instanceof GuiInventory) break block0;
                this.c = (GuiContainer)i2.c();
                break block1;
            }
            if (!(i2.c() instanceof GuiInventory) || !this.1 || this.c == null) break block1;
            this.2 = false;
            i2.c(true);
            c.displayGuiScreen((GuiScreen)this.c);
        }
    }
}

