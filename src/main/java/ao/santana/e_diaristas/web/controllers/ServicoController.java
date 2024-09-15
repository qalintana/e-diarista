package ao.santana.e_diaristas.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ao.santana.e_diaristas.core.enums.Icone;
import ao.santana.e_diaristas.core.models.Servico;
import ao.santana.e_diaristas.core.repositories.ServicoRepository;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @GetMapping
    public ModelAndView buscarTodos() {
        var modelandview = new ModelAndView("admin/servico/lista");
        modelandview.addObject("servicos", repository.findAll());

        return modelandview;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var modelandview = new ModelAndView("admin/servico/form");

        modelandview.addObject("servico", new Servico());

        return modelandview;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Servico servico) {
        repository.save(servico);

        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/admin/servicos";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
}
