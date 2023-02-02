
public class Hilo extends Thread{

    private boolean llena = false;
    private ListaEnlazada lista = new ListaEnlazada();
    private int index = 0;

    @Override
    public synchronized void run() {
        while (true){
            while (!llena){
                if (lista.getSize() != 10){
                    lista.addPrimero(index);
                    index++;
                }else {
                    //lista.imprimir();
                    llena = true;
                    try {
                        //System.out.println("Esperando....");
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                // System.out.println("Hola Hola");
            }
        }
    }

    public synchronized int sacar(){
        int ultimo = lista.getUltimo();
        lista.pop();
        //lista.imprimir();
        //System.out.println(lista.getSize()+"Size Size");
        //System.out.println(llena+"Esta llena");
        notifyAll();
        //System.out.println("Empezando de nuevo");
        llena = false;
        return ultimo;


    }

    public synchronized int getSize(){
        return lista.getSize();
    }

    public boolean isLlena() {
        return llena;
    }

    public synchronized void setLlena(boolean llena) {
        this.llena = llena;
    }
}

