package OOP.L01_WorkingWithAbstraction.demo;

public class User {

    private String name;
    private Role role;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public boolean changeRoleToSupport(User user){

        if(this.role.equals("ADMIN")){
            user.role = Role.SUPPORT;
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return String.format("Hello my name is: %s, my role is: %s", name, role);
    }
}
