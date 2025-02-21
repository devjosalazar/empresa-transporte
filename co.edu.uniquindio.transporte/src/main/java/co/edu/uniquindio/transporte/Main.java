package co.edu.uniquindio.transporte;

import co.edu.uniquindio.transporte.factory.ModelFactory;
import co.edu.uniquindio.transporte.util.Constantes;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        //buscarVehiculoCargaPlaca(modelFactory);
        buscarPropietarioNombre(modelFactory);
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









