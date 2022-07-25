/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notacionpostfija;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author Abiu
 */
public class NotacionPost extends javax.swing.JFrame {
    //Pilas para separar a los operandos de los operadores
    Stack<Nodo> pOperandos = new Stack<Nodo>(); // Stack para guardar a los operandos, al final tendra al arbol
    Stack<String> pOperadores = new Stack<String>(); // Stack para guardar a los operadores
    final String blanco;
    final String operadores;

    /**
     * Creates new form NotacionPost
     */
    public NotacionPost() {
        initComponents();
        blanco = " "; // para espacios en blanco en la expresion recibida
        operadores = ")+-*/%^("; // para identificar a los operadores
    }

    private void guardarSubArbol() { // metodo que entra una vez encontrado un conjunto en unos parentesis para asignar el padre y los hijos (.....)
        Nodo op1 = (Nodo) pOperandos.pop(); //derecho
        Nodo op2 = (Nodo) pOperandos.pop(); // izquierdo
        pOperandos.push(new Nodo(op1, pOperadores.pop(), op2)); // se les asigna a su padre
    }
    private Nodo raiz; // nodo raiz que tendra el arbol
    
    public Nodo realizarArbol(String expresion) {
        StringTokenizer tokenizer; // Permite dividir la expresion
        String token; // Para guardar el caracter a analizar

        tokenizer = new StringTokenizer(expresion, blanco + operadores, true);// Dividimos la expresion ingresada en tokens y las separamos, tomando en cuenta a los delimitadores que son los
        //operandos, true es para que utilice los delimitadores como tokens
        
        // Dentro de este ciclo se resuelve lo de los parentesis si es que hay, y se separan los operandos de los operadores
        while (tokenizer.hasMoreTokens()) { // Ciclo mientras existan mas tokens en la variable 

            token = tokenizer.nextToken(); // Tomamos la siguiente variable del objeto StringTokenizer 

            if (token.contains(" "));// si es un espacio en blanco lo que recibimos, lo ignoramos 
            else if (!operadores.contains(token)) { // si el token no es un operador lo guarda como operando
                pOperandos.push(new Nodo(token)); // guardamos el operando como un nodo del arbol
            } 
            else if (token.equals(")")) { // si encuentra uno de cierre, para asignar al operador sus hijos
                while (!pOperadores.empty() && !pOperadores.peek().equals("(")) { //Se guarda lo que esta dentro de los parentesis, hasta encontrar en la pila un( de cierre
                    guardarSubArbol(); // guardamos a los operandos, izquierdo y derecho, asignamos nodo padre e hijos
                }
                pOperadores.pop(); // saca el operador que ya tiene hijos asignados, o en su defecto al parentesis ( de la (..)
            } else {
                if (!token.equals("(") && !pOperadores.empty()) { //sin parentesis
                    String op = (String) pOperadores.peek();
                    while (!op.equals("(") && !pOperadores.empty() && operadores.indexOf(op) >= operadores.indexOf(token)) {
                        guardarSubArbol();
                        if (!pOperadores.empty()) {
                            op = (String) pOperadores.peek();
                        }
                    }

                }
                pOperadores.push(token); // si no son () o espacios guarda al operador
            }
        }
        //Una vez que resolvimos lo de los parentesis y se acabo la expresion, puede haber mas en 
        // en el stack que no estaba en parentesis, entonces lo sacamos y asignamos padre e hijos
        raiz = (Nodo) pOperandos.peek(); // y aqui se asigna la raiz del arbol
        while (!pOperadores.empty()) {
            if (pOperadores.peek().equals("(")) {
                pOperadores.pop(); // saca el elemento
            } else {
                guardarSubArbol(); // asigna al operador sus hijos
                raiz = (Nodo) pOperandos.peek(); // asignamos el arbol que se genero
            }
        }
        return raiz;
    }
    public void PostOrden(Nodo n){
        if (n!=null) {
            PostOrden(n.getNodoIzquierdo());
            PostOrden(n.getNodoDerecho());
            txtArea_notacion.append(n.getInformacion() + " ");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_expresion = new javax.swing.JTextField();
        btn_calcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_notacion = new javax.swing.JTextArea();
        btn_calcular1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("NOTACIÓN POSTFIJA");

        txt_expresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_expresionActionPerformed(evt);
            }
        });

        btn_calcular.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btn_calcular.setText("CALCULAR");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        txtArea_notacion.setColumns(20);
        txtArea_notacion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtArea_notacion.setRows(5);
        jScrollPane1.setViewportView(txtArea_notacion);

        btn_calcular1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btn_calcular1.setText("LIMPIAR");
        btn_calcular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcular1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_calcular)
                                .addGap(15, 15, 15)
                                .addComponent(txt_expresion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_calcular1)
                .addGap(144, 144, 144))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_calcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_expresion))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_calcular1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_expresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_expresionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_expresionActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        txtArea_notacion.setText("");
        try{
           String expresion= txt_expresion.getText();
           Nodo raiz = realizarArbol(expresion); // este nodo contiene todo el arbol
           txtArea_notacion.append("La notacion POSTFIJA es: ");
           PostOrden(raiz);
        }
        catch(Exception p){}
    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_calcular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcular1ActionPerformed
        txtArea_notacion.setText(" ");
    }//GEN-LAST:event_btn_calcular1ActionPerformed

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
            java.util.logging.Logger.getLogger(NotacionPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotacionPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotacionPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotacionPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotacionPost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_calcular1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea_notacion;
    private javax.swing.JTextField txt_expresion;
    // End of variables declaration//GEN-END:variables
}
