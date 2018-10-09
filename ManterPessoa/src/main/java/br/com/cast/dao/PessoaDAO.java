package br.com.cast.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.cast.models.Pessoa;

public class PessoaDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public PessoaDAO() {
		this.emf = Persistence.createEntityManagerFactory("puManterPessoa");
		this.em = emf.createEntityManager();
	}

	public void inserirPessoa(Pessoa pessoa) {
		this.em.getTransaction().begin();
		try {
			this.em.persist(pessoa);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscaTodos() {
		Query query = this.em.createQuery("select p "
										+ "from Pessoa p "
										+ "join fetch p.endereco");
		return query.getResultList();
	}

	public void excluir(String cpf) {
		this.em.getTransaction().begin();
		try {
			this.em.remove(this.em.find(Pessoa.class, cpf));
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}
	}

	public Pessoa buscaPorCpf(String cpf) {
		return this.em.find(Pessoa.class, cpf);
	}

	public void update(Pessoa pessoa) {
		this.em.getTransaction().begin();
		try {
			this.em.merge(pessoa);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}
	}

}
