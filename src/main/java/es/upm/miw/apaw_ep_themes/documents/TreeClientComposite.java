package es.upm.miw.apaw_ep_themes.documents;

import java.util.List;

public class TreeClientComposite implements TreeClient {

    private String id;

    private String name;

    private String dni;

    private String lastname;

    private String email;

    private List<TreeClient> treeClientList;


    @Override
    public String id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String dni() {
        return this.dni;
    }

    @Override
    public String lastname() {
        return this.lastname;
    }

    @Override
    public String email() {
        return this.email;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeClient treeClient) {
        this.treeClientList.add(treeClient);
    }

    @Override
    public void remove(TreeClient treeClient) {
        this.treeClientList.remove(treeClient);
    }
}
