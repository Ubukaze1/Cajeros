public class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public void enlazarSigueinte(Nodo n){
        this.siguiente = n;
    }

    public int getDato(){
        return dato;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }


}
