package equalshashcode;

public class Money {
    int amount;
    String currencyCode;

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    // The equals method must be:
    // - reflexive: an object must equal itself
    // - symmetric: x.equals(y) must return the same result as y.equals(x)
    // - transitive: if x.equals(y) and y.equals(z), then x.equals(z)
    // - consistent: the value of equals() should change only if a property that is contained in equals() changes (no randomness allowed)
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Money)) {
            return false;
        }
        Money other = (Money) o;
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
                || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));

        return this.amount == other.amount && currencyCodeEquals;
    }
}
