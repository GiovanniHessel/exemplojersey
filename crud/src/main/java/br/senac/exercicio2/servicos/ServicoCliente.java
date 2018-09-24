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

import br.senac.exercicio2.modelo.Cliente;

@Path("/cliente")
public class ServicoCliente {
	private static List<Cliente> listaClientes = new ArrayList<Cliente>();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserirCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}

	@POST
	@Path("clientes")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserirClientes(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			listaClientes.add(cliente);
		}
	}

	@GET
	@Path("clientes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listarClientes() {
		return listaClientes;
	}

	@POST
	@Path("pesquisa")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Cliente getCliente(Cliente cliente) {
		for (Cliente cli : listaClientes) {
			if (cli.getCpf().equals(cliente.getCpf())) {
				return cli;
			}
		}

		return new Cliente();
	}
	
	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterarCliente(Cliente cliente) {
		for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(cliente.getCpf())) {
            	listaClientes.get(i).setNome(cliente.getNome());
            }
        }

	}
	
	@DELETE
	@Path("deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarCliente(Cliente cliente) {
		for (Iterator<Cliente> i = listaClientes.iterator(); i.hasNext();) {
			Cliente cli = i.next();
			if (cli.getCpf().equals(cliente.getCpf())) {
				i.remove();
			}
		}

	}
}