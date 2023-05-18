package api.touchbase.models.results;

import api.touchbase.models.MemberModel;

public class CreateMemberResult {
    private MemberModel member;

    public CreateMemberResult(Builder builder) {
        this.member = builder.member;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "CreateMemberResult{" +
                "member=" + member +
                '}';
    }

    public static final class Builder {
        private MemberModel member;

        public Builder withMember(MemberModel memberModel) {
            this.member = memberModel;
            return this;
        }

        public CreateMemberResult build() {
            return new CreateMemberResult(this);
        }
    }

}

