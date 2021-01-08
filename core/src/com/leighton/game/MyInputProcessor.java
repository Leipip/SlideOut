package com.leighton.game;

import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {

    boolean touching =false;

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touching = false;
        return touching;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touching = true;
        return touching;
    }

}
