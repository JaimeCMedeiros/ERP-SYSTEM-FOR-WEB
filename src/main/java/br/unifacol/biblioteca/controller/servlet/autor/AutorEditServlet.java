package br.unifacol.biblioteca.controller.servlet.autor;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.servico.AutorServi;  


@WebServlet("/AutorEditServlet")
public class AutorEditServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Editar Autor</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        System.out.println("EDITAR");
        AutorServi autorServi=new AutorServi();
        Autor autor=autorServi.listarAutorPorCodigo(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+autor.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+autor.getNome()+"'/></td></tr>");  
        out.print("<tr><td>CNPG:</td><td><input type='text' name='text' value='"+autor.getCnpj()+"'/></td></tr>");  
        out.print("<tr><td>Idade:</td><td><input type='text' name='text' value='"+autor.getIdade()+"'/></td></tr>");
        out.print("<tr><td>Idade:</td><td><input type='text' name='text' value='"+autor.getSexo()+"'/></td></tr>");
        out.print("<tr><td>Livros:</td><td>");  
        out.print("<select name='livros' style='width:150px'>");  
		
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  
