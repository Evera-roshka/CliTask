package org.platzi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ListCommandController {
    public static void listAllTasks (File file) throws IOException {
        List<String> taskLines = new ArrayList<>(Files.readAllLines(file.toPath()));
        for (String task : taskLines) {
            System.out.println(task);
        }
    }
}
