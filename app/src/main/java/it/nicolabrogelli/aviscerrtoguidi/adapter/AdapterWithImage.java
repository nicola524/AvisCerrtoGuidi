package it.nicolabrogelli.aviscerrtoguidi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import it.nicolabrogelli.aviscerrtoguidi.model.Post;
import it.nicolabrogelli.aviscerrtoguidi.R;


public final class AdapterWithImage extends ArrayAdapter<Post>
{

    Context context;
    final String mimeType = "text/html";
    final String encoding = "utf-8";

    public AdapterWithImage(Context context)
	{
		super(context, R.layout.row, R.id.title);
        this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

        Post t = getItem(position);
        ViewHolder viewHolder = null;

        if( convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, null);
            viewHolder = new ViewHolder();
            viewHolder.Titolo = (TextView) convertView.findViewById(R.id.title);
            viewHolder.Immagine = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.Riassunto = (TextView) convertView.findViewById(R.id.riassunto);

        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();

        }


        viewHolder.Titolo.setText(t.get_TITLE());
        String noHtml = android.text.Html.fromHtml(t.get_EXCERPT()).toString();
        viewHolder.Riassunto.setText(noHtml);

        Picasso.with(context)
                .load(t.get_ProfileImageUrl())
                .fit()
                .centerCrop()
                .into(viewHolder.Immagine);

        convertView.setTag(viewHolder);

        return convertView;
    }

    private static class  ViewHolder {
        public TextView Titolo;
        public ImageView Immagine;
        public TextView Riassunto;
    }

}