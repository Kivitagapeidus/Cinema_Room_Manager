import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] array = new int[len];
        int sum = 0;
        for (int i = 0;i < len; i++){
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        for (int bigger : array){
            if (bigger > n)
                sum += bigger;
        }
        System.out.println(sum);// put your code here
    }
}