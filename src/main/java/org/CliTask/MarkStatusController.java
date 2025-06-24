package org.CliTask;

import java.io.*;
import java.util.Date;

import static org.CliTask.Utils.*;
import static org.CliTask.Utils.deleteTempFile;

public class MarkStatusController {
    public static void markStatus(File originalFile, String idTarget, String newStatus) throws IOException {
        if(!isNumber(idTarget)){
            errorHandler("Id is not a number");
            return;
        }

        File tempFile = new File("tasks_temp.json");
        boolean findIdTarget = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains("\"id\":" + idTarget)) {
                    findIdTarget = true;
                    // Replace the value of 'description'
                    currentLine = currentLine.replaceAll(
                            "\"status\"\\s*:\\s*\"[^\"]*\"",
                            "\"status\":\"" + newStatus + "\""
                    );
                    currentLine = currentLine.replaceAll(
                            "\"updatedAt\"\\s*:\\s*\"[^\"]*\"",
                            "\"updatedAt\":\"" + new Date() + "\""
                    );
                }

                writer.write(currentLine + System.lineSeparator());
            }
        }

        isValidID(findIdTarget, idTarget); // Let's see if the id was found.
        deleteTempFile(originalFile, tempFile); // We replaced the original file with the temporary one.

    }
}
