package playground;

public class NumberOfDigits {
    public static void main(String[] args) {
        String text = "000000444444";
        try {
            int number = Integer.parseInt(text);
            int length = (int) (Math.log10(number) + 1);
            System.out.println(length);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }



    }
}
