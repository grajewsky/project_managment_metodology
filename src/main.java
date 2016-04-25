/**
 * Created by LUU-GAMES on 2016-04-25.
 */

public class main {

    public static void main(String[] args){
        onload load=  new onload();
        sumacj _sumacj = new sumacj();
        _sumacj.setMenu("Problematyka 1||Suma Cj");

        load.problematyki.put(1, _sumacj);
        load.input();
        load.todo();
        load.output();
    }
}
