package expresionmatematica;

class NodoArbol {
    String valor;
    NodoArbol izquierdo, derecho;

    NodoArbol(String valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}