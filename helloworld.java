package duoxiancheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class helloworld implements Runnable{
    int i;
   static List<Integer> lists = new ArrayList<>();
    public helloworld(int i){
        this.i = i;
    }
    public static void main(String[] args)throws Exception  {
     int muns[]= {143,443,54,654,321,53,2};
     for(int i=0;i<muns.length;i++){
        Thread a = new Thread(new helloworld(muns[i]));
        a.start();
     }
        System.out.println(lists.size());
        Scanner input= new Scanner(System.in);
        System.out.println("输入参数");
        int i =input.nextInt();
        System.out.println(lists.get(i));
    }

    @Override
    public void run() {
        try {
            Thread.sleep(i);
            System.out.println(i);
            lists.add(i);
            System.out.println("list的size"+lists.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
