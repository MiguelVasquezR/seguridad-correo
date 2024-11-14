package resenas;

public class Datos {

    private String destinatario;
    private String email;
    private String password;

    public Datos() {
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Datos [destinatario=" + destinatario + ", email=" + email + ", password=" + password + "]";
    }

}
