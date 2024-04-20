package playground;

public class ValidNumber {
    public static void main(String[] args) {
       // System.out.println(isValidNumber("09999"));

       // int number = Integer.parseInt("09999");

        System.out.println(isValidNumber(null));

    }
    private static boolean isValidNumber(String text) {
        boolean isNumber = true;
        try {
            int number = Integer.parseInt(text);
            if(number <= 0) {
                isNumber = false;
            }
        } catch(NumberFormatException ex) {
            isNumber = false;
        }

        return isNumber;
    }
}
