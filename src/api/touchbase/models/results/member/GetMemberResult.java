package api.touchbase.models.results.member;

import api.touchbase.models.objects.MemberModel;

public class GetMemberResult {
    private MemberModel member;


    public GetMemberResult(Builder builder) {
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


        public GetMemberResult build() {
            return new GetMemberResult(this);
        }
    }
}
