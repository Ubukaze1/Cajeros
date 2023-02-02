
import java.util.concurrent.ThreadLocalRandom;

public class Recibido implements Runnable{
    private DataMan dat;
    private Hilo h;


    public Recibido(DataMan dat, Hilo h){
        this.dat = dat;
        this.h = h;
    }

    @Override
    public void run() {
        int num = 0;
        for(num = dat.recibe(); h.getSize() >= 0; num = dat.recibe()){
            System.out.println("Se ha recibido: "+num);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
