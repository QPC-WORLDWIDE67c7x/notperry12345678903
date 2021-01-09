/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.4p
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4p_0
extends Enum {
    public static /* enum */ 4p_0 c = new 4p_0("PACKET", 0);
    public static /* enum */ 4p_0 0 = new 4p_0("BYPASS", 1);
    public static /* enum */ 4p_0 1 = new 4p_0("JUMP", 2);
    public static /* enum */ 4p_0 2 = new 4p_0("SMALLJUMP", 3);
    public static 4p_0[] c = new 4p_0[]{c, 0, 1, 2};

    public static 4p_0[] values() {
        return (4p_0[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4p_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 4p_0 c(String string) {
        return Enum.valueOf(4p_0.class, string);
    }
}

