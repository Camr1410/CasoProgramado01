
package vista;

import controlador.Controlador_FRM_MantenimientoCursos;
import javax.swing.JOptionPane;
import modelo.Verificador;

public class Panel_Cursos extends javax.swing.JPanel {

    Controlador_FRM_MantenimientoCursos controlador;
    Verificador verificador;
    
    public Panel_Cursos() {
        initComponents();
        cargarCreditos();
        desabilitarCampos();
    }
    
    public void agregarEventos(Controlador_FRM_MantenimientoCursos controlador,Verificador verificador)
    {
        this.btn_ConsultaRapida.addActionListener(controlador);
        this.controlador=controlador;
        this.verificador=verificador;
    }
    public void cargarCreditos() 
    {
        this.jcb_Creditos.removeAllItems();
        for(int contador=0;contador<=10;contador++)
        {
            this.jcb_Creditos.addItem(""+contador);
        }
        this.jcb_Creditos.setSelectedIndex(4);
    }
    public String devolverSigla() 
    {
        if(verificador.verificarCampoTexto(verificador.quitarEspacios(jt_Sigla.getText())))
        {
            return verificador.quitarEspacios(jt_Sigla.getText());
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Debe rellenar el espacio de Sigla");
            jt_Sigla.setText("");
            return null;
        }
    }
    public void habilitarEdicion()
    {
        this.jt_Sigla.setEditable(false);
        this.jt_NombreCurso.setEnabled(true);
        this.jcb_Creditos.setEnabled(true);
        this.jt_Horario.setEnabled(true);
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_NombreCurso.setText(arreglo[0]);
        this.jcb_Creditos.setSelectedIndex(Integer.parseInt(arreglo[1]));
        this.jt_Horario.setText(arreglo[2]);
    }
    public void mostrarInformacionXML(String arreglo[])
    {
        this.jt_NombreCurso.setText(arreglo[1]);
        this.jcb_Creditos.setSelectedIndex(Integer.parseInt(arreglo[2]));
        this.jt_Horario.setText(arreglo[3]);
    }
    public void habilitarCampos()
    {
        this.jt_NombreCurso.setEnabled(true);
        this.jcb_Creditos.setEnabled(true);
        this.jt_Horario.setEnabled(true);
    }
    public String[] devolverInformacion()
    {
        String informacion[]=new String[4];
        if(verificador.verificarCampoTexto(verificador.quitarEspacios(jt_Sigla.getText())))
        {
           informacion[0]=this.jt_Sigla.getText(); 
           informacion[2]=""+this.jcb_Creditos.getSelectedIndex();
        }
        else
        {
            informacion=null;
            JOptionPane.showMessageDialog(null,"Debe rellenar el espacio de Sigla");
            this.jt_Sigla.setText("");
        }
        if(verificador.verificarLetras(jt_NombreCurso.getText()) && verificador.verificarCampoTexto(jt_NombreCurso.getText()))
        {
            informacion[1]=this.jt_NombreCurso.getText();
            informacion[2]=""+this.jcb_Creditos.getSelectedIndex();
        }
        else
        {
            informacion=null;
            JOptionPane.showMessageDialog(null,"El nombre del curso solo puede contener letras");
            this.jt_NombreCurso.setText("");
        }
        if(verificador.verificarCampoTexto(jt_Horario.getText()))
        {
            informacion[2]=""+this.jcb_Creditos.getSelectedIndex();
            informacion[3]=this.jt_Horario.getText();
        }
        else
        {
            informacion=null;
            JOptionPane.showMessageDialog(null,"Debe rellenar el espacio de Horario");
            this.jt_Horario.setText("");
        }
        
        return informacion;
    }
    public void limpiarCampos()
    {
        this.jt_Sigla.setText("");
        this.jt_Sigla.setEditable(true);
        this.jt_NombreCurso.setText("");
        this.jt_NombreCurso.setEnabled(false);
        this.jcb_Creditos.setSelectedIndex(4);
        this.jcb_Creditos.setEnabled(false);
        this.jt_Horario.setText("");
        this.jt_Horario.setEnabled(false);
    }
    public void desabilitarCampos()
    {
        this.jt_NombreCurso.setEnabled(false);
        this.jcb_Creditos.setEnabled(false);
        this.jt_Horario.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Sigla = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jl_NombreCurso = new javax.swing.JLabel();
        jt_NombreCurso = new javax.swing.JTextField();
        jl_Creditos = new javax.swing.JLabel();
        jcb_Creditos = new javax.swing.JComboBox<>();
        jl_Horario = new javax.swing.JLabel();
        jt_Horario = new javax.swing.JTextField();
        btn_ConsultaRapida = new javax.swing.JButton();

        jl_Sigla.setText("Sigla");

        jl_NombreCurso.setText("Nombre");

        jl_Creditos.setText("Créditos");

        jcb_Creditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jl_Horario.setText("Horario");

        btn_ConsultaRapida.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN1\\Documents\\UCR\\Progra 2\\img\\buscar.png")); // NOI18N
        btn_ConsultaRapida.setActionCommand("ConsultaRapida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_Horario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_Horario))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_NombreCurso)
                            .addComponent(jl_Sigla))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_ConsultaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_Creditos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcb_Creditos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ConsultaRapida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_Sigla))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreCurso)
                    .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Creditos)
                    .addComponent(jcb_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Horario)
                    .addComponent(jt_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaRapida;
    private javax.swing.JComboBox<String> jcb_Creditos;
    private javax.swing.JLabel jl_Creditos;
    private javax.swing.JLabel jl_Horario;
    private javax.swing.JLabel jl_NombreCurso;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Horario;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_Sigla;
    // End of variables declaration//GEN-END:variables
}
