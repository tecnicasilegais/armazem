import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("===  Controle de Veículos  ===");
        String lido;
        int opcao = 0;
        do {
            try {
                System.out.println("Selecione uma opção:");
                System.out.println("1. Procurar veículo por placa");
                System.out.println("2. Procurar veículos por categoria");
                System.out.println("3. Listar todos");
                System.out.println("0. Sair\n");
                lido = sc.nextLine();
                opcao = Integer.parseInt(lido.trim());
                switch (opcao) {
                case 1:
                    menuPlaca();
                    break;
                case 2:
                    menuCategoria();
                    break;
                case 3:
                    menuTodos();
                    break;
                default:
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Por favor, informe apenas o número da opção desejada.\n");
            }
        } while (opcao != 0);
        sc.close();
    }

    private static void menuPlaca() {
        String placa = "";
        System.out.println("===  Pesquisa por placa  ===");
        do {
            System.out.println("Informe a placa sem traços ou espaços:");
            placa = sc.nextLine().trim();
        } while (!placa.matches("([a-z]|[A-Z]){3}((\\d){4}|\\d([a-z]|[A-Z])\\d{2})"));
        try {
            Veiculo veiculo = ControleDeVeiculos.getVeiculo(placa);
            System.out.println(veiculo);
        } catch (NoSuchElementException ex) {
            System.out.println("Nenhum veiculo com a placa informada foi encontrado.");
        }
    }

    private static void menuCategoria() {
        CategoriaVeiculo[] categorias = CategoriaVeiculo.values();
        int opcao = -1;
        System.out.println("===  Pesquisa por categoria  ===");
        do {
            System.out.println("Selecione uma categoria:");
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i + 1) + ". " + categorias[i].toString());
            }
            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Por favor, informe apenas o número da opção desejada.\n");
            }
        } while (opcao < 0 && opcao >= categorias.length);
    }

    private static void menuTodos() {

    }
}