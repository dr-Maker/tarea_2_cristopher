package modelos.dao;

import data.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.vo.Cliente;
import java.util.List;
import java.util.ArrayList;
import modelos.vo.Estado;
import modelos.vo.Tipocli;

public class ClienteDao {

    BaseDatos db = new BaseDatos();
    PreparedStatement stmt;
    ResultSet rs;
    String sql;
    Cliente obj;
    
    EstadoDao daoe = new EstadoDao();
    TipocliDao daot = new TipocliDao();

    public List Listar() {
        List<Cliente> lista = new ArrayList<>();
        try {
            db.Conectar();
            sql = "sp_listar_cliente";
            stmt = db.getConn().prepareStatement(sql);
            rs = db.EjecutarConsulta(stmt);
            while (rs.next()) {
                int clienteid = rs.getInt("clienteid");
                String nombre = rs.getString("nombres");
                String apellido = rs.getString("apellidos");
                String email = rs.getString("email");
                String fono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                int renta = rs.getInt("renta");
                int estadoid = rs.getInt("stdcli");
                int tipoid = rs.getInt("tipocliid");

                String estadodesc = rs.getString("stddesc");
                String tipodesc = rs.getString("tipodesc");

                Estado estado = new Estado(estadoid, estadodesc);
                Tipocli tipo = new Tipocli(tipoid, tipodesc);

                obj = new Cliente(clienteid, nombre, apellido, email, fono, edad, renta, estado, tipo);

                // obj = new Cliente(productoid, nombre, precio, new Estado(estadoid, estadodesc), new Tipocli(familiaid, familiadesc));
                lista.add(obj);
            }
            db.Cerrar();
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
        return lista;
    }

    public Cliente Buscar(int id) {
        try {
            db.Conectar();
            sql = "sp_buscar_cliente ?";
            stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            rs = db.EjecutarConsulta(stmt);
            if (rs.next()) {
                obj = new Cliente();
                
               
                obj.setClienteid(rs.getInt("clienteid"));
                obj.setNombre(rs.getString("nombres"));
                obj.setApellido(rs.getString("apellidos"));
                obj.setEmail(rs.getString("email"));
                obj.setFono(rs.getString("telefono"));
                obj.setEdad(rs.getInt("edad"));
                obj.setRenta(rs.getInt("renta"));
                
                EstadoDao daoe = new EstadoDao();
                obj.setEstado(daoe.Buscar(rs.getInt("stdcli")));
                    
                TipocliDao daotipo = new TipocliDao();
                obj.setTipo(daotipo.Buscar(rs.getInt("tipocliid")));
               
 
                       
                // objetos     
                //Estado estado = new Estado(, 
                //rs.getString("stddesc"));
                //Tipocli tipo = new Tipocli(), rs.getString("tipodesc"));
                //obj.setEstado(estado);
                //obj.setTipo(tipo);
                
                
            } 
            db.Cerrar();
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
        return obj;
    }

    public Cliente BuscarOld(int id) {
        try {
            db.Conectar();
            sql = "sp_buscar_cliente ?";
            stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, id); 
            rs = db.EjecutarConsulta(stmt);
            if (rs.next()) {
                int clienteid = rs.getInt("clienteid");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String esta_es_mi_variable_terrible_de_pulenta = rs.getString("email");
                String fono = rs.getString("fono");
                int edad = rs.getInt("edad");
                int renta = rs.getInt("renta");
                int estadoid = rs.getInt("estadoid");
                int tipoid = rs.getInt("tipoid");
                String estadodesc = rs.getString("estadodesc");
                String tipodesc = rs.getString("tipodesc");

                Estado estado = new Estado(estadoid, estadodesc);
                Tipocli tipo = new Tipocli(tipoid, tipodesc);

                obj = new Cliente(clienteid, nombre, apellido, esta_es_mi_variable_terrible_de_pulenta, fono, edad, renta, estado, tipo);
            }
            db.Cerrar();
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
        return obj;
    }

    public boolean Insert(Cliente obj) {
        int edad = obj.getEdad();
        int renta = obj.getRenta();
        int tipocliente = 0;
        boolean estado = false;
        
        if(edad>18 & edad<25)
        {
            if(renta <5000000)
            {
                //Silver
                tipocliente = 1;
            }
        }
        else
        {   
            //Gold
            tipocliente = 2;
        }

        
        try {
            db.Conectar();
            sql = "insert into cliente "
                    + "(nombres, apellidos, email, telefono, edad, renta, tipocliid) "
                    + "values(?, ?, ?, ?, ?, ?, ?)";
            stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, obj.getNombre());
            stmt.setString(2, obj.getApellido());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getFono());
            stmt.setInt(5, obj.getEdad());
            stmt.setInt(6, obj.getRenta());
            stmt.setInt(7, tipocliente);
            db.EjecutarAccion(stmt);
            db.Cerrar();
            estado = true;
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
        
        return estado;
    }

    public void Update(Cliente obj) {
        try {
            db.Conectar();
            sql = "update cliente set "
                    + "nombres = ?, "
                    + "apellidos = ?, "
                    + "email = ?, "
                    + "telefono = ?, "
                    + "edad = ?, "
                    + "renta = ? "
                    + "where clienteid = ?";
            stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, obj.getNombre());
            stmt.setString(2, obj.getApellido());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getFono());
            stmt.setInt(5, obj.getEdad());
            stmt.setInt(6, obj.getRenta());
            stmt.setInt(7, obj.getClienteid());
            db.EjecutarAccion(stmt);
            db.Cerrar();
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
    }

    public void UpdateSTD(int std, int id) {
        try {
            db.Conectar();
            sql = "update cliente set "
                    + "stdcli = ? "
                    + "where clienteid = ?";
            stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, std);
            stmt.setInt(2, id);
            db.EjecutarAccion(stmt);
            db.Cerrar();
        } catch (SQLException exe) {
            System.out.println(exe.getMessage());
        }
    }
}
