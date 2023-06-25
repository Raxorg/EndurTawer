package com.epicness.endurtawer.game.logic.player;

import static com.epicness.endurtawer.game.constants.GameConstants.PLAYER_WIDTH;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.logic.GameLogicHandler;
import com.epicness.endurtawer.game.stuff.LightTentacle;
import com.epicness.endurtawer.game.stuff.Player;
import com.epicness.fundamentals.stuff.DualSprited;

public class PlayerTentacleInteractionHandler extends GameLogicHandler {

    private DelayedRemovalArray<LightTentacle> goodTentacles, evilTentacles;
    private Player player;

    @Override
    protected void init() {
        goodTentacles = stuff.getGoodTentacles();
        evilTentacles = stuff.getEvilTentacles();
        player = stuff.getPlayer();
    }

    public void update(float delta) {
        if (colliding(goodTentacles)) player.health += delta / 3f;
        if (colliding(evilTentacles)) player.health -= delta / 2f;
    }

    private boolean colliding(DelayedRemovalArray<LightTentacle> tentacles) {
        LightTentacle tentacle;
        DualSprited light;
        for (int i = 0; i < tentacles.size; i++) {
            tentacle = tentacles.get(i);
            light = tentacle.getLight();
            if (player.getCenter().dst(light.getForegroundCenter()) <= PLAYER_WIDTH / 2f) {
                return true;
            }
        }
        return false;
    }
}