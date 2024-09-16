import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class menuTest {
    @Test
    public void testPendientePositiva() {
        String resultado = menu.ecuacionDeRecta(1, 2, 3, 4);
        assertEquals("y = 1.0x + 1.0", resultado);
    }

    @Test
    public void testPendienteNegativa() {
        String resultado = menu.ecuacionDeRecta(1, 5, 4, 2);
        assertEquals("y = -1.0x + 6.0", resultado);
    }

    @Test
    public void testRectaHorizontal() {
        String resultado = menu.ecuacionDeRecta(1, 2, 3, 2);
        assertEquals("y = 0.0x + 2.0", resultado);
    }

    @Test
    public void testRectaVertical() {
        String resultado = menu.ecuacionDeRecta(2, 3, 2, 5);
        assertEquals("¡¡ERROR DE CÁLCULO!!: El denominador no puede ser cero", resultado);
    }

    @Test
    void testCalcularPorcentaje() {
        assertEquals(5, menu.calcularPorcentaje(10, 50));
        assertEquals(50, menu.calcularPorcentaje(100, 50));
        assertEquals(100, menu.calcularPorcentaje(200, 50));
    }

    @Test
    void testCualEsMayor() {
        assertEquals(50, menu.cualEsMayor(10, 50));
        assertEquals(50, menu.cualEsMayor(50, 50));
        assertEquals(10, menu.cualEsMayor(10, -6));
    }

    @Test
    void testCualEsMenor() {
        assertEquals(10, menu.cualEsMenor(10, 50));
        assertEquals(50, menu.cualEsMenor(50, 50));
        assertEquals(6, menu.cualEsMenor(10, 6));
    }

    @Test
    void testMain() {
        // Test main method if needed
    }

    @Test
    void testPotenciaNumero() {
        assertEquals(100, menu.potenciaNumero(10, 2));
        assertEquals(4, menu.potenciaNumero(2, 2));
        assertEquals(64, menu.potenciaNumero(8, 2));
        assertEquals(1, menu.potenciaNumero(10, 0));
    }

    @Test
    public void testDespejarX_Caso1() {
        menu sistema = new menu();
        double[] coeficientes = {2, 4, 6};
        double[] resultadoEsperado = {1, -2, 3};
        assertArrayEquals(resultadoEsperado, sistema.despejarX(coeficientes));
        System.out.println("La prueba se realizo correctamente...");
    }

    @Test
    public void testDespejarXThrowsArithmeticException() {
        double[] coeficientes = {0, 2, 3};
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            new menu().despejarX(coeficientes);
        });
        assertEquals("El coeficiente principal no puede ser cero.", exception.getMessage());
    }

    @Test
    public void testResolver_Caso1() {
        menu sistema = new menu();
        double[] coeficientes = {2, 4, 6, 1, 5, 10};
        double[] resultadoEsperado = {-1.67, 2.33};
        assertArrayEquals(resultadoEsperado, sistema.resolver(coeficientes));
    }

    @Test
    public void testResolver_Caso2() {
        menu sistema = new menu();
        double[] coeficientes = {3, 6, 9, 2, 7, 14};
        double[] resultadoEsperado = {-2.33, 2.67};
        assertArrayEquals(resultadoEsperado, sistema.resolver(coeficientes));
    }

    @Test
    public void solucionEcuacionCuadratica_PositiveDiscriminant() {
        double[] soluciones = menu.solucionEcuacionCuadratica(1, -5, 6);
        assertEquals(2, soluciones.length);
        assertEquals(3.0, soluciones[0], 0.0001);
        assertEquals(2.0, soluciones[1], 0.0001);
    }

    @Test
    public void solucionEcuacionCuadratica_NegativeDiscriminant() {
        double[] soluciones = menu.solucionEcuacionCuadratica(1, 2, 5);
        assertEquals(0, soluciones.length);
    }

    @Test
    public void testCalcularFigurasGeometricas_Cuadrado() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu.calcularFigurasGeometricas("cuadrado", 4);
        assertEquals("Cuadrado - Perímetro: 16.00, Área: 16.00\n", outContent.toString());
    }

    @Test
    public void testCalcularFigurasGeometricas_Rectangulo() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu.calcularFigurasGeometricas("rectángulo", 4, 2);
        assertEquals("Rectángulo - Perímetro: 12.00, Área: 8.00\n", outContent.toString());
    }

    @Test
    public void testCalcularFigurasGeometricas_Circulo() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu.calcularFigurasGeometricas("círculo", 3);
        assertEquals("Círculo - Perímetro: 18.85, Área: 28.27\n", outContent.toString());
    }

    @Test
    public void testCalcularFigurasGeometricas_Esfera() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu.calcularFigurasGeometricas("esfera", 3);
        assertEquals("Esfera - Área: 113.10, Volumen: 113.10\n", outContent.toString());
    }

    @Test
    public void testCalcularFigurasGeometricas_Cubo() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu.calcularFigurasGeometricas("cubo", 3);
        assertEquals("Cubo - Área: 54.00, Volumen: 27.00\n", outContent.toString());
    }

    @Test
    public void testCalcularFigurasGeometricas_Cono() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu.calcularFigurasGeometricas("cono", 3, 4);
        assertEquals("Cono - Área: 75.40, Volumen: 37.70\n", outContent.toString());
    }

    @Test
    public void testCalcularFigurasGeometricas_FiguraNoReconocida() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu.calcularFigurasGeometricas("triángulo", 3, 4);
        assertEquals("Figura no reconocida.\n", outContent.toString());
    }
}