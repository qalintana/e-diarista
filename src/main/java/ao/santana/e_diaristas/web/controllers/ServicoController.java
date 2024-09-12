package ao.santana.e_diaristas.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ao.santana.e_diaristas.core.models.Servico;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var modelandview = new ModelAndView("admin/servico/form");
        modelandview.addObject("servico", new Servico());

        return modelandview;
    }
}
