package com.epicness.endurtawer.game.logic;

import static com.badlogic.gdx.graphics.Color.CHARTREUSE;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HALF_WIDTH;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.stuff.LightTentacle;
import com.epicness.fundamentals.stuff.shapes.Tentacle;

public class TentacleMovementHandler extends GameLogicHandler {

    private DelayedRemovalArray<LightTentacle> tentacles;

    @Override
    protected void init() {
        tentacles = stuff.getTentacles();
        LightTentacle tentacle = new LightTentacle(WHITE, CHARTREUSE, sharedAssets, assets);
        tentacle.setPosition(CAMERA_HALF_WIDTH, CAMERA_HALF_HEIGHT);
        tentacle.lock();
        tentacles.add(tentacle);
    }

    public void update(float delta) {
        Vector2 target = stuff.getPlayer().getBackgroundCenter();
        for (int i = 0; i < tentacles.size; i++) {
            Tentacle tentacle = stuff.getTentacles().get(i);
            tentacle.follow(target);
            //tentacle.translateX(-100f * delta);
        }
    }

    public void toggleLock() {
        for (int i = 0; i < tentacles.size; i++) {
            stuff.getTentacles().get(i).toggleLock();
        }
    }
}