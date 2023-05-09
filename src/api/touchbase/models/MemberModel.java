package api.touchbase.models;

import api.touchbase.NotificationContent;

import java.time.LocalDateTime;
import java.util.List;

public class MemberModel {
    private String memberId;
    private String familyId;
    private String memberName;
    private int memberAge;
    private boolean memberHasFamily;
    private LocalDateTime memberBirthday;
    private int memberNumUnreadNotifications;

    public MemberModel() {

    }

    public MemberModel(Builder builder) {
        this.memberId = builder.memberId;
        this.familyId = builder.familyId;
        this.memberName = builder.memberName;
        this.memberAge = builder.memberAge;
        this.memberHasFamily = builder.memberHasFamily;
        this.memberBirthday = builder.memberBirthday;
        this.memberNumUnreadNotifications = builder.memberNumUnreadNotifications;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "memberId='" + memberId + '\'' +
                ", familyId='" + familyId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberAge=" + memberAge +
                ", memberHasFamily=" + memberHasFamily +
                ", memberBirthday=" + memberBirthday +
                ", memberNotifications=" + memberNumUnreadNotifications +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String memberId;
        private String familyId;
        private String memberName;
        private int memberAge;
        private boolean memberHasFamily;
        private LocalDateTime memberBirthday;
        private int memberNumUnreadNotifications;

        public Builder withMemberId(String memberIdToUse) {
            this.memberId = memberIdToUse;
            return this;
        }

        public Builder withFamilyId(String familyIdToUse) {
            this.familyId = familyIdToUse;
            return this;
        }

        public Builder withMemberName(String memberNameToUse) {
            this.memberName = memberNameToUse;
            return this;
        }

        public Builder withMemberAge(int memberAgeToUse) {
            this.memberAge = memberAgeToUse;
            return this;
        }

        public Builder withHasFamily(boolean memberHasFamilyToUse) {
            this.memberHasFamily = memberHasFamilyToUse;
            return this;
        }

        public Builder withMemberBirthday(LocalDateTime memberBirthdayToUse) {
            this.memberBirthday = memberBirthdayToUse;
            return this;
        }

        public Builder withMemberNotifications(int memberNumUnreadNotifications) {
            this.memberNumUnreadNotifications = memberNumUnreadNotifications;
            return this;
        }
    }
}
