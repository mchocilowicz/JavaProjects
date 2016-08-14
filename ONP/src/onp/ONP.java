package onp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class ONP {
    
    public String convertExpression(String expression) {
	Stack<String> stack = new Stack<>(); 
	StringBuilder result = new StringBuilder(); 
        String[] tokens = getTokens(expression);
        for (String token : tokens) {
            if(isOperator(token)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) && comparePriority(stack.peek(), token)) {
                    
                    result.append(stack.peek()).append(" ");
                    stack.pop(); 
                }
                stack.push(token); 
            } else if ("(".equals(token)) {
                stack.push(token);
            } else if (")".equals(token)) {
                while (!"(".equals(stack.peek())) {
                    result.append(stack.peek()).append(" ");
                    stack.pop();
                }
                stack.pop();
            } else if(isNumber(token)) { 
                result.append(token).append(" "); 
            }
	}

        while(!stack.empty()) 
	{
            result.append(stack.peek()).append(" ");
            stack.pop();
	}

	return result.toString(); 
    }
    
    private String[] getTokens(String expression) {
        return expression.split("(?<=[-+*/()])|(?=[-+*/()])");
    }
    
    private boolean comparePriority(String token1, String token2)
    {
	if ("^".equals(token1))
            return true; 
	else if ("^".equals(token2))
            return false; 
	else if ("*".equals(token1) || "/".equals(token1)) 
            return true;
	else if ("*".equals(token2) || "/".equals(token2))
            return false;
        return true;
    }

    
    private boolean isNumber(String s)
    {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isOperator(String s)
    {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/", "^"));
        return operators.contains(s);
    }
}