
package modelos.dao;

import data.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.vo.Tipocli;

public class TipocliDao {
    
    BaseDatos db = new BaseDatos();
    PreparedStatement stmt;
    ResultSet rs;
    String sql;
    Tipocli obj;
    
    public List Listar() {
        List<Tipocli> lista = new ArrayList<>();
        try {
            db.Conectar();
            sql = "select * from tipocliente";
            stmt = db.getConn().prepareStatement(sql);
            rs = db.EjecutarConsulta(stmt);
            while (rs.next()) {
                int tipoid = rs.getInt("tipocliid");
                String tipodesc = rs.getString("tipodesc");
                obj = new Tipocli(tipoid, tipodesc);
                lista.add(obj);
            }
            db.Cerrar();
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
        return lista;
    }
    
    public Tipocli Buscar(int id) {
        try {
            db.Conectar();
            sql = "select * from tipocliente where tipocliid = ?";
            stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            rs = db.EjecutarConsulta(stmt);
            if (rs.next()) {
                int tipoid = rs.getInt("tipocliid");
                String tipodesc = rs.getString("tipodesc");
                obj = new Tipocli(tipoid, tipodesc);
            }
            db.Cerrar();
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
        return obj;
    }
}
