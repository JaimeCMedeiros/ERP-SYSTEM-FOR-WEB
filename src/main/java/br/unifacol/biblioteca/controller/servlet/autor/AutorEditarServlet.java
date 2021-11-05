package br.unifacol.biblioteca.controller.servlet.autor;
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

import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.exceptions.AutorException;
import br.unifacol.biblioteca.servico.AutorServi;


@WebServlet("/AutorEditarServlet")
public class AutorEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	try {
    		long id = Integer.parseInt(req.getParameter("id")); 
            
            System.out.println("ID :" + id); 
            AutorServi autorServi=new AutorServi(); 
            Autor autor=new  Autor();
            autor=autorServi.listarAutorPorCodigo(id); 
            System.out.println("Nome :" + autor.getNome()); 
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();  
	        out.println("<h1>Editar Autor</h1>");
            out.print("<form action='AutorSalvarEditarServlet' method='get'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+autor.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='nome' value='"+autor.getNome()+"'/></td></tr>");  
	        out.print("<tr><td>CNPJ:</td><td><input type='text' name='cnpj' value='"+autor.getCnpj()+"'/></td></tr>");  
	        out.print("<tr><td>Idade:</td><td><input type='text' name='idade' value='"+autor.getIdade()+"'/></td></tr>");
	        out.print("<tr><td>Sexo:</td><td><input type='text' name='sexo' value='"+autor.getSexo()+"'/></td></tr>");
	      
	        
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
