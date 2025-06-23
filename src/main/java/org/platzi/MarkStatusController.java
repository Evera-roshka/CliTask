package org.platzi;

import java.io.*;
import java.util.Date;

public class MarkStatusController {
    public static void markStatus(File originalFile, String idTarget, String newStatus) throws IOException {
        File tempFile = new File("tasks_temp.json");

        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains("\"id\":" + idTarget)) {
                    // Reemplazar el valor de "description"
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

        // Reemplazamos el archivo original con el temporal
        if (originalFile.delete()) {
            if (!tempFile.renameTo(originalFile)) {
                System.out.println("No se pudo renombrar el archivo temporal.");
            }
        } else {
            System.out.println("No se pudo borrar el archivo original.");
        }
    }
}
