/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 51
extends Enum {
    public static /* enum */ 51 c = new 51("UP", 0);
    public static /* enum */ 51 0 = new 51("PRESERVE", 1);
    public static /* enum */ 51 1 = new 51("DOWN", 2);
    public static /* enum */ 51 2 = new 51("LIMITJITTER", 3);
    public static /* enum */ 51 3 = new 51("BYPASS", 4);
    public static /* enum */ 51 4 = new 51("OBSCURE", 5);
    public static 51[] c = new 51[]{c, 0, 1, 2, 3, 4};

    public static 51[] values() {
        return (51[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 51() {
        void var2_-1;
        void var1_-1;
    }

    public static 51 c(String string) {
        return Enum.valueOf(51.class, string);
    }
}

