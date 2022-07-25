/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notacionpostfija;

/**
 *
 * @author Abiu
 */
public class Nodo {
    private  String informacion;// raiz
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;
    
    public Nodo(){
        this.informacion= "";
        this.nodoIzquierdo= null;
        this.nodoDerecho= null;
        
    }
    public Nodo(String informacion){
        this.informacion= informacion;
        this.nodoIzquierdo= null;
        this.nodoDerecho= null;
        
    }
    public Nodo(Nodo op1,String pop,Nodo op2){
        this.informacion= pop;
        this.nodoIzquierdo= op2;
        this.nodoDerecho= op1;
        
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }


    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }
    
    
}
