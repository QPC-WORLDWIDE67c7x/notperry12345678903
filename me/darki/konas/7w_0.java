/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.7w
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7w_0
extends Enum {
    public static /* enum */ 7w_0 c = new 7w_0("NORMAL", 0);
    public static /* enum */ 7w_0 0 = new 7w_0("GAMMA", 1);
    public static /* enum */ 7w_0 1 = new 7w_0("POTION", 2);
    public static 7w_0[] c = new 7w_0[]{c, 0, 1};

    public static 7w_0[] values() {
        return (7w_0[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7w_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 7w_0 c(String string) {
        return Enum.valueOf(7w_0.class, string);
    }
}

