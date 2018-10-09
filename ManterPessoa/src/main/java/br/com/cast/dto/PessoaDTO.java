package br.com.cast.dto;

public class PessoaDTO {

	private String cpf;
	private String nome;
	private String email;
	private EnderecoDTO enderecoDTO;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}

	public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}

	@Override
	public String toString() {
		return "PessoaDTO [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", enderecoDTO=" + enderecoDTO + "]";
	}

}
