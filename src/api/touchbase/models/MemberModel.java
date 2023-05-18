package api.touchbase.models;

import api.touchbase.NotificationContent;

import java.util.List;

public class MemberModel {
    private String memberId;
    private String memberName;
    private boolean memberHasFamily;
    private String memberBirthday;
    private String memberPassword;
    private List<NotificationContent> notifications;

    public MemberModel() {

    }
    public MemberModel(Builder builder) {
        this.memberId = builder.memberId;
        this.memberName = builder.memberName;
        this.memberHasFamily = builder.memberHasFamily;
        this.memberBirthday = builder.memberBirthday;
        this.notifications = builder.notifications;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public boolean isMemberHasFamily() {
        return memberHasFamily;
    }

    public String getMemberBirthday() {
        return memberBirthday;
    }

    public List<NotificationContent> getNotifications() {
        return notifications;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberHasFamily=" + memberHasFamily +
                ", memberBirthday=" + memberBirthday +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String memberId;
        private String memberName;
        private String memberPassword;
        private boolean memberHasFamily;
        private String memberBirthday;
        private List<NotificationContent> notifications;

        public Builder withMemberId(String memberIdToUse) {
            this.memberId = memberIdToUse;
            return this;
        }

        public Builder withMemberName(String memberNameToUse) {
            this.memberName = memberNameToUse;
            return this;
        }

        public Builder withMemberPassword(String memberPasswordToUse) {
            this.memberPassword = memberPasswordToUse;
            return this;
        }

        public Builder withHasFamily(boolean memberHasFamilyToUse) {
            this.memberHasFamily = memberHasFamilyToUse;
            return this;
        }

        public Builder withMemberBirthday(String memberBirthdayToUse) {
            this.memberBirthday = memberBirthdayToUse;
            return this;
        }

        public Builder withNotifications(List<NotificationContent> notifications) {
            this.notifications = notifications;
            return this;
        }

        public MemberModel build() {
            return new MemberModel(this);
        }
    }
}
