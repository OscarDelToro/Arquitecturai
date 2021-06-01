import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class Tests {


    @Test
    void testSizeEmpty() {
        List<Integer> lista = new List<>();
        Assertions.assertEquals(0,lista.getSize());

    }
    @Test
    void testSizeWithElements() {
        List<Integer> lista = new List<>();
        lista.push(4);
        lista.push(10);
        Assertions.assertEquals(2,lista.getSize());

    }
    @Test
    void testSizeWithRemoval() {
        List<Integer> lista = new List<>();
        lista.push(4);
        lista.push(10);
        lista.removeAt(0);
        lista.push(1);
        lista.push(3);
        lista.push(6);
        lista.removeAt(3);
        Assertions.assertEquals(3,lista.getSize());
    }
    @Test
    void testSizeWithNull() {
        List<Integer> lista= null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            lista.getSize();
        });
    }
    @Test
    void testClearWithEmptyList() {
        List<Integer> lista= new List<>();
        Assertions.assertEquals(0,lista.getSize());
    }
    @Test
    void testClearWithFullList() {
        List<Integer> lista= new List<>();
        lista.push(3);
        lista.push(2);
        lista.push(1);
        lista.clear();
        Assertions.assertEquals(0,lista.getSize());
    }
    @Test
    void testClearWithFullListByTriggeringException() {
        List<Integer> lista= new List<>();
        lista.push(3);
        lista.push(2);
        lista.push(1);
        lista.clear();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.elementAt(0);
        });
    }
    @Test
    void testClearByCheckingToString() {
        List<Integer> lista= new List<>();
        lista.push(3);
        lista.push(2);
        lista.push(1);
        lista.clear();
        Assertions.assertEquals("[]",lista.toString());
    }

    @Test
    void testClearWithNullList() {
        List<Integer> lista= null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            lista.getSize();
        });
    }

    @Test
    void addItemsByToString() {
        List<Integer> lista= new List<>();
        Assertions.assertEquals("[]",lista.toString());
        lista.push(1);
        lista.push(2);
        lista.push(3);
        Assertions.assertEquals("[1, 2, 3]",lista.toString());
    }
    @Test
    void addItemsBySize() {
        List<Integer> lista= new List<>();
        Assertions.assertEquals(0,lista.getSize());
        lista.push(1);
        lista.push(2);
        lista.push(3);
        Assertions.assertEquals(3,lista.getSize());
    }
    @Test
    void addItemsByToStringCheckOrder() {
        List<Integer> lista= new List<>();
        Assertions.assertEquals("[]",lista.toString());
        lista.push(1);
        lista.push(2);
        lista.push(3);
        Assertions.assertEquals("[1, 2, 3]",lista.toString());
        lista.push(4);
        lista.push(5);
        Assertions.assertEquals("[1, 2, 3, 4, 5]",lista.toString());
    }
    @Test
    void itemDoesNotExists() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        Assertions.assertEquals(false,lista.has(4));
    }
    @Test
    void itemDoesExists() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        Assertions.assertEquals(true,lista.has(3));
    }
    @Test
    void itemExistedButRemoved() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        lista.removeAt(2);
        Assertions.assertEquals(false,lista.has(3));
    }
    @Test
    void getByIndex() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        Assertions.assertEquals(2,lista.elementAt(1));
    }
    @Test
    void getByIndexOutOfBOunds() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.elementAt(3);
        });
    }
    @Test
    void getByIndexWithRemoval() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        lista.removeAt(1);
        Assertions.assertEquals(3,lista.elementAt(1));
    }
    @Test
    void getByIndexEdgeMinor() {
        List<Integer> lista= new List<>();
        lista.push(1);
        Assertions.assertEquals(1,lista.elementAt(0));
    }
    @Test
    void getByIndexEdgeMajor() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        Assertions.assertEquals(3,lista.elementAt(2));
    }
    @Test
    void getIndexOfEdgeMajor() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        lista.push(4);
        lista.push(5);
        lista.push(6);
        Assertions.assertEquals(5,lista.indexOf(6));
    }
    @Test
    void getIndexOfEdgeMinor() {
        List<Integer> lista= new List<>();
        lista.push(1);
        Assertions.assertEquals(0,lista.indexOf(1));
    }
    @Test
    void getIndexOfEdgeMiddle() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        lista.push(4);
        lista.push(5);
        lista.push(6);
        Assertions.assertEquals(3,lista.indexOf(4));
    }
    @Test
    void getIndexOfUnexistingElement() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        lista.push(4);
        lista.push(5);
        lista.push(6);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            lista.indexOf(14);
        });
    }
    @Test
    void getIndexOfEmptyList() {
        List<Integer> lista= new List<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            lista.indexOf(4);
        });
    }
    @Test
    void RemoveTheOnlyElement() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.removeAt(0);
        Assertions.assertEquals("[]",lista.toString());
    }
    @Test
    void RemoveTheLastElement() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        lista.push(4);
        lista.removeAt(3);
        Assertions.assertEquals("[1, 2, 3]",lista.toString());
    }
    @Test
    void RemoveMiddleElement() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        lista.push(4);
        lista.removeAt(2);
        Assertions.assertEquals("[1, 2, 4]",lista.toString());
    }
    @Test
    void RemoveOutOfBoundsElement() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        lista.push(4);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.removeAt(5);
        });

    }
    @Test
    void RemoveFirstElement() {
        List<Integer> lista= new List<>();
        lista.push(1);
        lista.push(2);
        lista.push(3);
        lista.push(4);
        lista.removeAt(0);
        Assertions.assertEquals("[2, 3, 4]",lista.toString());
    }
}
