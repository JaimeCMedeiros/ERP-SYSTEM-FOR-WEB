package br.unifacol.biblioteca.controller.servlet.funcionario;
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

import br.unifacol.biblioteca.entidade.Funcionario;
import br.unifacol.biblioteca.exceptions.FuncionarioException;
import br.unifacol.biblioteca.servico.FuncionarioServi;


@WebServlet("/FuncionarioEditarServlet")
public class FuncionarioEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	try {
    		long id = Integer.parseInt(req.getParameter("id"));
            
            System.out.println("ID :" + id);
            FuncionarioServi funcionarioServi=new FuncionarioServi();
            Funcionario funcionario=new  Funcionario();
            funcionario=funcionarioServi.listarFuncionarioPorCodigo(id);
            System.out.println("Nome :" + funcionario.getNome());
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();  
	        out.println("<h1>Editor Funcionario</h1>");
            out.print("<form action='FuncionarioSalvarEditarServlet' method='get'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+funcionario.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='nome' value='"+funcionario.getNome()+"'/></td></tr>"); 
			out.print("<tr><td>CNPJ:</td><td><input type='text' name='idade' value='"+funcionario.getIdade()+"'/></td></tr>");			
	        out.print("<tr><td>Idade:</td><td><input type='text' name='cnpj' value='"+funcionario.getCnpj()+"'/></td></tr>"); 
	        out.print("<tr><td>Sexo:</td><td><input type='text' name='sexo' value='"+funcionario.getSexo()+"'/></td></tr>");
	      
	        
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
