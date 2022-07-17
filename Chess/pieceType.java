package Chess;

public enum pieceType {
    /*
     * List of game pieces
     */

     BISHOP, KING, KNIGHT, PAWN, QUEEN, ROOK;

     
    /*
     * Interprets enum to return string type of game piece
     */

    public String getPieceType() {
        switch(this) {
            case BISHOP: return "BISHOP";
            case KING: return "KING";
            case KNIGHT: return "KNIGHT";
            case PAWN: return "PAWN";
            case QUEEN: return "QUEEN";
            case ROOK: return "ROOK";
        }
        return "N/A";
    }
}