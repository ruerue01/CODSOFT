import java.util.Scanner;
/*
 * 
 * @author Ruvimbo Machekano 
 */
public class Atm{
    private BankAccount userAccount;

    public Atm(BankAccount userAccount) {
        this.userAccount = userAccount;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void displayOptions() {
        System.out.println("Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline not consumed by nextInt()
        switch (option) {
            case 1:
                withdraw(scanner);
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Your session just ended.Goodbye!");
                System.exit(0);
                break;  
            default:
                System.out.println("Incorrect option.Retry.");
                start();
           
        }
    }

    public void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw (ZAR): ");
        float amount = scanner.nextFloat();
        if (userAccount.getBalance() >= amount) {
            userAccount.setBalance(userAccount.getBalance() - amount);
            System.out.printf("Successful Withdrawal, Available balance: ZAR", amount, userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Please Retry.");
        }
    }

    public void deposit(Scanner scanner) {
        System.out.print("Enter deposit amount (ZAR): ");
        float amount = scanner.nextFloat();
        userAccount.setBalance(userAccount.getBalance() + amount);
        System.out.printf("Successful Deposit, Available balance: ZAR", amount, userAccount.getBalance());
    }
    public void checkBalance() {
        System.out.printf("Your available balance is: ZAR", userAccount.getBalance());
    }
}

public class AtmInterface {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        //BankAccount with initial balance of ZAR 800
        BankAccount userAccount = new BankAccount(800);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();

            atm.performTransaction(choice, scanner);
        }
    }
}