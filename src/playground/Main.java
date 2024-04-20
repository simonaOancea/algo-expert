package playground;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        String path = "C:\\Users\\SOancea\\Desktop\\Project Saves";

        List<Path> dirs = Files.walk(Paths.get(path), 2)
                .filter(Files::isDirectory)
                .collect(Collectors.toList());

        System.out.println(dirs);
    }
}
