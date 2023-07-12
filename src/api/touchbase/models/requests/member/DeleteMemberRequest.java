package api.touchbase.models.requests.member;

public class DeleteMemberRequest {
    private String memberId;
    private String memberPassword;
    private String memberName;

    public DeleteMemberRequest() {
    }

    public DeleteMemberRequest(String memberId, String memberPassword, String memberName) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
    }

    public DeleteMemberRequest(Builder builder) {
        this.memberId = builder.memberId;
        this.memberPassword = builder.memberPassword;
        this.memberName = builder.memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "DeleteMemberRequest{" +
                "memberId='" + memberId + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                '}';
    }

    // Builder Class
    public static final class Builder {
        private String memberId;
        private String memberPassword;
        private String memberName;

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder withMemberPassword(String memberPassword) {
            this.memberPassword = memberPassword;
            return this;
        }

        public Builder withMemberName(String memberName) {
            this.memberName = memberName;
            return this;
        }

        public DeleteMemberRequest build() {
            return new DeleteMemberRequest(this);
        }
    }
}
