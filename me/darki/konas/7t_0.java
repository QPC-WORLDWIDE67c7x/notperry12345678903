/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.7t
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7t_0
extends Enum {
    public static /* enum */ 7t_0 c = new 7t_0("VANILLA", 0);
    public static /* enum */ 7t_0 0 = new 7t_0("PING", 1);
    public static /* enum */ 7t_0 1 = new 7t_0("LENGTH", 2);
    public static 7t_0[] c = new 7t_0[]{c, 0, 1};

    public static 7t_0 c(String string) {
        return Enum.valueOf(7t_0.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7t_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 7t_0[] values() {
        return (7t_0[])c.clone();
    }
}

