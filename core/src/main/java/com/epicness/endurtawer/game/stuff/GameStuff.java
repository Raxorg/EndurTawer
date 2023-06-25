package com.epicness.endurtawer.game.stuff;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.Stuff;

public class GameStuff extends Stuff<GameAssets> {

    private DelayedRemovalArray<LightTentacle> goodTentacles, evilTentacles;
    private Player player;

    @Override
    public void initializeStuff() {
        goodTentacles = new DelayedRemovalArray<>();
        evilTentacles = new DelayedRemovalArray<>();
        player = new Player(assets.getBushGlow(), assets.getFishGlow(), assets.getFish(), sharedAssets.getPixel());
    }

    public DelayedRemovalArray<LightTentacle> getGoodTentacles() {
        return goodTentacles;
    }

    public DelayedRemovalArray<LightTentacle> getEvilTentacles() {
        return evilTentacles;
    }

    public Player getPlayer() {
        return player;
    }
}