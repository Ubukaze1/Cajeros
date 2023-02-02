import java.util.ArrayList;

public class Cajero implements Runnable{


    private ArrayList<Integer> dato = new ArrayList<>();

    private Recibido ree;

    public Cajero(Recibido re){
        this.ree = re;
    }
    @Override
    public synchronized void run() {
        while (true){
            if (dato.size() > 0){
                int one = dato.get(0);
                dato.remove(0);
                salir(one);
            }
            if (dato.size() == 0){
                try {
                    System.out.println("Esperando");
                    wait();
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
        notify();

        if (dato.size() < 2) {
            System.out.println("Ha Entrado ->"+ da);
            dato.add(da);
        } else {
            System.out.println("Los clientes son en espera son");
            ree.ww();
        }
    }

    public synchronized void salir(int d){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("A salido -> "+d);
        ree.sta();
    }
}
