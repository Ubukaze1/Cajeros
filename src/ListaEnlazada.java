import java.util.Arrays;

public class ListaEnlazada {

    Nodo cabeza;
    int dato;
    int size = 0;

    public ListaEnlazada(){
        cabeza = null;
    }

    public boolean empty(){
        return cabeza == null;
    }

    public void addPrimero(int dato){
        if (cabeza == null){
            cabeza = new Nodo(dato);
        } else {
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(dato);
            nuevo.enlazarSigueinte(temp);
            cabeza = nuevo;
        }
        size++;
    }

    public void addUltimo(int dato){
        if (cabeza == null) {
            cabeza = new Nodo(dato);
        }else {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null){
                temp = temp.getSiguiente();
            }
            Nodo nuevo = new Nodo(dato);
            temp.enlazarSigueinte(nuevo);
        }
        size++;
    }

    public void imprimir(){
        if (cabeza != null) {
            int[] li = new int[size];
            Nodo temp = cabeza;
            for (int i = 0; i < size; i++) {
                li[i] = temp.getDato();
                temp = temp.getSiguiente();
            }
            System.out.println(Arrays.toString(li));
        } else {
            System.out.println("No hay Nodos");
        }
    }

    public int obtener(int index){
        if (cabeza != null) {
            Nodo temp = cabeza;
            for (int i = 0; i < index; i++) {
                temp = temp.getSiguiente();
            }
            System.out.println(temp.getDato());
            return temp.dato ;
        } else {
            System.out.println("No hay nodos");
            return 0;
        }
    }

    public int getSize() {
        return size;
    }

    public void pop(){
        if (cabeza != null){
            Nodo temp = cabeza;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.getSiguiente();
            }
            temp.enlazarSigueinte(null);
            size--;
        }

    }

    public int getUltimo(){
        int ultimo = 0;
        int ind = size;
        ind--;
        if (cabeza != null) {
            Nodo temp = cabeza;

            for (int i = 0; i < ind; i++) {
                temp = temp.getSiguiente();
            }
            ultimo = temp.getDato();
        }
        return ultimo;
    }





}
