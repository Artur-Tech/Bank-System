class Account {
    private String IBAN;
    private Customer owner;
    private double balance;

    public Account() {}

    public Account(String IBAN, Customer owner, double balance) {
        this.IBAN = IBAN;
        this.owner = owner;
        this.balance = balance;
    }

    public void doDeposit(double amount) {
        this.balance += amount;
    }

    public boolean doWithdrow(double amount) {
        if (amount > balance) {
            double difference = balance - amount;
            switch (this.owner.getCreditRating()) {
                case LOW:
                    return getMoneyFromKreditBalance(100, difference, amount);
                case MEDIUM:
                    return getMoneyFromKreditBalance(500, difference, amount);
                case HIGHT:
                    return getMoneyFromKreditBalance(1000, difference, amount);
                default:
                    System.out.println("Invalid credit rating");
                    return false;
            }
        }
        this.balance -= amount;
        return true;
    }

    private boolean getMoneyFromKreditBalance(double creditBalance, double difference, double amount) {
        if (creditBalance >= difference) {
            this.balance -= amount;
            return true;
        }

        System.out.println("Not enough money");
        return false;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account { " + "IBAN = '" + IBAN + '\'' + ", owner = " + owner + ", balance = " + balance + '}';
    }
}
