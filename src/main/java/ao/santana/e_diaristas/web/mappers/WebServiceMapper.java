package ao.santana.e_diaristas.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ao.santana.e_diaristas.core.models.Servico;
import ao.santana.e_diaristas.web.dtos.ServicoForm;

@Mapper(componentModel = "spring")
public interface WebServiceMapper {

    WebServiceMapper INSTANCE = Mappers.getMapper(WebServiceMapper.class);

    Servico toModel(ServicoForm form);

    ServicoForm toForm(Servico servico);

    

}
