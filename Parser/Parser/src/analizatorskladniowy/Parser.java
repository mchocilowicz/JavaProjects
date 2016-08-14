package analizatorskladniowy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Parser {
    
    private String expression;
    private int index;
    private boolean isCorrect;
    
    public boolean analyzeExpression(String expression) {
        this.expression = expression; 
        this.index = -1; 
        this.isCorrect = true; 
        
        if (!readNextChar()) { 
            return isCorrect = false;
        }
        if (expression.charAt(index) == '-') { 
            if(!readNextChar()) {
                return isCorrect = false;
            }
        }
        index--; 
        W();
        if (readNextChar())
            isCorrect = false;
        return isCorrect;
    }
    
    private void W() {
        if(!readNextChar())
            isCorrect = false;
        if (expression.charAt(index) == '(') {
            if(!readNextChar())
                isCorrect = false;
            if (expression.charAt(index) != '-')
                index--;
            W();
            if(!readNextChar())
                isCorrect = false;
            if (expression.charAt(index) != ')')
                isCorrect = false;
            if (readNextChar()) {
                if (isOperator(expression.charAt(index))) {
                    W();
                } else
                    index--;
            }
        } else if (isDigit(expression.charAt(index))) {
            while (readNextChar()) {
                if(!isDigit(expression.charAt(index))) {
                    index--;
                    break;
                }
            }
            if (readNextChar()) {
                if (expression.charAt(index) == '.') {
                    if(!readNextChar())
                        isCorrect = false;
                    if (isDigit(expression.charAt(index))) {
                        while (readNextChar()) {
                            if(!isDigit(expression.charAt(index))) {
                                index--;
                                break;
                            }
                        }
                        if (readNextChar()) {
                            if (isOperator(expression.charAt(index))) {
                                W();
                            } else if(expression.charAt(index) == ')')
                                index--;
                            else
                                isCorrect = false;
                        }
                    } else
                        isCorrect = false;
                } else if (isOperator(expression.charAt(index))) {
                    W();
                } else if(expression.charAt(index) == ')')
                    index--;
                else
                    isCorrect = false;
            }
        } else
            isCorrect = false;
    }
    
    private boolean readNextChar() {
        if(index + 1 < expression.length()) {
            index++;
            return true;
        }
        return false;
    }
    
    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }
    
    private boolean isOperator(char c) {
        Set<Character> operators = new HashSet<>(Arrays.asList('+', '-', '*', '/', '^'));
        return operators.contains(c);
    }
}
