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

    static {
        ASSETS = new ArrayList<>();
        ASSETS.add(FISH = new AssetDescriptor<>("endurtawer/game/fish.png", Sprite.class));
        ASSETS.add(FISH_GLOW = new AssetDescriptor<>("endurtawer/game/fishGlow.png", Sprite.class));
        ASSETS.add(BUSH = new AssetDescriptor<>("endurtawer/game/bush.png", Sprite.class));
        ASSETS.add(BUSH_GLOW = new AssetDescriptor<>("endurtawer/game/bushGlow.png", Sprite.class));
    }
}