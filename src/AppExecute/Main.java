package AppExecute;

import Diferenciales.PuntoPendiente;
import GaussJordan.GaussJordan;
import Integracion.Simpson_1_3;
import Integracion.Simpson_3_8;
import Integracion.Trapecio;
import Interpolacion_Ajuste.Lagrange;
import Interpolacion_Ajuste.MinimosCuadrados;
import Interpolacion_Ajuste.Newton;
import Interpolacion_Ajuste.Spline;
import MetodosIterativos.Biseccion;
import MetodosIterativos.InterpolacionCuadratica;
import MetodosIterativos.InterpolacionLineal;
import MetodosIterativos.Jacobi;
import MetodosIterativos.Secante;
import MetodosIterativos.Seidel;

import java.util.Scanner;

public class Main {
    
    private final static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        boolean loopSection = true;
        boolean loopMethod;
        int optionSection;
        int optionMethod;
        
        while (loopSection) {
            
            try {
                
                System.out.println("-----------------------------------------");
                
                System.out.println("Elige una opcion:\n"
                        + "1. Gauss Jordan\n"
                        + "2. Iterativos\n"
                        + "3. Integracion\n"
                        + "4. Interpolacion y Ajuste\n"
                        + "5. Diferenciales\n"
                        + "6. SALIR\n");
                optionSection = scanner.nextInt();
                loopMethod = true;
                
                switch (optionSection) {
                    
                    case 1: {                        
                        while (loopMethod) {

                            System.out.println("Elige un metodo:\n"
                                    + "1. Gauss Jordan\n"
                                    + "2. ATRAS");
                            optionMethod = scanner.nextInt();

                            switch (optionMethod) {
                                case 1: Main.metodoGaussJordan(); break;
                                case 2: loopMethod = false; break;
                            } // optionMethod
                            
                        } // loopMethod
                        break;
                    } // Gauss Jordan
                    
                    case 2: {
                        while (loopMethod) {

                        System.out.println("Elige un metodo:\n"
                                + "1. Biseccion\n"
                                + "2. Secante\n"
                                + "3. Interpolacion Lineal\n"
                                + "4. Interpolacion Cuadratica\n"
                                + "5. Jacobi\n"
                                + "6. Gauss Seidel\n"
                                + "7. ATRAS");
                        optionMethod = scanner.nextInt();
                        
                        switch (optionMethod) {
                            
                            case 1: Main.metodoBiseccion(); break;
                            case 2: Main.metodoSecante(); break;
                            case 3: Main.metodoInterpolacionLineal(); break;
                            case 4: Main.metodoInterpolacionCuadratica(); break;
                            case 5: Main.metodoJacobi(); break;
                            case 6: Main.metodoSeidel(); break;
                            case 7: loopMethod = false; break;
                        } // optionMethod
                        
                        } // loopMethod
                        break;
                    } // Iterativos
                    
                    case 3: {
                        while (loopMethod) {
                        
                        System.out.println("Elige un metodo:\n"
                                + "1. Trapecio\n"
                                + "2. Simpson 1/3\n"
                                + "3. Simpson 3/8\n"
                                + "4. ATRAS");
                        optionMethod = scanner.nextInt();
                        
                        switch (optionMethod) {
                            
                            case 1: metodoTrapecio(); break;
                            case 2: metodoSimpson13(); break;
                            case 3: metodoSimpson38(); break;
                            case 4: loopMethod = false; break;
                            
                        } // optionMethod
                        
                        } // loopMethod
                        break;
                    } // Integracion
                    
                    case 4: {
                        while (loopMethod) {

                        System.out.println("Elige un metodo:\n"
                                + "1. Interpolacion de Newton\n"
                                + "2. Interpolacion de Lagrange\n"
                                + "3. Ajuste de Minimos Cuadrados\n"
                                + "4. Ajuste de Spline\n"
                                + "5. ATRAS");
                        optionMethod = scanner.nextInt();
                        
                        switch (optionMethod) {
                            
                            case 1: metodoNewton(); break;
                            case 2: metodoLagrange(); break;
                            case 3: metodoMinimosCuadrados(); break;
                            case 4: metodoSpline(); break;
                            case 5: loopMethod = false; break;
                            
                        } // optionMethod
                        
                        } // loopMethod
                        break;
                    } // Interpolacion y Ajuste
                    
                    case 5: {
                        while (loopMethod) {

                        System.out.println("Elige un metodo:\n"
                                + "1. Punto pendiente\n"
                                + "2. ATRAS");
                        optionMethod = scanner.nextInt();
                        
                        switch (optionMethod) {
                            case 1: metodoPuntoPendiente(); break;
                            case 2: loopMethod = false; break;
                        } // optionMethod
                        
                        } // loopMethod
                        break;
                    } // Diferenciales
                    
                    case 6: loopSection = false; break;
                    
                } // optionSection
                
            } catch(Exception ex) {
                System.out.println("Ingrese una opcion valida.");
                scanner.nextLine();
            }
            
        }
        
    }
    
    private static void metodoGaussJordan() {
        System.out.println("Este metodo se utiliza para resolver un sistema de "
                + "ecuaciones lineales mediante una matriz\n");
                                
        double[][] matriz = Main.ingresarMatriz();
        GaussJordan.resolver(matriz, matriz.length);
    }
    
    private static void metodoBiseccion() {
        System.out.println("Este metodo se utiliza para aproximar un error porcentual "
                + "mediante dos puntos dados.");
                                
        double[] datos = Main.ingresarPuntosYError();
        Biseccion.resolver(new double[] {datos[0], datos[1]}, datos[2]);
    }
    
    private static void metodoSecante() {
        System.out.println("Este metodo se utiliza para aproximar un error porcentual "
                + "mediante dos puntos dados.");
                                
        double[] datos = Main.ingresarPuntosYError();
        Secante.resolver(new double[] {datos[0], datos[1]}, datos[2]);
    }
    
    private static void metodoInterpolacionLineal() {
        System.out.println("Este metodo se utiliza para interpolar un conjunto de puntos\n"
                + "dada una tabla de puntos (xi, yi).");
        
        System.out.println("Ingresa el numero de datos:");
        System.out.print("n = "); int n = scanner.nextInt();
        
        System.out.println("Ingresa los puntos (xi, yi).");
        System.out.println("(ingresa un cero cuando no se conozca el valor de yi).");
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println(String.format("(x%d, y%d) = ", i + 1, i + 1));
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }
        
        InterpolacionLineal.resolver(x, y);
    }
    
    private static void metodoInterpolacionCuadratica() {
        System.out.println("Este metodo se utiliza para interpolar un punto dada una tabla\n"
                + "puntos (xi, yi). La diferencia con el metodo de interpolacion lineal, es que\n"
                + "este se utiliza cuando se conocen tres puntos y queremos encontrar el punto\n"
                + "desconocido entre los tres conocidos.");
        
        System.out.println("Ingresa los puntos (x1, y1), (x2, y2), (x3, y3))");
        double[] x = new double[3];
        double[] y = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("(x%d, y%d) = ", i + 1, i + 1));
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }
        
        System.out.println("Ingresa el punto desconocido (xi, ?)");
        System.out.print("xi = ");
        double xi = scanner.nextDouble();
        
        InterpolacionCuadratica.resolver(x, y, xi);
    }
    
    private static void metodoJacobi() {
        System.out.println("Este metodo se utiliza para resolver un sistema de ecuaciones lineales\n"
                + "y aproximar un error porcentual.");
        
        System.out.println("NOTA: Se tiene que ingresar una matriz de tres variables, es decir, una\n"
                + "matriz de 3 filas 4 columnas");
        
        double[][] matriz = ingresarMatriz();
        
        System.out.println("Ingresa el error porcentual (e).");
        System.out.print("e = "); double e = scanner.nextDouble();
        
        Jacobi.resolver(matriz, e);
    }
    
    private static void metodoSeidel() {
        System.out.println("Este metodo se utiliza para resolver un sistema de ecuaciones lineales\n"
                + "y aproximar un error porcentual, pero utilizando un algoritmo un poco diferente\n"
                + "al de Jacobi.");
        
        System.out.println("NOTA: Se tiene que ingresar una matriz de tres variables, es decir, una\n"
                + "matriz de 3 filas 4 columnas");
        
        double[][] matriz = ingresarMatriz();
        
        System.out.println("Ingresa el error porcentual (e).");
        System.out.print("e = "); double e = scanner.nextDouble();
        
        Seidel.resolver(matriz, e);
    }
    
    private static void metodoTrapecio() {
        System.out.println("Este metodo se utiliza para resolver una integral definida dada\n"
                + "una cantidad de intervalos.");
        
        System.out.println("Ingresa el intervalo menor (a)");
        System.out.print("a = "); double a = scanner.nextDouble();
        
        System.out.println("Ingresa el intervalo mayor (b)");
        System.out.print("b = "); double b = scanner.nextDouble();
        
        System.out.println("Ingresa la cantidad de intervalos (n)");
        System.out.print("n = "); int n = scanner.nextInt();
        
        Trapecio.resolver(a, b, n);
    }
    
    private static void metodoSimpson13() {
        System.out.println("Este metodo se utiliza para resolver una integral definida dada\n"
                + "una cantidad de intervalos.");
        
        System.out.println("Ingresa el intervalo menor (a)");
        System.out.print("a = "); double a = scanner.nextDouble();
        
        System.out.println("Ingresa el intervalo mayor (b)");
        System.out.print("b = "); double b = scanner.nextDouble();
        
        System.out.println("Ingresa la cantidad de intervalos (n)");
        System.out.print("n = "); int n = scanner.nextInt();
        
        Simpson_1_3.resolver(a, b, n);
    }
    
    private static void metodoSimpson38() {
        System.out.println("Este metodo se utiliza para resolver una integral definida dada\n"
                + "una cantidad de intervalos.");
        
        System.out.println("Ingresa el intervalo menor (a)");
        System.out.print("a = "); double a = scanner.nextDouble();
        
        System.out.println("Ingresa el intervalo mayor (b)");
        System.out.print("b = "); double b = scanner.nextDouble();
        
        System.out.println("Ingresa la cantidad de intervalos (n)");
        System.out.print("n = "); int n = scanner.nextInt();
        
        Simpson_3_8.resolver(a, b, n);
    }
    
    private static void metodoNewton() {
        System.out.println("Este metodo se utiliza para interpolar un punto desconocido"
                + "dado un punto (x, y).");
        
        System.out.println("Ingresa la cantidad de puntos (n)");
        System.out.print("n = "); int n = scanner.nextInt();
        
        double[] x = new double[n];
        double[] y = new double[n];
        
        System.out.println("Ingresa el conjunto de puntos (xi, yi)");
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("(x%d, y%d) = ", i, i));
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }
        
        System.out.println("Ingresa el punto desconocido (xi, ?)");
        System.out.print("xi = ");
        double xi = scanner.nextDouble();
        
        Newton.resolver(x, y, xi);
    }
    
    private static void metodoLagrange() {
        System.out.println("Este metodo se utiliza para interpolar un punto desconocido"
                + "dado un punto (x, y).");
        
        System.out.println("Ingresa la cantidad de puntos (n)");
        System.out.print("n = "); int n = scanner.nextInt();
        
        double[] x = new double[n];
        double[] y = new double[n];
        
        System.out.println("Ingresa el conjunto de puntos (xi, yi)");
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("(x%d, y%d) = ", i, i));
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }
        
        System.out.println("Ingresa el punto desconocido (xi, ?)");
        System.out.print("xi = ");
        double xi = scanner.nextDouble();
        
        Lagrange.resolver(x, y, xi);
    }
    
    private static void metodoMinimosCuadrados() {
        System.out.println("Este metodo se utiliza para encontrar la pendiente de\n"
                + "una funcion dado un conjunto de puntos");
        
        System.out.println("Ingresa el numero de puntos (n)");
        System.out.print("n = "); int n = scanner.nextInt();
        
        double[] x = new double[n];
        double[] y = new double[n];
        
        System.out.println("Ingresa el conjunto de puntos (xi, yi)");
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("(x%d, y%d) = ", i, i));
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }
        
        MinimosCuadrados.resolver(x, y);
    }
    
    private static void metodoSpline() {
        System.out.println("Este metodo se utiliza para encontrar la funcion de cada\n"
                + "punto dado");
        
        System.out.println("Ingresa el numero de puntos (n)");
        System.out.print("n = "); int n = scanner.nextInt();
        
        double[] x = new double[n];
        double[] y = new double[n];
        
        System.out.println("Ingresa el conjunto de puntos (xi, yi)");
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("(x%d, y%d) = ", i, i));
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }
        
        Spline.resolver(x, y);
    }
    
    private static void metodoPuntoPendiente() {
        System.out.println("Este metodo se utiliza para encontrar la funcion general\n"
                + "y ordinaria dado un punto (x, y) y una pendiente (m)");
        
        System.out.println("Ingresa x");
        System.out.print("x = "); double x = scanner.nextDouble();
        
        System.out.println("Ingresa y");
        System.out.print("y = "); double y = scanner.nextDouble();
        
        System.out.println("Ingresa m");
        System.out.print("m = "); double m = scanner.nextDouble();
        
        PuntoPendiente.resolver(x, y, m);
    }
    
    private static double[][] ingresarMatriz() {
        System.out.println("Ingresa el tamano de la matriz (n, m): ");
        System.out.print("n = "); int n = scanner.nextInt();
        System.out.print("m = "); int m = scanner.nextInt();
        
        double[][] matriz = new double[n][m];
        
        System.out.println("Ingresa la matriz: ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matriz[i][j] = scanner.nextInt();
        
        return matriz;
    }
    
    private static double[] ingresarPuntosYError() {
        System.out.println("Ingresa el punto (x, y) y el error base (e):");
        System.out.print("(x, y) = ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        System.out.print("e = "); double e = scanner.nextDouble();
        
        return new double[] {x, y, e};
    }
    
}
