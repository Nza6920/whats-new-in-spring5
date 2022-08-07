package com.niu.stream.p2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamNioTest {

    @Test
    void filesLinesTest() {
        Path path = new File(getClass().getResource("/stream/nio_datasource_1.txt").getFile()).toPath();
        try (Stream<String> content = Files.lines(path, Charset.defaultCharset())){
            List<String> collect = content.map(String::toUpperCase).sorted().collect(Collectors.toList());
            System.out.println(collect);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
