package at.ac.fhwn.group6.DigitaleRADAnamnese.repositories;

import at.ac.fhwn.group6.DigitaleRADAnamnese.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    List<CommentModel> findBySpecificAnswersId(Long specificAnswersId);
}
