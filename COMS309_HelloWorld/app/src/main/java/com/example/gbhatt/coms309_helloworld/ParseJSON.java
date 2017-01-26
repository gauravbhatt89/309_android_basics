package com.example.gbhatt.coms309_helloworld;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {
    public static String[] ids;
    public static String[] fnames;
    public static String[] lnames;
    public static final String KEY_ID = "S_NO";
    public static final String KEY_FNAME = "First_Name";
    public static final String KEY_LNAME = "Last_Name";

    private JSONArray users;
    private String json;
    public ParseJSON(String json) { this.json = json; }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONArray(json).getJSONObject(0);
            // users = jsonObject.getJSONArray(JSON_ARRAY);

            users = new JSONArray(json);
            ids = new String[users.length()];
            fnames = new String[users.length()];
            lnames = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                fnames[i] = jo.getString(KEY_FNAME);
                lnames[i] = jo.getString(KEY_LNAME);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}