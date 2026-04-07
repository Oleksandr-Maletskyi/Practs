package Assignment4;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathSafety {

    public static Path safeResolve(Path base, String userInput) {
        Path absoluteBase = base.toAbsolutePath().normalize();

        Path resolvedPath = base.resolve(userInput).toAbsolutePath().normalize();

        if (!resolvedPath.startsWith(absoluteBase)) {
            throw new IllegalArgumentException("Спроба Path Traversal! Небезпечний шлях: " + userInput);
        }

        return resolvedPath;
    }
}