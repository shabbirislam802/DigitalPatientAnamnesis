package org.shabbir.digitalpatientanamnesis.repositories;

import jdk.jfr.Registered;
import org.shabbir.digitalpatientanamnesis.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface PatientRepository extends JpaRepository<PatientModel, Long> {
}
