package entity;

import data.DataKasir;

public class Auth {

    private DataKasir users;

    public Auth(DataKasir users) {
        this.users = users;
    }

    public Kasir login(Kasir user) {
        for (Kasir iUser : users.getAll()) {
            if (iUser.equals(user, true)) {
                return user;
            }
        }

        return new UnknownKasir(user.getNip());
    }
}
