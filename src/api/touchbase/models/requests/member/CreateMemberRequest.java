package api.touchbase.models.requests.member;

public class CreateMemberRequest {
    private String name;
    private String password;

    // Constructors
    public CreateMemberRequest() {

    }

    public CreateMemberRequest(String name, String handle,String password, String birthday) {
        this.name = name;
        this.password = password;
    }

    public CreateMemberRequest(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                '}';
    }

    // Builder class
    public static final class Builder {
        private String name;
        private String password;

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

        public CreateMemberRequest build() {
            return new CreateMemberRequest(this);
        }
    }
}
