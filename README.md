# Facts
Libraries used:
 -Retrofit2,Dagger2,Butterknife,Glide

Assumptions:
 -If both 'title' and 'description' is null then omit that particular data row
 -Display error image if there is an url for the image and request fails due to some reason
 -If the image url is null then use the space to display the description
 -Use SwipeRefreshLayout for data refresh
 -Snackbar is used to display network error

TODO:
 -Improve LogUtil
 -Add test cases
