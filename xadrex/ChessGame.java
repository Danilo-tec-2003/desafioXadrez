import java.util.Scanner;

public class ChessGame {
    private Board board;
    private boolean whiteTurn = true;

    public void start() {
        board = new Board();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.print();
            System.out.println((whiteTurn ? "Brancas" : "Pretas") + ", sua vez. Ex: e2 e4 (ou digite 'sair')");
            String move = scanner.nextLine();

            if (move.equalsIgnoreCase("sair")) break;

            String[] parts = move.split(" ");
            if (parts.length != 2) {
                System.out.println("Movimento inválido.");
                continue;
            }

            Position from = Position.fromString(parts[0]);
            Position to = Position.fromString(parts[1]);

            if (from == null || to == null) {
                System.out.println("Coordenadas inválidas.");
                continue;
            }

            if (board.move(from, to, whiteTurn)) {
                whiteTurn = !whiteTurn;
            } else {
                System.out.println("Movimento inválido.");
            }
        }

        scanner.close();
    }
}
