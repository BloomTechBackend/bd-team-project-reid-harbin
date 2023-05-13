package api.touchbase.models.results;

public class DeleteMemberResult {
    private String responseMessage;

    public DeleteMemberResult() {
    }

    public DeleteMemberResult(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public DeleteMemberResult(Builder builder) {
        this.responseMessage = builder.responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String responseMessage;

        public Builder withResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
            return this;
        }

        public DeleteMemberResult build() {
            return new DeleteMemberResult(this);
        }
    }
}
