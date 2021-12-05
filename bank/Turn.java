package bank;
import java.sql.Time;
public class Turn {
    public static int count = 0;
    private Time time;
    private int customersTurn = 0;
    public void addTurn(Customer e ) {
        Turn.count++;
        e.setMyTurn(this);
        this.time =new Time(System.currentTimeMillis());
        this.customersTurn = Turn.count;
    }
    public Time printTime(Turn n){
        return n.time;
    }

    public int getCustomersTurn() {
        return customersTurn;
    }
}
