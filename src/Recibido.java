
public class Recibido implements Runnable{
    private DataMan dat;
    private Hilo h;



    public Recibido(DataMan dat, Hilo h){
        this.dat = dat;
        this.h = h;
    }

    @Override
    public void run() {
        Cajero caj = new Cajero(this);
        Thread caj1 = new Thread(caj);
        caj1.start();


        int num = 0;
        for(num = dat.recibe(); h.getSize() >= 0; num = dat.recibe()){
            System.out.println("Se ha recibido: "+num);

            caj.añadir(num);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void ww(){
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void sta(){
        notifyAll();
    }

}
