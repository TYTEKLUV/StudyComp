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
    ABS("abs"),
    AS("as"),
    AUTO("auto"),
    CLASS("class"),
    CONSTRUCTOR("constructor"),
    DESTRUCTOR("destructor"),
    EVENT("event"),
    EXCEPT("excepr"),
    EXTENSIONMETHOD("extensionmethod"),
    FILE("file"),
    FINALIZATOR("finalizator"),
    FINALLY("finally"),
    FOREACH("foreach"),
    GOTO("goto"),
    IMPLEMENTATION("implementation"),
    IN("in"),
    INHERITED("inherited"),
    INITIALIZATION("initialization"),
    INTERFACE("interface"),
    IS("is"),
    LABEL("label"),
    LOCK("lock"),
    LOOP("loop"),
    NIL("nil"),
    OPERATOR("operator"),
    PROPERTY("property"),
    RAISE("raise"),
    SEALED("sealed"),
    SET("set"),
    SEQUENCE("sequence"),
    SHL("shl"),
    SHR("shr"),
    SIZEOF("sizeof"),
    TEMPLATE("template"),
    TRY("try"),
    TYPEOF("typeof"),
    USES("uses"),
    USING("using"),
    WHERE("where"),
    WITH("with"),
    XOR("xor");







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
