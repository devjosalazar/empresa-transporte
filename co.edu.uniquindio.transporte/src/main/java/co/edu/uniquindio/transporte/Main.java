package co.edu.uniquindio.transporte;

import co.edu.uniquindio.transporte.factory.ModelFactory;
import co.edu.uniquindio.transporte.model.Propietario;
import co.edu.uniquindio.transporte.util.Constantes;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        //buscarVehiculoCargaPlaca(modelFactory);
        //buscarPropietarioNombre(modelFactory);
        //crudPropietario(modelFactory);
        buscarPropietarionombreVocal(modelFactory);
    }

    private static void buscarPropietarionombreVocal(ModelFactory modelFactory) {
        List<Propietario> listaPropietarios = modelFactory.buscarPropietarionombreVocal();
    }

    private static void crudPropietario(ModelFactory modelFactory) {
        agregarPropietario(modelFactory);
        obtenerPropietario(modelFactory);
        //eliminarPropietario(modelFactory);
        //actualizarPropietario(modelFactory);
    }

    private static void agregarPropietario(ModelFactory modelFactory) {

        Boolean resultado = modelFactory.agregarPropietario("Pepe",
                "234242323",
                "pepe@gmail",
                "786786");

        if(resultado)
            JOptionPane.showMessageDialog(null, "Propietario agregado correctamente");
        else
            JOptionPane.showMessageDialog(null, "Propietario no agregado");
    }

    private static void obtenerPropietario(ModelFactory modelFactory) {
        Propietario propietario = modelFactory.obtenerPropietario("7777");
        if(propietario != null){
            validarResultado(propietario.toString(),Constantes.PROPIETARIO_EXISTENTE+propietario.toString(),
                    Constantes.PROPIETARIO_NO_EXISTE);
        }

    }

    private static void eliminarPropietario(ModelFactory modelFactory) {
    }

    private static void actualizarPropietario(ModelFactory modelFactory) {
    }



    private static void buscarPropietarioNombre(ModelFactory modelFactory) {
        String nombre = "ANA";
        String resultado = modelFactory.buscarPropietarioNombre(nombre);
        validarResultado(
                resultado,
                Constantes.PROPIETARIO_EXISTENTE+resultado,
                Constantes.PROPIETARIO_NO_EXISTE);

    }

    private static void buscarVehiculoCargaPlaca(ModelFactory modelFactory) {
        String placa = "RRD098";
        String resultado = modelFactory.buscarVehiculoCargaPlaca(placa);
        validarResultado(resultado, Constantes.VEHICULO_EXISTENTE+resultado, Constantes.VEHICULO_NO_EXISTE);
    }

    private static void validarResultado(String resultado,
                                         String mensajeExitoso,
                                         String mensajeNoExitoso) {
        if (!resultado.equals("")) {
            System.out.println(mensajeExitoso);
        } else {
            System.out.println(mensajeNoExitoso);
        }
    }
}









