package api.touchbase.models.requests;

public class CreateMemberRequest {
    private String name;
    private String password;
    private String birthday;

    // Constructors
    public CreateMemberRequest() {

    }

    public CreateMemberRequest(String name, String handle,String password, String birthday) {
        this.name = name;
        this.password = password;
        this.birthday = birthday;
    }

    public CreateMemberRequest(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
        this.birthday = builder.birthday;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    // Builder Constructor
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "CreateMemberRequest{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    // Builder class
    public static final class Builder {
        private String name;
        private String password;
        private String birthday;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withMemberPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public CreateMemberRequest build() {
            return new CreateMemberRequest(this);
        }
    }
}
