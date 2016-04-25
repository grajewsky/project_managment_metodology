import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by LUU-GAMES on 2016-04-25.
 */
public class onload implements Equation {

    private Scanner input = new Scanner(System.in);
    public HashMap<Integer, Equation> problematyki = new HashMap<Integer, Equation>();
    private Equation problematyka = null;
    private String title;

    @Override
    public void setMenu(String title) {
        this.title = title;
    }

    @Override
    public void input() {
        String win = "";
        String menu = "## Jednomaszynowe problemy szeregowania zadan ## \n";
        Iterator it = problematyki.entrySet().iterator();
        int index = 1;
        while(it.hasNext()){
            Map.Entry problem = (Map.Entry)it.next();
            Equation eq = (Equation) problem.getValue();
            menu += "## "+index++ +". "+ eq.menu() + "\n";
        }
        System.out.format(menu);
        int choose = input.nextInt();
        this.problematyka = problematyki.get(choose);
        if(this.problematyka != null && this.problematyka instanceof Equation){
            problematyka.input();
            problematyka.todo();
            problematyka.output();
        }
    }

    @Override
    public void todo() {

    }

    @Override
    public void output() {

    }

    @Override
    public String menu() {
        return null;
    }
}
