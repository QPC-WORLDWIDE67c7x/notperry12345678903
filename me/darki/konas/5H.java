/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5H
extends Enum {
    public static /* enum */ 5H c = new 5H("MSG", 0);
    public static /* enum */ 5H 0 = new 5H("WHISPER", 1);
    public static 5H[] c = new 5H[]{c, 0};

    public static 5H c(String string) {
        return Enum.valueOf(5H.class, string);
    }

    public static 5H[] values() {
        return (5H[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5H() {
        void var2_-1;
        void var1_-1;
    }
}

