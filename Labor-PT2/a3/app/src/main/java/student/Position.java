package student;

public class Position {
    private int column;
    private int row;

    public Position(int column, int row) {
        setColumn(column);
        setRow(row);
    }

    public Position(String posString) {
        if (posString == null || posString.length() != 2) {
            throw new IllegalArgumentException();
        }
        setColumn(posString.charAt(0) - 'a'); // get column
        setRow(Character.getNumericValue(posString.charAt(1) - 1)); // get row
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        if (column < 0 || column > 7) {
            throw new IllegalArgumentException();
        }
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (row < 0 || row > 7) {
            throw new IllegalArgumentException();
        }
        this.row = row;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ('a' + column));
        sb.append(row + 1);
        return sb.toString();
    }

    public boolean equals(Position pos2) {
        if (pos2 == null) {
            throw new IllegalArgumentException();
        }

        if ( this.getRow() == pos2.getRow() && this.getColumn() == pos2.getColumn() ) {
            return true;
        }
        return false;
    }
}
