/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.7o
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7o_0
extends Enum {
    public static /* enum */ 7o_0 c = new 7o_0("NONE", 0);
    public static /* enum */ 7o_0 0 = new 7o_0("GLOW", 1);
    public static /* enum */ 7o_0 1 = new 7o_0("BOX", 2);
    public static /* enum */ 7o_0 2 = new 7o_0("SHADER", 3);
    public static /* enum */ 7o_0 3 = new 7o_0("OUTLINE", 4);
    public static 7o_0[] c = new 7o_0[]{c, 0, 1, 2, 3};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7o_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 7o_0 c(String string) {
        return Enum.valueOf(7o_0.class, string);
    }

    public static 7o_0[] values() {
        return (7o_0[])c.clone();
    }
}

