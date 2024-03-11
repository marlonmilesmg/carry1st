package za.co.marlonmagonjo.model;


public class Article {
    private String title;
    private String storyTitle;
    private Integer numComments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }
}

