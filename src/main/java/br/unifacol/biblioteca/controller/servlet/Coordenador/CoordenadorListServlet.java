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
import br.unifacol.biblioteca.servico.CoordenadorServi;


@WebServlet("/CoordenadorListServlet")
public class CoordenadorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
		      response.setContentType("text/html");  
		      PrintWriter out=response.getWriter(); 
		      try {
			     CoordenadorServi coordenadorServi=new CoordenadorServi();
			     ArrayList<Coordenador> coordenadores=new ArrayList<Coordenador>();
			     coordenadores=coordenadorServi.listarCoordenadores();
			     out.println("<a href='http://localhost:8080/biblioteca/coordenador/coordenador_cadastrar.jsp'>Add Novo Coordenador</a>");  
			     out.println("<h1>Lista de Coordenador</h1>");  
			       
			     
			       
			     out.print("<table border='1' width='100%'");  
			     out.print("<tr><th>Id</th><th>NOME</th><th>CNPJ</th><th>IDADE</th><th>SEXO</th><th>CODIGO COORDENADOR</th><th>Edit Coordenador</th><th>Delete Coordenador</th></tr>");  
			     System.out.println("nome :: " + coordenadores.size());
			     for(Coordenador e:coordenadores){  
			      out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getCnpj()+"</td><td>"+e.getIdade()+"</td><td>"+e.getSexo()+"</td><td>"+e.getCodCord()+"<td><a href='CoordenadorEditarServlet?id="+e.getId()+
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
