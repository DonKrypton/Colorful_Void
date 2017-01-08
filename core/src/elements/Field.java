package elements;

/**
 * Created by Daniel on 08.01.2017.
 */


/* The field where the stones drop.
 * It creates a 2-dimensional array, storing information of being empty/filled, as well as type of stone. */
public class Field {
    private int[][] field;

    // field is 20 high, 10 wide. plus 1 on left/right/down/up for collision detect and stone spawning
    private final int VERTICAL_TILES;
    private final int HORIZONTAL_TILES;

    private int[] filledRows; //remembers which row is filled
    private int comboCount;	// counts the filled rows

    public Field(){
        VERTICAL_TILES = 22;
        HORIZONTAL_TILES = 12;
        field = new int[VERTICAL_TILES][HORIZONTAL_TILES];

        for(int i=0; i<VERTICAL_TILES; i++){ // initialize board with Zeroes
            for(int j=0; j<HORIZONTAL_TILES; j++){
                field[i][j] = 0;
            }
        }

        filledRows = new int[VERTICAL_TILES]; // no rows filled yet
        resetFillingsMemory();
    }

    // Count filled rows, return the points and reset the count
    // REFACTOR; DIVIDE; OUTSOURCE TO LOGIC CLASS (?)
    public int evaluateField(){
        for (int i=0; i<VERTICAL_TILES; i++){
            for (int j=0; j<HORIZONTAL_TILES; j++){
                if (field[i][j]==0){
                    break;

                } else if (field[i][HORIZONTAL_TILES - 1] != 0){
                    comboCount++;
                    filledRows[i]=1;
                }
            }
        }
        resetFillingsMemory();
        clearFilledRows();
        dropFilledRows();
        return getPoints();
    }

    // Reset memory of filled rows
    private void resetFillingsMemory(){
        for(int i = 0; i<VERTICAL_TILES; i++){
            filledRows[i]= 0;
        }
    }

    // clear the filled rows
    private void clearFilledRows(){
        for(int i=0; i<VERTICAL_TILES; i++){
            if(filledRows[i] != 0){
                for(int j=0; j<HORIZONTAL_TILES; j++){
                    field[i][j] = 0;
                }
            }
        }
    }

    // drop rows that became unsupported by solved stones
    private void dropFilledRows(){
		/* 1. erkenne leere Rows mit filledRows[]
		 * 1a. iteriere durch filled Rows
		 * 1b. bei Treffer, überprüfe die nächste Row,
		 * 1c. lass einen Zähler um 1 steigen.
		 * 1d. überprüfe solange die nächste, bis du eine 0 triffst. der Zähler zählt mit
		 * 1e. nutze den Zähler, um Steine entsprechend fallen zu lassen.
		 * 1f. iteriere dann weiter.
		 * 1g. beachte dabei Ober- und Untergrenze des Field Arrays.
		 *
		 */
    }

    // Return and reset combo counter
    private int getPoints(){
        int combos = comboCount;
        comboCount = 0;
        return combos *  100;
    }

    // fixates a stone after reaching obstacles
    // BOUNDARIES HAVE TO BE CONTROLLED -> Logic class
    public void fixateStone(int currentRow, int[][] stone){
        for(int row = 0; row < stone.length; row++){
            for(int col = 0; col < stone[0].length; col++){
                field[row + currentRow][col] = stone[row][col];
            }
        }
    }

    public int[][] getField(){
        return field;
    }
}
