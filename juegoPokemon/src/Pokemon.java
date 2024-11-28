/**
 * La clase Pokémon representa a un Pokémon con un nombre, tipo, nivel y aguante. 
 * Permite calcular su poder contra otros Pokémon, subir de nivel, y modificar 
 * sus estadísticas de acuerdo al nivel.
 */
public class Pokemon {

    private String nombre;  // Nombre del Pokémon
    private String tipo;    // Tipo del Pokémon (e.g., Agua, Fuego, Tierra)
    private int nivel;      // Nivel del Pokémon
    private int aguante;    // Aguante (resistencia) del Pokémon

    /**
     * Constructor para crear un Pokémon con un nombre y un tipo específico, 
     * y asignar el nivel inicial como 1. También se actualizan sus estadísticas.
     *
     * @param qNombre El nombre del Pokémon.
     * @param qTipo El tipo del Pokémon (e.g., Agua, Fuego, Tierra).
     */
    public Pokemon(String qNombre, String qTipo){
        this.nombre = qNombre;
        this.tipo = qTipo;
        this.nivel = 1;  // El nivel inicial es 1
        this.actualizarStats();  // Actualiza el aguante al nivel 1
    } // Pokémon jugador

    /**
     * Constructor para crear un Pokémon con un nombre, un tipo y un nivel especificado. 
     * También actualiza las estadísticas del Pokémon.
     *
     * @param qNombre El nombre del Pokémon.
     * @param qTipo El tipo del Pokémon.
     * @param qNivel El nivel inicial del Pokémon.
     */
    public Pokemon(String qNombre, String qTipo, int qNivel){
        this.nombre = qNombre;
        this.tipo = qTipo;
        this.nivel = qNivel;
        this.actualizarStats();  // Actualiza las estadísticas según el nivel
    } // Pokémon rival

    /**
     * Obtiene el aguante (resistencia) del Pokémon.
     *
     * @return El aguante del Pokémon.
     */
    public int getAguante() {
        return aguante;
    }

    /**
     * Establece un nuevo valor para el aguante del Pokémon.
     *
     * @param aguante El nuevo valor de aguante.
     */
    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    /**
     * Obtiene el nombre del Pokémon.
     *
     * @return El nombre del Pokémon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo del Pokémon.
     *
     * @return El tipo del Pokémon.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el nivel del Pokémon.
     *
     * @return El nivel del Pokémon.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece un nuevo nivel para el Pokémon.
     *
     * @param nivel El nuevo nivel del Pokémon.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Calcula el poder de un Pokémon al enfrentarse a otro Pokémon.
     * El daño se ajusta según el tipo de cada Pokémon, y el nivel de ambos.
     *
     * @param contrincante El Pokémon contra el que se calcula el poder.
     * @return El poder de ataque contra el contrincante.
     */
    public int calcularPoder(Pokemon contrincante){
        int danoPorNivel = ((int)(Math.random()*8)+3) * this.nivel;

        // Lógica para calcular el poder de ataque según el tipo de Pokémon
        if(contrincante.getTipo() == "Agua" ){
            if (this.tipo == "Fuego"){
                danoPorNivel = danoPorNivel - 2*contrincante.getNivel(); // Pierde contra Agua
            }else if (this.tipo == "Tierra"){
                danoPorNivel = danoPorNivel + 2*this.nivel ;  // Gana contra Agua
            }
        } else if (contrincante.getTipo() == "Fuego"){
            if (this.tipo == "Tierra"){
                danoPorNivel = danoPorNivel - 2*contrincante.getNivel(); // Pierde contra Fuego
            }else if (this.tipo == "Agua"){
                danoPorNivel = danoPorNivel + 2*this.nivel ;  // Gana contra Fuego
            }
        }else if (contrincante.getTipo() == "Tierra") {
            if (this.tipo == "Agua") {
                danoPorNivel = danoPorNivel - 2 * contrincante.getNivel(); // Pierde contra Tierra
            } else if (this.tipo == "Fuego") {
                danoPorNivel = danoPorNivel + 2 * this.nivel;  // Gana contra Tierra
            }
        }

        // Si el daño calculado es negativo, se devuelve 0
        if (danoPorNivel < 0){
            return 0;
        }else{
            return danoPorNivel;  // Devuelve el daño calculado
        }
    }

    /**
     * Aumenta el nivel del Pokémon en 1 y actualiza sus estadísticas.
     */
    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();  // Se actualizan las estadísticas al subir de nivel
    }

    /**
     * Actualiza el aguante del Pokémon según su nivel.
     * El aguante es calculado como nivel * 2.5 (redondeado).
     */
    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    /**
     * Disminuye el aguante del Pokémon en 1.
     */
    public void disminuirAguante(){
        this.aguante--;
    }

    /**
     * Devuelve una representación en cadena del Pokémon, con su nombre, tipo, nivel y aguante.
     *
     * @return La representación en cadena del Pokémon.
     */
    public String toString(){
        return "Nombre: " + this.nombre +
                "\n Tipo: " + this.tipo +
                "\n Nivel: " + this.nivel +
                "\n Aguante: " + this.aguante;
    }
}