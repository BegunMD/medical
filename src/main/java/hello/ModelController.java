package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@ControllerAdvice
public class ModelController {

    @Autowired
    private ModelValidator modelFormValidator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "modelForm", new ModelForm());
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public ModelAndView showForm2() {
        return new ModelAndView("index2", "modelForm", new ModelForm());
    }

    @RequestMapping(value = "/index3", method = RequestMethod.GET)
    public ModelAndView showForm3() {
        return new ModelAndView("index3", "modelForm", new ModelForm());
    }

    @RequestMapping(value = "count1", method = RequestMethod.POST)
    public String count(@ModelAttribute("modelForm") ModelForm form, Model model, BindingResult bindingResult) {
        modelFormValidator.validate(form, bindingResult);
        if (bindingResult.hasErrors()) return "index";
        model.addAttribute("result", form.count1());
        return "index";
    }

    @RequestMapping(value = "count2", method = RequestMethod.POST)
    public String count2(@ModelAttribute("modelForm") ModelForm form, Model model, BindingResult bindingResult) {
        modelFormValidator.validate(form, bindingResult);
        if (bindingResult.hasErrors()) return "index2";
        model.addAttribute("result", form.count1());
        return "index2";
    }

    @RequestMapping(value = "count3", method = RequestMethod.POST)
    public String count3(@ModelAttribute("modelForm") ModelForm form, Model model, BindingResult bindingResult) {
      modelFormValidator.validate(form, bindingResult);
        if (bindingResult.hasErrors()) return "index3";
        model.addAttribute("result", form.count1());
        return "index3";
    }

    @RequestMapping(value = "count1", method = RequestMethod.GET)
    public ModelAndView redirect() {
        return new ModelAndView("index", "modelForm", new ModelForm());
    }

    @RequestMapping(value = "count2", method = RequestMethod.GET)
    public ModelAndView redirect2() {
        return new ModelAndView("index2", "modelForm", new ModelForm());
    }

    @RequestMapping(value = "count3", method = RequestMethod.GET)
    public ModelAndView redirect3() {
        return new ModelAndView("index3", "modelForm", new ModelForm());
    }


}
