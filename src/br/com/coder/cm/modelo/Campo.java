package br.com.coder.cm.modelo;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Campo {

    private final int linha;
    private final int coluna;

    private boolean aberto;
    private boolean minado;
    private boolean marcado;

    private List <Campo> vizinhos = new ArrayList<>();
    private List <CampoObservador> observadores = new ArrayList<>();


    public Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void registrarObservador(CampoObservador observador) {
        observadores.add(observador);
    }

    private void notificarObservadores(CampoEvento evento) {
        observadores.stream().forEach(o -> o.eventoOcorreu(this, evento));
    }

    public boolean adicionarVizinho(Campo vizinho) {
        boolean linhaDif = linha != vizinho.linha;
        boolean colunaDif = coluna != vizinho.coluna;
        boolean diagobal = linhaDif && colunaDif;

        int deltaLinha = Math.abs(linha - vizinho.linha);
        int deltaColuna = Math.abs(coluna - vizinho.coluna);
        int deltaGeral = deltaColuna + deltaLinha;

        if (deltaGeral == 1 && !diagobal) {
            vizinhos.add(vizinho);
            return true;
        } else if (deltaGeral == 2 && diagobal) {
            vizinhos.add(vizinho);
            return true;
        } else {
            return false;
        }

    }
    public void alternarMarcacao() {
        if (!aberto) {
            marcado = !marcado;

            if (marcado) {
                notificarObservadores(CampoEvento.MARCAR);

            } else {
                notificarObservadores(CampoEvento.DESMARCAR);
            }
        }
    }

    void atualizar() {
        if (aberto) {
            notificarObservadores(CampoEvento.ATUALIZAR);
        }
    }

    public boolean abrir() {

        if (!aberto && !marcado) {
            aberto = true;

            if (minado) {

                notificarObservadores(CampoEvento.EXPLODIR);
                return true;
            }

            setAberto(true);

            if (vizinhancaSegura()) {
                vizinhos.forEach(v -> v.abrir());
            }
            return true;
        } else {
            return false;
        }

    }
    public boolean vizinhancaSegura() {
        return vizinhos.stream().noneMatch(v -> v.minado);
    }

    public void minar() {
        minado = true;
    }

    public void desminar() {
        minado = false;
    }

    public boolean isMinadoEMarcado() {
        return minado && marcado;
    }

    public boolean isMinado() {
        return minado;
    }

    public boolean isMarcado() {
        return marcado;
    }

     void setAberto(boolean aberto) {
        this.aberto = aberto;

        if (aberto){
            notificarObservadores(CampoEvento.ABRIR);
        }
    }

    public boolean isAberto() {
        return aberto;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    boolean objetiboAlcancado() {
        boolean desvendado = !minado && aberto;
        boolean protegido = minado && marcado;
        return  desvendado || protegido;
    }

    public int minasNaVizinhanca() {
        return (int) vizinhos.stream().filter(v -> v.minado).count();
    }

    void reiniciar() {
        aberto = false;
        minado = false;
        marcado = false;
        notificarObservadores(CampoEvento.REINICIAR);
    }


}
