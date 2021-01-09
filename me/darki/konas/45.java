/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 45
extends Enum {
    public static /* enum */ 45 c = new 45("OFF", 0);
    public static /* enum */ 45 0 = new 45("SEMI", 1);
    public static /* enum */ 45 1 = new 45("FULL", 2);
    public static 45[] c = new 45[]{c, 0, 1};

    public static 45 c(String string) {
        return Enum.valueOf(45.class, string);
    }

    public static 45[] values() {
        return (45[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 45() {
        void var2_-1;
        void var1_-1;
    }
}

