package com.letscode.general;

import com.google.common.collect.Lists;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static final int ELEMENTS_BY_GROUP = 2;
    public static final int INITIAL_GROUP_NUMBER = 1;
    public static final String GROUP_LABEL = "Group %02d";
    public static final String FILE_NAME = "elements.txt";

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(Main.class.getClassLoader().getResource(FILE_NAME).toURI());
        List<String> elements = Files.readAllLines(path, StandardCharsets.UTF_8);

        Collections.shuffle(elements);
        AtomicInteger ind = new AtomicInteger(INITIAL_GROUP_NUMBER);
        Lists.partition(elements, ELEMENTS_BY_GROUP)
                .forEach(group -> {
                    System.out.println(GROUP_LABEL.formatted(ind.getAndIncrement()));
                    group.forEach(System.out::println);
                    System.out.println();
                });
    }
}
