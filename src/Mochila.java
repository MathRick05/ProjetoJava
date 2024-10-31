import java.util.ArrayList;

public class Mochila {

    private long capacidadeMax;
    private ArrayList<Item> itens;
    private long numItens;

    public Mochila() {
    }

    public Mochila(long getCapacidadeMax) {

    }

    public Mochila(long capacidadeMax, ArrayList<Item> itens) {
        this.capacidadeMax = capacidadeMax;
        this.itens = itens;
    }

    public long getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(long capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public long getNumItens() {
        return numItens;
    }

    public void setNumItens(long numItens) {
        this.numItens = numItens;
    }



}
