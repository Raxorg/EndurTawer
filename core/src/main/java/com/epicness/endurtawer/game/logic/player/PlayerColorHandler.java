package com.epicness.endurtawer.game.logic.player;

import com.badlogic.gdx.graphics.Color;
import com.epicness.endurtawer.game.logic.GameLogicHandler;
import com.epicness.endurtawer.game.stuff.Player;
import com.epicness.fundamentals.utils.Random;

public class PlayerColorHandler extends GameLogicHandler {

    private Color colorA, colorB;
    private float progress;

    private Player player;

    @Override
    protected void init() {
        colorB = Random.rainbowColor();
        randomizeNextColor();
        player = stuff.getPlayer();
        player.setColor(colorA);
    }

    public void update(float delta) {
        Color color = colorA.cpy().lerp(colorB, progress);
        player.setColor(color);
        progress = Math.min(progress + delta, 1f);
        if (progress == 1f) {
            randomizeNextColor();
        }
    }

    private void randomizeNextColor() {
        colorA = colorB.cpy();
        colorB = Random.rainbowExcludedColor(colorA);
        progress = 0f;
    }
}