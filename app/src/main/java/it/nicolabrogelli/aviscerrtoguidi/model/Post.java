package it.nicolabrogelli.aviscerrtoguidi.model;

import android.graphics.Bitmap;
import android.text.Spanned;

/**
 * Created by Nicola on 17/06/2014.
 */
public class Post {

    // Post
    private int _ID;
    private String _TYPE;
    private String _SLUG;
    private String _URL;
    private String _STATUS;
    private String _TITLE;
    private String _TITLE_PLAIN;
    private String _CONTENT;
    private String _EXCERPT;
    private String _POST_DATE;


    // Categories
    private int _CATEGORIES_ID;
    private String _CATEGORIES_SLUG;
    private String _CATEGORIES_TITLE;
    private String _CATEGORIES_DESCRIPTION;
    private int _CATEGORIES_PARENT;
    private int _CATEGORIES_POST_COUNT;


    private String _TAGS;


    // Author
    private int _AUTHOR_ID;
    private String _AUTHOR_SLUG;
    private String _AUTHOR_NAME;
    private String _AUTHOR_FIRST_NAME;
    private String _AUTHOR_LAST_NAME;
    private String _AUTHOR_NICK_NAME;
    private String _AUTHOR_URL;
    private String _AUTHOR_DESCRIPTION;


    private String _COMMENTS;

    // Attachments
    private int _ATTACHMENTS_ID;
    private String _ATTACHMENTS_URL;
    private String _ATTACHMENTS_SLUG;
    private String _ATTACHMENTS_TITLE;
    private String _ATTACHMENTS_DESCRIPTION;
    private String _ATTACHMENTS_CAPTION;
    private int _ATTACHMENTS_PARENT;
    private String _ATTACHMENTS_MIME_TYPE;
    private String _ATTACHMENTS_IMAGES;


    private String _PROFILE_IMAGE_URL;
    private Bitmap _IMAGE_POST;



    // Metodi setter

    public void set_ID(int id){
        this._ID = id;
    }

    public  void set_TYPE(String type) {
        this._TYPE = type;
    }

    public void set_SLUG(String slug) {
        this._SLUG = slug;
    }

    public void set_URL(String url) {
        this._URL = url;
    }

    public void set_STATUS(String status) {
        this._STATUS = status;
    }

    public void set_TITLE(String title) {
        this._TITLE = title;
    }

    public void set_TITLE_PLAIN(String title_plain) {
        this._TITLE_PLAIN = title_plain;
    }

    public void set_CONTENT(String content) {
        this._CONTENT = content;
    }

    public void set_EXCERPT(String excerpt) {
        this._EXCERPT = excerpt;
    }

    public void set_POST_DATE(String data) { this._POST_DATE = data; }

    public void set_CATEGORIES_ID(int categories_id) {
        this._CATEGORIES_ID = categories_id;
    }

    public void set_CATEGORIES_SLUG(String categories_slug) {
        this._CATEGORIES_SLUG = categories_slug;
    }

    public void set_CATEGORIES_TITLE(String categories_title) {
        this._CATEGORIES_TITLE = categories_title;
    }

    public void set_CATEGORIES_DESCRIPTION(String categories_description) {
        this._CATEGORIES_DESCRIPTION = categories_description;
    }

    public void set_CATEGORIES_PARENT(int categories_parent) {
        this._CATEGORIES_PARENT = categories_parent;
    }

    public void set_CATEGORIES_POST_COUNT(int categories_post_count) {
        this._CATEGORIES_POST_COUNT = categories_post_count;
    }

    public void set_TAGS(String tags) {
        this._TAGS = tags;
    }

    public void set_AUTHOR_ID(int id) {
        this._AUTHOR_ID = id;
    }

    public void set_AUTHOR_SLUG(String slug) {
        this._AUTHOR_SLUG = slug;
    }

    public void set_AUTHOR_NAME(String name) {
        this._AUTHOR_NAME = name;
    }

    public void set_AUTHOR_FIRST_NAME(String first_name) {
        this._AUTHOR_FIRST_NAME = first_name;
    }

    public void set_AUTHOR_LAST_NAME(String last_name) {
        this._AUTHOR_LAST_NAME = last_name;
    }

    public void set_AUTHOR_NICK_NAME(String nick_name) {
        this._AUTHOR_NICK_NAME = nick_name;
    }

    public void set_AUTHOR_URL(String url) {
        this._AUTHOR_URL = url;
    }

    public void set_AUTHOR_DESCRIPTION(String description) {
        this._AUTHOR_DESCRIPTION = description;
    }

    public void set_COMMENTS(String comments) {
        this._COMMENTS = comments;
    }

    public void set_ATTACHMENTS_ID(int id) {
        this._ATTACHMENTS_ID = id;
    }

    public void set_ATTACHMENTS_URL(String url) {
        this._ATTACHMENTS_URL = url;
    }

    public void set_ATTACHMENTS_SLUG(String slug) {
        this._ATTACHMENTS_SLUG = slug;
    }

    public void set_ATTACHMENTS_TITLE(String title) {
        this._ATTACHMENTS_TITLE = title;
    }

    public void set_ATTACHMENTS_DESCRIPTION(String description) {
        this._ATTACHMENTS_DESCRIPTION = description;
    }

    public void set_ATTACHMENTS_CAPTION(String caption) {
        this._ATTACHMENTS_CAPTION = caption;
    }

    public void set_ATTACHMENTS_PARENT(int parent) {
        this._ATTACHMENTS_PARENT = parent;
    }

    public void set_ATTACHMENTS_MIME_TYPE(String mime_type) {
        this._ATTACHMENTS_MIME_TYPE = mime_type;
    }

    public void set_ATTACHMENTS_IMAGES(String images) {
        this._ATTACHMENTS_IMAGES = images;
    }

    public void set_IMAGE_POST(Bitmap bitmap) {
        this._IMAGE_POST = bitmap;
    }



    // Metodi getter

    public int get_ID() {
        return this._ID;
    }

    public String get_TYPE() {
        return this._TYPE;
    }

    public String get_SLUG() {
        return this._SLUG;
    }

    public String get_URL() {
        return  this._URL;
    }

    public String get_STATUS() {
        return this._STATUS;
    }

    public String get_TITLE() {
        return this._TITLE;
    }

    public String get_TITLE_PLAIN() {
        return this._TITLE_PLAIN;
    }

    public String get_CONTENT() {
        return this._CONTENT;
    }

    public String get_EXCERPT() {
        return this._EXCERPT;
    }

    public String get_POST_DATE() { return  this._POST_DATE; }

    private int get_CATEGORIES_ID() {
        return this._CATEGORIES_ID;
    }

    private String get_CATEGORIES_SLUG() {
        return this._CATEGORIES_SLUG;
    }

    private String get_CATEGORIES_TITLE() {
        return this._CATEGORIES_TITLE;
    }

    private String get_CATEGORIES_DESCRIPTION() {
        return this._CATEGORIES_DESCRIPTION;
    }

    private int get_CATEGORIES_PARENT() {
        return this._CATEGORIES_PARENT;
    }

    private int get_CATEGORIES_POST_COUNT() {
        return this._CATEGORIES_POST_COUNT;
    }

    public String get_TAGS() {
        return this._TAGS;
    }

    public int get_AUTHOR_ID() {
        return this._AUTHOR_ID;
    }

    public String get_AUTHOR_SLUG() {
        return this._AUTHOR_SLUG;
    }

    public String get_AUTHOR_NAME() {
        return this._AUTHOR_NAME;
    }

    public String get_AUTHOR_FIRST_NAME() {
        return this._AUTHOR_FIRST_NAME;
    }

    public String get_AUTHOR_LAST_NAME() {
        return this._AUTHOR_LAST_NAME;
    }

    public String get_AUTHOR_NICK_NAME() {
        return this._AUTHOR_NICK_NAME;
    }

    public String get_AUTHOR_URL() {
        return this._AUTHOR_URL;
    }

    public String get_AUTHOR_DESCRIPTION() {
        return this._AUTHOR_DESCRIPTION;
    }

    public String get_COMMENTS() {
        return this._COMMENTS;
    }

    public int get_ATTACHMENTS_ID() {
        return this._ATTACHMENTS_ID;
    }

    public String get_ATTACHMENTS_URL() {
        return this._ATTACHMENTS_URL;
    }

    public String get_ATTACHMENTS_SLUG() {
        return this._ATTACHMENTS_SLUG;
    }

    public String get_ATTACHMENTS_TITLE() {
        return this._ATTACHMENTS_TITLE;
    }

    public String get_ATTACHMENTS_DESCRIPTION() {
        return this._ATTACHMENTS_DESCRIPTION;
    }

    public String get_ATTACHMENTS_CAPTION() {
        return this._ATTACHMENTS_CAPTION;
    }

    public int get_ATTACHMENTS_PARENT() {
        return this._ATTACHMENTS_PARENT;
    }

    public String get_ATTACHMENTS_MIME_TYPE() {
        return  this._ATTACHMENTS_MIME_TYPE;
    }

    public String get_ATTACHMENTS_IMAGES() {
        return this._ATTACHMENTS_IMAGES;
    }


    public Bitmap get_IMAGE_POST() {
        return this._IMAGE_POST;
    }



    public String get_ProfileImageUrl()
    {
        return this._PROFILE_IMAGE_URL;
    }

    public void set_ProfileImageUrl(String profileImageUrl)
    {
        this._PROFILE_IMAGE_URL = profileImageUrl;
    }

}
