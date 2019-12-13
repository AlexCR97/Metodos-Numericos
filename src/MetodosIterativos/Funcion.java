package MetodosIterativos;

public class Funcion {
    
    public static double f1(double x) {
        return (Math.pow(Math.E, -(Math.abs(x)))) - (Math.log(Math.abs(x)));
    }

    public static double f2(double x) {
        return (Math.pow(x, 2)) - (Math.pow(Math.E, -x));
    }

    public static double f3(double x) {
        return (x * Math.pow(Math.E, x)) - (Math.PI);
    }

    public static double f4(double x) {
        return Math.pow(x, 10) - 1;
    }

    public static double f5(double x) {
        return Math.pow(x, 3) - x - 1;
    }

    public static double f6(double x) {
        return (-0.4 * Math.pow(x, 2)) + (2.2 * x) + 4.7;
    }

    public static double f7(double x) {
        return (0.65 * Math.pow(x, 5)) - (9 * Math.pow(x, 4)) + (45.4 * Math.pow(x, 3))
                - (88 * Math.pow(x, 2)) + (82.3 * x) - (26);
    }

    public static double f8(double x) {
        return Math.pow(x, 4) - (2 * Math.pow(x, 3)) - (4 * Math.pow(x, 2)) + (4 * x) + 4;
    }

    public static double f9(double x) {
        return Math.pow(x, 3) + x - 4;
    }

    public static double f10(double x) {
        return (x * x) + (10 * Math.cos(x));
    }

    public static double f11(double x) {
        return Math.pow(Math.E, -Math.pow(x, 2)) - x;
    }
    
}
