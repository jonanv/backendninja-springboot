package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @GetMapping("/cancel")
    public String cancel() {
        return ViewConstant.CONTACTS_VIEW;
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
        model.addAttribute("result", 1);
        // model.addAttribute("contactModel", contactModel);
        return ViewConstant.CONTACTS_VIEW;
    }
    
}
