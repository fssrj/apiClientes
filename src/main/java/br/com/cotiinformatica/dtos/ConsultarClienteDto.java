package br.com.cotiinformatica.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class ConsultarClienteDto {
	
	private UUID idCliente;
	private String nomeCliente;
	private String emailCliente;
	private String telefoneCliente;

}
