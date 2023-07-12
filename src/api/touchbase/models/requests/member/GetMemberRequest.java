package api.touchbase.models.requests.member;

public class GetMemberRequest {
    private String memberId;

    public GetMemberRequest() {
    }

    public GetMemberRequest(String memberId) {
        this.memberId = memberId;
    }

    public GetMemberRequest(Builder builder) {
        this.memberId = builder.memberId;
    }

    // Getters and Setters
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GetMemberDetailsRequest{" +
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

        public GetMemberRequest build() {
            return new GetMemberRequest(this);
        }
    }
}
