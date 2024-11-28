public class Combate {

    // Añada los atributos y el constructor *************

    private Pokemon pokemonJugador;
    private Pokemon pokemonRival;

    public Combate (Pokemon jugador, Pokemon rival){
        this.pokemonJugador = jugador;
        this.pokemonRival = rival;
    }

    //***************************************************


    public Pokemon Ronda(){
        int poderJugador = this.pokemonJugador.calcularPoder(pokemonJugador);
        int poderRival = this.pokemonRival.calcularPoder(pokemonRival);
         if (poderJugador > poderRival){
             this.pokemonRival.disminuirAguante();
             return this.pokemonJugador;
         }else if (poderRival > poderJugador){
             this.pokemonJugador.disminuirAguante();
             return this.pokemonRival;
         }else{
             return null;
         }

    }

    public Pokemon Ganador(){
        if (this.pokemonJugador.getAguante() == 0){

            return this.pokemonRival;
        } else if (this.pokemonRival.getAguante() == 0){

            return this.pokemonJugador;
        }else {
            return null;
        }
    }


}
