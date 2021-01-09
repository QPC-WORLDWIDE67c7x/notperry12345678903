/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.regex.Pattern;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 9a
extends Enum {
    public static /* enum */ 9a c;
    public static /* enum */ 9a 0;
    public static /* enum */ 9a 1;
    public static /* enum */ 9a 2;
    public static /* enum */ 9a 3;
    public static /* enum */ 9a 4;
    public static /* enum */ 9a 5;
    public static /* enum */ 9a 6;
    public static /* enum */ 9a 7;
    public static /* enum */ 9a 8;
    public static /* enum */ 9a 9;
    public static /* enum */ 9a a;
    public static /* enum */ 9a b;
    public static /* enum */ 9a d;
    public static /* enum */ 9a e;
    public static /* enum */ 9a f;
    public static /* enum */ 9a g;
    public static /* enum */ 9a h;
    public static /* enum */ 9a i;
    public static /* enum */ 9a j;
    public static /* enum */ 9a k;
    public static /* enum */ 9a l;
    public static char c;
    public static Pattern c;
    public static int[] c;
    public char 0;
    public boolean c;
    public String c;
    public static 9a[] c;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 9a() {
        this((String)var1_-1, (int)var2_-1, (char)var3_1, false);
        void var3_1;
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - void declaration
     */
    public 9a() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.0 = var3_1;
        this.c = var4_2;
        this.c = new String(new char[]{'\u00a7', var3_1});
    }

    public boolean c() {
        return this.c;
    }

    public static 9a[] values() {
        return (9a[])c.clone();
    }

    public static String c(String string) {
        return string == null ? null : Pattern.compile("(?i)\u00a7[0-9A-FK-OR]").matcher(string).replaceAll("");
    }

    public char 0() {
        return this.0;
    }

    static {
        c = (char)167;
        c = new 9a("BLACK", 0, '0');
        0 = new 9a("DARK_BLUE", 1, '1');
        1 = new 9a("DARK_GREEN", 2, '2');
        2 = new 9a("DARK_AQUA", 3, '3');
        3 = new 9a("DARK_RED", 4, '4');
        4 = new 9a("DARK_PURPLE", 5, '5');
        5 = new 9a("GOLD", 6, '6');
        6 = new 9a("GRAY", 7, '7');
        7 = new 9a("DARK_GRAY", 8, '8');
        8 = new 9a("BLUE", 9, '9');
        9 = new 9a("GREEN", 10, 'a');
        a = new 9a("AQUA", 11, 'b');
        b = new 9a("RED", 12, 'c');
        d = new 9a("LIGHT_PURPLE", 13, 'd');
        e = new 9a("YELLOW", 14, 'e');
        f = new 9a("WHITE", 15, 'f');
        g = new 9a("MAGIC", 16, 'k', true);
        h = new 9a("BOLD", 17, 'l', true);
        i = new 9a("STRIKETHROUGH", 18, 'm', true);
        j = new 9a("UNDERLINE", 19, 'n', true);
        k = new 9a("ITALIC", 20, 'o', true);
        l = new 9a("RESET", 21, 'r');
        c = new 9a[]{c, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, d, e, f, g, h, i, j, k, l};
        c = Pattern.compile("\u00a7[0123456789abcdefklmnor]");
        c = new int[]{0, 170, 43520, 43690, 0xAA0000, 0xAA00AA, 0xFFAA00, 0xAAAAAA, 0x555555, 0x5555FF, 0x55FF55, 0x55FFFF, 0xFF5555, 0xFF55FF, 0xFFFF55, 0xFFFFFF};
    }

    public static 9a 0(String string) {
        return Enum.valueOf(9a.class, string);
    }

    public static String c(char c2, String string) {
        char[] cArray = string.toCharArray();
        int n2 = cArray.length - 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (cArray[i2] != c2 || "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(cArray[i2 + 1]) <= -1) continue;
            cArray[i2] = 167;
            cArray[i2 + 1] = Character.toLowerCase(cArray[i2 + 1]);
        }
        return new String(cArray);
    }

    public String toString() {
        return this.c;
    }

    public boolean 1() {
        return !this.c && this != l;
    }
}

