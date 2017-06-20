package kimkihwan.navercorp.com.top100.utils;

import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by jamie on 2017. 6. 19..
 */

public class VodEndIntentUtil {

    public static Uri getVodEndUri(long clipNo, long playlistNo, int index) {
        return getVodEndUri(clipNo, playlistNo, null, null, index, null);
    }

    public static Uri getVodEndUri(long clipNo, long playlistNo) {
        return getVodEndUri(clipNo, playlistNo, null, null, -2, null);
    }

    public static Uri getVodEndUri(long clipNo, long playlistNo, String videoId) {
        return getVodEndUri(clipNo, playlistNo, videoId, null, -2, null);
    }

    public static Uri getVodEndUri(long clipNo, long playlistNo, String videoId,
                                   String qualityId, int index, String serviceId) {
        StringBuilder sb = new StringBuilder();
        sb.append("naverplayer://vod_play?minAppVersion=1600&schemeVersion=2");
        sb.append("&clipNo=" + clipNo);

        if (serviceId == null) {
            serviceId = "2010";
        }
        sb.append("&serviceId=" + serviceId);

        if (playlistNo > 0) {
            sb.append("&playlistNo=" + playlistNo);
        }

        sb.append("&repeatState=");
        sb.append("one");

        if (TextUtils.isEmpty(videoId) == false) {
            sb.append("&videoId=");
            sb.append(videoId);
        }

        if (TextUtils.isEmpty(qualityId) == false) {
            sb.append("&qualityId=");
            sb.append(qualityId);
        }
        if (index > -2) {
            // 중복 방지용으로 사용됨.
            sb.append("&index=");
            sb.append(index);
        }
        return Uri.parse(sb.toString());
    }
}
