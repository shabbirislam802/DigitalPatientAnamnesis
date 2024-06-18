package at.ac.fhwn.group6.DigitaleRADAnamnese.controller.web;

import at.ac.fhwn.group6.DigitaleRADAnamnese.model.AftercareModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.CommentModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.GeneralAnswersModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.SpecificAnswersModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.services.PatientService;
import at.ac.fhwn.group6.DigitaleRADAnamnese.services.StaffService;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private final PatientService patientService;
    private final StaffService staffService;

    @Autowired
    public StaffController(PatientService patientService, StaffService staffService) {
        this.patientService = patientService;
        this.staffService = staffService;
    }

    @GetMapping("/welcome")
    public String showStaffDashboard(Model model) {
        List<SpecificAnswersModel> specificAnswers = patientService.findAllSpecificAnswersWithGeneral();
        model.addAttribute("specificAnswersList", specificAnswers);
        return "staff/welcomeStaff";
    }

    @GetMapping("/patient/questionnaireDetail/{id}")
    public String viewPatientDetails(@PathVariable Long id, Model model) {
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
            return "staff/viewPatientDetails";
        } else {
            return "redirect:/staff/welcome";
        }
    }


    @PostMapping("/saveComments")
    public ModelAndView saveComment(String commentContent, Long specificAnswersId) {
        staffService.addComment(commentContent, specificAnswersId);
        return new ModelAndView("redirect:/staff/welcome");
    }
}
