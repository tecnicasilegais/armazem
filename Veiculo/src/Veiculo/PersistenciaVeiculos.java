package Veiculo;

import java.util.LinkedList;
import java.util.List;

public class PersistenciaVeiculos {
    public static List<Veiculo> carregaVeiculos() {
        return new LinkedList<Veiculo>();
    }

    public static boolean persisteVeiculos(List<Veiculo> lista) {
        return false;
    }
}