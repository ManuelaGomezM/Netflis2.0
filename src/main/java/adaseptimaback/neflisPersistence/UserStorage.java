package adaseptimaback.neflisPersistence;
import adaseptimaback.Netflis2model.UserResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class UserStorage {
    @Autowired
    private ObjectMapper objectMapper;

    public List<UserResponse> userList(){
        try {
            return objectMapper.readValue(
                    new File("src\\main\\resources\\users.json"),
                    new TypeReference<List<UserResponse>>() {
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo leer el archivo",e);
        }
    }
}