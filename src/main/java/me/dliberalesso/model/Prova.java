package me.dliberalesso.model;

/**
 * Modela Prova e confere comportamento.
 * <p>
 * Uma Prova eh composta por sua descricao, tempo maximo e penalidade em segundos, pontuacao maxima.
 */
public class Prova {
    private String descricao;
    private int tempoMaximo, pontuacaoMaxima, penalidade;

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
     * @throws IllegalArgumentException Descricao nao pode ser vazia
     */
    public void setDescricao(String descricao) throws IllegalArgumentException {
        if (descricao.equals("")) {
            throw new IllegalArgumentException("Descricao nao pode ser vazia.");
        }

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
     * @throws IllegalArgumentException Tempo maximo deve ser um inteiro maior ou igual a zero
     */
    public void setTempoMaximo(int tempoMaximo) throws IllegalArgumentException {
        if (tempoMaximo == 0) {
            throw new IllegalArgumentException("Tempo maximo deve ser um inteiro maior ou igual a zero.");
        }

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
     * @throws IllegalArgumentException Pontuacao maxima deve ser um inteiro maior ou igual a zero
     */
    public void setPontuacaoMaxima(int pontuacaoMaxima) throws IllegalArgumentException {
        if (pontuacaoMaxima == 0) {
            throw new IllegalArgumentException("Pontuacao maxima deve ser um inteiro maior ou igual a zero.");
        }

        this.pontuacaoMaxima = pontuacaoMaxima;
    }

    /**
     * Retorna a penalidade da Prova.
     *
     * @return penalidade
     */
    public int getPenalidade() {
        return penalidade;
    }

    /**
     * Seta a penalidade da Prova.
     *
     * @param penalidade Penalidade em segundos
     * @throws IllegalArgumentException Penalidade deve ser um inteiro maior ou igual a zero
     */
    public void setPenalidade(int penalidade) throws IllegalArgumentException {
        if (penalidade <= 0) {
            throw new IllegalArgumentException("Penalidade deve ser um inteiro maior ou igual a zero.");
        }

        this.penalidade = penalidade;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
