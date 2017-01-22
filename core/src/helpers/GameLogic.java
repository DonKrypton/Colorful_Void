package helpers;

/**
 * Created by Daniel on 08.01.2017.
 */
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import elements.Field;
import elements.Stone;

public class GameLogic {

    //Field field;
    Array<Stone> bag;  // the shuffling bag of 7 stones, a FIFO queue
    private int StoneIndex; // current Stone's position from bag
    private Stone currentStone;        // current Stone Object on field
    private Vector2 startPosition = new Vector2 (3,0);   // where all new stones appear on the field


    public GameLogic() {
        // the bag that shuffles the 7 stones, no stone shall appear twice until bag was emptied
        bag = new Array<Stone>();
        bag.setSize(7);

        // create and put the 7 stones into bag
        for (int i = 0; i < bag.size; i++){
            Stone stone = new Stone(i+1);
            bag.add(stone);
        }

        // shuffle stones in bag
        bag.shuffle();
        StoneIndex = 0; // we look on the first stone in bag's queue
    }


    // the game loop. analyzes the field, registers input and updates accordingly
    public Field update(Field field){
        // spawne einen Stein, prüfe ob er andere Steine überlappt
        drawStoneFromBag();

        currentStone.setCurrentPosition(startPosition);

        if(checkOverlapping(field, currentStone)){  // spawned stone overlaps existing stones on field
            // end the game, e.g. Game Over Screen
        }

        // prüfe den Input, prüfe ob entsprechende Richtung frei ist.


        // prüfe ob Weg nach unten frei ist

        //wenn nach unten nichts geht, spawne neuen Stein



        return field;
    }

    // look into bag and pick stone after stone
    private void drawStoneFromBag(){
        // while 7th stone not reached, take the next out of the bag
        if (StoneIndex < bag.size){
            StoneIndex++;
            currentStone = bag.get(StoneIndex);

         // we reached the 7th stone, so shuffle and start anew
        } else {
            StoneIndex = 0;
            bag.shuffle();
            currentStone = bag.first();
        }
    }

    private void checkDirection(Field field, Stone currentStone, boolean vertical, boolean leftSide){
        if (vertical){
            if(leftSide){

            }
        }

    }

    // checks if new stone lies over existing stone when spawning
    private boolean checkOverlapping(Field field, Stone stone){
        for(int i = 0; i <stone.getStone().length; i++){
            for(int j = 0; j < stone.getStone()[i].length; j++){
                if(field.getField()[i + (int) stone.getCurrentPosition().x][j + (int) stone.getCurrentPosition().y] != 0){
                    return true;
                }
            }
        }
        return false;
    }
}
