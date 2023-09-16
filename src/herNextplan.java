import java.util.Scanner;

public class herNextplan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter her next plan: ");
        String herNextPlan = scanner.nextLine();
        
        if (herNextPlan.equals("get married")) {
            System.out.println("I'm going to propose to her");
        } else {
            System.out.println("I'll wait for her patiently 😇");
        }
        
        scanner.close();
    }
}
