package MetodosIterativos;

public class Seidel {
    
    private Seidel() {}
    
    public static void resolver(double[][] matriz, double errorBase) {
        int iteracion = 1;
        
        double[] xPrevia = {0, 0, 0};
        double[] xActual = {0, 0, 0};
        
        xActual[0] = calcularX1(matriz, xPrevia[1], xPrevia[2]);
        xPrevia[0] = xActual[0];
        
        xActual[1] = calcularX2(matriz, xPrevia[0], xPrevia[2]);
        xPrevia[1] = xActual[1];
        
        xActual[2] = calcularX3(matriz, xPrevia[0], xPrevia[1]);
        xPrevia[2] = xActual[2];
        
        info(iteracion++, xPrevia, xActual);
        
        while (true) {
            
            xActual[0] = calcularX1(matriz, xPrevia[1], xPrevia[2]);
            xPrevia[0] = xActual[0];

            xActual[1] = calcularX2(matriz, xPrevia[0], xPrevia[2]);
            xPrevia[1] = xActual[1];

            xActual[2] = calcularX3(matriz, xPrevia[0], xPrevia[1]);
            xPrevia[2] = xActual[2];
            
            info(iteracion++, xPrevia, xActual);
            
            if (
                errorPorcentual(xPrevia[0], xActual[0]) <= errorBase &&
                errorPorcentual(xPrevia[1], xActual[1]) <= errorBase &&
                errorPorcentual(xPrevia[2], xActual[2]) <= errorBase
            ) break;
            
            if (iteracion >= 1000) {
                System.out.println("No es posible resolver ese sistema de ecuaciones lineales por este metodo.");
                return;
            }
        }
        
        xActual[0] = calcularX1(matriz, xPrevia[1], xPrevia[2]);
        xPrevia[0] = xActual[0];

        xActual[1] = calcularX2(matriz, xPrevia[0], xPrevia[2]);
        xPrevia[1] = xActual[1];

        xActual[2] = calcularX3(matriz, xPrevia[0], xPrevia[1]);
        xPrevia[2] = xActual[2];
        
        info(iteracion, xPrevia, xActual);
        
    }
    
    private static double calcularX1(double[][] matriz, double x2, double x3) {
        return (matriz[0][3] - (matriz[0][1] * x2) - (matriz[0][2] * x3)) / (matriz[0][0]);
    }
    
    private static double calcularX2(double[][] matriz, double x1, double x3) {
        return (matriz[1][3] - (matriz[1][0] * x1) - (matriz[1][2] * x3)) / (matriz[1][1]);
    }
    
    private static double calcularX3(double[][] matriz, double x1, double x2) {
        return (matriz[2][3] - (matriz[2][0] * x1) - (matriz[2][1] * x2)) / (matriz[2][2]);
    }
    
    private static double errorPorcentual(double x1, double x2) {
        return Math.abs((x2 - x1)/(x2)) * 100;
    }
    
    private static void info(int iteracion, double[] xPrevia, double[] xActual) {
        System.out.println("Iteracion: " + iteracion + '\n');
        
        System.out.println("x1 = " + xActual[0]);
        System.out.println("x2 = " + xActual[1]);
        System.out.println("x3 = " + xActual[2]);

        System.out.println("");
        
        //System.out.println("e1 = " + errorPorcentual(xPrevia[0], xActual[0]));
        //System.out.println("e2 = " + errorPorcentual(xPrevia[1], xActual[1]));
        //System.out.println("e3 = " + errorPorcentual(xPrevia[2], xActual[2]));
        
        System.out.println("------------------------");
    }
    
    public static void main(String[] args) {
        double[][] matriz = {
            {17, -2, -3, 500},
            {-5, 21, -2, 200},
            {-5, -5, 22,  30},
        };
        
        Seidel.resolver(matriz, 1);
    }
    
}
