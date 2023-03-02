package africa.semicolon.yarnMeBlog.data.repository;

import africa.semicolon.yarnMeBlog.data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImplementation implements CommentRepository{
    private int count;
    private List<Comment>comments = new ArrayList<>();
    @Override
    public Comment save(Comment comment) {
        boolean commentHasNotBeenSaved = comment.getId() == 0;
        if (commentHasNotBeenSaved) saveNew(comment);
        comment.setId(generateCommentID());
        comments.add(comment);
        count++;

        return comment;
    }

    private void saveNew(Comment comment) {
        comments.add(comment);
        comment.setId(generateCommentID());
    }

    private int generateCommentID() {
       return count + 1;
    }

    @Override
    public Comment findById(int id) {
        for (Comment comment : comments)
            if (comment.getId() == id) return comment;
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public void delete(Comment comment) {
        for (Comment comment1 : comments) {
            comments.remove(comment);
            count--;
            break;

        }
    }
    @Override
    public void delete(int id) {
        for (Comment comment : comments) {
            if (comment.getId() == id) {
                comments.remove(comment);
                count--;
                break;

            }
        }
    }

    @Override
    public void deleteAll() {
        comments.clear();
        count = 0;

    }
}
