package structures;

/** Node class for binary trees */
public class BinaryNode {
    /** Element of this node */
    private String element;
    /** Left and right children of this node */
    private BinaryNode left;
    private BinaryNode right;

    /** A constructor */
    public BinaryNode() {
        this.element = null;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(String element, BinaryNode left, BinaryNode right) {
    	this.element = element;
    	this.left = left;
    	this.right = right;
    }
    
    public BinaryNode(String element) {
    	this.element = element;
    	this.left = null;
    	this.right = null;
    }
    
    /** Returns the element */
    public String getElement() {
        return element;
    }

    /** Returns the left child */
    public BinaryNode getLeft() {
        return left;
    }

    /** Returns the right child */
    public BinaryNode getRight() {
        return right;
    }

    /** Set the left child as the given node l */
    public void setLeft(BinaryNode l) {
        left = l;
    }

    /** Set the right child as the given node r */
    public void setRight(BinaryNode r) {
        right = r;
    }

    /** Returns if this node is a leaf or not */
    public boolean isLeaf() {
        return left == null && right == null;
    }

    /** Set the element as the given string e */
    public void setElement(String e) {
    	element = e; 
    }
}
