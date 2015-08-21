package pl.psychoffice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 15/08/15.
 */
@Controller
public class ServiceController {

    @RequestMapping("/onlineConsultation")
    String onlineConsultation(){
        return "services/onlineConsultation";
    }

    @RequestMapping("/onlineTherapy")
    String onlineTherapy(){
        return "services/onlineTherapy";
    }

    @RequestMapping("/onlineTests")
    String onlineTests(){
        return "services/onlineTests";
    }

    @RequestMapping("/directConsultation")
    String directConsultation(){
        return "services/directConsultation";
    }

    @RequestMapping("/directPsychotherapy")
    String directPsychotherapy(){
        return "services/directPsychotherapy";
    }

    @RequestMapping("/directDiagnosis")
    String directDiagnosis(){
        return "services/directDiagnosis";
    }

    @RequestMapping("/companiesDiagnosis")
    String companiesDiagnosis(){
        return "services/companiesDiagnosis";
    }

    @RequestMapping("/companiesTraining")
    String companiesTraining(){
        return "services/companiesTraining";
    }

    @RequestMapping("/companiesNegotiations")
    String companiesNegotiations(){
        return "services/companiesNegotiations";
    }
}
