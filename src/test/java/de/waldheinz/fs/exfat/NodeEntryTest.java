
package de.waldheinz.fs.exfat;

import org.junit.Ignore;
import de.waldheinz.fs.util.RamDisk;
import java.io.IOException;
import java.io.InputStream;
import de.waldheinz.fs.FsDirectory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthias Treydte &lt;waldheinz at gmail.com&gt;
 */
public class NodeEntryTest {

    private final static String ENTRY_NAME = "folder with image";

    private RamDisk bd;
    private NodeDirectory dir;
    private NodeEntry entry;

    @Before
    public void setUp() throws IOException {
        final InputStream is =
                getClass().getResourceAsStream("exfat-test.dmg.gz");
        bd = RamDisk.readGzipped(is);
        is.close();
        dir = (NodeDirectory) ExFatFileSystem.read(bd, false).getRoot();
        entry = (NodeEntry) dir.getEntry(ENTRY_NAME);
    }
    
    @Test
    public void testGetName() {
        System.out.println("getName");
        
        assertEquals(ENTRY_NAME, entry.getName());
    }
    
    @Test
    public void testGetParent() throws IOException {
        System.out.println("getParent");
        
        final FsDirectory parent = entry.getParent();
        
        assertNotNull(parent);
        assertEquals(entry, parent.getEntry(ENTRY_NAME));
    }
    
    @Test
    @Ignore
    public void testGetLastModified() throws Exception {
        System.out.println("getLastModified");
        
    }

    @Test
    @Ignore
    public void testGetCreated() throws Exception {
        System.out.println("getCreated");
        
    }

    @Test
    @Ignore
    public void testGetLastAccessed() throws Exception {
        System.out.println("getLastAccessed");

        
    }

    @Test
    public void testIsFile() {
        System.out.println("isFile");
        
        assertFalse(entry.isFile());
    }

    @Test
    public void testIsDirectory() {
        System.out.println("isDirectory");
        
        assertTrue(entry.isDirectory());
    }

    @Test
    @Ignore
    public void testSetName() throws Exception {
        System.out.println("setName");
        
        
    }

    @Test
    @Ignore
    public void testSetLastModified() throws Exception {
        System.out.println("setLastModified");
        
        
    }

    @Test(expected=UnsupportedOperationException.class)
    public void testGetFile() throws Exception {
        System.out.println("getFile");

        entry.getFile();
    }

    @Test
    @Ignore
    public void testGetDirectory() throws Exception {
        System.out.println("getDirectory");
        
        assertNotNull(entry.getDirectory());
    }

    @Test
    public void testIsDirty() {
        System.out.println("isDirty");
        
        assertFalse(entry.isDirty());
    }
    
}
