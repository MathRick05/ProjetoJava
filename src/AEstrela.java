
    import java.util.ArrayList;
import java.util.PriorityQueue;

    public class AEstrela {

        private long capacidadeMax;
        private ArrayList<Produto> itens;

        public AEstrela(long capacidadeMax, ArrayList<Produto> itens) {
            this.capacidadeMax = capacidadeMax;
            this.itens = itens;
        }

        public Armazem resolver() {
            PriorityQueue<Estado> fila = new PriorityQueue<>((e1, e2) -> Long.compare(e2.getEstimativaValor(), e1.getEstimativaValor()));

            Estado estadoInicial = new Estado(0, 0, 0, calcularEstimativa(0, 0));
            fila.add(estadoInicial);

            Estado melhorEstado = null;

            while (!fila.isEmpty()) {
                Estado atual = fila.poll();

                if (atual.getArmazenamentoAtual() <= capacidadeMax && (melhorEstado == null || atual.getValorAtual() > melhorEstado.getValorAtual())) {
                    melhorEstado = atual;
                }

                if (atual.getIndex() < itens.size()) {
                    int proximoIndice = atual.getIndex() + 1;

                    Estado incluir = criarEstadoComItem(atual, proximoIndice);
                    if (incluir != null) fila.add(incluir);

                    Estado naoIncluir = criarEstadoSemItem(atual, proximoIndice);
                    fila.add(naoIncluir);
                }
            }

            return construirArmazen(melhorEstado);
        }

        private long calcularEstimativa(int indice, long valorAtual) {
            long estimativa = valorAtual;
            long pesoRestante = capacidadeMax;

            for (int i = indice; i < itens.size(); i++) {
                Produto item = itens.get(i);
                if (item.getPeso() <= pesoRestante) {
                    pesoRestante -= item.getPeso();
                    estimativa += item.getValor();
                }
            }
            return estimativa;
        }

        private Estado criarEstadoComItem(Estado atual, int proximoIndice) {
            Produto item = itens.get(atual.getIndex());
            long novoPeso = atual.getArmazenamentoAtual() + item.getPeso();
            if (novoPeso > capacidadeMax) return null;

            long novoValor = atual.getValorAtual() + item.getValor();
            long novaEstimativa = calcularEstimativa(proximoIndice, novoValor);
            return new Estado(proximoIndice, novoPeso, novoValor, novaEstimativa);
        }

        private Estado criarEstadoSemItem(Estado atual, int proximoIndice) {
            long novaEstimativa = calcularEstimativa(proximoIndice, atual.getValorAtual());
            return new Estado(proximoIndice, atual.getArmazenamentoAtual(), atual.getValorAtual(), novaEstimativa);
        }

        private Armazem construirArmazen(Estado melhorEstado) {
            ArrayList<Produto> itensSelecionados = new ArrayList<>();
            Estado atual = melhorEstado;

            while (atual != null && atual.getIndex() > 0) {
                Produto item = itens.get(atual.getIndex() - 1);
                if (atual.getArmazenamentoAtual() >= item.getPeso() && atual.getValorAtual() >= item.getValor()) {
                    itensSelecionados.add(0, item);
                }
                atual = null;
            }

            return new Armazem(capacidadeMax, itensSelecionados);
        }

    }


