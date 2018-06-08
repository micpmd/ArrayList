package arraylist;

import org.junit.Test;

//import arraylist.sol.ArrayList;

import static org.junit.Assert.*;

/**
 * @author jspacco
 *
 */
public class TestArrayList {
  @Test
  public void testEmptyList() {
      ArrayList<Integer> list = new ArrayList<Integer>();
      assertEquals(0, list.size());
  }
  
  @Test
  public void testAddToEmptyList() {
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(5);
      assertEquals(1, list.size());
  }
  
  @Test
  public void testGetFromListWithOne() {
      ArrayList<String> list = new ArrayList<String>();
      list.add("a");
      assertEquals("a", list.get(0));
  }
  
  @Test
  public void testAddTwo() {
      ArrayList<String> list = new ArrayList<String>();
      list.add("a");
      list.add("b");
      assertEquals(2, list.size());
      assertEquals("a", list.get(0));
      assertEquals("b", list.get(1));
  }
  
  @Test
  public void testEmpty() {
      ArrayList<String> list = new ArrayList<String>();
      //System.out.println(list.toString());
      assertEquals("[ ]", list.toString());
  }
  
  @Test
  public void testToString() {
      ArrayList<String> list = new ArrayList<String>();
      list.add("a");
      list.add("b");
      list.add("c");
      assertEquals("[ a b c ]", list.toString());
  }
  
  @Test
  public void testSet1() {
      ArrayList<String> list = new ArrayList<String>();
      list.add("a");
      list.add("b");
      list.set(0, "c");
      assertEquals(2, list.size());
      assertEquals("c", list.get(0));
      assertEquals("b", list.get(1));
  }
  
  @Test
  public void testSet2() {
      ArrayList<String> list = new ArrayList<String>();
      for (String s : new String[] {"a", "b", "c", "d", "e"}){
          list.add(s);
      }
      list.set(4, "z");
      assertEquals(5, list.size());
      assertEquals("a", list.get(0));
      assertEquals("b", list.get(1));
      assertEquals("c", list.get(2));
      assertEquals("d", list.get(3));
      assertEquals("z", list.get(4));
  }
  
  @Test
  public void testInsertEmpty() {
      ArrayList<String> list = new ArrayList<String>();
      list.insert(0, "a");
      assertEquals(1, list.size());
      assertEquals("a", list.get(0));
  }
  
  
  /**
   * Helper method for creating a ArrayList with 5 Strings, "0" through "4".
   * @return
   */
  private ArrayList<String> makeList() {
      return makeList(0, 5);
  }
  
  private ArrayList<String> makeList(int start, int end){
      ArrayList<String> list = new ArrayList<String>();
      for (int i=start; i<end; i++){
          list.add(i+"");
      }
      return list;
  }
  
  @Test
  public void testInsertMiddle() {
      ArrayList<String> list = makeList();
      assertEquals(5, list.size());
      
      list.insert(2, "a");
      System.out.println(list);
      
      assertEquals(6, list.size());
      
      assertEquals("a", list.get(2));
      
      assertEquals("0", list.get(0));
      assertEquals("1", list.get(1));
      
      assertEquals("2", list.get(3));
      assertEquals("3", list.get(4));
      assertEquals("4", list.get(5));
  }
  
  @Test
  public void testInsertEnd() {
      ArrayList<String> list = makeList();
      list.insert(5, "5");

      //System.out.println(list);
      assertEquals(6, list.size());
      
      assertEquals("0", list.get(0));
      assertEquals("1", list.get(1));
      assertEquals("2", list.get(2));      
      assertEquals("3", list.get(3));
      assertEquals("4", list.get(4));
      assertEquals("5", list.get(5));
  }
  
  @Test
  public void testInsertFirst() {
      ArrayList<String> list = makeList();
      list.insertFirst("a");
      //System.out.println(list);
      assertEquals(6, list.size());
      
      assertEquals("a", list.get(0));
      assertEquals("0", list.get(1));
      assertEquals("1", list.get(2));      
      assertEquals("2", list.get(3));
      assertEquals("3", list.get(4));
      assertEquals("4", list.get(5));
  }
  
  @Test
  public void testRemoveFirst() {
      ArrayList<String> list = makeList();

      String s = list.remove(0);
      
      assertEquals(4, list.size());
      
      assertEquals("0", s);
      
      assertEquals("1", list.get(0));
      assertEquals("2", list.get(1));      
      assertEquals("3", list.get(2));
      assertEquals("4", list.get(3));
  }
  
  @Test
  public void testRemoveLast() {
      ArrayList<String> list = makeList();

      String s = list.remove(4);
      
      assertEquals(4, list.size());
      
      assertEquals("4", s);
      
      assertEquals("0", list.get(0));
      assertEquals("1", list.get(1));      
      assertEquals("2", list.get(2));
      assertEquals("3", list.get(3));
  }


  
  @Test
  public void testSubList1() {
      List<String> list1 = makeList();
      List<String> list2 = list1.subList(1);
      
      assertEquals(5, list1.size());
      assertEquals(4, list2.size());
      
      assertEquals("1", list2.get(0));
      assertEquals("2", list2.get(1));
      assertEquals("3", list2.get(2));
      assertEquals("4", list2.get(3));
      
  }
  
  @Test
  public void testSubList2() {
      List<String> list1 = makeList();
      List<String> list2 = list1.subList(1, 3);
      
      assertEquals(5, list1.size());
      assertEquals(2, list2.size());
      
      assertEquals("1", list2.get(0));
      assertEquals("2", list2.get(1));
  }
  
  @Test
  public void testAddAll() {
      List<String> list1 = makeList();
      List<String> list2 = makeList(5, 10);
      list1.add(list2);
      
      assertEquals(10, list1.size());
      assertEquals(5, list2.size());
      
      for (int i=0; i<10; i++){
          assertEquals(i+"", list1.get(i));
      }
  }
  
  @Test
  public void testContainsFirst() {
      List<String> list1 = makeList();
      assertTrue(list1.contains("0"));
  }
  
  @Test
  public void testContainsSecond() {
      List<String> list1 = makeList();
      assertTrue(list1.contains("1"));
  }
  
  @Test
  public void testContainsLast() {
      List<String> list1 = makeList();
      assertTrue(list1.contains("4"));
  }
  
  @Test
  public void testNotContains() {
      List<String> list1 = makeList();
      assertFalse(list1.contains("77"));
  }
}