package com.epicness.endurtawer.game;

import static com.badlogic.gdx.graphics.Color.NAVY;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.endurtawer.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class GameRenderer extends Renderer<GameStuff> {

    private final ShapeDrawer shapeDrawer;

    public GameRenderer() {
        TextureRegion pixel = new TextureRegion(new Texture("fundamentals/images/pixel.png"));
        shapeDrawer = new ShapeDrawer(spriteBatch, pixel);
    }

    @Override
    public void render() {
        ScreenUtils.clear(NAVY);
        spriteBatch.begin();
        for (int i = 0; i < stuff.getTentacles().size; i++) {
            stuff.getTentacles().get(i).draw(shapeDrawer);
        }
        stuff.getPlayer().draw(spriteBatch);
        spriteBatch.end();
    }
}