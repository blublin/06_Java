public class BankMain {
    public static void main(String[] notArgs) {
        BankAccount bensBank = new BankAccount();
        
        System.out.printf("|---- TOTAL BANK ACCOUNTS #%s -----|\n",
        BankAccount.getTotalAccounts()
        );

        bensBank.setChecking(100);
        bensBank.setSavings(200);
        System.out.println("\n|----- Ben's Bank Accounts ----|");
        System.out.printf("Checking Account: $%.2f\n", bensBank.getChecking());
        System.out.printf("Savings Account: $%.2f\n", bensBank.getSavings());

        bensBank.addToEither("savings", 50);
        bensBank.displayAccounts();
        
        BankAccount anotherBank = new BankAccount();
        System.out.printf("|---- TOTAL BANK ACCOUNTS #%s -----|\n",
        BankAccount.getTotalAccounts()
        );
        System.out.printf("|--- All The Money :: $%.2f ---|\n",
        BankAccount.getAllTheMoney()
        );
        
    }
}