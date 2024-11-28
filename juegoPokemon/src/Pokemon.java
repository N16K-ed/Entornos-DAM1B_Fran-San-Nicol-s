public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;

// Añada los constructores********************
    public Pokemon (String qNombre, String qTipo){
        this.nombre = qNombre;
        this.tipo = qTipo;
        this.nivel = 1;
        this.actualizarStats();
    } //Pokémon jugador

    public Pokemon (String qNombre, String qTipo, int qNivel){
        this.nombre = qNombre;
        this.tipo = qTipo;
        this.nivel = qNivel;
        this.actualizarStats();
    } // Pokémon rival
// ******************************************

    public int getAguante() {
        return aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int calcularPoder(Pokemon contrincante){
        int danoPorNivel = ((int)(Math.random()*8)+3) * this.nivel;

        if(contrincante.getTipo() == "Agua" ){
            if (this.tipo == "Fuego"){
                danoPorNivel = danoPorNivel - 2*contrincante.getNivel(); //Pierde tipos
            }else if (this.tipo == "Tierra"){
                danoPorNivel = danoPorNivel + 2*this.nivel ;  //Gana tipos
            }
        } else if (contrincante.getTipo() == "Fuego"){
            if (this.tipo == "Tierra"){
                danoPorNivel = danoPorNivel - 2*contrincante.getNivel(); //Pierde tipos
            }else if (this.tipo == "Agua"){
                danoPorNivel = danoPorNivel + 2*this.nivel ;  //Gana tipos
            }
        }else if (contrincante.getTipo() == "Tierra") {
            if (this.tipo == "Agua") {
                danoPorNivel = danoPorNivel - 2 * contrincante.getNivel(); //Pierde tipos
            } else if (this.tipo == "Fuego") {
                danoPorNivel = danoPorNivel + 2 * this.nivel;  //Gana tipos
            }
        }if (danoPorNivel < 0){
            return 0;
        }else{
            return danoPorNivel;
        }

    }

    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();
    }

    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    public void disminuirAguante(){
        this.aguante--;
    }

    public String toString(){
        return "Nombre: " + this.nombre +
                "\n tipo: " + this.tipo +
                "\n nivel: " + this.nivel +
                "\n aguante " + this.aguante;
    }

}
