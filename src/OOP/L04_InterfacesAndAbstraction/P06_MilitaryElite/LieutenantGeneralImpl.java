package OOP.L04_InterfacesAndAbstraction.P06_MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Collection<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary, Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        this.setPrivates(privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        this.getPrivates().forEach(p -> sb.append("  ").append(p).append(System.lineSeparator()));
        return sb.toString();
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }

    private void setPrivates(Collection<Private> privates) {
        if (privates != null) {
            this.privates = new ArrayList<>(privates);
            return;
        }

        this.privates = new ArrayList<>();
    }
}
