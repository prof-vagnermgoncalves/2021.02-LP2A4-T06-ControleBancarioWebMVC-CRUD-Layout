package modelo.repositorio;

import modelo.ContaComum;

public class ContaComumRepositorio extends Repositorio<ContaComum>
{
	public ContaComum recuperarContaComumPorNumero(long numero)
	{
		ContaComum resultado = null;
		
		try
		{
			resultado =
					PersistenceConfig.getEntityManager()
					.find(ContaComum.class, numero);
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar recuperar a conta comum! " +
					e.getMessage());
		}
		
		return resultado;
	}
}
