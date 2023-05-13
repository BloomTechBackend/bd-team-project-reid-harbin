package api.touchbase.models.results;

import api.touchbase.models.MemberModel;

public class GetMemberDetailsResult {
    private MemberModel member;


    public GetMemberDetailsResult(Builder builder) {
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

    public static final class Builder {
        private MemberModel member;

        public Builder withMember(MemberModel member) {
            this.member = member;
            return this;
        }


        public GetMemberDetailsResult build() {
            return new GetMemberDetailsResult(this);
        }
    }
}
