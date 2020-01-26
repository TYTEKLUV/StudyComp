package Folder;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws IOException {
        String newText;
        int ok=0;

        ArrayList<Token> tokens = new ArrayList();
        String split[];
        for (int i = 1; i<101; i++){
            boolean check = true;
            String fileName = String.format("%03din.pas",i);
            File file = new File("src/Tests/"+fileName);
            String text = Files.readString(Path.of(file.toURI()));
            Tokenizer tokenizer = new Tokenizer(text);
            Token token = tokenizer.next();

            fileName = String.format("%03dout.pas",i);
 //           System.out.println(fileName);
           // file = ;
           Scanner sc = new Scanner(new File("src/Tests/"+fileName));
//            System.out.println(sc.nextLine().split("\t")[3]);

            while (token.getType()!=TokenType.EOF) {
                if (sc.hasNext()){
                    split = sc.nextLine().split("\t");
                    if (Integer.parseInt(split[0]) != token.getLine()) {
                        check = false;
                    }
                    if (Integer.parseInt(split[1]) != token.getPosition()) {
                        check = false;
                    }
                    if (!split[2].equals(token.getType().name())) {
                        System.out.println(split[2]+" "+token.getType().name());
                        check = false;
                    }
                    if (!split[3].equals(token.getName())) {
                        System.out.println(split[3]+" "+token.getName());
                        check = false;
                    }

                }
                token = tokenizer.next();
            }

            if (check){
                System.out.println("Тест №"+i+" OK");
                ok++;
            } else {
                System.out.println("Тест №"+i+" NO");
            }

        }
        System.out.println("Результат: "+ok+"/100");
    }
}
