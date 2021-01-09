/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.6p
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6p_0
extends Enum {
    public static /* enum */ 6p_0 c = new 6p_0("OFF", 0);
    public static /* enum */ 6p_0 0 = new 6p_0("CONSTANT", 1);
    public static /* enum */ 6p_0 1 = new 6p_0("DYNAMIC", 2);
    public static 6p_0[] c = new 6p_0[]{c, 0, 1};

    public static 6p_0[] values() {
        return (6p_0[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 6p_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 6p_0 c(String string) {
        return Enum.valueOf(6p_0.class, string);
    }
}

