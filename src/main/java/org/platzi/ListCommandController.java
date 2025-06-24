package org.platzi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ListCommandController {
    public static void listAllTasks (File file, String filter) throws IOException {
        List<String> taskLines = new ArrayList<>(Files.readAllLines(file.toPath()));
        for (String task : taskLines) {
            if(filter.equalsIgnoreCase("all"))
                System.out.println(task);
            else if(filter.equalsIgnoreCase("not-done") && task.contains("pending"))
                System.out.println(task);
            else if(task.contains(filter))
                System.out.println(task);
        }
    }

}
