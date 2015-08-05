/*
@authores : Eli y Dina
 */
package entity;

import java.io.Serializable;
import java.sql.Date;

public class BaseEntity implements Serializable {
    private int id;
    private String nombre;
<<<<<<< HEAD
    
=======
>>>>>>> elizabeth/master
    private int rowSearch = 0;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private Date P;
    //-------------------------------------------

    public Date getP() {
        return P;
    }

    public void setP(Date P) {
        this.P = P;
    }
//-------------------------------------------
    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public String getE() {
        return E;
    }

    public void setE(String E) {
        this.E = E;
    }

    public String getF() {
        return F;
    }

    public void setF(String F) {
        this.F = F;
    }

    public String getG() {
        return G;
    }

    public void setG(String G) {
        this.G = G;
    }

    public String getH() {
        return H;
    }

    public void setH(String H) {
        this.H = H;
    }

    public String getI() {
        return I;
    }

    public void setI(String I) {
        this.I = I;
    }

    public String getJ() {
        return J;
    }

    public void setJ(String J) {
        this.J = J;
    }

    public String getK() {
        return K;
    }

    public void setK(String K) {
        this.K = K;
    }

    public String getL() {
        return L;
    }

    public void setL(String L) {
        this.L = L;
    }

    public String getM() {
        return M;
    }

    public void setM(String M) {
        this.M = M;
    }

    public String getN() {
        return N;
    }

    public void setN(String N) {
        this.N = N;
    }
    //*******************************
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //-------------------------------------------
    public void clear(){
       id =    0;
       nombre = "";
    }

    public int getRowSearch() {
        return rowSearch;
    }

    public void setRowSearch(int rowSearch) {
        this.rowSearch = rowSearch;
    }
    
    public void copyTo(BaseEntity obj){
          obj.setId(id);
          obj.setNombre(nombre);
          obj.setRowSearch(rowSearch);
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaseEntity)) {
            return false;
        }
        BaseEntity other = (BaseEntity) object;
        if (rowSearch==0 || rowSearch==1)
             { if (this.id != other.id) { return false;  }
             }
        
        if (rowSearch==0 || rowSearch==2)
           {if (this.nombre.compareToIgnoreCase(other.nombre) != 0) {return false; }
           }
        
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
