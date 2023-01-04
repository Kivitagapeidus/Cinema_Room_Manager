import java.util.Scanner;
import java.util.Objects;

class FixingNullPointerException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string = "null".equals(string) ? null : string;
        /* Do not change code above */
        String test = null;
        if (Objects.equals(string, test)){
            string = "NPE!";
            System.out.println(string);
        }else {
            System.out.println(string.toLowerCase());

        }

    }
}