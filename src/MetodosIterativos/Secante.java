package MetodosIterativos;

public class Secante {
    
    public Secante() {}
    
    public static void resolver(double[] x, double errorBase) {
        int iteraciones = 1;
        double xn;

        while (errorPorcentual(x) >= errorBase) {
            info(iteraciones++, x);
            xn = calcularX(x);
            x[0] = x[1];
            x[1] = xn;
        }
        info(iteraciones++, x);
    }

    private static double calcularX(double[] x) {
        return x[1] - ((Funcion.f9(x[1]) * (x[0] - x[1]))/(Funcion.f9(x[0]) - Funcion.f9(x[1])));
    }

    private static double errorPorcentual(double[] x) {
        return Math.abs( ((x[1] - x[0]) / (x[1])) * (100) );
    }

    private static void info(int iteracion, double[] x) {
        System.out.println("Iteracion: " + iteracion);
        System.out.println("x1 = " + x[0]);
        System.out.println("x2 = " + x[1]);
        System.out.println("x3 = " + calcularX(x));
        System.out.println("f(x1) = " + Funcion.f9(x[0]));
        System.out.println("f(x2) = " + Funcion.f9(x[1]));
        System.out.println("f(x3) = " + Funcion.f9(calcularX(x)));
        System.out.println("Error porcentual = " + errorPorcentual(x));
        System.out.println("--------------------------------------------------------");
    }
    
    public static void main(String[] args) {
        Secante.resolver(new double[] {5, 10}, 1);
    }
    
}
