package entity;

import data.PekerjaRepository;

public class Auth {

    private PekerjaRepository users;

    public Auth(PekerjaRepository users) {
        this.users = users;
    }

    public Kasir login(Kasir user) {
        for (Pekerja iUser : users.getAll()) {
            if (iUser.equals(user, true)) {
                return user;
            }
        }

        return new UnknownKasir(user.getNip());
    }
}
