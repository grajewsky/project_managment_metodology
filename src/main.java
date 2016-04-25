/**
 * Created by LUU-GAMES on 2016-04-25.
 */

public class main {

    public static void main(String[] args){
        onload load=  new onload();
        sumacj _sumacj = new sumacj();
        cmax _cmax = new cmax();
        lmax _lmax = new lmax();
        _sumacj.setMenu("Problematyka 1||Suma Cj");
        _cmax.setMenu("Problematyka 1||Cmax");
        _lmax.setMenu("Problematyka 1||Lmax");

        load.problematyki.put(1, _sumacj);
        load.problematyki.put(2, _cmax);
        load.problematyki.put(3, _lmax);
        load.input();
        load.todo();
        load.output();
    }
}
