package Diferenciales;

public class PuntoPendiente {
    
    public static void resolver(double x, double y, double m) {
        System.out.println("Forma ordinaria: " + ordinaria(x, y, m));
        System.out.println("Forma general: " + general(x, y, m));
    }
    
    private static String ordinaria(double x, double y, double m) {
        String op1 = m + "x";
        double op2 = (m * -x) + y;
        String op3 = String.format("y = %s %s %s", op1, (op2 > 0)? "+" : "-", Math.abs(op2));
        
        return op3;
    }
    
    private static String general(double x, double y, double m) {
        String op1 = m + "x";
        double op2 = (m * -x) + y;
        String op3 = String.format("%s - y %s %s = 0", op1, (op2 > 0)? "+" : "-", Math.abs(op2));
        
        return op3;
    }
    
    public static void main(String[] args) {
        PuntoPendiente.resolver(2, 4, -5);
    }
    
}
