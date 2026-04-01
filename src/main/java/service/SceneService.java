package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Scene;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SceneService {

    private static final Map<Integer, Scene> scenes = new HashMap<>();

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream is = SceneService.class
                    .getClassLoader()
                    .getResourceAsStream("scenes.json");

            if (is == null) {
                throw new RuntimeException("scenes.json not found");
            }

            List<Scene> list = mapper.readValue(is, new TypeReference<List<Scene>>() {});

            for (Scene s : list) {
                scenes.put(s.getId(), s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Scene getScene(int id) {
        return scenes.get(id);
    }
}