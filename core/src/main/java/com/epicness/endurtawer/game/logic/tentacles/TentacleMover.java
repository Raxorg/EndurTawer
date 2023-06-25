package com.epicness.endurtawer.game.logic.tentacles;

import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.logic.GameLogicHandler;
import com.epicness.endurtawer.game.stuff.LightTentacle;
import com.epicness.endurtawer.game.stuff.Player;

public class TentacleMover extends GameLogicHandler {

    private DelayedRemovalArray<LightTentacle> goodTentacles, evilTentacles;
    private Player player;

    @Override
    protected void init() {
        goodTentacles = stuff.getGoodTentacles();
        evilTentacles = stuff.getEvilTentacles();
        player = stuff.getPlayer();
    }

    public void update(float delta) {
        moveTentacles(goodTentacles, delta);
        moveTentacles(evilTentacles, delta);
    }

    private void moveTentacles(DelayedRemovalArray<LightTentacle> tentacles, float delta) {
        Vector2 target = player.getCenter();
        LightTentacle tentacle;
        tentacles.begin();
        for (int i = 0; i < tentacles.size; i++) {
            tentacle = tentacles.get(i);
            tentacle.follow(target);
            tentacle.translateX(-100f * delta);
            if (tentacle.getX() <= -CAMERA_WIDTH / 2f) {
                tentacles.removeValue(tentacle, true);
            }
        }
        tentacles.end();
    }
}