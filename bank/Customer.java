package bank;
import java.util.Scanner;
import java.util.ArrayList;
public class Customer {
    Scanner input = new Scanner(System.in);
    private Turn myTurn;
    private int allWorks;
    private int[] numberOfWorks;
    public static ArrayList<Customer> numberOfCustomers = new ArrayList<Customer>();
    public static int index = 0 ;
    private int whichCounter;
    public void addCustomer(){
        System.out.println("Enter n for creating a customer, Enter q for delete of quit :");
        String what = input.nextLine();
        if(what.equals("n") || what.equals("N")){
            Customer e = new Customer();
            Turn n = new Turn();
            n.addTurn(e);
            numberOfCustomers.add(index , e);
            index++;
            System.out.println("customer " + (index) + " created." + e.getMyTurn().printTime(n));
            System.out.println("customer " + (index) + " please enter number of works you need.");
            int num = input.nextInt();
            e.setAllWorks(num);
            e.numberOfWorks = new int[num];
            for(int i = 0 ; i < num ; i++){
                System.out.println("enter number " + (i+1) + "of works");
                e.numberOfWorks[i] = input.nextInt();
            }
            Works.print();
            Works k = new Works();
            k.searchWorks(e);
            Counter.Counters[0].goToWhichBaje(e);
        }
        if(what.equals("q") || what.equals("Q")){
            System.out.println("for exiting the bank enter b & for exiting the counter enter j :");
            String w = input.nextLine();
            if(w.equals("j") || w.equals("J")) {
                System.out.println("enter number of counter :");
                int b = input.nextInt();
                System.out.println("the customer " + b + "exitted the counter .");
                Counter.Counters[b - 1].setEmpty(true);
                for (int i = 0; i < Counter.Counters[b-1].getCustomer().getNumberOfWorks().length; i++) {
                    for (int j = 0; j < Counter.Counters[b - 1].getWd().length; j++) {
                        if (Counter.Counters[b-1].getCustomer().getNumberOfWorks()[i] == Counter.Counters[b - 1].getWd()[j]) {
                            Counter.Counters[b-1].getCustomer().getNumberOfWorks()[i] = 0;
                        }
                    }
                }
                Counter.Counters[b - 1].setCustomer(null);
            }
            if(w.equals("B") || w.equals("b")){
                System.out.println("enter number of the customer for delete him/her : ");
                int d = input.nextInt();
                numberOfCustomers.get(d-1).deleteFromCounter();
                numberOfCustomers.remove(d-1);
                System.out.println("customer number  "+ d + "exitted the bank.");
            }
        }
    }

    public void setAllWorks(int allWorks) {
        if(allWorks >0)this.allWorks = allWorks;
    }
    public void setMyTurn(Turn myTurn) {
        this.myTurn = myTurn;
    }
    public Turn getMyTurn() {
        return myTurn;
    }
    public void setWhichCounter(int whichCounter) {
        this.whichCounter = whichCounter;
    }
    public void deleteFromCounter(){
        int m = this.whichCounter;
        Counter.Counters[m-1].deleteLineUp();
    }
    public int[] getNumberOfWorks() {
        return numberOfWorks;
    }
}
