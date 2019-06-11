package com.libgdx.spaceshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class InputManager implements InputProcessor {

    public boolean keyRight = false;
    public boolean keyLeft = false;
    public boolean keyUp = false;
    public boolean keyDown = false;
    public boolean keyShootN = false;
    public boolean keyShootS = false;
    public Vector3 pointBut = null;



    public boolean keyDown (int keycode) {

        switch(keycode)
        {
            case Input.Keys.D: keyRight = true;
                break;
            case Input.Keys.A: keyLeft = true;
                break;
            case Input.Keys.W: keyUp = true;
                break;
            case Input.Keys.S: keyDown  = true;
                break;
            case Input.Keys.SPACE: keyShootN = true;
                break;
            case Input.Keys.SHIFT_LEFT: keyShootS = true;
                break;
        }



        return true;
    }

    public boolean keyUp (int keycode) {

        switch(keycode)
        {
            case Input.Keys.D: keyRight = false;
                break;
            case Input.Keys.A: keyLeft = false;
                break;
            case Input.Keys.W: keyUp = false;
                break;
            case Input.Keys.S: keyDown  = false;
                break;
            case Input.Keys.SPACE: keyShootN = false;
                break;
            case Input.Keys.SHIFT_LEFT: keyShootS = false;
                break;
        }

        return true;
    }

    public boolean keyTyped (char character) {
        return false;
    }

    public boolean touchDown (int x, int y, int pointer, int button) {

        pointBut = new Vector3(x,y,0);
        //check if the click is for the HUD
        if(MAIN_GAME.instance.getScreen() == MAIN_GAME.instance.menuScreen)
        {
            MenuController.instance.ch.hudCamera.unproject(pointBut);
            if (!MenuController.instance.hud.click(pointBut.x, pointBut.y))
            {
                System.out.println("CLICC");
            }
        }
        else {

            WorldController.instance.ch.hudCamera.unproject(pointBut);
            if (!WorldController.instance.hud.click(pointBut.x, pointBut.y))
            {
                System.out.println("CLICC");
            }
        }
        return true;
    }

    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        return false;
    }

    public boolean scrolled (int amount) {
        return false;
    }
}
