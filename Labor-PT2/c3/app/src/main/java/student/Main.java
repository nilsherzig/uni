package student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // main things
        Scanner sc = new Scanner(System.in);
        Chessboard cb = new Chessboard();
        int counter = 0;
        while (true) {
            cb.print();
            String color = counter % 2 == 0 ? "white" : "black";
            System.out.print(color + " > ");

            String userInput = sc.nextLine();

            if (userInput.equals("q")) {
                break;
            }

            String split[] = userInput.split(" ");

            Position reqStart = new Position(split[0]);
            Position reqEnd = new Position(split[1]);

            Figure fg = cb.getFigure(reqStart);

            if ((fg.getBlack() && color.equals("black")) || (!fg.getBlack() &&
                    color.equals("white"))) {

                if (cb.move(reqStart, reqEnd)) {
                    System.out.println(
                            color + " | " + fg.getSymbol() + " " + fg.getLabel() + " " + reqStart + " -> " + reqEnd
                                    + "\n");
                    counter += 1;
                } else {
                    System.out.println("Move isn't legal");

                }

            } else {
                System.out.println("You can't move this figure\n");
            }
        }
        sc.close();
    }

}
