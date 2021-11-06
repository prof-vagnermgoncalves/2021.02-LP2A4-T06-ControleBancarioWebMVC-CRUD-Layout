package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contascomuns")
public class ContaComum implements Serializable
{
	private static final long serialVersionUID = 1l;
	
	@Id
	protected long numero;
	
	@Column(name = "data_abertura", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date abertura;
	
	@Column(name = "data_fechamento")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date fechamento;
	
	protected byte situacao;
	
	protected int senha;
	
	protected double saldo;
	
	public ContaComum(long numero, Date abertura)
	{
		this.numero = numero;
		this.abertura = abertura;		
		this.saldo = 0.0;
		this.situacao = 1;
	}
	
	public ContaComum()
	{
		this.numero = ContaComum.obterNumeroContaAleatorio();
		this.abertura = new Date();		
		this.saldo = 0.0;
		this.situacao = 1;
	}
	
	public Date getFechamento()
	{
		return fechamento;
	}
	
	public void setFechamento(Date fechamento)
	{
		this.fechamento = fechamento;
	}
	
	public byte getSituacao()
	{
		return situacao;
	}
	
	public void setSituacao(byte situacao)
	{
		this.situacao = situacao;
	}
	
	public int getSenha()
	{
		return senha;
	}
	
	public void setSenha(int senha)
	{
		this.senha = senha;
	}
	
	public double getSaldo()
	{
		return saldo;
	}
	
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}
	
	public long getNumero()
	{
		return numero;
	}
	
	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	public Date getAbertura()
	{
		return abertura;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

	public static ContaComum abrirConta()
	{
		// Número (pseudo)aleatório para a nova conta comum.
		// Não trata a possibidade de ser gerado um número já utilizado no banco de dados. 
		long n = obterNumeroContaAleatorio();
		
		// Data de abertura da conta
		Date abertura = new Date();
		
		// Criação da conta
		ContaComum cc = new ContaComum(n, abertura);
		
		return cc;
	}
	
	public static long obterNumeroContaAleatorio()
	{
		// Gerar um número de conta (pseudo)aleatório.
		Random r = new Random();
		long n = r.nextLong();
		if(n < Long.MAX_VALUE && n != -1) n++;
		if(n < 0) n = n*(-1);
		return n;
	}
}
