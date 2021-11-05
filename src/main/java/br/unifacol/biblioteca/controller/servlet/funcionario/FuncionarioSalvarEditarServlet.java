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


@WebServlet("/FuncionarioSalvarEditarServlet")
public class FuncionarioSalvarEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	try {
    		
    		String nome = req.getParameter("nome");    		 
            String cnpj = req.getParameter("cnpj");
            String idade = req.getParameter("idade");
            String sexo = req.getParameter("sexo");
             
    		long id = Integer.parseInt(req.getParameter("id"));
    		
            FuncionarioServi funcionarioServi=new FuncionarioServi();
            Funcionario funcionario=funcionarioServi.listarFuncionarioPorCodigo(id);
            funcionario.setNome(nome);
            funcionario.setCnpj(cnpj);
            funcionario.setIdade(idade);
            funcionario.setSexo(sexo);
           
            System.out.println("ID :" + id);
   		 	System.out.println("nome" + nome);
            System.out.println("idade :" + idade);
            System.out.println("cnpj :" + cnpj);
            System.out.println("sexo :" + sexo);
            funcionarioServi.alterarFuncionario(funcionario);
           
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();
         
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
