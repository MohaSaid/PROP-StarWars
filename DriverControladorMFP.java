import java.util.Scanner;



public class DriverControladorMFP{
    public void Executa(Scanner sc, ControladorMFP cMFP,ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp) {
        int op;

        
                		System.out.print("Opciones: \n\n"
		     +"---------------------------------------------------------------------------------\n"
      	     +"-                                 OPCIONES                                      -\n"
   	         +"-                     [opcion   Operacion(Atributos)]                           -\n"
             +"---------------------------------------------------------------------------------\n"
             +"-                                                                               -\n"
             +"-   0   Salir del DriverNave                                                    -\n"
             +"-   1   TestSeleccionarFC(int i)                                                -\n"
             +"-   2   TestSeleccionarAlgoritmo(int i)                                         -\n"
             +"-   3   Mostrar solucion                                                        -\n"
             +"-   4   Mostrar solucion parcial                                                -\n"
             +"-                                                                               -\n"
             +"---------------------------------------------------------------------------------\n");

        op = sc.nextInt(); 
                
        while(op != 0){
            switch (op) {
            case 1: TestSeleccionarFC(sc,cMFP,cg,cr,cp);break;
            case 2: TestSeleccionarAlgoritmo(sc,cMFP);break;
            //case 3: TestConsultarSalida(cMFP);break;
            //case 4: TestConsultarCambios(cMFP);break;
            default: System.out.println("Opción incorrecta");
            }
    op = sc.nextInt(); 
    }
   }
    public static void TestSeleccionarFC(Scanner sc, ControladorMFP cMFP, ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp){
    	try{
	    	System.out.print("Opciones:\n\n"
	    			+"-----------------------------------------------\n"
	         	    +"-             OPCIONES                        -\n"
	      	        +"-     [opcion   Operacion(Atributos)]         -\n"
	                +"-----------------------------------------------\n"
	                +"-                                             -\n"
	                +"-   1   Flujo                                 -\n"
	                +"-   2   Distancia                             -\n"
	                +"-   3   Precio                                -\n"
	                +"-                                             -\n"
	                +"-----------------------------------------------\n");
	    	int i = sc.nextInt();
	    	if(i<1 || i>3) throw new Exception("Error: Opcion incorrecta");
	    	cMFP.InitEntrada(cg,cr,cp);
	    	cMFP.SeleccionarFC(i,cg,cr,cp);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    public static void TestSeleccionarAlgoritmo(Scanner sc, ControladorMFP cMFP){
    	try{
	    	System.out.print("Opciones:\n\n"
	    			+"-----------------------------------------------\n"
	         	    +"-             OPCIONES                        -\n"
	      	        +"-     [opcion   Operacion(Atributos)]         -\n"
	                +"-----------------------------------------------\n"
	                +"-                                             -\n"
	                +"-   1   FordFulkerson con BFS                 -\n"
	                +"-   2   FordFulkerson con Dijkstra            -\n"
	                +"-   3   PushRelabel                           -\n"
	                +"-                                             -\n"
	                +"-----------------------------------------------\n");
	    	int i = sc.nextInt();
	    	if(i<1 || i>3) throw new Exception("Error: Opcion incorrecta");
	    	cMFP.SeleccionarAlgoritmo(i);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
}