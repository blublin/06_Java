import java.util.Random;

public class BankAccount {
    private static int totalBankAccounts = 0;
    private static double lotsOfMoney = 0.0;
    private double checkingBalance;
    private double savingsBalance;
    private String account;

    public BankAccount() {
        checkingBalance = 0.0;
        savingsBalance = 0.0;
        account = setAccountString();
        totalBankAccounts++;
    }

    /* ----- PUBLIC ----- */
    
    /* --- GETTERS --- */
    public double getChecking() {
        return checkingBalance;
    }
    public double getSavings() {
        return savingsBalance;
    }
    public double getAll() {
        return this.getChecking() + this.getSavings();
    }
    public void displayAccounts() {
         System.out.printf("Checking Account: $%.2f\nSavings Account: $%.2f\n",
        getChecking(), getSavings()
        );
    }
    /* --- STATIC GETTERS --- */
    public static int getTotalAccounts() {
        return totalBankAccounts;
    }
    public static double getAllTheMoney() {
        return lotsOfMoney;
    }

    /* --- SETTERS --- */
    // Set 1
    public void setChecking(double amount) {
        checkingBalance += amount;
        lotsOfMoney += amount;
    }
    public void setSavings(double amount) {
        savingsBalance += amount;
        lotsOfMoney += amount;
    }
    // Set Either
    public void addToEither(String account, double amount) {
        if (account == "checking" ) {
            this.setChecking(amount);
        }
        else if (account == "savings" ) {
            this.setSavings(amount);
        }
    }
    // Set Negative
    public double withdrawFromOne(String account, double amount) {
        double negAmount = amount * -1;
        if (account.toLowerCase() == "checking" ) {
            if (this.getChecking() + amount >= 0) {
                this.setChecking(amount);
                return this.getChecking();
            }
        }
        else if (account.toLowerCase() == "savings" ) {
            if (this.getSavings() + amount >= 0) {
                this.setSavings(amount);
                return this.getSavings();
            }
        }
        return 0.0;
    }
    
    /* ---- PRIVATE ----- */

    private String setAccountString() {
        Random randIndex = new Random();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String accStr = "";
        for (byte i = 0; i < 10; i++) {
            accStr += alphabet[randIndex.nextInt(26)];
        }
        return accStr;
    }
}