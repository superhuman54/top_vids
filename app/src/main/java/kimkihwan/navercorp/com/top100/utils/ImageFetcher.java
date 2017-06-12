package kimkihwan.navercorp.com.top100.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 *  이미지를 캐쉬 혹은 네트워크에서 불러온다.
 */

public class ImageFetcher {

    public static void display(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .into(view);
    }
}
