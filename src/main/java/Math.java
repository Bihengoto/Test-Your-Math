import org.sql2o.Connection;

import java.util.List;

public class Math {
    private int id;
    private String name;
    private String email;
    private int perform;


    public Math(String name, String email, int perform) {
        this.name = name;
        this.email = email;
        this.perform = perform;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPerform() {
        return perform;
    }

    public void save() {
        try(Connection con = DB.sql2o.open())  {
            String sql = "INSERT INTO math (name, email) VALUES (:name, :email)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("email",this.email)
                    .addParameter("perform",this.perform)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Math> all() {
        String sql = "SELECT * FROM math";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Math.class);
        }
    }

    @Override
    public boolean equals(Object otherMath){
        if (!(otherMath instanceof Math)) {
            return false;
        } else {
            Math newMath = (Math) otherMath;
            return this.getId() == newMath.id;
        }
    }

}