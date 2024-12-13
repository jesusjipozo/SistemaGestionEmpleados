package ej;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {
    private Properties propiedades = new Properties();
    private String ficheroBinario; // Ruta del archivo binario
    private String ficheroXml; // Ruta del archivo XML
    private String ficheroJson; // Ruta del archivo JSON
    private int idEmpleado; // Identificador del empleado

    public Configuracion() {
        cargarConfiguracion();
    }

    private void cargarConfiguracion() {
        String rutaRelativa = System.getProperty("user.dir") + "/config.properties";
        try (InputStream input = new FileInputStream(rutaRelativa)) {
            propiedades.load(input);
            ficheroBinario = propiedades.getProperty("fichero_binario");
            ficheroXml = propiedades.getProperty("fichero_xml");
            ficheroJson = propiedades.getProperty("fichero_json");
            idEmpleado = Integer.parseInt(propiedades.getProperty("id_empleado"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getFicheroBinario() {
        return ficheroBinario;
    }

    public void setFicheroBinario(String ficheroBinario) {
        this.ficheroBinario = ficheroBinario;
    }


    public void setFicheroXml(String ficheroXml) {
        this.ficheroXml = ficheroXml;
    }


    public void setFicheroJson(String ficheroJson) {
        this.ficheroJson = ficheroJson;
    }

 
    public int getIdEmpleado() {
        return idEmpleado;
    }


    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
        guardarIdEmpleado();
    }


    private void guardarIdEmpleado() {
        propiedades.setProperty("id_empleado", String.valueOf(idEmpleado));
        try (FileOutputStream output = new FileOutputStream("config.properties")) {
            propiedades.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFicheroXml() {
        return ficheroXml;
    }


    public String getFicheroJson() {
        return ficheroJson;
    }
}
