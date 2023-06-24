package com.epicness.endurtawer.game.logic;

import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final PlayerMovementHandler playerMovementHandler;
    private final TentacleMovementHandler tentacleMovementHandler;

    public GameLogic() {
        registerHandler(new GameInputHandler());
        registerHandler(playerMovementHandler = new PlayerMovementHandler());
        registerHandler(tentacleMovementHandler = new TentacleMovementHandler());
    }

    @Override
    public void update(float delta) {
        playerMovementHandler.update(delta);
        tentacleMovementHandler.update(delta);
    }
}