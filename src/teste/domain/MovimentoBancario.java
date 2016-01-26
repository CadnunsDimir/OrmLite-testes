package teste.domain;

import java.util.Collection;

import teste.app.repositories.MovimentoBancarioRepository;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="MovimentosBancarios", daoClass=MovimentoBancarioRepository.class)
public class MovimentoBancario {

	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField
	private String data;
	
	@DatabaseField
	private double valor;
	
	@DatabaseField
	private String descricao;
	
	@DatabaseField(foreign=true)
	private ContaBancaria contaBancaria;
	
	public MovimentoBancario(){
		
	}
	public MovimentoBancario(String data, double valor, String descricao) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}
	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

}
