package Folder;

public class Token {


    private int line;
    private int position;
    private TokenType type;
    private String name;
   // private String value;

    public Token(int line, int position, TokenType type, String name){

        this.line = line;
        this.position = position;
        this.type = type;
        this.name = name;
        //this.value = value;
    }

    @Override
    public String toString() {
        return String.format( "%d\t%d\t%s\t%s", line, position, type.name(), name);
    }

   // public String getValue() {
      //  return value;
    //}

    public String getName() {
        return name;
    }

    public TokenType getType() {
        return type;
    }

    public int getPosition() {
        return position;
    }

    public int getLine() {
        return line;
    }

}

class TokenString extends Token{

    private String value;

    public TokenString(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = name.substring(1,name.length()-1);
    }

    public String getValue() {
        return value;
    }
}

class TokenReal extends Token{

    private double value;

    public TokenReal(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = Double.parseDouble(name);
    }

    public double getValue() {
        return value;
    }
}

class TokenKeyWord extends Token{

    private KeyWord value;

    public TokenKeyWord(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = KeyWord.getItem(name);
    }

    public KeyWord getValue() {
        return value;
    }
}

class TokenSeparator extends Token{

    private Separator value;

    public TokenSeparator(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = Separator.getItem(name);
    }

}

class TokenInteger extends Token{

    private int value;

    public TokenInteger(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = Integer.parseInt(name);
    }
}

class TokenHex extends Token{

    private String value;

    public TokenHex(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = name;
    }
}

class TokenEReal extends Token{

    private String value;

    public TokenEReal(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = name;
    }
}

class TokenOperation extends Token{

    private Operation value;

    public TokenOperation(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = Operation.getItem(name);
    }
}

class TokenBoolean extends Token{

    private boolean value;

    public TokenBoolean(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = Boolean.parseBoolean(name);
    }
}

class TokenIdentifier extends Token{

    private String value;

    public TokenIdentifier(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = name;
    }
}

class TokenLogicOperation extends Token{

    private Operation value;

    public TokenLogicOperation(int line, int position, TokenType type, String name) {
        super(line, position, type, name);
        value = Operation.getItem(name);
    }
}

