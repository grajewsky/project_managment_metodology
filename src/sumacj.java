import java.util.*;

/**
 * Created by LUU-GAMES on 2016-04-25.
 */
public class sumacj implements Equation {

    private String title;
    private Scanner in = new Scanner(System.in);
    private int n = 0;
    private int t0 = 0;
    private List<Task> zadania= new ArrayList<Task>();
    private List<Job> jobs = new ArrayList<Job>();
    private int suma = 0;
    private class Task{
        public Task(int id, int val){
            this.id = id;
            this.value = val;
        }
        public int id;
        public int value;
    }
    private class Job {
        public String name;
        public int value;
        public Job(String name, int value){
            this.name = name;
            this.value = value;
        }
    }
    @Override
    public void input() {
        System.out.println("##Obliczanie problematyki 1||Suma Cj##");

        while(this.n <= 0){
            System.out.println("##Podaj n-problemów (n>0):");
            this.n  = in.nextInt();
        }
        int index = 1;
        int tmp_p = 0;
        while(index <= n){
            System.out.println("Podaj P"+index+":");
            tmp_p  = in.nextInt();
            if(tmp_p > 0){
                zadania.add(new Task(index, tmp_p));
                index++;
            }
        }

        do{
            System.out.println("##Podaj t0 (t0>=0) :");
            this.t0  = in.nextInt();
        }
        while(t0<0);


    }

    @Override
    public void todo() {

        Iterator<Task> it = (Iterator<Task>) zadania.iterator();
        while(it.hasNext()){
            Task task = (Task) it.next();
            System.out.println("P"+task.id + "="+task.value);
        }
        Collections.sort(zadania, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.value - o2.value;
            }
        });

        System.out.println("t0="+this.t0);

        Iterator<Task> it2 = (Iterator<Task>) zadania.iterator();
        suma += t0;
        while(it2.hasNext()){
            Task task = (Task) it2.next();

            System.out.println("P"+task.id + "="+task.value);
            suma = suma + task.value;
            jobs.add(new Job(String.format("J%d", task.id), suma));
        }
    }

    @Override
    public void output() {
        System.out.format("\n\n ###### WYNIK ###### \n\n");
        Iterator<Job> it = (Iterator<Job>) jobs.iterator();
        suma = 0;
        System.out.print("{");
        while(it.hasNext()){
            Job job = (Job) it.next();
            System.out.print(job.name + "="+ job.value);
            if(it.hasNext()){
                System.out.print(",");
            }
            suma += job.value;
        }

        System.out.print("} \n");
        System.out.println("Suma Cj = "+suma);
    }

    @Override
    public String menu() {
        return "Problematyka 1||Suma Cj";
    }
    public void setMenu(String title) {
        this.title = title;
    }
}
