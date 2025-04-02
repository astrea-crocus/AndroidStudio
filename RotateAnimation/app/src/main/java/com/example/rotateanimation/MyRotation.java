package com.example.rotateanimation;

import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MyRotation extends RotateAnimation {
    public MyRotation(float fromDegrees, float toDegrees,
                      int pivotXType, float pivotXValue,
                      int pivotYType, float pivotYValue,
                      ImageView image, int durationMillis) {
        //Récupération des paramètres de la classe RotateAnimation
        super(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue);

        //Personalisation
        setDuration(durationMillis);
        setInterpolator(new LinearInterpolator());
        image.startAnimation(this);
    }

    public MyRotation(float fromDegrees, float toDegrees,
                      float pivotXValue, float pivotYValue,
                      ImageView image, int durationMillis){
        //Récupération des paramètres de la classe RotateAnimation
        super(fromDegrees, toDegrees, RELATIVE_TO_SELF, pivotXValue, RELATIVE_TO_SELF, pivotYValue);

        //Personalisation
        setDuration(durationMillis);
        setInterpolator(new LinearInterpolator());
        image.startAnimation(this);
    }
}
