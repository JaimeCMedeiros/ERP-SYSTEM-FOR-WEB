package br.unifacol.biblioteca.controller.servlet.Coordenador;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifacol.biblioteca.entidade.Coordenador;
import br.unifacol.biblioteca.exceptions.CoordenadorException;
import br.unifacol.biblioteca.servico.CoordenadorServi;


@WebServlet("/CoordenadorEditarServlet")
public class CoordenadorEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	try {
    		long id = Integer.parseInt(req.getParameter("id"));
            
            System.out.println("ID :" + id);
            CoordenadorServi coordenadorServi=new CoordenadorServi();
            Coordenador coordenador=new  Coordenador();
            coordenador=coordenadorServi.listarCoordenadorPorCodigo(id);
            System.out.println("Nome :" + coordenador.getNome());
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();  
	        out.println("<h1>Editor Coordenador</h1>");
            out.print("<form action='CoordenadorSalvarEditarServlet' method='get'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+coordenador.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='nome' value='"+coordenador.getNome()+"'/></td></tr>"); 
			out.print("<tr><td>CNPJ:</td><td><input type='text' name='idade' value='"+coordenador.getIdade()+"'/></td></tr>");			
	        out.print("<tr><td>Idade:</td><td><input type='text' name='cnpj' value='"+coordenador.getCnpj()+"'/></td></tr>"); 
	        out.print("<tr><td>Sexo:</td><td><input type='text' name='sexo' value='"+coordenador.getSexo()+"'/></td></tr>");
			out.print("<tr><td>CodigoCord:</td><td><input type='text' name='codCord' value='"+coordenador.getCodCord()+"'/></td></tr>");
	      
	        
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }



}
