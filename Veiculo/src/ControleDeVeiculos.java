import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ControleDeVeiculos {
    List<Veiculo> listaVeiculos;

    public Veiculo getVeiculo(String placa) throws NoSuchElementException{
        if (listaVeiculos == null) {
            listaVeiculos = PersistenciaVeiculos.carregaVeiculos();
        }
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca() == placa) {
                return veiculo;
            }
        }
        throw new NoSuchElementException("Nenhum veículo com a placa " + placa + " foi encontrado.")
    }

    public List<Veiculo> getVeiculo(CategoriaVeiculo categoria) {
        if (listaVeiculos == null) {
            listaVeiculos = PersistenciaVeiculos.carregaVeiculos();
        }
        LinkedList<Veiculo> retornoVeiculos = new LinkedList<Veiculo>();
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getCategoria() == categoria) {
                retornoVeiculos.add(veiculo);
            }
        }
        return retornoVeiculos;
    }

    public List<Veiculo> getTodosVeiculos() {
        if (listaVeiculos == null) {
            listaVeiculos = PersistenciaVeiculos.carregaVeiculos();
        }
        return listaVeiculos;
    }
}