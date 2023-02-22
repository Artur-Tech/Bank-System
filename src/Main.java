import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        BankSystem system = new BankSystem();
        try {
            system.createAccount("Peter", "Mayer", CreditRating.LOW, "FR 76 10057 19023 00018871101 43", 100);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error creating account", e);
        }
        try {
            system.createAccount("Anton", "Dachman", CreditRating.LOW, "DE2120050000123456XXX", 200);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error creating account", e);
        }
        try {
            system.createNewTransaction("FR_1001", "DE_2001", 50);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error creating transaction", e);
        }

        System.out.println("Bank Accounts:");
        System.out.println(system.getBankAccounts());

        System.out.println("Bank Transactions:");
        System.out.println(system.getBankTransactions());

    }
}

enum CreditRating {
    LOW, MEDIUM, HIGHT
}

enum TransactionStatus {
    FAILURE, SUCCESS
}
