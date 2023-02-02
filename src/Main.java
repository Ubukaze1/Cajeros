public class Main {
    public static void main(String[] args) {
        DataMan dat = new DataMan();
        Hilo h = new Hilo();
        h.start();
        Thread envios = new Thread(new Envio(dat,h));
        Thread recibido = new Thread(new Recibido(dat,h));

        envios.start();
        recibido.start();

    }
}