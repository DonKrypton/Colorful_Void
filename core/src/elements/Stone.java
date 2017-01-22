package elements;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Daniel on 08.01.2017.
 */

/* Represents all 7 types of stones.
 * Includes their type and rotation
 */
public class Stone {

    private int[][] stone;
    private int stoneType;
    private int[][] temp;
    private Vector2 currentPosition; // shows where Stone is on field array[][]

    public Stone(int stoneType){
        this.stoneType = stoneType;

        switch (stoneType) {
            case 1:	stone = new int[][]{ // cube
                    {stoneType,stoneType},
                    {stoneType,stoneType}
            };

            case 2: stone = new int[][]{
                    {0, stoneType, 0, 0}, // i-Stone
                    {0, stoneType, 0, 0},
                    {0, stoneType, 0, 0},
                    {0, stoneType, 0, 0}
            };

            case 3: stone = new int[][]{
                    {stoneType, stoneType, stoneType},	// t-Stone
                    {0, 		stoneType, 		0},
                    {0, 		0, 				0}
            };

            case 4: stone = new int[][]{
                    {0, 		stoneType, stoneType},	// s-Stone
                    {stoneType, stoneType, 		0},
                    {0, 		0, 				0}
            };

            case 5: stone = new int[][]{
                    {stoneType, stoneType, 			0},	// z-Stone
                    {0, 		stoneType, 	stoneType},
                    {0, 		0, 					0}
            };

            case 6: stone = new int[][]{ 		// j-Stone
                    {0, 		stoneType, 0},
                    {0, 		stoneType, 0},
                    {stoneType, stoneType, 0}
            };

            default:stoneType = 7;
                stone = new int[][]{
                        {0, 		stoneType, 			0},	//l-Stone
                        {0, 		stoneType, 			0},
                        {0, 		stoneType,	stoneType}
                };
        }
    }

    // Rotate the stone. Boolean decides clockwise vs counter-clockwise
    public void rotateClockwise(boolean clockwise){
        temp = stone;

        if(clockwise) {
            for(int row = 0; row < 3; row++){
                for(int col = 0; col <3; col++){
                    stone[row][col] = temp[3-col][row];
                }
            }

        } else {
            for(int row = 0; row < 3; row++){
                for(int col = 0; col <3; col++){
                    stone[3-col][row] = temp[row][col];
                }
            }
        }
    }

    public int[][] getStone(){
        return stone;
    }

    public int getStoneType(){
        return stoneType;
    }

    public Vector2 getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Vector2 newPosition){
        this.currentPosition = newPosition;
    }
}

