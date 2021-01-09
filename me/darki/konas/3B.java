/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3B {
    public String c;
    public String 0;
    public int c;

    public 3B(String string, String string2, int n2) {
        this.c = string;
        this.0 = string2;
        this.c = n2;
    }

    public String 1() {
        return this.0;
    }

    public int c() {
        return this.c;
    }

    public void c(String string) {
        this.0 = string;
    }

    public boolean equals(Object object) {
        if (object instanceof 3B) {
            return this.2().equalsIgnoreCase(((3B)object).2());
        }
        return false;
    }

    public void 0() {
        Minecraft.getMinecraft().player.sendChatMessage(this.0);
    }

    public String 2() {
        return this.c;
    }

    public void c(int n2) {
        this.c = n2;
    }
}

