package MetodosIterativos;

public class InterpolacionCuadratica {
    
    private InterpolacionCuadratica() {}
    
    public static void resolver(double[] x, double[] f, double xi) {
        double fi = interpolar(f[0], f[1], f[2], x[0], x[1], x[2], xi);
        info(x, f, xi, fi);
    }
    
    private static double intervalo(double f1, double f2, double x1, double x2) {
        return (f2 - f1) / (x2 - x1);
    }
    
    private static double intervalo(double f1, double f2, double f3, double x1, double x2, double x3) {
        return (intervalo(f2, f3, x2, x3) - intervalo(f1, f2, x1, x2)) / (x3 - x1);
    }
    
    private static double interpolar(double f1, double f2, double f3, double x1, double x2, double x3, double x) {
        return (f1) + (intervalo(f1, f2, x1, x2) * (x - x1)) + (intervalo(f1, f2, f3, x1, x2, x3) * (x - x1) * (x - x2));
    }
    
    private static void info(double[] x, double[] f, double xi, double fi) {
        System.out.println("Dada la tabla: ");
        for (int i = 0; i < x.length; i++)
            System.out.println(x[i] + " | " + f[i]);
        System.out.println("El valor de fi para "+ xi +" es " + fi);
        System.out.println("------------------------------");
    }
    
    public static void main(String[] args) {
        
        double[] x = {2004, 2011, 2015};
        double[] f = {38, 43, 48};
        double xi = 2012;
        
        InterpolacionCuadratica.resolver(x, f, xi);
        
    }
    
}
