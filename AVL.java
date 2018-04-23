package hieu;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import jdk.nashorn.api.tree.Tree;

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
			if(node.key.compareTo(key)<0){
//
				node.right = insert(gc,node.x+50,node.y+40,node.right,node,key,name,dob,avg,credits);

			}else if(node.key.compareTo(key)>0){
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
	private void inorder(TreeNode<E> node){
		if(node!=null){
			inorder(node.left);
			System.out.println(node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits());
			inorder(node.right);
		}
	}

	private void preorder(TreeNode<E> node){
		if(node!=null){
			System.out.println(node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits());
			preorder(node.left);
			preorder(node.right);
		}
	}

	private void postOrder(TreeNode<E> node){
		if(node!=null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.getKey()+" - "+node.getName()+" - "+node.getDob()+" - "+node.getAvg()+" - "+node.getCredits());
		}
	}

	/*Print*/
	public void traverse(int option){
		System.out.println("MSSV - Name - AVG - Credits");
		switch(option){
			case 1:
				System.out.println("Inorder: ");
				inorder(root);
				break;
			case 2:
				System.out.println("Preorder: ");
				preorder((root));
				break;
			case 3:
				System.out.println("Postorder: ");
				postOrder(root);
				break;

		}
	}

	/*Seach a Node of Tree by a key*/
	private TreeNode<E> search(TreeNode<E> node,Integer key){
		if(node!=null){
			if(node.key.compareTo(key)==0){
				return node;
			}
			else if(node.key.compareTo(key)<0){
				return search(node.right,key);

			}else if(node.key.compareTo(key)>0){
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
		System.out.println("Max is: "+findMax(root).key);
	}

	public void Min(){
		System.out.println("Min is: "+findMin(root).key);
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

	public void preDecessor(Integer key){
		TreeNode<E> node = search(root,key);
		if(searchNode(key)==true) {
			System.out.println("Predecessor of " + key + " is: " + preDecessor(node).getKey());
		}else{
			System.out.println(key+" has no Predecessor!");
		}
	}

	public void sucCessor(Integer key){
		TreeNode<E> node = search(root,key);
		if(searchNode(key)==true){
			System.out.println("sucCessor of "+key+" is: "+sucCessor(node).getKey());
		}else{
			System.out.println(key+" has no Successor!");
		}

	}

}
