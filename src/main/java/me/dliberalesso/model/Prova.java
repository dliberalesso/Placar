package me.dliberalesso.model;

/**
 * Modela Prova e confere comportamento.
 * <p>
 * Uma Prova eh composta por sua descricao, tempo maximo em segundos e pontuacao maxima.
 */
public class Prova {
    private String descricao;
    private int tempoMaximo, pontuacaoMaxima;

    /**
     * Construtor generico utilizado pela GUI.
     */
    public Prova() {
        // Generico
    }

    /**
     * Retorna a descricao da Prova.
     *
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Seta a descricao da Prova.
     *
     * @param descricao String que representa a descricao da Prova
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o tempo maximo de duracao da Prova em segundos.
     *
     * @return tempoMaximo
     */
    public int getTempoMaximo() {
        return tempoMaximo;
    }

    /**
     * Seta o tempo maximo de duracao da Prova em segundos.
     *
     * @param tempoMaximo Tempo maximo em segundos
     */
    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }

    /**
     * Retorna a pontuacao maxima da Prova.
     *
     * @return pontuacaoMaxima
     */
    public int getPontuacaoMaxima() {
        return pontuacaoMaxima;
    }

    /**
     * Seta a pontuacao maxima da Prova.
     *
     * @param pontuacaoMaxima Pontuacao maxima
     */
    public void setPontuacaoMaxima(int pontuacaoMaxima) {
        this.pontuacaoMaxima = pontuacaoMaxima;
    }
}
