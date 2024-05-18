package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ConsultarClienteDto;
import br.com.cotiinformatica.dtos.CriarClienteDto;
import br.com.cotiinformatica.dtos.EditarClienteDto;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClientesController {
	
	@PostMapping("criar")
	public String criar(@RequestBody CriarClienteDto dto) {
		
		try {
			
			Cliente cliente = new Cliente();
			cliente.setId(UUID.randomUUID());
			cliente.setNome(dto.getNomeCliente());
			cliente.setEmail(dto.getEmailCliente());
			cliente.setTelefone(dto.getTelefoneCliente());
			
			ClienteRepository repository = new ClienteRepository();
			repository.create(cliente);
			
			return ("Cliente Cadastrado com Sucesso.");
			
		} catch (Exception e) {			
			return "ERRO:" +e.getMessage();			
		}		
	}
	
	@PutMapping("editar")
	public String editar(@RequestBody EditarClienteDto dto) {
		
		try {
		
			Cliente cliente = new Cliente();
			cliente.setId(dto.getIdCliente());
			cliente.setNome(dto.getNomeCliente());
			cliente.setEmail(dto.getEmailCliente());
			cliente.setTelefone(dto.getTelefoneCliente());
			ClienteRepository repository = new ClienteRepository();
			repository.update(cliente);
			
			return "Cliente alterado com sucesso.";
			
		} catch (Exception e) {
			return "ERRO: " + e.getMessage();
		}		
	}
	
	@DeleteMapping("excluir/{idCliente}")
	public String delete(@PathVariable("idCliente") UUID idCliente) {
		
		try {
			
			ClienteRepository repository = new ClienteRepository();
			repository.delete(idCliente);
			return "Cliente Excluído com Sucesso";
			
		} catch (Exception e) {
			return "ERRO: " + e.getMessage();
		}		
	}
	
	@GetMapping("consultar")
	public List<ConsultarClienteDto> getAll() {
		
		try {
			
			ClienteRepository repository = new ClienteRepository();
			List<Cliente> lista = repository.findAll();
			
			List<ConsultarClienteDto> clientes = new ArrayList<ConsultarClienteDto>();
			
			for (Cliente cliente : lista) {
				ConsultarClienteDto dto = new ConsultarClienteDto();
				dto.setIdCliente(cliente.getId());
				dto.setNomeCliente(cliente.getNome());
				dto.setEmailCliente(cliente.getEmail());
				dto.setTelefoneCliente(cliente.getTelefone());
				clientes.add(dto);
			}
			return clientes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
