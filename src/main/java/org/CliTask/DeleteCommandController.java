package org.CliTask;

import java.io.*;

import static org.CliTask.Utils.*;

public class DeleteCommandController {
    public static void deleteTask(File originalFile, String idTarget) throws IOException {
        if(!isNumber(idTarget)){
            errorHandler("Id is not a number");
            return;
        }

        File tempFile = new File("tasks_temp.json");

        BufferedReader reader = new BufferedReader(new FileReader(originalFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        boolean findIdTarget = false;
        while ((currentLine = reader.readLine()) != null) {
            if (currentLine.contains("\"id\":" + idTarget)) {
                findIdTarget = true;
                continue;
            }
            writer.write(currentLine + System.lineSeparator());
        }

        writer.close();
        reader.close();

        isValidID(findIdTarget, idTarget); // Let's see if the id was found.
        deleteTempFile(originalFile, tempFile); // We replaced the original file with the temporary one.
    }
}
