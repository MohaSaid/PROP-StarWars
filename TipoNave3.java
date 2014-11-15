import java.util.*;

//TIPO 3

public class TipoNave3 extends Nave{
	public static int consumo;
	public static boolean definido = false;

	public static boolean ErrorTipografico(int i) {  
        	return (i<=0);
	} 
	//pre:cierto
	//post: el tipo de nave 3 queda definido pasando a tener consumo c asignado
	/**
	 * metodo que define el tipo de nave 3 asignandole un consumo
	 * @param c
	 * @throws Exception
	 */
	public static void DefinirTipo(int c) throws Exception{
		if(ErrorTipografico(c)){
			throw new Exception("Error: el consumo debe ser mayor que 0\n");
		}
			consumo = c;
			definido = true;
	}
	//pre: cierto
	//post: crea una nave de tipo 3 vacía
	/**
	 * metodo que crea una nave de tipo 3 vacía
	 */
	public TipoNave3(){
		ident = -1;
		destino =-1;
		origen = -1;
	}
	//pre:cierto;
	//Post: Crea una nave de tipo 3 a partir de una sin tipo
	/**
	 * metodo que crea una nave de tipo 3 a partir de una nave sin tipo
	 * @param n
	 * @throws Exception
	 */
	public TipoNave3(Nave n) throws Exception{
		ident = n.consultar_id();
		destino = n.consultar_destino();
		origen = n.consultar_origen();
	}

	//pre: cierto
	//post: crea una nave de tipo 3 inicializada
	/**
	 * metodo que crea una nave de tipo 3 con identificador, destino y origen
	 * @param id
	 * @param d
	 * @param o
	 * @throws Exception
	 */
	public TipoNave3(int id,int d, int o) throws Exception{
		if(ErrorTipograficoID(id)){
			throw new Exception("Error: El identificador del tipo debe ser mayor o igual que 0\n");
		}
		if(ErrorTipografico(d)){
			throw new Exception("Error: El identificador del planeta destino debe ser mayor o igual que 0\n");
		}
		if(ErrorTipograficoID(o)){
			throw new Exception("Error: El identificador del planeta origen debe ser mayor o igual que 0\n");
		}
		if(!definido){
			throw new Exception("Error: el tipo de nave 3 no ha sido definido\n");
		}
		ident = id;
		destino = d;
		origen = o;
	}
	
	//Pre:cierto
		//Post devuelve el estado del tipo de nave.
	/**
	 * metodo que crea consulta si el tipo 3 está definido
	 */
		public boolean EstaDefinido(){
			return definido;
		}
		
	//pre: cierto
	//post: retorna el nombre que identifica al tipo
		/**
		 * metodo que consulta el tipo de una nave
		 * @throws Exception
		 */
	public int consultar_tipo() throws Exception{
		return 1;
	}

	//pre: cierto
	//post: retorna el consumo asociado al tipo
	/**
	 * metodo que consulta el consumo asociado al tipo de nave 3
	 * @throws Exception
	 */
	public int consultar_consumo() throws Exception{
		if(consumo == 0){
		throw new Exception("Error: El tipo de nave no tiene un consumo asociado\n");	
	}
		return consumo;
	}

	//pre: cierto
	//post: modifica el consumo asociado al tipo de nave
	public static void modificar_consumo(int c) throws Exception{
		if(ErrorTipografico(c)){
			throw new Exception("Error: El consumo debe de ser superior a 0\n");	
		}
		consumo = c;
	}
}

class OrdenTipoNave3 implements Comparator<TipoNave3>{
    public int compare(TipoNave3 n1, TipoNave3 n2){
        try{
            if(n2.consultar_id() < n1.consultar_id()) return 1;
            else return -1;
        }
        catch(Exception e){
            System.out.print(e);
        }
        return 0;
    }
}
