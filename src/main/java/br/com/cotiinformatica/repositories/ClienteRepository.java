package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ClienteRepository {
	
	public void create(Cliente cliente) throws Exception{
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("insert into cliente(id, nome, email, telefone) values(?,?,?,?)");
		statement.setObject(1, cliente.getId());
		statement.setString(2, cliente.getNome());
		statement.setString(3, cliente.getEmail());
		statement.setString(4, cliente.getTelefone());
		statement.execute();
		connection.close();		
	}
	
	public void update(Cliente cliente) throws Exception{
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement
				("update cliente set nome=?, email=?, telefone=? where id=?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setObject(4, cliente.getId());
		statement.execute();
		connection.close();
	}
	
	public void delete(UUID id)throws Exception{
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement
				("delete from cliente where id=?");
		statement.setObject(1, id);
		statement.execute();
		connection.close();		
	}
	
	public List<Cliente> findAll() throws Exception{
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement
				("select * from cliente order by nome");
		ResultSet result = statement.executeQuery();
		List<Cliente> lista = new ArrayList<Cliente>();		
		while(result.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(UUID.fromString(result.getString("id")));
			cliente.setNome(result.getString("nome"));
			cliente.setEmail(result.getString("email"));
			cliente.setTelefone(result.getString("telefone"));
			lista.add(cliente);
		}
		connection.close();
		return lista;		
	}
	
	public Cliente findById(UUID id) throws Exception{
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement
				("select * from cliente where id=?");
		statement.setObject(1, id);
		ResultSet result = statement.executeQuery();
		Cliente cliente = null;
		if(result.next()) {
			cliente = new Cliente();
			cliente.setId(UUID.fromString(result.getString("id")));
			cliente.setNome(result.getString("nome"));
			cliente.setEmail(result.getString("email"));
			cliente.setTelefone(result.getString("telefone"));
		}
		connection.close();
		return cliente;
	}

}
