class Transaction {
	private int transactionId;
	private Account accountFrom;
	private Account accountTo;
	private double transactionAmount;
	private TransactionStatus transactionStatus;

	public Transaction(int transactionId, Account accountFrom, Account accountTo, double transactionAmount,
			TransactionStatus transactionStatus) {
		this.transactionId = transactionId;
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.transactionAmount = transactionAmount;
		this.transactionStatus = transactionStatus;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Account getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(Account accountFrom) {
		this.accountFrom = accountFrom;
	}

	public Account getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(Account accountTo) {
		this.accountTo = accountTo;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "Transaction { transactionId=" + transactionId + ", accountFrom=" + accountFrom
				+ ", accountTo=" + accountTo + ", transactionAmount=" + transactionAmount + ", transactionStatus="
				+ transactionStatus + " }";
	}
}
