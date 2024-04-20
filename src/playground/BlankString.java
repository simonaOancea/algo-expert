package playground;

public class BlankString {
    public static void main(String[] args) {
        String text = "";
        System.out.println(isBlank(text));
        //System.out.println(StringUtils.isBlank(text));
    }


    private static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }
}
