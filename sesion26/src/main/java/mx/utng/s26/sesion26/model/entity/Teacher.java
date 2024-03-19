package mx.utng.s26.sesion26.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Teacher {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    @Column(length = 90)
    private String name;

    @Min(0)
    @Max(50)
    private int yearOfService;

    @Temporal(TemporalType.TIMESTAMP)
    private Date recorAt;

    @PrePersist
    public void PrePersist(){
        recorAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYearOfService() {
        return yearOfService;
    }

    public Date getRecorAt() {
        return recorAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfService(int yearOfService) {
        this.yearOfService = yearOfService;
    }

    public void setRecorAt(Date recorAt) {
        this.recorAt = recorAt;
    }

    
}
