/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.7c_0;
import me.darki.konas.8j_0;
import me.darki.konas.8x_0;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.MovementInputFromOptions;

public class 6Y
extends MovementInputFromOptions {
    public 7c_0 c;

    public void updatePlayerMoveState() {
        if (!8x_0.c(((8j_0)7c_0.1.6()).c())) {
            super.updatePlayerMoveState();
        } else {
            this.moveStrafe = 0.0f;
            this.moveForward = 0.0f;
            this.forwardKeyDown = false;
            this.backKeyDown = false;
            this.leftKeyDown = false;
            this.rightKeyDown = false;
            this.jump = false;
            this.sneak = false;
        }
    }

    public 6Y(7c_0 c_02, GameSettings gameSettings) {
        this.c = c_02;
        super(gameSettings);
    }
}

