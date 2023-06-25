package com.epicness.endurtawer.game.logic.tentacles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.logic.GameLogicHandler;
import com.epicness.endurtawer.game.stuff.LightTentacle;

public class TentacleLightHandler extends GameLogicHandler {

    private DelayedRemovalArray<LightTentacle> goodTentacles, evilTentacles;

    @Override
    protected void init() {
        goodTentacles = stuff.getGoodTentacles();
        evilTentacles = stuff.getEvilTentacles();
    }

    public void update() {
        updateLights(goodTentacles);
        updateLights(evilTentacles);
    }

    private void updateLights(DelayedRemovalArray<LightTentacle> tentacles) {
        LightTentacle tentacle;
        Vector2 position;
        for (int i = 0; i < tentacles.size; i++) {
            tentacle = tentacles.get(i);
            position = tentacle.getLastLine().getB();
            tentacle.getLight().setOriginBasedPosition(position.x, position.y);
        }
    }
}