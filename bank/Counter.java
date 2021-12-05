package bank;
public class Counter {
    public static int totalCounters;
    public static Counter[] Counters;
    private int numberOfCounters;
    private int numberOfWorks;
    private int[] Wd; // works that this counter do
    private Customer customer = new Customer();
    private int lineUp = 0 ;
    private boolean isEmpty = true;

    public void goToWhichBaje(Customer e) {
        int m = 0;
        for (int i = 0; i < e.getNumberOfWorks().length; i++) {
            if (e.getNumberOfWorks()[i] != 0) {
                m = e.getNumberOfWorks()[i];
                e.getNumberOfWorks()[i] = 0;
                break;
            }
        }
        for (int j = 0; j < Counter.totalCounters; j++) {
            for (int k = 0; k < Counter.Counters[j].getWd().length; k++) {
                if (Counter.Counters[j].getWd()[k] == m) {
                    if (Counter.Counters[j].getIsEmpty() == true && Counter.Counters[j].getLineUp() != 0) {
                        Counter.Counters[j].deleteLineUp();
                        Counter.Counters[j].setEmpty(false);
                        Counter.Counters[j].setCustomer(e);
                        System.out.println("Turn " + e.getMyTurn().getCustomersTurn() + " to counter " + Counter.Counters[j].getNumberOfCounters());
                    }
                }
            }
        }
    }

    public void printEmpty(){
        for(int i = 0; i < Counter.totalCounters; i++ ){
            System.out.println("counter status " + (i+1) + " : " + Counter.Counters[i].getIsEmpty());
        }
    }
    public void printLineUp(){
        for(int i = 0; i < Counter.totalCounters; i++){
            System.out.println("customers in line " + (i+1) +" : " + Counter.Counters[i].getLineUp());
        }
    }

    public void setNumberOfCounters(int numberOfCounters) {
        if(numberOfCounters >0) this.numberOfCounters = numberOfCounters;
        else this.numberOfCounters = 0;
    }
    public void setNumberOfWorks(int nums) {
        if(nums>0)this.numberOfWorks = nums;
        else this.numberOfWorks = 0;
    }
    public void setWd(int[] wd) {
        this.Wd = wd;
    }
    public int[] getWd() {
        return Wd;
    }
    public int getNumberOfCounters() {
        return numberOfCounters;
    }
    public int getLineUp() {
        return lineUp;
    }
    public void addLineUp(){
        this.lineUp++;
    }
    public void deleteLineUp(){
        this.lineUp--;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
    public boolean getIsEmpty() {
        return isEmpty;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
