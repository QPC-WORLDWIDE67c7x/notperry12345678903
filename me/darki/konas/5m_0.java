/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Renamed from me.darki.konas.5m
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5m_0
extends Enum {
    public static /* enum */ 5m_0 c = new 5m_0("WALK", 0);
    public static /* enum */ 5m_0 0 = new 5m_0("PLACE", 1);
    public static /* enum */ 5m_0 1 = new 5m_0("JUMP", 2);
    public static /* enum */ 5m_0 2 = new 5m_0("DROP", 3);
    public static /* enum */ 5m_0 3 = new 5m_0("BREAK", 4);
    public static /* enum */ 5m_0 4 = new 5m_0("EAT", 5);
    public static /* enum */ 5m_0 5 = new 5m_0("CRAFT", 6);
    public static /* enum */ 5m_0 6 = new 5m_0("PICKUP", 7);
    public static 5m_0[] c = new 5m_0[]{c, 0, 1, 2, 3, 4, 5, 6};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5m_0() {
        void var2_-1;
        void var1_-1;
    }

    public static 5m_0 c(String string) {
        return Enum.valueOf(5m_0.class, string);
    }

    public static 5m_0[] values() {
        return (5m_0[])c.clone();
    }
}

