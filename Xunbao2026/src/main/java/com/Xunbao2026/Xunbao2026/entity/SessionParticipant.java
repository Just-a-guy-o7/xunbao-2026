package com.Xunbao2026.Xunbao2026.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "session_participants", uniqueConstraints = @UniqueConstraint(columnNames = {"session_id", "user_id"}), indexes = {
        @Index(name = "idx_participants_session_id", columnList = "session_id"),
        @Index(name = "idx_participants_user_id", columnList = "user_id")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionParticipant {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false, foreignKey = @ForeignKey(name = "fk_participant_session"))
    private QuizSession session;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_participant_user"))
    private User user;

    @CreationTimestamp
    @Column(name = "joined_at", nullable = false, updatable = false)
    private LocalDateTime joinedAt;

    @Column(name = "question_sent_at")
    private LocalDateTime questionSentAt;

    @Column(precision = 10, scale = 2)
    private BigDecimal score = BigDecimal.ZERO;

    @Column(name = "time_spent_seconds")
    private Integer timeSpentSeconds = 0;

    private Integer rank;

    @Column(length = 50)
    private String status;
}
