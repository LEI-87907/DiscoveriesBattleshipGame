/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Barca, navio que ocupa uma posição do tabuleiro.
 */
public class Barge extends Ship {
    private static final Integer SIZE = 1;
    private static final String NAME = "Barca";

    /**
     * @param bearing orientação da barca
     * @param pos     posição da barca
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * @return o tamanho da barca (1)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}