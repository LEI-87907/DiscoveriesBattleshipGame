/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Pontos cardeais usados para indicar a orientação (rumo) de um navio no
 * tabuleiro.
 * <p>
 * Cada ponto cardeal é representado por um carácter: 'n' (norte), 's' (sul),
 * 'e' (este) e 'o' (oeste). {@link #UNKNOWN} ('u') é usado quando o carácter
 * não corresponde a nenhuma direção válida.
 *
 * @author fba
 */
public enum Compass {
    /** Norte, representado por 'n'. */
    NORTH('n'),
    /** Sul, representado por 's'. */
    SOUTH('s'),
    /** Este, representado por 'e'. */
    EAST('e'),
    /** Oeste, representado por 'o'. */
    WEST('o'),
    /** Direção desconhecida ou inválida, representada por 'u'. */
    UNKNOWN('u');

    private final char c;

    /**
     * Associa um carácter a cada ponto cardeal.
     *
     * @param c carácter que representa a direção
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Devolve o carácter que representa esta direção.
     *
     * @return o carácter da direção
     */
    public char getDirection() {
        return c;
    }

    /**
     * Devolve a direção como texto, com o seu carácter.
     *
     * @return o carácter da direção em forma de {@code String}
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um carácter no ponto cardeal correspondente.
     *
     * @param ch carácter a converter ('n', 's', 'e' ou 'o')
     * @return o ponto cardeal correspondente, ou {@link #UNKNOWN} se o
     *         carácter não for válido
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
