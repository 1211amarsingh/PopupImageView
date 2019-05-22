# PopupImageView : Popup Image Dialog just by one click
Image View in dialog like whatspp... single image and multiple image view.
just have to pass string type array / stirng 

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
Version 1.1.0, which helps you to add library in sdk version 16.
[![](https://jitpack.io/v/1211amarsingh/PopupImageView.svg)](https://jitpack.io/#1211amarsingh/PopupImageView)
