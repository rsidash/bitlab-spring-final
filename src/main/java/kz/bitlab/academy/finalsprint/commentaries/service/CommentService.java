package kz.bitlab.academy.finalsprint.commentaries.service;

import kz.bitlab.academy.finalsprint.commentaries.entity.CommentEntity;

import java.util.List;

public interface CommentService {
    void create(String comment, Long taskId);

    void update(Long id, String comment);

    CommentEntity findById(Long id);

    void delete(Long id);

    List<CommentEntity> findAllByTaskId(Long taskId);
}
