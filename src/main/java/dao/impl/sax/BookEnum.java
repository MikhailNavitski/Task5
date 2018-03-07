package dao.impl.sax;

public enum BookEnum {
    CATALOG("catalog"),
    BOOK("book"),
    AUTHOR("author"),
    TITLE("title"),
    GENRE("genre"),
    PRICE("price"),
    PUBLISH_DATE("publish_date"),
    DESCRIPTION("description"),
    ID("id");
    private String value;

    BookEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
