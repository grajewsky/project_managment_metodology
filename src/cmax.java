/*Created by Łukasz Nawrocki*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cmax implements Equation
{
	public List<Task> zadania = new ArrayList<Task>();
	public class Task{
		public int id;
		public int value;
		public Task(int i, int v){
			this.id = i;
			this.value = v;
		}
	}
	
	public Zwroc zwroc;
	public class Zwroc{
		public List<Task> tasks;
		public int t0;
		public int cmax;
		public Zwroc(List<Task> zadania, int t0){
			this.tasks = zadania;
			this.t0 = t0;
		}
	}
	
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
        int n = isNegative(input.nextInt(), text);
        
        System.out.println('\u000C'+"Podaj czasy wykonywania zadań: ");
        for(int x=0; x<n; x++){
            text = "p"+(x+1)+"= ";
            System.out.print(text);
            input = new Scanner(System.in);
            this.zadania.add(new Task((x+1), isNegative_from0(input.nextInt(), text)));
        }
        
        text = "Podaj czas początkowy t0: ";
        System.out.print('\u000C'+text);
        input = new Scanner(System.in);
        
        //tworzymy obiekt który będziemy zwracać w output()
        this.zwroc = new Zwroc(this.zadania, isNegative_from0(input.nextInt(), text));
    }
    
    @Override
    public void todo(){
        for(int i=0; i<this.zadania.size(); i++){
            this.zwroc.cmax += (this.zadania.get(i)).value;
        }
    }
    
    @Override
    public Object output(){
        return this.zwroc;
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