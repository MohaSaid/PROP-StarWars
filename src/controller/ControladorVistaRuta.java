import java.util.ArrayList;
import java.util.Scanner;

public class ControladorVistaRuta {
    private ControladorRuta CR;
    private VistaRuta VR;
    private ControladorPlaneta CP;

    ControladorVistaRuta() {
        CR = new ControladorRuta();
        VR = new VistaRuta(this);
    }

    public VistaRuta ConsultarVistaRuta() {
        return VR;
    }

    public ArrayList<String> ConsultarIdsRutas(int i) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<Integer> aux = CR.Consultar_ids_rutas();
        int j = 0;
        while (i < aux.size() && j < 100) {
            String a = "" + aux.get(i);
            res.add(a);
            ++j;
            ++i;
        }
        return res;
    }

    public ArrayList<String> ConsultarIdsRutas_string() {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<Integer> aux = CR.Consultar_ids_rutas();
        for (int i = 0; i < aux.size(); ++i) {
            String s = "" + aux.get(i);
            res.add(s);
        }
        return res;
    }

    public void inicialitza(ControladorVistaPlaneta cVP) {
        CP = cVP.ConsultarControladorPlaneta();
    }

    public ControladorRuta consultarControladorRuta() {
        return CR;
    }

    public VistaRuta obterVistaRuta() {
        return VR;
    }

    public ArrayList<String> obtenerIdRutas() throws Exception {
        ArrayList<String> llistat = new ArrayList<String>();
        int i = 0;
        int n = CR.Consultar_numero_rutes();
        String s = "";
        while (i < n) {
            s += (CR.Consultar_ids_rutas_string(i));
            i += 100;
        }
        Scanner scan = new Scanner(s);
        scan.useDelimiter("#");
        while (scan.hasNext()) {
            llistat.add(scan.next());
        }
        scan.close();
        return llistat;
    }

    public void creaRuta(String _id, String _capacidad, String _distancia, String planetaA, String planetaB) throws Exception {
        int id = Integer.parseInt(_id);
        int capacidad = Integer.parseInt(_capacidad);
        int distancia = Integer.parseInt(_distancia);
        CR.CrearRuta(id, capacidad, distancia, planetaA, planetaB, CP);
    }

    public void creaRutaAut() throws Exception {
        CR.CrearRuta_automatica(CP);
    }

    public void creaRutaAut_id(String _id) throws Exception {
        int id = Integer.parseInt(_id);
        CR.CrearRuta_automatica(CP, id);
    }

    public String ConsultarCapacidadRuta(String id) throws Exception {
        int i = Integer.parseInt(id);
        return Integer.toString(CR.ConsultarCapacidadRuta(i));
    }

    public String ConsultarDistanciaRuta(String id) throws Exception {
        int i = Integer.parseInt(id);
        return Integer.toString(CR.ConsultarDistanciaRuta(i));
    }

    public int ConsultarNumeroRutes() {
        return CR.Consultar_numero_rutes();
    }

    public String ConsultarPlanetaARuta(String id) throws Exception {
        int i = Integer.parseInt(id);
        return CR.ConsultarPlanetaARuta(i);
    }


    public String ConsultarPlanetaBRuta(String id) throws Exception {
        int i = Integer.parseInt(id);
        return CR.ConsultarPlanetaBRuta(i);
    }

    public void ModificarCapacidadRuta(String id, String capacidad_nueva) throws Exception {
        int i = Integer.parseInt(id);
        int c = Integer.parseInt(capacidad_nueva);
        CR.ModificarCapacidadRuta(i, c);
    }

    public void ModificarDistanciaRuta(String id, String distancia_nueva) throws Exception {
        int i = Integer.parseInt(id);
        int d = Integer.parseInt(distancia_nueva);
        CR.ModificarDistanciaRuta(i, d);
    }

    public void ModificarPlanetaARuta(String id, String id_planetaA_nuevo) throws Exception {
        int i = Integer.parseInt(id);
        CR.ModificarPlanetaARuta(i, id_planetaA_nuevo, CP);
    }

    public void GuardarRutas(String path) throws Exception {
        CR.GuardarRutas(path);
    }

    public void CargarRutas(String path) throws Exception {
        CR.CargarRutas(path, CP);
    }

    public void ModificarPlanetaBRuta(String id, String id_planetaB_nuevo) throws Exception {
        int i = Integer.parseInt(id);
        CR.ModificarPlanetaARuta(i, id_planetaB_nuevo, CP);
    }

    public void eliminarRuta(String id) throws Exception {
        int i = Integer.parseInt(id);
        CR.BorrarRuta(i);
    }

    public void clear() {
        CR.BorrarRutas();
    }
}
