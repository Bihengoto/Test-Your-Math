import org.apache.log4j.BasicConfigurator;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        BasicConfigurator.configure();

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/index.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("question", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/question.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("perform", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/perform.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("questionTwo", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/questionTwo.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

//        post("/quiz", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            String name = request.queryParams("name");
//            String email = request.queryParams("email");
//            Math newMath = new Math(name, email);
//            newMath.save();
//            response.redirect("/question");
//            return new ModelAndView(model, layout);
//        }, new VelocityTemplateEngine());



    }
}
