package energy.dao;

import java.sql.*;
import java.util.ArrayList;

import energy.model.Cliente;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente) throws ExceptionDAO{

        String sql = "insert into cliente (nome, apelido, palavraPasse, dataDeNascimento, estadoCivil, profissao, morada, email, numeroDeBI, contacto," +
                "contactoAlternativo, nuit, genero) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        Connection conexao = null;

        try {
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getApelido());
            preparedStatement.setString(3, cliente.getPalavraPasse());
            preparedStatement.setDate(4, new Date(cliente.getDataDeNascimento().getTime()));
            preparedStatement.setString(5, cliente.getEstadoCivil());
            preparedStatement.setString(6, cliente.getProfissao());
            preparedStatement.setString(7, cliente.getMorada());
            preparedStatement.setString(8, cliente.getEmail());
            preparedStatement.setString(9, cliente.getNumeroDeBI());
            preparedStatement.setInt(10, cliente.getContacto());
            preparedStatement.setInt(11, cliente.getContactoAlternativo());
            preparedStatement.setInt(12, cliente.getNuit());
            preparedStatement.setString(13, cliente.getGenero());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar cliente " + e);
        } finally {

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o Statement" + e);
            }


            try {
                if(conexao != null)
                    conexao.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }


        }

    }


    public ArrayList<Cliente> listarTodosClientes() throws ExceptionDAO{

        String querySQL = "select * from cliente";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Cliente> clientes = null;

        try {
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                clientes = new ArrayList<>();

                while (resultSet.next()){
                    Cliente cliente = new Cliente();

                    cliente.setCodigoDeCliente(resultSet.getInt(1));
                    cliente.setNome(resultSet.getString(2));
                    cliente.setApelido(resultSet.getString(3));
                    cliente.setPalavraPasse(resultSet.getString(4));
                    cliente.setDataDeNascimento(resultSet.getDate(5));
                    cliente.setEstadoCivil(resultSet.getString(6));
                    cliente.setProfissao(resultSet.getString(7));
                    cliente.setMorada(resultSet.getString(8));
                    cliente.setEmail(resultSet.getString(9));
                    cliente.setNumeroDeBI(resultSet.getString(10));
                    cliente.setContacto(resultSet.getInt(11));
                    cliente.setContactoAlternativo(resultSet.getInt(12));
                    cliente.setNuit(resultSet.getInt(13));
                    cliente.setGenero(resultSet.getString(14));

                    clientes.add(cliente);
                }
            }

        }catch (SQLException e){

        }

        return clientes;
    }


    public Cliente listarClientePorID(int id) throws ExceptionDAO{
        Cliente cliente = null;


        return cliente;
    }


    public ArrayList<Cliente> listarClientePorNome(String nome) throws ExceptionDAO{

        String sql = "select * from cliente where nome like '%" + nome + "%' order by nome";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        ArrayList<Cliente> clientes = null;

        try {
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                clientes = new ArrayList<>();
                while (resultSet.next()){

                    Cliente cliente = new Cliente();
                    cliente.setCodigoDeCliente(resultSet.getInt(1));
                    cliente.setNome(resultSet.getString(2));
                    cliente.setApelido(resultSet.getString(3));
                    cliente.setPalavraPasse(resultSet.getString(4));
                    cliente.setDataDeNascimento(resultSet.getDate(5));
                    cliente.setEstadoCivil(resultSet.getString(6));
                    cliente.setProfissao(resultSet.getString(7));
                    cliente.setMorada(resultSet.getString(8));
                    cliente.setEmail(resultSet.getString(9));
                    cliente.setNumeroDeBI(resultSet.getString(10));
                    cliente.setContacto(resultSet.getInt(11));
                    cliente.setContactoAlternativo(resultSet.getInt(12));
                    cliente.setNuit(resultSet.getInt(13));
                    cliente.setGenero(resultSet.getString(14));


                    clientes.add(cliente);

                }
            }



        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao consultar cliente " + e);
        }

        return clientes;
    }

    public Cliente encontrarClientePorEmail(String email) throws ExceptionDAO{


        String sql = "select * from cliente where email = ?";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        Cliente cliente = null;

        try {
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                cliente = new Cliente();

                cliente.setCodigoDeCliente(resultSet.getInt(1));
                cliente.setNome(resultSet.getString(2));
                cliente.setApelido(resultSet.getString(3));
                cliente.setPalavraPasse(resultSet.getString(4));
                cliente.setDataDeNascimento(resultSet.getDate(5));
                cliente.setEstadoCivil(resultSet.getString(6));
                cliente.setProfissao(resultSet.getString(7));
                cliente.setMorada(resultSet.getString(8));
                cliente.setEmail(resultSet.getString(9));
                cliente.setNumeroDeBI(resultSet.getString(10));
                cliente.setContacto(resultSet.getInt(11));
                cliente.setContactoAlternativo(resultSet.getInt(12));
                cliente.setNuit(resultSet.getInt(13));
                cliente.setGenero(resultSet.getString(14));

            }


        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao consultar cliente " + e);

        }finally {
            try {
                if(conexao != null)
                    conexao.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar a conexão " + e);
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }
        }



        return cliente;

    }

    public void alterarCliente(Cliente cliente) throws ExceptionDAO{
        String querySQL = "Update cliente set nome = ?, apelido = ?, dataDeNascimento = ?, estadoCivil = ?, profissao = ?," +
                " morada = ?, email = ?, numeroDeBI = ?, contacto = ?, contactoAlternativo = ?, nuit = ?, genero = ? where codigoDeCliente = ?";

        PreparedStatement preparedStatement = null;
        Connection conexao = null;

        try{
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getApelido());
            preparedStatement.setDate(3, new Date(cliente.getDataDeNascimento().getTime()));
            preparedStatement.setString(4, cliente.getEstadoCivil());
            preparedStatement.setString(5, cliente.getProfissao());
            preparedStatement.setString(6, cliente.getMorada());
            preparedStatement.setString(7, cliente.getEmail());
            preparedStatement.setString(8, cliente.getNumeroDeBI());
            preparedStatement.setInt(9, cliente.getContacto());
            preparedStatement.setInt(10, cliente.getContactoAlternativo());
            preparedStatement.setInt(11, cliente.getNuit());
            preparedStatement.setString(12, cliente.getGenero());
            preparedStatement.setInt(13, cliente.getCodigoDeCliente());
            preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao alternar cliente " + e);

        }finally {
            try {
                if(conexao != null)
                    conexao.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar a conexão " + e);
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }
        }
    }




}
