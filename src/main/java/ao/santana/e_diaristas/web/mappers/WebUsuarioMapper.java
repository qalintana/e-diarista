package ao.santana.e_diaristas.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ao.santana.e_diaristas.core.models.Usuario;
import ao.santana.e_diaristas.web.dtos.UsuarioCadastroForm;

@Mapper(componentModel = "spring")
public interface WebUsuarioMapper {
    WebUsuarioMapper INSTANCE = Mappers.getMapper(WebUsuarioMapper.class);

    Usuario toModel(UsuarioCadastroForm form);

}
