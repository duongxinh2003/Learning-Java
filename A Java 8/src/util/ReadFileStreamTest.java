package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileStreamTest {
  public static void main(String[] args) throws IOException {
    Stream<String> stream = Files.lines(Paths.get("src/util/lines.txt"));
    stream.onClose(() -> System.out.println("Read done!!!")).forEach(s -> System.out.println(s));
    stream.close();
  }
}
