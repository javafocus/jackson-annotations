package com.jackson.demo.jacksonannotations.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UserDetails.UserDetailsBuilder.class)
public class UserDetails {

    @JsonView({UserViews.BasicView.class, UserViews.ExtendedView.class})
    private long userId;

    @JsonView({UserViews.BasicView.class, UserViews.ExtendedView.class})
    private String firstName;

    @JsonView({UserViews.BasicView.class, UserViews.ExtendedView.class})
    private String lastName;

    @JsonView({UserViews.BasicView.class, UserViews.ExtendedView.class})
    private int age;

    @JsonView({UserViews.BasicView.class, UserViews.ExtendedView.class})
    private String ssn;

    @JsonView({UserViews.ExtendedView.class})
    private String phonenumber;

    @JsonView({UserViews.ExtendedView.class})
    private String category;

    private UserDetails(long userId, String firstName, String lastName, int age, String ssn, String phonenumber, String category) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
        this.phonenumber = phonenumber;
        this.category = category;
    }

    public long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSsn() {
        return ssn;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getCategory() {
        return category;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserDetailsBuilder {

        private long userId;

        private String firstName;

        private String lastName;

        private int age;

        private String ssn;

        private String phonenumber;

        private String category;

        public UserDetailsBuilder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public UserDetailsBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDetailsBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDetailsBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserDetailsBuilder ssn(String ssn) {
            this.ssn = ssn;
            return this;
        }

        public UserDetailsBuilder phonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        public UserDetailsBuilder category(String category) {
            this.category = category;
            return this;
        }

        public UserDetails build() {
            return new UserDetails(userId, firstName, lastName, age, ssn, phonenumber, category);
        }
    }
}
