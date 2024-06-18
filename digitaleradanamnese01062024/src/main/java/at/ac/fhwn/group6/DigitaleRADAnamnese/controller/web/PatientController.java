package at.ac.fhwn.group6.DigitaleRADAnamnese.controller.web;

import at.ac.fhwn.group6.DigitaleRADAnamnese.model.AftercareModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.CommentModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.GeneralAnswersModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.SpecificAnswersModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.services.PatientService;
import at.ac.fhwn.group6.DigitaleRADAnamnese.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;
    private final StaffService staffService;


    @Autowired
    public PatientController(PatientService patientService, StaffService staffService) {
        this.patientService = patientService;
        this.staffService = staffService;
    }

    @GetMapping("/welcome")
    public String showPatientForm(Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<GeneralAnswersModel> patient = patientService.findByUsername(username);

        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
        } else {
            model.addAttribute("patient", new GeneralAnswersModel());
        }
        return "/patient/welcome";
    }

    @PostMapping("/savePatient")
    public String submitPatientForm(@ModelAttribute GeneralAnswersModel patient, Authentication authentication) {
        String username = authentication.getName();
        patientService.saveOrUpdatePatient(patient, username);
        return "redirect:/patient/welcome";
    }

    @GetMapping("/generalQuestions")
    public String showGeneralQuestions(Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<GeneralAnswersModel> patient = patientService.findByUsername(username);

        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
        } else {
            model.addAttribute("patient", new GeneralAnswersModel());
        }
        return "/patient/generalQuestions";
    }

    @PostMapping("/submitGeneralAnamnesis")
    public String submitGeneralAnamnesis(@ModelAttribute GeneralAnswersModel patient, Authentication authentication) {
        String username = authentication.getName();
        patientService.saveOrUpdatePatient(patient, username);
        return "redirect:/patient/specificQuestions";
    }

    @GetMapping("/specificQuestions")
    public String showSpecificQuestions(Model model, Authentication authentication) {
        model.addAttribute("specificAnswers", new SpecificAnswersModel());
        return "/patient/specificQuestions";
    }

    @PostMapping("/submitSpecificAnamnesis")
    public String submitSpecificAnamnesis(@ModelAttribute SpecificAnswersModel specificAnswers, Authentication authentication, HttpSession session) {
        String username = authentication.getName();
        patientService.saveSpecificAnswers(specificAnswers, username);
        session.setAttribute("specificAnswerId", specificAnswers.getId());
        return "redirect:/patient/aftercare";
    }

    @GetMapping("/aftercare")
    public String showAftercareForm(Model model, Authentication authentication, HttpSession session) {
        Long specificAnswerId = (Long) session.getAttribute("specificAnswerId");
        if (specificAnswerId == null) {
            return "redirect:/patient/specificQuestions";  // or some other appropriate error handling
        }
        model.addAttribute("specificAnswerId", specificAnswerId);
        model.addAttribute("aftercare", new AftercareModel());
        return "/patient/patientAftercare";
    }

    @PostMapping("/submitAftercare")
    public String submitAftercareForm(@ModelAttribute AftercareModel aftercare, Authentication authentication, @RequestParam Long specificAnswerId) {
        String username = authentication.getName();
        patientService.saveAftercareInfo(aftercare, username, specificAnswerId);
        return "redirect:/patient/thankYou";
    }

    @GetMapping("/thankYou")
    public String showThankYouPage() {
        return "/patient/thankYou";
    }

    @GetMapping("/listSpecificQuestions")
    public String listSpecificQuestions(Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<GeneralAnswersModel> patient = patientService.findByUsername(username);

        if (patient.isPresent()) {
            List<SpecificAnswersModel> specificAnswersList = patientService.findSpecificAnswersByPatientId(patient.get().getId());
            model.addAttribute("specificQuestionnaires", specificAnswersList);
        } else {
            model.addAttribute("specificQuestionnaires", List.of());
        }
        return "/patient/listSpecificQuestionnaires";
    }

    @GetMapping("/questionnaireDetails/{id}")
    public String showQuestionnaireDetails(@PathVariable Long id, Model model) {
        Optional<SpecificAnswersModel> specificAnswers = patientService.findSpecificAnswersById(id);
        if (specificAnswers.isPresent()) {
            SpecificAnswersModel specificAnswersModel = specificAnswers.get();
            GeneralAnswersModel generalAnswersModel = specificAnswersModel.getPatientModel();
            List<CommentModel> comments = staffService.findCommentsBySpecificAnswersId(specificAnswersModel.getId());

            model.addAttribute("generalAnswers", generalAnswersModel);
            model.addAttribute("specificAnswers", specificAnswersModel);
            model.addAttribute("comments", comments);

            Optional<AftercareModel> aftercare = patientService.findAftercareBySpecificAnswerId(id);
            model.addAttribute("aftercare", aftercare.orElse(null));
            return "/patient/questionnaireDetails";
        } else {
            return "redirect:/patient/listSpecificQuestionnaires";
        }
    }
}
