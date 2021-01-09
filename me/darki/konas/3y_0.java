/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.IOException;
import me.darki.konas.8J;
import me.darki.konas.8k_0;
import me.darki.konas.94;
import me.darki.konas.9f;
import me.darki.konas.9m;
import me.darki.konas.b_0;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;

/*
 * Renamed from me.darki.konas.3y
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3y_0
extends GuiScreen {
    public EntityPlayer c;
    public 9m c = new 9m();

    public void drawScreen(int n2, int n3, float f2) {
        block3: {
            super.drawScreen(n2, n3, f2);
            Vec3d vec3d = new Vec3d(this.c.lastTickPosX + (this.c.posX - this.c.lastTickPosX) * (double)this.mc.getRenderPartialTicks(), this.c.lastTickPosY + (this.c.posY - this.c.lastTickPosY) * (double)this.mc.getRenderPartialTicks(), this.c.lastTickPosZ + (this.c.posZ - this.c.lastTickPosZ) * (double)this.mc.getRenderPartialTicks()).add(0.0, (double)this.c.height, 0.0);
            Vec3d vec3d2 = 8k_0.c.c.c(vec3d);
            boolean bl = 8J.1(this.c.getName());
            boolean bl2 = b_0.0.contains(this.c.getName());
            boolean bl3 = false;
            if (this.mc.getCurrentServerData() != null && this.mc.getCurrentServerData().serverIP != null && this.mc.getCurrentServerData().serverIP.contains("pvp")) {
                bl3 = true;
            }
            float f3 = Math.max(9f.0(bl ? "Unfriend" : "Friend"), 9f.0(bl2 ? "Unparty" : "Party"));
            float f4 = 8.0f + 9f.c(bl ? "Unfriend" : "Friend") + 9f.c(bl2 ? "Unparty" : "Party");
            if (bl3) {
                f4 += 4.0f + 9f.c("Duel");
            }
            94.c((float)vec3d2.x - f3 / 2.0f - 2.0f, (float)vec3d2.y - 2.0f, f3 + 4.0f, f4, Integer.MIN_VALUE);
            94.c((float)vec3d2.x - f3 / 2.0f - 2.0f, (float)vec3d2.y - 2.0f, f3 + 4.0f, f4, 1.0f, -805306368);
            9f.1(bl ? "Unfriend" : "Friend", (float)vec3d2.x - 9f.0(bl ? "Unfriend" : "Friend") / 2.0f, (float)vec3d2.y, -1);
            9f.1(bl2 ? "Unparty" : "Party", (float)vec3d2.x - 9f.0(bl2 ? "Unparty" : "Party") / 2.0f, (float)vec3d2.y + 4.0f + 9f.c(bl ? "Unfriend" : "Friend"), -1);
            if (bl3) {
                9f.1("Duel", (float)vec3d2.x - 9f.0("Duel") / 2.0f, (float)vec3d2.y + 4.0f + 9f.c(bl ? "Unfriend" : "Friend") + 4.0f + 9f.c(bl2 ? "Unparty" : "Party"), -1);
            }
            if (!this.c.c(5000.0)) break block3;
            this.mc.displayGuiScreen(null);
        }
    }

    public void mouseClicked(int n2, int n3, int n4) throws IOException {
        block5: {
            boolean bl;
            boolean bl2;
            boolean bl3;
            Vec3d vec3d;
            block7: {
                block6: {
                    super.mouseClicked(n2, n3, n4);
                    Vec3d vec3d2 = new Vec3d(this.c.lastTickPosX + (this.c.posX - this.c.lastTickPosX) * (double)this.mc.getRenderPartialTicks(), this.c.lastTickPosY + (this.c.posY - this.c.lastTickPosY) * (double)this.mc.getRenderPartialTicks(), this.c.lastTickPosZ + (this.c.posZ - this.c.lastTickPosZ) * (double)this.mc.getRenderPartialTicks()).add(0.0, (double)this.c.height, 0.0);
                    vec3d = 8k_0.c.c.c(vec3d2);
                    bl3 = 8J.1(this.c.getName());
                    bl2 = b_0.0.contains(this.c.getName());
                    bl = false;
                    if (this.mc.getCurrentServerData() != null && this.mc.getCurrentServerData().serverIP != null && this.mc.getCurrentServerData().serverIP.contains("pvp")) {
                        bl = true;
                    }
                    if (n4 != 0) break block5;
                    if (!3y_0.c(n2, n3, (float)vec3d.x - 9f.0(bl3 ? "Unfriend" : "Friend") / 2.0f, (float)vec3d.y, 9f.0(bl3 ? "Unfriend" : "Friend"), 9f.c(bl3 ? "Unfriend" : "Friend"))) break block6;
                    if (bl3) {
                        8J.0(this.c.getName());
                    } else {
                        8J.c(this.c.getName(), this.c.getUniqueID().toString().replace("-", ""));
                    }
                    this.mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
                    this.mc.displayGuiScreen(null);
                    break block5;
                }
                if (!3y_0.c(n2, n3, (float)vec3d.x - 9f.0(bl2 ? "Unparty" : "Party") / 2.0f, (float)vec3d.y + 4.0f + 9f.c(bl3 ? "Unfriend" : "Friend"), 9f.0(bl2 ? "Unparty" : "Party"), 9f.c(bl2 ? "Unparty" : "Party"))) break block7;
                if (bl2) {
                    b_0.0.remove(this.c.getName());
                } else {
                    b_0.0.add(this.c.getName());
                }
                this.mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
                this.mc.displayGuiScreen(null);
                break block5;
            }
            if (!bl || !3y_0.c(n2, n3, (float)vec3d.x - 9f.0(bl2 ? "Unparty" : "Party") / 2.0f, (float)vec3d.y + 4.0f + 9f.c(bl3 ? "Unfriend" : "Friend") + 4.0f + 9f.c(bl2 ? "Unparty" : "Party"), 9f.0("Duel"), 9f.c("Duel"))) break block5;
            this.mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
            this.mc.displayGuiScreen(null);
            this.mc.player.connection.sendPacket((Packet)new CPacketChatMessage("/duel " + this.c.getName()));
        }
    }

    public 3y_0(EntityPlayer entityPlayer) {
        this.c = entityPlayer;
        this.c.c();
    }

    public static boolean c(int n2, int n3, double d2, double d3, double d4, double d5) {
        return (double)n2 >= d2 && (double)n2 <= d2 + d4 && (double)n3 >= d3 && (double)n3 <= d3 + d5;
    }
}

