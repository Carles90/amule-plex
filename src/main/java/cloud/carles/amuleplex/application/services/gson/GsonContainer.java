package cloud.carles.amuleplex.application.services.gson;

import com.google.gson.Gson;

public class GsonContainer {
    public static Gson get() {
        return new Gson();
    }
}
