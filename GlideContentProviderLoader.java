import android.content.Context;
import android.net.Uri;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

import java.io.InputStream;

/**
 *
 * Created by ahmed-basyouni on 4/22/17.
 */

public class GlideContentProviderLoader implements StreamModelLoader<Uri> {

    private final Context mContext;

    public GlideContentProviderLoader(Context context) {
        this.mContext = context;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(Uri uri, int width, int height) {
        return new ProviderDataFetcher(uri, mContext);
    }

    private static class ProviderDataFetcher implements DataFetcher<InputStream> {

        private final Uri imageUri;
        private final Context mContext;
        private boolean cancelled;

        ProviderDataFetcher(Uri uri, Context context){
            this.imageUri = uri;
            this.mContext = context;
        }

        @Override
        public InputStream loadData(Priority priority) throws Exception {
            InputStream stream = null;
            if(imageUri!=null && !cancelled)
                stream = mContext.getContentResolver().openInputStream(imageUri);
            return stream;
        }

        @Override
        public void cleanup() {

        }

        @Override
        public String getId() {
            return imageUri.toString();
        }

        @Override
        public void cancel() {
            cancelled = true;
        }
    }
}
