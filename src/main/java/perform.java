//import org.sql2o.Connection;
//
//import java.util.List;
//
//public class perform {
//    private int id;
//    private int perform;
//
//
//    public Math(int perform) {
//
//        this.perform = perform;
//
//    }
//
//    public int getId() {
//        return id;
//    }
//
//
//    public int getPerform() {
//        return perform;
//    }
//
//    public void save() {
//        try(Connection con = DB.sql2o.open())  {
//            String sql = "INSERT INTO math (perform, email) VALUES (:perform)";
//            this.id = (int) con.createQuery(sql, true)
//
//                    .addParameter("perform",this.perform)
//                    .executeUpdate()
//                    .getKey();
//        }
//    }
//
//    public static List<Math> all() {
//        String sql = "SELECT * FROM math";
//        try(Connection con = DB.sql2o.open()) {
//            return con.createQuery(sql).executeAndFetch(Math.class);
//        }
//    }
//
//    @Override
//    public boolean equals(Object otherMath){
//        if (!(otherMath instanceof Math)) {
//            return false;
//        } else {
//            Math newMath = (Math) otherMath;
//            return this.getId() == newMath.id;
//        }
//    }
//
//}