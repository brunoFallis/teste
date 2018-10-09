package br.com.cast.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.dao.PessoaDAO;
import br.com.cast.dto.EnderecoDTO;
import br.com.cast.dto.PessoaDTO;
import br.com.cast.models.Endereco;
import br.com.cast.models.Pessoa;

public class BusinessPessoa {

	PessoaDAO pessoaDAO = new PessoaDAO();
	
	public void atualizaPessoa(PessoaDTO pessoaDTO) {
		
		Pessoa pessoa = pessoaDAO.buscaPorCpf(pessoaDTO.getCpf());
		
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setEmail(pessoaDTO.getEmail());
		
		EnderecoDTO enderecoDTO = pessoaDTO.getEnderecoDTO();
		
		Endereco endereco = new Endereco();
		
		endereco.setCep(enderecoDTO.getCep());
		endereco.setLogradouro(enderecoDTO.getLogradouro());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setUf(enderecoDTO.getUf());
		
		pessoa.setEndereco(endereco);
		
		pessoaDAO.update(pessoa);
		
	}

	
	public void excluirPessoa(String cpf) {
		pessoaDAO.excluir(cpf);
	}

	public void inserirPessoa(PessoaDTO pessoaDTO) {

		pessoaDAO.inserirPessoa(mapeiaParaPessoa(pessoaDTO));

	}

	public List<PessoaDTO> buscaTodos() {

		List<PessoaDTO> dtoList = new ArrayList<>();

		for (Pessoa p : this.pessoaDAO.buscaTodos()) {
			dtoList.add(mapeiaParaPessoaDTO(p));
		}

		return dtoList;

	}

	public Pessoa mapeiaParaPessoa(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa();

		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setEmail(pessoaDTO.getEmail());

		Endereco endereco = new Endereco();

		EnderecoDTO eDTO = pessoaDTO.getEnderecoDTO();

		endereco.setCep(eDTO.getCep());
		endereco.setLogradouro(eDTO.getLogradouro());
		endereco.setNumero(eDTO.getNumero());
		endereco.setComplemento(eDTO.getComplemento());
		endereco.setCidade(eDTO.getCidade());
		endereco.setBairro(eDTO.getBairro());
		endereco.setUf(eDTO.getUf());

		pessoa.setEndereco(endereco);

		return pessoa;
	}

	public PessoaDTO mapeiaParaPessoaDTO(Pessoa pessoa) {
		PessoaDTO dto = new PessoaDTO();

		dto.setCpf(pessoa.getCpf());
		dto.setNome(pessoa.getNome());
		dto.setEmail(pessoa.getEmail());

		EnderecoDTO enderecoDTO = new EnderecoDTO();

		Endereco endereco = pessoa.getEndereco();

		enderecoDTO.setCep(endereco.getCep());
		enderecoDTO.setLogradouro(endereco.getLogradouro());
		enderecoDTO.setNumero(endereco.getNumero());
		enderecoDTO.setComplemento(endereco.getComplemento());
		enderecoDTO.setCidade(endereco.getCidade());
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setUf(endereco.getUf());

		dto.setEnderecoDTO(enderecoDTO);

		return dto;
	}

}
