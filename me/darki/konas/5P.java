/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import me.darki.konas.8p_0;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5P
extends Thread {
    public Socket c;
    public DataInputStream c;

    @Override
    public void run() {
        while (this.c.isConnected()) {
            StringBuilder stringBuilder;
            DataInputStream dataInputStream;
            try {
                dataInputStream = this.c;
            }
            catch (IOException object) {}
            String string = dataInputStream.readUTF();
            Object object = object = string;
            String string2 = "MESSAGE";
            boolean bl = ((String)object).equals(string2);
            if (!bl) continue;
            DataInputStream dataInputStream2 = this.c;
            String string3 = dataInputStream2.readUTF();
            String string4 = string3;
            DataInputStream dataInputStream3 = this.c;
            String string5 = dataInputStream3.readUTF();
            String string6 = string5;
            StringBuilder stringBuilder2 = stringBuilder;
            StringBuilder stringBuilder3 = stringBuilder;
            stringBuilder2();
            String string7 = "\u00c2\u00a7b";
            StringBuilder stringBuilder4 = stringBuilder3.append(string7);
            String string8 = string4;
            StringBuilder stringBuilder5 = stringBuilder4.append(string8);
            String string9 = ": ";
            StringBuilder stringBuilder6 = stringBuilder5.append(string9);
            String string10 = string6;
            StringBuilder stringBuilder7 = stringBuilder6.append(string10);
            String string11 = stringBuilder7.toString();
            8p_0.1(string11);
        }
    }

    public 5P(Socket socket, DataInputStream dataInputStream) {
        this.c = socket;
        this.c = dataInputStream;
    }
}

