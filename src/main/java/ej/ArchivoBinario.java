package ej;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoBinario {

    public void escribirEmpleados(String ruta, List<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            for (Empleado empleado : empleados) {
                oos.writeObject(empleado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Empleado> leerEmpleados(String archivo) {
        ArrayList<Empleado> empleados = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            empleados = (ArrayList<Empleado>) ois.readObject();  // Castear a ArrayList<Empleado>
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return empleados;
    }

}
