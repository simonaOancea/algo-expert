package equalshashcode;

import equalshashcode.Money;

public class EqualsHashcode {
    public static void main(String[] args) {
        Money income = new Money(55, "USD");
        Money expenses = new Money(55, "USD");

        // The default implementation of equals() in the Object class says that equality is
        // the same as object identity, and income and expenses are two distinct instances.
        boolean balanced = income.equals(expenses);

        System.out.println(balanced);
    }
}
