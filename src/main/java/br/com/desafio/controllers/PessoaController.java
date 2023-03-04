package br.com.desafio.controllers;

import br.com.desafio.dao.PessoaDAO;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaDAO pessoaDAO;

    @PostMapping
    public Pessoa addPessoa(@RequestBody Pessoa pessoa) {
        pessoaDAO.save(pessoa);
        // Envio de SMS com a posição na fila
        
        import com.telesign.MessagingClient;
        import com.telesign.RestClient;

        public class HelloTelesign {

            public static void main(String[] args) {

                String customerId = "1658CE60-5E62-44A8-A339-FFD0E704AFA6";
                String apiKey = "*********************************";
                String phoneNumber = "5581987822479";
                String message = "Sua senha para atendimento foi gerada";
                String messageType = "ARN";

                try {
                    MessagingClient messagingClient = new MessagingClient(customerId, apiKey);
                    RestClient.TelesignResponse telesignResponse = messagingClient.message(phoneNumber, message, messageType, null);
                    System.out.println("Your reference id is: "+telesignResponse.json.get("reference_id"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        
        return pessoa;
    }

    @GetMapping
    public List<Pessoa> getPessoas() {
        return pessoaDAO.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa getPessoa(@PathVariable Long id) {
        return pessoaDAO.findById(id);
    }

    @PutMapping("/{id}")
    public Pessoa updatePessoa(@RequestBody Pessoa pessoa, @PathVariable Long id) {
        pessoa.setId(id);
        return pessoaDAO.update(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaDAO.findById(id);
        pessoaDAO.delete(pessoa);
    }
}
