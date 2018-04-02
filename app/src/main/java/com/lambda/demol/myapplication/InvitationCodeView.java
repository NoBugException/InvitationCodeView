package com.lambda.demol.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * 常识：移动View内容的相关变量和方法
 * =============================
 * View的内容相对于View在水平方向上的偏移量，以像素为单位
 * 当mScrollX为正数时，内容相对于View从右向左移动，反之则向从左向右移动
 * =============================
 * View的内容相对于View在垂直方向上的偏移量，以像素为单位
 * 当mScrollY为负数时，内容相对于View从下向上移动，反之则向从上向下移动
 * =============================
 * 获取内容偏移量mScrollX的值
 * int android.view.View.getScrollX()
 * =============================
 * 获取内容偏移量mScrollY的值
 * int android.view.View.getScrollY()
 * =============================
 * 设置内容偏移量mScrollX的值，此方法引发View重新调整内容的位置并重绘
 * 相当于调用scrollTo(value,mScrollY)
 * void android.view.View.setScrollX(int value)
 * =============================
 * 设置内容偏移量mScrollY的值，此方法引发View重新调整内容的位置并重绘
 * 相当于调用scrollTo(mScrollX,value)
 * void android.view.View.setScrollY(int value)
 * =============================
 * 将View的内容移动到参数所指定的位置中，此时mScrollX=x，mScrollY=y。
 * 此方法引发View重新调整内容的位置并重绘
 * void android.view.View.scrollTo(int x, int y)
 * =============================
 * 设置View内容移动的增量，相当于调用scrollTo(mScroll+x, mScroll+y);
 * 此方法引发View重新调整内容的位置并重绘
 * void android.view.View.scrollBy(int x, int y)
 * =============================
 * 此成员变量包含了View的平移、缩放、旋转、锚点等属性
 * 平移相关的是mTransformationInfo.mTranslationX和mTransformationInfo.mTranslationY
 * TransformationInfo mTransformationInfo;
 * =============================
 * 此方法用于获取View在水平方向的偏移量，以像素为单位
 * public float android.view.View.getTranslationX()
 * =============================
 * 此方法用于获取View在垂直方向的偏移量，以像素为单位
 * public float android.view.View.getTranslationY()
 * =============================
 * 此方法用于设置View在水平方向的偏移量，以像素为单位。会引发View重绘
 * 偏移量为正数时，表示View从左向右平移。反之则从右向左平移
 * public void android.view.View.setTranslationX(float translationX)
 * =============================
 * 此方法用于设置View在水平方向的偏移量，以像素为单位。会引发View重绘
 * 偏移量为正数时，表示View从上向下平移。反之则从下向上平移
 * public void android.view.View.setTranslationY(float translationY)
 * =============================
 * 此成员变量包含了View的平移、缩放、旋转、锚点等属性
 * 缩放相关的是mTransformationInfo.mScaleX和mTransformationInfo.mScaleY
 * ransformationInfo mTransformationInfo;
 * =============================
 * 此方法用于获取View在水平方向的缩放比例。
 * public float android.view.View.getScaleX()
 * =============================
 * 此方法用于获取View在垂直方向的缩放比例。
 * public float android.view.View.getScaleY()
 * =============================
 * 设置View在水平方向的缩放比例
 * scaleX=1，表示是原来的大小
 * scaleX<1，表示缩小，如scale=0.5f，表示宽度是原来的0.5倍
 * scaleX>1，表示放大，如scale=2.0f，表示宽度是原来的2.0倍
 * public void android.view.View.setScaleX(float scaleX)
 * =============================
 * 设置View在垂直方向的缩放比例
 * scaleY=1，表示是原来的大小
 * scaleY<1，表示缩小，如scale=0.5f，表示高度是原来的0.5倍
 * caleY>1，表示放大，如scale=2.0f，表示高度是原来的2.0倍
 * public void android.view.View.setScaleY(float scaleY)
 * =============================
 * 设置锚点的X坐标值，以像素为单位。默认是View的中心。
 * public void android.view.View.setPivotX(float pivotX)
 * =============================
 * 设置锚点的Y坐标值，以像素为单位。默认是View的中心。
 * public void android.view.View.setPivotX(float pivotX)
 * =============================
 * 此成员变量包含了View的平移、缩放、旋转、锚点等属性
 * 缩放相关是mTransformationInfo的mRotation、mRotationX、mRotationY
 * TransformationInfo mTransformationInfo;
 * =============================
 * 此方法用于获取View在Z轴上的旋转角度
 * public float android.view.View.getRotation()
 * =============================
 * 此方法用于获取View在X轴上的旋转角度
 * public float android.view.View.getRotationX()
 * =============================
 * 此方法用于获取View在Y轴上的旋转角度
 * public float android.view.View.getRotationY()
 * =============================
 * 设置View在Z轴上的旋转角度
 * public void android.view.View.setRotation(float rotation)
 * =============================
 * 设置View在X轴上的旋转角度
 * public void android.view.View.setRotationX(float rotationX)
 * =============================
 * 设置View在Y轴上的旋转角度
 * public void android.view.View.setRotationY(float rotationY)
 * =============================
 * 设置View旋转中心点的X坐标。
 * public void android.view.View.setPivotX(float pivotX)
 * =============================
 * 设置View旋转中心点的Y坐标。
 * public void android.view.View.setPivotX(float pivotX)
 * =============================
 * 设置摄像机的与旋转目标在Z轴上距离
 * void android.view.View.setCameraDistance(float distance)
 * =============================
 *
 * =============================
 * =============================
 * =============================
 * =============================
 * Canvas的常用操作速查表
 * --------------------------------------------------------------------------------------------------------------------
 * 操作类型         相关API                                   备注
 * --------------------------------------------------------------------------------------------------------------------
 * 绘制颜色        drawColor, drawRGB, drawARGB               使用单一颜色填充整个画布
 * --------------------------------------------------------------------------------------------------------------------
 * 绘制基本形状    drawPoint, drawPoints, drawLine,           依次为 点、线、矩形、圆角矩形、椭圆、圆、圆弧
 *                 drawLines, drawRect, drawRoundRect,
 *                 drawOval, drawCircle, drawArc
 * --------------------------------------------------------------------------------------------------------------------
 * 绘制图片        drawBitmap, drawPicture                    绘制位图和图片
 * --------------------------------------------------------------------------------------------------------------------
 * 绘制文本        drawText, drawPosText, drawTextOnPath      依次为 绘制文字、绘制文字时指定每个文字位置、根据路径绘制文字
 * --------------------------------------------------------------------------------------------------------------------
 * 绘制路径        drawPath                                   绘制路径，绘制贝塞尔曲线时也需要用到该函数
 * --------------------------------------------------------------------------------------------------------------------
 * 顶点操作        drawVertices, drawBitmapMesh               通过对顶点操作可以使图像形变，drawVertices直接对画布作用、
 *                                                            drawBitmapMesh只对绘制的Bitmap作用
 * --------------------------------------------------------------------------------------------------------------------
 * 画布剪裁        clipPath, clipRect                         设置画布的显示区域
 * --------------------------------------------------------------------------------------------------------------------
 * 画布快照        save, restore, saveLayerXxx,               依次为 保存当前状态、 回滚到上一次保存的状态、
 *                 restoreToCount, getSaveCount               保存图层状态、 回滚到指定状态、 获取保存次数
 * --------------------------------------------------------------------------------------------------------------------
 * 画布变换        translate, scale, rotate, skew             依次为 位移、缩放、 旋转、倾斜
 * --------------------------------------------------------------------------------------------------------------------
 * Matrix(矩阵)    getMatrix, setMatrix, concat                实际上画布的位移，缩放等操作的都是图像矩阵Matrix，
 *                                                             只不过Matrix比较难以理解和使用，故封装了一些常用的方法。
 * --------------------------------------------------------------------------------------------------------------------
 * Canvas基本操作详解
 * --------------------------------------------------------------------------------------------------------------------
 * 绘制图片
 * 绘制有两种方法，drawPicture(矢量图) 和 drawBitmap(位图)
 * (1)drawPicture
 * 使用Picture前请关闭硬件加速，以免引起不必要的问题！
 * 在AndroidMenifest文件中application节点下添上 Android:hardwareAccelerated=”false”以关闭整个应用的硬件加速。
 * PS：你可以把Picture看作是一个录制Canvas操作的录像机。
 * --------------------------------------------------------------------------------------------------------------------
 * 相关方法                                                    简介
 * --------------------------------------------------------------------------------------------------------------------
 * public int getWidth ()                                      获取宽度
 * --------------------------------------------------------------------------------------------------------------------
 * public int getHeight ()                                     获取高度
 * --------------------------------------------------------------------------------------------------------------------
 * public Canvas beginRecording (int width, int height)        开始录制 (返回一个Canvas，在Canvas中所有的绘制都会存储在Picture中)
 * --------------------------------------------------------------------------------------------------------------------
 * public void endRecording ()                                 结束录制
 * --------------------------------------------------------------------------------------------------------------------
 * public void draw (Canvas canvas)                            将Picture中内容绘制到Canvas中
 * --------------------------------------------------------------------------------------------------------------------
 * public static Picture createFromStream (InputStream stream) (已废弃)通过输入流创建一个Picture
 * --------------------------------------------------------------------------------------------------------------------
 * public void writeToStream (OutputStream stream)             (已废弃)将Picture中内容写出到输出流中
 * --------------------------------------------------------------------------------------------------------------------
 * 硬件加速：setLayerType(View.LAYER_TYPE_SOFTWARE, null);
 * --------------------------------------------------------------------------------------------------------------------
 *  private Picture mPicture = new Picture();
 *  //录制
 *  private void recording() {
 *      // 开始录制 (接收返回值Canvas)
 *      Canvas canvas = mPicture.beginRecording(500, 500);
 *      // 创建一个画笔
 *      Paint paint = new Paint();
 *      paint.setColor(Color.BLUE);
 *      paint.setStyle(Paint.Style.FILL);
 *      // 在Canvas中具体操作
 *      // 位移
 *      canvas.translate(250,250);
 *      // 绘制一个圆
 *      canvas.drawCircle(0,0,100,paint);
 *      mPicture.endRecording();
 *  }
 * --------------------------------------------------------------------------------------------------------------------
 * 绘制Picture方法
 * 主要区别               分类                              简介
 * 是否对Canvas有影响     1有影响；2,3不影响                此处指绘制完成后是否会影响Canvas的状态(Matrix clip等)
 * 可操作性强弱           1可操作性较弱；2,3可操作性较强    此处的可操作性可以简单理解为对绘制结果可控程度
 *
 * 1.将Picture中的内容绘制在Canvas上
 * mPicture.draw(canvas);
 * PS：这种方法在比较低版本的系统上绘制后可能会影响Canvas状态，所以这种方法一般不会使用。
 * 2.使用Canvas提供的drawPicture方法绘制
 * drawPicture有三种方法：
 * public void drawPicture (Picture picture)
 * public void drawPicture (Picture picture, Rect dst)
 * public void drawPicture (Picture picture, RectF dst)
 * 和使用Picture的draw方法不同，Canvas的drawPicture不会影响Canvas状态。
 * canvas.drawPicture(mPicture,new RectF(0,0,mPicture.getWidth(),200));
 * 3.将Picture包装成为PictureDrawable，使用PictureDrawable的draw方法绘制。
 * 包装成为Drawable
 * PictureDrawable drawable = new PictureDrawable(mPicture);
 * 设置绘制区域 -- 注意此处所绘制的实际内容不会缩放
 * drawable.setBounds(0,0,250,mPicture.getHeight());
 * 绘制
 * drawable.draw(canvas);
 *
 * 注意：在使用Picture之前请关闭硬件加速，以免引起不必要的问题
 * --------------------------------------------------------------------------------------------------------------------
 * (2)drawBitmap
 * 获取Bitmap方式:
 * 通过Bitmap创建          复制一个已有的Bitmap(新Bitmap状态和原有的一致) 或者 创建一个空白的Bitmap(内容可改变)
 * 通过BitmapDrawable获取  从资源文件 内存卡 网络等地方获取一张图片并转换为内容不可变的Bitmap
 * 通过BitmapFactory获取   从资源文件 内存卡 网络等地方获取一张图片并转换为内容不可变的Bitmap
 * Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),R.raw.bitmap)
 * 资源文件(assets):
 * Bitmap bitmap=null;
 * try {
 * InputStream is = mContext.getAssets().open("bitmap.png");
 * bitmap = BitmapFactory.decodeStream(is);
 * is.close();
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 * 内存卡文件:
 * Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/bitmap.png");
 * 网络文件:
 * Bitmap bitmap = BitmapFactory.decodeStream(is);
 * is.close();
 * --------------------------------------------------------------------------------------------------------------------
 * public void drawBitmap (Bitmap bitmap, Matrix matrix, Paint paint)
 * canvas.drawBitmap(bitmap,new Matrix(),new Paint())
 * --------------------------------------------------------------------------------------------------------------------
 * public void drawBitmap (Bitmap bitmap, float left, float top, Paint paint)
 * canvas.drawBitmap(bitmap,200,500,new Paint());
 * --------------------------------------------------------------------------------------------------------------------
 * public void drawBitmap (Bitmap bitmap, Rect src, Rect dst, Paint paint)
 * public void drawBitmap (Bitmap bitmap, Rect src, RectF dst, Paint paint)
 *        // 将画布坐标系移动到画布中央
 *        canvas.translate(mWidth/2,mHeight/2);
 *        // 指定图片绘制区域(左上角的四分之一)
 *        Rect src = new Rect(0,0,bitmap.getWidth()/2,bitmap.getHeight()/2);
 *        // 指定图片在屏幕上显示的区域
 *        ect dst = new Rect(0,0,200,400);
 *        // 绘制图片
 *        canvas.drawBitmap(bitmap,src,dst,null);
 * PS:绘制Bitmap的部分区域
 * --------------------------------------------------------------------------------------------------------------------
 * 2.绘制文字
 * 第一类只能指定文本基线位置(基线x默认在字符串左侧，基线y默认在字符串下方)。
 *     public void drawText (String text, float x, float y, Paint paint)
 *     public void drawText (String text, int start, int end, float x, float y, Paint paint)
 *     public void drawText (CharSequence text, int start, int end, float x, float y, Paint paint)
 *     public void drawText (char[] text, int index, int count, float x, float y, Paint paint)
 * --------------------------------------------------------------------------------------------------------------------
 * 第二类可以分别指定每个文字的位置。
 *     public void drawPosText (String text, float[] pos, Paint paint)
 *     public void drawPosText (char[] text, int index, int count, float[] pos, Paint paint)
 * --------------------------------------------------------------------------------------------------------------------
 * 第三类是指定一个路径，根据路径绘制文字
 *     public void drawTextOnPath (String text, Path path, float hOffset, float vOffset, Paint paint)
 *     public void drawTextOnPath (char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint)
 * --------------------------------------------------------------------------------------------------------------------
 * Paint文本相关常用方法表
 * --------------------------------------------------------------------------------------------------------------------
 * 标题       相关方法                        备注
 * 色彩       setColor setARGB setAlpha       设置颜色，透明度
 * 大小       setTextSize                     设置文本字体大小
 * 字体       setTypeface                     设置或清除字体样式
 * 样式       setStyle                        填充(FILL),描边(STROKE),填充加描边(FILL_AND_STROKE)
 * 对齐       setTextAlign                    左对齐(LEFT),居中对齐(CENTER),右对齐(RIGHT)
 * 测量       measureText                     测量文本大小(注意，请在设置完文本各项参数后调用)
 * --------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------
 * 自定义view分为四步：
 * 1.继承view，覆盖构造方法
 * 2.自定义属性
 * 3.重写onMeasure方法测量宽高
 * 4.重写onDraw方法
 * --------------------------------------------------------------------------------------------------------------------
 * 自定义属性详解：
 * 格式：
 * <declare-styleable name="View">
 *     <attr name="id" format="reference" />
 *     <attr name="background" format="reference|color" />
 *     <attr name="padding" format="dimension" />
 *     <attr name="focusable" format="boolean" />
 * </declare-styleable>
 *
 * 分类：
 * 1.带format：我们知道系统已经定义过名称为text的属性，我们不用自己定义，只需要在自定义属性中申明，我要使用这个text属性
 * 2.不带format：我们并不知道系统定义了此名称的属性，我们自己定义一个名为text或者mText的属性
 *
 * format支持的类型：
 * （1）reference：参考某一资源ID
 *      <attr name = "background" format = "reference" />
 *      <ImageView android:background = "@drawable/图片ID"/>
 * （2） color：颜色值
 *      <attr name = "textColor" format = "color" />
 *      <TextView android:textColor = "#00FF00" />
 * （3）boolean：布尔值
 *      <attr name = "focusable" format = "boolean" />
 *      <Button android:focusable = "true"/>
 * （4）dimension：尺寸值
 *      <attr name = "layout_width" format = "dimension" />
 *      <Button android:layout_width = "42dip"/>
 * （5） float：浮点值
 *      <attr name = "fromAlpha" format = "float" />
 *      <alpha android:fromAlpha = "1.0"/>
 * （6）integer：整型值
 *      <attr name = "framesCount" format="integer" />
 *      <animated-rotate android:framesCount = "12"/>
 * （7）string：字符串
 *      <attr name = "text" format = "string" />
 *      <TextView android:text = "我是文本"/>
 * （8）fraction：百分数
 *      <attr name = "pivotX" format = "fraction" />
 *      <rotate android:pivotX = "200%"/>
 * （9） enum：枚举值
 *       <attr name="orientation">
 *       <enum name="horizontal" value="0" />
 *       <enum name="vertical" value="1" />
 *       </attr>
 *       <LinearLayout android:orientation = "vertical">
 *  (10) flag：位或运算
 *  <declare-styleable name="名称">
 *      <attr name="gravity">
 *          <flag name="top" value="0x30" />
 *          <flag name="bottom" value="0x50" />
 *          <flag name="left" value="0x03" />
 *          <flag name="right" value="0x05" />
 *          <flag name="center_vertical" value="0x10" />
 *       </attr>
 *  </declare-styleable>
 *  <TextView android:gravity="bottom|left"/>
 *  （11）混合类型：属性定义时可以指定多种类型值
 *  <attr name = "background" format = "reference|color" />
 *  <ImageView android:background = "@drawable/图片ID" />
 *  <ImageView android:background = "#00FF00" />
 * --------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------
 *
 *

        *
        *
 *
 * Created by beixinyuan_android on 2018/3/30.
 */

public class InvitationCodeView extends View {

    private static final String TAG = InvitationCodeView.class.getSimpleName();

    //矩形
    private RectF rect = null;
    //顶部标题panit
    private Paint topTitleTextPaint;
    private TextPaint topContentTextPaint;
    private StaticLayout topContent_textLayout;
    //底部标题panit
    private Paint bootomTitlePaint;
    //底部内容panit
    private Paint bootomContentTextPaint;
    private int TITLE_TEXT_SIZE = 80;
    private int CONTENT_TEXT_SIZE = 40;
    private int BOOTOM_TEXT_SIZE = 50;
    //文字和横线之间的距离
    private final int TEXTOFFSET = 20;
    //顶部标题
    private String TOP_TITLE = "";
    //底部文字
    private String BOTTOM_TITLE = "";
    //上面文字内容
    private String TOP_CONTENT_TEXT = "";
    //下面的文字内容
    private String BOTTOM_CONTENT_TEXT = "";

    //画布宽度
    private int CANVAS_WIDTH;
    //画布高度
    private int CANVAS_HEIGHT;
    //文字和边的距离
    private int TEXTMARGIN = 60;

    private Bitmap qrBitmap;

    private Paint.FontMetrics topTitleFont;
    private Paint.FontMetrics bottomContentFont;
    private Paint.FontMetrics bottomTitleFont;

    //四个边角对应的宽度
    private final int CORNER_WIDTH = 15;

    //正文和正文，正文和图片之间的间距
    private final int CONTENT_MARIN = 40;

    public InvitationCodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initTexts(context, attrs);
        initData();
    }

    public InvitationCodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTexts(context, attrs);
        initData();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InvitationCodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initTexts(context, attrs);
        initData();
    }

    /**
     * 初始化文本
     * @param context
     * @param attrs
     */
    private void initTexts(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.InvitationCodeView);
        TOP_TITLE = typedArray.getString(R.styleable.InvitationCodeView_topTitleString);
        TOP_CONTENT_TEXT = typedArray.getString(R.styleable.InvitationCodeView_topContentString);
        BOTTOM_CONTENT_TEXT = typedArray.getString(R.styleable.InvitationCodeView_bottomContentString);
        BOTTOM_TITLE = typedArray.getString(R.styleable.InvitationCodeView_bottomTitleString);
    }

    /**
     * 初始化数据
     */
    private void initData(){
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        CANVAS_WIDTH =wm.getDefaultDisplay().getWidth() / 4 * 3;
        initTopTitlePaint();
        initTopContentPaint();
        initBootomContentText();
        initBootomTitle();
        if(qrBitmap == null){
            CANVAS_HEIGHT = (int) (topContent_textLayout.getHeight() + CONTENT_MARIN*3 + topTitleFont.bottom - topTitleFont.top + bottomContentFont.bottom - bottomContentFont.top + bottomTitleFont.bottom - bottomTitleFont.top);
        }else{
            CANVAS_HEIGHT = (int) (topContent_textLayout.getHeight() + CONTENT_MARIN*4 + topTitleFont.bottom - topTitleFont.top + qrBitmap.getHeight() + bottomContentFont.bottom - bottomContentFont.top + bottomTitleFont.bottom - bottomTitleFont.top);
        }
    }

    /**
     * 矩形
     * @return
     */
    private RectF getFramingRect(Canvas canvas) {

        float width = canvas.getWidth();
        float height = canvas.getHeight();
        RectF framingRect = new RectF(0, 0, width, height);
        return framingRect;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rect = getFramingRect(canvas);

        //画矩形背景
        //drawRect(canvas, rect);
        //画标题
        drawTitle(canvas, rect);
        //画上边
        drawTopEdge(canvas, rect);
        //画上部分文字内容
        drawTopContentText(canvas, rect);
        //画二维码
        drawQrBitmap(canvas, rect);
        //画底部文本
        drawBootomContentText(canvas, rect);
        //画底部标题
        drawBootomTitle(canvas, rect);
        //画下边
        drawBottomEdge(canvas, rect);
        //画左右两条线
        drawLeftAndRightEdge(canvas, rect);
        //postInvalidateDelayed(ANIMATION_DELAY, frame.left, rect.top, rect.right, rect.bottom);
    }

    public void setQrBitmap(InputStream is){
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        // 获得图片的宽高.
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        // 计算缩放比例.
        float scaleWidth = CANVAS_WIDTH/ 2.0f / width;

        // 取得想要缩放的matrix参数.
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleWidth);
        // 得到新的图片.
        Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        qrBitmap = newbm;
        initData();
        invalidate();
    }

    private void drawQrBitmap(Canvas canvas, RectF rect){
        if(qrBitmap != null){
            canvas.drawBitmap(qrBitmap, rect.centerX() - qrBitmap.getWidth()/2, topContent_textLayout.getHeight() + CONTENT_MARIN*2 + topTitleFont.bottom - topTitleFont.top, new Paint());
        }
    }

    private void initTopTitlePaint(){
        topTitleTextPaint = new Paint();
        topTitleTextPaint.setColor(Color.WHITE);
        topTitleTextPaint.setTextSize(TITLE_TEXT_SIZE);
        topTitleTextPaint.setStyle(Paint.Style.FILL);
        topTitleTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        //该方法即为设置基线上那个点到底是left,center,还是right  这里我设置为center
        topTitleTextPaint.setTextAlign(Paint.Align.CENTER);
        topTitleFont = topTitleTextPaint.getFontMetrics();
    }

    /**
     * 绘画标题
     * @param canvas
     * @param rect
     */
    private void drawTitle(Canvas canvas, RectF rect) {

        Paint.FontMetrics fontMetrics = topTitleTextPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
        int baseLineY = (int) (rect.top - top);//基线中间点的y轴计算公式
        canvas.drawText(TOP_TITLE,rect.centerX(),baseLineY,topTitleTextPaint);
    }

    private void initBootomContentText(){
        bootomContentTextPaint = new Paint();
        bootomContentTextPaint.setColor(Color.WHITE);
        bootomContentTextPaint.setTextSize(CONTENT_TEXT_SIZE);
        bootomContentTextPaint.setStyle(Paint.Style.FILL);
        bootomContentTextPaint.setTypeface(Typeface.DEFAULT);
        //该方法即为设置基线上那个点到底是left,center,还是right  这里我设置为center
        bootomContentTextPaint.setTextAlign(Paint.Align.CENTER);

        bottomContentFont = bootomContentTextPaint.getFontMetrics();
    }

    /**
     * 画底部文本内容
     * @param canvas
     * @param rect
     */
    private void drawBootomContentText(Canvas canvas, RectF rect) {
        int baseLineY;
        if(qrBitmap == null){
            baseLineY = (int) (topContent_textLayout.getHeight() + CONTENT_MARIN*3 + topTitleFont.bottom - topTitleFont.top);//基线中间点的y轴计算公式
        }else{
            baseLineY = (int) (topContent_textLayout.getHeight() + CONTENT_MARIN*4 + topTitleFont.bottom - topTitleFont.top + qrBitmap.getHeight());//基线中间点的y轴计算公式
        }
        canvas.drawText(BOTTOM_CONTENT_TEXT,rect.centerX(),baseLineY,bootomContentTextPaint);
    }


    private void initBootomTitle(){
        bootomTitlePaint = new Paint();
        bootomTitlePaint.setColor(Color.RED);
        bootomTitlePaint.setTextSize(BOOTOM_TEXT_SIZE);
        bootomTitlePaint.setStyle(Paint.Style.FILL);
        bootomTitlePaint.setTypeface(Typeface.DEFAULT_BOLD);
        //该方法即为设置基线上那个点到底是left,center,还是right  这里我设置为center
        bootomTitlePaint.setTextAlign(Paint.Align.CENTER);

        bottomTitleFont = bootomTitlePaint.getFontMetrics();
    }

    /**
     * 画底部标题
     * @param canvas
     * @param rect
     */
    private void drawBootomTitle(Canvas canvas, RectF rect) {

        float top = bottomTitleFont.top;
        float bottom = bottomTitleFont.bottom;
        int baseLineY;
        if(qrBitmap == null){
            baseLineY = (int) (topContent_textLayout.getHeight() + CONTENT_MARIN*3 + topTitleFont.bottom - topTitleFont.top + bottomContentFont.bottom - bottomContentFont.top - top);
        }else{
            baseLineY = (int) (topContent_textLayout.getHeight() + CONTENT_MARIN*4 + topTitleFont.bottom - topTitleFont.top + qrBitmap.getHeight() + bottomContentFont.bottom - bottomContentFont.top - top);
        }
        canvas.drawText(BOTTOM_TITLE,rect.centerX(),baseLineY,bootomTitlePaint);
    }

    /**
     * 绘画上边
     *
     * @param canvas
     * @param frame
     */
    private void drawTopEdge(Canvas canvas, RectF frame) {
        Paint paint = new Paint();
        //标题文字长度
        float titleWidth = topTitleTextPaint.measureText(TOP_TITLE);
        Paint.FontMetrics fontMetrics = topTitleTextPaint.getFontMetrics();
        float top = fontMetrics.top;
        float bottom = fontMetrics.bottom;
        //底部文字长度
//        float bootomTextWidth = bootomTitlePaint.measureText(BOTTOM_TITLE);
        // 画扫描框边上的角，总共8个部分
        paint.setColor(Color.WHITE);
        // 左上横线
        canvas.drawRect(frame.left, frame.top - top/2 + bottom/2 , frame.centerX() - titleWidth / 2 - TEXTOFFSET, frame.top - top/2 + bottom/2 + CORNER_WIDTH, paint);
        // 左竖线
//        canvas.drawRect(frame.left, frame.top, frame.left + CORNER_WIDTH, frame.bottom, paint);
        // 右上横线
        canvas.drawRect(frame.centerX() + titleWidth / 2 + TEXTOFFSET, frame.top - top/2 + bottom/2, frame.right, frame.top - top/2 + bottom/2 + CORNER_WIDTH, paint);
        // 右竖线
//        canvas.drawRect(frame.right - CORNER_WIDTH, frame.top, frame.right, frame.bottom, paint);
        // 左下横线
//        canvas.drawRect(frame.left, frame.bottom - CORNER_WIDTH, frame.centerX() - bootomTextWidth / 2 - TEXTOFFSET, frame.bottom, paint);
        // 右下下
//        canvas.drawRect(frame.centerX() + bootomTextWidth / 2 + TEXTOFFSET, frame.bottom - CORNER_WIDTH, frame.right, frame.bottom, paint);
    }

    /**
     * 画下边
     * @param canvas
     * @param frame
     */
    private void drawBottomEdge(Canvas canvas, RectF frame){
        Paint paint = new Paint();
        //标题文字长度
        float titleWidth = bootomTitlePaint.measureText(BOTTOM_TITLE);
        Paint.FontMetrics fontMetrics = bootomTitlePaint.getFontMetrics();
        float top = fontMetrics.top;
        float bottom = fontMetrics.bottom;
        paint.setColor(Color.WHITE);
        canvas.drawRect(frame.left, frame.bottom + top/2 - bottom/2 , frame.centerX() - titleWidth / 2 - TEXTOFFSET, frame.bottom + top/2 - bottom/2 + CORNER_WIDTH, paint);
        canvas.drawRect(frame.centerX() + titleWidth / 2 + TEXTOFFSET, frame.bottom + top/2 - bottom/2, frame.right, frame.bottom + top/2 - bottom/2 + CORNER_WIDTH, paint);
    }

    private void drawLeftAndRightEdge(Canvas canvas, RectF frame){
        Paint paint = new Paint();
        float top_titleWidth = topTitleTextPaint.measureText(TOP_TITLE);
        Paint.FontMetrics top_fontMetrics = topTitleTextPaint.getFontMetrics();
        float top_top = top_fontMetrics.top;
        float top_bottom = top_fontMetrics.bottom;
        paint.setColor(Color.WHITE);

        float bottom_titleWidth = bootomTitlePaint.measureText(BOTTOM_TITLE);
        Paint.FontMetrics bottom_fontMetrics = bootomTitlePaint.getFontMetrics();
        float bottom_top = bottom_fontMetrics.top;
        float bottom_bottom = bottom_fontMetrics.bottom;
        paint.setColor(Color.WHITE);

        paint.setColor(Color.WHITE);
        canvas.drawRect(frame.left, frame.top - top_top/2 + top_bottom/2, frame.left + CORNER_WIDTH, frame.bottom + bottom_top/2 - bottom_bottom/2 + CORNER_WIDTH, paint);
        canvas.drawRect(frame.right - CORNER_WIDTH, frame.top - top_top/2 + top_bottom/2, frame.right, frame.bottom + bottom_top/2 - bottom_bottom/2 + CORNER_WIDTH, paint);
    }

    private void initTopContentPaint(){
        topContentTextPaint = new TextPaint();
        topContentTextPaint.setColor(Color.WHITE);
        topContentTextPaint.setTextSize(CONTENT_TEXT_SIZE);
        topContentTextPaint.setStyle(Paint.Style.FILL);
        topContentTextPaint.setTypeface(Typeface.DEFAULT);
        //该方法即为设置基线上那个点到底是left,center,还是right  这里我设置为center
        topContentTextPaint.setTextAlign(Paint.Align.CENTER);
        topContentTextPaint.setAntiAlias(true);

        topContent_textLayout = new StaticLayout(TOP_CONTENT_TEXT, topContentTextPaint, (int) (CANVAS_WIDTH - TEXTMARGIN), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }

    /**
     * 画上部分文字内容
     */
    private void drawTopContentText(Canvas canvas, RectF rect){
        canvas.save();
        canvas.translate(rect.centerX(),topTitleFont.bottom-topTitleFont.top + CONTENT_MARIN);
        topContent_textLayout.draw(canvas);
        canvas.restore();//别忘了restore
        //canvas.drawText(TOP_CONTENT_TEXT,rect.centerX(),baseLineY,topContentTextPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(TAG, "onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 获取宽-测量规则的模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        // 获取高-测量规则的模式和大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        // 设置wrap_content的默认宽 / 高值
        // 默认宽/高的设定并无固定依据,根据需要灵活设置
        // 类似TextView,ImageView等针对wrap_content均在onMeasure()对设置默认宽 / 高值有特殊处理,具体读者可以自行查看

        // 当布局参数设置为wrap_content时，设置默认值
        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(CANVAS_WIDTH, CANVAS_HEIGHT);
            // 宽 / 高任意一个布局参数为= wrap_content时，都设置默认值
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(CANVAS_WIDTH, heightSize);
        } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, CANVAS_HEIGHT);
        }
    }


}
