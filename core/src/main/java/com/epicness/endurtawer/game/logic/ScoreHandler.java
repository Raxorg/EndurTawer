package com.epicness.endurtawer.game.logic;

import com.epicness.endurtawer.game.logic.player.PlayerMover;
import com.epicness.endurtawer.game.stuff.Player;

public class ScoreHandler extends GameLogicHandler {

    private float time;
    private boolean gameOver;

    @Override
    protected void init() {
        stuff.getScore().setText("");
        time = 0f;
        gameOver = false;
    }

    @Override
    protected void update(float delta) {
        if (gameOver) return;
        time += delta;
    }

    public void gameOver() {
        logic.get(PlayerMover.class).blockMovement();
        stuff.getScore().setText("You survived " + (int) time + " seconds!\nPress R to restart");
        gameOver = true;
    }

    public void reset() {
        if (gameOver) logic.initialLogic();
    }
}