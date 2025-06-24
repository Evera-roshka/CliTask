package org.CliTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Utils {
    public static void errorHandler(String message){
        System.out.println(message);
    }
    public static boolean fileVerificator(File file) throws IOException {
        if (!file.exists()){
            return file.createNewFile();
        }
        return false;
    }

    public static boolean isNumber(String number){
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static void helpCommand(){
        List<String> commandsList = new ArrayList<>(Arrays.asList(
                "--add following the description to add a task",
                "--update following with the id target and the description to update the task",
                "--delete following the id to delete a task",
                "--mark-done following the id to mark done a task",
                "--mark-in-progress following the id to mark in progress a task",
                "--list to see all tasks, or with status (done, in progress, not done) to filter tasks",
                "--help to see all commands"
        ));
        commandsList.forEach(System.out::println);
    }

    public static void isValidID(boolean findIdTarget, String idTarget){
        if (findIdTarget)
            System.out.println("The task with the ID " + idTarget + " was found and operated on");
        else
            System.out.println("The task with ID " + idTarget + " was not found");
    }

    public static void deleteTempFile(File originalFile, File tempFile) {
        if (originalFile.delete()) {
            if (!tempFile.renameTo(originalFile)) {
                System.out.println("No se pudo renombrar el archivo temporal.");
            }
        } else {
            System.out.println("No se pudo borrar el archivo original.");
        }
    }
}
