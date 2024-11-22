public class ListaLigada {
    
    private Nodo head;
    private Nodo tail;
    private Nodo actual;
    private int size; // tamaño actual de la lista

    // Agregar nodo al final
    public void add(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (this.size == 0) {
            // Escenario 1: Es el primer nodo que se crea
            this.head = nuevoNodo;
            this.tail = nuevoNodo;
        } else {
            // Escenario 2: No es el primer nodo, la lista ya tiene nodos
            this.tail.setSiguiente(nuevoNodo);
            this.tail = nuevoNodo;
        }
        this.size++;
    }

    // Insertar nodo en posición específica
    public void addAt(int pos, int dato) {
        if (pos < 0 || pos > size) {
            System.out.println("Posición fuera del rango");
        }

        Nodo nuevoNodo = new Nodo(dato);

        if (pos == 0) { // Insertar al inicio
            nuevoNodo.setSiguiente(head);
            head = nuevoNodo;
            if (size == 0) { // Si la lista estaba vacía
                tail = nuevoNodo;
            }
        } else if (pos == size) { // Insertar al final
            tail.setSiguiente(nuevoNodo);
            tail = nuevoNodo;
        } else { // Insertar en medio
            Nodo actual = head;
            for (int i = 0; i < pos - 1; i++) { // Encontrar el nodo anterior a la posición
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
        size++;
    }

    // Método de la profe para añadir en posición especifica
    public void addAt2(int dato, int pos) {
        int indice = 1;
        Nodo aux;
        // 1. Crear el nodo
        Nodo nuevoNodo = new Nodo(dato);
        // nuevoNodo = null
        if ( pos < sizeOfList() ){
            // Se puede insertar porque la posición es válida
            // 2. Recorrer la lista hasta llegar a la posición
            actual = head;
            while ( indice < pos - 1) {
                aux = actual.getSiguiente();
                actual = aux;
                indice++;
            }
            // 3. Insertar nuevoNodo
            aux = actual.getSiguiente();
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(aux);
        } else {
            System.out.println("La posición no es válida. No se puede insertar.");
        }
    }

    // Eliminar nodo en posición específica
    public void elimAt(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posición fuera del rango");
        }

        if (pos == 0) { // Eliminar el primer nodo
            head = head.getSiguiente();
            if (size == 1) { // Si era el único nodo
                tail = null;
            }
        } else {
            Nodo actual = head;
            for (int i = 0; i < pos - 1; i++) { // Encontrar el nodo anterior al que queremos eliminar
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            if (pos == size - 1) { // Si era el último nodo
                tail = actual;
            }
        }
        size--;
    }

    public int sizeOfList() {
        return this.size;
    }

    // Método para imprimir todos los nodos de la lista
    public void print() {
        this.actual = this.head;
        while (actual != null) {
            int dato = actual.getDato();
            System.out.println("Dato: " + dato);
            actual = actual.getSiguiente();
        }
    }
}
