package Interpolacion_Ajuste;

public class Newton {
    
    private Newton() {}
    
    public static void resolver(double[] x, double[] y, double xi) {
        int n = x.length;
        double[][] a = new double[n][n];
        
        for (int i = 0; i < n; i++)
            a[i][0] = y[i];
        
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1, k = 0; j < n; j++, k++)
                a[j][i + 1] = diferenciaDividida(x[k], x[j], a[j - 1][i], a[j][i]);
        
        double yi = 0;
        for (int i = 0, c = 1; i < n; i++, c = 1) {
            for (int j = 0; j < i; j++)
                c *= xi - x[j];
            yi += c * a[i][i];
        }
        
        System.out.println(yi);
    }
    
    private static double diferenciaDividida(double x0, double x1, double y0, double y1) {
        return (y1 - y0) / (x1 - x0);
    }
    
    public static void main(String[] args) {
        Newton.resolver(
                new double[] {1, 3, 5, 6},
                new double[] {2/3, 1, -1, 0},
                5
        );
    }
    
}
