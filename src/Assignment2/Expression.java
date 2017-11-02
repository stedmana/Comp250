package Assignment2;

/*
Student Name: Alexander Stedman
Student Number: 260627145
 */

import java.util.Stack;
import java.util.ArrayList;

public class Expression {
    private ArrayList<String> tokenList;

    //  Constructor

    /**
     * The constructor takes in an expression as a string
     * and tokenizes it (breaks it up into meaningful units)
     * These tokens are then stored in an array list 'tokenList'.
     */

    Expression(String expressionString) throws IllegalArgumentException {
        tokenList = new ArrayList<String>();
        //StringBuilder token = new StringBuilder();

        //ADD YOUR CODE BELOW HERE
        //
        //String[] inputSplit = expressionString.split(" ");
        StringBuilder workingSet = new StringBuilder(expressionString);
        //StringBuilder workingSetNoSpaces = new StringBuilder();

        for (int i = 0; i < workingSet.length(); i++) { //this loop removes spaces form workingSet
            while (workingSet.charAt(i) == ' ') {
                workingSet.deleteCharAt(i);
            }
        }

        for (int i = 0; i < workingSet.length(); i++) {
            if (workingSet.charAt(i) == '(' || workingSet.charAt(i) == ')'
                    || workingSet.charAt(i) == '['
                    || workingSet.charAt(i) == ']'
                    || workingSet.charAt(i) == '*'
                    || workingSet.charAt(i) == '/') {
                tokenList.add(String.valueOf(workingSet.charAt(i)));
                //workingSet.deleteCharAt(i);
            }
            if (workingSet.charAt(i) == '+') {
                if (workingSet.charAt(i + 1) == '+') {
                    tokenList.add("++");
                    //workingSet.deleteCharAt(i);
                    workingSet.deleteCharAt(i+1);
                } else {
                    tokenList.add("+");
                    //workingSet.deleteCharAt(i);
                }
            }
            if (workingSet.charAt(i) == '-') {
                if (workingSet.charAt(i + 1) == '-') {
                    tokenList.add("--");
                    //workingSet.deleteCharAt(i);
                    workingSet.deleteCharAt(i+1);
                } else {
                    tokenList.add("-");
                    //workingSet.deleteCharAt(i);
                }
            }
            if (Character.isDigit(workingSet.charAt(i))) {

                StringBuilder workingString = new StringBuilder(String.valueOf(workingSet.charAt(i)));
                while (Character.isDigit(workingSet.charAt(i + 1))) {
                    workingString.append(workingSet.charAt(i + 1));
                    workingSet.deleteCharAt(i+1);
                }
                tokenList.add(workingString.toString());

            }

        }


        //..
        //ADD YOUR CODE ABOVE HERE
    }


    /**
     * This method evaluates the expression and returns the value of the expression
     * Evaluation is done using 2 stack ADTs, operatorStack to store operators
     * and valueStack to store values and intermediate results.
     * - You must fill in code to evaluate an expression using 2 stacks
     */
    public Integer eval() {
        Stack<String> operatorStack = new Stack<String>();
        Stack<Integer> valueStack = new Stack<Integer>();

        //ADD YOUR CODE BELOW HERE
        //..
        //..
        //ADD YOUR CODE ABOVE HERE
        //count items between parenthesis, if there are 2 then its unary, if 3 then its a binary op
        while (tokenList.size() > 1) {
            int countSinceLastBracket = 0;
            for (int i = 0; i < tokenList.size(); i++) {
                if (tokenList.get(i).equals("(")
                        || tokenList.get(i).equals("[")
                        || tokenList.get(i).equals("+")
                        || tokenList.get(i).equals("-")
                        || tokenList.get(i).equals("*")
                        || tokenList.get(i).equals("/")
                        || tokenList.get(i).equals("++")
                        || tokenList.get(i).equals("--")) {
                    operatorStack.push(tokenList.get(i));
                }
                if (tokenList.get(i).equals(")") || tokenList.get(i).equals("]")) {
                    if (operatorStack.peek().equals("++")) {
                        valueStack.push(Integer.parseInt(tokenList.get(i-1)));
                        int value  = valueStack.pop();
                        value++;
                        tokenList.remove(i-1);
                        tokenList.remove((i-2));
                        tokenList.add(i-2, Integer.toString(value));
                        operatorStack.pop();
                        i -= 1;
                        break;
                    }
                    else if (operatorStack.peek().equals("--")) {
                        valueStack.push(Integer.parseInt(tokenList.get(i - 1)));
                        int value = valueStack.pop();
                        value--;
                        tokenList.remove(i - 1);
                        tokenList.remove((i - 2));
                        tokenList.add(i - 2, Integer.toString(value));
                        operatorStack.pop();
                        i -= 1;
                        break;
                    }
                    else if (operatorStack.peek().equals("-")){
                        valueStack.push(Integer.parseInt(tokenList.get(i - 1)));
                        valueStack.push(Integer.parseInt(tokenList.get(i-3)));
                        int value = valueStack.pop();
                        value = value - valueStack.pop();
                        tokenList.remove(i - 1);
                        tokenList.remove((i - 2));
                        tokenList.remove(i-3);
                        tokenList.add(i - 3, Integer.toString(value));
                        operatorStack.pop();
                        i -= 2;
                    }
                    else if (operatorStack.peek().equals("+")){
                        valueStack.push(Integer.parseInt(tokenList.get(i - 1)));
                        valueStack.push(Integer.parseInt(tokenList.get(i-3)));
                        int value = valueStack.pop();
                        value = value + valueStack.pop();
                        tokenList.remove(i - 1);
                        tokenList.remove((i - 2));
                        tokenList.remove(i-3);
                        tokenList.add(i - 3, Integer.toString(value));
                        operatorStack.pop();
                        i -= 2;
                    }
                    else if (operatorStack.peek().equals("/")) {
                        valueStack.push(Integer.parseInt(tokenList.get(i - 1)));
                        valueStack.push(Integer.parseInt(tokenList.get(i-3)));
                        int value = valueStack.pop();
                        value = value / valueStack.pop();
                        tokenList.remove(i - 1);
                        tokenList.remove((i - 2));
                        tokenList.remove(i-3);
                        tokenList.add(i - 3, Integer.toString(value));
                        operatorStack.pop();
                        i -= 2;
                        break;
                    }
                    else if (operatorStack.peek().equals("*")) {
                        valueStack.push(Integer.parseInt(tokenList.get(i - 1)));
                        valueStack.push(Integer.parseInt(tokenList.get(i-3)));
                        int value = valueStack.pop();
                        value = value * valueStack.pop();
                        tokenList.remove(i - 1);
                        tokenList.remove((i - 2));
                        tokenList.remove(i-3);
                        tokenList.add(i - 3, Integer.toString(value));
                        operatorStack.pop();
                        i -= 2;
                        break;
                    }
                    if (tokenList.get(i).equals(")")) {
                        operatorStack.pop();
                        tokenList.remove(i);
                        tokenList.remove(i-2);
                        break;
                    }
                    if (tokenList.get(i).equals("]") && isInteger(tokenList.get(i-1))) {
                        String inStr = tokenList.get(i-1);
                        StringBuilder workingString = new StringBuilder(tokenList.get(i-1));
                        if (workingString.charAt(0) == '-') {
                            workingString.deleteCharAt(0);
                            inStr = workingString.toString();
                        }

                        tokenList.remove(i-1);
                        tokenList.add(i-1, inStr);
                        tokenList.remove(i);
                        tokenList.remove(i-2);
                        operatorStack.pop();
                        break;

                    }


                }


            }
            operatorStack.clear();
        }

        if (isInteger((tokenList.get(0)))) {
            return Integer.valueOf(tokenList.get(0));
        } else {return 11;}
    }

    //Helper methods

    /**
     * Helper method to test if a string is an integer
     * Returns true for strings of integers like "456"
     * and false for string of non-integers like "+"
     * - DO NOT EDIT THIS METHOD
     */
    private boolean isInteger(String element) {
        try {
            Integer.valueOf(element);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Method to help print out the expression stored as a list in tokenList.
     * - DO NOT EDIT THIS METHOD
     */

    @Override
    public String toString() {
        String s = new String();
        for (String t : tokenList)
            s = s + "~" + t;
        return s;
    }

}

