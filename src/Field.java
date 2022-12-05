public class Field {
    char[][] field;
    int size = 3;
    int score = 3;

    void createField() {
        this.field = new char[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                field[row][column] = ' ';
            }
        }

        System.out.println("Field initialized");
        System.out.println();
    }

    void setSize(int size) {
        this.size = size;
    }

    void setScore(int score) {
        this.score = score;
    }

    void printField() {

        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + "   ");

        }

        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.print(row + 1 + " ");

            for (int column = 0; column < size; column++) {
                System.out.print("{" + field[row][column] + "} ");
            }

            System.out.println();
        }
        System.out.println();
    }

    boolean isPlaceFree(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex >= size || columnIndex < 0 || columnIndex >= size) {
            return false;
        } else if (field[rowIndex][columnIndex] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    void setValue(int rowIndex, int columnIndex, char value) {
        field[rowIndex][columnIndex] = value;
    }

    boolean isGameOver(char player) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {

                if (checkRightDir(row, column, player)) {
                    return true;
                } else if (checkDownDir(row, column, player)) {
                    return true;
                } else if (checkRightDiagonal(row, column, player)) {
                    return true;
                } else if (checkLeftDiagonal(row, column, player)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean checkRightDir(int row, int column, char player) {
        if (column > size - score) {
            return false;
        }

        for (int i = column; i < column + score; i++) {

            if (field[row][i] != player) {
                return false;
            }
        }

        return true;
    }

    boolean checkDownDir(int row, int column, char player) {
        if (row > size - score) {
            return false;
        }

        for (int i = row; i < row + score; i++) {

            if (field[i][column] != player) {
                return false;
            }
        }

        return true;
    }

    boolean checkRightDiagonal(int row, int column, char player) {
        if (row > size - score) {
            return false;
        }

        if (column > size - score) {
            return false;
        }

        for (int i = 0; i < score; i++) {
            int indexRow = row + i;
            int indexColumn = column + i;

            if (field[indexRow][indexColumn] != player) {
                return false;
            }
        }

        return true;
    }

    boolean checkLeftDiagonal(int row, int column, char player) {
        if (row > size - score) {
            return false;
        }

        if (column < size - 1) {
            return false;
        }

        for (int i = 0; i < score; i++) {
            int indexRow = row + i;
            int indexColumn = column - i;

            if (field[indexRow][indexColumn] != player) {
                return false;
            }
        }

        return true;
    }
}