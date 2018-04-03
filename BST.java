package hieu;




import java.lang.*;
import java.util.*;

public class BST<E extends Comparable<E>> extends Student<E> {

 private class TreeNode<T extends Comparable<T>> extends Student<E> {

    private TreeNode<T> left,right,parent;
    private int size,height;


    private TreeNode(int key, String name,String dob, double Avg, int credits, int size, int height, TreeNode<T> parent) {
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
    }



}

    private TreeNode<E> root;
    public BST(){
        root =null;
    }

    private int size(TreeNode<E> node){
        if(node == null){
            return 0;
        }
        return node.size;
    }
    
    public int size(){
        return size(root);
    }
    
    private int height(TreeNode<E> node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    
    public int height(){
        return height(root);
    }

    private TreeNode<E> insert(TreeNode<E> node,TreeNode<E> parent,int key,String name,String dob,double avg,int credits){
    if(node==null){
        return new TreeNode<E>(key,name,dob,avg,credits,1,0,parent);
    }else if(node!=null){
        if(node.key.compareTo(key)<0){
            node.right = insert(node.right,node,key,name,dob,avg,credits);
        }else if(node.key.compareTo(key)>0){
            node.left = insert(node.left,node,key,name,dob,avg,credits);
        }
    }
        node.size = 1+size(node.left)+size(node.right);
        node.height = 1+Math.max(height(node.left),height(node.right));
        return node;
    }

    public void insert(Integer key,String name,String dob,double avg,int credits){
        root = insert(root,root,key,name,dob,avg,credits);
    }

    private TreeNode<E> findMax(TreeNode<E> node){
        if(node.right == null){
            return node;
        }
        return findMax(node.right);
    }

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

    private TreeNode<E> delete(TreeNode<E> node,Integer key) {
        TreeNode<E> p = node.parent;

        if (node == null) {

            return null;

        } else if (node.getKey().compareTo(key) < 0) {

            node.right = delete(node.right, key);

        } else if (node.getKey().compareTo(key) > 0) {

            node.left = delete(node.left, key);

        } else {

            if (node.left == null && node.right == null) {

                return null;

            } else if (node.left == null) {

                node.right.parent = p;

                return node.right;

            } else if (node.right == null) {

                node.left.parent = p;

                return node.left;
            }

            node.key = sucCessor(node).getKey();
            node.right = delete(node.right,node.right.getKey());

            node.size = 1 + size(node.left) + size(node.right);

            node.height = 1 + Math.max(height(node.left), height(node.right));



        }

        return node;

    }

    public void del(Integer key){

        if(searchNode(key) == false){
            System.out.println("No such key found!");
        }else{
            root = delete(root,key);
        }
    }




//    public String searchNode(String name){
//
//    }

    private String getInfo(TreeNode<E> node,Integer key){
        node = search(node,key);
        if(node==null){
            return null;
        }
        return node.getKey()+" - "+node.getName()+" - "+node.getAvg()+" - "+node.getCredits();
    }
    public void getInfo(Integer key){
        String info = getInfo(root,key);
        System.out.println("Info of "+key+" is :");
        System.out.println("Key - Name - AVG - Credits");
        System.out.println(info);
    }

    public void randomize(int n){
        Collections.shuffle(studentsName);
        for(int i=0;i<n;i++) {
            Student stu = new Student();
//            root = insert(root, root.randomMSSV(), studentsName.get(i), root.randomAvg(), root.randomCre());
            root = insert(root,root,stu.randomMSSV(),studentsName.get(i),stu.randDOB(),stu.randomAvg(),stu.randomCre());

        }
    }

    public void skewedRight(int n){
        Collections.shuffle(studentsName);
//        HashSet<Integer> r = new HashSet<Integer>();
        int[] r = new int[n];
        int i = 0;
        Random ran = new Random();
        while(i<n){
            r[i] = ran.nextInt((999-100)+100);
            i++;
        }
        r = sort(r);

        for(int j=0;j<n;j++){
            Student stu = new Student();
            root = insert(root,root,r[j],studentsName.get(j),stu.randDOB(),stu.randomAvg(),stu.randomCre());
        }

    }

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


}