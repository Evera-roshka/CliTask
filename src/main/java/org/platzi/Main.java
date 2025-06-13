package org.platzi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        /*TODO ESTRUCTURA
        * id
        * description
        * status
        * createdAt
        * updatedAt
        */

        fileVerificator();

        if(args.length > 0){
            commandIdentificator(args);
        } else {
            errorHandler();
        }
    }

    private static void errorHandler(){
        System.out.println("Don't recognize the instrucction. Use --help to see the availables commands");
    }
    private static void fileVerificator() throws IOException {
        File file = new File("tasks.json");
        if (!file.exists()){
            file.createNewFile();
        }
    }

    private static void commandIdentificator(String[] args) throws IOException{
        switch (args[0]){
            case "--add":
                System.out.println("It's add command");
                addCommand(args);
                break;
            case "--update":
                System.out.println("It's update command");
                break;
            case "--delete":
                System.out.println("It's delete command");
                break;
            case "--mark-done":
                System.out.println("It's mark-done command");
                break;
            case "--mark-in-progress":
                System.out.println("It's mark-in-progress command");
                break;
            case "--list":
                System.out.println("It's list command");
                break;
            case "--help":
                helpCommand();
                break;
            default:
                errorHandler();
        }
    }

    private static void addCommand(String[] args) throws IOException {
        try {
            File file = new File("tasks.json");
            FileWriter writer = new FileWriter(file, true);

            if (args.length == 2 ){
                Date date = new Date();
                int id = createId(file);
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

    private static int createId(File file) throws IOException{
        try{
            // Get all tasks
            List<String> taskLines = new ArrayList<>(Files.readAllLines(file.toPath()));
            if (taskLines.size() <= 0){ // see if the first task
                return 1;
            }
            String lastLine = taskLines.getLast();
            Function<String, Integer> getIndexTaskId = (task) -> task.lastIndexOf("\"id\":");
            Integer indexId = getIndexTaskId.apply(lastLine);

            char cha = lastLine.charAt(indexId + 5);
            return Character.getNumericValue(cha) + 1;

        } catch (IOException e){
            System.out.println("Error " + e);
        }
        return 0;
    }

    private static void helpCommand(){
        List<String> commandsList = new ArrayList<>(Arrays.asList(
                "--add following the description to add a task",
                "--update following with the id target and the description to update the task",
                "--delete following the id to delete a task",
                "--mark-done following the id to mark done a task",
                "--mark-in-progress following the id to mark in progress a task",
                "--list to see all tasks, or with status (done, in-progress, not done) to filter tasks",
                "--help to see all commands"
        ));
        commandsList.forEach(System.out::println);
    }
}