package controlador.pessoafisica;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import modelo.PessoaFisica;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.PessoaFisicaRepositorio;

/**
 * Servlet implementation class ExcluirPessoaFisicaServlet
 */
@WebServlet("/pessoafisica/excluir")
public class ExcluirPessoaFisicaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ExcluirPessoaFisicaServlet() { }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		int pessoaFisicaId = 0;
		PessoaFisica pessoaFisica = null;
		
		try
		{
			pessoaFisicaId = Integer.parseInt(request.getParameter("id").trim());
			
			PessoaFisicaRepositorio repositorio =
					new PessoaFisicaRepositorio();
			
			pessoaFisica = repositorio.recuperarPessoaFisicaPorId(pessoaFisicaId);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(pessoaFisica == null)
			pessoaFisica = new PessoaFisica();
		
		request.setAttribute("pessoaFisica", pessoaFisica);
		
		request.setAttribute("tituloPagina",
				"Excluir Pessoa Física");
		
		request.setAttribute("pathView",
				"/WEB-INF/views/pessoafisica/excluir.jsp");
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/WEB-INF/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		int id = 0;
		
		try
		{
			id = Integer.parseInt(request.getParameter("numId"));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(id > 0)
		{	
			PessoaFisicaRepositorio repositorio = new PessoaFisicaRepositorio();
			
			PessoaFisica pf = repositorio.recuperarPessoaFisicaPorId(id);
			
			repositorio.excluir(pf);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/pessoafisica");
		
		rd.forward(request, response);
	}
}
