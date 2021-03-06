package energy.model;

import energy.dao.ExceptionDAO;
import energy.dao.FuncionarioDAO;

import java.util.ArrayList;
import java.util.Date;

public class Funcionario extends Pessoa{

    protected int numeroDeFuncionario;
    protected AreaDeServicoAoCliente localDeTrabalho;
    protected String categoria;
    protected EquipasDeTrabalho equipaDeTrabalho;

    protected String palavraPasse;
    protected int contactoAlternativo;

    public Funcionario(String nome, String apelido, Date dataDeNascimento, String estadoCivil, String nacionalidade, String morada, String email, String numeroDeBI, int contacto, int contactoAlternativo, int nuit, String genero, AreaDeServicoAoCliente localDeTrabalho, String categoria) {
        super(nome, apelido, dataDeNascimento, estadoCivil, nacionalidade, morada, email, numeroDeBI, contacto, nuit, genero);
        this.localDeTrabalho = localDeTrabalho;
        this.categoria = categoria;
        this.contactoAlternativo = contactoAlternativo;

    }

    public Funcionario(){}

    public EquipasDeTrabalho getEquipaDeTrabalho() {
        return equipaDeTrabalho;
    }

    public void setEquipaDeTrabalho(EquipasDeTrabalho equipaDeTrabalho) {
        this.equipaDeTrabalho = equipaDeTrabalho;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumeroDeFuncionario() {
        return numeroDeFuncionario;
    }

    public void setNumeroDeFuncionario(int numeroDeFuncionario) {
        this.numeroDeFuncionario = numeroDeFuncionario;
    }

    public int getContactoAlternativo() {
        return contactoAlternativo;
    }

    public void setContactoAlternativo(int contactoAlternativo) {
        this.contactoAlternativo = contactoAlternativo;
    }

    public AreaDeServicoAoCliente getLocalDeTrabalho() {
        return localDeTrabalho;
    }

    public void setLocalDeTrabalho(AreaDeServicoAoCliente localDeTrabalho) {
        this.localDeTrabalho = localDeTrabalho;
    }

    public void cadastarFuncionario(Funcionario funcionario) throws ExceptionDAO {
        new FuncionarioDAO().cadastrarFuncionario(funcionario);
    }

    public Funcionario encontrarFuncionarioPorEmail(String email)throws ExceptionDAO{
        return new FuncionarioDAO().encontrarFuncionarioPorEmail(email);
    }

    public void alterarFuncionario(Funcionario funcionario) throws ExceptionDAO {
        new FuncionarioDAO().alterarFuncionario(funcionario);
    }

    public void alterarSenha(Funcionario funcionario, String senha) throws ExceptionDAO{
        new FuncionarioDAO().alterarSenha(funcionario, senha);
    }

    public ArrayList<Funcionario> listarTodosFuncionarios() throws ExceptionDAO{
        return new FuncionarioDAO().listarTodosFuncionarios();
    }

    public String getPalavraPasse() {
        return palavraPasse;
    }

    public void setPalavraPasse(String palavraPasse) {
        this.palavraPasse = palavraPasse;
    }

    public void deletarFuncionario(Funcionario funcionario)throws ExceptionDAO{
        new FuncionarioDAO().deletarFuncionario(funcionario);
    }

    public Funcionario encontrarFuncionarioPorID(int id) throws ExceptionDAO{
        return new FuncionarioDAO().encontrarFuncionarioPorId(id);
    }

    public String toString(){
        return nome + " " + apelido;
    }

}
