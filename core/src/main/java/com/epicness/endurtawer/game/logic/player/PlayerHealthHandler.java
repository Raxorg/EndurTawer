package com.epicness.endurtawer.game.logic.player;

import static com.badlogic.gdx.graphics.Color.CHARTREUSE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.endurtawer.game.logic.GameLogicHandler;
import com.epicness.endurtawer.game.stuff.Player;
import com.epicness.fundamentals.stuff.Sprited;

public class PlayerHealthHandler extends GameLogicHandler {

    private Player player;
    private Sprited healthBar;

    @Override
    protected void init() {
        player = stuff.getPlayer();
        player.health = 1f;

        healthBar = player.getHealthBar();
        healthBar.setWidth(CAMERA_WIDTH);
        healthBar.setColor(CHARTREUSE);
    }

    public void update() {
        player.health = MathUtils.clamp(player.health, 0f, 1f);

        float width = MathUtils.lerp(0f, CAMERA_WIDTH, player.health);
        healthBar.setWidth(width);
        Color color = RED.cpy().lerp(CHARTREUSE, player.health);
        healthBar.setColor(color);

        if (player.health == 0f) {
            // TODO: game over
        }
    }
}