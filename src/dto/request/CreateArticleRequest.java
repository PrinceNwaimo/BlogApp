package dto.request;

public class CreateArticleRequest {
    private int count;
    private String title;
    private String body;

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthorID() {
        return count;
    }

    public void setBody(String my_body) {
    }

    public void setTitle(String my_title) {
    }

    public void setAuthorId(int i) {
    }
}
