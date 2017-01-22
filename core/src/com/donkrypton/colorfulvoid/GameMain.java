package com.donkrypton.colorfulvoid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import helpers.Constants;
import screens.GameScreen;


public class GameMain extends Game {
    public SpriteBatch batch;
    public OrthographicCamera mainCamera;
    public Viewport gameViewport;

    @Override
    public void create() {
        batch = new SpriteBatch();

        mainCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());         // camera is always as big as current screen
        mainCamera.position.set(Constants.WORLD_WIDTH  * 0.5f, Constants.WORLD_HEIGHT  * 0.5f, 0);  // camera looks at quarter with positive x and y values

        gameViewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),mainCamera);  // images stretch with device resolution

        setScreen(new GameScreen(this));
    }

    @Override
    public void dispose() {

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
