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
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty 
    @Column (length = 30)
    private String name;
    @NotEmpty
    @Column (length = 30)
    private String middleName;
    @NotEmpty
    @Column (length = 30)
    private String lasName;

  
    @Min(value = 0, message = "No puede ser menor a 0")
    @Max(value = 10, message = "No puede ser mayor que 10")
    private Float average = 0.0f;


    @Temporal (TemporalType.DATE)
    private Date recorAt;
    
    @PrePersist
    public void prePersist(){
        recorAt = new Date(); //crea la fecha y hora actual

    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLasName() {
        return lasName;
    }
    public Float getAverage() {
        return average;
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
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setLasName(String lasName) {
        this.lasName = lasName;
    }
    public void setAverage(Float average) {
        this.average = average;
    }
    public void setRecorAt(Date recorAt) {
        this.recorAt = recorAt;
    }

    
}
