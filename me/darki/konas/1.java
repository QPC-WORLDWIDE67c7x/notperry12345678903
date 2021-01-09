/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import me.darki.konas.0;
import me.darki.konas.3F;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 1
extends Thread {
    public Socket c;
    public DataInputStream c;
    public DataOutputStream c;
    @Nullable
    public String c;
    @NotNull
    public static 1 c;
    public static 0 c;

    @Override
    public void run() {
        3F.c = "cool";
    }

    public String c(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = ((CharSequence)string).length();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append((char)(string.charAt(i2) ^ string2.charAt(i2 % string2.length())));
        }
        return stringBuilder.toString();
    }

    public static void c(1 var0) {
        c = var0;
    }

    @Nullable
    public String c() {
        return this.c;
    }

    public void c(@Nullable String string) {
        this.c = string;
    }

    static {
        c = new 0(null);
        c = new 1();
    }

    @NotNull
    public String 1(@NotNull String string) {
        String string2;
        block0: {
            string2 = this.c;
            if (string2 != null) break block0;
            Intrinsics.throwNpe();
        }
        return this.c(string, string2);
    }

    public static 1 0() {
        return c;
    }

    @NotNull
    public String 0(@NotNull String string) {
        String string2 = string;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Base64.Encoder encoder = Base64.getEncoder();
        Charset charset = Charsets.UTF_8;
        boolean bl = false;
        byte[] byArray = string2.getBytes(charset);
        return encoder.encodeToString(messageDigest.digest(byArray));
    }
}

