import java.util.Objects;

class Customer {
    private final String name;
    private final String surName;
    private final CreditRating creditRating;

    public Customer(String name, String surName, CreditRating creditRating) {
        if (name == null || surName == null) {
            throw new IllegalArgumentException("Name and surname cannot be null.");
        }
        this.name = name;
        this.surName = surName;
        this.creditRating = creditRating;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public CreditRating getCreditRating() {
        return creditRating;
    }

    @Override
    public String toString() {
        return "Customer {" +
                " name = '" + name + '\'' +
                ", surName = '" + surName + '\'' +
                ", creditRating = " + creditRating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(surName, customer.surName) &&
                creditRating == customer.creditRating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, creditRating);
    }
}
