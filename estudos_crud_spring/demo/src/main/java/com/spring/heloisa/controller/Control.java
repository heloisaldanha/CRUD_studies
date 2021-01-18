package com.spring.heloisa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.spring.heloisa.interfaceservice.InterfacePessoaService;
import com.spring.heloisa.model.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class Control {

    @Autowired
    private InterfacePessoaService service;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model){
        List<Pessoa> people = service.listar();
        model.addAttribute("people", people);
        return "/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("pessoa", new Pessoa());
        return "/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Pessoa person, BindingResult result, RedirectAttributes attributes){
        /** O @Valid ficou dando problema pra reconhecer e não conseguia importar
         * javax.validation. Tive que colocar a dependência do Hibernate.
         */
        if(result.hasErrors()){
            attributes.addFlashAttribute("message", "There are required fields in this form.");
            return "redirect:/new";
        }
        service.save(person);
        return "redirect:/listar";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model){ // PathVariable é o caminho que pode mudar de acordo com o que é pedido. No caso aqui, o id pode ser diferente.
        Optional<Pessoa>pessoa = service.listarId(id);
        model.addAttribute("pessoa", pessoa);
        return "form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }
}