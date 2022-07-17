package Chess;

public class tile {
    /*
     * Individual tile of the board
     * Used to store position of chess piece
     */

    private int myRow;
    private int myCol;


    /*
     * Initialize chess piece with row and column
     */

    public tile(int row, int col) {
        myRow = row;
        myCol = col;
    }


    /*
     * Set row of chess piece
     */

    public void setRow(int row) {
        myRow = row;
    }


    /*
     * Return column of chess piece
     */

    public void setCol(int col) {
        myCol = col;
    }


    /*
     * Return row of chess piece
     */

    public int getRow() {
        return myRow;
    }


    /*
     * Return column of chess piece
     */

    public int getCol() {
        return myCol;
    }
}
