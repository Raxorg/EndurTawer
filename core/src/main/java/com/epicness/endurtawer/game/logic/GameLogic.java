package com.epicness.endurtawer.game.logic;

import com.epicness.endurtawer.game.logic.player.PlayerColorHandler;
import com.epicness.endurtawer.game.logic.player.PlayerHealthHandler;
import com.epicness.endurtawer.game.logic.player.PlayerMover;
import com.epicness.endurtawer.game.logic.player.PlayerTentacleInteractionHandler;
import com.epicness.endurtawer.game.logic.tentacles.TentacleLightHandler;
import com.epicness.endurtawer.game.logic.tentacles.TentacleMover;
import com.epicness.endurtawer.game.logic.tentacles.TentacleSpawner;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    // Player
    private final PlayerColorHandler playerColorHandler;
    private final PlayerHealthHandler playerHealthHandler;
    private final PlayerMover playerMover;
    private final PlayerTentacleInteractionHandler playerTentacleInteractionHandler;
    // Tentacles
    private final TentacleLightHandler tentacleLightHandler;
    private final TentacleMover tentacleMover;
    private final TentacleSpawner tentacleSpawner;

    public GameLogic() {
        registerHandler(new GameInputHandler());
        // Player
        registerHandler(playerColorHandler = new PlayerColorHandler());
        registerHandler(playerHealthHandler = new PlayerHealthHandler());
        registerHandler(playerMover = new PlayerMover());
        registerHandler(playerTentacleInteractionHandler = new PlayerTentacleInteractionHandler());
        // Tentacles
        registerHandler(tentacleLightHandler = new TentacleLightHandler());
        registerHandler(tentacleMover = new TentacleMover());
        registerHandler(tentacleSpawner = new TentacleSpawner());
    }

    @Override
    public void update(float delta) {
        // Player
        playerColorHandler.update(delta);
        playerHealthHandler.update();
        playerMover.update(delta);
        playerTentacleInteractionHandler.update(delta);
        // Tentacles
        tentacleLightHandler.update();
        tentacleMover.update(delta);
        tentacleSpawner.update(delta);
    }
}