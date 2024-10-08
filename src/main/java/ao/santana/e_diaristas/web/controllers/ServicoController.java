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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ao.santana.e_diaristas.core.enums.Icone;
import ao.santana.e_diaristas.web.dtos.FlashMessage;
import ao.santana.e_diaristas.web.dtos.ServicoForm;
import ao.santana.e_diaristas.web.services.WebServiceServico;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    private WebServiceServico service;

    @GetMapping
    public ModelAndView buscarTodos() {
        var modelandview = new ModelAndView("admin/servico/lista");
        modelandview.addObject("servicos", service.buscarTodos());

        return modelandview;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var modelandview = new ModelAndView("admin/servico/form");
        modelandview.addObject("form", new ServicoForm());

        return modelandview;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("form") ServicoForm form, BindingResult result,
            RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "admin/servico/form";
        }
        service.cadastrar(form);
        attrs.addFlashAttribute("alert",
                new FlashMessage("alert-success", "Serviço Cadastrado com sucesso"));
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var modelandview = new ModelAndView("admin/servico/form");
        modelandview.addObject("form", service.buscarPorId(id));
        return modelandview;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, @Valid @ModelAttribute("form") ServicoForm form, BindingResult result,
            RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "admin/servico/form";
        }
        service.editar(form, id);
        attrs.addFlashAttribute("alert",
                new FlashMessage("alert-success", "Serviço atualizado com sucesso"));
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {
        service.excluirPorId(id);
        attrs.addFlashAttribute("alert",
                new FlashMessage("alert-warning", "Serviço Eliminado com sucesso"));
        return "redirect:/admin/servicos";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
}
