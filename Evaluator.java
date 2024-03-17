package expresionmatematica;
import java.util.Stack;

class Evaluator {
    // Método estático para evaluar la expresión en notación polaca (postfija)
    public static double evaluar(String notacionPolaca) {
        Stack<Double> stack = new Stack<>();

        String[] tokens = notacionPolaca.split(" ");

        for (String token : tokens) {
            if (!token.isEmpty()) { // Verificar que el token no esté vacío
                if (esOperador(token)) {
                    // Verificar si hay suficientes operandos en la pila
                    if (stack.size() < 2) {
                        throw new IllegalArgumentException("Faltan operandos para el operador: " + token);
                    }

                    double operand2 = stack.pop();
                    double operand1 = stack.pop();

                    switch (token) {
                        case "+":
                            stack.push(operand1 + operand2);
                            break;
                        case "-":
                            stack.push(operand1 - operand2);
                            break;
                        case "*":
                            stack.push(operand1 * operand2);
                            break;
                        case "/":
                            stack.push(operand1 / operand2);
                            break;
                        case "^":
                            stack.push(Math.pow(operand1, operand2));
                            break;
                        default:
                            throw new IllegalArgumentException("Operador no válido: " + token);
                    }
                } else {
                    // Manejar el caso cuando el token es un número
                    try {
                        stack.push(Double.parseDouble(token));
                    } catch (NumberFormatException e) {
                        System.err.println("Token inválido: " + token);
                        throw e; // Relanzar la excepción para terminar la ejecución
                    }
                }
            }
        }

        // Verificar si quedó exactamente un valor en la pila
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión matemática inválida");
        }

        return stack.pop();
    }

    private static boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }
}