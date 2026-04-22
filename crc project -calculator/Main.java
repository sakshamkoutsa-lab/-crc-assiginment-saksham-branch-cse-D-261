import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter expression: ");
        String input = sc.nextLine();

        Calculator obj = new Calculator();

        try {
            double ans = obj.calculate(input);
            System.out.println("answer= " + ans);
        } catch (Exception e) {
            System.out.println("invalid input");
        }

        sc.close();
    }
}