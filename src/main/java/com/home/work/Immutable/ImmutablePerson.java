package com.home.work.Immutable;

import java.util.Date;

public final class ImmutablePerson {
    private final String name;
    private final Date birthday;

    private ImmutablePerson(String name, Date birthday) {
        this.name = name;
        this.birthday = new Date(birthday.getTime());
    }

    public static ImmutablePerson getInstance(String name, Date birthday){
        return new ImmutablePerson(name, birthday);
    }

    public Date getBirthday() {
        return new Date(birthday.getTime());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name +", birthday=" + birthday;
    }
}
