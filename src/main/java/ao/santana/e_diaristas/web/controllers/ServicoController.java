package ao.santana.e_diaristas.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ao.santana.e_diaristas.core.enums.Icone;
import ao.santana.e_diaristas.core.repositories.ServicoRepository;
import ao.santana.e_diaristas.web.dtos.ServicoForm;
import ao.santana.e_diaristas.web.mappers.WebServiceMapper;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @Autowired
    private WebServiceMapper mapper;

    @GetMapping
    public ModelAndView buscarTodos() {
        var modelandview = new ModelAndView("admin/servico/lista");
        modelandview.addObject("servicos", repository.findAll());

        return modelandview;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var modelandview = new ModelAndView("admin/servico/form");

        modelandview.addObject("form", new ServicoForm());

        return modelandview;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("form") ServicoForm form, BindingResult result) {
        if(result.hasErrors()) {

            return "admin/servico/form";
        }

        var servico = mapper.toModel(form);
        repository.save(servico);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var modelandview = new ModelAndView("admin/servico/form");
        var servico = repository.getById(id);
        var form = mapper.toForm(servico);
        modelandview.addObject("form", form);

        return modelandview;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, @Valid ServicoForm form) {
        var servico = mapper.toModel(form);
        servico.setId(id);
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
