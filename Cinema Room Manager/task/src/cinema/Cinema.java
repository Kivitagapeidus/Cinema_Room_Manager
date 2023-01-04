package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {

        int [] statistics = new int[] {0,0,0,0}; //purchasedtickets, totalseats, income, totalincome

        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        statistics[1] = rows * seats;
        showMeTheMoney(statistics, rows, seats);


        char[][] planSeats = new char[rows][seats];

        for (int i = 0; i < rows ; i++){
            for (int j = 0; j < seats; j++){
                planSeats[i][j] = 'S';
            }
        }
        int menu = 3;
        while (menu !=0){
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n");
            menu = scanner.nextInt();
            switch (menu){
                case 0:
                    break;
                case 1:
                    showSeats(planSeats,seats, rows);
                    break;
                case 2:
                    buySeats(planSeats,seats ,rows, statistics);
                    break;
                case 3:
                    statistics(statistics);
                    break;
            }

        }
    }
    public static void showSeats(char[][] planSeats, int seats, int rows){
        System.out.print("Cinema:" + "\n" + " ");
        int m = 1;
        while (m <= seats){
            System.out.print(" " + m);
            m++;
        }
        System.out.println();


        for (int i = 0; i < rows ; i++){
            System.out.print(i+1);
            for (int j = 0; j < seats; j++){
                System.out.print(" " + planSeats[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[] buySeats(char[][] planSeats, int seats, int rows, int[] statistics){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int wantRow = scanner.nextInt();
        while (wantRow < 0 || wantRow > rows){
            System.out.println("Wrong input!");
            System.out.println("Enter a row number:");
            wantRow = scanner.nextInt();
        }
        System.out.println("Enter a seat number in that row:");
        int wantSeat = scanner.nextInt();
        while (wantSeat < 0 || wantSeat > seats) {
            System.out.println("Wrong input!");
            System.out.println("Enter a row number:");
            wantRow = scanner.nextInt();
        }



        int totalSeats = rows * seats;

        while (planSeats[wantRow - 1][wantSeat - 1] == 'B'){
            System.out.println("That ticket has already been purchased!");
            System.out.println("Enter a row number:");
            wantRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            wantSeat = scanner.nextInt();
        }
        if (totalSeats <= 60){
            System.out.println("Ticket price: $10");
            statistics[2] += 10;
        }else {
            if (rows % 2 ==0 && rows/2 >= wantRow){
                System.out.println("Ticket price: $10");
                statistics[2] += 10;
            } else if (rows % 2 ==0 && rows/2 < wantRow) {
                System.out.println("Ticket price: $8");
                statistics[2] += 8;
            } else if (rows % 2 !=0 && rows/2 >= wantRow) {
                System.out.println("Ticket price: $10");
                statistics[2] += 10;
            } else {
                System.out.println("Ticket price: $8");
                statistics[2] += 8;
            }
        }

        planSeats[wantRow - 1][wantSeat - 1] = 'B';
        statistics[0]++;
        return statistics;


    }

    public static int[] showMeTheMoney (int [] statistics, int rows, int seats){
        int totalSeats = rows * seats;
        if (totalSeats <= 60){
            statistics[3] = totalSeats * 10;
        }else {
            if (rows % 2 ==0){
                statistics[3] = totalSeats * 9;
            } else if (rows % 2 ==0) {
                statistics[3] = totalSeats * 9;
            } else if (rows % 2 !=0) {
                statistics[3] = (((rows / 2)* seats * 10) + ((((rows / 2) + 1)* seats ) * 8));
            } else {
                statistics[3] = (((rows / 2)* seats * 10) + ((((rows / 2) + 1)* seats ) * 8));
            }
        }

        return statistics;
    }
    public static void statistics(int [] statistics){

        double seatsSold = statistics[0];
        double allSeats = statistics[1];
        double prec = seatsSold / allSeats * 100;

        System.out.format("Number of purchased tickets: %d %n", statistics[0]);
    System.out.format("Percentage: %.2f",prec);
    System.out.println("%");
    System.out.format("Current income: $%d %n",statistics[2]);
    System.out.format("Total income: $%d %n", statistics[3]);
    System.out.println();
    }
}