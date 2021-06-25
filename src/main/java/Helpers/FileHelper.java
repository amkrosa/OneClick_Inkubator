package Helpers;

import SeleniumBase.Base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHelper {

    private final Path directory;

    public FileHelper(String directory){
        this.directory = Path.of(directory);
    }
    public FileHelper(){
        this.directory = Path.of(Base.downloadFolder);
    }

    public int countFilesWithExtension(String extension){
        long result=-1;
        try (Stream<Path> walk = Files.walk(directory)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(extension))
                    .count();
        } catch (IOException ignored) {}

        return (int)result;
    }

    public void deleteFilesWithExtension(String extension){
        List<String> result = null;
        try (Stream<Path> walk = Files.walk(directory)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(extension))
                    .collect(Collectors.toList());
        } catch (IOException ignored) { }
        assert result != null;
        result.forEach(e-> {
            try {
                Files.delete(Path.of(e));
            } catch (IOException ignored) {}
        });
    }

    public Path getLatestFile() throws IOException {
        Optional<Path> opPath = Files.list(directory)
                .filter(p -> !Files.isDirectory(p))
                .sorted((p1, p2)-> Long.compare(p2.toFile().lastModified(), p1.toFile().lastModified()))
                .findFirst();

        return opPath.orElse(null);
    }

    public int getFileSizeInKb(Path file) throws IOException {
        return (int)Files.size(file)/1024;
    }

    public boolean isLatestFileNew() throws IOException {
        FileTime currentTime = FileTime.fromMillis(System.currentTimeMillis() - 5000);
        FileTime lastFile = Files.getLastModifiedTime(getLatestFile());
        int result = currentTime.compareTo(lastFile);
        if(result>0)
            return false;
        else return result < 0;
    }

}
