package com.epicness.endurtawer.game.stuff;

import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.endurtawer.game.constants.GameConstants.TENTACLE_END_WIDTH;
import static com.epicness.endurtawer.game.constants.GameConstants.TENTACLE_LIGHT_DIAMETER;
import static com.epicness.endurtawer.game.constants.GameConstants.TENTACLE_START_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.epicness.endurtawer.game.assets.GameAssets;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.shapes.Tentacle;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class LightTentacle extends Tentacle {

    private final DualSprited bush, light;

    public LightTentacle(int segments, float segmentLength, Color startColor, Color endColor,
                         SharedAssets sharedAssets, GameAssets assets) {
        super(segments, segmentLength, TENTACLE_START_WIDTH, TENTACLE_END_WIDTH, startColor, endColor);

        bush = new DualSprited(assets.getBushGlow(), assets.getBush());
        bush.setSize(150f);
        bush.setOriginCenter();
        bush.setColor(startColor);

        light = new DualSprited(assets.getBushGlow(), sharedAssets.getCircle());
        light.setBackgroundSize(80f);
        light.setForegroundSize(TENTACLE_LIGHT_DIAMETER);
        light.setOriginCenter();
        light.setColor(endColor.cpy().lerp(WHITE, 0.5f));
    }

    @Override
    public void draw(ShapeDrawer shapeDrawer) {
        SpriteBatch spriteBatch = (SpriteBatch) shapeDrawer.getBatch();
        super.draw(shapeDrawer);
        bush.draw(spriteBatch);
        light.draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(light.getForegroundCenterX(), light.getForegroundCenterY(), 5f);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        bush.setOriginBasedPosition(x, y);
        light.setPosition(x, y);
    }

    @Override
    public void translateX(float amount) {
        super.translateX(amount);
        bush.translateX(amount);
    }

    public DualSprited getLight() {
        return light;
    }
}