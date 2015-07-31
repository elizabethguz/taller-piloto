/*
@authores : Eli y Dina
 */
package database.jdbc;

import java.sql.Connection;

public class JdbcBase {
    protected String error = "";
    protected QuerySQL query;

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    public QuerySQL getQuery() {
        return query;
    }

    public void setQuery(QuerySQL query) {
        this.query = query;
    }
    protected String ArrayToString(String[] arrayStr){
          String s="";
          int i;
          for (i=0; i< arrayStr.length; i++)
              {  if (i>0) {s = s + ", " + arrayStr[i];}
              else {s = s + arrayStr[i];}
              }
          return s.trim();
       } 
    private static final database.conexion.Conexion db= new database.conexion.Conexion();
    public boolean ConexionOpen(){
       if (!db.opened()) {db.Open();}
       return db.opened();
    }
    public boolean ConexionClose(){
       if (db.opened()) {db.Close();}
       return !db.opened();
    }
    protected Connection Conexion(){
       return db.getConexion();
    }
}
