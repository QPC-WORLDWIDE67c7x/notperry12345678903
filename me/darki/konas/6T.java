/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.07;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.BlockWeb;
import net.minecraft.init.Blocks;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6T
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("Fire", true);
    public 8h_0<Boolean> 2 = new 8h_0("Webs", true);
    public 8h_0<Boolean> 3 = new 8h_0("PressurePlates", true);
    public 8h_0<Boolean> 4 = new 8h_0("Wires", true);
    public 8h_0<Boolean> 5 = new 8h_0("Cactus", true);
    public 8h_0<Boolean> 6 = new 8h_0("Unloaded", true);

    public 6T() {
        super("Avoid", "Avoids hazards", 3D.1, "AntiFlame", "AntiFire", "AntiCactus");
    }

    @Subscriber
    public void c(07 var1_1) {
        block0: {
            Block block = var1_1.1();
            if (!((double)var1_1.2().getY() >= Math.floor(6T.c.player.posY)) || !(block.equals(Blocks.FIRE) && (Boolean)this.1.6() != false || block instanceof BlockWeb && (Boolean)this.2.6() != false || block instanceof BlockBasePressurePlate && (Boolean)this.3.6() != false || block == Blocks.TRIPWIRE && (Boolean)this.4.6() != false || block.equals(Blocks.CACTUS) && (Boolean)this.5.6() != false) && (6T.c.world.isBlockLoaded(var1_1.2(), false) && var1_1.2().getY() >= 0 || !((Boolean)this.6.6()).booleanValue())) break block0;
            var1_1.c(Block.FULL_BLOCK_AABB);
        }
    }
}

