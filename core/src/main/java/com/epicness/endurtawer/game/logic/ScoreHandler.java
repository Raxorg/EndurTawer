package com.epicness.endurtawer.game.logic;

public class ScoreHandler extends GameLogicHandler {

    private float time;

    @Override
    protected void update(float delta) {
        time += delta;
    }

    public void showScore() {
        //todo
    }

    public void reset() {
        // todo
    }
}