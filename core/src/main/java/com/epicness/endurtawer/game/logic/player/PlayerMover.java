package com.epicness.endurtawer.game.logic.player;

import static com.epicness.endurtawer.game.constants.GameConstants.MAX_PLAYER_X;
import static com.epicness.endurtawer.game.constants.GameConstants.MAX_PLAYER_Y;
import static com.epicness.endurtawer.game.constants.GameConstants.STARTING_PLAYER_POSITION;
import static com.epicness.endurtawer.game.constants.GameConstants.STOP_TIME;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.epicness.endurtawer.game.logic.GameLogicHandler;
import com.epicness.endurtawer.game.stuff.Player;

public class PlayerMover extends GameLogicHandler {

    private Player player;
    private Vector2 speed;
    private Vector2 acceleration;
    private float lastSpeedX, stopTimeX, lastSpeedY, stopTimeY;
    private boolean blocked;

    @Override
    protected void init() {
        player = stuff.getPlayer();
        player.setOriginBasedPosition(STARTING_PLAYER_POSITION);
        speed = new Vector2();
        acceleration = new Vector2();
        blocked = false;
    }

    public void update(float delta) {
        movePlayer(delta);
        // Decelerate / stop
        if (acceleration.x == 0f) {
            stopTimeX = Math.min(stopTimeX + delta / STOP_TIME, 1f);
            speed.x = MathUtils.lerp(lastSpeedX, 0f, stopTimeX);
        }
        if (acceleration.y == 0f) {
            stopTimeY = Math.min(stopTimeY + delta / STOP_TIME, 1f);
            speed.y = MathUtils.lerp(lastSpeedY, 0f, stopTimeY);
        }
    }

    private void movePlayer(float delta) {
        if (blocked) return;

        speed.mulAdd(acceleration.cpy(), delta);
        float x = MathUtils.clamp(player.getX(), 0f, MAX_PLAYER_X);
        if (x == 0) {
            speed.x = Math.max(speed.x, 0f);
        }
        if (x == MAX_PLAYER_X) {
            speed.x = Math.min(speed.x, 0f);
        }
        float y = MathUtils.clamp(player.getY(), 0f, MAX_PLAYER_Y);
        if (y == 0) {
            speed.y = Math.max(speed.y, 0f);
        }
        if (y == MAX_PLAYER_Y) {
            speed.y = Math.min(speed.y, 0f);
        }
        player.translate(speed);
    }

    public void accelerate(float xAcceleration, float yAcceleration) {
        acceleration.x += xAcceleration;
        if (acceleration.x == 0f) {
            lastSpeedX = speed.x;
            stopTimeX = 0f;
        }
        acceleration.y += yAcceleration;
        if (acceleration.y == 0f) {
            lastSpeedY = speed.y;
            stopTimeY = 0f;
        }
    }

    public void blockMovement() {
        blocked = true;
    }
}