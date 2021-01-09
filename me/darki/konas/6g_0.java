/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.6g
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6g_0
extends Enum {
    public static /* enum */ 6g_0 c = new 6g_0("BOOST", 0);
    public static /* enum */ 6g_0 0 = new 6g_0("CONTROL", 1);
    public static /* enum */ 6g_0 1 = new 6g_0("FIREWORK", 2);
    public static /* enum */ 6g_0 2 = new 6g_0("PACKET", 3);
    public static 6g_0[] c = new 6g_0[]{c, 0, 1, 2};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 6g_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 6g_0[] values() {
        return (6g_0[])c.clone();
    }

    public static 6g_0 c(String string) {
        return Enum.valueOf(6g_0.class, string);
    }
}

