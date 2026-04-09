import java.util.ArrayList;
import java.util.Scanner;

// Credential class
class Credential {
    String website;
    String username;
    String password;

    Credential(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }
}

// Main class
public class SecureVault {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🆕 Create account
        System.out.println("=== Create Master Account ===");
        System.out.print("Set Username: ");
        String masterUser = sc.nextLine();

        System.out.print("Set Password: ");
        String masterPass = sc.nextLine();

        // 🔐 Login system
        System.out.println("\n=== Login ===");
        System.out.print("Enter Username: ");
        String inputUser = sc.nextLine();

        System.out.print("Enter Password: ");
        String inputPass = sc.nextLine();

        if (!inputUser.equals(masterUser) || !inputPass.equals(masterPass)) {
            System.out.println("❌ Access Denied!");
            return;
        }

        System.out.println("✅ Login Successful!");

        ArrayList<Credential> vault = new ArrayList<>();

        // 🔁 Menu loop
        while (true) {
            System.out.println("\n--- Password Vault ---");
            System.out.println("1. Add Credentials");
            System.out.println("2. View Credentials");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            // ➕ Add multiple credentials
            if (choice == 1) {
                System.out.print("How many credentials you want to add: ");
                int n = sc.nextInt();
                sc.nextLine();

                for (int i = 1; i <= n; i++) {
                    System.out.println("\nEnter details for Credential " + i);

                    System.out.print("Website: ");
                    String website = sc.nextLine();

                    System.out.print("Username: ");
                    String username = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    vault.add(new Credential(website, username, password));
                }

                System.out.println("✅ All credentials saved!");
            }

            // 👀 View credentials
            else if (choice == 2) {
                if (vault.isEmpty()) {
                    System.out.println("❌ No credentials found.");
                } else {
                    System.out.println("\n--- Saved Credentials ---");

                    int index = 1;
                    for (Credential c : vault) {
                        System.out.println("\nCredential " + index++);
                        System.out.println("Website : " + c.website);
                        System.out.println("Username: " + c.username);
                        System.out.println("Password: " + c.password);
                    }
                }
            }

            // 🚪 Exit
            else if (choice == 3) {
                System.out.println("🔒 Vault Closed");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}