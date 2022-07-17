package Chess;

public class board {
    /*
     * Create constant # of rows and columns on the board
     * Create board data type to be initialized as empty in the constructor
     */

    private static int numRows = 8;
    private static int numCols = 8;
    private piece[][] myBoard;


    /**
     * Constructor to create an empty board of 8x8
     */

    public board() {
        myBoard = new piece[numRows][numCols];
    }


    /*
     * Ensures row and column of piece are on the board
     */

    public boolean isOnBoard(int row, int col) {
        if ((row >= 0 && col >= 0) && (row <= 7 && col <= 7)) {
            return true;
        }
        return false;
    }


    /*
     * Create chess piece and add chess piece to the board
     * Row and column must be within the space of the board
     */
    public void addPiece(pieceType pieceType, int row, int col) {
        if (isOnBoard(row, col)) {
            piece myPiece = new piece(pieceType, row, col);
            myBoard[row][col] = myPiece;
        }
    }


    /*
     * Remove chess piece from board
     * Row and column must be within the space of the board
     */

    public void removePiece(int row, int col) {
        if (isOnBoard(row, col)) {
            myBoard[row][col] = null;
        }
    }


    /*
     * Cannot move piece to a location where another piece resides
     * Cannot move piece that does not exist
     * Cannot move outside board
     */

    public boolean canMovePiece(pieceType pieceType, int initialRow, int initialCol, int newRow, int newCol) {

        //If rows or columns are out of range
        if (!isOnBoard(initialRow, initialCol) || !isOnBoard(newRow, newCol)) {
            return false;
        }

        else if (myBoard[initialRow][initialCol] == null) {
            return false;
        }

        else if (myBoard[newRow][newCol] != null) {
            return false;
        }


        //Create a piece type and check the piece.java class to determine whether the move is valid
        piece piece = myBoard[initialRow][initialCol];

        if (!piece.isValidMove(pieceType, initialRow, initialCol, newRow, newCol)) {
            return false;
        }

        return true;
    }


    /*
     * Used to move pieces on board and update
       corresponding value stored in the piece
     */
    
    public boolean movePiece(pieceType pieceType, int initialRow, int initialCol, int newRow, int newCol) {
        if (!canMovePiece(pieceType, initialRow, initialCol, newRow, newCol)) {
            return false;
        }
        removePiece(initialRow, initialCol);
        addPiece(pieceType, newRow, newCol);
        return true;
    }


    /*
     * Capture piece from board by removing existing piece and
       replacing with the piece that overtook it
     * 
     * Initial row and column are for the overtaking piece's tile before it moved
     * 
     * New row and column are for the tile of the piece to be captured. Used to remove
       old piece and place new piece
     */

    public boolean capturePiece(pieceType pieceType, int initialRow, int initialCol, int newRow, int newCol) {
        if (!canMovePiece(pieceType, initialRow, initialCol, newRow, newCol)) {
            return false;
        }
        
        //Remove piece that was captured
        removePiece(newRow, newCol);

        //move overtaking piece to appropriate tile
        return movePiece(pieceType, initialRow, initialCol, newRow, newCol);
    }


    /*
     * Checks every tile on board and removes any piece
       to empty the board
     */

    public void removeAllPieces() {
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                if (myBoard[i][j] != null) {
                    removePiece(i, j);
                }
            }
        }
    }


    /*
     * Set board with appropriate pieces on their respective tiles
     */

    public void setBoard() {
        removeAllPieces();
        
        /*
         * Create enemy (top) pieces
         */
        addPiece(pieceType.KING, 0, 4);
        addPiece(pieceType.QUEEN, 0, 3);
        addPiece(pieceType.BISHOP, 0, 2);
        addPiece(pieceType.BISHOP, 0, 5);
        addPiece(pieceType.KNIGHT, 0, 1);
        addPiece(pieceType.KNIGHT, 0, 6);
        addPiece(pieceType.ROOK, 0, 0);
        addPiece(pieceType.ROOK, 0, 7);
        addPiece(pieceType.PAWN, 1, 0);
        addPiece(pieceType.PAWN, 1, 1);
        addPiece(pieceType.PAWN, 1, 2);
        addPiece(pieceType.PAWN, 1, 3);
        addPiece(pieceType.PAWN, 1, 4);
        addPiece(pieceType.PAWN, 1, 5);
        addPiece(pieceType.PAWN, 1, 6);
        addPiece(pieceType.PAWN, 1, 7);


        /*
         * Create player(bottom) pieces
         */
        addPiece(pieceType.KING, 7, 4);
        addPiece(pieceType.QUEEN, 7, 3);
        addPiece(pieceType.BISHOP, 7, 2);
        addPiece(pieceType.BISHOP, 7, 5);
        addPiece(pieceType.KNIGHT, 7, 1);
        addPiece(pieceType.KNIGHT, 7, 6);
        addPiece(pieceType.ROOK, 7, 0);
        addPiece(pieceType.ROOK, 7, 7);
        addPiece(pieceType.PAWN, 6, 0);
        addPiece(pieceType.PAWN, 6, 1);
        addPiece(pieceType.PAWN, 6, 2);
        addPiece(pieceType.PAWN, 6, 3);
        addPiece(pieceType.PAWN, 6, 4);
        addPiece(pieceType.PAWN, 6, 5);
        addPiece(pieceType.PAWN, 6, 6);
        addPiece(pieceType.PAWN, 6, 7);
    }


    /*
     * Return board filled with pieces
     */

    public piece[][] getBoard() {
        return myBoard;
    }


    /*
     * Print text version of piece in console window
     * EX: empty space == " "
     *     "KING"      == "K"
     *     "QUEEN"     == "Q"
     *     "KNIGHT"    == "N"
     *      etc
     */

    public String getPieceString(pieceType pieceType) {
        String pieceString = " ";
        if (pieceType.getPieceType() == "KING") {
            pieceString = "K";
        }
        else if (pieceType.getPieceType() == "QUEEN") {
            pieceString = "Q";
        }
        else if (pieceType.getPieceType() == "BISHOP") {
            pieceString = "B";
        }
        else if (pieceType.getPieceType() == "KNIGHT") {
            pieceString = "N";
        }
        else if (pieceType.getPieceType() == "ROOK") {
            pieceString = "R";
        }
        else if (pieceType.getPieceType() == "PAWN") {
            pieceString = "P";
        }
        return pieceString;
    }


    /*
     * Print text version of board in console window
     * 
     * Takes piece on board,
       accesses type of piece,
       utilizes above function to convert to string, 
       and prints string to display on console
     * 
     * A row --> | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
     * Each row consists of 33 characters
     * Takes actual 34 "-" characters to fill row
     */

    public void printBoard() {
        piece piece;
        String pieceString;

        for (int i = 0; i < numRows; ++i) {

            //Print bottom row border of 34 characters
            for (int k = 0; k < 33; ++k) {
                System.out.print("-");
            }

            System.out.println();

            for (int j = 0; j < numCols; ++j) {
                //Get piece on board then get string representation of piece
                //null means empty board space --> " "
                piece = myBoard[i][j];

                if (piece == null) {
                    pieceString = " ";
                }
                else {
                    pieceString = getPieceString(piece.getPieceType());
                }

                
                //for left (first) column
                //Create left border, print first piece, create border between next piece
                if (j == 0) {
                    System.out.print("| ");
                    System.out.print(pieceString);
                    System.out.print(" | ");
                }

                //for right (last) column
                //print piece and create right border
                else if (j == 7) {
                    System.out.print(pieceString);
                    System.out.println(" |");
                }

                //print piece and place border between next piece
                else {
                    System.out.print(pieceString);
                    System.out.print(" | ");
                }
            }
        }

        //Print bottom row border of 34 characters
        for (int k = 0; k < 33; ++k) {
            System.out.print("-");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        board board = new board();
        board.setBoard();
        board.printBoard();
        board.movePiece(pieceType.KING, 7, 4, 3, 0);
        board.printBoard();
    }
}
