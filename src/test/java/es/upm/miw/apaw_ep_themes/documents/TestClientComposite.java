package es.upm.miw.apaw_ep_themes.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestClientComposite {
    private TreeClient root;
    private TreeClient sub;
    private TreeClient leaf;

    @BeforeEach
    void start(){
        TreeClient subClient1;


        this.root = new TreeClientComposite("Rolling","AA0102938","Stones","rstones@gmail.com");
        this.leaf = new TreeClientLeaf(new Client("Mick","AA121282","Jagger","mjagger@gmail.com"));
        this.root.add(leaf);

        this.root.add(new TreeClientLeaf(new Client("keith","AA1ew82","Richards","krichards@gmail.com")));

        subClient1 = new TreeClientComposite("Guardias","adada1234","Seguridad Guardespaldas","guardiasrstones@gmail.com");
        this.root.add(subClient1);
        subClient1.add(new TreeClientLeaf( new Client("juan","AB122312","Perez","jperes@gmail.com")));
        this.sub = new TreeClientComposite("Sonidistas","aasds","banda rolling","sonidistarstones@gmail.com");
        subClient1.add(sub);

        this.sub.add(new TreeClientLeaf(new Client("Jose","AY123112","Madero","jmadero@gmail.com")));

    }

    @Test
    void testClientofTreeClientIfLeaf(){
        assertEquals("Mick",this.leaf.name());

    }

    @Test
    void testClientofTreeClientIfComposite(){
        assertEquals("Rolling",this.root.name());
    }

    @Test

    void testClientIfLeaf(){
        assertEquals("Jagger",this.leaf.lastname());
    }
}
