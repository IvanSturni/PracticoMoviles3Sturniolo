package com.sturni.practicomoviles3sturniolo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<String> resultado;
    private Double tasaDaE = 0.85021; // Tasa de cambio de Dólares a Euros

    public MutableLiveData<String> getResultado() {
        if (resultado == null) {
            resultado = new MutableLiveData<>();
        }
        return resultado;
    }

    private Double mostrarDecimales(Double valor, int decimales) {
        decimales = Math.min(decimales, 10);
        valor = valor * Math.pow(10, decimales); // Mueve la coma la cantidad de decimales que uno quiere
        valor = Math.floor(valor); // Corta los demás números
        valor = valor / Math.pow(10, decimales); // Mueve la coma a la posición original

        return valor;
    }

    public void convertir(Boolean esDolaresAEuros, String dolares, String euros, String decimales) {
        Integer dec = 2;
        try {
            dec = Integer.parseInt(decimales);
        } catch (Exception _) {
            resultado.setValue("Ingrese una cantidad de decimales correcta.");
            return;
        }

        if (esDolaresAEuros) {
            try {
                resultado.setValue(mostrarDecimales(Double.parseDouble(dolares) * tasaDaE, dec) + "");
            } catch (Exception _) {
                resultado.setValue("Ingrese una cantidad de dólares válida.");
            }
        } else {
            try {
                resultado.setValue(mostrarDecimales(Double.parseDouble(euros) / tasaDaE, dec) + "");
            } catch (Exception _) {
                resultado.setValue("Ingrese una cantidad de euros válida.");
            }
        }
    }
}
