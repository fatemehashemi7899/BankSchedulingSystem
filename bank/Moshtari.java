package bank;
import java.util.Scanner;
import java.util.ArrayList;
public class Moshtari {
    Scanner input = new Scanner(System.in);
    private Nobat myNobat;
    private int tedadKhedmatKhasteShode;
    private int[] shomareKhadamatKhasteShode;
    public static ArrayList<Moshtari> tedadMoshtari = new ArrayList<Moshtari>();
    public static int index = 0 ;
    private int whichBaje;
    public void addMoshtari(){
        System.out.println("baraie ijad moshtari (n) ra vared konid va baraie hazf ya khorooj e moshtari (q) ra vared konid :");
        String what = input.nextLine();
        if(what.equals("n") || what.equals("N")){
            Moshtari e = new Moshtari();
            Nobat n = new Nobat();
            n.addNobat(e);
            tedadMoshtari.add(index , e);
            index++;
            System.out.println("moshtari " + (index) + " ijad shod." + e.getMyNobat().printTime(n));
            System.out.println("moshtari " + (index) + " niaz be che khadamati darad ? tedad anhara vared konid.");
            int num = input.nextInt();
            e.setTedadKhedmatKhasteShode(num);
            e.shomareKhadamatKhasteShode = new int[num];
            for(int i = 0 ; i < num ; i++){
                System.out.println("shomare " + (i+1) + "omin khedmat mored niaz ra vared konid.");
                e.shomareKhadamatKhasteShode[i] = input.nextInt();
            }
            Khedmat.print();
            Khedmat k = new Khedmat();
            k.searchKhedmat(e);
            Baje.bajeha[0].goToWhichBaje(e);
        }
        if(what.equals("q") || what.equals("Q")){
            System.out.println("baraye khorooj e moshtari az bank (b) va baraye khorooj az baje (j) ra vared konid :");
            String w = input.nextLine();
            if(w.equals("j") || w.equals("J")) {
                System.out.println("shomare baje ra vared konid :");
                int b = input.nextInt();
                System.out.println("moshtari az baje " + b + "kharej shod.");
                Baje.bajeha[b - 1].setEmpty(true);
                for (int i = 0; i < Baje.bajeha[b-1].getMoshtari().getShomareKhadamatKhasteShode().length; i++) {
                    for (int j = 0; j < Baje.bajeha[b - 1].getKhadamatiKAnjamMidahad().length; j++) {
                        if (Baje.bajeha[b-1].getMoshtari().getShomareKhadamatKhasteShode()[i] == Baje.bajeha[b - 1].getKhadamatiKAnjamMidahad()[j]) {
                            Baje.bajeha[b-1].getMoshtari().getShomareKhadamatKhasteShode()[i] = 0;
                        }
                    }
                }
                Baje.bajeha[b - 1].setMoshtari(null);
            }
            if(w.equals("B") || w.equals("b")){
                System.out.println("baraie hazf e moshtari,shomare moshtari ra vared konid : ");
                int d = input.nextInt();
                tedadMoshtari.get(d-1).deleteFromBaje();
                tedadMoshtari.remove(d-1);
                System.out.println("moshtari shomare "+ d + "az bank kharej shod.");
            }
        }
    }

    public void setTedadKhedmatKhasteShode(int tedadKhedmatKhasteShode) {
        if(tedadKhedmatKhasteShode>0)this.tedadKhedmatKhasteShode = tedadKhedmatKhasteShode;
    }
    public void setMyNobat(Nobat myNobat) {
        this.myNobat = myNobat;
    }
    public Nobat getMyNobat() {
        return myNobat;
    }
    public void setWhichBaje(int whichBaje) {
        this.whichBaje = whichBaje;
    }
    public void deleteFromBaje(){
        int m = this.whichBaje;
        Baje.bajeha[m-1].deleteDarSAF();
    }
    public int[] getShomareKhadamatKhasteShode() {
        return shomareKhadamatKhasteShode;
    }
}
