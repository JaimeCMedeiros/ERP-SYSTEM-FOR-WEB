package br.unifacol.biblioteca.view;

import java.util.ArrayList;

import br.unifacol.biblioteca.entidade.Autor;
import br.unifacol.biblioteca.entidade.Coordenador;
import br.unifacol.biblioteca.entidade.Livro;
import br.unifacol.biblioteca.repositorio.AutorRepo;
import br.unifacol.biblioteca.repositorio.CoordenadorRepo;
import br.unifacol.biblioteca.entidade.Funcionario;
import br.unifacol.biblioteca.entidade.Leitor;
import br.unifacol.biblioteca.repositorio.FuncionarioRepo;
import br.unifacol.biblioteca.repositorio.LeitorRepo;

public class MainAutor { 
	                     
	public static void main(String[]args) { 
		
	
		
	ArrayList<Livro> lv = new ArrayList<Livro>(); 
	
	Livro l = new Livro("ane","age","ali");
	
	lv.add(l);
		
	Autor aut = new Autor("jaime","costa","1231","3123", lv);
	
	AutorRepo at = new AutorRepo();
	at.salvar(aut);
	
	System.out.println(aut);
	
	Funcionario fuc = new Funcionario("funci","masculino","12","1231451");
	FuncionarioRepo fc = new FuncionarioRepo();
	fc.salvar(fuc);
	
	System.out.println(fuc);
	
	Leitor lei = new Leitor("Leito","Feminino","25","153425");
	LeitorRepo le = new LeitorRepo();
	le.salvar(lei);
	
	System.out.println(lei);
	
	Coordenador cor = new Coordenador("CordPe","Masculino","31","99481233","4142");
	CoordenadorRepo co = new CoordenadorRepo();
	co.salvar(cor);
		
	}
	
	
    
}
