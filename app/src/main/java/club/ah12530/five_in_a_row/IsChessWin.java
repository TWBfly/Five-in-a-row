package club.ah12530.five_in_a_row;


import android.content.Context;
import android.graphics.Point;

import java.util.List;

public class IsChessWin {
    private boolean isGameOver = false;   //判断是否游戏结束
    private boolean isWhiteWin;     //判断是否白棋胜
    private int MAX_NUMWIN = 5;  //设置5子连在一起胜利
    private int CURRENT_NUM = 0;
    private Context mContext;
    private boolean isRestart=false;
    public IsChessWin(Context context) {
        super();
        mContext = context;
    }

    /**
     * 判断是否胜利
     * @param whitePoints
     * @param blackPoints
     * @return
     */
    public boolean isGameOverMethod(List<Point> whitePoints, List<Point> blackPoints) {
        boolean whiteWin = isWhiteWin(whitePoints);
        boolean blackWin = isBlackWin(blackPoints);

        if (whiteWin || blackWin) {
            isGameOver = true;
            isWhiteWin = whiteWin;
        }
        return isGameOver;
    }

    /**
     * 返回是否白棋取胜
     * @return
     */
    public boolean isWhiteWinFlag(){
        return isWhiteWin;
    }

    /**
     * 判断是否白棋取胜
     * @param points
     * @return
     */
    private boolean isWhiteWin(List<Point> points) {
        if (isFiveConnect(points)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否黑棋取胜
     * @param points
     * @return
     */
    private boolean isBlackWin(List<Point> points) {
        if (isFiveConnect(points)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否五子连珠
     * @param points
     * @return
     */
    private boolean isFiveConnect(List<Point> points) {
        for (Point p : points) {
            int x = p.x;
            int y = p.y;
            if (isHorizontalFive(x, y, points)) {
                return true;
            } else if (isVerticalFive(x, y, points)) {
                return true;
            } else if (isSkewFive(x, y, points)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否横向五子连珠
     * @param x
     * @param y
     * @param points
     * @return
     */
    private boolean isHorizontalFive(int x, int y, List<Point> points) {
        //判断横向向右是否练成5子,points里面存的值为int类型，所以可以进行加一或者减一的运算
        for (int i = 0; i < MAX_NUMWIN; i++) {
            if (points.contains(new Point(x + i, y))) {
                CURRENT_NUM++;
            } else {
                break;
            }
        }
        if (MAX_NUMWIN == CURRENT_NUM) {
            return true;
        } else {
            CURRENT_NUM = 0;
        }
        //判断横向向左是否连成5子
        for (int i = 0; i < MAX_NUMWIN; i++) {
            if (points.contains(new Point(x - i, y))) {
                CURRENT_NUM++;
            } else {
                break;
            }
        }
        if (MAX_NUMWIN == CURRENT_NUM) {
            return true;
        } else {
            CURRENT_NUM = 0;
        }
        return false;
    }

    /**
     * 判断是否竖直五子连珠
     * @param x
     * @param y
     * @param points
     * @return
     */
    private boolean isVerticalFive(int x, int y, List<Point> points) {
        for (int i = 0; i < MAX_NUMWIN; i++) {
            //判断向下是否5子连珠
            if (points.contains(new Point(x, y + i))) {
                CURRENT_NUM++;
            } else {
                break;
            }
        }
        if (MAX_NUMWIN == CURRENT_NUM) {
            return true;
        } else {
            CURRENT_NUM = 0;
        }
        //判断向上是否5子连珠
        for (int i = 0; i < MAX_NUMWIN; i++) {
            if (points.contains(new Point(x, y - i))) {
                CURRENT_NUM++;
                if (5 == CURRENT_NUM) {
                    return true;
                }
            } else {
                CURRENT_NUM = 0;
                break;
            }
        }
        if (MAX_NUMWIN == CURRENT_NUM) {
            return true;
        } else {
            CURRENT_NUM = 0;
        }
        return false;
    }

    /**
     * 判断斜着是否五子连珠
     * @param x
     * @param y
     * @param points
     * @return
     */
    private boolean isSkewFive(int x, int y, List<Point> points) {
        //判断左斜下是否5子连珠
        for (int i = 0; i < MAX_NUMWIN; i++) {
            if (points.contains(new Point(x - i, y + i))) {
                CURRENT_NUM++;
            } else {
                break;
            }
        }
        if (MAX_NUMWIN == CURRENT_NUM) {
            return true;
        } else {
            CURRENT_NUM = 0;
        }
        //判断左上是否5子连珠
        for (int i = 0; i < MAX_NUMWIN; i++) {
            if (points.contains(new Point(x - i, y - i))) {
                CURRENT_NUM++;
            } else {
                break;
            }
        }
        if (MAX_NUMWIN == CURRENT_NUM) {
            return true;
        } else {
            CURRENT_NUM = 0;
        }
        //判断右上是否5子连珠
        for (int i = 0; i < MAX_NUMWIN; i++) {
            if (points.contains(new Point(x + i, y - i))) {
                CURRENT_NUM++;
            } else {
                break;
            }
        }
        if (MAX_NUMWIN == CURRENT_NUM) {
            return true;
        } else {
            CURRENT_NUM = 0;
        }
        //判断右斜上是否5子连珠
        for (int i = 0; i < MAX_NUMWIN; i++) {
            if (points.contains(new Point(x + i, y - i))) {
                CURRENT_NUM++;
            } else {
                break;
            }
        }
        if(MAX_NUMWIN==CURRENT_NUM){
            return true;
        }else{
            CURRENT_NUM=0;
        }
        //判断右斜下是否5子连珠
        for (int i = 0; i < MAX_NUMWIN; i++) {
            if (points.contains(new Point(x + i, y + i))) {
                CURRENT_NUM++;
            } else {
                break;
            }
        }
        if(MAX_NUMWIN==CURRENT_NUM){
            return true;
        }else{
            CURRENT_NUM=0;
        }
        return false;
    }
}
