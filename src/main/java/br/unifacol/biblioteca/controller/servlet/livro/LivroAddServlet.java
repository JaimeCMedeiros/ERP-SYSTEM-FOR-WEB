package br.unifacol.biblioteca.controller.servlet.livro;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.entidade.Autor;

import br.unifacol.biblioteca.exceptions.AutorException;
import br.unifacol.biblioteca.servico.LivroServi;
import br.unifacol.biblioteca.servico.AutorServi;


@WebServlet("/LivroAddServlet")
public class LivroAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
    		long id = Integer.parseInt(req.getParameter("id"));
    		 
    		AutorServi autorServi =new AutorServi();           
            Autor autor =new  Autor();
            autor=autorServi.listarAutorPorCodigo(id);
            LivroServi livroServ=new LivroServi();
            
            System.out.println("ID :: " + id);
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();  
           
	        out.println("<h1>NOVO Livro</h1>");
            out.print("<form action='LivroSalvarServlet' method='get'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+id+"'/></td></tr>");  
	        out.print("<tr><td>Titulo:</td><td><input type='text' name='titulo' value=''/></td></tr>");  	       
	        out.print("<tr><td>Genero:</td><td><input type='text' name='genero' value=''/></td></tr>");  
	        
	        out.print("<tr><td colspan='2'><input type='submit' value='Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  

	        out.print("<table border='1' width='100%'");  
		    out.print("<tr><th>Id</th><th>TITULO</th><th>GENERO</th><th>IDENTIFICADOR</th><th>Delete</th></tr>");  
		      
		     for(Livro e:livroServ.consultarPorIdAutor(id)){  
		      out.print("<tr><td>"+e.getId()+"</td><td>"+e.getTitulo()+"</td><td>"+e.getGenero()+"</td> <td>"+e.getIdentificador()+"</td></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
		     }  
		     out.print("</table>");  
		       
		     out.close(); 
	          
	        out.close();  
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
}
