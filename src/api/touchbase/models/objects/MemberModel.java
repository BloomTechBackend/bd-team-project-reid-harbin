package api.touchbase.models.objects;

import api.touchbase.dynamodb.models.Notification;

import java.util.List;

public class MemberModel {
    private String memberId;
    private String memberName;
    private List<Notification> notifications;
    private String memberFamilyId;

    public MemberModel() {

    }
    public MemberModel(Builder builder) {
        this.memberId = builder.memberId;
        this.memberName = builder.memberName;
        this.notifications = builder.notifications;
        this.memberFamilyId = builder.familyId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public String getFamilyId() {
        return memberFamilyId;
    }

    public void setFamilyId(String familyId) {
        this.memberFamilyId = familyId;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String memberId;
        private String memberName;
        private String memberPassword;
        private List<Notification> notifications;
        private String familyId;

        public Builder withMemberId(String memberIdToUse) {
            this.memberId = memberIdToUse;
            return this;
        }

        public Builder withMemberName(String memberNameToUse) {
            this.memberName = memberNameToUse;
            return this;
        }

        public Builder withNotifications(List<Notification> notifications) {
            this.notifications = notifications;
            return this;
        }

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
            return this;
        }

        public MemberModel build() {
            return new MemberModel(this);
        }
    }
}
