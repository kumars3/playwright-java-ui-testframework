package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    private FileUtils(){
    }

    public static Path ensureDirectory(String directoryPath) {
        try {
            Path path = Paths.get(directoryPath);
            if (!path.toFile().exists()) {
                Files.createDirectories(path);
            }
            return path;
        } catch (IOException e) {
            throw new RuntimeException("Unable to create directory: " + directoryPath, e);
        }
    }

    public static String santitizeFileName(String str)
    {
        return str.replaceAll("[\\\\/:*?\"<>|]", "_");
    }
}



