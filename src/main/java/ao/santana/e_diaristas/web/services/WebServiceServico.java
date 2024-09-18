package ao.santana.e_diaristas.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.santana.e_diaristas.core.exceptions.ServicoNaoEncontradoException;
import ao.santana.e_diaristas.core.models.Servico;
import ao.santana.e_diaristas.core.repositories.ServicoRepository;
import ao.santana.e_diaristas.web.dtos.ServicoForm;
import ao.santana.e_diaristas.web.mappers.WebServiceMapper;

@Service
public class WebServiceServico {

    @Autowired
    private ServicoRepository repository;

    @Autowired
    private WebServiceMapper mapper;

    public List<Servico> buscarTodos() {
        return repository.findAll();
    }

    public Servico cadastrar(ServicoForm form) {
        var model = mapper.toModel(form);
        return repository.save(model);
    }

    public Servico buscarPorId(Long id) {
        var servicoEncontrado = repository.findById(id);
        if (servicoEncontrado.isPresent()) {
            return servicoEncontrado.get();
        }
        var mensagem = String.format("Servico com id %d não encontrado", id);

        throw new ServicoNaoEncontradoException(mensagem);
    }

    public Servico editar(ServicoForm form, Long id) {
        var servicoEncontrado = buscarPorId(id);

        var servico = mapper.toModel(form);
        servico.setId(servicoEncontrado.getId());
        return repository.save(servico);

    }

    public void excluirPorId(Long id){
        var servico = buscarPorId(id);
        repository.delete(servico);
    }

}
