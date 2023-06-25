package com.epicness.endurtawer.game.logic;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.GOLD;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.ROYAL;
import static com.badlogic.gdx.graphics.Color.SALMON;

import com.epicness.endurtawer.game.stuff.Player;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;

public class BackgroundHandler extends GameLogicHandler {

    private Sprited base;
    private DualSprited background;
    private Player player;

    @Override
    protected void init() {
        base = stuff.getBase();
        background = stuff.getBackground();
        player = stuff.getPlayer();
    }

    public void update() {
        base.setColor(BLACK.cpy().lerp(GOLD, player.health));
        background.setBackgroundColor(RED.cpy().lerp(ROYAL, player.health));
        background.setForegroundColor(BLACK.cpy().lerp(SALMON, player.health));
    }
}