import javafx.scene.layout.GridPane;

public class Board {
    private int numberRows = 6;
    private int numberColumns = 6;
    private WegeButton[] board;
    private int numberSquares = 36;
    private int index;

    // Field for wegeButton size setting default wegeButton size to 75x75
    private int wegeWidth = 75;
    private int wegeHeight = 75;

    private GridPane grid;


    /**
     * create all the cards for the game & shuffle them each time
     * @param number of each card type if inputted
     */
    public Board(int numberRows, int numberColumns) {
        this.numberRows = numberRows;
        this.numberColumns = numberColumns;
        this.numberSquares = numberRows * numberColumns;
        board = new WegeButton[numberRows * numberColumns];

        // create the empty WegeButtons to fill the specific part of the grid
        for (int i = 0; i < numberSquares; i++) {
            board[i] = new WegeButton(wegeWidth, wegeHeight);
        }

        /**
         * puts the created board that is an array onto a grid
         */
        grid = new GridPane();
        for (int index = 0; index < numberRows; index ++) {
            for (int index2 =0; index2 <numberColumns; index2 ++){

                int indexOfBoard = index * numberColumns + index2;
                grid.add(board[indexOfBoard], index2, index);
            }
        }
    }

    /** method that returns the GridPane of the created board
     */
    public GridPane getGridPane() {
        return grid;
    }

    /** method that returns the WegeButton of the inputted index
     * @param the int i which is the index
     */
    public WegeButton getIndexButton(int i){
        return board[i];
    }

    /** method that finds the index of the inputted WegeButton
     * @param WegeButton
     */
    public int getIndex(WegeButton b) {
        for (int i = 0; i < numberSquares; i++) {
            if (b == this.getIndexButton(i)){
                index = i;
                break;
            }
        }
        return index;
    }

    /** method that checks if the card placed is following the rules
     */
    public boolean checkAdjacent(int i) {
        if (getIndexButton(i+1).getCard() == null && getIndexButton(i-1).getCard() == null &&
                getIndexButton(i+numberColumns).getCard() == null && getIndexButton(i-numberColumns).getCard() == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean matchAdjacent(int i, WegeCard c) {
        return true;
    }
}
