package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.TemaDAO;
import modelo.dominio.Tema;

/**
 * Servlet implementation class ServletAbrirAlteracao
 */
@WebServlet("/editar")
public class ServletAbrirAlteracao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAbrirAlteracao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");
		Integer id = Integer.parseInt(idStr);
		
		// criar instância do DAO para persistência
		TemaDAO dao = new TemaDAO();

		// carregar o Tema escolhido do banco
		Tema tem = dao.obter(id);
		
		// guardar o Tema no request para ser lido pela página
		request.setAttribute("tem", tem);
		
		// criar um objeto para despachar a requisição
		RequestDispatcher desp = request.getRequestDispatcher("temaEditar.jsp");
		// encaminhar para o servlet ou página selecionada
		desp.forward(request, response);
	}


}
