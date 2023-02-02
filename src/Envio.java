import java.util.concurrent.ThreadLocalRandom;

public class Envio implements Runnable{
    private DataMan dat;
    private Hilo h;

    public Envio(DataMan man,Hilo h){
        dat = man;
        this.h = h;
    }


    @Override
    public void run() {
        int i;
        while (true){
            if (h.getSize() == 10){
                while (true){
                    dat.envia(h.sacar());
                    System.out.println("Aqui se saca");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                /*
                if (i == h.getSize()) {
                    System.out.println("Termina por enviar");
                    System.exit(0);
                }
                */
            } else {
                try {
                    System.out.println("Esperar");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
