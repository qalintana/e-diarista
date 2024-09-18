package ao.santana.e_diaristas.web.mappers;

import org.springframework.stereotype.Component;

import ao.santana.e_diaristas.core.models.Servico;
import ao.santana.e_diaristas.web.dtos.ServicoForm;

@Component
public class WebServiceMapper {

    public Servico toModel(ServicoForm form) {
        if (form == null) {
            throw new IllegalArgumentException();
        }

        var model = new Servico();
        model.setNome(form.getNome());

        model.setValorMinimo(form.getValorMinimo());
        model.setProcentagemComissao(form.getProcentagemComissao());
        model.setQtdHoras(form.getQtdHoras());       

        model.setHorasCozinha(form.getHorasCozinha());
        model.setValorCozinha(form.getValorCozinha());

        model.setHorasQuarto(form.getHorasQuarto());
        model.setValorQuarto(form.getValorQuarto());

        model.setValorSala(form.getValorSala());
        model.setHorasSala(form.getHorasSala());

        model.setValorBanheiro(form.getValorBanheiro());
        model.setHorasBanheiro(form.getHorasBanheiro());

        model.setValorQuintal(form.getValorQuintal());
        model.setHorasQuintal(form.getHorasQuintal());

        model.setValorOutros(form.getValorOutros());
        model.setHorasOutros(form.getHorasOutros());
        
        model.setIcone(form.getIcone());
        model.setPosicao(form.getPosicao());
      
        return model;
    }

    public ServicoForm toForm(Servico model) {
        if (model == null) {
            throw new IllegalArgumentException();
        }

        var form = new ServicoForm();
        form.setNome(model.getNome());
        form.setValorMinimo(model.getValorMinimo());
        form.setProcentagemComissao(model.getProcentagemComissao());
        form.setQtdHoras(model.getQtdHoras());
        form.setHorasCozinha(model.getHorasCozinha());
        form.setValorCozinha(model.getValorCozinha());
        form.setHorasQuarto(model.getHorasQuarto());
        form.setValorQuarto(model.getValorQuarto());
        form.setValorSala(model.getValorSala());
        form.setHorasSala(model.getHorasSala());
        form.setValorBanheiro(model.getValorBanheiro());
        form.setHorasBanheiro(model.getHorasBanheiro());
        form.setValorQuintal(model.getValorQuintal());
        form.setHorasQuintal(model.getHorasQuintal());
        form.setValorOutros(model.getValorOutros());
        form.setHorasOutros(model.getHorasOutros());
        form.setIcone(model.getIcone());
        form.setPosicao(model.getPosicao());

        return form;

    }

}
