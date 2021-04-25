package com.example.casadooleobackend.dao;

import com.example.casadooleobackend.factory.ConnectionFactory;
import com.example.casadooleobackend.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VeiculoDao {

    Connection connection;

    public VeiculoDao () {

        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastraVeiculo (Veiculo v) {
        String sql = "INSERT INTO veiculos" +
                "(marca, modelo, placaDoVeiculo, ano)" +
                "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, v.getMarca());
            stmt.setString(2, v.getModelo());
            stmt.setString(3, v.getPlacaDoVeiculo());
            stmt.setInt(4, v.getAno());

            stmt.execute();
            stmt.close();
            System.out.println("funcionou");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Veiculo alteraVeiculo (Veiculo v, int idVeiculos) {
        String sql = "update veiculos set marca=?,modelo=?,placaDoVeiculo=?,ano=? where idVeiculos =?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, v.getMarca());
            stmt.setString(2, v.getModelo());
            stmt.setString(3, v.getPlacaDoVeiculo());
            stmt.setInt(4, v.getAno());
            stmt.setInt(5, idVeiculos);
            stmt.execute();
            stmt.close();

            Veiculo veiculo = new Veiculo();
            veiculo = this.consultaVeiculoPorId(idVeiculos);

            return veiculo;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Veiculo consultaVeiculoPorId (int id) {
        String sql = "SELECT * FROM  veiculos WHERE idVeiculos =?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Veiculo veiculo1 = new Veiculo();

            while (rs.next()) {
                veiculo1.setIdVeiculos(rs.getInt("idVeiculos"));
                veiculo1.setMarca(rs.getString("marca"));
                veiculo1.setModelo(rs.getString("modelo"));
                veiculo1.setPlacaDoVeiculo(rs.getString("placaDoVeiculo"));
                veiculo1.setAno(rs.getInt("Ano"));
            }
            return veiculo1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Veiculo> listaDeVeiculos () {
        String sql = "SELECT * FROM veiculos";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            List<Veiculo> veiculos = new ArrayList<>();

            ResultSet resultSet = st.executeQuery();

            Veiculo veiculo;
            while (resultSet.next()) {
                veiculo = new Veiculo();
                veiculo.setIdVeiculos(resultSet.getInt("idVeiculos"));
                veiculo.setMarca(resultSet.getString("marca"));
                veiculo.setModelo(resultSet.getString("modelo"));
                veiculo.setPlacaDoVeiculo(resultSet.getString("placaDoVeiculo"));
                veiculo.setAno(resultSet.getInt("ano"));

                veiculos.add(veiculo);
            }
            return veiculos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeVeiculo (int idVeiculo) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from veiculos where idVeiculos=?");
            stmt.setInt(1, idVeiculo);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
