package test.intellect.merchantguide.input.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.util.List;

@DisplayName("While testing TextFileReader")
class TextFileReaderTest {

    @Test
    @DisplayName("I should be able to read the data.txt file from test resources")
    void testReadCorrectFileName() throws Exception {
        FileReader fileReader = new TextFileReader();
        final List<String> lines = fileReader.read("data.txt");
        Assertions.assertEquals(1, lines.size(), "Should be only one line");
        Assertions.assertEquals("I am a test File", lines.get(0), "Should be 'I am a test File'");
    }

    @Test
    @DisplayName("I throw exception when 'data' is passed as file name")
    void testReadIncorrectFileName() throws Exception {
        FileReader fileReader = new TextFileReader();
        Assertions.assertThrows(
                NoSuchFileException.class,
                () -> fileReader.read("data"),
                "Should throw NoSuchFileException"
        );
    }
}