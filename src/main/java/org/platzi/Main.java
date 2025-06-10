package org.platzi;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*TODO ESTRUCTURA
        * id
        * description
        * status
        */
        Main app = new Main();
        app.fileVerificator();

        if(args.length > 0){
            System.out.println("Hay commando");
        } else {
            System.out.println("No hay commando");
        }

    }

    private void fileVerificator() throws IOException {
        File file = new File("tasks.json");
        if (!file.exists()){
            file.createNewFile();
        }
    }
}