package RestApi;

import Rest.entities.Comment;
import Rest.CommentController;
import Rest.entities.ApiResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommentControlTest {
    private CommentController commentController;

    @BeforeClass
    public void setUp() {
        commentController = new CommentController();
    }

    @Test(description = "Create new comment test", priority = 10)
    public void CreateCommentByJobIdTest() throws IOException {
        Comment comment = new Comment();
        comment.setId("1");
        comment.setMessage("Random Text!");
        comment.setUsername("TestUser");
        comment.setCommentDate("2023-07-30 12:56:10");

        ApiResponse response = commentController.postCreateCommentByJobId(comment, "1");
        System.out.println(response.statusCode());
        System.out.println(response.responseBody());
    }

    @Test(description = "Get all comments test", priority = 20)
    public void GetAllCommentsTest() throws IOException {
        ApiResponse response = commentController.getCommentAll("1");
        System.out.println(response.statusCode());
        System.out.println(response.responseBody());
    }
}

