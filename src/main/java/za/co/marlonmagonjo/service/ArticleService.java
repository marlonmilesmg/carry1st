package za.co.marlonmagonjo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.marlonmagonjo.model.ApiResponse;
import za.co.marlonmagonjo.model.Article;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Value("${api.url}")
    private String apiUrl;

    public List<String> getTopArticles(int limit) {
        List<Article> articles = fetchArticlesFromApi();

        return articles.stream()
                .filter(article -> article.getTitle() != null || article.getStoryTitle() != null)
                .sorted((a1, a2) -> {
                    int comments1 = a1.getNumComments() != null ? a1.getNumComments() : 0;
                    int comments2 = a2.getNumComments() != null ? a2.getNumComments() : 0;

                    int compareByComments = Integer.compare(comments2, comments1);
                    return compareByComments != 0 ? compareByComments : a1.getTitle().compareToIgnoreCase(a2.getTitle());
                })
                .limit(limit)
                .map(article -> article.getTitle() != null ? article.getTitle() : article.getStoryTitle())
                .collect(Collectors.toList());
    }

    private List<Article> fetchArticlesFromApi() {
        RestTemplate restTemplate = new RestTemplate();
        ApiResponse response = restTemplate.getForObject(apiUrl, ApiResponse.class);

        if (response != null) {
            return response.getData();
        }

        return List.of();
    }


}
