package screens;

/**
 * Created by Daniel on 08.01.2017.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.donkrypton.colorfulvoid.GameMain;
import elements.Field;
import helpers.GameInput;
import helpers.GameLogic;
import helpers.GameRenderer;


public class GameScreen implements Screen{

    private GameMain game;
    private Field field;
    private GameLogic logic;
    private GameRenderer renderer;
    private GameInput input;

    public GameScreen(GameMain game) {
        this.game = game;
        this.field = new Field();
        //logic = new GameLogic();
        renderer = new GameRenderer();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
       // field = logic.update(field);
        game.batch.setProjectionMatrix(game.mainCamera.combined);
        game.mainCamera.update();

        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        renderer.gameBackground.draw(game.batch);
        game.batch.end();


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

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
