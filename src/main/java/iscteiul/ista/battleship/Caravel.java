/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Caravela, navio que ocupa duas posições do tabuleiro.
 */
public class Caravel extends Ship {
    private static final Integer SIZE = 2;
    private static final String NAME = "Caravela";

    /**
     * @param bearing orientação da caravela
     * @param pos     posição inicial da caravela
     * @throws NullPointerException     se a orientação for null
     * @throws IllegalArgumentException se a orientação for inválida
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * @return o tamanho da caravela (2)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}