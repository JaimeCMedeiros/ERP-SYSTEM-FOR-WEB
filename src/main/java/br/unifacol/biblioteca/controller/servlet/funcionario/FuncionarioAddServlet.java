package br.unifacol.biblioteca.controller.servlet.funcionario;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.unifacol.biblioteca.entidade.Funcionario;
import br.unifacol.biblioteca.exceptions.FuncionarioException;
import br.unifacol.biblioteca.servico.FuncionarioServi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FuncionarioAddServlet")
public class FuncionarioAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
         	
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	
    	String nome = req.getParameter("nome");
		String sexo = req.getParameter("sexo");
		String idade = req.getParameter("idade");
		String cnpj = req.getParameter("cnpj");
        System.out.println("nome :: " + nome);
    	 
    	
    	try {
    		FuncionarioServi funcionarioServi=new FuncionarioServi();
        	Funcionario novoFuncionario=new  Funcionario();
			byte[] array = new byte[7]; // length is bounded by 7
		    
			funcionarioServi.cadastrarFuncionario(nome, sexo, idade , cnpj);
			
		} catch (FuncionarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Funcionario Salvo</h1>");
        printWriter.print("<p> nome :: " + nome + "</p>");
        printWriter.print("<p> sexo :: " + sexo + "</p>");
        printWriter.print("<p> cnpj :: " + cnpj + "</p>");
        printWriter.print("<p> idade :: " + idade + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }  


}
