import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaPCApp {
    public static void main(String[] args) {
        Raton ratonLenovo = new Raton("BLUETOOTH","LENOVO");
        Teclado tecladoLenovo = new Teclado("BLUETOOTH", "LENOVO");
        Monitor monitorLenovo = new Monitor("Lenovo", 27);
        Computadora computadoraLenovo = new Computadora("Computadora Lenovo",
                monitorLenovo, tecladoLenovo, ratonLenovo);

        Monitor monitorDell = new Monitor("Dell", 15);
        Teclado tecladoDell = new Teclado("usb", "Dell");
        Raton ratonDell = new Raton("usb", "Dell");
        Computadora computadoraDell = new Computadora("Computadora Dell",
                monitorDell, tecladoDell, ratonDell);

        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.agregarComputadora(computadoraDell);
        orden1.mostrarOrden();

        Monitor monitorMac = new Monitor("Mac", 27);
        Teclado tecladoMac = new Teclado("BLUETOOTH", "Mac");
        Raton ratonMac = new Raton("bluetooth", "Mac");
        Computadora computadoraIMac = new Computadora("iMac",
                monitorMac, tecladoMac, ratonMac);

        Orden orden2 = new Orden();
        orden2.agregarComputadora(computadoraIMac);
        orden2.agregarComputadora(computadoraDell);
        orden2.agregarComputadora(computadoraLenovo);
        orden2.mostrarOrden();

    }
}