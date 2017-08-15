# GlideContentProviderLoader
a utils class that help load image from content provider using glide

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-GlideContentProviderLoader-blue.svg?style=plastic)](https://android-arsenal.com/details/1/5880)

# how to use

````
      Glide.with(this)
           .using(new GlideContentProviderLoader(this))
           .load(Uri.parse(imageUri))
           .into(expandedImageView);
````                
