package helpers;

/**
 * Created by Daniel on 08.01.2017.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameRenderer {

    public TextureAtlas atlas;
    private TextureRegion yellowStone;
    private TextureRegion redStone;
    private TextureRegion greenStone;
    private TextureRegion blueStone;
    private TextureRegion purpleStone;
    private TextureRegion brownStone;
    private TextureRegion greyStone;
    private TextureRegion bGStone;
    public TextureRegion fieldTexture;

    public GameRenderer(){
        atlas = new TextureAtlas(Gdx.files.internal("Stones.pack"));

        yellowStone = atlas.findRegion("Stone_yellow");
        redStone =  atlas.findRegion("Stone_red");
        greenStone = atlas.findRegion("Stone_green");
        blueStone = atlas.findRegion("Stone_blue");
        purpleStone = atlas.findRegion("Stone_purple");
        brownStone = atlas.findRegion("Stone_brown");
        greyStone = 	atlas.findRegion("Stone_grey");
        bGStone = atlas.findRegion("Stones_BGTile");

        fieldTexture = 	atlas.findRegion("Stones_background_field");
    }

    public void dispose(){
        atlas.dispose();
    }
}
