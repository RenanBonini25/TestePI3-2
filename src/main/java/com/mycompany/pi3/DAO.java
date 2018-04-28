package com.mycompany.pi3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {
        //1A) Registrar drive JDBC
        Class.forName("com.mysql.jdbc.Driver");

        //1B) Abrir conexão com o BD
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
    }

    public static long incluir(Cliente cliente) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO cliente (NOME, CPF, SEXO, DTNASCIMENTO, ESTADOCIVIL, ENDERECO,"
                + "COMPLEMENTO, NUMERO, BAIRRO, CEP, CIDADE, ESTADO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        long idPessoa = 0;

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getSexo());
                stmt.setString(4, cliente.getDtNascimento());
//                Timestamp dataBD = new Timestamp(cliente.getDtNascimento().getTime());
//                stmt.setTimestamp(4, dataBD);
                stmt.setString(5, cliente.getEstadoCivil());
                stmt.setString(6, cliente.getEndereco());
                stmt.setString(7, cliente.getComplemento());
                stmt.setString(8, cliente.getNumero());
                stmt.setString(9, cliente.getBairro());
                stmt.setString(10, cliente.getCep());
                stmt.setString(11, cliente.getCidade());
                stmt.setString(12, cliente.getEstado());
                stmt.executeUpdate();

                try (ResultSet chave = stmt.getGeneratedKeys()) {
                    if (chave.next()) {
                        idPessoa = chave.getLong(1);
                    }
                }

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }

        return idPessoa;
    }

    public static ArrayList<Cliente> listar() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        Cliente cliente = new Cliente();
                        cliente.setId(resultados.getInt("ID"));
                        cliente.setNome(resultados.getString("NOME"));
                        cliente.setCpf(resultados.getString("CPF"));
                        cliente.setSexo(resultados.getString("SEXO"));
//                        Timestamp t = resultados.getTimestamp("DTNASCIMENTO");
                        String dataNasc = resultados.getString("DTNASCIMENTO");
//                        String data = formatador.format(t);
                        cliente.setDtNascimento(dataNasc);
//                        Date dataNasc = new Date();
//                        try {
//                            dataNasc = formatador.parse(data);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                        cliente.setDtNascimento(dataNasc);
                        cliente.setEstadoCivil(resultados.getString("ESTADOCIVIL"));
                        cliente.setEndereco(resultados.getString("ENDERECO"));
                        cliente.setComplemento(resultados.getString("COMPLEMENTO"));
                        cliente.setNumero(resultados.getString("NUMERO"));
                        cliente.setBairro(resultados.getString("BAIRRO"));
                        cliente.setCep(resultados.getString("CEP"));
                        cliente.setCidade(resultados.getString("CIDADE"));
                        cliente.setEstado(resultados.getString("ESTADO"));
                        listaClientes.add(cliente);

                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    public static ArrayList<Cliente> obterCliente(int id) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        String query = "SELECT * FROM CLIENTE WHERE ID = ?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);
                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        Cliente cliente = new Cliente();
                        cliente.setId(resultados.getInt("ID"));
                        cliente.setNome(resultados.getString("NOME"));
                        cliente.setCpf(resultados.getString("CPF"));
                        cliente.setSexo(resultados.getString("SEXO"));
                        cliente.setDtNascimento(resultados.getString("DTNASCIMENTO"));
                        cliente.setEstadoCivil(resultados.getString("ESTADOCIVIL"));
                        cliente.setEndereco(resultados.getString("ENDERECO"));
                        cliente.setComplemento(resultados.getString("COMPLEMENTO"));
                        cliente.setNumero(resultados.getString("NUMERO"));
                        cliente.setBairro(resultados.getString("BAIRRO"));
                        cliente.setCep(resultados.getString("CEP"));
                        cliente.setCidade(resultados.getString("CIDADE"));
                        cliente.setEstado(resultados.getString("ESTADO"));
                        clientes.add(cliente);
                        return clientes;
                    }
                }

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void atualizarCliente(Cliente cliente) {
        String query = "UPDATE CLIENTE SET NOME=?, CPF=?, SEXO=?, DTNASCIMENTO=?, ESTADOCIVIL=?,"
                + "ENDERECO=?, COMPLEMENTO=?, NUMERO=?, BAIRRO=?, CEP=?, CIDADE=?, ESTADO=? WHERE ID=?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getSexo());
                stmt.setString(4, cliente.getDtNascimento());
                stmt.setString(5, cliente.getEstadoCivil());
                stmt.setString(6, cliente.getEndereco());
                stmt.setString(7, cliente.getComplemento());
                stmt.setString(8, cliente.getNumero());
                stmt.setString(9, cliente.getBairro());
                stmt.setString(10, cliente.getCep());
                stmt.setString(11, cliente.getCidade());
                stmt.setString(12, cliente.getEstado());
                stmt.setInt(13, cliente.getId());

                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void excluirCliente(int id) {
        String query = "DELETE FROM CLIENTE WHERE ID = ?";
        try (Connection conn = obterConexao()) {
            try (PreparedStatement stmtCategoria = conn.prepareStatement(query)) {
                stmtCategoria.setInt(1, id);
                stmtCategoria.executeUpdate();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
