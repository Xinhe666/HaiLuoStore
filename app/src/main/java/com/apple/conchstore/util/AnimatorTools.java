package com.apple.conchstore.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by android on 2016/7/22.
 */
public class AnimatorTools {

    /**
     * 移动动画
     * @param view
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @param animationListener
     * @param duration
     */
    public static void startTranslationAnimator(final View view, float fromX, float fromY, float toX,
                                                 float toY, int duration, Animator.AnimatorListener animationListener) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view, "translationX", fromX, toX);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view, "translationY", fromY, toY);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animatorX).with(animatorY);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(duration);
        if(animationListener != null){
            animatorSet.addListener(animationListener);
        }
        animatorSet.start();
    }

    public static void startTranslationAndRotationAnimator(final View view, float fromX, float fromY, float toX,
                                                float toY, int duration, Animator.AnimatorListener animationListener) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view, "translationX", fromX, toX);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view, "translationY", fromY, toY);
        ObjectAnimator animatorRotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animatorX).with(animatorY).with(animatorRotate);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(duration);
        if(animationListener != null){
            animatorSet.addListener(animationListener);
        }
        animatorSet.start();
    }
}
