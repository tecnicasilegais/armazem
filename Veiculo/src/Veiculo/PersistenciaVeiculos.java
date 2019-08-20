package veiculo;

import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import enums.CategoriaVeiculo;

/**
 * Classe responsavel pela leitura e persistencia de dados do arquivo de
 * Veiculos
 */
public class PersistenciaVeiculos {
    // caminho do arquivo de veiculos tratado
    private static final String path = new File("").getAbsolutePath();

    private static final String filename = "\\data\\veiculos.dat";

    /**
     * Metodo usado para carregar a lista de Veiculos presente no arquivo
     * 
     * @return List<Veiculo>
     */
    public static List<Veiculo> carregaVeiculos() {
        try {
            FileReader file = new FileReader(path + filename);
            BufferedReader reader = new BufferedReader(file);
            List<Veiculo> veiculos = new LinkedList<Veiculo>();
            String row;
            while ((row = reader.readLine()) != null) {
                String[] dadosLinha = row.split(",");
                CategoriaVeiculo cat = CategoriaVeiculo.valueOf(dadosLinha[3].toUpperCase());
                Veiculo esteveiculo = new Veiculo(dadosLinha[2], dadosLinha[1], dadosLinha[0], cat);
                veiculos.add(esteveiculo);
            }
            reader.close();
            return veiculos;
        } catch (IOException ex) {
            // adicionar log
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Metodo responsavel pela persistencia de uma lista de veiculos no arquivo
     * 
     * @param veiculos de veiculos a ser salva
     * @return verdadeiro para sucesso e falso para falha
     */
    public static boolean persisteVeiculos(List<Veiculo> veiculos) {
        try {
            Map<String, Veiculo> mapa_veiculos = mapeiaVeiculos(carregaVeiculos(), veiculos);
            FileWriter file = new FileWriter(path + filename, false);
            BufferedWriter writer = new BufferedWriter(file);

            for (Veiculo v : mapa_veiculos.values()) {
                String linha = v.getCor() + "," + v.getMarca() + "," + v.getPlaca() + "," + v.getCategoria().toString();
                writer.write(linha);
                writer.newLine();
            }

            writer.close();
            file.close();
            return true;
        } catch (IOException io) {
            // adicionar log
            System.out.println(io.getMessage());
            return false;
        } catch (Exception ex) {
            // adicionar log
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Metodo que passa a lista de veiculos para um HashMap -utilizado para impedir
     * repeticoes na base de dados
     * 
     * @param veiculos lista de veiculos que vao ser mapeados
     * @return Mapa com os veiculos mapeados
     */
    private static Map<String, Veiculo> mapeiaVeiculos(List<Veiculo> veiculos, List<Veiculo> inclusao) {
        try {
            Map<String, Veiculo> mapear = new HashMap<String, Veiculo>();
            for (Veiculo v : veiculos) {
                mapear.put(v.getPlaca(), v);
            }
            for (Veiculo v : inclusao) {
                Veiculo teste = mapear.get(v.getPlaca());
                if (teste != null) {
                    // implementar alterações caso o professor solicite
                } else {
                    mapear.put(v.getPlaca(), v);
                }
            }
            return mapear;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}