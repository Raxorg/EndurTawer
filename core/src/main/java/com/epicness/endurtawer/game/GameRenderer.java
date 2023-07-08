package com.epicness.endurtawer.game;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.epicness.endurtawer.game.logic.Debugger.debug;
import static com.epicness.endurtawer.game.logic.Debugger.onlyDebug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.endurtawer.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class GameRenderer extends Renderer<GameStuff> {

    private final ShapeDrawer shapeDrawer;
    private final ShaderProgram shader;
    private float time;
    private final SpriteBatch spriteBatch2;

    public GameRenderer() {
        TextureRegion pixel = new TextureRegion(new Texture("fundamentals/images/pixel.png"));
        shapeDrawer = new ShapeDrawer(spriteBatch, pixel);

        ShaderProgram.pedantic = false;
        shader = new ShaderProgram(
                Gdx.files.internal("endurtawer/game/underwater.glsl"),
                Gdx.files.internal("endurtawer/game/fragment.glsl"));
        if (!shader.isCompiled()) {
            Gdx.app.error("SHADER", shader.getLog());
        }
        spriteBatch.setShader(shader);

        spriteBatch2 = new SpriteBatch();
    }

    @Override
    public void useStaticCamera() {
        super.useStaticCamera();
        spriteBatch2.setProjectionMatrix(screen.getStaticCamera().combined);
    }

    @Override
    public void render() {
        ScreenUtils.clear(BLACK);
        if (!onlyDebug) renderNormally();
        if (debug) renderDebug();
    }

    private void renderNormally() {
        time += Gdx.graphics.getDeltaTime();

        shader.bind();
        shader.setUniformf("u_time", time);

        spriteBatch2.begin();
        stuff.getBase().draw(spriteBatch2);
        stuff.getBackground().draw(spriteBatch2);
        spriteBatch2.end();

        spriteBatch.begin();
        for (int i = 0; i < stuff.getBackMountains().size; i++) {
            stuff.getBackMountains().get(i).draw(spriteBatch);
        }
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

        spriteBatch2.begin();
        for (int i = 0; i < stuff.getFrontMountains().size; i++) {
            stuff.getFrontMountains().get(i).draw(spriteBatch2);
            stuff.getHealthBar().draw(spriteBatch2);
        }
        stuff.getScore().draw(spriteBatch2);
        spriteBatch2.end();
    }

    private void renderDebug() {
        shapeBatch.begin();
        stuff.getPlayer().drawDebug(shapeBatch);
        for (int i = 0; i < stuff.getGoodTentacles().size; i++) {
            stuff.getGoodTentacles().get(i).drawDebug(shapeBatch);
        }
        for (int i = 0; i < stuff.getEvilTentacles().size; i++) {
            stuff.getEvilTentacles().get(i).drawDebug(shapeBatch);
        }
        shapeBatch.end();
    }
}