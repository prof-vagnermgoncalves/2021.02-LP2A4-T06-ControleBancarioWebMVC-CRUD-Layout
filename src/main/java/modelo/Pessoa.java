package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable
{
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(length = 255, nullable = false)
	protected String nome;
	
	@Column(length = 255)
	protected String endereco;
	
	protected long cep;
	
	@Column(length = 19) // +55 (11) 99999-9999
	protected String telefone;
	
	protected float renda;
	
	protected byte situacao;
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	protected Collection<ContaComum> contas;
	
	public Pessoa()
	{
		this.situacao = 1;
		this.contas = new ArrayList<ContaComum>();
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
	
	public long getCep()
	{
		return cep;
	}
	
	public void setCep(long cep)
	{
		this.cep = cep;
	}
	
	public String getTelefone()
	{
		return telefone;
	}
	
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	
	public float getRenda()
	{
		return renda;
	}
	
	public void setRenda(float renda)
	{
		this.renda = renda;
	}
	
	public byte getSituacao()
	{
		return situacao;
	}
	
	public void setSituacao(byte situacao)
	{
		this.situacao = situacao;
	}

	public Collection<ContaComum> getContas()
	{
		return contas;
	}

	public void setContas(Collection<ContaComum> contas)
	{
		this.contas = contas;
	}
}
