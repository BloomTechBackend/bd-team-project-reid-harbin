package api.touchbase.models.requests.member;

public class MemberLoginRequest {
    private String memberName;
    private String memberPassword;

    public MemberLoginRequest() {

    }

    public MemberLoginRequest(String memberName, String memberPassword) {
        this.memberName = memberName;
        this.memberPassword = memberPassword;
    }

    public MemberLoginRequest(Builder builder) {
        this.memberName = builder.memberName;
        this.memberPassword = builder.memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String memberName;
        private String memberPassword;

        public Builder withMemberName(String memberName) {
            this.memberName = memberName;
            return this;
        }

        public Builder withMemberPassword(String memberPassword) {
            this.memberPassword = memberPassword;
            return this;
        }

        public MemberLoginRequest build(){
            return new MemberLoginRequest(this);
        }
    }
}
