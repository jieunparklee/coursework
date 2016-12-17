package CCFinder;

public class CCFinder {
	private ParPtrTree PPT;
	private static final int MAXNODE = 30;
	public CCFinder(){
		PPT = new ParPtrTree(MAXNODE);
	}
	
	public void CCprint(int node){
		System.out.println(PPT.print(node));
	}
	
	public int CCnumber(){
		return PPT.number();
	}
	
	public int CCsize(int node){
		return PPT.size(node);
	}
	
	public boolean CCdiffer(int node1, int node2){
		return PPT.differ(node1, node2);
	}
	
	public void addedge(int node1, int node2){
		PPT.UNION(node1, node2);
	}
}
