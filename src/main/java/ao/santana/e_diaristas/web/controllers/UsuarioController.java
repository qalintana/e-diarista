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

import ao.santana.e_diaristas.web.dtos.FlashMessage;
import ao.santana.e_diaristas.web.dtos.UsuarioCadastroForm;
import ao.santana.e_diaristas.web.services.WebUsuarioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {

    @Autowired
    private WebUsuarioService service;

    @GetMapping
    public ModelAndView buscarTodo() {
        var model = new ModelAndView("admin/usuario/lista");
        model.addObject("usuarios", service.buscarTodos());
        return model;

    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var model = new ModelAndView("admin/usuario/cadastro-form");
        model.addObject("cadastroForm", new UsuarioCadastroForm());
        return model;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("cadastroForm") UsuarioCadastroForm cadastroForm,
            BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "admin/usuario/cadastro-form";
        }

        service.cadastrar(cadastroForm);

        attributes.addFlashAttribute("alert",
                new FlashMessage("alert-success", "Usuario Cadastrado com sucesso"));
        return "redirect:/admin/usuarios";

    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
        service.excluirPorId(id);
        attributes.addFlashAttribute("alert",
                new FlashMessage("alert-success", "Usuario excluido com sucesso"));
        return "redirect:/admin/usuarios";
    }

}
