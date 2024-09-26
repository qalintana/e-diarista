package ao.santana.e_diaristas.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.santana.e_diaristas.core.repositories.UsuarioRepository;
import ao.santana.e_diaristas.web.dtos.UsuarioCadastroForm;
import ao.santana.e_diaristas.web.mappers.WebUsuarioMapper;
import ao.santana.e_diaristas.core.enums.TipoUsuario;
import ao.santana.e_diaristas.core.exceptions.UsuarioNaoEncontradoExcetpion;
import ao.santana.e_diaristas.core.models.Usuario;

@Service
public class WebUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private WebUsuarioMapper mapper;

    public List<Usuario> buscarTodos() {

        return repository.findAll();
    }

    public Usuario cadastrar(UsuarioCadastroForm form) {
        var model = mapper.toModel(form);
        model.setTipoUsuario(TipoUsuario.ADMIN);
        return repository.save(model);

    }

    public Usuario buscarPorId(Long id) {
        var message = String.format("Usuário com id %d não encontrado", id);
        return repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoExcetpion(message));
    }

    public void excluirPorId(Long id) {
        var usuario = this.buscarPorId(id);
        repository.delete(usuario);

    }

}
