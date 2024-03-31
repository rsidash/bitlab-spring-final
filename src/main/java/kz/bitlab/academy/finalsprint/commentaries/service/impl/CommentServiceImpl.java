package kz.bitlab.academy.finalsprint.commentaries.service.impl;

import kz.bitlab.academy.finalsprint.commentaries.entity.CommentEntity;
import kz.bitlab.academy.finalsprint.commentaries.repository.CommentRepository;
import kz.bitlab.academy.finalsprint.commentaries.service.CommentService;
import kz.bitlab.academy.finalsprint.tasks.service.impl.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final TaskServiceImpl taskService;

    @Override
    @Transactional
    public void create(String comment, Long taskId) {
        var task = taskService.findById(taskId);

        if (task.hasEditableStatus()) {
            repository.save(new CommentEntity(comment, task));
        } else {
            throw new RuntimeException("Task is closed");
        }
    }

    @Override
    @Transactional
    public void update(Long id, String commentText) {
        CommentEntity comment = findById(id);

        comment.setComment(commentText);
    }

    @Override
    @Transactional(readOnly = true)
    public CommentEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentEntity> findAllByTaskId(Long taskId) {
        return repository.findAllByTaskId(taskId);
    }
}
