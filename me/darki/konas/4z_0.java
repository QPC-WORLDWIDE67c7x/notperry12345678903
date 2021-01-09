/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

/*
 * Renamed from me.darki.konas.4z
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4z_0
extends Enum {
    public static /* enum */ 4z_0 c = new 4z_0("TOTEM", 0, Items.TOTEM_OF_UNDYING);
    public static /* enum */ 4z_0 0 = new 4z_0("CRYSTAL", 1, Items.END_CRYSTAL);
    public static /* enum */ 4z_0 1 = new 4z_0("GAPPLE", 2, Items.GOLDEN_APPLE);
    public static /* enum */ 4z_0 2 = new 4z_0("AIR", 3, Items.AIR);
    public Item c;
    public static 4z_0[] c = new 4z_0[]{c, 0, 1, 2};

    public static 4z_0 c(String string) {
        return Enum.valueOf(4z_0.class, string);
    }

    public static 4z_0[] values() {
        return (4z_0[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4z_0() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.c = var3_1;
    }
}

