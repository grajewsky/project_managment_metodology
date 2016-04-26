/*Created by Łukasz Nawrocki
*/

import java.util.Scanner;

public class cmax implements Equation
{
    private int[] p;
    private int cmax_value=0;
    private Scanner input;

    private String title;

    @Override
    public void setMenu(String title) {
        this.title = title;
    }

    @Override
    public void input(){
        String text = "Podaj ilość zadań: ";
        System.out.print('\u000C'+text);
        input = new Scanner(System.in);
        this.p = new int[isNegative(input.nextInt(), text)];
        
        System.out.println('\u000C'+"Podaj czasy wykonywania zadań: ");
        for(int x=0; x<this.p.length; x++){
            text = "p"+(x+1)+"= ";
            System.out.print(text);
            input = new Scanner(System.in);
            this.p[x] = isNegative_from0(input.nextInt(), text);
        }
        
        text = "Podaj czas początkowy t0: ";
        System.out.print('\u000C'+text);
        input = new Scanner(System.in);
        this.cmax_value = isNegative_from0(input.nextInt(), text);
    }
    
    @Override
    public void todo(){
        for(int i=0; i<this.p.length; i++){
            this.cmax_value += this.p[i];
        }
    }
    
    @Override
    public Object output(){
        System.out.print("\n\n{");
        for(int i=0; i<this.p.length; i++){
            if(i!=(this.p.length-1))
                System.out.print(this.p[i] + ",");
            else
                System.out.print(this.p[i]);
        }
        System.out.print("}\nCmax = "+ this.cmax_value);
        return null;
    }

    @Override
    public String menu() {
        return this.title;
    }

    //pomocnicze metody z ograniczeniem dla wprowadzanej wartości
    private int isNegative(int number, String text){
        if(number <= 0){
            do{
                System.out.print("Podana wartość nie musi być większa od zera!\n" + text);
                input = new Scanner(System.in);
                number = input.nextInt();
            }while(number <= 0);
        }        
        return number;
    }
    
    private int isNegative_from0(int number, String text){
        if(number < 0){
            do{
                System.out.print("Podana wartość nie musi być nieujemna!\n" + text);
                input = new Scanner(System.in);
                number = input.nextInt();
            }while(number < 0);
        }        
        return number;
    }
}