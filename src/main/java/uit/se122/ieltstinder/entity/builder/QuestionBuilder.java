package uit.se122.ieltstinder.entity.builder;

import uit.se122.ieltstinder.entity.Question;
import uit.se122.ieltstinder.entity.QuestionDetail;
import uit.se122.ieltstinder.entity.Test;
import uit.se122.ieltstinder.entity.enumeration.QuestionType;

import java.util.List;

public class QuestionBuilder {

    private Long id;
    private String audioUrl;
    private String paragraph;
    private Test test;
    private QuestionType type;
    private String description;
    private List<QuestionDetail> questionDetails;

    QuestionBuilder() {}

    public static QuestionBuilder builder() {
        return new QuestionBuilder();
    }

    public QuestionBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public QuestionBuilder audioUrl(final String audioUrl) {
        this.audioUrl = audioUrl;
        return this;
    }

    public QuestionBuilder paragraph(final String paragraph) {
        this.paragraph = paragraph;
        return this;
    }

    public QuestionBuilder test(final Test test) {
        this.test = test;
        return this;
    }

    public QuestionBuilder type(final QuestionType type) {
        this.type = type;
        return this;
    }

    public QuestionBuilder description(final String description) {
        this.description = description;
        return this;
    }

    public QuestionBuilder questionDetails(final List<QuestionDetail> questionDetails) {
        this.questionDetails = questionDetails;
        return this;
    }

    public Question build() {
        return new Question(this.id, this.audioUrl, this.paragraph, this.test, this.type, this.description, this.questionDetails);
    }
    
}
