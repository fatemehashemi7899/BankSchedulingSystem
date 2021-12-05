package bank;
public class Works {
    public static int total;
    private String name;
    public static Works[] totalWorks;
    public Works(){}
    public void searchWorks(Customer e) {
        int[][] search = new int[e.getNumberOfWorks().length][Counter.totalCounters];
        int in = 0;
        for (int j = 0; j < e.getNumberOfWorks().length; j++) {
            for (int i = 0; i < Counter.totalCounters; i++) {
                for (int k = 0; k < Counter.Counters[i].getWd().length; k++) {
                    if (e.getNumberOfWorks()[j] == Counter.Counters[i].getWd()[k]) {
                        search[j][in] = Counter.Counters[i].getNumberOfCounters();
                        in++;
                        break;
                    }
                }
            }
            in = 0;
        } // Search :)
        int a ;
        for(int i = 0; i < e.getNumberOfWorks().length ; i++) {
            a = 500;
            for (int j = 0; j < search[i].length -1; j++) {
                if (search[i][j] != 0 && search[i][j + 1] !=0){
                    if (Counter.Counters[search[i][j] - 1].getLineUp() > Counter.Counters[search[i][j + 1] - 1].getLineUp()) {
                        a = search[i][j + 1] - 1;
                    } else {
                        a = search[i][j] - 1;
                    }
                }
                if(search[i][j]!= 0 && search[i][j+1]==0 && a==500 ){
                    a = search[i][j] -1;
                }
            }
            Counter.Counters[a].addLineUp();
            e.setWhichCounter(a+1);
        }

    }
    public static void print(){
        System.out.println("khadamat khaste shode : ");
        for(int i = 0; i < Works.total ; i++){
            System.out.println("khedmat shomare " + (i+1) +" : " + Works.totalWorks[i].getName());
        }
    }
    public Works(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
