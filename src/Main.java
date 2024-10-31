import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        String opc = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o tamanho da mochila?");
        long getCapacidadeMax = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Deseja criar os itens manualmente?");
        opc = scanner.nextLine().toUpperCase();

        ArrayList<Item> itens = new ArrayList<>();

        if(opc.equals("SIM"))
        {
            String adicionarMais = "sim";
            while (adicionarMais.equalsIgnoreCase("sim")) {

                System.out.println("Qual o nome do item?");
                String nomeItem = scanner.nextLine();

                System.out.println("Qual o peso do item?");
                long pesoItem = scanner.nextLong();
                scanner.nextLine();

                System.out.println("Qual o valor do item?");
                long valorItem = scanner.nextLong();
                scanner.nextLine();

                Item item = new Item(nomeItem, pesoItem, valorItem);
                itens.add(item);

                System.out.println("Deseja adicionar mais itens? (sim/não)");
                adicionarMais = scanner.nextLine();

            }
        }
        else {
            System.out.println("Quantos itens deseja gerar?");
            int qntd = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Deseja usar uma seed?");
            String usarSeed = scanner.nextLine().toUpperCase();

            GeradorDeItens gerador;

            if(usarSeed.equals("SIM")){
                System.out.println("Qual a seed?");
                int seed = scanner.nextInt();
                scanner.nextLine();

                gerador = new GeradorDeItens(seed);
            }else {
                gerador = new GeradorDeItens();
            }

            itens = gerador.gerarItensAleatorios(qntd);
        }

        Mochila mochila = new Mochila(getCapacidadeMax);

        System.out.println("Itens:");
        for (Item item : itens) {
            System.out.println("Item: " + item.getNome() + ", Peso: " + item.getPeso() + ", Valor: " + item.getValor());
        }
    }
}