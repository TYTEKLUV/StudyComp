package Folder;

public enum KeyWord {

    IF("if"),
    FUNCTION("function"),
    AND("and"),
    ARRAY("array"),
    BEGIN("begin"),
    CASE("case"),
    CONST("const"),
    DIV("div"),
    DO("do"),
    DOWNTO("downto"),
    ELSE("else"),
    END("end"),
    FOR("for"),
    MOD("mod"),
    NOT("not"),
    OR("or"),
    PROCEDURE("procedure"),
    PROGRAM("program"),
    RECORD("record"),
    REPEAT("repeat"),
    THEN("then"),
    TO("to"),
    TYPE("type"),
    UNTIL("until"),
    VAR("var"),
    WHILE("while"),
    INTEGER("integer"),
    REAL("real"),
    STRING("string"),
    BOOLEAN("boolean"),
    WRITE("write"),
    READ("read"),
    WRITELN("writeln"),
    READLN("readln"),
    OF("of"),
    LENGTH("length"),
    CHAR("char"),
    ABS("abs");



    private final String stringName;

    private KeyWord(String name){
        this.stringName = name;
    }

    public String getName() {
        return stringName;
    }

    public static KeyWord getItem(String str){
        for(KeyWord keyWord: values()){
            if (keyWord.getName().equals(str)){
                return keyWord;
            }
        }
        return null;
    }

}
