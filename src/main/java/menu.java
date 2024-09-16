import java.util.Scanner;
import java.util.InputMismatchException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class menu {
    public static void main(String[] args) {
        ejecutarMenu();
    }
    public static void mostrarMenu() {
        System.out.println("---------------------------------");
        System.out.println("Menu de la calculadora cientifica:");
        System.out.println("1. Operaciones aritméticas");
        System.out.println("2. Ecuación cuadrática");
        System.out.println("3. Figuras geométricas");
        System.out.println("4. Sistema ecuaciones lineales");
        System.out.println("5. Ecuación de la recta");
        System.out.println("6. Salir");
        System.out.println("---------------------------------");
        System.out.print("Seleccione una opción: ");
    }

    public static double cualEsMayor(double n1, double n2) {
        return Math.max(n1, n2);
    }

    public static double cualEsMenor(double n1, double n2){
        return Math.min(n1 , n2);
    }

    public static double potenciaNumero(double n1, double n2){
        return Math.pow(n1,n2);
    }

    public static double calcularPorcentaje(double numero, double porcentaje) {
        return (porcentaje / 100) * numero;
    }

    public static String ecuacionDeRecta(float x1, float y1, float x2, float y2) {
        try {
            if (x1 == x2) {
                throw new ArithmeticException("¡¡ERROR DE CÁLCULO!!: El denominador no puede ser cero");
            }
            float pendiente = ((y2 - y1) / (x2 - x1));
            float términoN = y1 - (pendiente * x1);
            return "y = " + pendiente + "x + " + términoN;
        } catch (ArithmeticException error) {
            return error.getMessage();
        }
    }

    public double[] despejarX(double[] coeficientes) {
        if (coeficientes[0] == 0) {
            throw new ArithmeticException("El coeficiente principal no puede ser cero.");
        }
        try {
            coeficientes[2] = coeficientes[2] / coeficientes[0];
            coeficientes[1] = (coeficientes[1] / coeficientes[0]) * -1;
            coeficientes[0] = 1;
        }
        catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }

        return coeficientes;
    }

    public static double[] resolver(double[] coeficientes){
        double y = (coeficientes[5]-((coeficientes[3]*coeficientes[2])/coeficientes[0]))/(coeficientes[4]-((coeficientes[3]*coeficientes[1])/coeficientes[0]));
        BigDecimal Y = new BigDecimal(y);
        Y = Y.setScale(2, RoundingMode.HALF_UP);
        double x = -y*(coeficientes[1]/coeficientes[0])+(coeficientes[2]/coeficientes[0]);
        BigDecimal X = new BigDecimal(x);
        X = X.setScale(2, RoundingMode.HALF_UP);
        x = X.doubleValue();
        y = Y.doubleValue();
        double[] incognitas = new double[2];
        incognitas[0] = x;
        incognitas[1] = y;
        return  incognitas;
    }
    public static void mostarResultadosIncognitas(double[] incognitas){
        String x = Double.toString(incognitas[0]);
        String y = Double.toString(incognitas[1]);

        System.out.println("La variable x es: "+x);
        System.out.println("La variable y es: "+y);
    }

    public static double[] solucionEcuacionCuadratica(double a, double b, double c) {
        try {
            double discriminante = Math.pow(b, 2) - 4 * a * c;
            System.out.println("---------------------------------");
            if (discriminante < 0) {
                System.out.println("No tiene soluciones reales");
                System.out.println("---------------------------------");
                return new double[0];
            } else {
                try {
                    double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                    double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                    double[] soluciones = { x1, x2 };
                    return soluciones;
                } catch (ArithmeticException e) {
                    System.err.println("Error: División por cero");
                    return new double[0];
                }
            }
        } catch (Exception e) {
            System.err.println("Error al calcular las soluciones: " + e.getMessage());
            return new double[0];
        }
    }

    public static void imprimirSoluciones(double[] soluciones) {
        try {
            if (soluciones.length == 0) {
                return;
            }
            System.out.println("Solución 1: " + soluciones[0]);
            System.out.println("Solución 2: " + soluciones[1]);
            System.out.println("---------------------------------");
        } catch (Exception e) {
            System.err.println("Error al imprimir las soluciones: " + e.getMessage());
        }
    }

    public static void ejecutarMenu() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 5);
    }

    public static String leerString() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("Ingrese un string: ");
            input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }
        return input;
    }

    public static String calcularFigurasGeometricas(String figura, double... dimensiones) {
        try {
            switch (figura.toLowerCase()) {
                case "cuadrado":
                    double lado = dimensiones[0];
                    double perimetroCuadrado = 4 * lado;
                    double areaCuadrado = lado * lado;
                    return String.format(Locale.US, "Cuadrado - Perímetro: %.2f, Área: %.2f", perimetroCuadrado, areaCuadrado);
                case "rectángulo":
                    double largo = dimensiones[0];
                    double ancho = dimensiones[1];
                    double perimetroRectangulo = 2 * (largo + ancho);
                    double areaRectangulo = largo * ancho;
                    return String.format(Locale.US, "Rectángulo - Perímetro: %.2f, Área: %.2f", perimetroRectangulo, areaRectangulo);
                case "círculo":
                    double radio = dimensiones[0];
                    double perimetroCirculo = 2 * Math.PI * radio;
                    double areaCirculo = Math.PI * Math.pow(radio, 2);
                    return String.format(Locale.US, "Círculo - Perímetro: %.2f, Área: %.2f", perimetroCirculo, areaCirculo);
                case "esfera":
                    double radioEsfera = dimensiones[0];
                    double areaEsfera = 4 * Math.PI * Math.pow(radioEsfera, 2);
                    double volumenEsfera = (4.0 / 3.0) * Math.PI * Math.pow(radioEsfera, 3);
                    return String.format(Locale.US, "Esfera - Área: %.2f, Volumen: %.2f", areaEsfera, volumenEsfera);
                case "cubo":
                    double ladoCubo = dimensiones[0];
                    double areaCubo = 6 * Math.pow(ladoCubo, 2);
                    double volumenCubo = Math.pow(ladoCubo, 3);
                    return String.format(Locale.US, "Cubo - Área: %.2f, Volumen: %.2f", areaCubo, volumenCubo);
                case "cono":
                    double radioCono = dimensiones[0];
                    double alturaCono = dimensiones[1];
                    double generatrizCono = Math.sqrt(Math.pow(radioCono, 2) + Math.pow(alturaCono, 2));
                    double areaCono = Math.PI * radioCono * (radioCono + generatrizCono);
                    double volumenCono = (1.0 / 3.0) * Math.PI * Math.pow(radioCono, 2) * alturaCono;
                    return String.format(Locale.US, "Cono - Área: %.2f, Volumen: %.2f", areaCono, volumenCono);
                default:
                    return "Figura no reconocida.";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Error: Número incorrecto de dimensiones proporcionadas.";
        } catch (Exception e) {
            return "Error inesperado: " + e.getMessage();
        }
    }

    public static int leerOpcion() {
        int opcion;
        while (true) {
            try {
                Scanner scanner = crearScanner();
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion >= 1 && opcion <= 6) {
                        break;
                    } else {
                        System.out.print("Opción inválida. Intente nuevamente: ");
                    }
                } else {
                    System.out.print("Entrada no válida. Ingrese un número: ");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("Error al leer la opción: " + e.getMessage());
            }
        }
        return opcion;
    }
    public static double leerDouble() {
        Scanner scanner = new Scanner(System.in);
        double input;
        while (true) {
            System.out.print("Ingrese un número double: ");
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                break;
            } else {
                System.out.println("Entrada no válida. Intente nuevamente.");
                scanner.next(); // Clear the invalid input
            }
        }
        return input;
    }
    public static float leerFloat() {
        Scanner scanner = new Scanner(System.in);
        float input;
        while (true) {
            System.out.print("Ingrese un número float: ");
            if (scanner.hasNextFloat()) {
                input = scanner.nextFloat();
                break;
            } else {
                System.out.println("Entrada no válida. Intente nuevamente.");
                scanner.next(); // Clear the invalid input
            }
        }
        return input;
    }

    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }
    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1://Operaciones aritmeticas
                System.out.println("Ingrese dos números: ");
                double n1 = leerDouble();
                double n2 = leerDouble();
                System.out.println("El número mayor es: " + cualEsMayor(n1, n2));
                System.out.println("El número menor es: " + cualEsMenor(n1, n2));
                System.out.println("La potencia de " + n1 + " elevado a " + n2 + " es: " + potenciaNumero(n1, n2));
                System.out.println("El " + n2 + "% de " + n1 + " es: " + calcularPorcentaje(n1, n2));
                break;
            case 2: //variables de la ecuacion cuadratica
                System.out.println("Ingrese los coeficientes de la ecuación cuadrática (ax^2 + bx + c = 0): ");
                double a = leerDouble();
                double b = leerDouble();
                double c = leerDouble();
                double[] soluciones = solucionEcuacionCuadratica(a, b, c);
                imprimirSoluciones(soluciones);
                break;
            case 3://Figuras geometricas
                System.out.println("Ingrese la figura geométrica (cuadrado, rectángulo, círculo, esfera, cubo, cono): ");
                System.out.println("Ingrese las dimensiones de la figura: ");
                    System.out.println(calcularFigurasGeometricas(leerString(), leerDouble(), leerDouble()));
                break;
            case 4://Sistema ecuaciones lineales
                double[] coeficientes = new double[6];
                System.out.println("Ingrese los coeficientes de la primera ecuación (ax + by = c): ");
                coeficientes[0] = leerDouble();
                coeficientes[1] = leerDouble();
                coeficientes[2] = leerDouble();
                System.out.println("Ingrese los coeficientes de la segunda ecuación (dx + ey = f): ");
                coeficientes[3] = leerDouble();
                coeficientes[4] = leerDouble();
                coeficientes[5] = leerDouble();
                double[] incognitas = resolver(coeficientes);
                mostarResultadosIncognitas(incognitas);
                break;
            case 5://Ecuación de la recta
                System.out.println("Ingrese las coordenadas de dos puntos (x1, y1, x2, y2): ");
                float x1 = leerFloat();
                float y1 = leerFloat();
                float x2 = leerFloat();
                float y2 = leerFloat();
                System.out.println(ecuacionDeRecta(x1, y1, x2, y2));
                break;
            case 6://salir
                salir();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void salir() {
        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        System.exit(0);
    }
}