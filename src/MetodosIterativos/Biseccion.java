package MetodosIterativos;

public class Biseccion {
    
    private Biseccion() {}

    public static void resolver(double[] x, double errorBase) {
        int iteraciones = 1;
        double xi;

        System.out.println("--------------------------------------------------------");
        while(errorPorcentual(x) >= errorBase) {
            info(iteraciones++, x);

            xi = puntoMedio(x);
            if (Funcion.f9(xi) < 0)
                x[0] = xi;
            else
                x[1] = xi;
        }
        info(iteraciones++, x);
    }

    private static double puntoMedio(double[] x) {
        return (x[0] + x[1]) / 2;
    }

    private static double errorPorcentual(double[] x) {
        return Math.abs(((x[0] - x[1]) / (x[0])) * (100));
    }

    private static void info(int iteracion, double[] x) {
        System.out.println("Iteracion: " + iteracion);
        System.out.println("x1 = " + x[0]);
        System.out.println("x2 = " + x[1]);
        System.out.println("f(x1) = " + Funcion.f9(x[0]));
        System.out.println("f(x2) = " + Funcion.f9(x[1]));
        System.out.println("Punto medio = " + puntoMedio(x));
        System.out.println("Error porcentual = " + errorPorcentual(x));
        System.out.println("--------------------------------------------------------");
    }
    
    public static void main(String[] args) {
        Biseccion.resolver(new double[] {5, 10}, 1);
    }
    
}
