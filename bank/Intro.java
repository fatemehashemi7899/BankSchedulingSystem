package bank;
import java.util.Scanner;
import static bank.Baje.bajeha;
public class Intro {
    Scanner input = new Scanner(System.in);
    public void intro(){
        System.out.println("lotfan shomare aghaz e nobat ra vared konid : ");
        Nobat.count = input.nextInt();
        System.out.println("lotfan tedad koll e khadamat ra vared konid : ");
        Khedmat.total = input.nextInt();
        input.nextLine();
        Khedmat.totalKhedmat = new Khedmat[Khedmat.total];
        for ( int i = 0; i < Khedmat.total ; i++){
            System.out.println("nam e khedmat shomare " + (i+1) +" ra vared konid : ");
            Khedmat.totalKhedmat[i] = new Khedmat(input.nextLine());
        }
        System.out.println("lotfan tedad koll e bajeha ra vared konid : ");
        Baje.totalBaje = input.nextInt();
        input.nextLine();
        Baje.bajeha = new Baje[Baje.totalBaje ];
        Khedmat.print();
        for(int i = 0 ; i < Baje.totalBaje ; i++) {
            Baje.bajeha[i] = new Baje();
            Baje.bajeha[i].setBajeCount(i + 1);
            System.out.println("lotfan moshakhas konid baje " + (i + 1) + " che tedad khedmat ra anjam midahad : ");
            int m = input.nextInt();
            input.nextLine();
            Baje.bajeha[i].setTedadKhedmat(m);
            int[] kh = new int[m];
            System.out.println("lotfan moshakhas konid baje " + (i + 1) + " che khedmat/khadamati ra anjam midahad(pas az har shomare khedmat Enter ra bezanid) : ");
            for (int j = 0; j < m; j++) {
                kh[j] = input.nextInt();
            }
            Baje.bajeha[i].setKhadamatiKAnjamMidahad(kh);
        }
    }
    public void amaliat(){
        while(true){
            Moshtari need = new Moshtari();
            need.addMoshtari();
            Baje.bajeha[0].printEmpty();
            Baje.bajeha[0].printDarSAF();
        }
    }
}
