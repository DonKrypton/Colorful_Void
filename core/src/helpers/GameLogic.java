package helpers;

/**
 * Created by Daniel on 08.01.2017.
 */
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import elements.Field;
import elements.Stone;

public class GameLogic {
    Field field;

    Array<Stone> bag;
    int currentStoneIndex;
    Stone currentStone;

    // stone's bottom-left corner determines its position over field
    Vector2 stonePosition;

    public GameLogic(){
        // the bag that shuffles the 7 stones
        // no stone appaers twice until bag is emptied
        bag = new Array<Stone>();

        // create and put the 7 stones into bag
        for (int i = 1; i < 8; i++){
            Stone stone = new Stone(i);
            bag.add(stone);
        }

        // shuffle stones in bag
        bag.shuffle();
        currentStoneIndex = 0;
        currentStone = bag.first();
    }


    // the game loop. analyzes the field, registers input and updates accordingly
    public Field update(Field field){
        //this.field = field;

        /*untenstehende Logik geht nicht.
        * Muss immer beginnen mit : Kann Stein fallen?
        wenn ja, falle mit Tests, wenn Nein: ist game Over? Kann fixiert werden? */

        // to do: final lose condition is a check of complete stone (not just lowest row). if collision = lose.
        // normal movement only requires checking lowest row and/or left/right column

        // startposition of any stone
        stonePosition.x = 4;
        stonePosition.y = currentStone.getStone().length;

        // check for bottom movement
        if(stonePosition.y + 1 <= field.getField().length){   // still one field row left the stone could enter

            //check collisions of last stone row with bottom field row
        }

        if (currentStoneIndex < 7){  // already 7 stones used? reset
            currentStoneIndex++;
            currentStone = bag.get(currentStoneIndex);

        } else {					// not all 7 stones used yet
            currentStoneIndex = 0;
            bag.shuffle();
            currentStone = bag.first();
        }
        return field;
    }
}
