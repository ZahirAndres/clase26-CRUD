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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class Building { 
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    @Column(length = 90)
    private String letra;

    @NotEmpty
    @Column(length = 60)
    private String name;

    @NotEmpty
    @Column(length = 60)
    private String area;

    @NotNull(message = "No puede esatr vacio")
    @Min(value = 1994, message = "Aun no existia la univarsidad")
    private Integer anioBuilt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date recorAt;

    @PrePersist
    public void PrePersist(){
        recorAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getLetra() {
        return letra;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }
    public Integer getAnioBuilt() {
        return anioBuilt;
    }

    public Date getRecorAt() {
        return recorAt;
    }


    public void setId(Long id) { 
        this.id = id;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public void setAnioBuilt(Integer anioBuilt) {
        this.anioBuilt = anioBuilt;
    }

    public void setRecorAt(Date recorAt) {
        this.recorAt = recorAt;
    }

    


    
}
