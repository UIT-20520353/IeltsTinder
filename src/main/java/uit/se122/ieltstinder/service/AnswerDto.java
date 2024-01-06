package uit.se122.ieltstinder.service;

public record AnswerDto(
        Long id,
        String content,
        Boolean isResult
) {
}
