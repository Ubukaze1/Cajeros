public class DataMan {

    private int dat;
    private boolean trans = true;

    public synchronized int recibe() {
        while (trans) {
            try {
                //System.out.println("EStoy esperando Recibe");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        trans = true;
        notifyAll();
        return this.dat;
    }

    public synchronized void envia(int dato) {
        while (!trans) {
            try {
                //System.out.println("EStoy esperando Envio");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        trans = false;
        this.dat = dato;
        notifyAll();

    }

}
