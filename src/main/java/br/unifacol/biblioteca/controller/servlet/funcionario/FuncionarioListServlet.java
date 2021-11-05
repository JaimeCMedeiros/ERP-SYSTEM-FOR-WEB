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
import br.unifacol.biblioteca.servico.FuncionarioServi;


@WebServlet("/FuncionarioListServlet")
public class FuncionarioListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
		      response.setContentType("text/html");  
		      PrintWriter out=response.getWriter(); 
		      try {
			     FuncionarioServi funcionarioServi=new FuncionarioServi();
			     ArrayList<Funcionario> funcionarios=new ArrayList<Funcionario>();
			     funcionarios=funcionarioServi.listarFuncionarios();
			     out.println("<a href='http://localhost:8080/biblioteca/funcionario/funcionario_cadastrar.jsp'>Add Novo Funcionario</a>");  
			     out.println("<h1>Lista de Funcionario</h1>");  
			       
			     
			       
			     out.print("<table border='1' width='100%'");  
			     out.print("<tr><th>Id</th><th>NOME</th><th>CNPJ</th><th>IDADE</th><th>SEXO</th><th>Edit Funcionario</th><th>Delete Funcionario</th></tr>");  
			     System.out.println("nome :: " + funcionarios.size());
			     for(Funcionario e:funcionarios){  
			      out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getCnpj()+"</td><td>"+e.getIdade()+"</td><td>"+e.getSexo()+"<td><a href='FuncionarioEditarServlet?id="+e.getId()+
			    		  "'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></td></tr>");  
			     }  
			     out.print("</table>");  
			       
			     out.close(); 
		     } catch (Exception e) {
					System.out.println("Error - Conversao indisponivel:"+e.getMessage());
			}
			finally {
			      System.out.println("OPERACAO FINALIZADA");
		    }
	 } 


}
