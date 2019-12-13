package Interpolacion_Ajuste;

public class Lagrange {
    
    private Lagrange() {}
    
    public static void resolver(double[] x, double[] y, double xi) {
        int n = x.length;
        double[] l = calcularLi(x, y);
        double[] li = new double[n];
        
        for (int i = 0; i < n; i++) {
            double c = 1;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                c = (xi - x[j]) * c;
            }
            
            li[i] = c * l[i];
        }
        System.out.println("");
        
        double yi = 0;
        for (int i = 0; i < n; i++)
            yi += li[i];
        
        System.out.println(yi);
    }
    
    private static double[] calcularLi(double[] x, double[] y) {
        int n = x.length;
        double[] l = new double[n];
        
        for (int i = 0; i < n; i++) {
            double c = 1;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                c = (x[i] - x[j]) * c;
            }
            
            l[i] = y[i] / c;
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        Lagrange.resolver(
            new double[] {1, 3},
            new double[] {0, 4},
            2
        );
    }
    
}
