package Folder;

import java.util.ArrayList;

public class Node {
    public static int lvl = 0;
    Token token = null;

    public String indent(){
        String ind ="";
        for(int i = 1;i<=lvl-1;i++) {
            ind += "\t";
        }
        return ind;
    }

    public Node(Token token) {
        this.token = token;
    }

    public Node() {
    }

    public Token getToken() {
        return token;
    }

    public TokenIdentifier getIdentifier() {
        return null;
    }

    public void setToken(Token token) {
        this.token = token;
    }

}

class NodeProgram extends Node {
    private Node identifier;
    private Node block = null;

    public NodeProgram(Token token) {
        super(token);
    }

    public NodeProgram(Token token, Node identifier, Node block) {
        super(token);
        this.identifier = identifier;
        this.block = block;
    }

    @Override
    public String toString() {
        String text;
        text = this.token.getName() + " " + identifier.token.getName() + "\n";
        lvl++;
        text += indent() + block.toString();
        lvl--;
        return (text);
    }

}

class NodeVar extends Node {
    public ArrayList<NodeType> list = new ArrayList<>();

    public NodeVar(Token token) {
        super(token);
    }
}

class NodeType extends Node {
    public ArrayList<Node> list = new ArrayList<>();

    public NodeType(Token token, ArrayList<Node> list) {
        super(token);
        this.list = list;
    }

    @Override
    public String toString() {
        String text = "";
        text = "└─"+ token.getName() + "\n";
        lvl++;
        for (Node node : list) {
            text += indent() + node.token.getName() + "\n";
        }
        lvl--;
        return text;
    }
}

class NodeBinaryOperation extends Node {

    Node left = null;
    Node right = null;

    public NodeBinaryOperation(Token token) {
        super(token);
    }

    public NodeBinaryOperation(Node left, Token token, Node right) {
        this.left = left;
        this.right = right;
        this.token = token;
    }

    @Override
    public String toString() {
        String text = "";
        text = "└─"+ token.getName() + "\n";
        lvl++;
        text += indent() + left.toString();
        text += indent() + right.toString();
        lvl--;
        return text;
    }
}

class NodeUnaryOperation extends Node {
    Node argument = null;

    public NodeUnaryOperation(Token token) {
        super(token);
    }

    public NodeUnaryOperation(Token token, Node argument) {
        super(token);
        this.argument = argument;
    }
}

class NodeBlock extends Node {
    private NodeDeclaration description = null;
    private Node compound_statement = null;

    public NodeBlock(Token token, NodeDeclaration description, Node compound_statement) {
        super(token);
        this.description = description;
        this.compound_statement = compound_statement;
    }

    @Override
    public String toString() {
        String text = "";
        if (description != null) {
            text+= description.toString();
        }
        text+=indent() + compound_statement.toString()+"\n";
        return (text);
    }
}

class NodeVariable extends Node {
    public NodeVariable(Token token) {
        super(token);
    }

    @Override
    public String toString() {
        String text = "";
        text ="└─"+ token.getName() + "\n";
        return text;
    }
}

class NodeConst extends Node {
    public NodeConst(Token token) {
        super(token);
    }
}

class NodeIf extends Node {
    Node condition = null;
    Node then = null;
    Node _else = null;

    public NodeIf(Token token) {
        super(token);
    }

    public NodeIf(Token token, Node condition, Node then, Node _else) {
        super(token);
        this.condition = condition;
        this.then = then;
        this._else = _else;
    }
}

class NodeThen extends Node{
    Node statement = null;

    public NodeThen(Token token, Node statement) {
        super(token);
        this.statement = statement;
    }
}

class NodeDeclaration extends Node {
    private ArrayList<Node> blocks = new ArrayList<>();

    public NodeDeclaration(Token token, ArrayList<Node> blocks) {
        super(token);
        this.blocks = blocks;
    }

    public ArrayList<Node> getBlocks() {
        return blocks;
    }

    public String toString() {
        String text = "";

        return text;
    }
}

class NodeFunction extends Node {
    public NodeVar globalVar = null;
    public ArrayList<NodeType> localVar = new ArrayList<>();
    public NodeType type = null;

    public NodeFunction(Token token, NodeType type) {
        super(token);
        this.type = type;

    }
}

class NodeCompoundStatement extends Node {
    private ArrayList<Node> statement_list = new ArrayList<>();

    public NodeCompoundStatement(Token token, ArrayList<Node> statement_list) {
        super(token);
        this.statement_list = statement_list;
    }

    @Override
    public String toString() {
        String text = "";
        text = "└─"+  token.getName() + "\n";
        lvl++;
        for (Node node: statement_list) {
            text+=indent() + node.toString();
        }
        lvl--;
        return text;
    }
}

class NodeProcedure extends Node {
    private Node identifier;
    private Node block = null;
    private Node formalParameterList = null;

    public NodeProcedure(Token token, Node identifier, Node formalParameterList, Node block) {
        super(token);
        this.identifier = identifier;
        this.formalParameterList = formalParameterList;
        this.block = block;
    }
}

class NodeCall extends Node {
    private ArrayList<Node> parameters = new ArrayList<>();

    public NodeCall(Token token, ArrayList<Node> parameters) {
        super(token);
        this.parameters = parameters;
    }

}



