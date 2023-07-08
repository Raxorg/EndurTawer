package com.epicness.endurtawer.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

public class GameAssetPaths {

    static final List<AssetDescriptor<?>> ASSETS;
    // Fonts
    public static final AssetDescriptor<BitmapFont> TIMES_SQUARE;
    // Music
    public static final AssetDescriptor<Music> MUSIC_1;
    public static final AssetDescriptor<Music> MUSIC_2;
    // Sprites
    public static final AssetDescriptor<Sprite> FISH;
    public static final AssetDescriptor<Sprite> FISH_GLOW;
    public static final AssetDescriptor<Sprite> BUSH;
    public static final AssetDescriptor<Sprite> BUSH_GLOW;
    public static final AssetDescriptor<Sprite> TOP_BG;
    public static final AssetDescriptor<Sprite> BOTTOM_BG;
    public static final AssetDescriptor<Sprite> BUBBLE;
    public static final AssetDescriptor<Sprite> MOUNTAIN;
    public static final AssetDescriptor<Sprite> MOUNTAIN_2;

    static {
        ASSETS = new ArrayList<>();
        // Fonts
        ASSETS.add(TIMES_SQUARE = new AssetDescriptor<>("endurtawer/game/fonts/timesSquare.fnt", BitmapFont.class));
        // Music
        ASSETS.add(MUSIC_1 = new AssetDescriptor<>("endurtawer/game/music/intoTheUnknown.ogg", Music.class));
        ASSETS.add(MUSIC_2 = new AssetDescriptor<>("endurtawer/game/music/salutations.ogg", Music.class));
        // Sprites
        ASSETS.add(FISH = new AssetDescriptor<>("endurtawer/game/images/fish.png", Sprite.class));
        ASSETS.add(FISH_GLOW = new AssetDescriptor<>("endurtawer/game/images/fishGlow.png", Sprite.class));
        ASSETS.add(BUSH = new AssetDescriptor<>("endurtawer/game/images/bush.png", Sprite.class));
        ASSETS.add(BUSH_GLOW = new AssetDescriptor<>("endurtawer/game/images/bushGlow.png", Sprite.class));
        ASSETS.add(TOP_BG = new AssetDescriptor<>("endurtawer/game/images/topBG.png", Sprite.class));
        ASSETS.add(BOTTOM_BG = new AssetDescriptor<>("endurtawer/game/images/bottomBG.png", Sprite.class));
        ASSETS.add(BUBBLE = new AssetDescriptor<>("endurtawer/game/images/bubble.png", Sprite.class));
        ASSETS.add(MOUNTAIN = new AssetDescriptor<>("endurtawer/game/images/mountain.png", Sprite.class));
        ASSETS.add(MOUNTAIN_2 = new AssetDescriptor<>("endurtawer/game/images/mountain2.png", Sprite.class));
    }
}