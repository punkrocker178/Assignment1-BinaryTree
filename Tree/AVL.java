package hieu.Tree;

import hieu.Student;
import hieu.Tree.TreeNode;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.lang.*;
import java.util.*;

public class AVL<E extends Comparable<E>> extends Student<E> {

	private TreeNode<E> root;
	/*Create an emty Tree*/
	public void emtyTree(){
		root = null;
	}

	/*Constructor*/
	public AVL(){
		root =null;
	}

	/*Number of Tree nodes*/
	private int size(TreeNode<E> node){
		if(node == null){
			return 0;
		}
		return node.size;
	}

	public int size(){
		return size(root);
	}

	/*Tree's height*/
	private int height(TreeNode<E> node){
		if(node==null){
			return -1;
		}
		return node.height;
	}

	public int height(){
		return height(root);
	}

	/*Method insert-----insert(GraphicsContext,X position,Y position,TreeNode , Parent , Student's MSSV , Student's Name , Student's DOB , Student's AVG , Student's credit)*/
	private TreeNode<E> insert(GraphicsContext gc, double x, double y, TreeNode<E> node, TreeNode<E> parent, int key, String name, String dob, double avg, int credits){

		if(node==null){
        /*
        Begin to draw the circle,text and a line
         */

			gc.fillOval(x,y,30,30);
			gc.setStroke(Color.GREEN);
			gc.strokeText(String.valueOf(key),x+5,y+20);

			return new TreeNode<E>(key,name,dob,avg,credits,1,0,parent,x,y);

		}else if(node!=null){
			if(node.getKey().compareTo(key)<0){
//
				node.right = insert(gc,node.x+50,node.y+40,node.right,node,key,name,dob,avg,credits);

			}else if(node.getKey().compareTo(key)>0){
//
				node.left = insert(gc,node.x-50,node.y+40,node.left,node,key,name,dob,avg,credits);

			}
		}

		node.size = 1+size(node.left)+size(node.right);
		node.height = 1+Math.max(height(node.left),height(node.right));

		gc.stroke();
		return balancing(node);
	}

	public void insert(GraphicsContext gc,double x,double y, Integer key, String name, String dob, double avg, int credits){
		root = insert(gc,x,y,root,root,key,name,dob,avg,credits);
	}

	/*Find Parent of Node*/
	private TreeNode<E> checkParent(TreeNode<E> node){

		if(node == null){
			return null;
		}
		return node.parent;
	}

	public Integer checkParent(Integer key){
		TreeNode<E> node = search(root,key);
		TreeNode<E> parent = checkParent(node);
		return parent.getKey();
	}

	/*Get information of a node*/
	private String getInfo(TreeNode<E> node,Integer key){
		node = search(node,key);
		if(node==null){
			return null;
		}
		return node.getKey()+" - "+node.getName()+" - "+node.getAvg()+" - "+node.getCredits();
	}
	public String getInfo(Integer key){
		String info = getInfo(root,key);
		return info;
	}

	/*Check Balance*/
	private int checkBalance(TreeNode<E> node){
		return height(node.left)-height(node.right);
	}

	public int Balance(){
		return checkBalance(root);
	}

	private TreeNode<E> balancing(TreeNode<E> node) {
		if (checkBalance(node) < -1) {
			if (checkBalance(node.right) > 0) {
				node.right = rotateRight(node.right);
			}
			node = rotateLeft(node);
		}
		else if (checkBalance(node) > 1) {
			if (checkBalance(node.left) < 0) {
				node.left = rotateLeft(node.left);
			}
			node = rotateRight(node);
		}
		return node;

	}

	public void bal(){
		root = balancing(root);
	}

	/*Rotate Left*/
	private TreeNode<E> rotateLeft(TreeNode<E> node){
		TreeNode<E> y = node.right;
		node.right = y.left;
		y.left = node;
		y.size = node.size;
		node.size = 1 + size(node.left) + size(node.right);
		node.height = 1 + Math.max(height(node.left), height(node.right));
		y.height = 1 + Math.max(height(y.left), height(y.right));
		return y;
	}

	/*Rotate Right*/
	private TreeNode<E> rotateRight(TreeNode<E> node){
		TreeNode<E> y = node.left;
		node.left = y.right;
		y.right =node;
		node.size = 1+size(node.left) + size(node.right);
		node.height = 1 +Math.max(height(node.right), height(node.left));
		y.height = 1+ Math.max(height(y.left), height(y.right));
		return y;

	}

	/*3 type of Tree Traversal
	 * 1/In order
	 * 2/Pre order
	 * 3/Post order*/
	private String inorder(TreeNode<E> node,String s){

		if(node!=null){
			s = inorder(node.left,s);
			s=s+node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits()+"\n";
			System.out.println(node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits());
			s=inorder(node.right,s);
		}
		return s;
	}

	private String preorder(TreeNode<E> node,String s){

		if(node!=null){
			s=s+node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits()+"\n";
			System.out.println(node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits());
			s=preorder(node.left,s);
			s=preorder(node.right,s);
		}
		return s;
	}

	private String postOrder(TreeNode<E> node,String s){

		if(node!=null){
			s=postOrder(node.left,s);
			s=postOrder(node.right,s);
			s=s+node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits()+"\n";
			System.out.println(node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits());
		}
		return s;
	}

	private String RNL(TreeNode<E> node,String s){
		if(node!=null){

			s=postOrder(node.right,s);
			s=s+node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits()+"\n";
			s=postOrder(node.left,s);

		}
		return s;
	}

	private String RLN(TreeNode<E> node,String s){
		if(node!=null){

			s=postOrder(node.right,s);
			s=postOrder(node.left,s);
			s=s+node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits()+"\n";


		}
		return s;
	}

	private String NRL(TreeNode<E> node,String s){
		if(node!=null){

			s=s+node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits()+"\n";
			s=postOrder(node.left,s);
			s=postOrder(node.right,s);

		}
		return s;
	}


	/*Print*/
	public String traverse(int option){
		String s= "";
		System.out.println("MSSV - Name - AVG - Credits");
		switch(option){
			case 1:
				System.out.println("Inorder: ");
				s = inorder(root,"");
				break;
			case 2:
				System.out.println("Preorder: ");
				s = preorder(root,"");
				break;
			case 3:
				System.out.println("Postorder: ");
				s = postOrder(root,"");
				break;
			case 4:
				System.out.println("RNL");
				s = RNL(root,"");
				break;
			case 5:
				System.out.println("NRL");
				s = NRL(root,"");
				break;
			case 6:
				System.out.println("RLN");
				s = RLN(root,"");
				break;

		}
		return s;
	}

	/*Seach a Node of Tree by a key*/
	private TreeNode<E> search(TreeNode<E> node,Integer key){
		if(node!=null){
			if(node.getKey().compareTo(key)==0){
				return node;
			}
			else if(node.getKey().compareTo(key)<0){
				return search(node.right,key);

			}else if(node.getKey().compareTo(key)>0){
				return search(node.left,key);
			}
		}
		return null;
	}

	public boolean searchNode(Integer key){

		if(search(root,key)!=null)
			return true;
		return false;
	}

	/*Find the biggest int key in Tree*/
	private TreeNode<E> findMax(TreeNode<E> node){
		if(node.right == null){
			return node;
		}
		return findMax(node.right);
	}

	/*Find the smallest int key in Tree*/
	private TreeNode<E> findMin(TreeNode<E> node){
		if(node.left==null){
			return node;
		}
		return findMin(node.left);
	}

	public void Max(){
		System.out.println("Max is: "+findMax(root).getKey());
	}

	public void Min(){
		System.out.println("Min is: "+findMin(root).getKey());
	}

	/*Find Predecessor of a Node*/
	private TreeNode<E> preDecessor(TreeNode<E> node){
		TreeNode<E> p = node.parent;
		TreeNode<E> t = node;

		if(node.left!=null){
			return findMax(node.left);
		}else{
			while(p!=null&&t==p.left){
				t=p;
				p=t.parent;
			}
			if(p==null) {
				return null;
			}
		}
		return p;
	}

	/*Find Successor of a Node*/
	private TreeNode<E> sucCessor(TreeNode<E> node){
		TreeNode<E> p = node.parent;
		TreeNode<E> t = node;

		if(node.right!=null){
			return findMin(node.right);
		}else{
			while(p!=null&&t==p.right){
				t=p;
				p=t.parent;
			}
			if(p==null) {
				return null;
			}
		}
		return p;
	}

	public String preDecessor(Integer key){
		TreeNode<E> node = search(root,key);
		Integer getPre = preDecessor(node).getKey();
		return getPre+"";
	}

	public String sucCessor(Integer key){
		TreeNode<E> node = search(root,key);
		Integer getSucc = sucCessor(node).getKey();
		return getSucc+"";
	}

	/*Tree Deletion*/
	private TreeNode<E> deleteMin(TreeNode<E> node){
		if(node.left==null){
			return node.right;
		}
		node.left = deleteMin(node.left);
		root.size = 1+size(node.left)+size(node.right);
		root.height = 1+ Math.max(height(node.left),height(node.right));
		return node;
	}

	private TreeNode<E> delMax(TreeNode<E> node){
		if(node.right == null){
			return node.left;
		}
		node.right= delMax(node.right);
		root.size = 1+size(node.left)+size(node.right);
		root.height = 1+Math.max(height(node.left),height(node.right));
		return node;
	}

	/*Delete 3 types of a Node
	 * 1/Leaf node
	 * 2/Node with 1 child
	 * 3/Node with 2 child*/
	private TreeNode<E> delete(TreeNode<E> node,Integer key) {
		TreeNode<E> p = node.parent;

		if (node == null) {

			return null;

		} else if (node.getKey().compareTo(key) < 0) {

			node.right = delete(node.right, key);

		} else if (node.getKey().compareTo(key) > 0) {

			node.left = delete(node.left, key);

		} else {

			if (node.left == null && node.right == null) {	//Leaf node

				return null;

			} else if (node.left == null) {					//Node with right child

				node.right.parent = p;

				return node.right;

			} else if (node.right == null) {				//Node with left child

				node.left.parent = p;

				return node.left;
			}
			/*Node with 2 child
			 * Explaination: find the successor of a node and copy the successor's data to the current Node
			 * then delete the successor's Node
			 * Update tree size and height again*/
			node.setKey(sucCessor(node).getKey()) ;
			node.right = delete(node.right,node.right.getKey());

			node.size = 1 + size(node.left) + size(node.right);

			node.height = 1 + Math.max(height(node.left), height(node.right));



		}

		return balancing(node);

	}

	public void del(Integer key){

		if(searchNode(key) == false){
			System.out.println("No such key found!");
		}else{
			root = delete(root,key);
		}
	}

	/*Random all info*/
	public void randomize(int n,GraphicsContext gc){
		Collections.shuffle(studentsName);
		for(int i=0;i<n;i++) {
			Student stu = new Student();
//            root = insert(root, root.randomMSSV(), studentsName.get(i), root.randomAvg(), root.randomCre());
			root = insert(gc,640,20,root,root,stu.randomMSSV(),studentsName.get(i),stu.randDOB(),stu.randomAvg(),stu.randomCre());

		}
	}
	/*This method use Bubble Sort to sort all students's key from smallest to largest to an array*/
	public void skewedRight(int n,GraphicsContext gc){
		Collections.shuffle(studentsName);
//        HashSet<Integer> r = new HashSet<Integer>();
		int[] r = new int[n];
		int i = 0;
		Random ran = new Random();
		while(i<n){
			r[i] = ran.nextInt(999-100)+100;

			i++;
		}
		r = sort(r);

		for(int j=0;j<n;j++){
			Student stu = new Student();
			root = insert(gc,640,20,root,root,r[j],studentsName.get(j),stu.randDOB(),stu.randomAvg(),stu.randomCre());
		}

	}

	/*Same as skewedRight method but this time we use backward for loop*/
	public void skewedLeft(int n,GraphicsContext gc){
		Collections.shuffle(studentsName);
		int[] r = new int[n];
		int i = 0;
		Random ran = new Random();
		while(i<n){
			r[i] = ran.nextInt(999-100)+100;

			i++;
		}
		r = sort(r);

		for(int j=n-1;j>=0;j--){
			Student stu = new Student();
			root = insert(gc,640,20,root,root,r[j],studentsName.get(j),stu.randDOB(),stu.randomAvg(),stu.randomCre());
		}
	}

	/*Bubble Sort*/
	private int[] sort(int[] r){
		int tmp;
		for(int i = 1;i<r.length;i++){
			for(int j = 0;j<r.length-i;j++){
				if(r[j]>r[j+1]){
					tmp = r[j];
					r[j] = r[j+1];
					r[j+1] = tmp;
				}
			}
		}
		return r;
	}
	/*Update info*/
	private void update(TreeNode<E> node,String name,String dob,double Avg,int credits){
		node.setName(name);
		node.setAVG(Avg);
		node.setCredits(credits);
		node.setDOB(dob);
	}

	public void update(Integer key,String name,String dob,double Avg,int credits){
		TreeNode<E> node = search(root,key);
		update(node,name,dob,Avg,credits);
	}

}
