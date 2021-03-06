package energy.model;

import energy.dao.ClienteDAO;
import energy.dao.ExceptionDAO;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Pessoa {

    private int codigoDeCliente;
    private int contactoAlternativo;
    private ArrayList <Contador> numeroDeContador = new ArrayList<>();


    public Cliente(String nome, String apelido, Date dataDeNascimento, String estadoCivil, String profissao, String morada, String email, String numeroDeBI, int contacto, int contactoAlternativo, int nuit, String genero, ArrayList<Contador> numeroDeContador) {
        super(nome, apelido, dataDeNascimento, estadoCivil, profissao, morada, email, numeroDeBI, contacto, nuit, genero);

        this.numeroDeContador = numeroDeContador;
        this.contactoAlternativo = contactoAlternativo;
    }



    public Cliente(){

    }

    public Cliente(String nome, String apelido, Date dataDeNascimento, String estadoCivil, String profissao, String morada, String email, String numeroDeBI, int contacto, int contactoAlternativo, int nuit, String genero) {
        super(nome, apelido, dataDeNascimento, estadoCivil, profissao, morada, email, numeroDeBI, contacto, nuit, genero);
        this.contactoAlternativo = contactoAlternativo;
    }

    public int getCodigoDeCliente() {
        return codigoDeCliente;
    }

    public void setCodigoDeCliente(int codigoDeCliente) {
        this.codigoDeCliente = codigoDeCliente;
    }

    public int getContactoAlternativo() {
        return contactoAlternativo;
    }

    public void setContactoAlternativo(int contactoAlternativo) {
        this.contactoAlternativo = contactoAlternativo;
    }

    public ArrayList<Contador> getNumeroDeContador() {
        return numeroDeContador;
    }

    public void setNumeroDeContador(ArrayList<Contador> numeroDeContador) {
        this.numeroDeContador = numeroDeContador;
    }

    public void cadastarCliente(Cliente cliente) throws ExceptionDAO {
        new ClienteDAO().cadastrarCliente(cliente);
    }

    public ArrayList<Cliente> listarTodosOsClientes() throws ExceptionDAO{
        return new ClienteDAO().listarTodosClientes();
    }

    public ArrayList<Cliente> listarTodosOsClientesPorNome(String nome) throws ExceptionDAO{
        return new ClienteDAO().listarClientePorNome(nome);
    }

    public void alterarCliente(Cliente cliente) throws ExceptionDAO{
        new ClienteDAO().alterarCliente(cliente);
    }

    public Cliente encontrarClientePorID(int id) throws ExceptionDAO{
        return new ClienteDAO().encontrarClientePorID(id);
    }
}
