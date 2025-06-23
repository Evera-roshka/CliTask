package org.platzi;

import java.io.File;
import java.io.IOException;

import static org.platzi.Utils.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*TODO ESTRUCTURA
        * id
        * description
        * status
        * createdAt
        * updatedAt
        */
        File file = new File("tasks.json");
        if(!fileVerificator(file)){
            errorHandler();
        }

        if(args.length > 0){
            commandIdentificator(args, file);
        } else {
            errorHandler();
        }
    }

    public static void commandIdentificator(String[] args, File file) throws IOException{
        switch (args[0]){
            case "--add":
                AddCommandController addCommandController = new AddCommandController(file);
                addCommandController.addCommand(args);
                break;
            case "--update":
                UpdateCommandController.updateTitle(file, args[1], args[2]);
                break;
            case "--delete":
                DeleteCommandController.deleteTask(file, args[1]);
                break;
            case "--mark-done":
                System.out.println("It's mark-done command");
                break;
            case "--mark-in-progress":
                System.out.println("It's mark-in-progress command");
                break;
            case "--list":
                ListCommandController.listAllTasks(file);
                break;
            case "--help":
                helpCommand();
                break;
            default:
                errorHandler();
        }
    }
}