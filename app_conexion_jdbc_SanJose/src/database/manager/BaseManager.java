/*

 */
package database.manager;

import database.jdbc.*;
import java.sql.Date;
import java.util.List;


/**
 *
 * @authores : Eli y Dina
 */
public class BaseManager {
    protected entity.BaseEntity entidad;
    protected QuerySQL querySQL = null;
    protected JdbcList MyList=new JdbcList();
    protected JdbcItem MyItem=new JdbcItem();
    protected JdbcDatabase MyBase=new JdbcDatabase();
    private String error="";
    protected String FieldID="id";
    protected String FieldNombre="nombre";
    protected String FieldA="A";
    protected String FieldB="B";
    protected String FieldC="C";
    protected String FieldD="D";
    protected String FieldE="E";
    protected String FieldF="F";
    protected String FieldG="G";
    protected String FieldH="H";
    protected String FieldI="I";
    //protected Date FieldFecha = "Fecha";
//---------------------------------------

   
    //---------------------------------------
    public BaseManager(){
       
    }

    public QuerySQL getQuerySQL() {
        return querySQL;
    }

    public void setQuerySQL(QuerySQL querySQL) {
        this.querySQL = querySQL;
    }

    public JdbcList getMyList() {
        return MyList;
    }

    public void setMyList(JdbcList MyList) {
        this.MyList = MyList;
    }

    public JdbcItem getMyItem() {
        return MyItem;
    }

    public void setMyItem(JdbcItem MyItem) {
        this.MyItem = MyItem;
    }

    public JdbcDatabase getMyBase() {
        return MyBase;
    }

    public void setMyBase(JdbcDatabase MyBase) {
        this.MyBase = MyBase;
    }

    public String getFieldID() {
        return FieldID;
    }

    public void setFieldID(String FieldID) {
        this.FieldID = FieldID;
    }
//------------------------
    public String getFieldA() {
        return FieldA;
    }

    public void setFieldA(String FieldA) {
        this.FieldA = FieldA;
    }

    public String getFieldB() {
        return FieldB;
    }

    public void setFieldB(String FieldB) {
        this.FieldB = FieldB;
    }

    public String getFieldC() {
        return FieldC;
    }

    public void setFieldC(String FieldC) {
        this.FieldC = FieldC;
    }

    public String getFieldD() {
        return FieldD;
    }

    public void setFieldD(String FieldD) {
        this.FieldD = FieldD;
    }

    public String getFieldE() {
        return FieldE;
    }

    public void setFieldE(String FieldE) {
        this.FieldE = FieldE;
    }

    public String getFieldF() {
        return FieldF;
    }

    public void setFieldF(String FieldF) {
        this.FieldF = FieldF;
    }

    public String getFieldG() {
        return FieldG;
    }

    public void setFieldG(String FieldG) {
        this.FieldG = FieldG;
    }

    public String getFieldH() {
        return FieldH;
    }

    public void setFieldH(String FieldH) {
        this.FieldH = FieldH;
    }

    public String getFieldI() {
        return FieldI;
    }

    public void setFieldI(String FieldI) {
        this.FieldI = FieldI;
    }

    
    //-----------------------------------
    public String getFieldIDName(){
       return FieldID;
    } 
    public String getFieldNombre(){
       return FieldNombre;
    } 
    public entity.BaseEntity getEntidad() {
        return entidad;
     }
    public void  setEntity(entity.BaseEntity value) {
        entidad=value;
        querySQL.setEntity(value);
     }
    public void setQuery(QuerySQL query) {
        this.querySQL = query;
     }
    
    public void setError(String value){
         error = value;
    }
    public String getError(){
        return error;
    }
     /**
     * Obtener la lista de registros para una entidad
     * @return
     */
    public List getItemsCBO(){
            MyList.setQuery(querySQL);
            return MyList.getListCBO(new String[] {getFieldIDName()});
        }
    public List getItems(){
            MyList.setQuery(querySQL);
            return MyList.getList( new String[] {getFieldIDName()});
        }
    public List getListLIKE(String[] OrderBy, String[] PropertyName, String[] PropertyValue){
            MyList.setQuery(querySQL);
            return MyList.getListLIKE(OrderBy,PropertyName,PropertyValue);
    }
    public List getList(String[] OrderBy){
            MyList.setQuery(querySQL);
            return MyList.getList(OrderBy);
    }
    public List getList(String[] OrderBy, String FilterSQL){
            MyList.setQuery(querySQL);
            return MyList.getList(OrderBy,FilterSQL);
    }
    public List getList(String PropertyName, int PropertyValue){
            MyList.setQuery(querySQL);
            return MyList.getList(PropertyName, PropertyValue);
    }
    //-----------------------------------------------------------------
        /**
        * Cantidad de registros de una entidad
        * @return
        */
      public int getItemsCount() {
           MyList.setQuery(querySQL);
           return MyList.getListCount();
        }  
     public Object getItem(String PropertyName,String PropertyValue){
           MyItem.setQuery(querySQL);
           return MyItem.getItem(PropertyName, PropertyValue);
     }
     public Object getItem(String PropertyName,int PropertyValue){
           MyItem.setQuery(querySQL);
           return MyItem.getItem(PropertyName, PropertyValue);
     }
     public Object getItemLast(String OrderBy){
           MyItem.setQuery(querySQL);
           return MyItem.getItemLast(OrderBy);
     }
     public Object getItemLastByID(){
           MyItem.setQuery(querySQL);
           return MyItem.getItemLast(getFieldIDName());
     }     
     public boolean insert(){
           MyBase.setQuery(querySQL);
           return MyBase.insert(entidad)>0;
        }

     public boolean update(){
           MyBase.setQuery(querySQL);
           return MyBase.update(entidad)>0;

        }
       public boolean delete() {
//            MyBase.setQuery(querySQL);
//           return MyBase.delete(entidad)>0;

           return false;   
        }
    
}
