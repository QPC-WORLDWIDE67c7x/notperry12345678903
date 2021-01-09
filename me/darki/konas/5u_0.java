/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.5u
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5u_0
extends Enum {
    public static /* enum */ 5u_0 c = new 5u_0("BOUNCE", 0);
    public static /* enum */ 5u_0 0 = new 5u_0("SPLASH", 1);
    public static /* enum */ 5u_0 1 = new 5u_0("BOTH", 2);
    public static 5u_0[] c = new 5u_0[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5u_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 5u_0[] values() {
        return (5u_0[])c.clone();
    }

    public static 5u_0 c(String string) {
        return Enum.valueOf(5u_0.class, string);
    }
}

