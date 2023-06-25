package com.epicness.endurtawer.game;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.epicness.endurtawer.game.logic.Debugger.debug;
import static com.epicness.endurtawer.game.logic.Debugger.onlyDebug;

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
        ScreenUtils.clear(BLACK);
        if (!onlyDebug) renderNormally();
        if (debug) renderDebug();
    }

    private void renderNormally() {
        spriteBatch.begin();
        stuff.getBase().draw(spriteBatch);
        stuff.getBackground().draw(spriteBatch);
        for (int i = 0; i < stuff.getGoodTentacles().size; i++) {
            stuff.getGoodTentacles().get(i).draw(shapeDrawer);
        }
        for (int i = 0; i < stuff.getEvilTentacles().size; i++) {
            stuff.getEvilTentacles().get(i).draw(shapeDrawer);
        }
        stuff.getPlayer().draw(spriteBatch);
        for (int i = 0; i < stuff.getBubbles().size; i++) {
            stuff.getBubbles().get(i).draw(spriteBatch);
        }
        spriteBatch.end();
    }

    private void renderDebug() {
        shapeRenderer.begin();
        stuff.getPlayer().drawDebug(shapeRenderer);
        for (int i = 0; i < stuff.getGoodTentacles().size; i++) {
            stuff.getGoodTentacles().get(i).drawDebug(shapeRenderer);
        }
        for (int i = 0; i < stuff.getEvilTentacles().size; i++) {
            stuff.getEvilTentacles().get(i).drawDebug(shapeRenderer);
        }
        shapeRenderer.end();
    }
}