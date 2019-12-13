package Interpolacion_Ajuste;

public class Spline {
    
    private Spline() {}
    
    public static void resolver(double[] x, double[] y) {
        
        for (int i = 0; i < x.length - 1; i++) {
            System.out.println(String.format("s%d(x) = %s", i, calcularS(y[i + 1], y[i], x[i + 1], x[i])));
            System.out.println(calcularIntervalo(x[i], x[i + 1]));
            System.out.println("----------------------");
        }
        
    }
    
    private static String calcularS(double yj, double yi, double xj, double xi) {
        double c1 = yi;
        double c2 = (yj - yi) / (xj - xi);
        double c3 = c2 * xi;
        
        double c4 = c1 - c3;
        
        return c2 + "x + " + c4;
    }
    
    private static String calcularIntervalo(double xi, double xj) {
        return "x E [" + xi + ", " + xj + "]";
    }
    
    public static void main(String[] args) {
        Spline.resolver(
                new double[] {12, 7, 0},
                new double[] {7, -12, 0}
        );
    }
    
}
