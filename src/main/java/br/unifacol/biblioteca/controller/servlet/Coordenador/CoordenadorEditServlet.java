package br.unifacol.biblioteca.controller.servlet.Coordenador;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;  
import java.io.PrintWriter; 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifacol.biblioteca.entidade.Coordenador;
import br.unifacol.biblioteca.servico.CoordenadorServi; 

@WebServlet("/CoordenadorEditServlet")
public class CoordenadorEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Editar Coordenador</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        System.out.println("EDITAR");
        CoordenadorServi coordenadorServi=new CoordenadorServi();
        Coordenador coordenador=coordenadorServi.listarCoordenadorPorCodigo(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+coordenador.getId()+"'/></td></tr>");  
	    out.print("<tr><td>Name:</td><td><input type='text' name='nome' value='"+coordenador.getNome()+"'/></td></tr>"); 
	    out.print("<tr><td>Idade:</td><td><input type='text' name='idade' value='"+coordenador.getIdade()+"'/></td></tr>");			
	    out.print("<tr><td>CNPJ:</td><td><input type='text' name='cnpj' value='"+coordenador.getCnpj()+"'/></td></tr>"); 
	    out.print("<tr><td>Sexo:</td><td><input type='text' name='sexo' value='"+coordenador.getSexo()+"'/></td></tr>");
		out.print("<tr><td>CodigoCord:</td><td><input type='text' name='cordCord' value='"+coordenador.getSexo()+"'/></td></tr>");
       
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
		  }  



}
