package tw.gof;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    public void testInit_normal(){
        App app = new App(3,3);

        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            arr[1][i] = 1;
        }

        assertEquals(app.initView(arr),true);

    }

    public void testUpdateLife_normal(){
        App app = new App(3, 3);
        int[][] graph = new int[][]{
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        };
        String grapnew = "010\n010\n010\n";
        app.initView(graph);
        app.updateLife();
        assertEquals(app.toString(), grapnew);
    }

    public void testUpdateLife_In2Times_normal(){
        App app = new App(3, 3);
        int[][] graph = new int[][]{
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        };
        String grapnew = "000\n111\n000\n";
        app.initView(graph);
        app.updateLife();
        app.updateLife();
        assertEquals(app.toString(), grapnew);
    }

    public void testUpdateLife_unnormal(){
        App app = new App(2, 4);
        int[][] graph = new int[][]{
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };
        String grapnew = "0110\n0110\n";
        app.initView(graph);
        app.updateLife();
        assertEquals(app.toString(), grapnew);
    }


    public void testUpdateLife_testmodel2(){
        App app = new App(3, 3);
        int[][] graph = new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {1, 0, 0}
        };
        String grapnew = "000\n010\n010\n";
        app.initView(graph);
        app.updateLife();
        assertEquals(app.toString(), grapnew);
    }

}
