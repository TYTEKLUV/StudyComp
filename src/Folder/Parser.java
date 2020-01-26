//package Folder;
//
//import java.util.ArrayList;
//import java.util.Stack;
//
//import static Folder.TokenType.*;
//
//public class Parser {
//
//    private Tokenizer tokenizer;
//
//    public ArrayList<Node> tree = new ArrayList<>();
//
//    public Parser(Tokenizer tokenizer) {
//        this.tokenizer = tokenizer;
//    }
//
//    public void nextToken() {
//        currentToken =  tokenizer.next();
//    }
//
//    Token currentToken = null;
//    boolean back = false;
//    Stack<NodeBlock> blockStack = new Stack<>();
//    Node currentNode = null;
//
//    public Node start(){
//        nextToken();
//        return program();
//
//
////        while (currentToken.getType()!= EOF){
////            switch (currentToken.getType()){
////                case KEY_WORD:
////                    keyWord();
////                    break;
////                case IDENTIFIER:
////                    parseIdentifier();
////                    break;
////                default:
////                    error("Синтаксическая ошибка. Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
////                    break;
////            }
////            if (!back) {
////                nextToken();
////            } else {
////                back = false;
////            }
////        }
//    }
//
//    private void parseIdentifier() {
//        NodeVariable newNode = new NodeVariable(currentToken);
//        nextToken();
//        if (currentToken.getName().equals(":=") || currentToken.getName().equals("-=") || currentToken.getName().equals("+=") || currentToken.getName().equals("*=") || currentToken.getName().equals("/=")){
//            NodeBinaryOperation operation = new NodeBinaryOperation(currentToken);
//            operation.left = newNode;
//            nextToken();
//            operation.right = expression();
//            if (!currentToken.getName().equals(";")){
//                error("Ожидалось ; Строка " + currentToken.getLine()); // ожидалось ;
//            }
//            if (blockStack.empty()){
//                error("Ожидалось begin Строка " + currentToken.getLine()); //ожидалось begin
//            }
//            blockStack.peek().list.add(operation);
//        }
//
//
//    }
//
//    public Node identifier(){
//        Token token = currentToken;
//        if (currentToken.getType()==IDENTIFIER){
//            nextToken();
//            return new NodeVariable(token);
//        } else {
//            error("Ожидался идентификатор. Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
//            return null;
//        }
//    }
//
//
//    public Node expression(){
//        Node node = term();
//        while(currentToken.getName().equals("+") || currentToken.getName().equals("-")){
//            Token token = currentToken;
//            nextToken();
//            node = new NodeBinaryOperation(node, token, term());
//        }
//        return node;
//    }
//
//    public Node factor(){
//        Token token = currentToken;
//        if (currentToken.getType()==INT || currentToken.getType()==REAL || currentToken.getType()==CHAR || currentToken.getType()==STRING || currentToken.getType()==IDENTIFIER){
//            nextToken();
//            return new NodeVariable(token);
//            } else if (currentToken.getName().equals("+") || currentToken.getName().equals("-")){
//                nextToken();
//                return new NodeUnaryOperation(token, factor());
//            } else if(currentToken.getName().equals("(")) {
//            nextToken();
//            Node node = expression();
//            if (currentToken.getName().equals(")")) {
//                return node;
//            } else {
//                error("Ожидалось выражение, а встречено ')'. Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//                return null;
//            }
//        } else {
//            error("Ожидалось выражение. Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//            return null;
//        }
//    }
//
//    public Node term(){
//        Node node = factor();
//        while(currentToken.getName().equals("*") || currentToken.getName().equals("/")){
//            Token token = currentToken;
//            nextToken();
//            node = new NodeBinaryOperation(node, token, factor());
//        }
//        return node;
//    }
//
//    public Node booleanFactor(){
//        Token token = currentToken;
//        if (currentToken.getType()==BOOLEAN){
//            nextToken();
//            return new NodeBinaryOperation(token);
//        } else if (currentToken.getName().equals("not")){
//            nextToken();
//            return new NodeBinaryOperation(null, token, factor());
//        } else if(currentToken.getName().equals("(")) {
//            nextToken();
//            Node node = booleanExpression();
//            if (currentToken.getName().equals(")")) {
//                return node;
//            } else {
//                error("Ожидалось выражение, а встречено ')'. Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//                return null;
//            }
//        } else {
//            Node node = expression();
//            if (currentToken.getName().equals(">") || currentToken.getName().equals("<") || currentToken.getName().equals("<=") || currentToken.getName().equals("<=") || currentToken.getName().equals("<>") || currentToken.getName().equals("=")){
//               token = currentToken;
//               nextToken();
//               node = new NodeBinaryOperation(node,token,expression());
//               return node;
//            }
//            error("Ожидалось выражение. Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//            return null;
//        }
//    }
//
//    public Node booleanTerm(){
//        Token token = currentToken;
//        if (currentToken.getName().equals("(")){
//            nextToken();
//            Node node = booleanFactor();
//            if (currentToken.getName().equals(")")) {
//                return node;
//            } else {
//                error("Ожидалось выражение, а встречено ')'. Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//                return null;
//            }
//        } else {
//            Node node = booleanFactor();
//            return node;
//        }
//    }
//
//    private Node booleanExpression() {
//        Node node = booleanTerm();
//        while(currentToken.getName().equals("and") || currentToken.getName().equals("or")){
//            Token token = currentToken;
//            nextToken();
//            node = new NodeBinaryOperation(node, token, booleanTerm());
//        }
//        return node;
//    }
//
//    private Node keyWord() {
//        Token token = currentToken;
//        switch (currentToken.getName()){
//            case "program":
//                nextToken();
//                return program();
//                break;
//            case "var":
//                parseVar();
//                break;
//            case "if":
//                parseIf();
//                break;
//            case "for":
//                //parseFor();
//                break;
//            case "while":
//               // parseWhile();
//                break;
//            case "read":
//                //parseRead();
//                break;
//            case "readln":
//                //parseRead();
//                break;
//            case "write":
//                //parseWrite();
//                break;
//            case "writeln":
//                //parseWrite();
//                break;
//            case "begin":
//                parseBlock();
//                break;
//            case "end":
//                parseEnd();
//                break;
//            default:
//                error("Данная функция пока не реализована.");
//                break;
//        }
//    }
//
//    private void parseIf() {
//        NodeIf newNode = new NodeIf(currentToken);
//        blockStack.peek().list.add(newNode); // перенести в конец
//        currentNode = newNode;
//        nextToken();
//        newNode.setCondition(booleanExpression());
//        if (!currentToken.getName().equals("then")){
//            error("Ожидалость then, а встречено " + currentToken.getName() + ". Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
//        }
//        nextToken();
//        //запарсить тело then
//        //проверить на else, если надо запарсить тело else
//        //вернуть весь блок
//
//
//
//
//    }
//
//
//    private void parseEnd() {
//        if (blockStack.empty()) {
//            error("Ожидалось begin, а встречено end. Строка " + currentToken.getLine());
//        }
//        nextToken();
//        NodeBlock block = blockStack.pop();
//        switch (currentToken.getName()){
//            case ";": // изменить при добавлении функций и процедур
//                if (blockStack.empty()){
//                    error("Ожидался конец программы. Строка " + currentToken.getLine()); //ожидался конец
//                }
//                block.setParent(currentNode);
//                //прикрепить блок
//                break;
//            case ".":
//                if (!blockStack.empty()){
//                    error("Неожиданный конец программы. Строка " + currentToken.getLine()); //неожиданный конец
//                }
//                nextToken();
//                if (currentToken.getType()!=EOF){
//                    error("Ожидался конец программы. Строка " + currentToken.getLine()); //ожидался конец файла
//                }
//                back = true;
//                tree.add(block);
//                break;
//            case "else":
//                back = true;
//                if (blockStack.empty()){
//                    error("Ожидался конец программы. Строка " + currentToken.getLine()); //ожидался конец
//                }
//                block.setParent(currentNode);
//                //прикрепить блок к then
//                break;
//            default:
//
//                break;
//        }
//    }
//
//    private void parseBlock() {
//        NodeBlock newBlock = new NodeBlock(currentToken);
//        blockStack.push(newBlock);
//    }
//
//    private void parseVar() {
//        NodeVar newNode = new NodeVar(currentToken);
//        nextToken();
//        NodeType type = new NodeType();
//        while (!currentToken.getName().equals("begin")) {
//            while (currentToken.getType() != KEY_WORD) {
//                if (currentToken.getType() == IDENTIFIER) {
//                    type.list.add(new NodeVariable(currentToken));
//                } else {
//                    error("Ожидался идентификатор. Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//                }
//                nextToken();
//                switch (currentToken.getName()) {
//                    case ",":
//                        nextToken();
//                        continue;
//                    case ":":
//                        nextToken();
//                        break;
//                    default:
//                        error("Ожидалось ':', а встречено "+ currentToken.getName() + ". Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//                        break;
//                }
//            }
//            if (currentToken.getName().equals("integer") || currentToken.getName().equals("real") || currentToken.getName().equals("char") || currentToken.getName().equals("string") || currentToken.getName().equals("boolean")){
//                type.setToken(currentToken);
//                nextToken();
//            } else {
//                error("Неизвестное имя " + currentToken.getName() + ". Строка " + currentToken.getLine());
//            }
//            if (!currentToken.getName().equals(";")){
//                error("Ожидалось ';', а встречено "+ currentToken.getName() + ". Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//            } else {
//                nextToken();
//            }
//        }
//        back = true;
//        tree.add(newNode);
//    }
//
//
//    private Node program(){
//        Token token = currentToken;
//        nextToken();
//
//    }
//    private void parseProgram() {
//        NodeProgram newNode = new NodeProgram(currentToken);
//        nextToken();
//        if (currentToken.getType()== IDENTIFIER){
//            newNode.setIdentifier((TokenIdentifier) currentToken);
//        } else {
//            error("Ожидался идентификатор. Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//        }
//        nextToken();
//        if (currentToken.getName().equals(";")){
//            tree.add(newNode);
//        } else {
//            error("Ожидалось ';', а встречено "+ currentToken.getName() + ". Строка " + currentToken.getLine() + ". Позиция " + currentToken.getPosition());
//        }
//    }
//
//    public void error(String message){
//        System.out.println("Ошибка парсера. " + message);
//        System.exit(0);
//    }
//}
