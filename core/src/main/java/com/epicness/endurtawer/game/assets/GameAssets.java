package com.epicness.endurtawer.game.assets;

import static com.epicness.endurtawer.game.assets.GameAssetPaths.ASSETS;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.BOTTOM_BG;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.BUBBLE;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.BUSH;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.BUSH_GLOW;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.FISH;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.FISH_GLOW;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.MOUNTAIN;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.TOP_BG;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    private Sprite fish, fishGlow, bush, bushGlow, topBG, bottomBG, bubble, mountain;

    public GameAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        fish = get(FISH);
        fishGlow = get(FISH_GLOW);
        bush = get(BUSH);
        bushGlow = get(BUSH_GLOW);
        topBG = get(TOP_BG);
        bottomBG = get(BOTTOM_BG);
        bubble = get(BUBBLE);
        mountain = get(MOUNTAIN);
    }

    public Sprite getFish() {
        return fish;
    }

    public Sprite getFishGlow() {
        return fishGlow;
    }

    public Sprite getBush() {
        return bush;
    }

    public Sprite getBushGlow() {
        return bushGlow;
    }

    public Sprite getTopBG() {
        return topBG;
    }

    public Sprite getBottomBG() {
        return bottomBG;
    }

    public Sprite getBubble() {
        return bubble;
    }

    public Sprite getMountain() {
        return mountain;
    }
}