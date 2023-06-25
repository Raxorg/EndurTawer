package com.epicness.endurtawer.game.stuff;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.endurtawer.game.constants.GameConstants.PLAYER_HEIGHT;
import static com.epicness.endurtawer.game.constants.GameConstants.PLAYER_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;

public class Player {

    private final Sprited glow;
    private final DualSprited fish;
    private final Sprited healthBar;
    public float health;

    public Player(Sprite glowSprite, Sprite fishGlowSprite, Sprite fishSprite, Sprite pixel) {
        fish = new DualSprited(fishGlowSprite, fishSprite);
        fish.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
        fish.setOriginCenter();
        fish.setFlip(true, false);

        glow = new Sprited(glowSprite);
        glow.setOriginCenter();
        glow.setOriginBasedPosition(PLAYER_WIDTH / 2f, PLAYER_HEIGHT / 2f);

        healthBar = new Sprited(pixel);
        healthBar.setHeight(5f);

        health = 1f;
    }

    public void draw(SpriteBatch spriteBatch) {
        glow.draw(spriteBatch);
        fish.draw(spriteBatch);
        healthBar.draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(getCenter().x, getCenter().y, 5f);
    }

    public float getX() {
        return fish.getX();
    }

    public float getY() {
        return fish.getY();
    }

    public void setY(float y) {
        glow.setY(y);
        fish.setY(y);
    }

    public void setOriginBasedPosition(Vector2 position) {
        fish.setOriginBasedPosition(position);
        glow.setOriginBasedPosition(position);
    }

    public void translate(Vector2 amount) {
        fish.translate(amount);
        glow.translate(amount);
    }

    public Vector2 getCenter() {
        return glow.getCenter();
    }

    public void setColor(Color color) {
        glow.setColor(color.cpy().lerp(WHITE, 0.25f).lerp(CLEAR, 0.5f));
        fish.setColor(color);
    }

    public Sprited getHealthBar() {
        return healthBar;
    }
}