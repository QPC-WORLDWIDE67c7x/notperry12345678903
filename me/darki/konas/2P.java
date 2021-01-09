/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2P
extends Enum {
    public static /* enum */ 2P c = new 2P("TEXTURE", 0);
    public static /* enum */ 2P 0 = new 2P("OUTLINE", 1);
    public static /* enum */ 2P 1 = new 2P("OFF", 2);
    public static 2P[] c = new 2P[]{c, 0, 1};

    public static 2P[] values() {
        return (2P[])c.clone();
    }

    public static 2P c(String string) {
        return Enum.valueOf(2P.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 2P() {
        void var2_-1;
        void var1_-1;
    }
}

