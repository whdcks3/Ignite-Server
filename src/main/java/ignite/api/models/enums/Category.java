package ignite.api.models.enums;

public enum Category {
    SOCCER("축구"),
    GOLF("골프"),
    BASKETBALL("농구"),
    BASEBALL("야구"),
    SCREENGOLF("스크린골프"),
    FUTSAL("풋살"),
    TENNIS("테니스"),
    BADBINTON("배드민턴"),
    BOWLING("볼링"),
    HEALTH("헬스");

    private String category;

    private Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
