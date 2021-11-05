package br.unifacol.biblioteca.controller.servlet.autor;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.exceptions.AutorException;
import br.unifacol.biblioteca.servico.AutorServi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AutorAddServlet") 
public class AutorAddServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	
    	
    	String nome = req.getParameter("nome");
		String sexo = req.getParameter("sexo");
		String idade = req.getParameter("idade");
		String cnpj = req.getParameter("cnpj");
        System.out.println("nome :: " + nome);
    	 
    	
    	try {
    		AutorServi autorServi=new AutorServi(); 
        	Autor novoAutor=new  Autor();
			List<Livro> livrosAutor=new LinkedList<Livro>(); 
			byte[] array = new byte[7]; // length is bounded by 7
		    
			Livro capaDura=new Livro("Acao","Kannon22",String.valueOf(new Random().nextInt())); 
			livrosAutor.add(capaDura); 
			
			autorServi.cadastrarAutor(nome, sexo, cnpj , idade, livrosAutor);
			
		} catch (AutorException e) { 
			e.printStackTrace();
		}
         
        resp.setContentType("text/html"); 
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Autor Salvo</h1>");
        printWriter.print("<p> nome :: " + nome + "</p>");
        printWriter.print("<p> sexo :: " + sexo + "</p>");
        printWriter.print("<p> cnpj :: " + cnpj + "</p>");
        printWriter.print("<p> idade :: " + idade + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }  
}
