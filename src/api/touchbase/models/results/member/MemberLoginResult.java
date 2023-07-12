package api.touchbase.models.results.member;

public class MemberLoginResult {
    private String memberId;
    private String memberFamilyId;

    public MemberLoginResult() {

    }

    public MemberLoginResult(String memberId) {
        this.memberId = memberId;
    }

    public MemberLoginResult(String memberId, String memberFamilyId) {
        this.memberId = memberId;
        this.memberFamilyId = memberFamilyId;
    }

    public MemberLoginResult(Builder builder) {
        this.memberId = builder.memberId;
        this.memberFamilyId = builder.memberFamilyId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberFamilyId() {
        return memberFamilyId;
    }

    public void setMemberFamilyId(String memberFamilyId) {
        this.memberFamilyId = memberFamilyId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String memberId;
        private String memberFamilyId;

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder withMemberFamilyId(String memberFamilyId) {
            this.memberFamilyId = memberFamilyId;
            return this;
        }

        public MemberLoginResult build() {
            return new MemberLoginResult(this);
        }
    }
}
