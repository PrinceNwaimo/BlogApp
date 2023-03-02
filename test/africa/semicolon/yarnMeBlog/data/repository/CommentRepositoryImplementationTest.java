package africa.semicolon.yarnMeBlog.data.repository;

import africa.semicolon.yarnMeBlog.data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentRepositoryImplementationTest {
        private CommentRepository commentRepository;
        private Comment comment;

        @BeforeEach
        public void setup() {
            commentRepository = new CommentRepositoryImplementation();
            comment = new Comment();
            comment.setComment("Give away");
            comment.setId(2);
            comment.setArticleId(3);
            comment.setUserID(1);

        }

        @Test
        public void saveCommentTest() {
            Comment comment = new Comment();
            commentRepository.save(comment);
            assertEquals(1, commentRepository.count());

        }

        @Test
        public void saveOneComment_findCommentById() {
            Comment savedComment = commentRepository.save(comment);
            assertEquals(1, savedComment.getId());
            Comment foundComment = commentRepository.findById(1);
            assertEquals(foundComment,savedComment);

        }
        @Test
        public void deleteCommentsByIDTest(){
            Comment savedComment = commentRepository.save(comment);
            assertEquals(1,commentRepository.count());
            commentRepository.delete(1);
            assertEquals(0,commentRepository.count());
        }
        @Test
        public void deleteCommentTest(){
           Comment savedComment = commentRepository.save(comment);
            assertEquals(1,commentRepository.count());
            commentRepository.delete(comment);
            assertEquals(0,commentRepository.count());

        }
        @Test
        public void deleteAllComments(){
            Comment savedComments = commentRepository.save(comment);
            savedComments = commentRepository.save(comment);
            assertEquals(2,commentRepository.count());
            commentRepository.deleteAll();
            assertEquals(0,commentRepository.count());
        }
        @Test
        public void findAllComments(){
            Comment savedComment = commentRepository.save(comment);
            assertEquals(1,commentRepository.count());
            commentRepository.findAll();
            assertEquals(1,commentRepository.count());
        }
    }
