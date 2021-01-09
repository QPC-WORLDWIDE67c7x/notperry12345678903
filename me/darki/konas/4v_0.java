/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.4v
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4v_0
extends Enum {
    public static /* enum */ 4v_0 c = new 4v_0("SEQUENTIAL", 0);
    public static /* enum */ 4v_0 0 = new 4v_0("VANILLA", 1);
    public static 4v_0[] c = new 4v_0[]{c, 0};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4v_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 4v_0[] values() {
        return (4v_0[])c.clone();
    }

    public static 4v_0 c(String string) {
        return Enum.valueOf(4v_0.class, string);
    }
}

