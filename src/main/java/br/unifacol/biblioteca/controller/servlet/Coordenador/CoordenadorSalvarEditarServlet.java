package br.unifacol.biblioteca.controller.servlet.Coordenador;
/*Jaime Costa Medeiros Junior
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import br.unifacol.biblioteca.entidade.Coordenador;
import br.unifacol.biblioteca.servico.CoordenadorServi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CoordenadorSalvarEditarServlet")
public class CoordenadorSalvarEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	try {
    		
    		String nome = req.getParameter("nome");    		 
            String cnpj = req.getParameter("cnpj");
            String idade = req.getParameter("idade");
            String sexo = req.getParameter("sexo");
			String codCord = req.getParameter("codCord");
             
    		long id = Integer.parseInt(req.getParameter("id"));
    		
            CoordenadorServi coordenadorServi=new CoordenadorServi();
            Coordenador coordenador=coordenadorServi.listarCoordenadorPorCodigo(id);
            coordenador.setNome(nome);
            coordenador.setCnpj(cnpj);
            coordenador.setIdade(idade);
            coordenador.setSexo(sexo);
			coordenador.setCodCord(codCord);
           
            System.out.println("ID :" + id);
   		 	System.out.println("nome" + nome);
            System.out.println("idade :" + idade);
            System.out.println("cnpj :" + cnpj);
            System.out.println("sexo :" + sexo);
			System.out.println("codCord :" + codCord);
            coordenadorServi.alterarCoordenador(coordenador);
           
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();
         
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
