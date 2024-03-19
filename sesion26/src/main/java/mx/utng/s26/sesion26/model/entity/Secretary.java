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
import jakarta.validation.constraints.NotNull;

@Entity
public class Secretary { 
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    @Column(length = 90)
    private String name;

    @NotEmpty
    @Column(length = 60)
    private String cargo;

    @NotNull(message = "No puede estar vacio")
    @Min(value = 1)
    @Max(value = 20)
    private Integer numCub;//parta que el dato no sea de tipo primitivo

   @NotEmpty(message = "Seleccionde un horario")
    private String hour;


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

    public String getCargo() {
        return cargo;
    }
    public Integer getNumCub() {
        return numCub;
    }
public String getHour() {
    return hour;
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

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setNumCub(Integer numCub) {
        this.numCub = numCub;
    }

    public void setHour(String hour) {
        this.hour = hour;

    }


    public void setRecorAt(Date recorAt) {
        this.recorAt = recorAt;
    }

    
}
