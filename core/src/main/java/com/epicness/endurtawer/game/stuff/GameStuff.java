package com.epicness.endurtawer.game.stuff;

import static com.badlogic.gdx.utils.Align.center;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;

public class GameStuff extends Stuff<GameAssets> {

    private Sprited base;
    private DualSprited background;
    private DelayedRemovalArray<Sprited> backMountains, frontMountains;
    private DelayedRemovalArray<LightTentacle> goodTentacles, evilTentacles;
    private Player player;
    private Sprited healthBar;
    private DelayedRemovalArray<Sprited> bubbles;
    private Text score;

    @Override
    public void initializeStuff() {
        base = new Sprited(sharedAssets.getPixel());
        base.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        background = new DualSprited(assets.getTopBG(), assets.getBottomBG());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        backMountains = new DelayedRemovalArray<>();
        frontMountains = new DelayedRemovalArray<>();
        goodTentacles = new DelayedRemovalArray<>();
        evilTentacles = new DelayedRemovalArray<>();
        player = new Player(assets.getBushGlow(), assets.getFishGlow(), assets.getFish());

        healthBar = new Sprited(sharedAssets.getPixel());
        healthBar.setHeight(5f);

        bubbles = new DelayedRemovalArray<>();

        assets.getTimesSquare().getData().setScale(1.8f);
        score = new Text(assets.getTimesSquare());
        score.setTextTargetWidth(CAMERA_WIDTH);
        score.setHorizontalAlignment(center);
        score.setCenterVertical(true);
        score.setY(CAMERA_HALF_HEIGHT);
    }

    public Sprited getBase() {
        return base;
    }

    public DualSprited getBackground() {
        return background;
    }

    public DelayedRemovalArray<Sprited> getBackMountains() {
        return backMountains;
    }

    public DelayedRemovalArray<Sprited> getFrontMountains() {
        return frontMountains;
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

    public Sprited getHealthBar() {
        return healthBar;
    }

    public DelayedRemovalArray<Sprited> getBubbles() {
        return bubbles;
    }

    public Text getScore() {
        return score;
    }
}