package com.epicness.endurtawer.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.utils.Random;

public class BubbleHandler extends GameLogicHandler {

    private DelayedRemovalArray<Sprited> bubbles;
    private float timer1, timer2;

    @Override
    protected void init() {
        bubbles = stuff.getBubbles();
        bubbles.clear();
    }

    @Override
    protected void update(float delta) {
        handleBubbleSpawning(delta);
        moveBubbles(delta);
    }

    private void handleBubbleSpawning(float delta) {
        timer1 += delta;
        timer2 += delta;
        if (timer1 >= 0.1f) {
            bubbles.add(spawnBubble(25f));
            timer1 = 0f;
        }
        if (timer2 >= 1f) {
            bubbles.add(spawnBubble(75f));
            timer2 = 0f;
        }
    }

    private Sprited spawnBubble(float size) {
        Sprited bubble = new Sprited(assets.getBubble());
        bubble.setSize(size);
        bubble.setPosition(MathUtils.random(CAMERA_WIDTH - size), -size);
        bubble.setColor(Random.rainbowColor().cpy().lerp(CLEAR, 0.5f));
        return bubble;
    }

    private void moveBubbles(float delta) {
        Sprited bubble;
        bubbles.begin();
        for (int i = 0; i < bubbles.size; i++) {
            bubble = bubbles.get(i);
            float sizeFactor = MathUtils.map(25f, 75f, 1f, 0.5f, bubble.getWidth());
            float heightFactor = MathUtils.map(0f, CAMERA_HEIGHT, 1f, 10f, bubble.getY());
            float speed = 50f * delta * sizeFactor * heightFactor;
            bubble.translateY(speed);
            if (bubble.getY() >= CAMERA_HEIGHT) {
                bubbles.removeValue(bubble, true);
            }
        }
        bubbles.end();
    }
}