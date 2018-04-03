package hieu;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Student <E extends Comparable<E>> {
    protected Integer key;
    protected String name;
    protected double Average;
    protected int credits;
//    protected int day,month,year;
    protected String dob;
    Random rand = new Random();
    NumberFormat format = new DecimalFormat("#0.00");
  protected  String[] nameArray = {"An", "Anh", "Bao", "Binh", "Cong", "Canh", "Chau", "Chinh", "Chien", "Chi", "Dat", "Dai", "Dao", "Dan", "Duong", "Dung", "Dien", "Giang", "Giao", "Hieu", "Hau", "Hien", "Huy", "Han", "Hung",
            "Hoa", "Kha", "Khoa", "Khoi", "Khiem", "Khanh", "Khang", "Long", "Linh", "Lan", "Lien", "Liem", "Luat", "Minh", "My", "Mai", "Nguyen", "Ngoc", "Nguyet", "Nhi", "Nhu", "Oanh", "Phuong", "Phuc", "Quyen", "Quynh",
            "Suong", "Uyen", "Tam", "Tram", "Tien", "Trang", "Truc", "Trac", "Thanh", "Thuy", "Vy", "Vi", "Van", "Yen"};

  protected ArrayList<String> studentsName = new ArrayList<String>(Arrays.asList(nameArray));

    public String getName(){
        return name;
    }
    public Integer getKey(){
        return key;
    }
    public double getAvg(){
        return Average;
    }
    public int getCredits(){
        return credits;
    }
    public String getDob(){
        return dob;
    }
    protected void randomName(){
        Collections.shuffle(studentsName);
    }

    protected String randDOB(){
        int day,month,year;
        day = rand.nextInt(30)+1;
        month = rand.nextInt(11)+1;
        year =  rand.nextInt(2000-1970)+1970;
        return day+"/"+month+"/"+year;
    }

    protected int randomMSSV(){
        return rand.nextInt(999-100)+100;
    }

    protected int randomCre(){
        return rand.nextInt(50)+1;
    }

   protected double randomAvg(){
        double min = 1.0;
        double max =10.0;
        return Double.parseDouble(format.format(min+(max-min)*rand.nextDouble()));
    }

//    public String toString(){
//        return day+"/"+month+"/"+year;
//    }

}
