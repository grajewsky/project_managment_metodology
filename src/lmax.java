import javafx.concurrent.Task;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Qriss on 2016-04-25.
 */
public class lmax implements Equation{

    public List<Task> zadania = new ArrayList<Task>();
    public int n;
    public int t;
    public int l=0;
    private String title;

    public class Task
    {
        public int id;
        public int value;
        public int term;
        public Task(int id, int value, int term)
        {
            this.id=id;
            this.value=value;
            this.term=term;

        }
    }

    @Override
    public void setMenu(String title) {
        this.title = title;
    }

    public void input()
    {


        Scanner input = new Scanner(System.in);
        System.out.println("Podaj czas poczatkowy");
        t=input.nextInt();
        System.out.println("Podaj liczbe zadan");
        n=input.nextInt();
        int value;
        int term;

        for (int i=0; i<n; i++)
        {

            System.out.println("Podaj wartosci zadania" + (i+1));
            value=input.nextInt();
            System.out.println("Podaj wartosci terminu zadania" + (i+1));
            term=input.nextInt();
            Task task = new Task((i+1),value,term);
            zadania.add(task);
        }

    }

    public void todo()
    {


        Collections.sort(zadania, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.term - o2.term;
            }
        });

        Task pomocnicza;
        for(int i=0;i<n;i++)
        {
            pomocnicza=zadania.get(i);
            t=t+pomocnicza.value;
            pomocnicza.value=t - pomocnicza.term;
            if(l<pomocnicza.value)
                l=pomocnicza.value;
        }

    }

    public Object output()
    {
        System.out.println("\f");
        Task pomocnicza;
        System.out.println("Kolejnosc zadan:");
        for(int i=0;i<n;i++)
        {
            pomocnicza = zadania.get(i);
            System.out.print(pomocnicza.id+", ");
        }
        System.out.println(" Lmax: "+l);

        return null;
    }

    @Override
    public String menu() {
        return this.title;
    }
}
