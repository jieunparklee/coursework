package structures;

import java.util.Arrays;
import java.util.Stack;

/**
 * A class of a binary tree.
 */
public class BinaryTree {
    /** Head node for this tree */
    BinaryNode root;
    String postfix;

    /**
     * A constructor for a binary tree using the expression.
     * You should parse the expression and store them recursively.
     */
    public BinaryTree(String expression) {
    	root = new BinaryNode();
    	postfix = "";
        String[] stringArray = expression.split(" ");
        root = cleaner(binaryTreeSub(stringArray, root));
    }

    /**
     * Returns the result of calculation for the given expression.
     */
    public int calculate() {
        Stack<Integer> helper = new Stack<Integer>();
        postfix = postorderSub(root); 
    	String[] exp = postfix.split(" ");
    	
        for (int i = 0; i < exp.length; i++) {
        	String value = exp[i];  	
        	int valueTwo;
			int valueOne;
        	switch (value){
    			case "+":
    				valueTwo = helper.pop();
    				valueOne = helper.pop();
    				helper.push(valueOne + valueTwo);
    				break;
    			case "-":
    				valueTwo = helper.pop();
    				valueOne = helper.pop();
    				helper.push(valueOne - valueTwo);
    				break;
    			case "*":
    				valueTwo = helper.pop();
    				valueOne = helper.pop();
    				helper.push(valueOne * valueTwo);
    				break;
    			case "/":
    				valueTwo = helper.pop();
    				valueOne = helper.pop();
    				helper.push(valueOne / valueTwo);
    				break;
    			default:
    				helper.push(Integer.parseInt(value));
    				break;
        	}
        }
    	return helper.pop();
    }

    /**
     * Returns the result of post-order traversal of this tree.
     */
    public String postorder() {
    	if (root == null) return "";
		return postfix.replaceAll("\\s+", "");
    }
    
    private BinaryNode binaryTreeSub(String[] exp, BinaryNode rt) { 
    	boolean passOp = false;
		for (int i = 0; i < exp.length; i++) {
			if (exp[i].equals("+") || exp[i].equals("-") || exp[i].equals("*") || exp[i].equals("/")) {
				rt.setElement(exp[i]);
				passOp = true;
			} else {
				if (!exp[i].equals(")")) { // ignore ")"
					if(!passOp) {
						if (!exp[i].equals("(")) {
							rt.setLeft(new BinaryNode(exp[i]));
						} else {
							String[] split = splitExp(Arrays.copyOfRange(exp, i, exp.length));
							i += split.length + 1; // skip this block - it's covered by recursion
							if (split.length == 1) rt.setLeft(new BinaryNode(split[0])); 
							else rt.setLeft(binaryTreeSub(split, new BinaryNode()));
						}
					} else {
						if (!exp[i].equals("(")) {
							rt.setRight(new BinaryNode(exp[i]));
						} else { 
							String[] split = splitExp(Arrays.copyOfRange(exp, i, exp.length));
							i += split.length + 1; // skip this block - it's covered by recursion
							if (split.length == 1) rt.setRight(new BinaryNode(split[0])); 
							else rt.setRight(binaryTreeSub(split, new BinaryNode()));
						}
					}
				}
			}
		} return rt;
    }
    
    private String[] splitExp(String[] exp) { // extract each block of expression
    	int count = 0;
    	int end;
		for (end = 0; end < exp.length; end++) {
			if (exp[end].equals("(")) count++;
			else if (exp[end].equals(")")) {
				count--;
				if (count == 0) break;
			}
		}
		if (1 != end - 1) return Arrays.copyOfRange(exp, 1, end); // without brackets
		else return new String[]{exp[end-1]}; // return single integer (array type)
    }
    
    private BinaryNode cleaner(BinaryNode rt) {
    	if (rt.getElement() == null) // for cases like ( 1 + 1 )
        	return cleaner(rt.getLeft());
    	else if (rt.isLeaf()) 
			return rt;
		else {
			return new BinaryNode(rt.getElement(), cleaner(rt.getLeft()), cleaner(rt.getRight()));
		}
    }
    
    private String postorderSub(BinaryNode rt) { 
    	if (rt.isLeaf()) 
			return rt.getElement();
		else {
			return postorderSub(rt.getLeft()) + " " + postorderSub(rt.getRight()) + " " + rt.getElement();
		}
    }
}
