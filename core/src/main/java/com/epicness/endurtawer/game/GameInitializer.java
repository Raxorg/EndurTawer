package com.epicness.endurtawer.game;

import com.epicness.endurtawer.game.assets.GameAssets;
import com.epicness.endurtawer.game.logic.GameLogic;
import com.epicness.endurtawer.game.stuff.GameStuff;
import com.epicness.fundamentals.initializer.Initializer;

public class GameInitializer extends Initializer<GameAssets, GameRenderer, GameStuff> {

    public GameInitializer(GameAssets assets) {
        super(assets, new GameLogic(), new GameRenderer(), new GameStuff());
    }
}
