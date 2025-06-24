package org.platzi;

import java.io.File;
import java.io.IOException;

import static org.platzi.Utils.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // Create or verify the existence of the file
        File file = new File("tasks.json");
        if(fileVerificator(file))
            errorHandler("An error occurred while creating the file");

        // Verify the command
        if(args.length > 0)
            commandIdentifier(args, file);
        else
            errorHandler("Don't recognize the instrucction. Use --help to see the availables commands");
    }

    public static void commandIdentifier(String[] args, File file) throws IOException{
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
                if (args.length == 2)
                    MarkStatusController.markStatus(file, args[1], "done");
                else
                    errorHandler("To mark done you need to use the command --mark-done + id");
                break;

            case "--mark-in-progress":
                if (args.length == 2)
                    MarkStatusController.markStatus(file, args[1], "in progress");
                else
                    errorHandler("To mark in progress you need to use the command --mark-in-progress + id");
                break;

            case "--list":
                if (args.length == 1)
                    ListCommandController.listAllTasks(file, "all");
                else if (args.length == 2)
                    ListCommandController.listAllTasks(file, args[1]);
                else
                    errorHandler("To list you need to use the command --list + status or only --list for all tasks");
                break;

            case "--help":
                helpCommand();
                break;

            default:
                errorHandler("Don't recognize the instrucction. Use --help to see the availables commands");
        }
    }
}