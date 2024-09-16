import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
        assertEquals( 5 , menu.calcularPorcentaje(10, 50));
        assertEquals( 50 , menu.calcularPorcentaje(100, 50));
        assertEquals( 100 , menu.calcularPorcentaje( 200, 50));
    }

    @Test
    void testCualEsMayor() {
        assertEquals( 50 , menu.cualEsMayor(10, 50));
        assertEquals( 50 , menu.cualEsMayor(50, 50));
        assertEquals( 10 , menu.cualEsMayor(10, -6));
    }

    @Test
    void testCualEsMenor() {
        assertEquals( 10 , menu.cualEsMenor(10, 50));
        assertEquals( 50 , menu.cualEsMenor(50, 50));
        assertEquals( 6 , menu.cualEsMenor(10, 6));
    }

    @Test
    void testMain() {
        // Test main method if needed
    }

    @Test
    void testPotenciaNumero() {
        assertEquals(100, menu.potenciaNumero(10,2));
        assertEquals(4, menu.potenciaNumero(2,2));
        assertEquals(64, menu.potenciaNumero(8,2));
        assertEquals(1, menu.potenciaNumero(10,0));
    }

    // Se prueba que el metodo despejarX funciona en un caso normal
    @Test
    public void testDespejarX_Caso1() {
        menu sistema = new menu();
        double[] coeficientes = {2, 4, 6};
        double[] resultadoEsperado = {1, -2, 3};
        assertArrayEquals(resultadoEsperado, sistema.despejarX(coeficientes));
        System.out.println("La prueba se realizo correctamente...");
    }

    // Se prueba que el metodo despejarX funciona en el caso extremo 0/0
    @Test
    public void testDespejarXThrowsArithmeticException() {
        double[] coeficientes = {0, 2, 3};
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            new menu().despejarX(coeficientes);
        });
        assertEquals("El coeficiente principal no puede ser cero.", exception.getMessage());
    }

    // Pruebas para el método resolver
    @Test
    public void testResolver_Caso1() {
        menu sistema = new menu();
        double[] coeficientes = {2, 4, 6, 1, 5, 10};  // Coeficientes para el sistema de ecuaciones
        double[] resultadoEsperado = {-1.67, 2.33};  // Valores esperados de x e y
        assertArrayEquals(resultadoEsperado, sistema.resolver(coeficientes));
    }

    @Test
    public void testResolver_Caso2() {
        menu sistema = new menu();
        double[] coeficientes = {3, 6, 9, 2, 7, 14};  // Coeficientes para el sistema de ecuaciones
        double[] resultadoEsperado = {-2.33, 2.67};  // Valores esperados de x e y
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
    public void calcularFigurasGeometricas_Cuadrado() {
        String resultado = menu.calcularFigurasGeometricas("cuadrado", 4);
        assertEquals("Cuadrado - Perímetro: 16.00, Área: 16.00", resultado);
    }

    @Test
    public void calcularFigurasGeometricas_Rectangulo() {
        String resultado = menu.calcularFigurasGeometricas("rectángulo", 4, 2);
        assertEquals("Rectángulo - Perímetro: 12.00, Área: 8.00", resultado);
    }

    @Test
    public void calcularFigurasGeometricas_Circulo() {
        String resultado = menu.calcularFigurasGeometricas("círculo", 3);
        assertEquals("Círculo - Perímetro: 18.85, Área: 28.27", resultado);
    }

    @Test
    public void calcularFigurasGeometricas_Esfera() {
        String resultado = menu.calcularFigurasGeometricas("esfera", 3);
        assertEquals("Esfera - Área: 113.10, Volumen: 113.10", resultado);
    }

    @Test
    public void calcularFigurasGeometricas_Cubo() {
        String resultado = menu.calcularFigurasGeometricas("cubo", 3);
        assertEquals("Cubo - Área: 54.00, Volumen: 27.00", resultado);
    }

    @Test
    public void calcularFigurasGeometricas_Cono() {
        String resultado = menu.calcularFigurasGeometricas("cono", 3, 4);
        assertEquals("Cono - Área: 75.40, Volumen: 37.70", resultado);
    }

    @Test
    public void calcularFigurasGeometricas_FiguraNoReconocida() {
        String resultado = menu.calcularFigurasGeometricas("triángulo", 3, 4);
        assertEquals("Figura no reconocida.", resultado);
    }
}