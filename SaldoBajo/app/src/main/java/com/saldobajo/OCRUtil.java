package com.saldobajo;

import android.content.Context;
import android.graphics.Bitmap;
import com.googlecode.tesseract.android.TessBaseAPI;

public class OCRUtil {
    private TessBaseAPI tessBaseAPI;

    public OCRUtil(Context context) {
        tessBaseAPI = new TessBaseAPI();
        String datapath = context.getFilesDir() + "/tesseract/";
        tessBaseAPI.init(datapath, "eng");
    }

    public String extractText(Bitmap bitmap) {
        tessBaseAPI.setImage(bitmap);
        String result = tessBaseAPI.getUTF8Text();
        tessBaseAPI.end();
        return result;
    }
}
