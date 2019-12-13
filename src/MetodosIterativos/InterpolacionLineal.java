package MetodosIterativos;

public class InterpolacionLineal {
    
    private InterpolacionLineal() {}
    
    public static void resolver(double[] x, double[] f) {
        int size = f.length;
        
        int[] indices = obtenerIndices(f);
        double f1 = f[indices[0]];
        double f2 = f[indices[1]];
        double x1 = x[indices[0]];
        double x2 = x[indices[1]];
        
        for (int i = 0; i < size; i++) {
            if (f[i] == 0)
                f[i] = interpolar(f1, f2, x1, x2, x[i]);
            info(x, f);
        }
    }
    
    private static int[] obtenerIndices(double[] f) {
        int[] indices = new int[2];
        
        for (int i = 0, j = 0; i < f.length; i++)
            if (f[i] != 0)
                indices[j++] = i;
        
        return indices;
    }
    
    private static double interpolar(double f1, double f2, double x1, double x2, double x) {
        return f1 + (((f2 - f1) / (x2 - x1)) * (x - x1));
    }
    
    private static void info(double[] x, double[] f) {
        for (int i = 0; i < x.length; i++)
            System.out.println(x[i] + " | " + f[i]);
        System.out.println("-------------------------------------------");
    }
    
    public static void main(String[] args) {
            double[] x = {10, 13, 16, 18, 20, 22};
            double[] f = {45,  0,  0,  0, 57,  0};
        
        InterpolacionLineal.resolver(x, f);
    }
    
}
