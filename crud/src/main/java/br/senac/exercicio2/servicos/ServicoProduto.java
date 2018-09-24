package br.senac.exercicio2.servicos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.senac.exercicio2.modelo.Produto;

@Path("/produto")
public class ServicoProduto {
	
	private static List<Produto> produtos = new ArrayList<Produto>();
	
	@GET
	@Path("produtos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listar() {
		return produtos;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Produto produto) {
		produtos.add(produto);
	}

	@POST
	@Path("produtos")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(List<Produto> produtos) {
		for (Produto produto : produtos) {
			ServicoProduto.produtos.add(produto);
		}
	}

	@POST
	@Path("pesquisa")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Produto getCliente(Produto produto) {
		for (Produto p : produtos) {
			if (p.getId() == produto.getId()) {
				return p;
			}
		}

		return new Produto();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterar(Produto produto) {
		for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()){
            	produtos.get(i).setProduto(produto);  
            
            }
        }

	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletar(Produto produto) {
		for (Iterator<Produto> i = produtos.iterator(); i.hasNext();) {
			Produto p = i.next();
			if (p.getId() == produto.getId()) {
				i.remove();
			}
		}

	}
}
