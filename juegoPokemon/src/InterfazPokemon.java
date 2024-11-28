import java.util.Scanner;

/**
 * Clase InterfazPokemon.
 * Controla la lógica del juego, permite la interacción con el jugador,
 * organiza los combates y gestiona la progresión en el juego.
 */
public class InterfazPokemon {
    private Scanner teclado;

    /**
     * Constructor de la clase InterfazPokemon.
     * Inicializa el scanner para la entrada de datos del jugador.
     */
    public InterfazPokemon() {
        teclado = new Scanner(System.in);
    }

    /**
     * Método principal que organiza el flujo del juego.
     * Permite al jugador enfrentarse a tres combates consecutivos, subiendo de nivel
     * después de cada victoria, o finalizando el juego al ser derrotado.
     */
    public void Juego() {
        Pokemon jugador = menuCreacionPokemonJugador();
        Pokemon rival = siguientePokemonRival(1);

        System.out.println("\nPULSE ENTER PARA CONTINUAR");
        teclado.nextLine();
        teclado.nextLine();

        if (Partida(jugador, rival) == rival) {
            System.out.println(rival.getNombre() + " te ha derrotado.");
            mostrarFinPartida();
        } else {
            System.out.println("Genial: Has derrotado a " + rival.getNombre());
            jugador.subirNivel();

            System.out.println("\nPULSE ENTER PARA CONTINUAR");
            teclado.nextLine();
            rival = siguientePokemonRival(2);

            System.out.println("\nPULSE ENTER PARA CONTINUAR");
            teclado.nextLine();

            if (Partida(jugador, rival) == rival) {
                System.out.println(rival.getNombre() + " te ha derrotado.");
                mostrarFinPartida();
            } else {
                System.out.println("Genial: Has derrotado a " + rival.getNombre());
                jugador.subirNivel();

                System.out.println("\nPULSE ENTER PARA CONTINUAR");
                teclado.nextLine();
                rival = siguientePokemonRival(3);

                System.out.println("\nPULSE ENTER PARA CONTINUAR");
                teclado.nextLine();

                if (Partida(jugador, rival) == jugador) {
                    System.out.println("Genial: Has derrotado a " + rival.getNombre());
                    System.out.println("\nPULSE ENTER PARA CONTINUAR");
                    teclado.nextLine();
                    mostrarJuegoSuperado();
                } else {
                    System.out.println(rival.getNombre() + " te ha derrotado.");
                    mostrarFinPartida();
                }
            }
        }
    }

    /**
     * Gestiona una partida entre el Pokémon del jugador y el Pokémon rival.
     *
     * @param pokemonJugador Pokémon del jugador.
     * @param pokemonRival   Pokémon rival.
     * @return Pokémon ganador del combate, o null si hubo empate.
     */
    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival) {
        Combate combate = new Combate(pokemonJugador, pokemonRival);

        while (pokemonJugador.getAguante() > 0 && pokemonRival.getAguante() > 0) {
            Pokemon ganaRonda = combate.Ronda();

            if (ganaRonda == null) {
                System.out.println("Empate en esta ronda.");
            } else {
                System.out.println("Gana la ronda: " + ganaRonda.getNombre());
            }

            System.out.println("Aguante de " + pokemonJugador.getNombre() + ": " + pokemonJugador.getAguante());
            System.out.println("Aguante de " + pokemonRival.getNombre() + ": " + pokemonRival.getAguante());
        }

        return combate.Ganador();
    }

    /**
     * Permite al jugador crear su Pokémon inicial.
     *
     * @return Pokémon creado por el jugador.
     */
    private Pokemon menuCreacionPokemonJugador() {
        System.out.println("..........................................................");
        System.out.println("Crea tu Pokémon ......");
        System.out.println("..........................................................");
        System.out.println("Introduce un nombre:");
        String nombre = teclado.next();

        System.out.println("Elige su tipo:");
        System.out.println("1.- Agua");
        System.out.println("2.- Tierra");
        System.out.println("3.- Fuego");

        int tipo = teclado.nextInt();
        String tipoS;
        while (tipo != 1 && tipo != 2 && tipo != 3) {
            System.out.println("Introduce un tipo válido:");
            tipo = teclado.nextInt();
        }

        if (tipo == 1) {
            tipoS = "Agua";
        } else if (tipo == 2) {
            tipoS = "Tierra";
        } else {
            tipoS = "Fuego";
        }

        return new Pokemon(nombre, tipoS);
    }

    /**
     * Devuelve un Pokémon rival basado en la ronda actual.
     *
     * @param numero Número de la ronda (1, 2 o 3).
     * @return Pokémon rival correspondiente a la ronda.
     */
    public Pokemon siguientePokemonRival(int numero) {
        Pokemon rival;
        if (numero == 1) {
            rival = new Pokemon("Caterpie", "Tierra", 1);
        } else if (numero == 2) {
            rival = new Pokemon("Bulbasaur", "Agua", 2);
        } else {
            rival = new Pokemon("Charmander", "Fuego", 3);
        }

        System.out.println("Presentación del Pokémon oponente:");
        System.out.println(rival);
        return rival;
    }

    /**
     * Muestra un mensaje indicando que el jugador ha ganado el juego.
     */
    private void mostrarJuegoSuperado() {
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    /**
     * Muestra un mensaje indicando que el jugador ha sido eliminado.
     */
    private void mostrarFinPartida() {
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }
}
