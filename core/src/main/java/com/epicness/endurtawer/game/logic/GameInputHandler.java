package com.epicness.endurtawer.game.logic;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.G;
import static com.badlogic.gdx.Input.Keys.R;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.W;
import static com.epicness.endurtawer.game.constants.GameConstants.ACCELERATION;

import com.epicness.endurtawer.game.logic.player.PlayerMover;
import com.epicness.endurtawer.game.stuff.GameStuff;
import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler<GameLogic, GameStuff> {

    @Override
    public void keyDown(int keycode) {
        logic.get(MusicHandler.class).keyDown();
        switch (keycode) {
            case W:
                logic.get(PlayerMover.class).accelerate(0f, ACCELERATION);
                break;
            case A:
                logic.get(PlayerMover.class).accelerate(-ACCELERATION, 0f);
                break;
            case S:
                logic.get(PlayerMover.class).accelerate(0f, -ACCELERATION);
                break;
            case D:
                logic.get(PlayerMover.class).accelerate(ACCELERATION, 0f);
                break;
            case F:
                logic.get(Debugger.class).toggleDebug();
                break;
            case G:
                logic.get(Debugger.class).toggleOnlyDebug();
                break;
        }
    }

    @Override
    public void keyUp(int keycode) {
        switch (keycode) {
            case W:
                logic.get(PlayerMover.class).accelerate(0f, -ACCELERATION);
                break;
            case A:
                logic.get(PlayerMover.class).accelerate(ACCELERATION, 0f);
                break;
            case S:
                logic.get(PlayerMover.class).accelerate(0f, ACCELERATION);
                break;
            case D:
                logic.get(PlayerMover.class).accelerate(-ACCELERATION, 0f);
                break;
            case R:
                logic.get(ScoreHandler.class).reset();
                break;
        }
    }

    @Override
    public void touchDown(float x, float y) {
        logic.get(MusicHandler.class).touchDown();
    }
}