package org.platzi;

import java.io.File;
import java.io.IOException;

import static org.platzi.Utils.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // Create or verify the existence of the file
        File file = new File("tasks.json");
        if(fileVerificator(file)){
            errorHandler("An error occurred while creating the file");
        }

        // Verify the command
        if(args.length > 0){
            commandIdentificator(args, file);
        } else {
            errorHandler("Don't recognize the instrucction. Use --help to see the availables commands");
        }
    }

    public static void commandIdentificator(String[] args, File file) throws IOException{
        switch (args[0]){
            case "--add":
                if (args.length == 2)
                    AddCommandController.addCommand(file, args);
                else
                    errorHandler("To add you need to use the command --add + description");
                break;

            case "--update":
                if (args.length == 3)
                    UpdateCommandController.updateTitle(file, args[1], args[2]);
                else
                    errorHandler("To update you need to use the command --update + id + description");
                break;

            case "--delete":
                if (args.length == 2)
                    DeleteCommandController.deleteTask(file, args[1]);
                else
                    errorHandler("To delete you need to use the command --delete + id");
                break;

            case "--mark-done":
                MarkStatusController.markStatus(file, args[1], "done");
                break;

            case "--mark-in-progress":
                MarkStatusController.markStatus(file, args[1], "in progress");
                break;

            case "--list":
                ListCommandController.listAllTasks(file);
                break;

            case "--help":
                helpCommand();
                break;

            default:
                errorHandler("Don't recognize the instrucction. Use --help to see the availables commands");
        }
    }
}