package expresionmatematica;
public class NotacionPolaca {
    // Método estático para convertir la expresión a notación polaca (postfija)
    public static String convertir(String expresion) {
        String[] tokens = expresion.trim().split("\\s+");
        StringBuilder resultado = new StringBuilder();
        for (String token : tokens) {
            if (!token.isEmpty()) { // Filtrar tokens vacíos
                if (esOperador(token)) {
                    // Hacer algo con el operador si es necesario
                } else {
                    // Manejar los operandos
                }
            }
        }

        return resultado.toString();
    }

    // Método estático para verificar si un token es un operador
    private static boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }
}