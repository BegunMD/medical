package hello;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class ModelValidator {

    String defaultMessage = "Некоторые поля не заполнены. Заполните все поля для получения результата.";

    public boolean supports(Class<?> clazz) {
        return clazz.equals(ModelForm.class);
    }

    public void validate(Object command, Errors errors){
        ModelForm form = (ModelForm) command;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.empty", "Необходимо заполнить возраст начала заболевания.\n");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "IN", "IN.empty", "Необходимо заполнить индекс напряженности.\n");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "OOAminus", "OOAminus.empty", "Необходимо заполнить ООА\"-\" до лечения.\n");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "OOAplus", "OOAplus.empty", "Необходимо заполнить ООА\"+\" до лечения.\n");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "OOA", "OOA.empty", "Необходимо заполнить ООА до лечения.\n");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correction", "correction.empty", "Необходимо заполнить коррекцию до лечения.\n");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "refractionWithC", "refractionWithC.empty", "Необходимо заполнить рефракцию с циклоплегией до лечения.\n");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "refractionWithoutC", "refractionWithoutC.empty", "Необходимо заполнить рефракцию без циклоплегии до лечения.\n");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vision", "vision.empty", "Необходимо заполнить острота зрения до лечения.\n");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "time", "time.empty", "Необходимо заполнить длительность заболевания.\n");
        if(!isInteger(""+form.getAge())) errors.rejectValue("age", "age.notValid", "Возраст начала заболевания должен быть целым числом.\n");
        if(!isInteger(""+form.getTime())) errors.rejectValue("time", "time.notValid", "Длительность заболевания должна быть целым числом.\n");
        if(!isFloat(""+form.getIN())) errors.rejectValue("IN", "IN.notValid", "Индекс напряженности должен быть целым числом.\n");
        if(!isFloat(""+form.getOOAminus())) errors.rejectValue("OOAminus", "OOAminus.notValid", "Индекс напряженности должен быть целым числом.\n");
        if(!isFloat(""+form.getOOAplus())) errors.rejectValue("OOAminus", "OOAminus.notValid", "Индекс напряженности должен быть целым числом.\n");
    }

    private static boolean isInteger(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String s) throws NumberFormatException {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
