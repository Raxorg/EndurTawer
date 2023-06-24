package com.epicness.endurtawer.game.stuff;

import static com.epicness.endurtawer.game.constants.GameConstants.PLAYER_HEIGHT;
import static com.epicness.endurtawer.game.constants.GameConstants.PLAYER_WIDTH;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.shapes.Tentacle;

public class GameStuff extends Stuff<GameAssets> {

    private DelayedRemovalArray<LightTentacle> tentacles;
    private DualSprited player;

    @Override
    public void initializeStuff() {
        tentacles = new DelayedRemovalArray<>();

        player = new DualSprited(assets.getFishGlow(), assets.getFish());
        player.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
        player.setFlip(true, false);
    }

    public DelayedRemovalArray<LightTentacle> getTentacles() {
        return tentacles;
    }

    public DualSprited getPlayer() {
        return player;
    }
}