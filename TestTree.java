package hieu;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.*;

public class TestTree {

    public static void main(String[] args) {
        // write your code here

//        HashSet<String> studentsName = new HashSet<String>();
//        int attempt = n;
//        for (int i = 1; i < attempt; i++) {
//            int r = rand.nextInt(nameArray.length);
//            studentsName.add(nameArray[r]);
//            if (studentsName.size() <=n) {
//                if (studentsName.size() == n) {
//                    attempt = n;
//                }
//                attempt++;
//                studentsName.add(nameArray[r]);
//            }
//        }
//
//
//        System.out.println("Randomly picked name:");
//        System.out.print(studentsName);


//
        Canvas canvas = new Canvas();
        String input = "";
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Scanner sc= new Scanner(System.in);
        BST tree = new BST();
        System.out.println("1.Emty Tree:");
        System.out.println("2.Randomized Tree:");
        System.out.println(("3.Insert manually"));
        System.out.println("4.Skewed Right");
        System.out.println("5.Skewed Left");
        int c = sc.nextInt();

        switch(c){
            case 1:
                break;
            case 2:
                System.out.println("How many students?");
                int n = sc.nextInt();
                tree.randomize(n,gc);
                break;
            case 3:
                sc.nextLine();
                System.out.println("Input: Key-Name-DOB-AVG-Credits");
                input = sc.nextLine();
                String[] data = input.split("-");
                tree.insert(gc,300,20,Integer.parseInt(data[0]),data[1],data[2],Double.parseDouble(data[3]),Integer.parseInt(data[4]));
                break;
            case 4:
                System.out.println("How many students?");
                int sk = sc.nextInt();
                tree.skewedRight(sk,gc);
                break;
            case 5:
                break;
        }
        System.out.println("--------------------------------------------------");
        System.out.println("1.Inorder");
        System.out.println("2.Preorder");
        System.out.println("3.Postorder");
        int t = sc.nextInt();
        tree.traverse(t);
        System.out.println("Get info:");
        int i = sc.nextInt();
        tree.getInfo(i);
        System.out.println("Find Predecessor: ");
        int p = sc.nextInt();
        tree.preDecessor(p);
        System.out.println(("Find Successor"));
        int u = sc.nextInt();
        tree.sucCessor(u);
        System.out.println("Delete a node: ");
        int d = sc.nextInt();
        tree.del(d);
        tree.traverse(1);

//        tree.insert(1);
//        tree.insert(2);
//        tree.insert(0);
//        tree.insert(4);
//        tree.insert(3);
//        do{
//            System.out.println("Do you want to continue y/n:");
//            System.out.println("Tree size: "+tree.size());
//            System.out.println("Tree height: "+tree.height());
//            tree.traverse();
//            System.out.println();
//
//        }while(sc.nextLine().equals("y"));
//            tree.getName(516);

//        System.out.println(tree.searchNode(5));
    }
}
