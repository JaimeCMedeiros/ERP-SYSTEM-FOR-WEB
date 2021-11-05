package br.unifacol.biblioteca.controller.servlet.Leitor;
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

import br.unifacol.biblioteca.entidade.Leitor;
import br.unifacol.biblioteca.exceptions.LeitorException;
import br.unifacol.biblioteca.servico.LeitorServi;

@WebServlet("/LeitorEditarServlet")
public class LeitorEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	try {
    		long id = Integer.parseInt(req.getParameter("id"));
            
            System.out.println("ID :" + id);
            LeitorServi leitorServi=new LeitorServi();
            Leitor leitor=new  Leitor();
            leitor=leitorServi.listarLeitorPorCodigo(id);
            System.out.println("Nome :" + leitor.getNome());
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();  
	        out.println("<h1>Editor Leitor</h1>");
            out.print("<form action='LeitorSalvarEditarServlet' method='get'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+leitor.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='nome' value='"+leitor.getNome()+"'/></td></tr>"); 
			out.print("<tr><td>Idade:</td><td><input type='text' name='idade' value='"+leitor.getIdade()+"'/></td></tr>");			
	        out.print("<tr><td>CNPJ:</td><td><input type='text' name='cnpj' value='"+leitor.getCnpj()+"'/></td></tr>"); 
	        out.print("<tr><td>Sexo:</td><td><input type='text' name='sexo' value='"+leitor.getSexo()+"'/></td></tr>");
	      
	        
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
