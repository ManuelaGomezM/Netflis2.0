package adaseptimaback.neflisService;
import adaseptimaback.Netflis2model.Response;
import adaseptimaback.Netflis2model.UserResponse;
import adaseptimaback.neflisPersistence.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private List<UserResponse> userResponses;
    @Autowired
    private UserStorage userStorage;

    public List<Response> contenidoVistoPorUsuario(Long id) {
        userResponses = userStorage.userList();
        return this.getUserPorId(id).getContenidosVistosPorUsuario();
    }

    public UserResponse getUserPorId(Long id) {
        return userResponses.stream()
                .filter(u -> u.getId() == id).findFirst().get();
    }
}
