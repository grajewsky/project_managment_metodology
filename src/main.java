import javax.swing.*;

/**
 * Created by LUU-GAMES on 2016-04-25.
 */

public class main {


    private static JFrame okno = new JFrame("Problematyki");

    public static void main(String[] args){
        sumacj _sumacj = new sumacj();
        cmax _cmax = new cmax();
        lmax _lmax = new lmax();
        _sumacj.setMenu("Problematyka 1||Suma Cj");
        _cmax.setMenu("Problematyka 1||Cmax");
        _lmax.setMenu("Problematyka 1||Lmax");
        okno.setSize(800,600);
        okno.setVisible(true);
        plotno p = new plotno();
        p.setSize(800,600);
        okno.add(p);

        /*

        onload load=  new onload();
        load.problematyki.put(1, _sumacj);
        load.problematyki.put(2, _cmax);
        load.problematyki.put(3, _lmax);
        load.input();
        load.todo();
        load.output();*/
    }
}
