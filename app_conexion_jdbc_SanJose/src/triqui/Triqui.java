
/* Programa: Triqui en java
<<<<<<< HEAD
 * Ingenieria de sistemas
 * version 1.0
 * Desarrolladores:
 * DINA VILLEGAS BALANDRA
=======
 
>>>>>>> elizabeth/master
 *
 * Clase principal que ejecutara el programa
 * Descripcion: jugar al clasico 3 en raya o triqui contra el ordenador.
*/

package triqui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Triqui extends JFrame implements ActionListener{

    private JugadorPC jugadorPC;

    private Font fuente = new Font("Arial",Font.BOLD, 40);
    public static final String marca1 = "0";
    public static final String marca2 = "X";

    private JButton[][] botonMatriz;
    private JButton bLimpiar;

    public Triqui(){

<<<<<<< HEAD
        super("ENTRETENIMIENTO SAN JOSE -->> Dina Villegas");

        botonMatriz = new JButton[3][3]; 
=======
        super("Triqui");

        botonMatriz = new JButton[3][3];
>>>>>>> elizabeth/master
        jugadorPC = new JugadorPC();

        this.getContentPane().add(creaPanelBotones(), BorderLayout.CENTER);
        this.getContentPane().add(creaPanelJuegoNuevo(), BorderLayout.SOUTH);

        this.pack();
        this.setMinimumSize(new Dimension(350,450));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.limpiarTablero();
        
        this.addWindowListener(new WindowAdapter(){
                                    public void windowClosing(WindowEvent ev){
                                        dispose();
                                    }
        });
    }
    
    private JPanel creaPanelBotones(){

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3,5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        for(int f=0; f<3; f++){
            for(int c=0; c<3; c++){

                botonMatriz[f][c] = new JButton();
                botonMatriz[f][c].addActionListener(this);
                botonMatriz[f][c].setFont(fuente);
                panel.add(botonMatriz[f][c]);
            }
        }

        return panel;
    }

    private JPanel creaPanelJuegoNuevo(){

        JPanel panel = new JPanel();

        panel.add(bLimpiar = new JButton("Juego Nuevo"), BorderLayout.CENTER);
        bLimpiar.addActionListener(this);
        return panel;
    }
    
    public void diagonalPrincipalLlena(){

        int aux1 = 0;
        int aux2 = 0;

        for(int f=0; f<3; f++){
            for(int c=0; c<3; c++){
                if(f==c){
                    if(botonMatriz[f][c].getText() != null){

                        if(botonMatriz[f][c].getText().equals(marca1)){
                            aux1++;
                            if(aux1==3){
<<<<<<< HEAD
                               JOptionPane.showMessageDialog(this,"Diagonal Principal Llena Ganas ","Ganador",JOptionPane.INFORMATION_MESSAGE);
=======
                               JOptionPane.showMessageDialog(this,"Diagonal Principal Llena Ganas GARAYAR ","Ganador",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> elizabeth/master
                               this.limpiarTablero();
                            }
                        }
                        else if(botonMatriz[f][c].getText().equals(marca2)){
                            aux2++;
                            if(aux2==3){
                                JOptionPane.showMessageDialog(this,"Diagonal Principal Llena Gana PC ","Ganador",JOptionPane.INFORMATION_MESSAGE);
                                this.limpiarTablero();
                            }
                        }
                    }                    
                }
            }
        }
    }

    public void diagonalSecundariaLlena(){

        int aux1 = 0;
        int aux2 = 0;
        int numFilas = 3;
        int numColumn = 3;

        for(int f=0; f<numFilas; f++){
            for(int c=0; c<numColumn; c++){
                if((f + c) == (numFilas - 1)){
                    if(botonMatriz[f][c].getText() != null){

                        if(botonMatriz[f][c].getText().equals(marca1)){
                            aux1++;
                            if(aux1==3){
<<<<<<< HEAD
                               JOptionPane.showMessageDialog(this,"Diagonal Secundaria Llena Ganas  ","Ganador",JOptionPane.INFORMATION_MESSAGE);
=======
                               JOptionPane.showMessageDialog(this,"Diagonal Secundaria Llena Ganas GARAYAR ","Ganador",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> elizabeth/master
                               this.limpiarTablero();
                            }
                        }
                        else if(botonMatriz[f][c].getText().equals(marca2)){
                            aux2++;
                            if(aux2==3){
                                JOptionPane.showMessageDialog(this,"Diagonal Secundaria Llena Gana PC ","Ganador",JOptionPane.INFORMATION_MESSAGE);
                                this.limpiarTablero();
                            }
                        }
                    }
                }
            }
        }
    }

    public void filaSuperiorLlena(){

        int aux1 = 0;
        int aux2 = 0;

        for(int c=0; c<3; c++){
            if(botonMatriz[0][c].getText() != null){

                if(botonMatriz[0][c].getText().equals(marca1)){
                    aux1++;
                    if(aux1==3){
<<<<<<< HEAD
                       JOptionPane.showMessageDialog(this,"Fila Superior Llena Ganas  ","Ganador",JOptionPane.INFORMATION_MESSAGE);
=======
                       JOptionPane.showMessageDialog(this,"Fila Superior Llena Ganas GARAYAR ","Ganador",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> elizabeth/master
                       this.limpiarTablero();
                    }
                }
                else if(botonMatriz[0][c].getText().equals(marca2)){
                    aux2++;
                    if(aux2==3){
                        JOptionPane.showMessageDialog(this,"Fila Superior Llena Gana PC ","Ganador",JOptionPane.INFORMATION_MESSAGE);
                        this.limpiarTablero();
                    }
                }
            }            
        }
    }

    public void filaMediaLlena(){

        int aux1 = 0;
        int aux2 = 0;

        for(int c=0; c<3; c++){
            if(botonMatriz[1][c].getText() != null){

                if(botonMatriz[1][c].getText().equals(marca1)){
                    aux1++;
                    if(aux1==3){
<<<<<<< HEAD
                       JOptionPane.showMessageDialog(this,"Fila Media Llena Ganas  ","Ganador",JOptionPane.INFORMATION_MESSAGE);
=======
                       JOptionPane.showMessageDialog(this,"Fila Media Llena Ganas GARAYAR ","Ganador",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> elizabeth/master
                       this.limpiarTablero();
                    }
                }
                else if(botonMatriz[1][c].getText().equals(marca2)){
                    aux2++;
                    if(aux2==3){
                        JOptionPane.showMessageDialog(this,"Fila Media Llena Gana PC ","Ganador",JOptionPane.INFORMATION_MESSAGE);
                        this.limpiarTablero();
                    }
                }
            }
        }
    }

    public void filaInferiorLlena(){

        int aux1 = 0;
        int aux2 = 0;

        for(int c=0; c<3; c++){
            if(botonMatriz[2][c].getText() != null){

                if(botonMatriz[2][c].getText().equals(marca1)){
                    aux1++;
                    if(aux1==3){
<<<<<<< HEAD
                       JOptionPane.showMessageDialog(this,"Fila Inferior Llena Ganas  ","Ganador",JOptionPane.INFORMATION_MESSAGE);
=======
                       JOptionPane.showMessageDialog(this,"Fila Inferior Llena Ganas GARAYAR ","Ganador",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> elizabeth/master
                       this.limpiarTablero();
                    }
                }
                else if(botonMatriz[2][c].getText().equals(marca2)){
                    aux2++;
                    if(aux2==3){
                        JOptionPane.showMessageDialog(this,"Fila Inferior Llena Gana PC ","Ganador",JOptionPane.INFORMATION_MESSAGE);
                        this.limpiarTablero();
                    }
                }
            }
        }
    }

    public void columnaIzquierdaLlena(){

        int aux1=0;
        int aux2=0;

        for(int f=0; f<3; f++){
            if(botonMatriz[f][0].getText() != null){

                if(botonMatriz[f][0].getText().equals(marca1)){
                    aux1++;
                    if(aux1==3){
<<<<<<< HEAD
                       JOptionPane.showMessageDialog(this,"Columna Izquierda Llena Ganas  ","Ganador",JOptionPane.INFORMATION_MESSAGE);
=======
                       JOptionPane.showMessageDialog(this,"Columna Izquierda Llena Ganas GARAYAR ","Ganador",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> elizabeth/master
                       this.limpiarTablero();
                    }
                }
                else if(botonMatriz[f][0].getText().equals(marca2)){
                    aux2++;
                    if(aux2==3){
                        JOptionPane.showMessageDialog(this,"Columna Izquierda Llena Gana PC ","Ganador",JOptionPane.INFORMATION_MESSAGE);
                        this.limpiarTablero();
                    }
                }
            }
        }
    }

    public void columnaCentralLlena(){

        int aux1 = 0;
        int aux2 = 0;

        for(int f=0; f<3; f++){
            if(botonMatriz[f][1].getText() != null){

                if(botonMatriz[f][1].getText().equals(marca1)){
                    aux1++;
                    if(aux1==3){
<<<<<<< HEAD
                       JOptionPane.showMessageDialog(this,"Columna Central Llena Ganas  ","Ganador",JOptionPane.INFORMATION_MESSAGE);
=======
                       JOptionPane.showMessageDialog(this,"Columna Central Llena Ganas GARAYAR ","Ganador",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> elizabeth/master
                       this.limpiarTablero();
                    }
                }
                else if(botonMatriz[f][1].getText().equals(marca2)){
                    aux2++;
                    if(aux2==3){
                        JOptionPane.showMessageDialog(this,"Columna Central Llena Gana PC ","Ganador",JOptionPane.INFORMATION_MESSAGE);
                        this.limpiarTablero();
                    }
                }
            }
        }
    }

    public void columnaDerechaLlena(){

        int aux1 = 0;
        int aux2 = 0;

        for(int f=0; f<3; f++){

            if(botonMatriz[f][2].getText() != null){
                if(botonMatriz[f][2].getText().equals(marca1)){

                    aux1++;
                    if(aux1==3){
<<<<<<< HEAD
                       JOptionPane.showMessageDialog(this,"Columna Derecha Llena Ganas  ","Ganador",JOptionPane.INFORMATION_MESSAGE);
=======
                       JOptionPane.showMessageDialog(this,"Columna Derecha Llena Ganas GARAYAR ","Ganador",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> elizabeth/master
                       this.limpiarTablero();
                    }
                }
                else if(botonMatriz[f][2].getText().equals(marca2)){
                    aux2++;
                    if(aux2==3){
                        JOptionPane.showMessageDialog(this,"Columna Derecha Llena Gana PC ","Ganador",JOptionPane.INFORMATION_MESSAGE);
                        this.limpiarTablero();
                    }
                }
            }            
        }
    }

    public void tableroLleno(){

        int aux = 0;

        for(int f=0; f<3; f++){
            for(int c=0; c<3; c++){
                if(botonMatriz[f][c].getText() != null){

                    aux++;
                    if(aux==9){
                        JOptionPane.showMessageDialog(this,"Empate tablero lleno");
                        this.limpiarTablero();
                    }
                }
            }
        }
    }

    public void limpiarTablero(){

        for(int f=0; f<3; f++){
            for(int c=0; c<3; c++){
                botonMatriz[f][c].setText(null);
            }
        }
    }

    public void verificaCasilla(JButton[][] bot, int f, int c){

        if(bot[f][c].getText() == null){
            botonMatriz[f][c].setText(marca1);
        }
        else{
            JOptionPane.showMessageDialog(this,"Casilla Ocupada\nPerdiste el Turno");
        }
    }

    public void analizaTablero(){

        this.diagonalPrincipalLlena();
        this.diagonalSecundariaLlena();
        this.filaSuperiorLlena();
        this.filaMediaLlena();
        this.filaInferiorLlena();
        this.columnaIzquierdaLlena();
        this.columnaCentralLlena();
        this.columnaDerechaLlena();
        this.tableroLleno();
    }

    public void actionPerformed(ActionEvent ev){

        JButton evBoton = (JButton)ev.getSource();

        if(evBoton.equals(botonMatriz[0][0])){
            this.verificaCasilla(botonMatriz, 0, 0);
            this.analizaTablero();
            if(jugadorPC.jugar2(botonMatriz) != true){
                jugadorPC.juegaAleatorioPC(botonMatriz);
            }
        }
        if(evBoton.equals(botonMatriz[0][1])){
            this.verificaCasilla(botonMatriz, 0, 1);
            this.analizaTablero();
            if(jugadorPC.jugar2(botonMatriz) != true){
                jugadorPC.juegaAleatorioPC(botonMatriz);
            }
        }
        if(evBoton.equals(botonMatriz[0][2])){
            this.verificaCasilla(botonMatriz, 0, 2);
            this.analizaTablero();
            if(jugadorPC.jugar2(botonMatriz) != true){
                jugadorPC.juegaAleatorioPC(botonMatriz);
            }
        }
        if(evBoton.equals(botonMatriz[1][0])){
            this.verificaCasilla(botonMatriz, 1, 0);
            this.analizaTablero();
            if(jugadorPC.jugar2(botonMatriz) != true){
                 jugadorPC.juegaAleatorioPC(botonMatriz);
            }
        }
        if(evBoton.equals(botonMatriz[1][1])){
            this.verificaCasilla(botonMatriz, 1, 1);
            this.analizaTablero();
            if(jugadorPC.jugar2(botonMatriz) != true){
                jugadorPC.juegaAleatorioPC(botonMatriz);
            }
        }
        if(evBoton.equals(botonMatriz[1][2])){
            this.verificaCasilla(botonMatriz, 1, 2);
            this.analizaTablero();
            if(jugadorPC.jugar2(botonMatriz) != true){
                jugadorPC.juegaAleatorioPC(botonMatriz);
            }
        }
        if(evBoton.equals(botonMatriz[2][0])){
            this.verificaCasilla(botonMatriz, 2, 0);
            this.analizaTablero();
            if(jugadorPC.jugar2(botonMatriz) != true){
                jugadorPC.juegaAleatorioPC(botonMatriz);
            }
        }
        if(evBoton.equals(botonMatriz[2][1])){
            this.verificaCasilla(botonMatriz, 2, 1);
            this.analizaTablero();
            if(jugadorPC.jugar2(botonMatriz) != true){
                jugadorPC.juegaAleatorioPC(botonMatriz);
            }
        }
        if(evBoton.equals(botonMatriz[2][2])){
            this.verificaCasilla(botonMatriz, 2, 2);
            this.analizaTablero();
            if(jugadorPC.jugar2(botonMatriz) != true){
                jugadorPC.juegaAleatorioPC(botonMatriz);
            }
        }
        if(evBoton.equals(bLimpiar)){
            this.limpiarTablero();
            jugadorPC.juegaAleatorioPC(botonMatriz);
        }
        
        this.analizaTablero();
    }

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        Triqui triqui = new Triqui();
        SwingUtilities.updateComponentTreeUI(triqui);    
    }
}