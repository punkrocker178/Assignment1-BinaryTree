package hieu;

public class TreeNode<T extends Comparable<T>> extends Student<T> {

	public TreeNode<T> left,right,parent;
	public int size,height;
	public double x,y;


	public TreeNode(int key, String name,String dob, double Avg, int credits, int size, int height, TreeNode<T> parent,double x,double y) {
		this.key = key;
		this.name =name;
		this.Average = Avg;
		this.credits = credits;
		this.left = null;
		this.right = null;
		this.height = height;
		this.size = size;
		this.parent = parent;
		this.dob = dob;
		this.x = x;
		this.y =y;
	}



}
