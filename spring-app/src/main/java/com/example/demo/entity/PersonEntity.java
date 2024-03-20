package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;
    private String prenume;
    @Column(unique = true)
    private String email;
    private Integer varsta;


    public PersonEntity() {
    }


    public PersonEntity(Long id, String nume, String prenume, String email, Integer varsta) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.varsta = varsta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", varsta=" + varsta +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        return Objects.equals(id, personEntity.id) &&
                Objects.equals(nume, personEntity.nume) &&
                Objects.equals(prenume, personEntity.prenume) &&
                Objects.equals(email, personEntity.email) &&
                Objects.equals(varsta, personEntity.varsta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, prenume, email, varsta);
    }
}


//am adăugat o metodă de comparație a obiectelor în clasa Person. Această metodă compara toate proprietățile
// obiectului și returnează true dacă sunt egale și false în caz contrar.
//Această metodă va fi utilă în teste, pentru a verifica dacă obiectele Person sunt egale sau nu.







