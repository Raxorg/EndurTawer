package com.epicness.endurtawer.game.stuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;

public class GameStuff extends Stuff<GameAssets> {

    private Sprited base;
    private DualSprited background;
    private DelayedRemovalArray<LightTentacle> goodTentacles, evilTentacles;
    private Player player;
    private DelayedRemovalArray<Sprited> bubbles;

    @Override
    public void initializeStuff() {
        base = new Sprited(sharedAssets.getPixel());
        base.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        background = new DualSprited(assets.getTopBG(), assets.getBottomBG());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        goodTentacles = new DelayedRemovalArray<>();
        evilTentacles = new DelayedRemovalArray<>();
        player = new Player(assets.getBushGlow(), assets.getFishGlow(), assets.getFish(), sharedAssets.getPixel());
        bubbles = new DelayedRemovalArray<>();
    }

    public Sprited getBase() {
        return base;
    }

    public DualSprited getBackground() {
        return background;
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

    public DelayedRemovalArray<Sprited> getBubbles() {
        return bubbles;
    }
}