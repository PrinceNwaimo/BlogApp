package data.repository;

import data.models.Comment;

import java.util.List;

public interface CommentRepository {
    Comment save(Comment comment);

    Comment findById(int id);

    long count();

    List<Comment> findAll();

    void delete(Comment comment);

    void delete(int id);

    void deleteAll();
}
