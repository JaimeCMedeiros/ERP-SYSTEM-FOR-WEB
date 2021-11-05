package br.unifacol.biblioteca.controller.servlet.autor;
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

import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.exceptions.AutorException;
import br.unifacol.biblioteca.servico.AutorServi;


@WebServlet("/AutorSalvarEditarServlet")
public class AutorSalvarEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	try {
    		
    		
    		String nome = req.getParameter("nome");    		 
            String cnpj = req.getParameter("cnpj");
            String idade = req.getParameter("idade");
            String sexo = req.getParameter("sexo");
             
    		long id = Integer.parseInt(req.getParameter("id"));
    		
            AutorServi autorServi=new AutorServi();
            Autor autor=autorServi.listarAutorPorCodigo(id);
            autor.setNome(nome);
            autor.setCnpj(cnpj);
            autor.setIdade(idade);
            autor.setSexo(sexo);
           
           
            System.out.println("ID :" + id);
   		 	System.out.println("nome" + nome);
            System.out.println("idade :" + idade);
            System.out.println("cnpj :" + cnpj);
            System.out.println("sexo :" + sexo);
            autorServi.alterarAutor(autor);
           
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();
         
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
