/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;
import net.minecraft.entity.Entity;

public class O
extends 2 {
    public Entity c;

    @Override
    public void c(String[] stringArray) {
        if (stringArray.length == 2) {
            if (stringArray[1].equalsIgnoreCase("Dismount") || stringArray[1].equalsIgnoreCase("D") || stringArray[1].equalsIgnoreCase("Dis")) {
                if (O.c.player.getRidingEntity() != null) {
                    this.c = O.c.player.getRidingEntity();
                    O.c.player.dismountRidingEntity();
                    O.c.world.removeEntity(this.c);
                    8p_0.1("Dismounted entity.");
                } else {
                    8p_0.1("You are not riding an entity.");
                }
            } else if (stringArray[1].equalsIgnoreCase("Remount") || stringArray[1].equalsIgnoreCase("R") || stringArray[1].equalsIgnoreCase("Re")) {
                if (this.c != null) {
                    this.c.isDead = false;
                    O.c.world.addEntityToWorld(this.c.getEntityId(), this.c);
                    O.c.player.startRiding(this.c, true);
                    this.c = null;
                } else {
                    8p_0.1("No entity to remount.");
                }
            } else {
                8p_0.c("Please enter either \"Dismount\" or \"Remount\"");
            }
        } else {
            8p_0.1(this.0());
        }
    }

    public O() {
        super("entitydesync", "Entity Desync", new String[]{"vanish"}, new SyntaxChunk("<Dismount/Remount>"));
    }
}

