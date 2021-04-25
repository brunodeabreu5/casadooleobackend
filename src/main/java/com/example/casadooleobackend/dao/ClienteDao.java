package com.example.casadooleobackend.dao;

import com.example.casadooleobackend.factory.ConnectionFactory;
import com.example.casadooleobackend.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    Connection connection;

    public ClienteDao () {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastraCliente (Cliente c) {
        String sql = "INSERT INTO cliente" +
                "(nome, endereco, email, telefone)" +
                "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEndereco());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefone());
            stmt.execute();
            stmt.close();
            System.out.println("funcionou");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente consultaClientePorId (int idCliente) {
        String sql = "SELECT * FROM  cliente WHERE idCliente =?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            Cliente cliente = new Cliente();

            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
            }
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Cliente alteraCliente (Cliente cliente, int idCliente) {
        String sql = "update cliente set nome=?,endereco=?,email=?,telefone=? where idCliente =?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setInt(5, idCliente);
            stmt.execute();
            stmt.close();

            Cliente clienteId = new Cliente();
            clienteId = this.consultaClientePorId(idCliente);

            return clienteId;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listaDeCliente () {
        String sql = "SELECT * FROM cliente";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            List<Cliente> clienteList = new ArrayList<>();

            ResultSet resultSet = st.executeQuery();

            Cliente cliente;
            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelefone(resultSet.getString("telefone"));

                clienteList.add(cliente);
            }
            return clienteList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeCliente (int idCliente) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from cliente where idCliente=?");
            stmt.setInt(1, idCliente);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
