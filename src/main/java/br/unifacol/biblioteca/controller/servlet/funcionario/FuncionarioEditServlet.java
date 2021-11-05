package br.unifacol.biblioteca.controller.servlet.funcionario;
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

import br.unifacol.biblioteca.entidade.Funcionario;
import br.unifacol.biblioteca.servico.FuncionarioServi; 

@WebServlet("/FuncionarioEditServlet")
public class FuncionarioEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Editar Funcionario</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        System.out.println("EDITAR");
        FuncionarioServi funcionarioServi=new FuncionarioServi();
        Funcionario funcionario=funcionarioServi.listarFuncionarioPorCodigo(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+funcionario.getId()+"'/></td></tr>");  
	    out.print("<tr><td>Name:</td><td><input type='text' name='nome' value='"+funcionario.getNome()+"'/></td></tr>"); 
	    out.print("<tr><td>Idade:</td><td><input type='text' name='idade' value='"+funcionario.getIdade()+"'/></td></tr>");			
	    out.print("<tr><td>CNPJ:</td><td><input type='text' name='cnpj' value='"+funcionario.getCnpj()+"'/></td></tr>"); 
	    out.print("<tr><td>Sexo:</td><td><input type='text' name='sexo' value='"+funcionario.getSexo()+"'/></td></tr>");
       
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
		  }  
}  