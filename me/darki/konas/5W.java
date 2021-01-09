/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1G;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.5T;
import me.darki.konas.8h_0;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumHand;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5W
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("PickaxeOnly", false);
    public 8h_0<Boolean> 2 = new 8h_0("SwordOnly", false);

    @Subscriber
    public void c(1G g2) {
        if (5W.c.gameSettings.keyBindPickBlock.isKeyDown() && 3F.c(5T.class).f()) {
            return;
        }
        if (!(!((Boolean)this.1.6()).booleanValue() || 5W.c.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemPickaxe || ((Boolean)this.2.6()).booleanValue() && 5W.c.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemSword)) {
            return;
        }
        g2.c(true);
    }

    public 5W() {
        super("NoEntityTrace", 3D.3, "NoEntityHit");
    }
}

