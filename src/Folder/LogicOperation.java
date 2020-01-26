package Folder;

public enum LogicOperation {
    MORE(">"),
    LESS("<"),
    MORE_OR_EQUAL(">="),
    LESS_OR_EQUAL("<=");

    private String name;

    LogicOperation(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static LogicOperation getItem(String str){
        for(LogicOperation operation: values()){
            if (operation.getName().equals(str)){
                return operation;
            }
        }
        return null;
    }
}
