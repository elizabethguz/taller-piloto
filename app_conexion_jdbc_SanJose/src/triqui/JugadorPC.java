package triqui;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class JugadorPC {

    public void juegaAleatorioPC(JButton[][] boton) {

        int aleatorio1 = 0;
        int aleatorio2 = 0;

        do {
            aleatorio1 = (int) (Math.random() * 3 + 0);
            aleatorio2 = (int) (Math.random() * 3 + 0);
        } while (boton[aleatorio1][aleatorio2].getText() != null);

        if (boton[aleatorio1][aleatorio2].getText() == null) {
            boton[aleatorio1][aleatorio2].setText(Triqui.marca2);
        }
    }

    public boolean jugar2(JButton[][] boton) {

        boolean estado = false;

        /***************************
         *        *        *       *
<<<<<<< HEAD
         *  posi 1 * posi 2  * posi 3 *
         *        *        *       *
         ***************************
         *        *        *       *
         *  posi 4 * posi 5  * posi 6 *
         *        *        *       *
         * *************************
         *        *        *       *
         *  posi 7 * posi 8  * posi 9 *
=======
         *  pos 1 * pos 2  * pos 3 *
         *        *        *       *
         ***************************
         *        *        *       *
         *  pos 4 * pos 5  * pos 6 *
         *        *        *       *
         * *************************
         *        *        *       *
         *  pos 7 * pos 8  * pos 9 *
>>>>>>> elizabeth/master
         *        *        *       *
         * **************************/
        String pos1 = "" + boton[0][0].getText();
        String pos2 = "" + boton[0][1].getText();
        String pos3 = "" + boton[0][2].getText();
        String pos4 = "" + boton[1][0].getText();
        String pos5 = "" + boton[1][1].getText();
        String pos6 = "" + boton[1][2].getText();
        String pos7 = "" + boton[2][0].getText();
        String pos8 = "" + boton[2][1].getText();
        String pos9 = "" + boton[2][2].getText();

        //------------------ATACAR_FILAS------------------------------------

        //fila 0 defender   pos 1 2 3
        if (pos1.equals(Triqui.marca2) && pos2.equals(Triqui.marca2) && pos3.equals("null")) {
            boton[0][2].setText(Triqui.marca2);
            estado = true;
        }
        if (pos1.equals(Triqui.marca2) && pos2.equals("null") && pos3.equals(Triqui.marca2)) {
            boton[0][1].setText(Triqui.marca2);
            estado = true;
        }
        if (pos1.equals("null") && pos2.equals(Triqui.marca2) && pos3.equals(Triqui.marca2)) {
            boton[0][0].setText(Triqui.marca2);
            estado = true;
        }

        //fila 1 defender   pos 4 5 6
        if (pos4.equals(Triqui.marca2) && pos5.equals(Triqui.marca2) && pos6.equals("null")) {
            boton[1][2].setText(Triqui.marca2);
            estado = true;
        }
        if (pos4.equals(Triqui.marca2) && pos5.equals("null") && pos6.equals(Triqui.marca2)) {
            boton[1][1].setText(Triqui.marca2);
            estado = true;
        }
        if (pos4.equals("null") && pos5.equals(Triqui.marca2) && pos6.equals(Triqui.marca2)) {
            boton[1][0].setText(Triqui.marca2);
            estado = true;
        }

        //fila 2 defender 7 8 9
        if (pos7.equals(Triqui.marca2) && pos8.equals(Triqui.marca2) && pos9.equals("null")) {
            boton[2][2].setText(Triqui.marca2);
            estado = true;
        }
        if (pos7.equals(Triqui.marca2) && pos8.equals("null") && pos9.equals(Triqui.marca2)) {
            boton[2][1].setText(Triqui.marca2);
            estado = true;
        }
        if (pos7.equals("null") && pos8.equals(Triqui.marca2) && pos9.equals(Triqui.marca2)) {
            boton[2][0].setText(Triqui.marca2);
            estado = true;
        }

        //------------------ATACAR_COLUMNAS---------------------------------

        //columna 0 defender pos 1 4 7
        if (pos1.equals(Triqui.marca2) && pos4.equals(Triqui.marca2) && pos7.equals("null")) {
            boton[2][0].setText(Triqui.marca2);
            estado = true;
        }
        if (pos1.equals(Triqui.marca2) && pos4.equals("null") && pos7.equals(Triqui.marca2)) {
            boton[1][0].setText(Triqui.marca2);
            estado = true;
        }
        if (pos1.equals("null") && pos4.equals(Triqui.marca2) && pos7.equals(Triqui.marca2)) {
            boton[0][0].setText(Triqui.marca2);
            estado = true;
        }

        //columna 1 defender pos 2 5 8
        if (pos2.equals(Triqui.marca2) && pos5.equals(Triqui.marca2) && pos8.equals("null")) {
            boton[2][1].setText(Triqui.marca2);
            estado = true;
        }
        if (pos2.equals(Triqui.marca2) && pos5.equals("null") && pos8.equals(Triqui.marca2)) {
            boton[1][1].setText(Triqui.marca2);
            estado = true;
        }
        if (pos2.equals("null") && pos5.equals(Triqui.marca2) && pos8.equals(Triqui.marca2)) {
            boton[0][1].setText(Triqui.marca2);
            estado = true;
        }

        //columna 2 defender pos 3 6 9
        if (pos3.equals(Triqui.marca2) && pos6.equals(Triqui.marca2) && pos9.equals("null")) {
            boton[2][2].setText(Triqui.marca2);
            estado = true;
        }
        if (pos3.equals(Triqui.marca2) && pos6.equals("null") && pos9.equals(Triqui.marca2)) {
            boton[1][2].setText(Triqui.marca2);
            estado = true;
        }
        if (pos3.equals("null") && pos6.equals(Triqui.marca2) && pos9.equals(Triqui.marca2)) {
            boton[0][2].setText(Triqui.marca2);
            estado = true;
        }

        //diagonal principal defender pos 1 5 9
        if (pos1.equals(Triqui.marca2) && pos5.equals(Triqui.marca2) && pos9.equals("null")) {
            boton[2][2].setText(Triqui.marca2);
            estado = true;
        }
        if (pos1.equals(Triqui.marca2) && pos5.equals("null") && pos9.equals(Triqui.marca2)) {
            boton[1][1].setText(Triqui.marca2);
            estado = true;
        }
        if (pos1.equals("null") && pos5.equals(Triqui.marca2) && pos9.equals(Triqui.marca2)) {
            boton[0][0].setText(Triqui.marca2);
            estado = true;
        }

        //diagonal secundaria defender pos 3 5 7
        if (pos3.equals(Triqui.marca2) && pos5.equals(Triqui.marca2) && pos7.equals("null")) {
            boton[2][0].setText(Triqui.marca2);
            estado = true;
        }
        if (pos3.equals(Triqui.marca2) && pos5.equals("null") && pos7.equals(Triqui.marca2)) {
            boton[1][1].setText(Triqui.marca2);
            estado = true;
        }
        if (pos3.equals("null") && pos5.equals(Triqui.marca2) && pos7.equals(Triqui.marca2)) {
            boton[0][2].setText(Triqui.marca2);
            estado = true;
        }


//********************************************************************************************


        //------------------DEFENDER_FILAS----------------------------------

        //fila 0 defender   pos 1 2 3
        if (pos1.equals(Triqui.marca1) && pos2.equals(Triqui.marca1) && pos3.equals("null")) {
            boton[0][2].setText(Triqui.marca2);
            estado = true;
        } else if (pos1.equals(Triqui.marca1) && pos2.equals("null") && pos3.equals(Triqui.marca1)) {
            boton[0][1].setText(Triqui.marca2);
            estado = true;
        } else if (pos1.equals("null") && pos2.equals(Triqui.marca1) && pos3.equals(Triqui.marca1)) {
            boton[0][0].setText(Triqui.marca2);
            estado = true;
        } //fila 1 defender   pos 4 5 6
        else if (pos4.equals(Triqui.marca1) && pos5.equals(Triqui.marca1) && pos6.equals("null")) {
            boton[1][2].setText(Triqui.marca2);
            estado = true;
        } else if (pos4.equals(Triqui.marca1) && pos5.equals("null") && pos6.equals(Triqui.marca1)) {
            boton[1][1].setText(Triqui.marca2);
            estado = true;
        } else if (pos4.equals("null") && pos5.equals(Triqui.marca1) && pos6.equals(Triqui.marca1)) {
            boton[1][0].setText(Triqui.marca2);
            estado = true;
        } //fila 2 defender 7 8 9
        else if (pos7.equals(Triqui.marca1) && pos8.equals(Triqui.marca1) && pos9.equals("null")) {
            boton[2][2].setText(Triqui.marca2);
            estado = true;
        } else if (pos7.equals(Triqui.marca1) && pos8.equals("null") && pos9.equals(Triqui.marca1)) {
            boton[2][1].setText(Triqui.marca2);
            estado = true;
        } else if (pos7.equals("null") && pos8.equals(Triqui.marca1) && pos9.equals(Triqui.marca1)) {
            boton[2][0].setText(Triqui.marca2);
            estado = true;
        } //------------------DEFENDER_COLUMNAS-------------------------------
        //columna 0 defender pos 1 4 7
        else if (pos1.equals(Triqui.marca1) && pos4.equals(Triqui.marca1) && pos7.equals("null")) {
            boton[2][0].setText(Triqui.marca2);
            estado = true;
        } else if (pos1.equals(Triqui.marca1) && pos4.equals("null") && pos7.equals(Triqui.marca1)) {
            boton[1][0].setText(Triqui.marca2);
            estado = true;
        } else if (pos1.equals("null") && pos4.equals(Triqui.marca1) && pos7.equals(Triqui.marca1)) {
            boton[0][0].setText(Triqui.marca2);
            estado = true;
        } //columna 1 defender pos 2 5 8
        else if (pos2.equals(Triqui.marca1) && pos5.equals(Triqui.marca1) && pos8.equals("null")) {
            boton[2][1].setText(Triqui.marca2);
            estado = true;
        } else if (pos2.equals(Triqui.marca1) && pos5.equals("null") && pos8.equals(Triqui.marca1)) {
            boton[1][1].setText(Triqui.marca2);
            estado = true;
        } else if (pos2.equals("null") && pos5.equals(Triqui.marca1) && pos8.equals(Triqui.marca1)) {
            boton[0][1].setText(Triqui.marca2);
            estado = true;
        } //columna 2 defender pos 3 6 9
        else if (pos3.equals(Triqui.marca1) && pos6.equals(Triqui.marca1) && pos9.equals("null")) {
            boton[2][2].setText(Triqui.marca2);
            estado = true;
        } else if (pos3.equals(Triqui.marca1) && pos6.equals("null") && pos9.equals(Triqui.marca1)) {
            boton[1][2].setText(Triqui.marca2);
            estado = true;
        } else if (pos3.equals("null") && pos6.equals(Triqui.marca1) && pos9.equals(Triqui.marca1)) {
            boton[0][2].setText(Triqui.marca2);
            estado = true;
        } //diagonal principal defender pos 1 5 9
        else if (pos1.equals(Triqui.marca1) && pos5.equals(Triqui.marca1) && pos9.equals("null")) {
            boton[2][2].setText(Triqui.marca2);
            estado = true;
        } else if (pos1.equals(Triqui.marca1) && pos5.equals("null") && pos9.equals(Triqui.marca1)) {
            boton[1][1].setText(Triqui.marca2);
            estado = true;
        } else if (pos1.equals("null") && pos5.equals(Triqui.marca1) && pos9.equals(Triqui.marca1)) {
            boton[0][0].setText(Triqui.marca2);
            estado = true;
        } //diagonal secundaria defender pos 3 5 7
        else if (pos3.equals(Triqui.marca1) && pos5.equals(Triqui.marca1) && pos7.equals("null")) {
            boton[2][0].setText(Triqui.marca2);
            estado = true;
        } else if (pos3.equals(Triqui.marca1) && pos5.equals("null") && pos7.equals(Triqui.marca1)) {
            boton[1][1].setText(Triqui.marca2);
            estado = true;
        } else if (pos3.equals("null") && pos5.equals(Triqui.marca1) && pos7.equals(Triqui.marca1)) {
            boton[0][2].setText(Triqui.marca2);
            estado = true;
        }

        return estado;
    }
}
