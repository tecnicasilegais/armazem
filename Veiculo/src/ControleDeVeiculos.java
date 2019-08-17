import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ControleDeVeiculos {
    /**
     * Procura um veículo com base na placa passada
     * 
     * @param placa Placa do veículo
     * @return Veículo com a placa correspondente, se existir
     * @throws NoSuchElementException
     */
    public static Veiculo getVeiculo(String placa) throws NoSuchElementException {
        for (Veiculo veiculo : PersistenciaVeiculos.carregaVeiculos()) {
            if (veiculo.getPlaca() == placa) {
                return veiculo;
            }
        }
        throw new NoSuchElementException("Nenhum veículo com a placa " + placa + " foi encontrado.");
    }

    /**
     * Procura os veículos da categoria passada
     * 
     * @param categoria Categoria do veículo
     * @return Lista contendo os veículos ou lista vazia
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
     * Lista todos os veículos
     * 
     * @return Lista contendo todos os veículos
     */
    public static List<Veiculo> getTodosVeiculos() {
        return PersistenciaVeiculos.carregaVeiculos();
    }
}