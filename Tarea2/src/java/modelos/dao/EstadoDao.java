package modelos.dao;

import data.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import modelos.vo.Estado;

public class EstadoDao {
    
    BaseDatos db = new BaseDatos();
    PreparedStatement stmt;
    ResultSet rs;
    String sql;
    Estado obj;
    
    public List Listar() {
        List<Estado> lista = new ArrayList<>();
        try {
            db.Conectar();
            sql = "select * from estadocliente";
            stmt = db.getConn().prepareStatement(sql);
            rs = db.EjecutarConsulta(stmt);
            while (rs.next()) {
                int estadoid = rs.getInt("stdcli");
                String estadodesc = rs.getString("stddesc");
                obj = new Estado(estadoid, estadodesc);
                lista.add(obj);
            }
            db.Cerrar();
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
        return lista;
    }
    
    public Estado Buscar(int id) {
        try {
            db.Conectar();
            sql = "select * from estadocliente where stdcli = ?";
            stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            rs = db.EjecutarConsulta(stmt);
            if (rs.next()) {
                int estadoid = rs.getInt("stdcli");
                String estadodesc = rs.getString("stddesc");
                obj = new Estado(estadoid, estadodesc);
            }
            db.Cerrar();
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
        return obj;
    }
    
}
