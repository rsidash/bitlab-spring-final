package kz.bitlab.academy.finalsprint.commentaries.entity;

import jakarta.persistence.*;
import kz.bitlab.academy.finalsprint.folders.entity.FolderEntity;
import kz.bitlab.academy.finalsprint.tasks.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment", nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;

    public CommentEntity(String comment, TaskEntity task) {
        this.comment = comment;
        this.task = task;
    }
}
