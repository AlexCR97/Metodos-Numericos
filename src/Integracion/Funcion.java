package Integracion;

public class Funcion {
    
    public static double f1(double x) {
        return Math.pow(x, 2) - 3;
    }
    
    public static double f2(double x) {
        return Math.pow(x, 3) - (2 * x);
    }
    
    public static double f3(double x) {
        return 1 / x;
    }
    
    public static double f4(double x) {
        return Math.pow(x, -x) * Math.cos(x);
    }
    
    public static double f5(double x) {
        return Math.pow(x, -x);
    }
    
    public static double f6(double x) {
        return 1 / (x + 2);
    }
    
    public static double f7(double x) {
        return Math.pow(Math.E, Math.pow(x, 2));
    }
    
    public static double f8(double x) {
        return Math.pow(Math.E, x) / x;
    }
    
    public static double f9(double x) {
        return Math.pow(Math.E, x) * Math.log(x);
    }
    
    public static double f10(double x) {
        return 1 / ((3 * x) + 2);
    }
    
}
