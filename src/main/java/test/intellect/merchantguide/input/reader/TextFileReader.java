package test.intellect.merchantguide.input.reader;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class TextFileReader implements FileReader {

    @Override
    public List<String> read(String fileName) throws Exception {
        final URL resource = this.getClass().getClassLoader().getResource(fileName);
        if (resource == null) {
            throw new NoSuchFileException("No such file found with name: " + fileName);
        }
        return Files.readAllLines(Paths.get(resource.toURI()));
    }
}
