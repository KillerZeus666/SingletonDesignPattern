/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Creacional - > Singleton
 * Tipo de Clase: Main()
 */
    package patronsingleton;
    /***
    * @author Fabrizio Bolaño
    */
    public class PatronSingletonMain {
    public static void main(String[] args) {
        //Configuración de Propiedades para el Modulo No->1
         // Creamos tres hilos que acceden al Singleton y lo modifican
         Thread hilo1 = new Thread(() -> {
            ParametrizacionSingleton singleton = ParametrizacionSingleton.getInstance();
            singleton.setNombreAplicacion("Aplicación Modificada por Hilo 1");
            singleton.setNumeroVersion("1.1");
            System.out.println("Hilo 1: " + singleton);
        });

        Thread hilo2 = new Thread(() -> {
            ParametrizacionSingleton singleton = ParametrizacionSingleton.getInstance();
            singleton.setNombreAplicacion("Aplicación Modificada por Hilo 2");
            singleton.setNumeroVersion("2.2");
            System.out.println("Hilo 2: " + singleton);
        });

        Thread hilo3 = new Thread(() -> {
            ParametrizacionSingleton singleton = ParametrizacionSingleton.getInstance();
            singleton.setNombreAplicacion("Aplicación Modificada por Hilo 3");
            singleton.setNumeroVersion("3.3");
            System.out.println("Hilo 3: " + singleton);
        });

        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Esperamos a que todos los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimimos la configuración final después de que todos los hilos terminaron
        ParametrizacionSingleton singletonFinal = ParametrizacionSingleton.getInstance();
        System.out.println("Estado final del Singleton ==> " + singletonFinal);
    }
}
    
    
