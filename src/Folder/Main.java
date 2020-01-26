package Folder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {


    public static void main(String[] args) throws IOException {
        File file = new File("src/Folder/Program.pas");
        String text = Files.readString(Path.of(file.toURI()));

        Tokenizer tokenizer = new Tokenizer(text);
        Parser parser = new Parser(tokenizer);
        Node tree = parser.start();
        System.out.println(tree);

//        Token token = tokenizer.next();
//
//        while (token.getType()!=TokenType.EOF) {
//            System.out.println(token);
//            token = tokenizer.next();
//        }

    }
}
