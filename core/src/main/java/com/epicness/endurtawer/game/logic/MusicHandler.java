package com.epicness.endurtawer.game.logic;

import com.badlogic.gdx.audio.Music;

public class MusicHandler extends GameLogicHandler {

    private boolean music1;

    @Override
    protected void init() {
        checkMusic();
    }

    private void checkMusic() {
        if (assets.getMusic1().isPlaying() || assets.getMusic2().isPlaying()) return;
        assets.getMusic1().setVolume(0.5f);
        assets.getMusic1().play();
        music1 = true;
    }

    @Override
    protected void update() {
        if (assets.getMusic1().isPlaying() || assets.getMusic2().isPlaying()) {
            return;
        }
        music1 = !music1;
        Music music = music1 ? assets.getMusic1() : assets.getMusic2();
        music.setVolume(0.5f);
        music.play();
    }

    public void touchDown() {
        checkMusic();
    }

    public void keyDown() {
        checkMusic();
    }
}