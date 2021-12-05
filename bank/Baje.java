package bank;
public class Baje {
    public static int totalBaje;
    public static Baje[] bajeha;
    private int bajeCount;
    private int tedadKhedmat;
    private int[] khadamatiKAnjamMidahad;
    private Moshtari moshtari = new Moshtari();
    private int darSAF = 0 ;
    private boolean isEmpty = true;

    public void goToWhichBaje(Moshtari e) {
        int m = 0;
        for (int i = 0; i < e.getShomareKhadamatKhasteShode().length; i++) {
            if (e.getShomareKhadamatKhasteShode()[i] != 0) {
                m = e.getShomareKhadamatKhasteShode()[i];
                e.getShomareKhadamatKhasteShode()[i] = 0;
                break;
            }
        }
        for (int j = 0; j < Baje.totalBaje; j++) {
            for (int k = 0; k < Baje.bajeha[j].getKhadamatiKAnjamMidahad().length; k++) {
                if (Baje.bajeha[j].getKhadamatiKAnjamMidahad()[k] == m) {
                    if (Baje.bajeha[j].getIsEmpty() == true && Baje.bajeha[j].getDarSAF() != 0) {
                        Baje.bajeha[j].deleteDarSAF();
                        Baje.bajeha[j].setEmpty(false);
                        Baje.bajeha[j].setMoshtari(e);
                        System.out.println("Nobat " + e.getMyNobat().getNobatMoshtari() + " be baje " + Baje.bajeha[j].getBajeCount());
                    }
                }
            }
        }
    }

    public void printEmpty(){
        for(int i = 0 ; i < Baje.totalBaje ; i++ ){
            System.out.println("vaziat e baje " + (i+1) + " : " + Baje.bajeha[i].getIsEmpty());
        }
    }
    public void printDarSAF(){
        for(int i = 0 ; i < Baje.totalBaje ; i++){
            System.out.println("moshtarian e dar saf e baje " + (i+1) +" : " + Baje.bajeha[i].getDarSAF());
        }
    }

    public void setBajeCount(int bajeCount) {
        if(bajeCount>0) this.bajeCount = bajeCount;
        else this.bajeCount = 0;
    }
    public void setTedadKhedmat(int tedadKhedmat) {
        if(tedadKhedmat>0)this.tedadKhedmat = tedadKhedmat;
        else this.tedadKhedmat = 0;
    }
    public void setKhadamatiKAnjamMidahad(int[] khadamatiKAnjamMidahad) {
        this.khadamatiKAnjamMidahad = khadamatiKAnjamMidahad;
    }
    public int[] getKhadamatiKAnjamMidahad() {
        return khadamatiKAnjamMidahad;
    }
    public int getBajeCount() {
        return bajeCount;
    }
    public int getDarSAF() {
        return darSAF;
    }
    public void addDarSAF(){
        this.darSAF++;
    }
    public void deleteDarSAF(){
        this.darSAF--;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
    public boolean getIsEmpty() {
        return isEmpty;
    }

    public void setMoshtari(Moshtari moshtari) {
        this.moshtari = moshtari;
    }

    public Moshtari getMoshtari() {
        return moshtari;
    }
}
