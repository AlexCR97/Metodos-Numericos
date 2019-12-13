package Interpolacion_Ajuste;

public class MinimosCuadrados {
    
    private MinimosCuadrados() {}
    
    public static void resolver(final double[] x, final double[] y) {
        final int n = x.length;
        final double[] xy = new double[n];
        final double[] x2 = new double[n];
        
        double xSum = 0;
        double ySum = 0;
        double xySum = 0;
        double x2Sum = 0;
        
        double xAver;
        double yAver;
        
        double m;
        double b;
        double xResultado;
        
        for (int i = 0; i < n; i++) {
            xy[i] = x[i] * y[i];
            x2[i] = x[i] * x[i];
            
            // Sumatorias
            xSum += x[i];
            ySum += y[i];
            xySum += xy[i];
            x2Sum += x2[i];
        }
        
        xAver = xSum/n;
        yAver = ySum/n;
        
        m = calcularM(xySum, xSum, ySum, x2Sum, n);
        b = calcularB(yAver, m, xAver);
        xResultado = calcularX(m, b);
        
        System.out.println("m = " + m);
        System.out.println("b = " + b);
        System.out.println("x = " + xResultado);
    }
    
    private static double calcularM(double xySum, double xSum, double ySum, double x2Sum, int n) {
        return (xySum - ((xSum * ySum)/n) ) / (x2Sum - ((xSum * xSum)/n) );
    }
    
    private static double calcularB(double yAver, double m, double xAver) {
        return yAver - (m * xAver);
    }
    
    private static double calcularX(double m, double b) {
        return -b/m;
    }
    
    public static void main(String[] args) {
        MinimosCuadrados.resolver(
                new double[] {0, 1, 2, 3, 4, 5, 6, 7},
                new double[] {88.5, 91.5, 94.4, 96.7, 98.6, 100, 106.3, 106.3}
        );
    }
    
}
