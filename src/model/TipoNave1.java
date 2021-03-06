//TIPO 1:

public class TipoNave1 extends Nave {
    private static int consumo;
    private static boolean definido = false;

    //pre:cierto
    //post: el tipo de nave 1 queda definido pasando a tener consumo c asignado

    /**
     * metodo que define el tipo de nave 1 asignandole un consumo
     *
     * @param c
     * @throws Exception
     */
    public static void DefinirTipo(int c) throws Exception {
        if (ErrorTipografico(c)) {
            throw new Exception("Error: el consumo debe ser mayor que 0\n");
        }
        consumo = c;
        definido = true;
    }

    public static void Desdefinir() {
        definido = false;
    }
    //pre: cierto
    //post: crea una nave de tipo 1 inicializada

    /**
     * metodo que crea una nave de tipo1 con identificador, destino y origen
     *
     * @param id
     * @param d
     * @param o
     * @throws Exception
     */
    public TipoNave1(int id, String d, String o) throws Exception {
        if (ErrorTipograficoID(id)) {
            throw new Exception("Error: El identificador del tipo debe ser mayor o igual que 0\n");
        }
        if (!alfa_numeric(d)) {
            throw new Exception("Error: El identificador del planeta destino ha de ser alfa numerico\n");
        }
        if (!alfa_numeric(o)) {
            throw new Exception("Error: El identificador del planeta destino ha de ser alfa numerico\n");
        }

        if (!definido) {
            throw new Exception("Error: el tipo de nave 1 no ha sido definido\n");
        }
        ident = id;
        destino = d;
        origen = o;
    }
    //Pre:cierto
    //Post devuelve el estado del tipo de nave.

    /**
     * metodo que crea consulta si el tipo 1 está definido
     */
    public static boolean EstaDefinido() {
        return definido;
    }
    //pre: cierto
    //post: retorna el nombre que identifica al tipo

    /**
     * metodo que consulta el tipo de una nave
     *
     * @throws Exception
     */
    public int consultar_tipo() {
        return 1;
    }

    //pre: cierto
    //post: retorna el consumo asociado al tipo

    /**
     * metodo que consulta el consumo asociado al tipo de nave 1
     *
     * @throws Exception
     */
    public static int consultar_consumo() {
        return consumo;
    }

    //pre: cierto
    //post: modifica el consumo asociado al tipo de nave

    /**
     * metodo que modifica el consumo asociado al tipo de nave 1
     *
     * @param c
     * @throws Exception
     */
    public static void modificar_consumo(int c) throws Exception {
        if (ErrorTipografico(c)) {
            throw new Exception("Error: El consumo debe de ser superior a 0\n");
        }
        consumo = c;
    }
}





