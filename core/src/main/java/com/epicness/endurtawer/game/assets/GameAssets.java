package com.epicness.endurtawer.game.assets;

import static com.epicness.endurtawer.game.assets.GameAssetPaths.ASSETS;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.BOTTOM_BG;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.BUBBLE;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.BUSH;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.BUSH_GLOW;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.FISH;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.FISH_GLOW;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.MOUNTAIN;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.MOUNTAIN_2;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.MUSIC_1;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.MUSIC_2;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.TIMES_SQUARE;
import static com.epicness.endurtawer.game.assets.GameAssetPaths.TOP_BG;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    private BitmapFont timesSquare;
    private Music music1, music2;
    private Sprite fish, fishGlow, bush, bushGlow, topBG, bottomBG, bubble, mountain, mountain2;

    public GameAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        // Fonts
        timesSquare = get(TIMES_SQUARE);
        // Music
        music1 = get(MUSIC_1);
        music2 = get(MUSIC_2);
        // Sprites
        fish = get(FISH);
        fishGlow = get(FISH_GLOW);
        bush = get(BUSH);
        bushGlow = get(BUSH_GLOW);
        topBG = get(TOP_BG);
        bottomBG = get(BOTTOM_BG);
        bubble = get(BUBBLE);
        mountain = get(MOUNTAIN);
        mountain2 = get(MOUNTAIN_2);
    }

    // Fonts
    public BitmapFont getTimesSquare() {
        return timesSquare;
    }

    // Music
    public Music getMusic1() {
        return music1;
    }

    public Music getMusic2() {
        return music2;
    }

    // Sprites
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

    public Sprite getMountain2() {
        return mountain2;
    }
}