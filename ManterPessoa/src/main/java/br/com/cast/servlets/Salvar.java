package br.com.cast.servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.cast.business.BusinessPessoa;
import br.com.cast.dto.PessoaDTO;

/**
 * Servlet implementation class Test
 */
@WebServlet("/salvar")
public class Salvar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Gson gson = new Gson();
		
		String json = gson.toJson(new BusinessPessoa().buscaTodos());
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().write(json);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String json = req.getReader().lines().collect(Collectors.joining());

		BusinessPessoa businessPessoa = new BusinessPessoa();
		Gson gson = new Gson();

		PessoaDTO pessoaDTO = gson.fromJson(json, PessoaDTO.class);

		businessPessoa.inserirPessoa(pessoaDTO);

		resp.setContentType("application/json");

		System.out.println(json);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cpf = req.getReader().lines().collect(Collectors.joining());
		
		BusinessPessoa businessPessoa = new BusinessPessoa();
		
		businessPessoa.excluirPessoa(cpf);

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pessoa = req.getReader().lines().collect(Collectors.joining());
		
		Gson gson = new Gson();

		PessoaDTO pessoaDTO = gson.fromJson(pessoa, PessoaDTO.class);
		
		BusinessPessoa businessPessoa = new BusinessPessoa();
		
		System.out.println(pessoaDTO);
		
		businessPessoa.atualizaPessoa(pessoaDTO);
		
	}

}
