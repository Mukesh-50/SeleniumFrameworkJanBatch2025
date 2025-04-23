package Bhakti_Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Bhakti_Testcase {
  @Test(priority = 1)
  public void Test1() 
  {
	  Assert.assertEquals("Bhakti", "Bhakti","String is not equal");
  }
  @Test(priority = 2)
  public void Test2() 
  {
	  Assert.assertSame("12", "Bhakti","String is not equal");
  }
  @Test(priority = 3)
  public void Test3() 
  {
	  Assert.assertTrue("Bhakti".equalsIgnoreCase("Bhakti"));
  }
}
