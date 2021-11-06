package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pessoasjuridicas")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa
{
	private static final long serialVersionUID = 1l;
	
	@Column(nullable = false)
	private long cnpj;
	
	@Column(length = 255, name = "nome_fantasia")
	private String nomeFantasia;
	
	public long getCnpj()
	{
		return cnpj;
	}
	
	public void setCnpj(long cnpj)
	{
		this.cnpj = cnpj;
	}
	
	public String getNomeFantasia()
	{
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia)
	{
		this.nomeFantasia = nomeFantasia;
	}
}
