package spring.producer.dto;

public class MessageQueueDTO {

    private String text;
    private Boolean isError;

    public MessageQueueDTO() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean error) {
        isError = error;
    }
}
