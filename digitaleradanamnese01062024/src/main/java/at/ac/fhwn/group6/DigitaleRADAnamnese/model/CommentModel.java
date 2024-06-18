package at.ac.fhwn.group6.DigitaleRADAnamnese.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2048)
    private String content;

    @ManyToOne
    @JoinColumn(name = "specificAnswersId", nullable = false)
    private SpecificAnswersModel specificAnswers;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime timestamp;
}
