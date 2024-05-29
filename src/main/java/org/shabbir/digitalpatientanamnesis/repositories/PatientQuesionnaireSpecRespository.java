package org.shabbir.digitalpatientanamnesis.repositories;

import org.shabbir.digitalpatientanamnesis.model.PatientQuestionnaireSpecModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientQuesionnaireSpecRespository extends JpaRepository <PatientQuestionnaireSpecModel, Long> {
}
