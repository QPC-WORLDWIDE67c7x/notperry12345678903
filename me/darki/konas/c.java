/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c {
    public static String b = "32597";
    public String c;
    public Minecraft c;
    public DiscordRPC c;
    public DiscordRichPresence c;
    public String 0;
    public String 1;
    public boolean c = false;
    public boolean 0 = false;
    public boolean 1 = false;

    public void 3() {
        if (this.c) {
            return;
        }
        DiscordEventHandlers discordEventHandlers = new DiscordEventHandlers();
        discordEventHandlers.disconnected = c::c;
        this.c.Discord_Initialize("813675760953851924", discordEventHandlers, true, "");
        this.c.startTimestamp = System.currentTimeMillis() / 1000L;
        this.c.details = "0.10.2" + (this.0 ? " (Cute)" : "");
        this.c.state = "Main Menu";
        this.c.Discord_UpdatePresence(this.c);
        new Thread(this::c, "Discord-RPC-Callback-Handler").start();
        this.c = true;
    }

    /*
     * Unable to fully structure code
     */
    public void c() {
        while (!Thread.currentThread().isInterrupted()) {
            block71: {
                block70: {
                    v0 = this.c;
                    v0.Discord_RunCallbacks();
                    v1 = this.c;
                    v2 = v1.isIntegratedServerRunning();
                    if (!v2 && this.c.world != null) ** GOTO lbl37
                    v3 = this;
                    v4 = v5;
                    v6 = v5;
                    v4();
                    v7 = "0.10.2";
                    v8 = v6.append(v7);
                    if (!this.0) ** GOTO lbl28
                    v9 = " (Cute)";
                    break block70;
lbl28:
                    // 1 sources

                    v9 = "";
                }
                v10 = v8.append(v9);
                v11 = v10.toString();
                v3.0 = v11;
                ** GOTO lbl64
lbl37:
                // 1 sources

                v12 = this;
                v13 = v14;
                v15 = v14;
                v13();
                v16 = "0.10.2 - Playing";
                v17 = v15.append(v16);
                if (!this.0) ** GOTO lbl52
                v18 = " Cute ";
                break block71;
lbl52:
                // 1 sources

                v18 = " ";
            }
            v19 = v17.append(v18);
            v20 = "Multiplayer";
            v21 = v19.append(v20);
            v22 = v21.toString();
            v12.0 = v22;
lbl64:
            // 2 sources

            this.1 = "";
            v23 = this.c;
            v24 = v23.isIntegratedServerRunning();
            if (!v24) ** GOTO lbl76
            v25 = this;
            v26 = "Playing Singleplayer";
            v25.1 = v26;
            ** GOTO lbl118
lbl76:
            // 1 sources

            v27 = this.c;
            v28 = v27.getCurrentServerData();
            if (v28 == null) ** GOTO lbl113
            v29 = this.c;
            v30 = v29.getCurrentServerData();
            v31 = v30.serverIP;
            v32 = "";
            v33 = v31.equals(v32);
            if (v33) ** GOTO lbl118
            v34 = this;
            v35 = v36;
            v37 = v36;
            v35();
            v38 = "Playing on ";
            v39 = v37.append(v38);
            v40 = this.c;
            v41 = v40.getCurrentServerData();
            v42 = v41.serverIP;
            v43 = v39.append(v42);
            v44 = v43.toString();
            v34.1 = v44;
            ** GOTO lbl118
lbl113:
            // 1 sources

            v45 = this;
            v46 = "Main Menu";
            v45.1 = v46;
lbl118:
            // 4 sources

            v47 = this.0;
            v48 = this.c.details;
            v49 = v47.equals(v48);
            if (!v49) ** GOTO lbl130
            v50 = this.1;
            v51 = this.c.state;
            v52 = v50.equals(v51);
            if (v52) ** GOTO lbl135
lbl130:
            // 2 sources

            v53 = this.c;
            v54 = System.currentTimeMillis();
            v53.startTimestamp = v54 / 1000L;
lbl135:
            // 2 sources

            this.c.details = this.0;
            this.c.state = this.1;
            v55 = this.c;
            v56 = this.c;
            try {
                v55.Discord_UpdatePresence(v56);
            }
            catch (Exception var1_2) {
                var1_2.printStackTrace();
            }
            v57 = 5000L;
            try {
                Thread.sleep(v57);
            }
            catch (InterruptedException var1_3) {
                var1_3.printStackTrace();
            }
        }
    }

    public void c(Boolean bl) {
        this.1 = bl;
        this.1();
        this.c.Discord_UpdatePresence(this.c);
    }

    public static void c(int n2, String string) {
        System.out.println("Discord RPC disconnected, var1: " + n2 + ", var2: " + string);
    }

    public void 0(Boolean bl) {
        this.0 = bl;
        this.1();
        this.2();
        this.c.Discord_UpdatePresence(this.c);
    }

    public void 1() {
        if (this.1) {
            this.c.largeImageText = "discord.gg/gpVZ4Y6cpq";
            return;
        }
        this.c.largeImageText = this.0 ? "Cute Konas on top" : "Konas on top";
    }

    public void 2() {
        this.c.largeImageKey = this.0 ? "cutekonas" : "konas";
    }

    public void 0() {
        this.c.Discord_Shutdown();
        this.c = false;
    }
}

