package strings;

public class RunLengthEncoding {

    public static void main(String[] args) {
        String str = "aAaAaaaaaAaaaAAAABbbbBBBB";
        System.out.println(runLengthEncoding(str));

        //1a1A1a1A5a1A3a4A1B3b4B
    }

    public static String runLengthEncoding(String string) {
        char[] strArr = string.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strArr.length - 1; i++) {
            int counter = 1;
            if (strArr[i] == strArr[i+1]) {
                counter++;
            }
            if (counter < 10) {
                result.append(counter).append(strArr[i]);
            } else {
                int value = strArr[i];
                int n = value / 9;
                int remainder = value % 9;
                for (int j = 0; j < n; j++) {
                    result.append("9").append(value);
                }
                result.append(remainder).append(value);
            }
        }

        return result.toString();
    }
}
