package org.platzi;

import java.io.*;
import java.util.Arrays;

public class DeleteCommandController {
    public static void deleteTask(File originalFile, String idTarget) throws IOException {
        File tempFile = new File("tasks_temp.json");

        BufferedReader reader = new BufferedReader(new FileReader(originalFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            if (currentLine.contains("\"id\":" + idTarget)) {
                continue;
            }
            writer.write(currentLine + System.lineSeparator());
        }

        writer.close();
        reader.close();

        // Reemplazamos el archivo original con el temporal
        if (originalFile.delete()) {
            tempFile.renameTo(originalFile);
        } else {
            System.out.println("No se pudo borrar el archivo original.");
        }
    }
}
