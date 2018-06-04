package com.example.gaope.imageviewandtextview;

/**
 * 返回图文混排的文字和图片的数据
 * Created by gaope on 2018/6/4.
 */

public class Data {


    /**
     * 文本，含有TAG_TEXT，则说明为文字
     */
    public static String TAG_TEXT = "[TEXT]";

    /**
     * 网络图片地址，含有TAG_URL_IMAGE，则说明为网络图片
     */
    public static String TAG_URL_IMAGE = "[URL_IMAGE]";

    /**
     * 本地图片，含有TAG_DRAWABLE_IMAGE，则说明为本地图片
     */
    public static String TAG_DRAWABLE_IMAGE = "[DRAWABLE_IMAGE]";

    /**
     * 分隔，通过TAG_SPACE来区分数据，分开图片与文字
     */
    public static String TAG_SPACE = "\\[SPACE\\]";

    public static String getData(){
        int resId = R.drawable.aa;
        String res = String .valueOf(resId);
        String data =
                "[TEXT]有山有水，有人家，一江清水养育一方人，有江河的地方才有是美景天堂。"
                + "[SPACE]"
                + "[URL_IMAGE]https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=972617049,2959623161&fm=27&gp=0.jpg"
                + "[SPACE]"
                + "[TEXT]丽江古城在南宋时期就初具规模，已有 八、九百年的历史。自明朝时，丽江古城称“大研厢”，因其居丽江坝中心，四面青山环绕，一 片碧野之间绿水萦回，形似一块碧玉大砚，故而得名。丽江古城在2014年遭遇火灾，但丝毫不影响那儿的特色，更是有着艳遇之都的美誉。"
                + "[SPACE]"
                + "[DRAWABLE_IMAGE]" + res
                + "[SPACE]"
                + "[TEXT]“桂林山水甲天下，阳朔堪称甲桂林”，高度概括了阳朔的自然风光在世界上所占有的重要位置。";
        return data;
    }
}
