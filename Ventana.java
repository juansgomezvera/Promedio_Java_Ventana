package promediocsvenventana;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

 
public class Ventana extends JFrame implements ActionListener {
 
    public Ventana(){
        
        //Para poder cerrar la ventana
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 
        //Se agrega un panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
 
        //Se crea el editor de texto y se agrega a un scroll
        txp = new JTextPane();
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView( txp );
        jsp.setBounds(535, 70, 400, 380);//editamos tamaño y posición.
        panel.add(jsp);//añadimos al panel.
 
        //Se crea un boton para abrir el archivo
        JButton btn = new JButton( "Sacar Promedio" );//lo que dice el botón.
        btn.addActionListener( this );//le añadimos el oyente de accion.
        btn.setBounds(65, 70, 400, 200);//editamos tamaño y posición.
        panel.add(btn);//añadimos al panel.
        
        //Se crea las etiquetas
        JLabel eti1 = new JLabel();
        eti1.setText("Al momento de seleccionar el arhivo");//lo que dice la etiqueta
        eti1.setHorizontalAlignment(SwingConstants.CENTER);//pisición horizontal.
        eti1.setBounds(105, 275, 300, 80);//aqui se edita posicion y tamaño.
        panel.add(eti1);//se añade al panel.
        
        //se hace lo mismo con el resto de etiquetas.
        
        JLabel eti2 = new JLabel();
        eti2.setText("debe buscar en la carpeta");
        eti2.setHorizontalAlignment(SwingConstants.CENTER);
        eti2.setBounds(105, 290, 300, 80);
        panel.add(eti2);
        
        JLabel eti3 = new JLabel();
        eti3.setText("en la cual se encuentra el programa,");
        eti3.setHorizontalAlignment(SwingConstants.CENTER);
        eti3.setBounds(105, 305, 300, 80);
        panel.add(eti3);
        
        JLabel eti4 = new JLabel();
        eti4.setText("un archivo llamado 'Promedio.txt'.");
        eti4.setHorizontalAlignment(SwingConstants.CENTER);
        eti4.setBounds(105, 320, 300, 80);
        panel.add(eti4);
        
        JLabel tit = new JLabel();
        tit.setText("SACA EL PROMEDIO DE LAS NOTAS!");
        tit.setHorizontalAlignment(SwingConstants.CENTER);
        tit.setBounds(100, 10, 800, 30);
        tit.setForeground(Color.BLUE);//cambiamos el color de las letras
        tit.setOpaque(true); //le ponemos fondo
        tit.setBackground(Color.WHITE); //cambiamos el color del fondo
        tit.setFont(new Font("cooper black",0,40)); //editamos el tamaño de las letras y la fuente.
        panel.add(tit);
        
        
        //Tamaño de la ventana
        setSize( 1000, 500 );
 
        //Esto sirve para centrar la ventana
        setLocationRelativeTo( null );
   
        //Hacemos visible la ventana
        setVisible( true );
    }
 //ahora se creará la clase del oyente de acción y el buscador de archivo.
    public void actionPerformed( ActionEvent e ){
        JButton btn = (JButton)e.getSource();
        if( btn.getText().equals( "Sacar Promedio" ) )
        {
            if( abrirArchivo == null ) abrirArchivo = new JFileChooser();
//            Con esto solamente podamos abrir archivos, seleccionaremos el archivo 
//            "Promedio.txt" creado por la clase PromedioCSVenVentana.java
            abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
 
            int seleccion = abrirArchivo.showOpenDialog( this );
                
            if( seleccion == JFileChooser.APPROVE_OPTION )
            {
                File f = abrirArchivo.getSelectedFile();
                try
                {
                    String nombre = f.getName();
                    String path = f.getAbsolutePath();
                    String contenido = getArchivo( path );
                    //Colocamos en el titulo de la aplicacion el 
                    //nombre del archivo
                    this.setTitle( nombre );
 
                    //En el editor de texto colocamos su contenido
                    txp.setText( contenido );
 
                }catch( Exception exp){}
            }
        }
    }
    //-----------------------------------------------------------------------------//
 
    //Aquí se crea la clase para extraer los datos del archivo.
    public String getArchivo( String ruta ){
        FileReader fr = null;
        BufferedReader br = null;
        //Cadena de texto donde se guardara el contenido del archivo
        String contenido = "";
        try
        {
            //ruta puede ser de tipo String o tipo File
            fr = new FileReader( ruta );
            br = new BufferedReader( fr );
 
            String linea;
            //Obtenemos el contenido del archivo linea por linea
            while( ( linea = br.readLine() ) != null ){ 
                contenido += linea + "\n";
            }
 
        }catch( Exception e ){  }
        //finally se utiliza para que si todo ocurre correctamente o si ocurre 
        //algun error se cierre el archivo que anteriormente abrimos
        finally
        {
            try{
                br.close();
            }catch( Exception ex ){}
        }
        return contenido;
    }
 
    JTextPane txp;
    JFileChooser abrirArchivo;
}