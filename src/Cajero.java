import java.util.ArrayList;

public class Cajero implements Runnable{


    private ArrayList<Integer> dato = new ArrayList<>();

    private Recibido ree;

    public Cajero(Recibido re){
        this.ree = re;
    }
    @Override
    public void run() {
        while (true){
            if (dato.size() > 0){
                int one = dato.get(0);
                System.out.println("Ha Entrado -> "+ one);
                salir(one);
            }
            if (dato.size() == 0){
                try {
                    System.out.println("Esperando");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (dato.size() > 2) {
                System.out.println("Mucha gente");
            }
        }

    }

    public synchronized void añadir(int da){

        if (dato.size() < 3) {
            dato.add(da);
            System.out.println("En espera "+dato.size());
        } else {
            ree.ww();
        }
    }

    public void salir(int d){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dato.remove(0);
        System.out.println("A salido -> "+d);
        ree.sta();
    }
}
