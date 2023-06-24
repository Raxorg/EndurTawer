package com.epicness.endurtawer.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.stuff.LightTentacle;

public class TentacleLightHandler extends GameLogicHandler {

    DelayedRemovalArray<LightTentacle> tentacles;

    @Override
    protected void init() {
        tentacles = stuff.getTentacles();
    }

    public void update() {
        for (int i = 0; i < tentacles.size; i++) {
            LightTentacle tentacle = tentacles.get(i);
            Vector2 position = tentacle.getLastLine().getPosition();
            tentacle.getLight().setPosition(position);
        }
    }
}