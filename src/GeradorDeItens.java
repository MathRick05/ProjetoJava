import java.util.ArrayList;
import java.util.Random;

public class GeradorDeItens {
    private Random random;
    private String[] nomesPossiveis = {"Espada", "Escudo", "Poção", "Armadura", "Elmo", "Bota", "Anel", "Bracelete"};

    public GeradorDeItens(long seed) {
        this.random = new Random(seed);
    }

    public GeradorDeItens() {
        this.random = new Random();
    }

    public ArrayList<Item> gerarItensAleatorios(int quantidade) {
        ArrayList<Item> itens = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            String nomeItem = "Item" + (i + 1);
            long pesoItem = random.nextInt(50) + 1;
            long valorItem = random.nextInt(100) + 1;
            itens.add(new Item(nomeItem, pesoItem, valorItem));
        }
        return itens;
    }
}
