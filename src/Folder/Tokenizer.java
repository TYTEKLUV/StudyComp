package Folder;

import java.util.HashMap;
import java.util.function.Supplier;

public class Tokenizer {

    private String text;

    public Tokenizer(String text){
        this.text = text + "\n";
        createHashTable();
    }

    private HashMap<State, HashMap<Character, Supplier>> hashTable = new HashMap<>();

    private void createHashTable() {
        int i = 0;
        for (State state: State.values()){
            HashMap<Character, Supplier> row = new HashMap<>();
            for (int j = 0; j<alphabet.length; j++){
                row.put(alphabet[j], statesTable[i][j]);
            }
            hashTable.put(state, row);
            i++;
        }
    }

    private char[] alphabet = {'\t', '\r', '\n', ' ', '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2',	'3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~'};

    private Supplier[][] statesTable = {{this::nothing, this::nothing, this::increaseLine, this::nothing, this::error, this::error, this::error, this::error, this::error, this::error, this::goString, this::returnSeparator, this::returnSeparator, this::goOperation, this::goPlus, this::returnSeparator, this::goMinus, this::goPoint, this::goSlash, this::goInteger, this::goInteger, this::goInteger, this::goInteger, this::goInteger, this::goInteger, this::goInteger, this::goInteger, this::goInteger, this::goInteger, this::goColon, this::returnSeparator, this::goLogicOperation, this::returnLogicOperation, this::goLogicOperation, this::error, this::error, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::returnSeparator, this::error, this::returnSeparator, this::error, this::goWord, this::error, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::goWord, this::error, this::error, this::error, this::error},
        {this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::returnString, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol},
        {this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOperationBack, this::error, this::error, this::returnOperationBack, this::error, this::returnOperationBack, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::returnOperation, this::error, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::returnOperationBack, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error},
        {this::returnIntegerBack, this::returnIntegerBack, this::returnIntegerBack, this::returnIntegerBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnIntegerBack, this::returnIntegerBack, this::returnIntegerBack, this::returnIntegerBack, this::returnIntegerBack, this::goReal, this::returnIntegerBack, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::returnIntegerBack, this::returnIntegerBack, this::returnIntegerBack, this::returnIntegerBack, this::returnIntegerBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnIntegerBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error},
        {this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOperation, this::error, this::error, this::error, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::error, this::error, this::error, this::error, this::returnSeparatorBack, this::error, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::error, this::error, this::error, this::error},
        {this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOperationBack, this::error, this::error, this::returnLogicOperationBack, this::error, this::returnLogicOperationBack, this::error, this::error, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::error, this::error, this::error, this::returnLogicOperation, this::returnLogicOperation, this::error, this::error, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::error, this::error, this::error, this::error, this::returnLogicOperationBack, this::error, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::returnLogicOperationBack, this::error, this::error, this::error, this::error},
        {this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::error, this::error, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::returnWordBack, this::error, this::returnWordBack, this::error, this::addSymbol, this::error, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::error, this::error, this::error, this::error},
        {this::returnRealBack, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::returnIntegerDoubleBack, this::returnRealBack, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::error, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnRealBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error},
        {this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::error, this::error, this::goComment, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::returnOperation, this::error, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::returnOperationBack, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error},
        {this::addSymbol, this::returnComment, this::returnComment, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol},
        {this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::returnOperationBack, this::error, this::error, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::returnOperation, this::error, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::returnOperationBack, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error},
        {this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::returnOperationBack, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::returnOperation, this::error, this::error, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error, this::returnOperationBack, this::error, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::returnOperationBack, this::error, this::error, this::error, this::error},
        {this::error, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnSeparator, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::error, this::error, this::error, this::error, this::returnSeparatorBack, this::error, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::returnSeparatorBack, this::error, this::error, this::error, this::error}};

    private State goPoint() {
        addSymbol();
        return State.POINT;
    }

    private State nothing() { return State.START; }

    private State addSymbol() {
        tokenName += String.valueOf(currentSymbol);
        return currentState;
    }

    private State increaseLine() {
        line++;
        position = 1;
        return State.START;
    }

    private State goComment() { return State.COMMENT; }

    private State goWord() {
        addSymbol();
        return State.WORD;
    }

    private State goLogicOperation() {
        addSymbol();
        return State.LOGIC_OPERATION;
    }

    private State goColon() {
        addSymbol();
        return State.COLON;
    }

    private State goReal() {
        addSymbol();
        return State.REAL;
    }

    private State goMinus() {
        addSymbol();
        return State.MINUS;
    }

    private State goSlash() {
        addSymbol();
        return State.SLASH;
    }

    private State goInteger() {
        addSymbol();
        return State.INTEGER;
    }

    private State goPlus() {
        addSymbol();
        return State.PLUS;
    }

    private State goOperation() {
        addSymbol();
        return State.OPERATION;
    }

    private State goString() {
        addSymbol();
        return State.STRING;
    }

    private State returnString() {
        addSymbol();
        currentToken = new TokenString(line, position-tokenName.length(), TokenType.STRING, tokenName);
        return State.START;
    }

    private State returnComment() {
        index--;
        position--;
        tokenName  = "";
        return State.START;
    }

    private State returnSeparator() {
        addSymbol();
        currentToken = new TokenSeparator(line, position-tokenName.length(), TokenType.SEPARATOR, tokenName);
        return State.START;
    }

    private State returnOperation() {
        addSymbol();
        currentToken = new TokenOperation(line, position-tokenName.length(), TokenType.OPERATION, tokenName);
        return State.START;
    }

    private State returnLogicOperation() {
        addSymbol();
        currentToken = new TokenLogicOperation(line, position-tokenName.length(), TokenType.LOGIC_OPERATION, tokenName);
        return State.START;
    }

    private State returnRealBack() {
        index--;
        position--;
        currentToken = new TokenReal(line, position-tokenName.length(), TokenType.REAL, tokenName);
        return State.START;
    }

    private State returnWordBack() {
        index--;
        position--;
        tokenName = tokenName.toLowerCase();
        if (tokenName.equals("true")||tokenName.equals("false")){
            currentToken = new TokenBoolean(line, position-tokenName.length(), TokenType.BOOLEAN, tokenName);
            return State.START;
        }
        for(KeyWord keyWord: KeyWord.values()){
            if (keyWord.getName().equals(tokenName)){
                currentToken = new TokenKeyWord(line, position-tokenName.length(), TokenType.KEY_WORD, tokenName);
                return State.START;
            }
        }
        currentToken = new TokenIdentifier(line, position-tokenName.length(), TokenType.IDENTIFIER, tokenName);
        return State.START;
    }

    private State returnSeparatorBack() {
        index--;
        position--;
        currentToken = new TokenSeparator(line, position-tokenName.length(), TokenType.SEPARATOR, tokenName);
        return State.START;
    }

    private State returnIntegerBack() {
        index--;
        position--;
        currentToken = new TokenInteger(line, position-tokenName.length(), TokenType.INT, tokenName);
        return State.START;
    }

    private State returnOperationBack() {
        index--;
        position--;
        currentToken = new TokenOperation(line, position-tokenName.length(), TokenType.OPERATION, tokenName);
        return State.START;
    }

    private State returnLogicOperationBack() {
        index--;
        position--;
        currentToken = new TokenLogicOperation(line, position-tokenName.length(), TokenType.LOGIC_OPERATION, tokenName);
        return State.START;
    }

    private State returnIntegerDoubleBack() {
        index-=2;
        position-=2;
        tokenName = tokenName.substring(0,tokenName.length()-1);
        currentToken = new TokenInteger(line, position-tokenName.length(), TokenType.INT, tokenName);
        return State.START;
    }

    private State error() {
        System.out.println("Ошибка: строка " + line + " позиция " + (position-1) + ". Неожиданный символ: " + text.charAt(index-1));
        System.exit(0);
        return null;
    }

    private int line = 1;
    private int position = 1;
    private int index = 0;
    private char currentSymbol = ' ';
    private State currentState = State.START;
    private String tokenName = "";
    private Token currentToken = null;


    public Token next() {
        while (index<text.length()) {
            currentSymbol = text.charAt(index);
            index++;
            position++;
            currentState = (State) hashTable.get(currentState).get(currentSymbol).get();
            if (currentToken!=null){
                tokenName = "";
                Token result = currentToken;
                currentToken = null;
                return result;
            }
        }
        return new Token(0,0, TokenType.EOF, "КОНЕЦ!");
    }

    private Token previousToken = null;

    public void backToken(Token token) {
        previousToken = token;
    }
}
