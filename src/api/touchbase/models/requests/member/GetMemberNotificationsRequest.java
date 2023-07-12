package api.touchbase.models.requests.member;

public class GetMemberNotificationsRequest {
    private String memberId;

    // Constructors
    public GetMemberNotificationsRequest() {

    }

    public GetMemberNotificationsRequest(String memberId) {
        this.memberId = memberId;
    }

    public GetMemberNotificationsRequest(Builder builder) {
        this.memberId = builder.memberId;
    }

    // Getters and Setters
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GetMemberNotificationsRequest{" +
                "memberId='" + memberId + '\'' +
                '}';
    }

    // Builder class
    public static final class Builder {
        private String memberId;

        private Builder() {

        }

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public GetMemberNotificationsRequest build() {
            return new GetMemberNotificationsRequest(this);
        }
    }

}

