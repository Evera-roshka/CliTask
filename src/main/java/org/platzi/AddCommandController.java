package org.platzi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import static org.platzi.Utils.errorHandler;

public class AddCommandController {
    File file;

    public AddCommandController(File file) {
        this.file = file;
    }

    public void addCommand(String[] args) throws IOException {
        try {
            FileWriter writer = new FileWriter(file, true);

            if (args.length == 2 ){
                Date date = new Date();
                int id = createId();
                if (id == 0){
                    errorHandler();
                    return;
                }
                writer.write(
                        "{" +
                                "\"id\":" + id + "," +
                                "\"title\": \"" + args[1] + "\"," +
                                "\"status\": \"pending\"," +
                                "\"createdAt\": \"" + date + "\"," +
                                "\"updatedAt\": \"" + date + "\"" +
                                "}\n"
                );
                System.out.println("Task added successfully (ID:" + id +")");
                writer.close();
            } else {
                errorHandler();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    public int createId() throws IOException{
        try{
            // Get all tasks
            List<String> taskLines = new ArrayList<>(Files.readAllLines(this.file.toPath()));
            if (taskLines.size() <= 0){ // see if the first task
                return 1;
            }
            String lastLine = taskLines.getLast();
            Function<String, Integer> getIndexTaskId = (task) -> task.lastIndexOf("\"id\":");
            Integer indexId = getIndexTaskId.apply(lastLine);

            if (taskLines.size() > 10){
                char cha1 = lastLine.charAt(indexId + 5);
                char cha2 = lastLine.charAt(indexId + 6);
                String number = String.valueOf(cha1 + cha2);
                return Integer.parseInt(number);
            }
            char cha = lastLine.charAt(indexId + 5);
            return Character.getNumericValue(cha) + 1;

        } catch (IOException e){
            System.out.println("Error " + e);
        }
        return 0;
    }

}
