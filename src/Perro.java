import java.util.ArrayList;
import java.util.List;

public class Perro {
    private static int contador = 1;
    private int id;
    private String nombre;
    private String raza;
    private int edadMeses;
    private String tamano; // PEQUENO, MEDIANO, GRANDE
    private boolean vacunado;
    private boolean esterilizado;
    private boolean adoptado;
    private String adoptante;

    // LISTA - BASE DE DATOS EN MEMORIA
    public static List<Perro> listaPerros = new ArrayList<>();

    // CONSTRUCTOR VACIO
    public Perro () {
        this.id = contador++;
    }

    // CONSTRUCTOR CON TODOS LOS PARAMETROS
    public Perro(String nombre, String raza, int edadMeses, String tamano, boolean vacunado, boolean esterilizado) {
        this.id = contador++;
        this.nombre = nombre;
        this.raza = raza;
        this.edadMeses = edadMeses;
        this.tamano = tamano.toUpperCase();
        this.vacunado = vacunado;
        this.esterilizado = esterilizado;
        this.adoptado = false;
        this.adoptante = null;
    }

    // GETTERS Y SETTERS
    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Perro.contador = contador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(int edadMeses) {
        this.edadMeses = edadMeses;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public boolean isEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public String getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(String adoptante) {
        this.adoptante = adoptante;
    }

    // METODOS PROPIOS
    public void vacunar() {
        this.vacunado = true;
    }

    public void esterilizar() {
        this.esterilizado = true;
    }

    public boolean marcarAdoptado(String adoptante) {
        if (!this.adoptado) {
            this.adoptado = true;
            this.adoptante = adoptante;
            return true;
        }
        return false;
    }

    public int calcularEdadHumanaAprox() {
        return (this.edadMeses / 12) * 7;
    }

    public boolean aptoParaDepartamento() {
        if (tamano.equals("PEQUENO") && vacunado) {
            return true;
        } else if (tamano.equals("MEDIANO") && vacunado) {
            return true;
        } else if (tamano.equals("GRANDE") && vacunado) {
            return false; // NO APTO
        } else if (tamano.equals("GRANDE") && !vacunado) {
            return false; // NO APTO
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nPerro{" +
                "ID =" + id +
                " / NOMBRE ='" + nombre + '\'' +
                " / RAZA ='" + raza + '\'' +
                " / EDAD EN MESES =" + edadMeses +
                " / TAMAÑO ='" + tamano + '\'' +
                " / VACUNADO =" + vacunado +
                " / ESTERILIZADO =" + esterilizado +
                " / ADOPTADO =" + adoptado +
                " / ADOPTANTE ='" + adoptante + '\'' +
                '}';
    }
}
