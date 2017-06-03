package tw.gof;

/**
 * Hello world!
 *
 */
public class App 
{

//    视图中默认矩形的长度
    private int xLength= 3;
    private int yLength = 3;


    private int[][] view1 = null;
    private int[][] view2 = null;
    private boolean isView1InUse = false;
    public App(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        view1 = new int[xLength][yLength];
        view2 = new int[xLength][yLength];
    }

    //初始化视图
    public boolean initView(int[][] arr){
        if(arr.length!=xLength || arr[0].length!=yLength){
            return false;
        }

        for(int i = 0; i< view1.length; i++){
            for (int j = 0; j < view1[0].length; j++) {
                view1[i][j] = arr[i][j];
            }
        }
        isView1InUse = true;
        return true;
    }

    public  boolean updataPixel(int x ,int y){
        if(x<0 || y<0 || x>=xLength || y>=yLength){
            return false;
        }

        int[][] oldView = view1, newView = view2;
        if(!isView1InUse){
            oldView = view2;
            newView = view1;
        }
//        int temp = oldView[x-1][y-1]+oldView[x-1][y]+oldView[x-1][y+1]
//                +oldView[x][y-1]+oldView[x][y+1]+oldView[x+1][y-1]+oldView[x+1][y]+oldView[x+1][y+1];
        int temp = 0;
        for(int i=x-1; i<= x+1; i++){
            for(int j=y-1; j<= y+1; j++){
                if(i<0 || j<0 || i>=xLength || j>=yLength || (i == x && j == y)){
                    continue;
                }
                temp += oldView[i][j];
            }
        }
        if (temp== 3){
            newView[x][y] = 1;
        }else if(temp ==2){
            newView[x][y] = oldView[x][y];
        }else{
            newView[x][y] = 0;
        }
        return true;
    }

    public void updateLife(){
        int[][] nowView = view1;
        if(!isView1InUse) {
            nowView = view2;
        }
        for (int i = 0; i < nowView.length; i++) {
            for (int j = 0; j < nowView[i].length; j++) {
                updataPixel(i, j);
            }
        }
        //取反
        isView1InUse = !isView1InUse;
    }

    @Override
    public String toString(){

        int[][] nowView = view1;
        StringBuffer sb = new StringBuffer();
        if(!isView1InUse) {
            nowView = view2;
        }
        for (int i = 0; i < nowView.length; i++) {
            for (int j = 0; j < nowView[i].length; j++) {
                sb.append(nowView[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printGame(){
        int[][] nowView = view1;
        if(!isView1InUse) {
            nowView = view2;
        }
        for (int i = 0; i < nowView.length; i++) {
            for (int j = 0; j < nowView[i].length; j++) {
                if(nowView[i][j] == 1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }


    public static void main(String[] args )
    {

//        App app = new App(3, 3);
//        int[][] graph = new int[][]{
//                {0, 0, 0},
//                {1, 1, 1},
//                {0, 0, 0}
//        };
        App app = new App(2, 4);
        int[][] graph = new int[][]{
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };
        app.initView(graph);
        while(true) {
            app.updateLife();
            app.printGame();
            System.out.println("------------------------------");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
