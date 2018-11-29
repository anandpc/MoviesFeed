package io.github.anandpc.moviesfeed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FeedDataAdapter extends RecyclerView.Adapter<FeedDataAdapter.ViewHolder>{

    private Context context;

    public FeedDataAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageMovie.setImageResource(R.drawable.demo_img);
        holder.textTitle.setText("3 Idiots");
        holder.textDesc.setText("A Private War&lt;/em&gt; tells Marie Colvin's story, which is just as vital as any conflict that she'd covered, and it does so with respect for its subject and the audience. It should not be missed.&lt;/p&gt;");

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageMovie;
        TextView textTitle,textDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            imageMovie = itemView.findViewById(R.id.imageMovie);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDesc = itemView.findViewById(R.id.textDesc);

        }
    }
}
