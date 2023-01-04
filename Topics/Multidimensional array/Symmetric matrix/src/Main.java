import java.text.BreakIterator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int msize = scanner.nextInt();
        int[][] matrix = new int[msize][msize];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        boolean check = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    System.out.println("NO");
                    check = false;
                    break;
                }

            }
            if (!check){
                break;
            }
        }
        if (check){
            System.out.println("YES");
        }  // put your code here
    }
}