package Assignment3;

import java.io.IOException;
import java.nio.file.*;

public class InboxArchiver {

    public static void archiveTmpFiles(Path inbox, Path archive) throws IOException {
        if (!Files.exists(archive)) {
            Files.createDirectories(archive);
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(inbox, "*.tmp")) {
            for (Path file : stream) {
                Path targetPath = archive.resolve(file.getFileName());

                Files.move(file, targetPath, StandardCopyOption.REPLACE_EXISTING);

                System.out.println("Переміщено в архів: " + file.getFileName());
            }
        }
    }
}
