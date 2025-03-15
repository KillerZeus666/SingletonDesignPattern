package patronsingleton;

import java.util.Properties;
import utilidades.UtilidadesAcceso;

public class ParametrizacionSingleton {
    private static ParametrizacionSingleton singleton;
    private static final String CONFIGURATION_PROP = "propiedades/ConfiguracionPropiedades.properties";
    
    private static final String NOMBRE_APLICACION_PROP = "nombreAplicacion";
    private static final String NUMERO_VERSION_PROP = "numeroVersion";

    private String nombreAplicacion;
    private String numeroVersion;
    
    private ParametrizacionSingleton() {
        Properties prop = UtilidadesAcceso.loadProperty(CONFIGURATION_PROP);
        if (prop != null) {
            this.nombreAplicacion = prop.getProperty(NOMBRE_APLICACION_PROP, "Valor por defecto");
            this.numeroVersion = prop.getProperty(NUMERO_VERSION_PROP, "0.0.0");
        } else {
            this.nombreAplicacion = "Desconocido";
            this.numeroVersion = "0.0.0";
        }
    }
    
    private static synchronized void createInstance() {
        if (singleton == null) {
            singleton = new ParametrizacionSingleton();
        }
    }

    public static ParametrizacionSingleton getInstance() {
        if (singleton == null) {
            createInstance();
        }
        return singleton;
    }

    public String getNombreAplicacion() {
        return nombreAplicacion;
    }

    public void setNombreAplicacion(String nombreAplicacion) {
        this.nombreAplicacion = nombreAplicacion;
    }

    public String getNumeroVersion() {
        return numeroVersion;
    }

    public void setNumeroVersion(String numeroVersion) {
        this.numeroVersion = numeroVersion;
    }

    @Override
    public String toString() {
        return "ParametrizacionSingleton{" + "nombreAplicacion=" + nombreAplicacion + ", numeroVersion=" + numeroVersion + '}';
    }
}
