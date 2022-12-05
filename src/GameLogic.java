import java.util.Scanner;

public class GameLogic {
    Scanner scan = new Scanner(System.in);
    Field field;
    char nextStep;
    boolean gameOver = false;

    private void setupGame() {
        System.out.println("Start new game");
        field = new Field();

        System.out.print("Choose field size (default 3): ");
        field.setSize(scan.nextInt());

        System.out.print("Choose score for win (default 3): ");
        field.setScore(scan.nextInt());

        field.createField();

    }

    public void play() {
        setupGame();

        System.out.print("Choose you figure (X or O): ");
        char first = scan.next().charAt(0);


        if (first == 'X' || first == 'O') {
            nextStep = first;
        } else {
            System.out.println("The first will be X");
            nextStep = 'X';
            System.out.println();
        }

        field.printField();

        while (!gameOver) {
            turn();

            gameOver = field.isGameOver(nextStep);
            if (gameOver) {
                System.out.println(nextStep + " win!");
                System.out.println("The game is over");
            }

            if (nextStep == 'X') {
                nextStep = 'O';
            } else {
                nextStep = 'X';
            }
        }
    }

    private void turn() {
        System.out.println(nextStep + ", your turn. ");

        System.out.print("Choose column: ");
        int column = scan.nextInt();

        System.out.print("Choose row: ");
        int row = scan.nextInt();

        int rowIndex = row - 1;
        int columnIndex = column - 1;

        if (field.isPlaceFree(rowIndex, columnIndex)) {
            field.setValue(rowIndex, columnIndex, nextStep);
            field.printField();
        } else {
            System.out.println("This place is busy. Try again");
            turn();
        }
    }
}
