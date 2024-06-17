package uit.se122.ieltstinder.entity.builder;

import uit.se122.ieltstinder.entity.Question;
import uit.se122.ieltstinder.entity.Test;
import uit.se122.ieltstinder.entity.enumeration.TestLevel;

import java.time.Instant;
import java.util.List;

public class TestBuilder {

    private Long id;
    private String title;
    private TestLevel difficultyLevel;
    private List<Question> questions;
    private Instant createdAt;

    TestBuilder() {}

    public static TestBuilder builder() {
        return new TestBuilder();
    }

    public TestBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public TestBuilder title(final String title) {
        this.title = title;
        return this;
    }

    public TestBuilder difficultyLevel(final TestLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        return this;
    }

    public TestBuilder questions(final List<Question> questions) {
        this.questions = questions;
        return this;
    }

    public TestBuilder createdAt(final Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Test build() {
        return new Test(this.id, this.title, this.difficultyLevel, this.questions, this.createdAt);
    }
    
}
