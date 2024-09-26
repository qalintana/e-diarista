package ao.santana.e_diaristas.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.santana.e_diaristas.core.models.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
