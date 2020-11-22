//package com.example.modern_android_development.viewmodel_ex
//
//import android.graphics.Bitmap
//import android.graphics.drawable.Drawable
//import android.os.Bundle
//import androidx.annotation.DrawableRes
//import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.ScrollableColumn
//import androidx.compose.foundation.Text
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.preferredHeight
//import androidx.compose.foundation.layout.preferredSizeIn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.onCommit
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.composed
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ImageAsset
//import androidx.compose.ui.graphics.asImageAsset
//import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
//import androidx.compose.ui.graphics.nativeCanvas
//import androidx.compose.ui.platform.ContextAmbient
//import androidx.compose.ui.platform.setContent
//import androidx.compose.ui.res.loadImageResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.ui.tooling.preview.Preview
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.target.CustomTarget
//import com.bumptech.glide.request.transition.Transition
//import com.example.modern_android_development.R
//import com.squareup.picasso.Picasso
//import com.squareup.picasso.Target
//
//
//class ImageActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ScrollableColumn {
//
//                Column(modifier = Modifier.padding(16.dp)) {
//                    DisplayImagesComponent()
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun DisplayImagesComponent() {
//    TitleComponent("Load image from the resource folder")
//    LocalResourceImageComponent(R.drawable.landscape)
//
//    TitleComponent("Load image from url using Picasso")
//    NetworkImageComponentPicasso(
//        url = "https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png"
//    )
//
//    TitleComponent("Load image from url using Glide")
//    NetworkImageComponentGlide(
//        url = "https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png"
//    )
//
//    TitleComponent("Image with rounded corners")
//    ImageWithRoundedCorners(R.drawable.landscape)
//}
//@Composable
//fun LocalResourceImageComponent(@DrawableRes resId: Int) {
//    val image = loadImageResource(resId)
//    image.resource.resource?.let {
//        Image(asset = it,
//            modifier = Modifier.preferredSizeIn(maxHeight = 200.dp)
//                .fillMaxWidth())
//    }
//}
//
//@Composable
//fun ImageWithRoundedCorners(@DrawableRes resId: Int) {
//    val image = loadImageResource(resId)
//    image.resource.resource?.let {
//
//        Column(
//            modifier = Modifier.clip(RoundedCornerShape(8.dp))
//        ) {
//            Image(
//                asset = it,
//                modifier = Modifier.preferredHeight(200.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun NetworkImageComponentPicasso(
//    url: String,
//    modifier: Modifier = Modifier.fillMaxWidth().preferredSizeIn(maxHeight = 200.dp)
//) {
//    var image by remember { mutableStateOf<ImageAsset?>(null) }
//    var drawable by remember { mutableStateOf<Drawable?>(null) }
//    onCommit(url) {
//        val picasso = Picasso.get()
//        val target = object : Target {
//            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
//                drawable = placeHolderDrawable
//            }
//
//            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
//                drawable = errorDrawable
//            }
//
//            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
//                image = bitmap?.asImageAsset()
//            }
//        }
//        picasso
//            .load(url)
//            .into(target)
//
//        onDispose {
//            image = null
//            drawable = null
//            picasso.cancelRequest(target)
//        }
//    }
//
//    val theImage = image
//    val theDrawable = drawable
//    if (theImage != null) {
//
//        Column(
//            modifier = modifier,
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Image(asset = theImage)
//        }
//    } else if (theDrawable != null) {
//        Canvas(modifier = modifier) {
//            drawIntoCanvas { canvas ->
//                theDrawable.draw(canvas.nativeCanvas)
//            }
//        }
//    }
//}
//
//@Composable
//fun NetworkImageComponentGlide(
//    url: String, modifier: Modifier = Modifier.fillMaxWidth().preferredSizeIn(maxHeight = 200.dp)
//) {
//    var image by remember { mutableStateOf<ImageAsset?>(null) }
//    var drawable by remember { mutableStateOf<Drawable?>(null) }
//    val context = ContextAmbient.current
//    onCommit(url) {
//        val glide = Glide.with(context)
//        val target = object : CustomTarget<Bitmap>() {
//            override fun onLoadCleared(placeholder: Drawable?) {
//                image = null
//                drawable = placeholder
//            }
//
//            override fun onResourceReady(bitmap: Bitmap, transition: Transition<in Bitmap>?) {
//                image = bitmap.asImageAsset()
//            }
//        }
//        glide
//            .asBitmap()
//            .load(url)
//            .into(target)
//
//        onDispose {
//            image = null
//            drawable = null
//            glide.clear(target)
//        }
//    }
//
//    val theImage = image
//    val theDrawable = drawable
//    if (theImage != null) {
//        Column(
//            modifier = modifier,
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Image(asset = theImage)
//        }
//    } else if (theDrawable != null) {
//        Canvas(modifier = modifier) {
//            drawIntoCanvas { canvas ->
//                theDrawable.draw(canvas.nativeCanvas)
//            }
//        }
//    }
//}
//
//@Composable
//fun TitleComponent(title: String) {
//    Text(
//        title, style = TextStyle(
//            fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
//            fontSize = 14.sp, color = Color.Black
//        ), modifier = Modifier.padding(16.dp).fillMaxWidth()
//    )
//}
//
//fun Modifier.RoundedCornerClipModifier(size: Dp): Modifier = composed {
//    val shape = RoundedCornerShape(size)
//    clip(shape)
//}
//
//@Preview("Load image stored in local resources folder")
//@Composable
//fun LocalResourceImageComponentPreview() {
//    Column {
//        LocalResourceImageComponent(R.drawable.landscape)
//    }
//}
//
//@Preview("Load an image over the network using the Picasso library")
//@Composable
//fun NetworkImageComponentPicassoPreview() {
//    NetworkImageComponentPicasso("https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png")
//}
//
//@Preview("Load an image over the network using the Glide library")
//@Composable
//fun NetworkImageComponentGlidePreview() {
//    NetworkImageComponentGlide("https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png")
//}
//
//@Preview("Add round corners to an image")
//@Composable
//fun ImageWithRoundedCornersPreview() {
//    ImageWithRoundedCorners(R.drawable.landscape)
//}
