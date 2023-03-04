package br.com.desafio.dao;

@Repository
@Transactional
public class PessoaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Pessoa save(Pessoa pessoa) {
        entityManager.persist(pessoa);
        return pessoa;
    }

    public Pessoa findById(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    public List<Pessoa> findAll() {
        return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    public Pessoa update(Pessoa pessoa) {
        return entityManager.merge(pessoa);
    }

    public void delete(Pessoa pessoa) {
        entityManager.remove(pessoa);
    }
}

