package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactService")
    private ContactService contactService;

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/contacts/showcontacts";
    }
    
    @GetMapping("/contactform")
    public String redirectContactForm(Model model) {
        LOG.info("METHOD: redirectContactForm()");
        model.addAttribute("contactModel", new ContactModel());
        return ViewConstant.CONTACTFORM_VIEW;
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel,
            Model model) {
        LOG.info("METHOD: addContact() -- PARAMS: contactModel=" + contactModel.toString());

        if (contactService.addContact(contactModel) != null) {
            model.addAttribute("result", 1);
            return ViewConstant.CONTACTS_VIEW;
        } else {
            model.addAttribute("result", 0);
        }
        return "redirect:/contacts/showcontacts";
        
    }

    @GetMapping("/showcontacts")
    public ModelAndView showContacts() {
        LOG.info("METHOD: listAllContact()");
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS_VIEW);
        mav.addObject("contacts", contactService.listAllContacts());
        return mav;
    }

    @GetMapping("/removecontact")
    public ModelAndView removeContact(@RequestParam(name="id", required=true) int id) {
        contactService.removeContact(id);
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS_VIEW);
        mav.addObject("contacts", contactService.listAllContacts());
        return mav;
    }
    
}
