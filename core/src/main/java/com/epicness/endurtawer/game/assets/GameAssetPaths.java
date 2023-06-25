package com.epicness.endurtawer.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.AssetPaths;

import java.util.ArrayList;
import java.util.List;

public class GameAssetPaths extends AssetPaths {

    static final List<AssetDescriptor<?>> ASSETS;
    public static final AssetDescriptor<Sprite> FISH;
    public static final AssetDescriptor<Sprite> FISH_GLOW;
    public static final AssetDescriptor<Sprite> BUSH;
    public static final AssetDescriptor<Sprite> BUSH_GLOW;
    public static final AssetDescriptor<Sprite> TOP_BG;
    public static final AssetDescriptor<Sprite> BOTTOM_BG;
    public static final AssetDescriptor<Sprite> BUBBLE;
    public static final AssetDescriptor<Sprite> MOUNTAIN;

    static {
        ASSETS = new ArrayList<>();
        ASSETS.add(FISH = new AssetDescriptor<>("endurtawer/game/fish.png", Sprite.class));
        ASSETS.add(FISH_GLOW = new AssetDescriptor<>("endurtawer/game/fishGlow.png", Sprite.class));
        ASSETS.add(BUSH = new AssetDescriptor<>("endurtawer/game/bush.png", Sprite.class));
        ASSETS.add(BUSH_GLOW = new AssetDescriptor<>("endurtawer/game/bushGlow.png", Sprite.class));
        ASSETS.add(TOP_BG = new AssetDescriptor<>("endurtawer/game/topBG.png", Sprite.class));
        ASSETS.add(BOTTOM_BG = new AssetDescriptor<>("endurtawer/game/bottomBG.png", Sprite.class));
        ASSETS.add(BUBBLE = new AssetDescriptor<>("endurtawer/game/bubble.png", Sprite.class));
        ASSETS.add(MOUNTAIN = new AssetDescriptor<>("endurtawer/game/mountain.png", Sprite.class));
    }
}