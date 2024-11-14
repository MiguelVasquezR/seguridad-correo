package resenas;

import static spark.Spark.*;

import com.google.gson.Gson;
import resenas.utils.Correo;

public class App {

    public static void main(String[] args) {

        port(getHerokuAssignedPort());

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Credentials", "true");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");

        });
        options("/*", (request, response) -> {
            response.status(200);
            return "OK";
        });

        post("/enviar", (req, res) -> {
            res.type("application/json");
            Datos correo = new Gson().fromJson(req.body(), Datos.class);
            return new Gson().toJson(
                    Correo.enviarAlertaSeguridad(correo.getDestinatario(), correo.getEmail(), correo.getPassword()));
        });

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
}
