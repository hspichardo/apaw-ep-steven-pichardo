package es.upm.miw.apaw_ep_themes.documents;

public interface TreeClient {
    String id();
    String name();
    String dni();
    String lastname();
    String email();
    boolean isComposite();
    void add(TreeClient treeClient);
    void remove(TreeClient treeClient);
}
