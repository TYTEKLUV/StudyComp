package Folder;

public enum Separator {
    COLON(":"),
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    DOUBLE_POINT(".."),
    COMMA(","),
    POINT("."),
    EMPTY_OP(";"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]");

    private String name;

    Separator(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static Separator getItem(String str){
        for(Separator separator: values()){
            if (separator.getName().equals(str)){
                return separator;
            }
        }
        return null;
    }
}
