/**
 * Clase Combate.
 * Representa un combate entre dos Pokémon y define las reglas para las rondas y la determinación del ganador.
 */
public class Combate {

    private Pokemon pokemonJugador;
    private Pokemon pokemonRival;

    /**
     * Constructor de la clase Combate.
     *
     * @param jugador Pokémon del jugador.
     * @param rival   Pokémon del rival.
     */
    public Combate(Pokemon jugador, Pokemon rival) {
        this.pokemonJugador = jugador;
        this.pokemonRival = rival;
    }

    /**
     * Ejecuta una ronda del combate entre los dos Pokémon.
     * Calcula el poder de ataque de ambos Pokémon, determina al ganador de la ronda
     * y reduce el aguante del perdedor en 1.
     *
     * @return El Pokémon ganador de la ronda, o null si hay empate.
     */
    public Pokemon Ronda() {
        int poderJugador = this.pokemonJugador.calcularPoder(pokemonJugador);
        int poderRival = this.pokemonRival.calcularPoder(pokemonRival);

        if (poderJugador > poderRival) {
            this.pokemonRival.disminuirAguante();
            return this.pokemonJugador;
        } else if (poderRival > poderJugador) {
            this.pokemonJugador.disminuirAguante();
            return this.pokemonRival;
        } else {
            return null; // Empate
        }
    }

    /**
     * Determina el ganador del combate.
     * El ganador es el Pokémon que tenga aguante mayor a 0 cuando el otro llegue a 0.
     *
     * @return El Pokémon ganador, o null si el combate aún no ha terminado.
     */
    public Pokemon Ganador() {
        if (this.pokemonJugador.getAguante() == 0) {
            return this.pokemonRival;
        } else if (this.pokemonRival.getAguante() == 0) {
            return this.pokemonJugador;
        } else {
            return null; // Combate aún en curso
        }
    }
}
