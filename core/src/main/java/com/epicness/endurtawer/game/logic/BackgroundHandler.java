package com.epicness.endurtawer.game.logic;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.GOLD;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.ROYAL;
import static com.badlogic.gdx.graphics.Color.SALMON;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.endurtawer.game.stuff.Player;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.utils.Random;

public class BackgroundHandler extends GameLogicHandler {

    private Sprited base;
    private DualSprited background;
    private Player player;
    private DelayedRemovalArray<Sprited> backMountains, frontMountains;
    private float backTime, frontTime, backSpawnTimer, frontSpawnTimer;

    @Override
    protected void init() {
        base = stuff.getBase();
        background = stuff.getBackground();
        player = stuff.getPlayer();

        backMountains = stuff.getBackMountains();
        backMountains.clear();

        frontMountains = stuff.getFrontMountains();
        frontMountains.clear();

        backSpawnTimer = MathUtils.random(2f, 10f);

        spawnBackMountain(0f);
        spawnBackMountain(CAMERA_WIDTH * 0.25f);
        spawnBackMountain(CAMERA_WIDTH * 0.5f);
        spawnBackMountain(CAMERA_WIDTH * 0.75f);
        for (int i = 0; i < 17; i++) {
            spawnFrontMountain(i * 100f);
        }
    }

    @Override
    public void update(float delta) {
        updateBackgroundColor();
        handleMountains(delta);
    }

    private void handleMountains(float delta) {
        backTime += delta;
        if (backTime >= backSpawnTimer) {
            spawnBackMountain(CAMERA_WIDTH);
            backSpawnTimer = MathUtils.random(2f, 10f);
            backTime = 0f;
        }
        frontTime += delta;
        if (frontTime >= frontSpawnTimer) {
            spawnFrontMountain(CAMERA_WIDTH);
            frontSpawnTimer = MathUtils.random(0.5f, 1f);
            frontTime = 0f;
        }
        moveMountains(backMountains, 25f, delta);
        moveMountains(frontMountains, 125f, delta);
    }

    private void spawnBackMountain(float x) {
        Sprited mountain = new Sprited(assets.getMountain());
        mountain.setX(x);
        mountain.setSize(MathUtils.random(125f, CAMERA_HEIGHT * 0.75f));
        mountain.setColor(Random.rainbowColor().cpy().lerp(BLACK, 0.5f));
        backMountains.add(mountain);
    }

    private void spawnFrontMountain(float x) {
        Sprited mountain = new Sprited(assets.getMountain2());
        mountain.setX(x);
        mountain.setSize(MathUtils.random(50f, 125f));
        mountain.setColor(Random.rainbowColor().cpy().lerp(BLACK, 0.8f));
        frontMountains.add(mountain);
    }

    private void moveMountains(DelayedRemovalArray<Sprited> mountains, float speed, float delta) {
        Sprited mountain;
        mountains.begin();
        for (int i = 0; i < mountains.size; i++) {
            mountain = mountains.get(i);
            mountain.translateX(-speed * delta);
            if (mountain.getX() <= -mountain.getWidth()) {
                mountains.removeValue(mountain, true);
            }
        }
        mountains.end();
    }

    private void updateBackgroundColor() {
        base.setColor(BLACK.cpy().lerp(GOLD, player.health));
        background.setBackgroundColor(RED.cpy().lerp(ROYAL, player.health));
        background.setForegroundColor(BLACK.cpy().lerp(SALMON, player.health));
    }
}