package br.unifacol.biblioteca.controller.servlet.Leitor;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifacol.biblioteca.entidade.Leitor;
import br.unifacol.biblioteca.exceptions.LeitorException;
import br.unifacol.biblioteca.servico.LeitorServi;


@WebServlet("/LeitorAddServlet")
public class LeitorAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	
    	String nome = req.getParameter("nome");
		String sexo = req.getParameter("sexo");
		String idade = req.getParameter("idade");
		String cnpj = req.getParameter("cnpj");
        System.out.println("nome :: " + nome);
    	 
    	
    	try {
    		LeitorServi leitorServi=new LeitorServi();
        	Leitor novoLeitor=new  Leitor();
			byte[] array = new byte[7]; // length is bounded by 7
		    
			leitorServi.cadastrarLeitor(nome, sexo, idade , cnpj);
			
		} catch (LeitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Leitor Salvo</h1>");
        printWriter.print("<p> nome :: " + nome + "</p>");
        printWriter.print("<p> sexo :: " + sexo + "</p>");
        printWriter.print("<p> cnpj :: " + cnpj + "</p>");
        printWriter.print("<p> idade :: " + idade + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }  


}
