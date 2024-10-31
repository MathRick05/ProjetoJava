public class Item {

    private String nome;
    private long peso;
    private long valor;

    public Item() {
    }

    public Item(String nome, long peso, long valor) {
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPeso() {
        return peso;
    }

    public void setPeso(long peso) {
        this.peso = peso;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }



}
