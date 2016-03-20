package g42861.rushhour.model;

/**
 *
 * @author G42861
 * @group B231
 */
public class Position {

    private int row;
    private int column;

    /**
     * Construct an instance of Position.
     *
     * @param row the row number of a position
     * @param column the column number of a position
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Get the row of an instance of Position.
     *
     * @return the row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Get the column of an instance of Position.
     *
     * @return the column
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Determine the state of an instance of Position.
     *
     * @return the coordinates of a position
     */
    @Override
    public String toString() {
        return "(" + this.row + "," + this.column + ")";
    }

    /**
     * Get the position in the direction next to the current instance of
     * Position. For example : If the current position is (2,3) and the
     * direction is UP, the position next to the current position is (1,3)
     *
     * @param direction
     * @return the new position
     */
    public Position gePosition(Direction direction) {
        Position newPosition = null;
        switch (direction) {
            case UP:
                newPosition = new Position(this.row - 1, this.column);
                break;
            case DOWN:
                newPosition = new Position(this.row + 1, this.column);
                break;
            case LEFT:
                newPosition = new Position(this.row, this.column - 1);
                break;
            case RIGHT:
                newPosition = new Position(this.row, this.column + 1);
                break;
            default:
        }
        return newPosition;
    }

    /**
     * Test if two instance of Position are structurally equal.
     *
     * @param o the other instance of Position
     * @return true is two positions are structurally equal
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Position))
            return false;

        Position p = (Position) o;
        return (this.row == p.row && this.column == p.column);
    }

}
/*
    @issue
    warning attributes
    Overrive nécessaire pour la méthode equals?
    Méthode hashcode necessaire?
 */
