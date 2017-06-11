# GlideContentProviderLoader
a utils class that help load image from content provider using glide

# how to use

````
      Glide.with(this)
           .using(new GlideContentProviderLoader(this))
           .load(Uri.parse(imageUri))
           .into(expandedImageView);
````                
