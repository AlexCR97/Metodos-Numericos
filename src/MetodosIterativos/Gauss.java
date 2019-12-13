package MetodosIterativos;

public class Gauss {
    
    private final double[][] matriz;
    private final double[] variables;
    private final int numVariables;
    
    public Gauss(double[][] matriz, int numVariables) {
        this.matriz = matriz;
        this.numVariables = numVariables;
        this.variables = new double[numVariables];
    }
    
    public void resolver() {
        mostrarMatriz(matriz);

        for (int indicePivote = 0; indicePivote < numVariables; indicePivote++) {
            convertirEnUno(indicePivote);
            convertirEnCeros(indicePivote);
            mostrarMatriz(matriz);
        }
        
        calcularVariables(matriz);
        mostrarVariables();
    }
    
    private void mostrarMatriz(double[][] matriz) {
        for (int i = 0; i < numVariables; i++) {
            for (int j = 0; j < numVariables + 1; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    private void convertirEnUno(int indicePivote) {
        double coeficiente = matriz[indicePivote][indicePivote];

        for (int i = 0; i < numVariables + 1; i++) {
            matriz[indicePivote][i] = matriz[indicePivote][i] / coeficiente;
        }
    }
    
    private void convertirEnCeros(int indicePivote) {
        for (int i = 0; i < numVariables; i++) {
            if (i > indicePivote) {
                double coeficiente = matriz[i][indicePivote];

                for (int j = 0; j < numVariables + 1; j++) {
                    matriz[i][j] = (-coeficiente * matriz[indicePivote][j]) + matriz[i][j];
                }
            }
        }
    }
    
    private void calcularVariables(double[][] matriz) {
        for (int i = numVariables - 1; i >= 0; i--) {
            double[] renglon = matriz[i];
            double constante = renglon[renglon.length - 1];
            double suma = 0;
            
            for (int j = renglon.length - 2; j >= 0; j--) {
                double coeficiente = renglon[j];
                if (coeficiente == 0)
                    break;
                
                suma += variables[j] * coeficiente;
            }
            variables[i] = constante - suma;
        }
    }

    private void mostrarVariables() {
        for (int i = 0; i < numVariables; i++) {
            System.out.println("v" + (i + 1) + " = " + variables[i]);
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        double[][] matriz;
        int numVariables;
        Gauss g;
        
        // Matriz 2 x 2
        matriz = new double[][] {
            {4, 2, 6},
            {1, 1, 8},
        };
        numVariables = 2;
        g = new Gauss(matriz, numVariables);
        g.resolver();
        
        System.out.println("-------------------------------------------------");
        
        // Matriz 3 x 3
        matriz = new double[][] {
            {2, -1, 1, 2},
            {3, 1, -2, 9},
            {-1, 2, 5, -5},
        };
        numVariables = 3;
        g = new Gauss(matriz, numVariables);
        g.resolver();
        
        System.out.println("-------------------------------------------------");
        
        // Matriz 4 x 4
        matriz = new double[][] {
            {2, 4, 6, -8, 10},
            {-8, 2, -4, -4, 4},
            {2, 2, -10, 6, 2},
            {10, 8, 8, 8, -2},
        };
        numVariables = 4;
        g = new Gauss(matriz, numVariables);
        g.resolver();
    }
}
