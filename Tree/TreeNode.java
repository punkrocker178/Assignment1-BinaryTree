package hieu.Tree;

import hieu.Student;

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


	public void setName(String name){
		this.name = name;
	}

	public void setDOB(String dob){
		this.dob = dob;
	}

	public void setAVG(double avg){
		this.Average = avg;
	}

	public void setCredits(int credits){
		this.credits = credits;
	}



}
