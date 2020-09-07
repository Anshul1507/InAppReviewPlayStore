package tech.anshul1507.inappreviewplaystore

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory

object ReviewHelper {
    lateinit var manager: ReviewManager
    var reviewInfo: ReviewInfo? = null

    /**
    * Call this method in Home page screen or start screen of your app
    * to initialize this setup
    * */
    fun initialize(ctx: Context) {
        manager = ReviewManagerFactory.create(ctx)
        manager.requestReviewFlow().addOnCompleteListener { request ->
            if (request.isSuccessful) {
                reviewInfo = request.result
            } else {
                logger("Problem in receiving object")
            }
        }
    }
    /**
     * Call this method in that activity where you want to show your dialog
     * */
    fun askForReview(activity: Activity) {
        reviewInfo?.let {
            manager.launchReviewFlow(activity, it)
                .addOnCompleteListener { task ->
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown. Thus, no
                    // matter the result, we continue our app flow.
                    logger("addOnCompleteListener ${task.result}")
                }
        }
    }

    private fun logger(msg: String) = Log.d("test->", "Review: $msg")

}