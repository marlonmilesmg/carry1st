package za.co.marlonmagonjo.model;

import java.util.List;

public class ApiResponse {
    private List<Article> data;
    private int total_pages;

    public List<Article> getData() {
        return data;
    }

    public void setData(List<Article> data) {
        this.data = data;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}

