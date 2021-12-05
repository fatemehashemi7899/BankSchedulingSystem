package bank;
import java.sql.Time;
public class Nobat {
    public static int count = 0;
    private Time time;
    private int nobatMoshtari = 0;
    public void addNobat(Moshtari e ) {
        Nobat.count++;
        e.setMyNobat(this);
        this.time =new Time(System.currentTimeMillis());
        this.nobatMoshtari = Nobat.count;
    }
    public Time printTime(Nobat n){
        return n.time;
    }

    public int getNobatMoshtari() {
        return nobatMoshtari;
    }
}
