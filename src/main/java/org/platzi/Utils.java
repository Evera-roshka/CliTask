package org.platzi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Utils {
    public static void errorHandler(){
        System.out.println("Don't recognize the instrucction. Use --help to see the availables commands");
    }
    public static boolean fileVerificator(File file) throws IOException {
        if (!file.exists()){
            return file.createNewFile();
        }
        return false;
    }



    public static void helpCommand(){
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
