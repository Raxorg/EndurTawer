package com.epicness.endurtawer;

import com.badlogic.gdx.Game;
import com.epicness.endurtawer.game.GameInitializer;
import com.epicness.endurtawer.game.assets.GameAssets;
import com.epicness.fundamentals.SharedResources;

public class EndurTawerGame extends Game {

    @Override
    public void create() {
        GameAssets assets = new GameAssets();
        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initializeAssets();
        new GameInitializer(assets).initialize(new SharedResources());
    }
}