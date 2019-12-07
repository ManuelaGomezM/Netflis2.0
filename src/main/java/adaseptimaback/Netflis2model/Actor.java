package adaseptimaback.Netflis2model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "Actores")

public class Actor {
    @Id
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name= "incrementator",strategy = "increment")
    @Column(name="Id", unique = true, nullable = false)

        private Long id;
        private String name;

    public Actor() {
    }
    public Actor(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Boolean actuoEn(Contenido contenido){
            return contenido.actuo(this);
        }
        public Actor (String name){
            this.name=name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
}



