package com.lambda.demol.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by beixinyuan_android on 2018/4/2.
 */

public class ICLinearLayout extends LinearLayout {

    //顶部标题文本大小
    private int TITLE_TEXT_SIZE = 80;
    //底部文字的大小
    private int BOOTOM_TEXT_SIZE = 50;
    //顶部标题
    private String TOP_TITLE = "邀请码";
    //底部文字
    private String BOTTOM_TITLE = "95折优惠券";

    //文字和横线之间的距离
    private final int TEXTOFFSET = 20;
    //四个边角对应的宽度
    private final int CORNER_WIDTH = 16;

    private Paint topTitleTextPaint;
    private Paint bootomTitlePaint;
    private Paint.FontMetrics topTitlefontMetrics;
    private Paint.FontMetrics bottomTitleFont;
    public ICLinearLayout(Context context) {
        super(context);
    }

    public ICLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ICLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ICLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        RectF rectF = getFramingRect(canvas);
        //画标题
        drawTitle(canvas, rectF);
        //画下标题
        drawBootomTitle(canvas, rectF);
        //画四边
        draw4Edge(canvas, rectF);

        this.setPadding(CORNER_WIDTH, (int) (topTitlefontMetrics.bottom - topTitlefontMetrics.top), CORNER_WIDTH, (int) (bottomTitleFont.bottom - bottomTitleFont.top));
    }

    /**
     * 矩形
     * @return
     */
    private RectF getFramingRect(Canvas canvas) {

        float width = canvas.getWidth();
        float height = canvas.getHeight();
        Log.d("yunchong", "Canvas---width:"+width);
        Log.d("yunchong", "Canvas---height:"+height);
        RectF framingRect = new RectF(0, 0, width, height);
        return framingRect;
    }
    /**
     * 绘画标题
     * @param canvas
     */
    private void drawTitle(Canvas canvas, RectF rectF) {
        topTitleTextPaint = new Paint();
        topTitleTextPaint.setColor(Color.WHITE);
        topTitleTextPaint.setTextSize(TITLE_TEXT_SIZE);
        topTitleTextPaint.setStyle(Paint.Style.FILL);
        topTitleTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        //该方法即为设置基线上那个点到底是left,center,还是right  这里我设置为center
        topTitleTextPaint.setTextAlign(Paint.Align.CENTER);
        topTitlefontMetrics = topTitleTextPaint.getFontMetrics();
        float top = topTitlefontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = topTitlefontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
        int baseLineY = (int) (rectF.top - top);//基线中间点的y轴计算公式
        canvas.drawText(TOP_TITLE,rectF.centerX(),baseLineY,topTitleTextPaint);
    }

    /**
     * 画下边
     * @param canvas
     * @param rectF
     */
    private void drawBootomTitle(Canvas canvas, RectF rectF){
        bootomTitlePaint = new Paint();
        bootomTitlePaint.setColor(Color.RED);
        bootomTitlePaint.setTextSize(BOOTOM_TEXT_SIZE);
        bootomTitlePaint.setStyle(Paint.Style.FILL);
        bootomTitlePaint.setTypeface(Typeface.DEFAULT_BOLD);
        //该方法即为设置基线上那个点到底是left,center,还是right  这里我设置为center
        bootomTitlePaint.setTextAlign(Paint.Align.CENTER);

        bottomTitleFont = bootomTitlePaint.getFontMetrics();

        float top = bottomTitleFont.top;
        float bottom = bottomTitleFont.bottom;
        canvas.drawText(BOTTOM_TITLE,rectF.centerX(),rectF.bottom - bottomTitleFont.bottom,bootomTitlePaint);
    }

    /**
     * 画四边
     * @param canvas
     * @param rectF
     */
    private void draw4Edge(Canvas canvas, RectF rectF){
        Paint paint = new Paint();
        //标题文字长度
        float titleWidth = topTitleTextPaint.measureText(TOP_TITLE);
        Paint.FontMetrics top_fontMetrics = topTitleTextPaint.getFontMetrics();
        float top_top = top_fontMetrics.top;
        float top_bottom = top_fontMetrics.bottom;
        //底部文字长度
        float bootomTextWidth = bootomTitlePaint.measureText(BOTTOM_TITLE);
        Paint.FontMetrics bottom_fontMetrics = topTitleTextPaint.getFontMetrics();
        float bottom_top = bottom_fontMetrics.top;
        float bottom_bottom = bottom_fontMetrics.bottom;
        // 画扫描框边上的角，总共8个部分
        paint.setColor(Color.WHITE);
        // 左上横线
        canvas.drawRect(rectF.left, rectF.top - top_top/2 + top_bottom/2 , rectF.centerX() - titleWidth / 2 - TEXTOFFSET, rectF.top - top_top/2 + top_bottom/2 + CORNER_WIDTH, paint);
        // 右上横线
        canvas.drawRect(rectF.centerX() + titleWidth / 2 + TEXTOFFSET, rectF.top - top_top/2 + top_bottom/2, rectF.right, rectF.top - top_top/2 + top_bottom/2 + CORNER_WIDTH, paint);
        // 左竖线
        canvas.drawRect(rectF.left, rectF.top - top_top/2 + top_bottom/2, rectF.left + CORNER_WIDTH, rectF.bottom + bottom_top/2 - bottom_bottom/2 + CORNER_WIDTH, paint);
        // 右竖线
        canvas.drawRect(rectF.right - CORNER_WIDTH, rectF.top - top_top/2 + top_bottom/2, rectF.right, rectF.bottom + bottom_top/2 - bottom_bottom/2 + CORNER_WIDTH, paint);
        // 左下横线
        canvas.drawRect(rectF.left, rectF.bottom + bottom_top/2 + bottom_bottom/2 -  CORNER_WIDTH / 2, rectF.centerX() - bootomTextWidth / 2 - TEXTOFFSET, rectF.bottom + bottom_top/2 + bottom_bottom/2 +  CORNER_WIDTH / 2, paint);
        //右下横线
        canvas.drawRect(rectF.centerX() + bootomTextWidth / 2 + TEXTOFFSET, rectF.bottom + bottom_top/2 + bottom_bottom/2 -  CORNER_WIDTH / 2, rectF.right, rectF.bottom + bottom_top/2 + bottom_bottom/2 +  CORNER_WIDTH / 2, paint);

    }

}
