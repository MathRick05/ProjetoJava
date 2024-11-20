public class Produto {

    private String nome;
    private long peso;
    private long valor;

    public Produto() {
    }

    public Produto(String nome, long peso, long valor) {
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

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", peso=" + peso +
                ", valor=" + valor +
                '}';
    }
}
