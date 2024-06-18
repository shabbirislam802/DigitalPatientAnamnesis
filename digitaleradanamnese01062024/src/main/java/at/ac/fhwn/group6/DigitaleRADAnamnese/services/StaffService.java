package at.ac.fhwn.group6.DigitaleRADAnamnese.services;

import at.ac.fhwn.group6.DigitaleRADAnamnese.model.CommentModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.SpecificAnswersModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.repositories.CommentRepository;
import at.ac.fhwn.group6.DigitaleRADAnamnese.repositories.SpecificAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final CommentRepository commentRepository;
    private final SpecificAnswersRepository specificAnswersRepository;

    @Autowired
    public StaffService(CommentRepository commentRepository, SpecificAnswersRepository specificAnswersRepository) {
        this.commentRepository = commentRepository;
        this.specificAnswersRepository = specificAnswersRepository;
    }

    public CommentModel addComment(String content, Long specificAnswersId) {
        SpecificAnswersModel specificAnswers = specificAnswersRepository.findById(specificAnswersId)
                .orElseThrow(() -> new RuntimeException("Specific Answer not found"));

        CommentModel comment = new CommentModel();
        comment.setContent(content);
        comment.setSpecificAnswers(specificAnswers);

        return commentRepository.save(comment);
    }

    public List<CommentModel> findCommentsBySpecificAnswersId(Long specificAnswersId) {
        return commentRepository.findBySpecificAnswersId(specificAnswersId);
    }

}
