package Folder;

public enum Operation {
    PLUS("+"),
    MINUS("-"),
    STAR("*"),
    SLASH("/");

    private String name;

    Operation (String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static Operation getItem(String str){
        for(Operation operation: values()){
            if (operation.getName().equals(str)){
                return operation;
            }
        }
        return null;
    }
}
