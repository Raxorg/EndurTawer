package com.epicness.endurtawer.game.logic;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.L;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.W;
import static com.epicness.endurtawer.game.constants.GameConstants.ACCELERATION;

import com.epicness.endurtawer.game.stuff.GameStuff;
import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler<GameLogic, GameStuff> {

    @Override
    public void keyDown(int keycode) {
        switch (keycode) {
            case W:
                logic.get(PlayerMovementHandler.class).accelerate(0f, ACCELERATION);
                break;
            case A:
                logic.get(PlayerMovementHandler.class).accelerate(-ACCELERATION, 0f);
                break;
            case S:
                logic.get(PlayerMovementHandler.class).accelerate(0f, -ACCELERATION);
                break;
            case D:
                logic.get(PlayerMovementHandler.class).accelerate(ACCELERATION, 0f);
                break;
            case L:
                logic.get(TentacleMovementHandler.class).toggleLock();
                break;
        }
    }

    @Override
    public void keyUp(int keycode) {
        switch (keycode) {
            case W:
                logic.get(PlayerMovementHandler.class).accelerate(0f, -ACCELERATION);
                break;
            case A:
                logic.get(PlayerMovementHandler.class).accelerate(ACCELERATION, 0f);
                break;
            case S:
                logic.get(PlayerMovementHandler.class).accelerate(0f, ACCELERATION);
                break;
            case D:
                logic.get(PlayerMovementHandler.class).accelerate(-ACCELERATION, 0f);
                break;
        }
    }

    @Override
    public void mouseMoved(float x, float y) {
    }
}