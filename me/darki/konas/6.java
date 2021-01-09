/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.command.SyntaxChunk;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class 6
extends SyntaxChunk {
    public 6(String string) {
        super(string);
    }

    public String c(String string) {
        for (EntityPlayer entityPlayer : Minecraft.getMinecraft().world.playerEntities) {
            if (!entityPlayer.getName().toLowerCase().startsWith(string.toLowerCase())) continue;
            return entityPlayer.getName();
        }
        return string;
    }
}

