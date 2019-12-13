package GaussJordan;

public class GaussJordan {

    private GaussJordan() {}

    public static void resolver(double[][] matriz, int numVariables) {
        imprimirMatriz(matriz, 0);

        for (int indicePivote = 0; indicePivote < numVariables; indicePivote++) {
            intercambiarRenglon(matriz, indicePivote, 0);
            transformarEnUno(matriz, indicePivote, numVariables);
            transformarEnCeros(matriz, indicePivote, numVariables);
            imprimirMatriz(matriz, indicePivote + 1);
        }
    }

    private static void imprimirMatriz(double[][] matriz, int iteracion) {
        System.out.println("Iteracion: " + iteracion);
        for (double[] i: matriz) {
            for (double j: i)
                System.out.print(j + " ");
            System.out.println();
        }
        System.out.println("----------------------------------");
    }

    private static void intercambiarRenglon(double[][] matriz, int indicePivote, int indiceOtro) {
        if (indiceOtro >= matriz.length)
            return;

        if (indiceOtro == indicePivote)
            intercambiarRenglon(matriz, indicePivote, indiceOtro + 1);

        if (matriz[indicePivote][indicePivote] == 0) {
            double[] temp = matriz[indicePivote];
            matriz[indicePivote] = matriz[indiceOtro];
            matriz[indiceOtro] = temp;

            intercambiarRenglon(matriz, indicePivote, indiceOtro + 1);
        }
    }

    private static void transformarEnUno(double[][] matriz, int indicePivote, int numVariables) {
        double temp = matriz[indicePivote][indicePivote];

        for (int i = 0; i < numVariables + 1; i++)
            matriz[indicePivote][i] = matriz[indicePivote][i] / temp;
    }

    private static void transformarEnCeros(double[][] matriz, int indicePivote, int numVariables) {
        for (int i = 0; i < numVariables; i++) {
            if (i != indicePivote) {
                double coeficiente = matriz[i][indicePivote];

                for (int j = 0; j < numVariables + 1; j++)
                    matriz[i][j] = (-coeficiente * matriz[indicePivote][j]) + matriz[i][j];
            }
        }
    }

    // Main thread
    public static void main(String[] args) {
        double[][] matriz = new double[][] {
            {2, 4, 6, -8, 10},
            {-8, 2, -4, -4, 4},
            {2, 2, -10, 6, 2},
            {10, 8, 8, 8, -2},
        };
        
        GaussJordan.resolver(matriz, 4);
    }

}

