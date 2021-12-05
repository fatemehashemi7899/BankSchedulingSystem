package bank;
import java.util.Scanner;

public class Intro {
    Scanner input = new Scanner(System.in);
    public void intro(){
        System.out.println("lotfan shomare aghaz e nobat ra vared konid : ");
        Turn.count = input.nextInt();
        System.out.println("lotfan tedad koll e khadamat ra vared konid : ");
        Works.total = input.nextInt();
        input.nextLine();
        Works.totalWorks = new Works[Works.total];
        for (int i = 0; i < Works.total ; i++){
            System.out.println("nam e khedmat shomare " + (i+1) +" ra vared konid : ");
            Works.totalWorks[i] = new Works(input.nextLine());
        }
        System.out.println("lotfan tedad koll e Counters ra vared konid : ");
        Counter.totalCounters = input.nextInt();
        input.nextLine();
        Counter.Counters = new Counter[Counter.totalCounters];
        Works.print();
        for(int i = 0; i < Counter.totalCounters; i++) {
            Counter.Counters[i] = new Counter();
            Counter.Counters[i].setNumberOfCounters(i + 1);
            System.out.println("lotfan moshakhas konid baje " + (i + 1) + " che tedad khedmat ra anjam midahad : ");
            int m = input.nextInt();
            input.nextLine();
            Counter.Counters[i].setNumberOfWorks(m);
            int[] kh = new int[m];
            System.out.println("lotfan moshakhas konid baje " + (i + 1) + " che khedmat/khadamati ra anjam midahad(pas az har shomare khedmat Enter ra bezanid) : ");
            for (int j = 0; j < m; j++) {
                kh[j] = input.nextInt();
            }
            Counter.Counters[i].setWd(kh);
        }
    }
    public void done(){
        while(true){
            Customer need = new Customer();
            need.addCustomer();
            Counter.Counters[0].printEmpty();
            Counter.Counters[0].printLineUp();
        }
    }
}
