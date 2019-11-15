package adaseptimaback.Netflis2model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserResponse implements Serializable {
    private Long id;
    private List<Response> contenidosVistosPorUsuario = new ArrayList<>();

    public UserResponse(){}

    public UserResponse(Long id, List<Response> contenidosVistosPorUsuario) {
        this.id = id;
        this.contenidosVistosPorUsuario = contenidosVistosPorUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Response> getContenidosVistosPorUsuario() {
        return contenidosVistosPorUsuario;
    }

    public void setContenidosVistosPorUsuario(List<Response> contenidosVistosPorUsuario) {
        this.contenidosVistosPorUsuario = contenidosVistosPorUsuario;
    }
}
