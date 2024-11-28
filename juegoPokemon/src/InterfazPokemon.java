import java.util.Scanner;
public class InterfazPokemon {
    private Scanner teclado;

    public InterfazPokemon(){
        teclado = new Scanner(System.in);
    }

    public void Juego() {
        Pokemon jugador = menuCreacionPokemonJugador();
        Pokemon rival = siguientePokemonRival(1);
        System.out.println("\nPULSE ENTER PARA CONTINUAR");
        teclado.nextLine();
        teclado.nextLine();
        Partida(jugador, rival);
        if (Partida(jugador, rival) == rival){
            System.out.println(rival.getNombre() + " te ha derrotado.");
            mostrarFinPartida();
        }else{
            System.out.println("Genial: Has derrotado a " + rival.getNombre());
            jugador.subirNivel();
            System.out.println("\nPULSE ENTER PARA CONTINUAR");
            teclado.nextLine();
            rival = siguientePokemonRival(2);
            System.out.println("\nPULSE ENTER PARA CONTINUAR");
            teclado.nextLine();
            Partida(jugador, rival);
            if (Partida(jugador,rival) == rival){
                System.out.println(rival.getNombre() + " te ha derrotado.");
                mostrarFinPartida();
            } else{
                System.out.println("Genial: Has derrotado a " + rival.getNombre());
                jugador.subirNivel();
                System.out.println("\nPULSE ENTER PARA CONTINUAR");
                teclado.nextLine();
                rival = siguientePokemonRival(3);
                System.out.println("\nPULSE ENTER PARA CONTINUAR");
                teclado.nextLine();
                Partida(jugador,rival);
                if (Partida(jugador,rival) == jugador){
                    System.out.println("Genial: Has derrotado a " + rival.getNombre());
                    System.out.println("\nPULSE ENTER PARA CONTINUAR");
                    teclado.nextLine();
                    mostrarJuegoSuperado();
                }else{
                    System.out.println(rival.getNombre() + " te ha derrotado.");
                    mostrarFinPartida();
                }
            }
        }

    }

    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival){
        Combate combate = new Combate(pokemonJugador, pokemonRival);
        while (pokemonJugador.getAguante() > 0 && pokemonRival.getAguante() > 0){
            Pokemon ganaRonda = combate.Ronda();
            if (ganaRonda == null){
                System.out.println("empate en esta ronda");
                System.out.println("Aguante de " + pokemonJugador.getNombre() + ": " + pokemonJugador.getAguante());
                System.out.println("Aguante de " + pokemonRival.getNombre() + ": " + pokemonRival.getAguante());
            }else{
                System.out.println("Gana la ronda: " + ganaRonda.getNombre());
                System.out.println("Aguante de " + pokemonJugador.getNombre() + ": " + pokemonJugador.getAguante());
                System.out.println("Aguante de " + pokemonRival.getNombre() + ": " + pokemonRival.getAguante());
            }

        }
        return combate.Ganador();
    }


    private Pokemon menuCreacionPokemonJugador(){
        System.out.println("..........................................................");
        System.out.println("Crea tu pokemon ......");
        System.out.println("..........................................................");
        System.out.println("Introduce un nombre:");
        String nombre = teclado.next();
        System.out.println("Elige su tipo:");
        System.out.println("1.- Agua");
        System.out.println("2.- Tierra");
        System.out.println("3.- Fuego");
        int tipo = teclado.nextInt();
        String tipoS;
        while (tipo != 1 && tipo != 2 && tipo != 3){
            System.out.println("Introduzca un tipo válido");
            tipo = teclado.nextInt();
        }
        if(tipo == 1){
            tipoS = "Agua";
        }else if (tipo == 2){
            tipoS = "Tierra";
        }else{
            tipoS = "Fuego";
        }
        return new Pokemon(nombre, tipoS);
    }

    public Pokemon siguientePokemonRival(int numero) {
    if (numero == 1){
        Pokemon rival = new Pokemon("Caterpie","Tierra",1 );
        System.out.println("Presentación del pokemon oponente:");
        System.out.println(rival);
        return rival;
    }else if (numero == 2){
        Pokemon rival = new Pokemon("Bulbasaur","Agua",2 );
        System.out.println("Presentación del pokemon oponente:");
        System.out.println(rival);
        return rival;
    }else {
        Pokemon rival = new Pokemon("Charmander","Fuego",3 );
        System.out.println("Presentación del pokemon oponente:");
        System.out.println(rival);
        return rival;
    }

    }

    private void mostrarJuegoSuperado(){
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    private void mostrarFinPartida(){
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }

}
