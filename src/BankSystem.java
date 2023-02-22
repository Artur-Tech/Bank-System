import java.util.ArrayList;
import java.util.List;

public class BankSystem {

    private List<Account> bankAccounts;
    private List<Transaction> bankTransactions;

    public BankSystem() {
        bankAccounts = new ArrayList<Account>();
        bankTransactions = new ArrayList<Transaction>();
    }

    public void createAccount(String ownerName, String ownerSurname, CreditRating rating, String IBAN, double balance) throws Exception {
        // check if IBAN already exists
        if(getAccountByIBAN(IBAN) != null) {
            throw new Exception("Account with this IBAN already exists");
        }
        Customer owner = new Customer(ownerName, ownerSurname, rating);
        Account account = new Account(IBAN, owner, balance);
        this.bankAccounts.add(account);
    }

    private int generateTransactionId() {
        return this.bankTransactions.size() + 1;
    }

    private Account getAccountByIBAN(String IBAN) {
        for (Account account : bankAccounts) {
            if (account.getIBAN().equals(IBAN)) {
                return account;
            }
        }
        return null;
    }

    public void createNewTransaction(String IBANAccountFrom, String IBANAccountTo, double amount) throws Exception {

        if(amount < 0) {
            throw new Exception("Transaction amount cannot be negative");
        }

        Account accountFrom = getAccountByIBAN(IBANAccountFrom);
        Account accountTo = getAccountByIBAN(IBANAccountTo);

        if (accountFrom == null || accountTo == null) {
            throw new Exception("One or both accounts with this IBAN doesn't exist");
        }

        Transaction trans = new Transaction(generateTransactionId(), accountFrom, accountTo, amount, TransactionStatus.FAILURE);

        if (accountFrom.doWithdrow(amount)) {
            accountTo.doDeposit(amount);
            trans.setTransactionStatus(TransactionStatus.SUCCESS);
        } else {
            throw new Exception("Insufficient funds in account");
        }

        this.bankTransactions.add(trans);
    }

    public List<Account> getBankAccounts() {
        return bankAccounts;
    }

    public List<Transaction> getBankTransactions() {
        return bankTransactions;
    }

    public void setBankAccounts(List<Account> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return " BankingSystem { " + " bankAccounts = " + bankAccounts + '}';
    }
}
