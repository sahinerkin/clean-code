package singleresponsibility;

public class BadPractice {

    static class User {
        // User sınıfı hem fullName gibi şahıs bilgilerini,
        // hem username ve PIN gibi yetkilendirme (authorization) bilgilerini,
        // hem de address gibi kullanıcıya ya da hesaba tanımlanabilecek bilgileri tutuyor.

        private String fullName;
        private String username;
        private String PIN;
        private String address;

        User(String username, String PIN) {
            setUsername(username);
            setPIN(PIN);
        }

        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }

        public void setUsername(String username) { this.username = username; }

        public void setPIN(String PIN) { this.PIN = PIN; }

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public boolean authenticate(String username, String PIN) {
            return this.username == username && this.PIN == PIN;
        }
    }

    public static void main(String[] args) {
        User u = new User("douglasadams", "1952");
        u.setFullName("Douglas Noel Adams");
        u.setAddress("42 Hitchhikers Street, UK, Earth");

        System.out.println(u.getFullName());
        System.out.println(u.getAddress());
        System.out.println(u.authenticate("douglasadams", "1234"));
    }

}
