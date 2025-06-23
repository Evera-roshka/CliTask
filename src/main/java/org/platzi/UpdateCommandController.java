package org.platzi;

import java.io.*;
import java.util.Arrays;

public class UpdateCommandController {
    public static void updateTitle(File originalFile, String idTarget, String newTask) throws IOException {
        File tempFile = new File("tasks_temp.json");

        BufferedReader reader = new BufferedReader(new FileReader(originalFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            if (currentLine.contains("\"id\":" + idTarget)) {
                String[] lines = currentLine.split(",");
                for(String line : lines){
                    if(line.contains("description")){
                        String[] descriptions = currentLine.split(" ");
                        descriptions[1] = newTask;
                        String newDescription = Arrays.toString(descriptions);
                        lines[0] = newDescription;
                    }
                }
                writer.write(newTask + System.lineSeparator());
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
