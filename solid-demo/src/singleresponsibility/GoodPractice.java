package singleresponsibility;

public class GoodPractice {
    static class Account {

        // Account bilgisi hesapla ilişkili giriş yetki kimliği,
        // hesap sahibi şahıs ve faturalandırma adresini
        // ilgili sınıfların nesneleri olarak tutuyor.

        // Bu nesnelere ait detaylı bilgiler ve işlevsellikler
        // ayrı sınıflarda enkapsüle ediliyor.
        // Böylece her sınıfın tek bir sorumluluğu oluyor.

        Account(Credentials cred) {
            this.credentials = cred;
        }

        private Credentials credentials;
        private Person accountOwner;
        private Address billingAddress;


        public Credentials getCredentials() { return credentials; }
        public void setCredentials(Credentials cred) { this.credentials = cred; }

        public Person getAccountOwner() { return accountOwner; }
        public void setAccountOwner(Person owner) { this.accountOwner = owner; }

        public Address getBillingAddress() { return billingAddress; }
        public void setBillingAddress(Address address) { this.billingAddress = address; }
    }

    static class Credentials {

        Credentials(String username, String PIN) {
            setUsername(username);
            setPIN(PIN);
        }

        private String username;
        private String PIN;

        public void setUsername(String username) { this.username = username; }
        public void setPIN(String PIN) { this.PIN = PIN; }

        public boolean authenticate(String username, String PIN) {
            return this.username == username && this.PIN == PIN;
        }
    }

    static class Person {
        private String firstName;
        private String familyName;
        private String nationalID;

        Person(String firstName, String familyName) {
            this.firstName = firstName;
            this.familyName = familyName;
        }

        public String getFirstName() { return firstName; }
        public String getFamilyName() { return familyName; }

        public String getNationalID() { return nationalID; }
        public void setNationalID(String id) { this.nationalID = id; }
    }

    static class Address {
        private String line1;
        private String line2;
        private String city;
        private String state;

        Address(String line1, String line2, String city, String state) {
            updateAddressInfo(line1, line2, city, state);
        }

        public void updateAddressInfo(String line1, String line2, String city, String state) {
            this.line1 = line1;
            this.line2 = line2;
            this.city = city;
            this.state = state;
        }

        public String getAddressInfoAsString() {
            String lines = (line2 == null) ? line1 : String.format("%s\n%s", line1, line2);
            String addressInfo = String.format("%s\n%s, %s", lines, city, state);
            return addressInfo;
        }
    }

    public static void main(String[] args) {

        Credentials myCred = new Credentials("username", "1234");
        Person myAccOwner = new Person("Name", "Surname");
        Address myAd = new Address("321 Nameless Street", "2 Line Rd", "Brooklyn", "NY");

        Account myAcc = new Account(myCred);
        myAcc.setAccountOwner(myAccOwner);
        myAcc.setBillingAddress(myAd);

        myAcc.getAccountOwner().setNationalID("12345678901");

    }
}
