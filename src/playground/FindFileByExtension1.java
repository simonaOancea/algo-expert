package playground;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFileByExtension1 {

    public static void main(String[] args) {

        try {

            List<String> files = findFiles(Paths.get("C:\\Users\\SOancea\\Desktop\\Project Saves"), "xml");
            files.forEach(x -> System.out.println(x));

            /*List<String> fileNames = getFileNameFromPath(files);
            fileNames.forEach(x -> System.out.println(x));*/

            /*for (String fileName: fileNames) {
                String fileDate = extractDateFromFileName(fileName);
                Date fileDateConverted = convertStringToDate(fileDate);
                System.out.println("Dates are: " + extractDateFromFileName(fileDate));
                System.out.println("Converted string date to date is: " + fileDateConverted);
                System.out.println("Diffrence between current date and file creation date is: " + getDifference(fileDateConverted));
            }*/

            Map<String, Long> filesWithDiff = getFilesWithDiffCurrentTimeCreationDate(files);
            for (Map.Entry<String, Long> entry: filesWithDiff.entrySet()) {
                System.out.println(entry.getValue());
                if (entry.getValue() >= 0) {
                    System.out.println(entry.getKey());
                }
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        System.out.println("*********************************************************-------------------------------------***************************************");
    }

    public static List<String> findFiles(Path path, String fileExtension)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    // this is a path, not string,
                    // this only test if path end with a certain path
                    //.filter(p -> p.endsWith(fileExtension))
                    // convert path to string first
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(fileExtension))
                    .collect(Collectors.toList());
        }

        return result;
    }


    public static Map<String, Long> getFilesWithDiffCurrentTimeCreationDate(List<String> files) throws IOException, ParseException {
        Map<String, Long> filesWithCreationDate = new HashMap<>();
        if (files.size() > 0) {
            for (String file : files) {
                String fileCreationDate = getFileCreationDate(file);
                Date creationFileDate = convertStringToDate(fileCreationDate);
                long timeDifference = getDifference(creationFileDate);
                System.out.println("Difference is: " + timeDifference);
                filesWithCreationDate.put(file, timeDifference);
            }
        }

        return filesWithCreationDate;
    }

    public static String getFileCreationDate(String fileName) throws IOException {
        Path file = Paths.get(fileName);
        BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);

        return attributes.creationTime().toString();
    }

    public static Date convertStringToDate(String stringDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);

        return date;
    }

    public static long getDifference(Date date) {
        Date currentDate = new Date(System.currentTimeMillis());
        long millisecondsDiff = currentDate.getTime() - date.getTime();
        final long day = TimeUnit.MILLISECONDS.toDays(millisecondsDiff);

        return day;
    }

    public static boolean deleteFile(String fullFilePath) {
        if(fullFilePath != null) {
            System.gc();
            File file = new File(fullFilePath);
            if(file.exists()) {
                return file.delete();
            }
        }
        return false;
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


}
