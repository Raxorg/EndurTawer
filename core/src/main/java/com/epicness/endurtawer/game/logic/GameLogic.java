package com.epicness.endurtawer.game.logic;

import com.epicness.endurtawer.game.logic.player.PlayerColorHandler;
import com.epicness.endurtawer.game.logic.player.PlayerHealthHandler;
import com.epicness.endurtawer.game.logic.player.PlayerMover;
import com.epicness.endurtawer.game.logic.player.PlayerTentacleInteractionHandler;
import com.epicness.endurtawer.game.logic.tentacles.TentacleLightHandler;
import com.epicness.endurtawer.game.logic.tentacles.TentacleTranslator;
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
    private final TentacleSpawner tentacleSpawner;
    private final TentacleTranslator tentacleTranslator;
    // Other
    private final BackgroundHandler backgroundHandler;
    private final BubbleHandler bubbleHandler;

    public GameLogic() {
        registerHandler(new GameInputHandler());
        // Player
        registerHandler(playerColorHandler = new PlayerColorHandler());
        registerHandler(playerHealthHandler = new PlayerHealthHandler());
        registerHandler(playerMover = new PlayerMover());
        registerHandler(playerTentacleInteractionHandler = new PlayerTentacleInteractionHandler());
        // Tentacles
        registerHandler(tentacleLightHandler = new TentacleLightHandler());
        registerHandler(tentacleSpawner = new TentacleSpawner());
        registerHandler(tentacleTranslator = new TentacleTranslator());
        // Other
        registerHandler(backgroundHandler = new BackgroundHandler());
        registerHandler(bubbleHandler = new BubbleHandler());
        registerHandler(new Debugger());
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
        tentacleSpawner.update(delta);
        tentacleTranslator.update(delta);
        // Other
        backgroundHandler.update();
        bubbleHandler.update(delta);
    }
}