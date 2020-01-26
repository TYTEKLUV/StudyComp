package Folder;

import java.net.InetSocketAddress;
import java.util.ArrayList;

import static Folder.TokenType.*;

public class ParserNew {

    private Tokenizer tokenizer;
    private Token currentToken = null;

    public ParserNew(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public void nextToken() {
        currentToken =  tokenizer.next();
    }
    
    public void error(int code){
        switch (code){
            case 1:
                System.out.println("Ожидался идентификатор, а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 2:
                System.out.println("Ожидалось ';', а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 3:
                System.out.println("Ожидалось ':', а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 4:
                System.out.println("Ожидалось '(', а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 5:
                System.out.println("Ожидалось 'begin', а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 6:
                System.out.println("Синтаксическая ошибка.");
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 7:
                System.out.println("Ожидалось выражение, а встречено ')'.");
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 8:
                System.out.println("Ожидалось выражение.");
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 9:
                System.out.println("Ожидалось ')', а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 10:
                System.out.println("Ожидался конец файла, а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 11:
                System.out.println("Ожидалось 'then', а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 12:
                System.out.println("Ожидался оператор, а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 13:
                System.out.println("Ожидалось 'do', а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 14:
                System.out.println("Ожидалось ':=', а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            case 15:
                System.out.println("Ожидалось 'to', а встречено " + currentToken.getName());
                System.out.println("Строка " + currentToken.getLine() + " Позиция " + currentToken.getPosition());
                break;
            default:
                break;
        }
        System.exit(0);
    }


    private boolean checkType(TokenType type){
        if (currentToken.getType()==type){
            nextToken();
            return true;
        } else {
            return false;
        }
    }

    private boolean checkName(String name){
        if (currentToken.getName().equals(name)){
            nextToken();
            return true;
        } else {
            return false;
        }
    }



    public Node start(){
        nextToken();
        Node node = program();
        if (currentToken.getType()!=EOF){
            error(10);
        }
        return node;
    }

    private Node program() {
       Token token = currentToken;
       if (checkName("program")){
           Node idNode = identifier();
           if (checkName(";")){
               Node block = block();
               if (checkName(".")){
                   return new NodeProgram(token,idNode,block);
               }
           } else {
               error(2);
               return null;
           }
       } else {
           //без програма или ошибка
           error(1);
           return null;
       }
       return null;
    }

    private Node block() {
        Token token = currentToken;
        Node declaration = null;
        if (!currentToken.getName().equals("begin")) {
            declaration = declaration();
        }
        if (!currentToken.getName().equals("begin")){
            error(5);
        }
        Node statement = compound_statement();
        return new NodeBlock(token,(NodeDeclaration) declaration,statement);
    }

    private Node compound_statement() {
        Token token = currentToken;
        nextToken();
        ArrayList<Node> list = new ArrayList<>();
        list.add(statement());
        while (currentToken.getName().equals(";")){
            nextToken();
            if (checkName("end")){
                break;
            }
            list.add(statement());
        }
        return new NodeCompoundStatement(token, list);
    }

    private Node statement() {
        Token token = currentToken;
        if (currentToken.getName().equals("begin")){
            return compound_statement();
        } else if (currentToken.getType()==IDENTIFIER){
            nextToken();
            if (currentToken.getName().equals("(")){
                return new NodeCall(token,call_statement());
            } else if(currentToken.getName().equals(":=")){
                Token tokenOp = currentToken;
                nextToken();
                return new NodeBinaryOperation( new NodeVariable(token), tokenOp,expression());
            } else {
                error(6);
                return null;
            }
        } else if(currentToken.getType()==KEY_WORD){
            if (currentToken.getName().equals("if")){
                return ifStatement();
            }
            if (currentToken.getName().equals("while")){
                return whileStatement();
            }
            if (currentToken.getName().equals("for")){
                return forStatement();
            }
            if (currentToken.getName().equals("write") || currentToken.getName().equals("writeln")){
                nextToken();
                if (currentToken.getName().equals("(")) {
                    return new NodeCall(token, call_statement());
                } else {
                    error(4);
                }
            }
            if (currentToken.getName().equals("read") || currentToken.getName().equals("readln")){
                return readStatement();
            }
            error(12);
            return null;
        } else if (currentToken.getName().equals(";")){
            nextToken();
            return null;
        } else {
            error(6);
            return null;
        }
    }

    private Node readStatement() {
        Token token = currentToken;
        nextToken();
        if (!checkName("(")){
            error(4);
        }
        ArrayList<Node> list = new ArrayList<>();
        list.add(identifier());
        while (currentToken.getName().equals(",")){
            nextToken();
            list.add(identifier());
        }
        if (checkName(")")){
            return new NodeCall(token,list);
        } else {
            error(9);
            return null;
        }
    }

//    private Node writeStatement() {
//        return null;
//    }

    private Node forStatement() {
        Token token = currentToken;
        nextToken();
        Node var = identifier();
        if (!currentToken.getName().equals(":=")){
            error(14);
        }
        Token oper = currentToken;
        nextToken();
        Node rihgt = expression();
        if (!currentToken.getName().equals("to")){
            error(15);
        }
        nextToken();
        Node end = expression();
        if (!currentToken.getName().equals("do")){
            error(13);
        }
        Node node = body();
        if (currentToken.getName().equals(";")){
            return new NodeFor(token,new NodeBinaryOperation(var,oper,rihgt),end,node);
        } else {
            error(2);
            return null;
        }
    }

    private Node whileStatement() {
        Token token = currentToken;
        nextToken();
        Node condition = booleanExpression();
        if (!currentToken.getName().equals("do")){
            error(13);
        }
        Node node = body();
        if (currentToken.getName().equals(";")){
            return new NodeWhile(token,condition,node);
        } else {
            error(2);
            return null;
        }
    }

    private Node body() {
        Token token = currentToken;
        nextToken();
        if (currentToken.getName().equals("begin")){
            Node node = compound_statement();
            return new NodeBody(token,node);
        } else {
            Node node = statement();
            return new NodeBody(token,node);
        }
    }

    private Node ifStatement() {
        Token token = currentToken;
        nextToken();
        Node condition = booleanExpression();
        if (!currentToken.getName().equals("then")){
            error(11);
        }
        Node then = body();
        if (currentToken.getName().equals("else")){
            Node elseNode = body();
            if (currentToken.getName().equals(";")){
                return new NodeIf(token,condition,then,elseNode);
            } else{
                error(2);
                return null;
            }
        } else if (currentToken.getName().equals(";")){
            return new NodeIf(token,condition,then,null);
        } else {
            error(2);
            return null;
        }

    }

    private Node booleanFactor(){
        Token token = currentToken;
        if (currentToken.getType()==BOOLEAN){
            nextToken();
            return new NodeBinaryOperation(token);
        } else if (currentToken.getName().equals("not")){
            nextToken();
            return new NodeBinaryOperation(null, token, factor());
        } else if(currentToken.getName().equals("(")) {
            nextToken();
            Node node = booleanExpression();
            if (currentToken.getName().equals(")")) {
                return node;
            } else {
                error(9);
                return null;
            }
        } else {
            Node node = expression();
            if (currentToken.getName().equals(">") || currentToken.getName().equals("<") || currentToken.getName().equals("<=") || currentToken.getName().equals(">=") || currentToken.getName().equals("<>") || currentToken.getName().equals("=")){
                token = currentToken;
                nextToken();
                node = new NodeBinaryOperation(node,token,expression());
                return node;
            }
            error(8);
            return null;
        }
    }

    private Node booleanTerm(){
        if (currentToken.getName().equals("(")){
            nextToken();
            Node node = booleanFactor();
            if (currentToken.getName().equals(")")) {
                nextToken();
                return node;
            } else {
                error(9);
                return null;
            }
        } else {
            return booleanFactor();
        }
    }

    private Node booleanExpression() {
        Node node = booleanTerm();
        while(currentToken.getName().equals("and") || currentToken.getName().equals("or")){
            Token token = currentToken;
            nextToken();
            node = new NodeBinaryOperation(node, token, booleanTerm());
        }
        return node;
    }

    private ArrayList<Node> call_statement() {
        nextToken();
        if (checkName(")")){
            return null;
        }
        ArrayList<Node> param = new ArrayList<>();
        param.add(expression());
        while (currentToken.getName().equals(",")){
            nextToken();
            param.add(expression());
        }
        if (checkName(")")){
            return param;
        } else {
            error(9);
            return null;
        }
    }

    private Node expression(){
        Node node = term();
        while(currentToken.getName().equals("+") || currentToken.getName().equals("-")){
            Token token = currentToken;
            nextToken();
            node = new NodeBinaryOperation(node, token, term());
        }
        return node;
    }

    private Node term(){
        Node node = factor();
        while(currentToken.getName().equals("*") || currentToken.getName().equals("/") || currentToken.getName().equals("div") || currentToken.getName().equals("mod")){
            Token token = currentToken;
            nextToken();
            node = new NodeBinaryOperation(node, token, factor());
        }
        return node;
    }

    private Node factor(){
        Token token = currentToken;
        if (currentToken.getType()==INT || currentToken.getType()==REAL || currentToken.getType()==CHAR || currentToken.getType()==STRING || currentToken.getType()==IDENTIFIER){
            nextToken();
            return new NodeVariable(token);
        } else if (currentToken.getName().equals("+") || currentToken.getName().equals("-")){
            nextToken();
            return new NodeUnaryOperation(token, factor());
        } else if(currentToken.getName().equals("(")) {
            nextToken();
            Node node = expression();
            if (currentToken.getName().equals(")")) {
                return node;
            } else {
                error(7);
                return null;
            }
        } else {
            error(8);
            return null;
        }
    }


    private Node declaration() {
        Token token = currentToken;
        ArrayList<Node> list = new ArrayList<>();
        if (currentToken.getName().equals("var")){
            nextToken();
            list.add(variableDeclaration());
            while (currentToken.getName().equals(";")){
                nextToken();
                if (currentToken.getName().equals("begin") || currentToken.getName().equals("procedure")){
                    break;
                }
                list.add(variableDeclaration());
            }

        }
        while (currentToken.getName().equals("procedure")){
            list.add(procedureDeclaration());
        }
        return new NodeDeclaration(token,list);
    }

    private Node procedureDeclaration() {
        Token token = currentToken;
        nextToken();
        Node list = null;
        Node nodeId = identifier();
        if (currentToken.getName().equals("(")){
            list = formalParameterList();
        }
        if(checkName(";")){
            Node node = block();
            if (checkName(";")){
                return new NodeProcedure(token,nodeId,list,node);
            } else {
                error(4);
                return null;
            }
        } else {
            error(4);
            return null;
        }

    }

    private Node formalParameterList() { //возвращает штуку с листом тайпов
        Token token = currentToken;
        nextToken();
        ArrayList<Node> list = new ArrayList<>();
        list.add(formalParameters());
        while (currentToken.getName().equals(";")){
            nextToken();
            list.add(formalParameters());
        }
        return new NodeType(token,list);
    }

    private Node formalParameters() { // возвращает 1 тайп
        ArrayList<Node> list = new ArrayList<>();
        list.add(identifier());
        while (currentToken.getName().equals(",")){
            nextToken();
            list.add(identifier());
        }
        if (checkName(":")){
            Token tokenType = type();
            nextToken();
            return new NodeType(tokenType,list);
        } else {
            error(3);
            return null;
        }

    }

    private Node variableDeclaration() {
        ArrayList<Node> list = new ArrayList<>();
        list.add(identifier());
        while (currentToken.getName().equals(",")){
            nextToken();
            list.add(identifier());
        }
        if (checkName(":")){
            Token token = type();
            return new NodeType(token,list);
        } else {
            error(3);
            return null;
        }
    }

    private Token type(){
        if (currentToken.getName().equals("integer") || currentToken.getName().equals("string") || currentToken.getName().equals("boolean") || currentToken.getName().equals("char") || currentToken.getName().equals("real")){
            Token token = currentToken;
            nextToken();
            return token;
        } else {
            error(5);
            return null;
        }
    }

    private Node identifier() {
        Token token = currentToken;
        if (checkType(IDENTIFIER)){
            return new NodeVariable(token);
        } else {
            error(1);
            return null;
        }
    }
}
