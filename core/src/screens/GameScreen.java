package screens;

/**
 * Created by Daniel on 08.01.2017.
 */
import com.badlogic.gdx.Screen;
import com.donkrypton.colorfulvoid.GameMain;
import elements.Field;
import helpers.GameLogic;
import helpers.GameRenderer;


public class GameScreen implements Screen{

    private GameMain game;
    private Field field;
    private GameLogic logic;
    private GameRenderer renderer;

    public GameScreen(GameMain game) {
        this.game = game;
        this.field = new Field();
        logic = new GameLogic();
        renderer = new GameRenderer();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
       // field = logic.update(field);

        game.batch.begin();
        game.batch.draw(renderer.fieldTexture, 0, 0);
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
        dispose();
    }

    @Override
    public void dispose() {
        renderer.atlas.dispose();
        game.dispose();
    }
}
