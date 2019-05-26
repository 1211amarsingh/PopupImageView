# PopupImageView : Popup Image Dialog just by one click
Image View in dialog like whatspp... single image and multiple image view.
just have to pass string type array / stirng<br>
With this library enables you to display photos in popup view. 
Highly recommended for view multiple image in a view using url or local storage.

<b>▷ Key Features:</b>

✔ works with any version of app and display<br>
✔ supports any image format load  (jpg, jpeg, png, webp, gif ) from url or local storage<br>
✔ zoom by gesture<br>
✔ swipe to change image<br>
✔ move image by drag<br>
✔ selected a desired position of image<br>
✔ close the image by pressing x button<br>
✔ cache data to quickly reopen images you've seen recently<br>

## Usage

*  Use with single image url:->    
    ```new PopupImageView(context, view, "imageurl");```<br><br>
    
*  Use with multiple image url:->    
    ```new PopupImageView(context, view, array_image);```<br><br>
    
*  Use with multiple image url and selected item:->    
    ```new PopupImageView(context, view, array_image, position);```<br><br>
    
*  Use with multiple image url with base url and selected item:->    
    ```new PopupImageView(context, view, array_image, position, baseUrl);```
    
    
## Gradle
**Step 1.** Add the JitPack repository to your build file
    Add it in your root build.gradle at the end of repositories:

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
**Step 2.** Add the dependency
    
    dependencies {
	        implementation 'com.github.1211amarsingh:PopupImageView:Tag'
	}

## Example
    ImageView imageView = findViewById(R.id.img_first);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PopupImageView(context, v, array_image);
                //new PopupImageView(context, v, ""https://placekitten.com/640/360"");
            }
        });

## Output 
![](https://github.com/1211amarsingh/PopupImageView/blob/master/sample.gif)

## Demo
Feel free to clone this project and run in your IDE to see how can be implemented :).

## Version
Latest Version : [![](https://jitpack.io/v/1211amarsingh/PopupImageView.svg)](https://jitpack.io/#1211amarsingh/PopupImageView)

<p align="center">
	<a href="https://play.google.com/store/apps/details?id=com.kv.popupimageviews1">
		<img alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" style="max-width:100%;" width="30%"/>

<b>▷ Other Apps:</b>

* Swiggy Address Pick <div><a href="https://play.google.com/store/apps/details?id=com.kv.swiggyaddresspick">Download</a></div>
* Call Recorder Free <div><a href="https://play.google.com/store/apps/details?id=com.kv.callrecorder">Download</a></div>
* Popup Image View <div><a href="https://play.google.com/store/apps/details?id=com.kv.popupimageviews1">Download</a></div>
          
<b>▷ Library:</b>

- Swiggy Address Pick <div><a href="https://github.com/1211amarsingh/swiggy">Open</a></div>
- Popup Image View <div><a href="https://github.com/1211amarsingh/PopupImageView">Open</a></div>


---------------------------------------------------------
We're always excited to hear from you! If you have any request, suggestions, feedback, questions, or concerns, please email us at:
<a href="mailto:1211AMARSINGH@GMAIL.COM" >1211AMARSINGH@GMAIL.COM</a>
