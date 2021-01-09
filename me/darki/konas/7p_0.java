/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.7p
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7p_0
extends Enum {
    public static /* enum */ 7p_0 c = new 7p_0("LINE", 0);
    public static /* enum */ 7p_0 0 = new 7p_0("OUTLINE", 1);
    public static /* enum */ 7p_0 1 = new 7p_0("FULL", 2);
    public static 7p_0[] c = new 7p_0[]{c, 0, 1};

    public static 7p_0 c(String string) {
        return Enum.valueOf(7p_0.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7p_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 7p_0[] values() {
        return (7p_0[])c.clone();
    }
}

