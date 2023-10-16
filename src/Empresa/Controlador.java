// Clase Controlador que maneja una lista de empleados
package Empresa;

public class Controlador {

    public int contador; // Contador para rastrear el número de nodos en la lista
    public Nodo inicial; // Nodo inicial de la lista
    public Nodo ultimo; // Nodo final de la lista

    // Constructor de la clase Controlador
    public Controlador() {
        contador = 0;
        inicial = null;
        ultimo = null;
    }

    // Método para insertar un nuevo objeto en la lista
    public void insertar(Object inserta) {
        contador++;
        Nodo nuevo = new Nodo(inserta);
        if (inicial == null && ultimo == null) {
            inicial = nuevo;
            ultimo = nuevo;
            nuevo.sig = null;
            nuevo.ant = null;
        } else if (ultimo == inicial) {
            ultimo = nuevo;
            inicial.sig = ultimo;
            inicial.ant = null;
            ultimo.ant = inicial;
            ultimo.sig = null;
        } else {
            ultimo = nuevo;
            Nodo aux = inicial;
            while (aux != null && aux.tieneSig()) {
                aux = aux.getSig();
            }
            assert aux != null;
            aux.setSig(ultimo);
            ultimo.setSig(null);
            ultimo.setAnt(aux);
        }
    }

    // Método para verificar si la lista está vacía
    public boolean esVacia() {
        return inicial == null;
    }

    // Método para modificar un objeto en la lista
    boolean modifica(Empleado a, Empleado b) {
        boolean exito = false;
        Nodo aux = this.inicial;
        while (aux != null) {
            if (aux.actual == a) {
                aux.actual = b;
                exito = true;
                break;
            }
            aux = aux.getSig();
        }
        return exito;
    }

    // Método privado para eliminar un objeto de la lista
    private boolean elimina(Object a) {
        boolean exito = false;
        Nodo aux = inicial;
        while (aux != null && aux.tieneSig()) {
            if (aux.actual.equals(a)) {
                if (aux == inicial) {
                    inicial = inicial.sig;
                    inicial.ant = null;
                    exito = true;
                } else if (aux == ultimo) {
                    ultimo = ultimo.ant;
                    ultimo.sig = null;
                } else {
                    aux.ant.sig = aux.sig;
                    aux.sig.ant = aux.ant;
                    exito = true;
                }
            }
            aux = aux.getSig();
        }
        if (exito) {
            contador--;
        }
        return exito;
    }

    // Método para verificar si el número de empleado ya existe en la lista
    public boolean numRepe(int num) {
        Nodo aux = this.inicial;
        while (aux != null) {
            Empleado e1 = (Empleado) aux.actual;
            if (e1.getNumero() == num) {
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }

    // Clase interna Nodo que representa un nodo en la lista
    public static class Nodo {
        public Object actual;
        private Nodo sig;
        private Nodo ant;

        // Constructor de la clase Nodo
        public Nodo(Object actual) {
            this.actual = actual;
        }

        // Método para verificar si el nodo tiene un nodo siguiente
        public boolean tieneSig() {
            return this.sig != null;
        }

        // Método para verificar si el nodo tiene un nodo anterior
        public boolean tieneAnt() {
            return this.ant != null;
        }

        // Métodos para obtener el nodo siguiente y anterior
        public Nodo getSig() {
            return sig;
        }

        public Nodo getAnt() {
            return ant;
        }

        // Métodos para establecer el nodo siguiente y anterior
        public void setSig(Nodo sig) {
            this.sig = sig;
        }

        public void setAnt(Nodo ant) {
            this.ant = ant;
        }
    }
}
