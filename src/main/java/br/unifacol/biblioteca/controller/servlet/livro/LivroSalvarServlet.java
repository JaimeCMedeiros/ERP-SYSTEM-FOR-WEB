package br.unifacol.biblioteca.controller.servlet.livro;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.exceptions.AutorException;
import br.unifacol.biblioteca.servico.LivroServi;
import br.unifacol.biblioteca.servico.AutorServi;

@WebServlet("/LivroSalvarServlet")
public class LivroSalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
   	 
    	String titulo = req.getParameter("titulo");       
        String genero = req.getParameter("genero");
        String cnpj = req.getParameter("cnpj");
    	
       
    	 
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
    	try {
    		 
    		long id= Integer.parseInt(req.getParameter("id"));
    		
    		AutorServi autorServi=new AutorServi();           
            Autor autor=new Autor();
            if(id>0){
            	autor=autorServi.listarAutorPorCodigo(id);}
            else if(cnpj.length()>1){
            	autor=autorServi.listarAutorPorCnpj(cnpj);}
            
            System.out.println("autor.getNome:"+autor.getNome());
            
            LivroServi livroServ=new LivroServi();
            Livro novoLivro =new Livro();
            novoLivro.setAutor(autor);
            novoLivro.setTitulo(titulo);
            novoLivro.setGenero(genero);
            livroServ.salvar(novoLivro);
            printWriter.print("<h1>Livro Salvo</h1>");
            printWriter.print("<p> titulo :: " + titulo + "</p>");
            
		} catch (Exception e) {
			 printWriter.print("<h1>Livro NAO Salvo</h1>");
		        printWriter.print("<p> titulo :: " + titulo + "</p>");
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			printWriter.print("</body>");
	        printWriter.print("</html>");
	        printWriter.close();
		}

       
       
       

        
    }
}
