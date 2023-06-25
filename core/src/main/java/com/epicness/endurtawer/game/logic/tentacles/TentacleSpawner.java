package com.epicness.endurtawer.game.logic.tentacles;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.CHARTREUSE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.endurtawer.game.constants.GameConstants.EVIL_SEGMENT_LENGTH;
import static com.epicness.endurtawer.game.constants.GameConstants.EVIL_TENTACLE_SEGMENTS;
import static com.epicness.endurtawer.game.constants.GameConstants.GOOD_SEGMENT_LENGTH;
import static com.epicness.endurtawer.game.constants.GameConstants.GOOD_TENTACLE_SEGMENTS;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.logic.GameLogicHandler;
import com.epicness.endurtawer.game.stuff.LightTentacle;

public class TentacleSpawner extends GameLogicHandler {

    private DelayedRemovalArray<LightTentacle> goodTentacles, evilTentacles;
    private float goodTimer, evilTimer;

    @Override
    protected void init() {
        goodTentacles = stuff.getGoodTentacles();
        evilTentacles = stuff.getEvilTentacles();
    }

    public void update(float delta) {
        goodTimer += delta;
        if (goodTimer >= 4f) {
            spawnGoodTentacle();
            goodTimer = 0f;
        }
        evilTimer += delta;
        if (evilTimer >= 3f) {
            spawnEvilTentacle();
            evilTimer = 0f;
        }
    }

    public void spawnGoodTentacle() {
        float random = MathUtils.random(0.5f);
        Color color = CHARTREUSE.cpy().lerp(WHITE, random);
        goodTentacles.add(spawnTentacle(GOOD_TENTACLE_SEGMENTS, GOOD_SEGMENT_LENGTH, WHITE, color));
    }

    public void spawnEvilTentacle() {
        float random = MathUtils.random(0.5f);
        Color color = RED.cpy().lerp(BLACK, random);
        evilTentacles.add(spawnTentacle(EVIL_TENTACLE_SEGMENTS, EVIL_SEGMENT_LENGTH, BLACK, color));
    }

    private LightTentacle spawnTentacle(int segments, float segmentLength, Color startColor, Color endColor) {
        LightTentacle tentacle = new LightTentacle(segments, segmentLength, startColor, endColor, sharedAssets, assets);
        tentacle.setPosition(CAMERA_WIDTH * 1.5f, MathUtils.random(CAMERA_HEIGHT));
        tentacle.lock();
        return tentacle;
    }
}