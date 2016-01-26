package teste.domain;

import java.util.Collection;

import teste.app.repositories.ContaBancariaRepository;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="ContasBancarias")
public class ContaBancaria {
	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField
	private int codigoBanco;
	
	@DatabaseField
	private String nome;
	
	@DatabaseField
	private double saldo;

	@ForeignCollectionField
	private	Collection<MovimentoBancario> movimentos;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(int codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Collection<MovimentoBancario> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(Collection<MovimentoBancario> movimentos) {
		this.movimentos = movimentos;
	}
}
