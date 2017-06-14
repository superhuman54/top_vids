package kimkihwan.navercorp.com.top100.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static kimkihwan.navercorp.com.top100.utils.ImageFetcher.ImageType.NMP_270;
import static kimkihwan.navercorp.com.top100.utils.ImageFetcher.ImageType.NMP_480;
import static kimkihwan.navercorp.com.top100.utils.ImageFetcher.ImageType.NMP_720;

/**
 * 이미지를 캐쉬 혹은 네트워크에서 불러온다.
 */

public class ImageFetcher {

    private final static String IMAGE_PARAMS = "?type=";

    public static void display(ImageView view, ImageDefinition def, String url) {
        ImageType type = getType(view.getContext().getApplicationContext(), def);
        String urlQuery = buildParams(url, type);

        Glide.with(view.getContext())
                .load(urlQuery)
                .override(type.width, type.height)
                .into(view);

    }

    private static ImageType getType(Context context, ImageDefinition definition) {
        ImageType type = null;
        if (definition.getType() != null) {
            type = definition.getType();
        } else {
            Display dis = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

            Point point = new Point();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                dis.getSize(point);
            } else {
                point.x = dis.getWidth();
                point.y = dis.getHeight();
            }

            type = definition.measure(point);
        }
        return type;
    }

    private static String buildParams(String url, ImageType type) {
        StringBuilder sb = new StringBuilder(url);
        if (type != null) {
            sb.append(IMAGE_PARAMS)
                    .append(type.name);
        }
        return sb.toString();
    }

    public enum ImageDefinition {

        FULL {
            @Override
            protected void adjust(Point point) {
                // ignored
            }
        },
        HALF {
            @Override
            protected void adjust(Point point) {
                point.x /= 2.0;
            }
        },
        QUATRE {
            @Override
            protected void adjust(Point point) {
                point.x /= 4.0;
            }
        };

        public ImageType type;

        protected abstract void adjust(Point point);

        protected ImageType measure(Point point) {
            ImageType type = null;
            adjust(point);
            int width = point.x;
            if (width >= NMP_720.minDisplayWidth) {
                type = NMP_720;
            } else if (width >= NMP_480.minDisplayWidth) {
                type = NMP_480;
            } else {
                type = NMP_270;
            }
            this.type = type;
            return type;
        }

        public ImageType getType() {
            return this.type;
        }
    }

    public enum ImageType {

        NMP_720("nmp720", 720, 405, 650, 90),
        NMP_480("nmp480", 480, 270, 400, 90),
        NMP_270("nmp270", 270, 152, 200, 90);

        private static final int LARGE_IMAGE_CRITERIA = 480;

        public final boolean isLargeImage;
        public final int width;
        public final int height;
        public final int quality;
        public final String name;
        public final double rate;
        public final int minDisplayWidth;

        ImageType(String name, int width, int height, int minDisplayWidth, int quality) {
            this.name = name;
            this.isLargeImage = Math.max(width, height) >= LARGE_IMAGE_CRITERIA;
            this.width = width;
            this.height = height;
            this.quality = quality;
            this.minDisplayWidth = minDisplayWidth;
            this.rate = (double) width / (double) height;
        }
    }
}
