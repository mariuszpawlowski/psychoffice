package pl.mariuszpawlowski.psychoffice.controllers;

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

    @RequestMapping("/directConsultation")
    String directConsultation(){
        return "services/directConsultation";
    }

    @RequestMapping("/directIndividual")
    String directIndividual(){
        return "services/directIndividual";
    }

    @RequestMapping("/directDiagnosis")
    String directDiagnosis(){
        return "services/directDiagnosis";
    }

    @RequestMapping("/directPair")
    String directPair(){
        return "services/directPair";
    }

    @RequestMapping("/directGroup")
    String directGroup2(){
        return "services/directGroup";
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
