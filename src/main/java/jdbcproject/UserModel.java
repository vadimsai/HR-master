package jdbcproject;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    int id;
    List<UserJdbc> list =new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UserJdbc> getList() {
        return list;
    }

    public void setList(List<UserJdbc> list) {
        this.list = list;
    }
}
