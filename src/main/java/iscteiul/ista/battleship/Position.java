/**
 *
 */
package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Representa uma posição (quadrado) do tabuleiro de jogo, identificada pela
 * linha e pela coluna.
 * <p>
 * Para além das coordenadas, cada posição guarda se está ocupada por um navio
 * e se já foi atingida por um tiro.
 */
public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Cria uma posição nas coordenadas indicadas. A posição começa livre e sem
     * ter sido atingida.
     *
     * @param row    linha da posição
     * @param column coluna da posição
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Devolve a linha da posição.
     *
     * @return a linha
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Devolve a coluna da posição.
     *
     * @return a coluna
     */
    @Override
    public int getColumn() {
        return column;
    }


    /**
     * Calcula o código de hash da posição.
     *
     * @return o código de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Verifica se esta posição é igual a outra. Duas posições são iguais quando
     * têm a mesma linha e a mesma coluna.
     *
     * @param otherPosition objeto a comparar com esta posição
     * @return {@code true} se o objeto for uma posição com as mesmas
     *         coordenadas, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Verifica se outra posição é adjacente a esta, incluindo na diagonal.
     * Uma posição também é considerada adjacente a si própria.
     *
     * @param other a outra posição
     * @return {@code true} se a linha e a coluna diferirem no máximo 1,
     *         {@code false} caso contrário
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marca a posição como ocupada por um navio.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marca a posição como atingida por um tiro.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Indica se a posição está ocupada por um navio.
     *
     * @return {@code true} se estiver ocupada, {@code false} caso contrário
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Indica se a posição já foi atingida por um tiro.
     *
     * @return {@code true} se já foi atingida, {@code false} caso contrário
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Devolve uma descrição da posição com a linha e a coluna.
     *
     * @return texto no formato "Linha = r Coluna = c"
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}
