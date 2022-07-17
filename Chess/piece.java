package Chess;
import java.lang.Math;

public class piece {
    /*
     * Every chess piece has a type (rook, pawn, etc),
       as well as a tile it is located on 
     */

    private pieceType myPieceType;
    private tile myTile;


    /*
     * Initialize the type and tile of the chess piece
     */

    public piece(pieceType pieceType, int row, int col) {
        myPieceType = pieceType;
        myTile = new tile(row, col);
    }


    /*
     * Return type of chess piece
     */

    public pieceType getPieceType() {
        return myPieceType;
    }


    /*
     * Return the tile that the chess piece is located
     */

    public tile getTile() {
        return myTile;
    }


    /*
     * Move piece by setting desired row and column
     * First checks if move is valid
     */

    public boolean movePiece(pieceType pieceType, int initialRow, int initialCol, int newRow, int newCol) {
        if (!isValidMove(pieceType, initialRow, initialCol, newRow, newCol)) {
            return false;
        }
        myTile.setRow(newRow);
        myTile.setCol(newCol);
        return true;
    }


    /*
     * Analyses piece type and desired move to
       check if the move is valid

     * ASSIGN BOOLEAN VALUE FOR WHETHER VERTICAL
     * ASSIGN BOOLEAN VALUE FOR WHETHER PLAYER PIECE
     * ASSIGN INT VALUE FOR NUMBER OF MOVES
     */

    public boolean isValidMove(pieceType pieceType, int initialRow, int initialCol, int newRow, int newCol) {
        //Move must be diagonal
        if (pieceType.getPieceType() == "BISHOP") {

            //# of rows moved must be equivalent to # of columns moved
            if (Math.abs(newRow - initialRow) == Math.abs(newCol - initialCol)) {
                return true;
            }

            else {
                return false;
            }
        }
        
        //Move can only be a distance of 1 tile in any direction
        else if (pieceType.getPieceType() == "KING") {
            
            //Diagonal 1 tile move
            if (Math.abs(newRow - initialRow) == 1 && Math.abs(newCol - initialCol) == 1) {
                return true;
            }

            //Vertical 1 tile move
            else if (Math.abs(newRow - initialRow) == 1 && Math.abs(newCol - initialCol) == 0) {
                return true;
            }

            //Horizontal 1 tile move
            else if (Math.abs(newRow - initialRow) == 0 && Math.abs(newCol - initialCol) == 1) {
                return true;
            }

            else {
                return false;
            }
        }

        //Move can only be in 'L' shaped pattern
        else if (pieceType.getPieceType() == "KNIGHT") {
            //Move 1 tiles vertically and 2 tile horizontally
            //Represents 90 degree turned 'L' or -90 degree turned 'L'
            if (Math.abs(newRow - initialRow) == 1 && Math.abs(newCol - initialCol) == 2) {
                return true;
            }

            //Move 2 tiles vertically and 1 tile horizontally
            //Represents 0 degree turned 'L' or 180 degree turned 'L'
            else if (Math.abs(newRow - initialRow) == 2 && Math.abs(newCol - initialCol) == 1) {
                return true;
            }

            else {
                return false;
            }
        }
        else if (pieceType.getPieceType() == "PAWN") {
            //TODO
            //Implement variable for number of moves, and test
            //If pawn is on first move, it can move 2 tiles
            //Else, can only move 1 tile

            //TODO
            //Ensure that pawn can only capture other pieces in a diagonal fashion

            //TODO
            //Implement way to tell whether pawn is enemy pawn or player pawn
            //Will help to determine if move can only go towards player or away from player

            //TODO
            //Ensure that other pieces are not blocking the piece from moving
            //Also ensure that there is no piece on the tile that the piece is moving to
            /*
             * IN REGARDS TO ABOVE
             * 
             * Statement holds true for case of:
             * 
             * If both pieces are player pieces or both pieces are enemy pieces
             */
        }

        //Queen can move in any direction
        else if (pieceType.getPieceType() == "QUEEN") {
            return true;
        }
        else if (pieceType.getPieceType() == "ROOK") {
            //Vertical move
            if (Math.abs(newRow - initialRow) >= 1 && Math.abs(newCol - initialCol) == 0) {
                return true;
            }

            //Horizontal move
            else if (Math.abs(newRow - initialRow) == 0 && Math.abs(newCol - initialCol) >= 1) {
                return true;
            }

            else {
                return false;
            }
        }

        return true;
    }

}
