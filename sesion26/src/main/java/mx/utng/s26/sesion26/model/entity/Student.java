/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */

package mx.utng.s26.sesion26.model.entity;
import java.lang.Math;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
    private float calf;
    @Min(value = 0, message = "No puede ser menor a 0")
    @Max(value = 10, message = "No puede ser mayor que 10")
    private float calf2;
    @Min(value = 0, message = "No puede ser menor a 0")
    @Max(value = 10, message = "No puede ser mayor que 10")
    private float calf3;

  
    @Min(value = 0, message = "No puede ser menor a 0")
    @Max(value = 10, message = "No puede ser mayor que 10")
    private float average;


    @Temporal (TemporalType.DATE)
    private Date recorAt;

  
    @PreUpdate
    public void prePersistOrUpdate() {
        average = (float) (Math.round(((calf + calf2 + calf3) / 3) * 10.0) / 10.0);
    }
    
    
    @PrePersist
    public void prePersist(){
        recorAt = new Date(); //crea la fecha y hora actual
        average =(float) (Math.round(((calf + calf2 + calf3) / 3) * 10.0) / 10.0);
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
    public float getCalf() {
        return calf;
    }
    public float getCalf2() {
        return calf2;
    }
    public float getCalf3() {
        return calf3;
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
    public void setCalf(float calf) {
        this.calf = calf;
    }
    public void setCalf2(float calf2) {
        this.calf2 = calf2;
    }
    public void setCalf3(float calf3) {
        this.calf3 = calf3;
    }

    public void setRecorAt(Date recorAt) {
        this.recorAt = recorAt;
    }

    
}
