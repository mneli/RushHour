package g42861.rushhour.model;

/**
 *
 * @author G42861
 * @group B231
 */
public class Position {

    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "(" + this.row + "," + this.column + ")";
    }

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

}
