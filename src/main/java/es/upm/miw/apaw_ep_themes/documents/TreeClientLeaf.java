package es.upm.miw.apaw_ep_themes.documents;

public class TreeClientLeaf implements  TreeClient{
    private Client client;

    public TreeClientLeaf(Client client){
        this.client = client;
    }

    @Override
    public String id() {
        return this.client.getId();
    }

    @Override
    public String name() {
        return this.client.getName();
    }

    @Override
    public String dni() {
        return this.client.getDni();
    }

    @Override
    public String lastname() {
        return this.client.getLastname();
    }

    @Override
    public String email() {
        return this.client.getEmail();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeClient treeClient) {
        // Do nothing because is leaf
    }

    @Override
    public void remove(TreeClient treeClient) {
        // Do nothing because is leaf
    }
}
