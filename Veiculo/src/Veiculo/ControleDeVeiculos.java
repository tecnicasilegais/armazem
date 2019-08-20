package veiculo;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import enums.CategoriaVeiculo;

public class ControleDeVeiculos {
    /**
     * Procura um veiculo com base na placa passada
     * 
     * @param placa Placa do veiculo
     * @return Veiculo com a placa correspondente, se existir
     * @throws NoSuchElementException
     */
    public static Veiculo getVeiculo(String placa) throws NoSuchElementException {
        for (Veiculo veiculo : PersistenciaVeiculos.carregaVeiculos()) {
            if (veiculo.getPlaca() == placa) {
                return veiculo;
            }
        }
        throw new NoSuchElementException("Nenhum veiculo com a placa " + placa + " foi encontrado.");
    }

    /**
     * Procura os veiculos da categoria passada
     * 
     * @param categoria Categoria do veiculo
     * @return Lista contendo os veiculos ou lista vazia
     */
    public static List<Veiculo> getVeiculo(CategoriaVeiculo categoria) {
        LinkedList<Veiculo> retornoVeiculos = new LinkedList<Veiculo>();
        for (Veiculo veiculo : PersistenciaVeiculos.carregaVeiculos()) {
            if (veiculo.getCategoria() == categoria) {
                retornoVeiculos.add(veiculo);
            }
        }
        return retornoVeiculos;
    }

    /**
     * Lista todos os veiculos
     * 
     * @return Lista contendo todos os veiculos
     */
    public static List<Veiculo> getTodosVeiculos() {
        return PersistenciaVeiculos.carregaVeiculos();
    }
}