package Integracion;

public class Simpson_1_3 {
    
    public static void resolver(double intervaloMenor, double intervaloMayor, int n) {
        double delta = (intervaloMayor - intervaloMenor) / n;
        double constante = (intervaloMayor - intervaloMenor) / (3 * n);
        double[] x = new double[n + 1];
        
        System.out.println("Delta: " + delta);
        System.out.println("Const: " + constante);
        
        for (int i = 0; i < x.length; i++, intervaloMenor += delta)
            /*/
                INSERTAR UNA FUNCION DE LA CLASE "Funcion"
            /*/
            x[i] = Funcion.f1(intervaloMenor);
        
        System.out.println("Resultado: " + serie(constante, x));
    }
    
    private static double serie(double constante, double[] x) {
        double suma = 0;
        
        for (int i = 0, k = 2; i < x.length; i++) {
            if (i == 0 || i == x.length - 1) {
                suma += x[i];
                continue;
            }
            
            suma += k * x[i];
            if (k == 2) k = 4;
            else k = 2;
        }
        return constante * suma;
    }
    
    public static void main(String[] args) {
        Simpson_1_3.resolver(0, 1, 4);
    }
    
}
