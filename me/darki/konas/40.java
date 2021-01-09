/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 40
extends Enum {
    public static /* enum */ 40 c = new 40("OFF", 0);
    public static /* enum */ 40 0 = new 40("NORMAL", 1);
    public static /* enum */ 40 1 = new 40("SILENT", 2);
    public static 40[] c = new 40[]{c, 0, 1};

    public static 40 c(String string) {
        return Enum.valueOf(40.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 40() {
        void var2_-1;
        void var1_-1;
    }

    public static 40[] values() {
        return (40[])c.clone();
    }
}

