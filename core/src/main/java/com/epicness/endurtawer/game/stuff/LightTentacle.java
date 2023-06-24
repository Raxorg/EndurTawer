package com.epicness.endurtawer.game.stuff;

import static com.epicness.endurtawer.game.constants.GameConstants.TENTACLE_END_WIDTH;
import static com.epicness.endurtawer.game.constants.GameConstants.TENTACLE_SEGMENTS;
import static com.epicness.endurtawer.game.constants.GameConstants.TENTACLE_SEGMENT_LENGTH;
import static com.epicness.endurtawer.game.constants.GameConstants.TENTACLE_START_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.endurtawer.game.assets.GameAssets;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.shapes.Tentacle;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class LightTentacle extends Tentacle {

    private final DualSprited bush, light;

    public LightTentacle(Color startColor, Color endColor, SharedAssets sharedAssets, GameAssets assets) {
        super(TENTACLE_SEGMENTS, TENTACLE_SEGMENT_LENGTH, TENTACLE_START_WIDTH, TENTACLE_END_WIDTH, startColor, endColor);
        bush = new DualSprited(assets.getBushGlow(), assets.getBush());
        light = new DualSprited(sharedAssets.getGlow(), sharedAssets.getCircle());
    }

    @Override
    public void draw(ShapeDrawer shapeDrawer) {
        SpriteBatch spriteBatch = (SpriteBatch) shapeDrawer.getBatch();
        super.draw(shapeDrawer);
        bush.draw(spriteBatch);
        light.draw(spriteBatch);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        bush.setPosition(x, y);
    }

    public DualSprited getBush() {
        return bush;
    }

    public DualSprited getLight() {
        return light;
    }
}