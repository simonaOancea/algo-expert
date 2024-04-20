package playground;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFile {

    private static Pattern DATE_PATTERN = Pattern.compile(
            "^((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26]))-02-29)$"
                    + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");

    public static void main(String[] args) throws IOException {
        /*Path path = Paths.get("C:\\Users\\SOancea\\Desktop\\Project Saves");
        String sequence = "010_020_030_098";
        List<String> files = findFilenamesContaining(path, sequence);
        List<String> shortFileNames = getFileNameFromPath(files);


        for (String file : shortFileNames) {
          //  System.out.println(dateValidator(file, "yyyy/MM/dd"));
          //  System.out.println(matches("2022-10-11"));
            System.out.println(dateValidator(extractDateFromFileName(file), "yyyy-MM-dd"));
        }*/


        String url = "C:\\Users\\SOancea\\Desktop\\Project Saves\\010_020_030_098-2022-05-26_16-20_1.xml";
        String emptyUrl = null;
        String[] fileInfo = getFileInfo(emptyUrl);

        for (int i = 0; i < fileInfo.length; i++) {
            System.out.println("File info is: " + fileInfo[i]);
        }
    }


    public static List<String> findFilenamesContaining(Path path, CharSequence sequence) throws IOException {
        List<String> result;
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }
        try (Stream<Path> walk = Files.walk(path, 1)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString())
                    .filter(f -> f.contains(sequence))
                    .collect(Collectors.toList());
        }

        return result;
    }

    public static boolean dateValidator(final String dateStr, final String dateFormat) {
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    public static boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }

    public static List<String> getFileNameFromPath(List<String> fileList) {
        List<String> fileNameList = new ArrayList<>();
        for (String absoluteFilePath : fileList) {
            int index = absoluteFilePath.lastIndexOf('\\');
            if (index > 0) {
                String fileName = absoluteFilePath.substring(index + 1);
                fileNameList.add(fileName);
            }
        }

        return fileNameList;
    }

    public static String extractDateFromFileName(String fileName) {
        int fileNameLength = fileName.length();
        String creationDate = "";
        if(fileNameLength >= 26) {
            creationDate = fileName.substring(16, 26);
        }
        return creationDate;
    }

    public static String[] getFileInfo(String url) {
        String[] result = new String[4];
        String fileName = new File(url).getName();
        int dot = fileName.lastIndexOf('.');
        Path p = Paths.get(url);
        Path folder = p.getParent();
        result[0] = (null == folder) ? "" : folder.toString();
        result[1] = fileName;
        result[2] = (dot == -1) ? fileName : fileName.substring(0, dot);
        result[3] = (dot == -1) ? "" : fileName.substring(dot + 1);
        return result;
    }



}
