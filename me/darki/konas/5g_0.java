/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.5g
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5g_0
extends Enum {
    public static /* enum */ 5g_0 c = new 5g_0("VANILLA", 0);
    public static /* enum */ 5g_0 0 = new 5g_0("PACKET", 1);
    public static /* enum */ 5g_0 1 = new 5g_0("INSTANT", 2);
    public static 5g_0[] c = new 5g_0[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5g_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 5g_0[] values() {
        return (5g_0[])c.clone();
    }

    public static 5g_0 c(String string) {
        return Enum.valueOf(5g_0.class, string);
    }
}

