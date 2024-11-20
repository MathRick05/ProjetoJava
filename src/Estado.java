public class Estado {

    private int index;
    private long armazenamentoAtual;
    private long valorAtual;
    private long estimativaValor;

    public Estado(int index, long armazenamentoAtual, long valorAtual, long estimativaValor) {
        this.index = index;
        this.armazenamentoAtual = armazenamentoAtual;
        this.valorAtual = valorAtual;
        this.estimativaValor = estimativaValor;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getArmazenamentoAtual() {
        return armazenamentoAtual;
    }

    public void setArmazenamentoAtual(long armazenamentoAtual) {
        this.armazenamentoAtual = armazenamentoAtual;
    }

    public long getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(long valorAtual) {
        this.valorAtual = valorAtual;
    }

    public long getEstimativaValor() {
        return estimativaValor;
    }

    public void setEstimativaValor(long estimativaValor) {
        this.estimativaValor = estimativaValor;
    }
}
