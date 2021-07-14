import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player1, player2;
        char[][] mass = new char[3][3];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = '•';
            }
        }

        System.out.println("Введите имя первого игрока.");
        player1 = scanner.nextLine();
        System.out.println("Введите имя второго игрока.");
        player2 = scanner.nextLine();
        System.out.println();

        int playerCounter = 1;
        int count = 0;
        while (true) {
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass[i].length; j++) {
                    System.out.print(mass[i][j] + "  ");
                }
                System.out.println();
            }
            System.out.println();

            if (playerCounter == 1) {
                System.out.println("Ход " + player1 + " (✘)");
            } else {
                System.out.println("Ход " + player2 + " (꩐)");
            }

            int x;
            do {
                System.out.println("Выберите ряд (1 - 3)");
                x = scanner.nextInt() - 1;
            } while (x < 0 || x > 2);

            int y;
            do {
                System.out.println("Выберите колонку (1 - 3)");
                y = scanner.nextInt() - 1;
            } while (y < 0 || y > 2);
            System.out.println();

            if (mass[x][y] == '✘' || mass[x][y] == '꩐'){
                System.out.println("Эта ячейка уже занята.");
                System.out.println();
                continue;
            }

            if (playerCounter == 1) {
                mass[x][y] = '✘';
            } else {
                mass[x][y] = '꩐';
            }
            count++;

            boolean isWin = false;
            for (int i = 0; i < mass.length; i++){
                boolean winY = true;
                boolean winX = true;
                for (int j = 0; j < 2; j++){
                    if (mass[i][j] == '•' || mass[i][j] != mass[i][j + 1]) winY = false;
                    if (mass[j][i] == '•' || mass[j][i] != mass[j + 1][i]) winX = false;
                }
                if (winY || winX){
                    isWin = true;
                    break;
                }
            }

            boolean win_1 = true;
            boolean win_2 = true;
            for (int i = 0; i < 2; i++ ){
                if(mass[i][i] == '•' || mass[i][i] != mass[i + 1][i + 1]) win_1 = false;
                if(mass[i][3 - i - 1] == '•' || mass[i][3 - i - 1] != mass[i + 1][3 - i - 2]) win_2 = false;
            }
            if (win_1 || win_2) {
                isWin = true;
            }

            if(isWin){
                System.out.println("Победил " + (playerCounter == 1 ? player1 : player2) + "!");
                break;
            }

            if(count == 9){
                System.out.println("Ничья.");
                break;
            }

            playerCounter = playerCounter == 1 ? 2 : 1;
        }
    }
}
// • ✘ ꩐