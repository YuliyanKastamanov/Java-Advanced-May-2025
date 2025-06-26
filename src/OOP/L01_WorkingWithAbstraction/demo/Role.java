package OOP.L01_WorkingWithAbstraction.demo;

public enum Role {
    ADMIN(true),
    USER(false),
    SUPPORT(false);

    private boolean isAccessAllowed;

    Role(boolean isAccessAllowed) {
        this.isAccessAllowed = isAccessAllowed;
    }

    public boolean isAccessAllowed(){
        return this.isAccessAllowed;
    }


}
