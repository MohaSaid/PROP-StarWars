
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
 
 
public class VistaPlaneta extends JPanel {
    
    //Componentes vista
    private ControladorVistaPlaneta CVP;
    private ArrayList<String> listado;
    private DefaultListModel<String> mlistado;
    private DefaultListModel<String> mlistadoPlanetas;
    private JComboBox<String> CBPlanetas;
   
    //Cajas Atributos
    private JTextField NombreAc;
    private JTextField CosteAc;
    private JTextField CoordenadaXAc;
    private JTextField CoordenadaYAc;
    private JTextField CosteNew;
    private JTextField CoordenadaXNew;
    private JTextField CoordenadaYNew;
    
    //Errores
    private JTextField Errores;
    
    //Cargar y Guardar
    private JFileChooser Cargar;
    private JFileChooser Guardar;
    
    //PRIMER NIVEL???
    private JTabbedPane Central;
    
    //Paneles
    private Panel PanelCreacion;
    private Panel PanelModificar;
    private Panel PanelConsultar;
    private Panel PanelGuardar;
    private Panel PanelCargar;
    private JScrollPane ScrollPlanetasConsulta;
    
    //Etiquetas
    private JLabel ENombre;
    private JLabel ECoste;
    private JLabel ECoordenadaX;
    private JLabel ECoordenadaY;
    private JLabel ECosteNew;
    private JLabel ECoordenadaXNew;
    private JLabel ECoordenadaYNew;
    private JLabel HelpNombre;
    private JLabel HelpCoste;
    private JLabel HelpCoordenadas;
    
    //Botones
    private JButton CrearPlaneta;
    private JButton CrearPlanetaAutoSN;
    private JButton CrearPlanetaAutoCN;
    private JButton Modificar;
    
    //Casillas
    private JRadioButton Manual;
    private JRadioButton Automatico;
    private JRadioButton AutomaticoCN;
    
    //Listas
    private JList<String> listaScroll1;
    private JList<String> listaScroll2;
    private JComboBox <String> CBPConsulta;
    
    public VistaPlaneta ConsultarVistaPlaneta() {
        return this;
    }
    public void actualiza() {
        try {
            mlistado.removeAllElements();
            listado = CVP.ConsultarNombresPlanetas();
            CBPlanetas.removeAllItems();
            CBPlanetas.setEditable(false);
            if (listado.size() != 0) {  
                CBPlanetas.setEditable(true);
                for (String s : listado) CBPlanetas.addItem(s);
                for (String p : listado) mlistado.addElement(p);
                CBPlanetas.revalidate();
                CBPlanetas.repaint();
                listaScroll1.setModel(mlistado);
                listaScroll1.revalidate();
                listaScroll1.repaint();
            }        
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
    public VistaPlaneta(ControladorVistaPlaneta ControladorVP) {
        CVP = ControladorVP;
        setOpaque(false);          
        setBackground(Color.WHITE); //Marco
        setLayout(null);
        
        listado = new ArrayList<String>();
        mlistado = new DefaultListModel<String>();
        mlistadoPlanetas = new DefaultListModel<String>();
        // list 1
        //scrollPanel
        
        CBPlanetas = new JComboBox<String>();
        CBPlanetas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String n = CBPlanetas.getSelectedItem().toString();
                    if(!n.equals("")){
                        Errores.setText("");
                        NombreAc.setText(n);
                        CosteAc.setText(CVP.ConsultarCoste(n));
                        CoordenadaXAc.setText(CVP.ConsultarCoordenadaX(n));
                        CoordenadaYAc.setText(CVP.ConsultarCoordenadaY(n));
                    }   
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        Central = new JTabbedPane(JTabbedPane.TOP);
        Central.setBackground(SystemColor.activeCaption);
        Central.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //A la espera de consenso
        add(Central);
        
        PanelCreacion = new Panel();
        PanelCreacion.setBackground(SystemColor.activeCaption);
        Central.addTab("Crear",null,PanelCreacion,null);
        PanelCreacion.setLayout(null);
        
        Manual = new JRadioButton("Manual");
        Manual.setSelected(false); 
        Manual.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelCreacion.add(Manual);
        
        Automatico = new JRadioButton("Automatico");
        Automatico.setSelected(false);
        Automatico.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelCreacion.add(Automatico);
        
        AutomaticoCN = new JRadioButton("Automatico con Nombre");
        AutomaticoCN.setSelected(false);
        AutomaticoCN.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelCreacion.add(AutomaticoCN);
        
        
        ENombre = new JLabel("Nombre :");
        ENombre.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelCreacion.add(ENombre);
        
        NombreAc = new JTextField();
        NombreAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelCreacion.add(NombreAc);
        NombreAc.setColumns(10);  //??????
        NombreAc.setEnabled(false);
        
        ECoste = new JLabel ("Coste :");
        ECoste.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(ECoste);
        
        CosteAc = new JTextField();
        CosteAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(CosteAc);
        CosteAc.setColumns(10);
        CosteAc.setEnabled(false);
        
        ECoordenadaX = new JLabel("X :");
        ECoordenadaX.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(ECoordenadaX);
        
        CoordenadaXAc = new JTextField();
        CoordenadaXAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(CoordenadaXAc);
        CoordenadaXAc.setColumns(10);
        CoordenadaXAc.setEnabled(false);
                
        ECoordenadaY = new JLabel("Y :");
        ECoordenadaY.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(ECoordenadaX);
        
        CoordenadaYAc = new JTextField();
        CoordenadaYAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(CoordenadaYAc);
        CoordenadaYAc.setColumns(10);
        CoordenadaYAc.setEnabled(false);
        
        Manual.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()) {
                        NombreAc.setEnabled(true);
                        CosteAc.setEnabled(true);
                        CoordenadaXAc.setEnabled(true);
                        CoordenadaYAc.setEnabled(true);
                        Automatico.setSelected(false);
                        AutomaticoCN.setSelected(false);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        Automatico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Automatico.isSelected()) {
                        NombreAc.setEnabled(false);
                        CosteAc.setEnabled(false);
                        CoordenadaXAc.setEnabled(false);
                        CoordenadaYAc.setEnabled(false);
                        Manual.setSelected(false);
                        AutomaticoCN.setSelected(false);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        AutomaticoCN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(AutomaticoCN.isSelected()) {
                        NombreAc.setEnabled(true);
                        CosteAc.setEnabled(false);
                        CoordenadaXAc.setEnabled(false);
                        CoordenadaYAc.setEnabled(false);
                        Manual.setSelected(false);
                        Automatico.setSelected(false);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        CrearPlaneta = new JButton("Crear");
        CrearPlaneta.setIcon(null);
        /*
        HelpNombre = new JLabel("");
        HelpNombre.setToolTipText("El Nombre tiene que estar compuesto por caracteres alfanumericos.");
        HelpNombre.setIcon(null);
        */
        
        CrearPlaneta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()){
                        String n = NombreAc.getText();
                        String c = CosteAc.getText();
                        String x = CoordenadaXAc.getText();
                        String y = CoordenadaYAc.getText();
                        CVP.CrearPlaneta(n, c, x, y);
                        actualiza();
                    }
                    if(Automatico.isSelected()) {
                        CVP.CrearPlaneta();
                        actualiza();
                    }
                    else {
                        String n = NombreAc.getText();
                        CVP.CrearPlaneta(n);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                NombreAc.setText("");
                CosteAc.setText("");
                CoordenadaXAc.setText("");
                CoordenadaYAc.setText("");
            }
        });
     
        CrearPlaneta.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelCreacion.add(CrearPlaneta);
        
        PanelModificar = new Panel();
        PanelModificar.setBackground(SystemColor.activeCaption);
        Central.addTab("Modificar", null,PanelModificar,null);
        PanelModificar.setLayout(null);
        
        ENombre = new JLabel("Nombre :");
        ENombre.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelModificar.add(ENombre);
        
        NombreAc = new JTextField();
        NombreAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelModificar.add(NombreAc);
        NombreAc.setColumns(10);  //??????
        
        ECoste = new JLabel ("Coste :");
        ECoste.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(ECoste);
        
        CosteAc = new JTextField();
        CosteAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        CosteAc.setEnabled(false);
        PanelModificar.add(CosteAc);
        CosteAc.setColumns(10);
        
        ECoordenadaX = new JLabel("X :");
        ECoordenadaX.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(ECoordenadaX);
        
        CoordenadaXAc = new JTextField();
        CoordenadaXAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        CoordenadaXAc.setEnabled(false);
        PanelModificar.add(CoordenadaXAc);
        CoordenadaXAc.setColumns(10);
        
        ECoordenadaY = new JLabel("Y :");
        ECoordenadaY.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(ECoordenadaX);
        
        CoordenadaYAc = new JTextField();
        CoordenadaYAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        CoordenadaYAc.setEnabled(false);
        PanelModificar.add(CoordenadaYAc);
        CoordenadaYAc.setColumns(10);
        
        ECosteNew = new JLabel ("Coste nuevo :");
        ECosteNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(ECosteNew);
        
        CosteNew = new JTextField();
        CosteNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(CosteNew);
        CosteNew.setColumns(10);
        
        ECoordenadaXNew = new JLabel("X :");
        ECoordenadaXNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(ECoordenadaXNew);
        
        CoordenadaXNew = new JTextField();
        CoordenadaXNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(CoordenadaXNew);
        CoordenadaXNew.setColumns(10);
        
        ECoordenadaYNew = new JLabel("Y :");
        ECoordenadaYNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(ECoordenadaXNew);
        
        CoordenadaYNew = new JTextField();
        CoordenadaYNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(CoordenadaYNew);
        CoordenadaYNew.setColumns(10);
        
        Modificar = new JButton("Modificar");
        Modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String nac = NombreAc.getText();
                    String c = CosteNew.getText();
                    String x = CoordenadaXNew.getText();
                    String y = CoordenadaYNew.getText();
                    if(!c.isEmpty()) CVP.ModificarCoste(nac, c);
                    if(!x.isEmpty() && !y.isEmpty()) CVP.ModificarCoordenadas(nac, x, y);
                    else if(x.isEmpty() && !y.isEmpty()) CVP.ModificarCoordenadas(nac, CVP.ConsultarCoordenadaX(nac), y);
                    else if(y.isEmpty() && !x.isEmpty()) CVP.ModificarCoordenadas(nac, x, CVP.ConsultarCoordenadaY(nac));
                    
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                NombreAc.setText("");
                CosteAc.setText("");
                CoordenadaXAc.setText("");
                CoordenadaYAc.setText("");
                CosteNew.setText("");
                CoordenadaXNew.setText("");
                CoordenadaYNew.setText("");
            }
        });
        
        PanelConsultar = new Panel();
        PanelConsultar.setBackground(SystemColor.activeCaption);
        Central.addTab("Consultar",null,PanelConsultar,null);
        PanelConsultar.setLayout(null);
        
        CBPConsulta = new JComboBox<String>();
        CBPConsulta.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(CBPConsulta);
        
        ENombre = new JLabel("Nombre :");
        ENombre.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(ENombre);
        
        NombreAc = new JTextField();
        NombreAc.setColumns(10);
        NombreAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(NombreAc);
        
        ECoste = new JLabel("Coste :");
        ECoste.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(ECoste);
        
        CosteAc = new JTextField();
        CosteAc.setColumns(10);
        CosteAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(CosteAc);
        
        ECoordenadaX = new JLabel("X :");
        ECoordenadaX.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(ECoordenadaX);
        
        CoordenadaXAc = new JTextField();
        CoordenadaXAc.setColumns(10);
        CoordenadaXAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(CoordenadaXAc);
        
        ECoordenadaX = new JLabel("Y :");
        ECoordenadaX.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(ECoordenadaX);
        
        CoordenadaYAc = new JTextField();
        CoordenadaYAc.setColumns(10);
        CoordenadaYAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(CoordenadaYAc);
        
        PanelGuardar = new Panel();
        PanelGuardar.setBackground(SystemColor.activeCaption);
        Central.addTab("Guardar", null, PanelGuardar, null);
        PanelGuardar.setLayout(null);
        
        Guardar = new JFileChooser();
        Guardar.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Guardar.setAutoscrolls(true);
        Guardar.setPreferredSize(new Dimension(WIDTH,WIDTH));
        PanelGuardar.add(Guardar);
        Guardar.setDialogTitle("Guardar");
        
        Guardar.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    String path = Guardar.getSelectedFile().getAbsolutePath();
                    CVP.GuardarPlanetas(path);
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        PanelCargar = new Panel();
        PanelCargar.setBackground(SystemColor.activeCaption);
        Central.addTab("Cargar", null, PanelCargar, null);
        PanelCargar.setLayout(null);
        
        Cargar = new JFileChooser();
        Cargar.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Cargar.setAutoscrolls(true);
        Cargar.setPreferredSize(new Dimension(WIDTH,WIDTH));
        PanelCargar.add(Cargar);
        Cargar.setDialogTitle("Cargr");
        
        Cargar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try{
                    String path = Cargar.getSelectedFile().getAbsolutePath();
                    CVP.CargarPlanetas(path);
                    actualiza();
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
    }
}