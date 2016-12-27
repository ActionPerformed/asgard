package main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Muestra un diálogo que permite al usuario cambiar el idioma dentro del juego
 * 
 * @author ActionPerformed
 * @version 1.0, 6 Jun 2014
 */
public final class DialogoOpciones extends javax.swing.JDialog {

	private static final long serialVersionUID = 2389985809374503294L;
	private DialogoMenu dialogoMenu;
    
    /**
     * Constructor de <code>DialogoOpciones</code>
     * @param parent <code>Frame</code> padre del diálogo 
     * @param modal
     */
    public DialogoOpciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initMoreComponents();
        configurarIdioma();
    }
    
    /**
     * Configura la fuente y el tamaño del texto a mostrar.
     */
    public void initMoreComponents(){
        try {
            //FUENTE CC-BY --> http://fontstruct.com/fontstructions/show/pixel_unicode
            InputStream is = getClass().getResourceAsStream("/fonts/Pixel-UniCode.ttf");
            Font fuenteDialogo = Font.createFont(Font.TRUETYPE_FONT, is);
            Libs.getInstance().formatearComponente(this.btVolver,fuenteDialogo,24);
            Libs.getInstance().formatearComponente(this.btGuardar,fuenteDialogo,24);
            Libs.getInstance().formatearComponente(this.lbTituloOpciones,fuenteDialogo,36);
            Libs.getInstance().formatearComponente(this.lbIdioma,fuenteDialogo,18);

            cbIdioma.setModel(
                new DefaultComboBoxModel<String>(
                    new String[] { 
                        ResourceBundle.getBundle("localizacion.Menus", configuracion.Parametros.getInstance().getLocalizacion()).getString("es"), 
                        ResourceBundle.getBundle("localizacion.Menus", configuracion.Parametros.getInstance().getLocalizacion()).getString("en")
                    }
                )
             );
                    
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(DialogoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Ajusta, al idioma seleccionado, el texto de las diversas opciones
     */
    public void configurarIdioma(){
        this.btVolver.setText (ResourceBundle.getBundle("localizacion.Menus", configuracion.Parametros.getInstance().getLocalizacion()).getString("volver"));
        this.lbIdioma.setText (ResourceBundle.getBundle("localizacion.Menus", configuracion.Parametros.getInstance().getLocalizacion()).getString("idioma"));
        this.btGuardar.setText (ResourceBundle.getBundle("localizacion.Menus", configuracion.Parametros.getInstance().getLocalizacion()).getString("guardar"));
        this.lbTituloOpciones.setText (ResourceBundle.getBundle("localizacion.Menus", configuracion.Parametros.getInstance().getLocalizacion()).getString("opciones"));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        lbTituloOpciones = new javax.swing.JLabel();
        jPanel1 = new JPanel();
        lbIdioma = new JLabel();
        cbIdioma = new JComboBox<>();
        btVolver = new JButton();
        btGuardar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        lbTituloOpciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTituloOpciones.setText("OPCIONES");

        lbIdioma.setText("Idioma: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbIdioma))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        btVolver.setText("Volver");
        btVolver.addActionListener(e -> btVolverActionPerformed(e));

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(e -> btGuardarActionPerformed(e));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTituloOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra los diálogos y vuelve al juego
     * @param evt 
     */
    private void btVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVolverActionPerformed
        this.dispose();
        dialogoMenu.panelJuego.getPersonaje().setHayDialogo(false);
        dialogoMenu.dispose();
    }//GEN-LAST:event_btVolverActionPerformed
    /**
     * Guarda la selección de idioma y vuelve al juego
     * @param evt 
     */
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        switch (cbIdioma.getSelectedIndex()){
            case 0: //español
                configuracion.Parametros.getInstance().setLocalizacion(new Locale("es"));
                break;
            case 1: //ingles
                configuracion.Parametros.getInstance().setLocalizacion(new Locale("en"));
                break;
        }
        this.dispose();
        dialogoMenu.panelJuego.getPersonaje().setHayDialogo(false);
        dialogoMenu.dispose();
    }//GEN-LAST:event_btGuardarActionPerformed
    
    /**
     * Devuelve un objeto de tipo <code>DialogoMenu</code>
     * @param dialogoMenu Objeto de tipo <code>DialogoMenu</code>
     * @see DialogoMenu
     */
    public void setDialogoMenu(DialogoMenu dialogoMenu) {
        this.dialogoMenu = dialogoMenu;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogoOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoOpciones dialog = new DialogoOpciones(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btGuardar;
    private JButton btVolver;
    private JComboBox<String> cbIdioma;
    private JPanel jPanel1;
    private JLabel lbIdioma;
    private JLabel lbTituloOpciones;
    // End of variables declaration//GEN-END:variables
}
