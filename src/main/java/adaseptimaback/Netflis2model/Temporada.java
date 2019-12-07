package adaseptimaback.Netflis2model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="Temporada", uniqueConstraints = {@UniqueConstraint(columnNames={"Id"})})
public class Temporada  {
    @Id
    @GeneratedValue (generator = "incrementator")
    @GenericGenerator(name= "incrementator",strategy = "increment")
    @Column(name="Id", unique = true, nullable = false)
    private Long id;
    //@JsonIgnore
    @Column(name="serie", unique = true, nullable = false)
        private Serie serie;
    //@JsonProperty("number")
    @Column(name="NumberOfSeason", unique = true, nullable = false)
    private Integer numeroDeTemporada;
   // @JsonProperty("Episodes")
   @Column(name="Capitulos", unique = true, nullable = false)
    private List<Capitulo> capitulos = new ArrayList<>();

    public Integer sizeTemporada() {
        return getCapitulos().size();
    }
    public Integer getNumeroDeTemporada() {
        return numeroDeTemporada;
    }
    public void setNumeroDeTemporada(Integer numeroDeTemporada) {
        this.numeroDeTemporada = numeroDeTemporada;
    }
    public void agregarCapitulo(Capitulo unCapitulo) {
        this.getCapitulos().add(unCapitulo);
    }
    public boolean vistoCompleto(Usuario unUsuario) {
        return this.getCapitulos().stream()
                .allMatch(capitulo -> capitulo.vistoCompleto(unUsuario));
    }
    public Integer cuantosMinutosDuraLatemporadaCompleta() {
        return getCapitulos().stream()
                .mapToInt(capitulo -> capitulo.getDuracion())
                .sum();
    }
    public Capitulo ultimoCapituloDisponible() {
        return getCapitulos().get(getCapitulos().size()-1);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Capitulo> getCapitulos() {
        return capitulos;
    }
    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }
}
