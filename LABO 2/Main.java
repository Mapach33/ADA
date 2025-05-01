import java.util.Scanner;

public class Main {
    public static int[] sumaSubsecuenciaMaxima(int[] arr) {
        int maxActual = 0; // Suma máxima que termina en la posición actual
        int maxGlobal = 0; // Suma máxima encontrada hasta ahora
        int inicio = 0, fin = 0, tempInicio = 0; // Variables para rastrear la subsecuencia

        for (int i = 0; i < arr.length; i++) {
            if (maxActual + arr[i] > arr[i]) {
                maxActual += arr[i];
            } else {
                maxActual = arr[i];
                tempInicio = i; // Reiniciamos el inicio temporal
            }

            if (maxActual > maxGlobal) {
                maxGlobal = maxActual;
                inicio = tempInicio; // Actualizamos el inicio de la subsecuencia
                fin = i; // Actualizamos el fin de la subsecuencia
            }
        }

        // Retornamos la suma máxima y la subsecuencia
        int[] subsecuencia = new int[fin - inicio + 1];
        System.arraycopy(arr, inicio, subsecuencia, 0, fin - inicio + 1);
        System.out.println("Subsecuencia máxima: " + java.util.Arrays.toString(subsecuencia));
        return new int[]{maxGlobal};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los números del arreglo separados por espacios:");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] resultado = sumaSubsecuenciaMaxima(arr);
        System.out.println("Suma máxima de subsecuencia: " + resultado[0]);
    }
}