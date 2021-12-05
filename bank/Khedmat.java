package bank;
public class Khedmat {
    public static int total;
    private String name;
    public static Khedmat[] totalKhedmat;
    public Khedmat(){}
    public void searchKhedmat(Moshtari e) {
        int[][] search = new int[e.getShomareKhadamatKhasteShode().length][Baje.totalBaje];
        int in = 0;
        for (int j = 0; j < e.getShomareKhadamatKhasteShode().length; j++) {
            for (int i = 0; i < Baje.totalBaje; i++) {
                for (int k = 0; k < Baje.bajeha[i].getKhadamatiKAnjamMidahad().length; k++) {
                    if (e.getShomareKhadamatKhasteShode()[j] == Baje.bajeha[i].getKhadamatiKAnjamMidahad()[k]) {
                        search[j][in] = Baje.bajeha[i].getBajeCount();
                        in++;
                        break;
                    }
                }
            }
            in = 0;
        } // Search :)
        int a ;
        for(int i = 0 ; i < e.getShomareKhadamatKhasteShode().length ; i++) {
            a = 500;
            for (int j = 0; j < search[i].length -1; j++) {
                if (search[i][j] != 0 && search[i][j + 1] !=0){
                    if (Baje.bajeha[search[i][j] - 1].getDarSAF() > Baje.bajeha[search[i][j + 1] - 1].getDarSAF()) {
                        a = search[i][j + 1] - 1;
                    } else {
                        a = search[i][j] - 1;
                    }
                }
                if(search[i][j]!= 0 && search[i][j+1]==0 && a==500 ){
                    a = search[i][j] -1;
                }
            }
            Baje.bajeha[a].addDarSAF();
            e.setWhichBaje(a+1);
           // System.out.println("a : " + a);
        }

      /*  for(int c = 0 ; c < search.length ; c++){
            for(int b = 0 ; b < search[a].length ; b++){
                System.out.print(search[a][b]);
            }
            System.out.println("");
        }*/
    }
    public static void print(){
        System.out.println("khadamat khaste shode : ");
        for( int i = 0 ; i < Khedmat.total ; i++){
            System.out.println("khedmat shomare " + (i+1) +" : " +Khedmat.totalKhedmat[i].getName());
        }
    }
    public Khedmat(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
